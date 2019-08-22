package com.juma.vms.transport;

import com.alibaba.fastjson.JSON;
import com.giants.common.tools.Page;
import com.giants.common.tools.PageQueryCondition;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.juma.auth.common.SystemAuthKey;
import com.juma.auth.conf.domain.BusinessArea;
import com.juma.auth.conf.service.BusinessAreaService;
import com.juma.auth.employee.domain.Department;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.auth.employee.service.DepartmentService;
import com.juma.auth.user.domain.LoginUser;
import com.juma.crm.customer.domain.CustomerInfo;
import com.juma.crm.support.domain.CustomerInfoBo;
import com.juma.crm.support.domain.CustomerInfoFilters;
import com.juma.crm.support.service.CrmService;
import com.juma.scm.storage.bo.StoreInMsgBO;
import com.juma.server.vm.domain1.bo.VehicleOwnerDeptBo;
import com.juma.thirdparty.aliyun.domain.IdentificationCard;
import com.juma.thirdparty.service.IdentificationCardOcrService;
import com.juma.tsl.domain.bo.CustomerInfoBO;
import com.juma.tsl.support.service.TslCustomerInfoService;
import com.juma.vms.mq.rabbit.send.MqSendService;
import com.juma.vms.tool.service.AmsCommonService;
import com.juma.vms.tool.service.AuthCommonService;
import com.juma.vms.tool.service.MessageService;
import com.juma.vms.tool.service.ThirdpartyCommonService;
import com.juma.workflow.core.service.ProcessService;
import com.third.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Base64Utils;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * 功能 :
 * 第三方接口,可用性测试
 * @author : Bruce(刘正航) 20:32 2019-04-08
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/META-INF/spring-standalone-beans.xml"
})
public class TransportThirdDubboTest {

    /**这里需要启动manage,通过断点方式获取json字符串,在这里使用**/
    private static final LoginEmployee loginEmployee = new Gson().fromJson(
            "{\"employeeId\":2904,\"maxInactiveInterval\":3600,\"loginDepartment\":{\"departmentId\":1479,\"departmentCode\":\"00\",\"departmentName\":\"驹马配送\",\"businessAreas\":[{\"areaCode\":\"00\",\"areaName\":\"全国\"}]},\"authDepartments\":[{\"departmentId\":1479,\"departmentName\":\"驹马配送\"}],\"sessionId\":\"757EB2EB0BCF4DF09BB0BFC4F4C5BD21\",\"tenantId\":9,\"tenantCode\":\"000000004\",\"userId\":1,\"loginName\":\"admin\",\"userName\":\"超级管理员\",\"mobileNumber\":\"18030574832\",\"isTest\":true,\"isSysUser\":true}",
            LoginEmployee.class);

    @Autowired
    private CrmService crmService;

    @Resource
    private MqSendService mqSendService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private AmsCommonService amsCommonService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private AuthCommonService authCommonService;

    @Autowired
    private BusinessAreaService businessAreaService;

    @Autowired
    private TslCustomerInfoService tslCustomerInfoService;

    @Autowired
    private ThirdpartyCommonService thirdpartyCommonService;

    @Autowired
    private IdentificationCardOcrService identificationCardOcrService;

    @Autowired
    private EventBus eventBus;

    @Autowired
    private ProcessService processService;

    @Test
    public void do_send_event_bus(){
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("number", "TC2019050089");
        processService.startProcessInstance("transport_truck_refund", "132212", variables, loginEmployee);
//        Event<String> event = new Event<>();
//        event.setEventId("transport_truck_refund");
//        event.setSystemAuthKey(Constants.SYSTEM_NAME.toLowerCase());
//        Map<String, Object> data = Maps.newHashMap();
//        data.put("processDefinitionKey", "transport_truck_refund");
//        data.put("businessKey", "asdsadsadasdasd");
//        data.put("nextKeyCode", WorkFlowOperate.WorkFlow_CANCEL.getWorkFlowKey());
//        event.setValue(JSON.toJSONString(data));
//        eventBus.push(event);
    }

    @Test
    public void do_send_rabbot_mq_message(){
        StoreInMsgBO data = new StoreInMsgBO();
        data.setSourceId(66);
        data.setSourceNo("TC2019040066");
        data.setOrderNo("SCM13891283918029312");
//        log.info("发送event 消息 {}" ,  JSON.toJSONString(data));
        //VMS_SCM_RETURN_STORAGE_EXCHANGE
        mqSendService.send("VMS_RETURN_STORAGE_EXCHANGE_DEV",data);
    }

    @Test
    public void do_send_event_bus_message(){
//        StoreInMsgBO data = new StoreInMsgBO();
//        data.setSourceId(66);
//        data.setSourceNo("TC2019040066");
//        data.setOrderNo("SCM13891283918029312");
//        //String processDefinitionKey, String businessKey, Map<String, Object> variables, LoginEmployee loginEmployee
//        Event<String> event = new Event<String>();
//        //给启动消息key
//        event.setEventName(Constants.EVENT_NAME_SCM_TO_VMS_RETURN_STORAGE_NO);
//        event.setSystemAuthKey(Constants.SYSTEM_NAME.toLowerCase()); //对应业务系统名称
//        event.setSync(false); //同步 消息
////        log.info("发送event 消息 {}" ,  JSON.toJSONString(data));
//        event.setData(JSON.toJSONString(data));
//        Map<String,Object> processInstance =  eventService.publish(event);
//        System.out.println(JSON.toJSONString(processInstance));
    }

//    @Test
//    public void do_message_receive_from_event_bus(){
//        Event<String> event = new Event<>();
//        // ** 事件名称 */
//        event.setEventName(Constants.EVENT_NAME_SCM_TO_VMS_RETURN_STORAGE_NO);
//        // ** 系统授权key *//*
//        event.setSystemAuthKey(Constants.SYSTEM_NAME.toLowerCase());
//        // ** 事件名称 */
//        // ** 系统授权key *//*
//        // 开始坚听消息
////        eventService.subscribe(event, new SubscribeListener() {
////            @Override
////            public void receive(String message) {
//////                log.info("退车入库: 接收到SCM消息.");
//////                log.info("退车入库: SCM消息内容: {}", message);
////                if (StringUtils.isBlank(message)) { return; }
////                try {
////                    System.out.println(message);
////                } catch (Exception e) {
//////                    log.warn("退车入库：SCM同步信息未成功，返回信息：{}, 异常：{}",message, e.getMessage());
////                }
////            }
//        });
//    }

    @Test
    public void do_send_message_with_driver_infos(){
        Map<String,Object> params = Maps.newHashMap();
        params.put("driverName","张三");
        params.put("plateNumber","川A73460");
        messageService.pushSmsMessage("VMS_COMPLETE_TRANSPORT_DRIVER",params,"13522204027");
    }

    @Test
    public void should_return_crm_customers_with_params(){
        CustomerInfoFilters filters = new CustomerInfoFilters();
//        filters.setTenantId(19);
        filters.setCustomerId("101242");
        filters.setCustomerType(CustomerInfo.CustomerType.DRIVER.getValue());
        // credentialNo字段,允许传身份证或者企业信用代码
//        filters.setCredentialNo("510723197610154934");
        PageQueryCondition<CustomerInfoFilters> customerParams = new PageQueryCondition<>(filters,1,100);
        Page<CustomerInfoBo> customerInfos = crmService.findCustomerInfoBo(customerParams);
        assertNotNull(customerInfos);
        System.out.println(new Gson().toJson(customerInfos.getResults()));
    }

    @Test
    public void should_return_tsl_customer_info_with_truck_identification_no(){
        String[] nos = new String[]{"LJ1EKBBS4J1316504","LFNA4LCA5HAM24691","LJ1EKBBS0J1316497","LFNA4LCA4HAM26531","LFNA4LCA6HAM25588","LFNA4LDA9JAX07986","LVBV3JBB1HE048741","LVBV3JBB8HE045142"};
        for (String truckIdentificationNo : nos) {
            CustomerInfoBO customer = tslCustomerInfoService.getCustomerByVehicleFrameNo(truckIdentificationNo);
            assertNotNull(customer);
            System.out.println(new Gson().toJson(customer));
        }
    }

    @Test
    public void should_return_crm_customers_with_customer_id(){
        CustomerInfo customerInfo = crmService.find(119740,loginEmployee);
        assertNotNull(customerInfo);
        System.out.println(new Gson().toJson(customerInfo));
    }

    @Test
    public void should_return_department_list_with_login_user(){
        List<Department> departments = departmentService.loadDepartmentList(loginEmployee);
        assertNotNull(departments);
        System.out.println(new Gson().toJson(departments));
    }

    @Test
    public void should_return_department_with_department_id(){
        Department department = departmentService.loadDepartment(1442);
        assertNotNull(department);
        System.out.println(new Gson().toJson(department));
    }

    @Test
    public void should_return_department_with_department_code(){
        LoginUser loginUser = new LoginUser();
        loginUser.setTenantId(1);
        Department department = departmentService.loadDepartment("",loginUser);
        assertNotNull(department);
        System.out.println(new Gson().toJson(department));
    }

    @Test
    public void do_card_image_file_upload_and_identify_card_info(){
        String fileName = System.getProperty("user.home")+"/Downloads/migrate-local-repo-tool.jar";
        try(FileInputStream fis = new FileInputStream(fileName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            int length;
            byte[] buf = new byte[4096];
            while((length = fis.read(buf)) != -1){
                baos.write(buf,0,length);
            }
            String imgBase64 = Base64Utils.encodeToString(baos.toByteArray());
            if( 8388608 < imgBase64.length() ){// dubbo接口数据大小限制1024 * 1024 * 8=8388608
                imgBase64 = imgBase64.substring(0,8388608);
            }
            SystemAuthKey systemAuthKey = new SystemAuthKey();
            systemAuthKey.setAuthKey(loginEmployee.getLoginAuthKey());
            IdentificationCard identificationCard = identificationCardOcrService.ocrIdentificationInfo(imgBase64,"face",loginEmployee,systemAuthKey);;
            assertNotNull(identificationCard);
            System.out.println(new Gson().toJson(identificationCard));
        } catch(Exception e){
        }
    }

    @Test
    public void should_return_business_area_name_with_area_code(){
        LoginUser returnLoginUser = new LoginUser();
        returnLoginUser.setTenantId(19);
        BusinessArea area = businessAreaService.loadBusinessArea("000400",returnLoginUser);
        System.out.println(new Gson().toJson(area));
    }

    @Test
    public void findTruckDetail(){
        VehicleOwnerDeptBo vehicleOwnerDeptBo = amsCommonService.getOwnVehicleBOByVehicleFrameNo("LNYADDA36GK502544");
        Department department = authCommonService.loadDepartment(vehicleOwnerDeptBo.getDepartmentCode(),loginEmployee);
        System.out.println(JSON.toJSONString(department));
    }

    @Test
    public void test(){
        boolean isValid = thirdpartyCommonService.validateIdCardAndName("吉里·买海提", "653129198205302618", loginEmployee);
        System.out.println(isValid);
    }

}
