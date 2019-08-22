package com.juma.vms.transport;

import com.alibaba.fastjson.JSON;
import com.giants.common.tools.Page;
import com.giants.common.tools.PageCondition;
import com.google.gson.Gson;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.auth.support.service.DepartmentSupportService;
import com.juma.auth.user.domain.LoginUser;
import com.juma.scm.support.service.Scm4VmsService;
import com.juma.server.vm.domain1.bo.VehicleBo;
import com.juma.server.vm.service.vehicle.AmsServiceV2;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.tool.service.AuthCommonService;
import com.juma.vms.tool.service.BusinessAreaCommonService;
import com.juma.vms.transport.domain.CapacityPool;
import com.juma.vms.transport.domain.TransportCapacity;
import com.juma.vms.transport.domain.TransportCapacityItem;
import com.juma.vms.transport.request.AddTransportSendReq;
import com.juma.vms.transport.request.SelectVehicleReq;
import com.juma.vms.transport.request.TransportSendPageReq;
import com.juma.vms.transport.response.TransportSendDetailResp;
import com.juma.vms.transport.service.CapacityPoolService;
import com.juma.vms.transport.service.TransportSendService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.*;

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
public class TransportSendServiceTest {

    /**这里需要启动manage,通过断点方式获取json字符串,在这里使用**/
    private static final LoginEmployee loginEmployee = new Gson().fromJson(
            "{\"employeeId\":2904,\"maxInactiveInterval\":3600,\"loginDepartment\":{\"departmentId\":1479,\"departmentCode\":\"00\",\"departmentName\":\"驹马配送\",\"businessAreas\":[{\"areaCode\":\"00\",\"areaName\":\"全国\"}]},\"authDepartments\":[{\"departmentId\":1479,\"departmentName\":\"驹马配送\"}],\"sessionId\":\"757EB2EB0BCF4DF09BB0BFC4F4C5BD21\",\"tenantId\":5,\"tenantCode\":\"000000004\",\"userId\":1,\"loginName\":\"admin\",\"userName\":\"超级管理员\",\"mobileNumber\":\"18030574832\",\"isTest\":true,\"isSysUser\":true}",
            LoginEmployee.class);

    @Resource
    private TransportSendService transportSendService;

    @Resource
    private BusinessAreaCommonService businessAreaCommonService;

    @Resource
    private AmsServiceV2 amsServiceV2;

    @Resource
    private Scm4VmsService scm4VmsService;

    @Resource
    private CapacityPoolService capacityPoolService;

    @Resource
    private AuthCommonService authCommonService;

    @Resource
    private DepartmentSupportService departmentSupportService;

    @Test
    public void transportPageTest(){
        QueryCond<TransportSendPageReq> queryCond = new QueryCond<>();
        queryCond.setPageNo(1);
        queryCond.setPageSize(15);
        transportSendService.findTransportSendPage(queryCond, loginEmployee);
    }

    @Test
    public void selectVehicleTest(){

//        String truckIdentificationNo = "LFNA4LCA4HAM26531";
//        String fromDepartmentCode = "00000400";
//        System.out.println(JSON.toJSONString(transportSendService.selectVehicle(truckIdentificationNo, fromDepartmentCode, loginEmployee)));
    }

    @Test
    public void equelsTest(){

        List<TransportCapacityItem> items = new ArrayList<>();
        TransportCapacityItem item = new TransportCapacityItem();
        item.setTruckIdentificationNo("123");
        TransportCapacityItem item1 = new TransportCapacityItem();
        item.setTruckIdentificationNo("1234");
        items.add(item);
        items.add(item1);
        TransportCapacityItem itemTest = new TransportCapacityItem();
        item.setTruckIdentificationNo("12344343");
        System.out.println(items.contains(itemTest));

    }

    @Test
    public void addTransportSendTest(){

        AddTransportSendReq addTransportSendReq = new AddTransportSendReq();
        TransportCapacity transportCapacity = new TransportCapacity();
        transportSendService.addTransportSend(addTransportSendReq, loginEmployee);
    }

    @Test
    public void testAreaCode(){
        System.out.println(businessAreaCommonService.loadLogicAndSelfAreaName("000303010102", loginEmployee));
    }

    @Test
    public void transportSendDetailTest(){
        TransportSendDetailResp resp = transportSendService.findTransportSendDetail(44,loginEmployee);
        System.out.println(JSON.toJSONString(resp));
    }

    @Test
    public void byteTest(){
        new ArrayList<>(null);
    }

    @Test
    public void findVehicleFromAmsTest(){
        PageCondition pageCondition = new PageCondition();
        pageCondition.setPageNo(1);
        pageCondition.setPageSize(10);

        Map<String,Object> paramMap = new HashMap<>();
//        paramMap.put("departmentCode", "00000400");
        paramMap.put("vehicleFrameNo", "LNYADDA36GK502544");

        List<Object> isAssetOwnerList = new ArrayList<>();
        isAssetOwnerList.add(1);
        isAssetOwnerList.add(3);
        paramMap.put("isAssetOwnerList", isAssetOwnerList);

        pageCondition.setFilters(paramMap);

        Page<VehicleBo> vehicleBoPage = amsServiceV2.queryVehicleBoForInner(pageCondition, loginEmployee);
        Collection<VehicleBo> objects = vehicleBoPage.getResults();
    }

    @Test
    public void scmLockTruckTest(){
        List<String> truckIdentificationNos = new ArrayList<>();
        truckIdentificationNos.add("LJ1EKBBS4J1316504");
        truckIdentificationNos.add("LFNA4LCA4HAM26531");
        scm4VmsService.lockByGoodsCodeList(truckIdentificationNos, "VMS", "SS19040019");
    }

    @Test
    public void findCapacityTest(){
        CapacityPool capacityPool = capacityPoolService.loadCapacityPoolByTruckId(56, new LoginUser(null, null));
        System.out.println(JSON.toJSONString(capacityPool));
    }

    @Test
    public void authServiceTest(){
        System.out.println(JSON.toJSONString(authCommonService.getAllOption("TRANSPORT_TENANT_LIST")));
    }

    @Test
    public void findTruckDetail(){

        SelectVehicleReq selectVehicleReq = new SelectVehicleReq();
        selectVehicleReq.setFromDepartmentCode("00010201");
        selectVehicleReq.setReceiveTenantId(19);
        selectVehicleReq.setToDepartmentId(2875);
        selectVehicleReq.setTruckIdentificationNo("LNYADDA36GK502544");
        transportSendService.selectVehicleDetail(selectVehicleReq, loginEmployee);
    }

    @Test
    public void findParentDepartment(){
        JSON.toJSONString(departmentSupportService.findParentCompanyDepartment(2875));
    }

}
