package com.juma.vms.transport;

import com.giants.common.tools.Page;
import com.google.gson.Gson;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.tool.domain.CrmCustomerInfo;
import com.juma.vms.tool.domain.DriveLicenseInfo;
import com.juma.vms.tool.domain.IdentificationCardInfo;
import com.juma.vms.tool.request.DriveLicenseReq;
import com.juma.vms.tool.request.IdentificationReq;
import com.juma.vms.tool.service.OcrCommonService;
import com.juma.vms.transport.dao.TransportCapacityItemMapper;
import com.juma.vms.transport.request.CompleteTransportReq;
import com.juma.vms.transport.request.TransportCustomerReq;
import com.juma.vms.transport.request.TransportReceivePageReq;
import com.juma.vms.transport.response.TransportBeforeAddVendorResp;
import com.juma.vms.transport.response.TransportReceiveDetailResp;
import com.juma.vms.transport.response.TransportReceivePageResp;
import com.juma.vms.transport.response.TransportReceiveResp;
import com.juma.vms.transport.service.CapacityPoolService;
import com.juma.vms.transport.service.TransportReceiveService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * 功能 :
 * 测试vendor层功能:
 * @author : Bruce(刘正航) 14:32 2019-03-22
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/META-INF/spring-standalone-beans.xml"
})
public class TransportCapacityTest {

    /**这里需要启动manage,通过断点方式获取json字符串,在这里使用**/
    private static final LoginEmployee loginEmployee = new Gson().fromJson(
//            "{\"employeeId\":2904,\"maxInactiveInterval\":3600,\"loginDepartment\":{\"departmentId\":1479,\"departmentCode\":\"00\",\"departmentName\":\"驹马配送\",\"businessAreas\":[{\"areaCode\":\"00\",\"areaName\":\"全国\"}]},\"authDepartments\":[{\"departmentId\":1479,\"departmentName\":\"驹马配送\"}],\"sessionId\":\"757EB2EB0BCF4DF09BB0BFC4F4C5BD21\",\"tenantId\":9,\"tenantCode\":\"000000004\",\"userId\":1,\"loginName\":\"admin\",\"userName\":\"超级管理员\",\"mobileNumber\":\"18030574832\",\"isTest\":true,\"isSysUser\":true}",
            "{\"employeeId\":7790,\"maxInactiveInterval\":3600,\"loginDepartment\":{\"departmentId\":2875,\"departmentCode\":\"00\",\"departmentName\":\"总部物流事业群\",\"businessAreas\":[{\"areaCode\":\"00\",\"areaName\":\"全国\"}]},\"authDepartments\":[{\"departmentId\":2875,\"departmentName\":\"总部物流事业群\"}],\"sessionId\":\"CD52FD12B00243849DD4F1AF3F581A49\",\"tenantId\":19,\"tenantCode\":\"000000010\",\"userId\":1,\"loginName\":\"admin\",\"userName\":\"超级管理员\",\"mobileNumber\":\"18030574832\",\"isTest\":true,\"isSysUser\":true}",
            LoginEmployee.class);

    @Resource
    private OcrCommonService ocrCommonService;

    @Resource
    private TransportReceiveService transportReceiveService;

    @Resource
    private TransportCapacityItemMapper transportCapacityItemMapper;

    @Resource
    private CapacityPoolService capacityPoolService;

    @Test
    public void should_return_driveLicenseInfo_face_with_image(){
        DriveLicenseReq request = new DriveLicenseReq();
        request.setImageUrl("http://juma-tgm.oss-cn-shenzhen.aliyuncs.com/jumaOss/xq-1557139305931.jpg");
        request.setFaceback("face");
        DriveLicenseInfo driveLicenseInfo = ocrCommonService.ocrDriveLicenseInfo(request, loginEmployee);
        assertNotNull(driveLicenseInfo);
        assertNotNull(driveLicenseInfo.getName());
    }

    @Test
    public void should_return_driveLicenseInfo_back_with_image(){
        DriveLicenseReq request = new DriveLicenseReq();
        request.setImageUrl("http://f.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=b6d5e91c6c600c33f02cd6cc2f7c7d39/cefc1e178a82b9019726e93b748da9773912ef2b.jpg");
        request.setFaceback("back");
        DriveLicenseInfo driveLicenseInfo = ocrCommonService.ocrDriveLicenseInfo(request, loginEmployee);
        assertNotNull(driveLicenseInfo);
        assertNotNull(driveLicenseInfo.getArchiveNo());
    }

    @Test
    public void should_return_identificationInfo_face_with_image(){
        IdentificationReq request = new IdentificationReq();
        request.setImageUrl("http://c.hiphotos.baidu.com/zhidao/pic/item/a50f4bfbfbedab6471a3f9ccf636afc378311eec.jpg");
        request.setFaceback("face");
        IdentificationCardInfo driveLicenseInfo = ocrCommonService.ocrIdentificationInfo(request, loginEmployee);
        assertNotNull(driveLicenseInfo);
        assertNotNull(driveLicenseInfo.getName());
    }

    @Test
    public void should_return_identificationInfo_back_with_image(){
        IdentificationReq request = new IdentificationReq();
        request.setImageUrl("http://c.hiphotos.baidu.com/zhidao/pic/item/a50f4bfbfbedab6471a3f9ccf636afc378311eec.jpg");
        request.setFaceback("face");
        IdentificationCardInfo driveLicenseInfo = ocrCommonService.ocrIdentificationInfo(request, loginEmployee);
        assertNotNull(driveLicenseInfo);
        assertNotNull(driveLicenseInfo.getEndDate());
    }

    /**
     * 根据客户名称或者客户证件号 查询客户列表
     */
    @Test
    public void should_return_customer_list_with_customer_name() {
        TransportCustomerReq request = new TransportCustomerReq();
        request.setCrmCustomerName("驹");
        List<CrmCustomerInfo> customers = transportReceiveService.findTransportCustomers(request,true,loginEmployee);
        assertNotNull(customers);
        assertTrue(customers.size() <= 10);
    }

    @Test
    public void should_return_customer_list_with_customer_idcard() {
        TransportCustomerReq request = new TransportCustomerReq();
        request.setCrmIdentityCardNo("131312991823921");
        List<CrmCustomerInfo> customers = transportReceiveService.findTransportCustomers(request,true,loginEmployee);
        assertNotNull(customers);
        assertTrue(customers.size() <= 10);
    }

    @Test
    public void should_return_transport_capacity_list_with_search_params(){
        QueryCond<TransportReceivePageReq> request = new QueryCond<>();
        TransportReceivePageReq filter = new TransportReceivePageReq();
//        filter.setCrmCustomerId(119740);
        filter.setReceiveStatus(0);
        request.setFilters(filter);
        request.setPageNo(1);
        request.setPageSize(15);
        Page<TransportReceivePageResp> datas = transportReceiveService.findTransportReceivePage(request,loginEmployee);
        assertNotNull(datas);
        if(!CollectionUtils.isEmpty(datas.getResults())){
            assertTrue(datas.getResults().size() <= 10);
        }
    }

    /**运力详情信息查询:客户信息+车辆信息**/
    @Test
    public void should_return_transport_capacity_detail_with_item_id(){
        Integer itemId = 1;
        TransportReceiveDetailResp detail = transportReceiveService.findTransportReceiveDetail(itemId,loginEmployee);
        assertNotNull(detail);
    }

    /**接收运力前置信息查询:客户信息+车辆信息**/
    @Test
    public void should_return_transport_pre_info_with_item_id(){
        Integer itemId = 31;
        TransportReceiveResp preReceiveInfo = transportReceiveService.receiveTransportInfo(itemId,loginEmployee);
        assertNotNull(preReceiveInfo);
    }

    /**完善运力**/
    @Test
    public void should_do_complete_transport_info_by_vendor_truck_and_driver(){
        CompleteTransportReq request = new CompleteTransportReq();
        request.setItemId(33);
        request.setTruckId(26);
        request.setDriverId(17);
        request.setVendorId(10171);
        transportReceiveService.completeTransport(request,loginEmployee);
    }

    /**新建承运商:前置信息获取**/
    @Test
    public void should_return_vendor_pre_info_by_crm_customer_id(){
        String truckIdentificationNo = "1";
        TransportBeforeAddVendorResp response = transportReceiveService.beforeAddVendor(truckIdentificationNo,loginEmployee);
        assertNotNull(response);
    }

    @Test
    public void updateCapacityTest(){
        capacityPoolService.updateCapacityToAvailableByTruck(284,new LoginUser(null,null));
    }

}
