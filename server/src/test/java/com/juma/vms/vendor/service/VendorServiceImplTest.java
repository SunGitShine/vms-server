package com.juma.vms.vendor.service;

import com.alibaba.fastjson.JSON;
import com.giants.common.tools.Page;
import com.giants.common.tools.PageCondition;
import com.giants.common.tools.PageQueryCondition;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.auth.user.domain.LoginUser;
import com.juma.scm.storage.service.GoodsService;
import com.juma.scm.storage.vo.GoodsVO;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.driver.external.DriverExternalFilter;
import com.juma.vms.driver.vo.DriverExtend;
import com.juma.vms.external.service.VmsService;
import com.juma.vms.mq.service.MqService;
import com.juma.vms.tool.service.CrmCommonService;
import com.juma.vms.transport.request.CapacityPoolFilter;
import com.juma.vms.transport.response.CapacityPoolQuery;
import com.juma.vms.transport.service.CapacityPoolService;
import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.domain.VendorDriver;
import com.juma.vms.vendor.domain.VendorTenant;
import com.juma.vms.vendor.external.VendorQueryConditionDto;
import com.juma.vms.vendor.vo.*;
import org.testng.annotations.Test;
import testng.BaseTestNGTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName VendorServiceImplTest.java
 * @Description 请填写注释...
 * @author Libin.Wei
 * @Date 2018年10月30日 下午7:46:55
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

public class VendorServiceImplTest extends BaseTestNGTest {

    @Resource
    private VendorService vendorService;
    @Resource
    private VendorVehicleService vendorVehicleService;
    @Resource
    private VmsService vmsService;
    @Resource
    private MqService mqService;
    @Resource
    private CrmCommonService crmCommonService;
    @Resource
    private VendorDriverService vendorDriverService;
    @Resource
    private GoodsService goodsService;
    @Resource
    private CapacityPoolService capacityPoolService;
    @Resource
    private VendorTenantService vendorTenantService;

    @Test
    public void sendVendorAfterUpdate() {
        
        GoodsVO goodsVO = goodsService.getDetailByCode("tesr11");
        System.out.println(goodsVO);
        
    }

    @Test
    public void getVendor() {
        // Vendor vendor = vendorService.getVendor(1);
        // System.out.println(JSON.toJSONString(vendor));
    }

    @Test
    public void getVendorVehicle() {
        // vmsService.loadByVendorByVehicleId(474, new LoginUser(2, 1));
    }

    @Test
    public void searchVendor() {

        QueryCond<VendorFilter> cond = new QueryCond<>();
        VendorFilter filter = new VendorFilter();

        List<String> areaCodeList = new ArrayList<String>();
        areaCodeList.add("00");

        filter.setAreaCodeList(areaCodeList);
        filter.setIsEnable((byte) 0);
//        filters.put("plateNumber", "云A7A2M2");
        cond.setFilters(filter);
        cond.setPageNo(2);
        cond.setPageSize(15);

        LoginUser loginUser = new LoginUser(2, 1);
        loginUser.setTenantCode("000000000");


        Page<VendorQuery> page = vendorService.search(cond, loginUser);
        System.out.println(JSON.toJSONString(page));
    }
    
    @Test
    public void search() {
        
        PageCondition pageCondition = new PageCondition();
        Map<String, Object> filters = new HashMap<String, Object>();
        filters.put("vendorId", 3);
        pageCondition.setFilters(filters);
        pageCondition.setPageNo(1);
        pageCondition.setPageSize(15);
        
        LoginUser loginUser = new LoginUser(2, 1);
        loginUser.setTenantCode("000000000");
        
        Page<VendorVehicleQuery> page = vendorVehicleService.search(pageCondition, loginUser);
        System.out.println(JSON.toJSONString(page));
    }

    @Test
    public void vendor2user() {
        Integer userId = vendorService.vendor2user(227919, new LoginUser(3, 5809));
        System.out.println(userId);
    }

    @Test
    public void insert() {
        VendorBo bo = new VendorBo();
        Vendor vendor = new Vendor();
        vendor.setVendorType((byte) 3);
        vendor.setVendorName("1257477141");
        vendor.setContactUserName("1245445");
        vendor.setContactPhone("15615100066");
        vendor.setVendorSource((byte) 2);
        vendor.setIsShowYourPrice((byte) 0);
        vendor.setVendorAddress("1234");
        vendor.setBankAccount("9999999999");
        vendor.setBankOfDeposit("1283912839");

        vendor.setIdCardNo("372926197907296912");
        vendor.setEnterpriseCode("372926197907296912");

        VendorTenant t = new VendorTenant();
        t.setAreaCode("00");
        t.setCustomerId(1234568);

        bo.setVendor(vendor);
        bo.setVendorTenant(t);

        LoginUser loginUser = new LoginUser(2, 1);
        loginUser.setTenantCode("000000000");
        vendorService.insert(bo,loginUser);
    }

    @Test
    public void searchSimple() {

        VendorQueryConditionDto dto = new VendorQueryConditionDto();
        PageQueryCondition<VendorQueryConditionDto> pageCondition = new PageQueryCondition<VendorQueryConditionDto>(dto);
        dto.setTenantId(2);
//        dto.setVendorName("葛凯泽");
        dto.setAreaCode("00");
//        pageCondition.setPageNo(1);
        pageCondition.setPageSize(215);
        pageCondition.setFilters(dto);
        Page<VendorQuery> page = vmsService.listVendorBy(pageCondition);
        System.out.println(JSON.toJSONString(page));
    }

    @Test
    public void testCrm () {
        LoginEmployee loginEmployee = new LoginEmployee();
        loginEmployee.setTenantId(4);
//        loginEmployee.setTenantCode("000000000");

//        PageCondition condition = new PageCondition();
//        Map<String, Object> filters = new HashMap<>();
//        condition.setPageNo(1);
//        condition.setPageSize(15);
//        filters.put("customerType", CustomerInfo.CustomerType.DRIVER.getValue());
//        filters.put("status", CustomerInfo.CustomerStatus.SIGNED.getValue());
//        filters.put("tenantId", 2);
//        condition.setFilters(filters);
//
//
//                List<VmsDriverCustomerInfo> list = crmCommonService.listByName("", null, loginEmployee);
//        System.out.println(JSON.toJSON(list));
//        Page<CustomerInfo> info = crmService.searchBaseCustomerInfo(condition, loginEmployee);
//        System.out.println(JSON.toJSON(info));
//        VmsDriverCustomerInfo byCustomerId = crmCommonService.findByCustomerId(85894, loginEmployee);
//        System.out.println(JSON.toJSON(byCustomerId));
    }

    @Test
    public void testLoadVendorTenant() {
        vendorService.loadByIdCardNo("12415454574878", null);
        vendorService.loadByPhone("124545545", null);
        vendorService.findByUserId(12, null);
    }

    @Test
    public void doEnable() {
//       vendorService.doEnable(16427, new LoginUser(9, 1));
        capacityPoolService.updateCapacityToAvailableByVendor(16425, new LoginUser(19, 1));
    }

    @Test
    public void searchByVendor() {
        QueryCond<CapacityPoolFilter> queryCond = new QueryCond<>();
        CapacityPoolFilter filter = new CapacityPoolFilter();
        filter.setVendorId(2);
        queryCond.setFilters(filter);
        queryCond.setPageNo(1);
        queryCond.setPageSize(10);

        Page<CapacityPoolQuery> page = capacityPoolService.searchByVendor(queryCond, new LoginUser(2, 1));
        System.out.println(JSON.toJSONString(page));
    }

    @Test
    public void searchDriverByVendor() {
        QueryCond<VendorDriver> queryCond = new QueryCond<>();
        VendorDriver filter = new VendorDriver();
        filter.setVendorId(2);
        queryCond.setFilters(filter);
        queryCond.setPageNo(1);
        queryCond.setPageSize(10);

        Page<VendorDriverQuery> page = vendorDriverService.search(queryCond, new LoginUser(9, 1));
        System.out.println(JSON.toJSONString(page));
    }

    @Test
    public void disable() {
        vendorTenantService.doDisable(43940, new LoginUser(2, 1));
    }

    @Test
    public void listByVendorFilter() {
        VendorFilter filter = new VendorFilter();
        filter.setCredentialNo("23");

        List<VendorQuery> vendorQueries = vendorService.listByVendorFilter(filter, 15, new LoginUser(2, 1));

        System.out.println(JSON.toJSONString(vendorQueries));
    }

    @Test
    public void listDriverByFilter(){
        DriverExternalFilter filter = new DriverExternalFilter();
        filter.setName("张");
        filter.setTruckIdentificationNo("LFNA4LCAXHAM21348");
        List<DriverExtend> driverExtends = vmsService.listDriverByFilter(filter,5,new LoginUser(9,1));
        System.out.println(JSON.toJSONString(driverExtends));
    }

    public static void main(String[] args) {
        Integer a = 12;
        Integer b = 12;

        System.out.println(a == b);
    }
}
