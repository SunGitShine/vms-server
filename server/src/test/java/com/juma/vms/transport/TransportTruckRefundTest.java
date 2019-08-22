package com.juma.vms.transport;

import com.alibaba.fastjson.JSON;
import com.giants.common.tools.Page;
import com.google.gson.Gson;
import com.juma.auth.conf.domain.BusinessArea;
import com.juma.auth.conf.service.BusinessAreaService;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.vms.common.id.IdGeneratorTable;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.tool.service.IdGeneratorService;
import com.juma.vms.tool.service.TslCommonService;
import com.juma.vms.transport.domain.TransportTruckRefund;
import com.juma.vms.transport.enumeration.RefundReasonType;
import com.juma.vms.transport.request.TransportTruckRefundPageReq;
import com.juma.vms.transport.request.TransportTruckRefundTaskReq;
import com.juma.vms.transport.request.TransportTruckRefundTruckReq;
import com.juma.vms.transport.response.TransportReturnTruckInfoResp;
import com.juma.vms.transport.response.TransportTruckReturnResp;
import com.juma.vms.transport.service.TransportTruckReturnService;
import com.juma.vms.truck.enumeration.TruckRunTypeEnum;
import com.juma.vms.vendor.enumeration.VendorTypeEnum;
import com.juma.workflow.core.domain.TaskDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * 功能 :
 *
 * @author : Bruce(刘正航) 15:43 2019-04-03
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/META-INF/spring-standalone-beans.xml"
})
public class TransportTruckRefundTest {

    /**这里需要启动manage,通过断点方式获取json字符串,在这里使用**/
    private static final LoginEmployee loginEmployee = new Gson().fromJson(
//            "{\"employeeId\":2904,\"maxInactiveInterval\":3600,\"loginDepartment\":{\"departmentId\":1479,\"departmentCode\":\"00\",\"departmentName\":\"驹马配送\",\"businessAreas\":[{\"areaCode\":\"00\",\"areaName\":\"全国\"}]},\"authDepartments\":[{\"departmentId\":1479,\"departmentName\":\"驹马配送\"}],\"sessionId\":\"757EB2EB0BCF4DF09BB0BFC4F4C5BD21\",\"tenantId\":9,\"tenantCode\":\"000000004\",\"userId\":1,\"loginName\":\"admin\",\"userName\":\"超级管理员\",\"mobileNumber\":\"18030574832\",\"isTest\":true,\"isSysUser\":true}",
            "{\"employeeId\":7790,\"maxInactiveInterval\":3600,\"loginDepartment\":{\"departmentId\":2875,\"departmentCode\":\"00\",\"departmentName\":\"总部物流事业群\",\"businessAreas\":[{\"areaCode\":\"00\",\"areaName\":\"全国\"}]},\"authDepartments\":[{\"departmentId\":2875,\"departmentName\":\"总部物流事业群\"}],\"sessionId\":\"CD52FD12B00243849DD4F1AF3F581A49\",\"tenantId\":19,\"tenantCode\":\"000000010\",\"userId\":1,\"loginName\":\"admin\",\"userName\":\"超级管理员\",\"mobileNumber\":\"18030574832\",\"isTest\":true,\"isSysUser\":true}",
            LoginEmployee.class);

    @Autowired
    private IdGeneratorService idGeneratorService;

    @Autowired
    private BusinessAreaService businessAreaService;

    @Autowired
    private TransportTruckReturnService transportTruckReturnService;

    @Autowired
    private TslCommonService tslCommonService;

    @Test
    public void should_return_refund_no_with_auto_increment() {
        String no = idGeneratorService.genId(IdGeneratorTable.IdType.TC);
        System.out.println(no);
    }

    /**运力退回单列表**/
    @Test
    public void should_return_truck_refund_list_with_params(){
        QueryCond<TransportTruckRefundPageReq> request = new QueryCond<>();
        TransportTruckRefundPageReq params = new TransportTruckRefundPageReq();
//        params.setPlateNumber("川A73460");
        request.setFilters(params);
        Page<TransportTruckReturnResp> page = transportTruckReturnService.findTransportTruckRefundPage(request,loginEmployee);
        assertNotNull(page);
        assertNotNull(page.getResults());
        assertTrue(!CollectionUtils.isEmpty(page.getResults()));
    }

    @Test
    public void do_cacel_truck_refund_with_refund_id(){
        Integer refundId = 39;
        transportTruckReturnService.cancelTruckRefund(refundId,loginEmployee);
    }

    @Test
    public void should_return_truck_list_with_plate_number(){
        TransportTruckRefundTruckReq request = new TransportTruckRefundTruckReq();
        request.setPlateNumber("陕A56QJ5");
//        request.setPageSize(10);
        List<TransportReturnTruckInfoResp> list = transportTruckReturnService.findRefundTruckInfos(request,loginEmployee);
        assertNotNull(list);
        assertTrue(!CollectionUtils.isEmpty(list));
    }

    @Test
    public void do_add_truck_refund_with_truck_refund_info(){
        TransportTruckRefund refund = new TransportTruckRefund();
        refund.setPlateNumber("川B967PL");
        refund.setTruckIdentificationNo("LJ11KBBC6G8019615");
        refund.setVehicleBoxType(31);
        refund.setVehicleBoxLength(57);
        refund.setTruckRunType(TruckRunTypeEnum.OWN_SALE.getCode());
        refund.setAreaCode("000400");
        refund.setVendorId(20);
        refund.setContactPhone("18880448113");
        refund.setVendorType(VendorTypeEnum.PERSONAL.getCode());
        refund.setDepartmentId(2875);
        refund.setRefundAttachments("[]");
        refund.setRefundReasonType(RefundReasonType.DRIVER.getCode().byteValue());
        refund.setRefundReason("测试退车");
        transportTruckReturnService.addTransportTruckRefund(refund,loginEmployee);
    }

    @Test
    public void should_return_truck_refund_detail_with_refund_id(){
        Integer refundId = 1;
        transportTruckReturnService.findDetailByRefundId(refundId,loginEmployee);
    }

    @Test
    public void should_return_task_detail_with_task_id(){
        String taskId = "1218223";
        TaskDetail taskDetail = transportTruckReturnService.getWorkflowElement(taskId,loginEmployee);
        assertNotNull(taskDetail);
        System.out.println(new Gson().toJson(taskDetail));
    }

    @Test
    public void should_return_task_detail_with_process_id(){
        String processInstanceId = "1218209";
        TaskDetail taskDetail = transportTruckReturnService.findTaskByProcessInstanceId(processInstanceId,loginEmployee);
        assertNotNull(taskDetail);
        System.out.println(new Gson().toJson(taskDetail));
    }

    @Test
    public void should_return_refund_list_with_search_params(){
        QueryCond<TransportTruckRefundPageReq> request = new QueryCond<>();
        TransportTruckRefundPageReq filters = new TransportTruckRefundPageReq();
        filters.setPlateNumber("川A73460");
        filters.setStartDate(new Date());
        filters.setEndDate(new Date());
        request.setFilters(filters);
        Page<TransportTruckReturnResp> page = transportTruckReturnService.findTransportTruckRefundPage(request,loginEmployee);
        assertNotNull(page);
        assertTrue(!CollectionUtils.isEmpty(page.getResults()));
        System.out.println(new Gson().toJson(page));
    }

    @Test
    public void should_return_business_area_name_with_area_code(){
        BusinessArea area = businessAreaService.loadBusinessArea("0001",loginEmployee);
        System.out.println(new Gson().toJson(area));
    }

    @Test
    public void do_work_flow_task_with_approval_key(){
        TransportTruckReturnResp refund = transportTruckReturnService.findDetailByRefundId(62,loginEmployee);
        TransportTruckRefundTaskReq request = new TransportTruckRefundTaskReq();
        request.setComment("测试测试测试");
        request.setRefundId(62);
        TaskDetail detail = transportTruckReturnService.findTaskByProcessInstanceId(refund.getTransportTruckRefund().getProcessInstanceId(),loginEmployee);
        request.setTaskId(detail.getTaskId());
        if( !CollectionUtils.isEmpty(detail.getApprovalTransitions()) ){
            if( detail.getApprovalTransitions().size() == 1 ){
                request.setApprovalKey(detail.getApprovalTransitions().get(0).getKey());
            }else if(detail.getApprovalTransitions().size() == 2){
                request.setApprovalKey(detail.getApprovalTransitions().get(0).getKey());
            }
//            transportTruckReturnService.doWorkFlowTask(request,loginEmployee);
        }
    }

    @Test
    public void returnStock(){
        System.out.println(tslCommonService.hasVehicleNeedReturn("LFNA4LCA6HAM10542"));
    }

    @Test
    public void makeReturnToScmBoTest(){
        System.out.println(JSON.toJSONString(transportTruckReturnService.findDetailByRefundId(249, loginEmployee)));
    }
}
