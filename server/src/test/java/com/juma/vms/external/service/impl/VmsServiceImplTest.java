package com.juma.vms.external.service.impl;

import com.alibaba.fastjson.JSON;
import com.giants.common.tools.Page;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.common.BaseUtil;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.driver.domain.Driver;
import com.juma.vms.external.service.VmsService;
import com.juma.vms.transport.domain.CapacityPool;
import com.juma.vms.transport.external.CapacityPoolExternalQuery;
import com.juma.vms.transport.request.CapacityPoolFilter;
import com.juma.vms.truck.domain.Truck;
import com.juma.vms.truck.external.TruckExternalFilter;
import com.juma.vms.truck.vo.TruckFilters;
import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.external.VendorExternalFilter;
import com.juma.vms.vendor.vo.VendorIdentification;
import com.juma.vms.vendor.vo.VendorQuery;
import org.testng.annotations.Test;
import testng.BaseTestNGTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class VmsServiceImplTest extends BaseTestNGTest {

    @Resource
    private VmsService vmsService;

    @Test
    public void searchCapacity() {
        QueryCond<CapacityPoolFilter> queryCond = new QueryCond<>();
        CapacityPoolFilter filter = new CapacityPoolFilter();
        filter.setStatus(true);
        queryCond.setFilters(filter);
        queryCond.setPageNo(1);
        queryCond.setPageSize(8);


        Page<CapacityPoolExternalQuery> page = vmsService.searchCapacity(queryCond, new LoginUser(9, 1));
        System.out.println(JSON.toJSONString(page));
    }
    
    @Test
    public void listTruckBy() {
        TruckExternalFilter filter = new TruckExternalFilter();
        filter.setPlateNumber("川A");
        List<Truck> trucks = vmsService.listTruckBy(filter, null, new LoginUser(19, 1));


    }

    @Test
    public void listEffectiveCapacityDriver() {
        CapacityPoolFilter filter = new CapacityPoolFilter();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("000201");
        filter.setAreaCodeList(strings);
        filter.setVehicleBoxType(33);

        List<Driver> drivers = vmsService.listEffectiveCapacityDriver(filter, new LoginUser(4, 1));

        System.out.println(JSON.toJSONString(drivers));
    }

    @Test
    public void loadByVendorByVehicleId() {
//        vmsService.loadByVendorByVehicleId();
//        System.out.println(JSON.toJSONString(drivers));
        //{"enterpriseCode":"","idCardNo":"511011199210218018","vendorId":16558,"vendorName":"李坤","vendorType":2}
    }

    @Test
    public void vendorIdentification() {
        String json = "{\"enterpriseCode\":\"\",\"idCardNo\":\"510321199206155315\",\"vendorId\":16558,"
            + "\"vendorName\":\"谢强\",\"vendorType\":2}";

        VendorIdentification vendorIdentification = JSON.parseObject(json, VendorIdentification.class);
        vmsService.vendorIdentification(vendorIdentification, new LoginUser(9, 1));
    }

    @Test
    public void testLoadByDriverWithTenant(){
        Vendor vendor = vmsService.loadByDriverWithTenant(123 ,new LoginUser(5,5809));
        System.out.println(JSON.toJSONString(vendor));
        System.out.println(BaseUtil.generationCoding(5));
    }

    @Test
    public void listVendorByFilter (){
        VendorExternalFilter filter = new VendorExternalFilter();
        List<VendorQuery> vendorQueries = vmsService.listVendorByFilter(filter, null, null);
    }

    @Test
    public void loadCapacityPoolByPlateNumber (){
        QueryCond<TruckFilters> cond = new QueryCond<TruckFilters>();
        cond.setPageNo(1);
        cond.setPageSize(1);
        TruckFilters filter = new TruckFilters();
        filter.setTenantId(19);
        cond.setFilters(filter);
        filter.setPlateNumber("川");
        filter.setDriverId(11);
        filter.setVendorId(16454);
        filter.setIsDelete(true);
        filter.setStatus(true);
        Page<CapacityPool> capacityPools = vmsService.loadCapacityPoolByPlateNumber(cond);
        System.out.println(capacityPools);
    }
}
