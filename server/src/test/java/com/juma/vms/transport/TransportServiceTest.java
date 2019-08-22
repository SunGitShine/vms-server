package com.juma.vms.transport;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.scm.product.bo.PropertyValueBO;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.driver.domain.Driver;
import com.juma.vms.transport.domain.CapacityPool;
import com.juma.vms.transport.request.AddExternalTransportReq;
import com.juma.vms.transport.request.AddVendorAndDriverReq;
import com.juma.vms.transport.request.TransportPageReq;
import com.juma.vms.transport.request.TransportSendPageReq;
import com.juma.vms.transport.service.TransportSendService;
import com.juma.vms.transport.service.TransportService;
import com.juma.vms.truck.domain.Truck;
import com.juma.vms.truck.enumeration.TruckStatusEnum;
import com.juma.vms.truck.service.TruckService;
import com.juma.vms.truck.vo.TruckBo;
import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.domain.VendorTenant;
import lombok.extern.slf4j.Slf4j;

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
public class TransportServiceTest {

    /**这里需要启动manage,通过断点方式获取json字符串,在这里使用**/
    private static final LoginEmployee loginEmployee = new Gson().fromJson(
            "{\"employeeId\":2904,\"maxInactiveInterval\":3600,\"loginDepartment\":{\"departmentId\":1479,\"departmentCode\":\"00\",\"departmentName\":\"驹马配送\",\"businessAreas\":[{\"areaCode\":\"00\",\"areaName\":\"全国\"}]},\"authDepartments\":[{\"departmentId\":1479,\"departmentName\":\"驹马配送\"}],\"sessionId\":\"757EB2EB0BCF4DF09BB0BFC4F4C5BD21\",\"tenantId\":19,\"tenantCode\":\"000000004\",\"userId\":1,\"loginName\":\"admin\",\"userName\":\"超级管理员\",\"mobileNumber\":\"18030574832\",\"isTest\":true,\"isSysUser\":true}",
            LoginEmployee.class);

    @Resource
    private TransportService transportService;

    @Resource
    private TruckService truckService;

    @Test
    public void transportPageTest(){
        QueryCond<TransportPageReq> queryCond = new QueryCond<>();
        queryCond.setPageNo(1);
        queryCond.setPageSize(15);
        TransportPageReq req = new TransportPageReq();
        req.setStatus(true);
        List<String> areaCodeList = new ArrayList<>();
        areaCodeList.add("00");
        req.setAreaCodeList(areaCodeList);
        req.setTruckType(1);
        queryCond.setFilters(req);
        System.out.println(JSON.toJSONString(transportService.findTransportByPage(queryCond, loginEmployee)));
    }

    @Test
    public void addExternalTransportTest(){
        AddExternalTransportReq addExternalTransport = new AddExternalTransportReq();
        TruckBo truck = new TruckBo();
        truck.setPlateNumber("川AJ61Z4");
        truck.setTruckIdentificationNo("xwe423ed3");
        truck.setLicenseType(46);
        truck.setVehicleBoxType(34);
        truck.setVehicleBoxLength(4200);
        truck.setEnergyType(42);
        truck.setEnergyOutType(43);
        truck.setGoCityLicenseType(0);
        truck.setIsTailBoard(true);
        truck.setTruckBodyImg("img.jpg");
        truck.setLicenseCertificateImg1("img.jpg");
        truck.setLicenseCertificateImg2("img.jpg");
        truck.setPermitLicenseImg1("img.jpg");
        truck.setPermitLicenseImg2("img.jpg");
        truck.setTruckTypeId(1);
        addExternalTransport.setVendorId(8);
        addExternalTransport.setDriverId(11);
        addExternalTransport.setTruckBo(truck);

        transportService.addExternalTransport(addExternalTransport, loginEmployee);
    }

    @Test
    public void findTransportDetailTest(){
        System.out.println(JSON.toJSONString(transportService.findTransportDetail(10,loginEmployee)));
    }

    @Test
    public void addVendorAndBindDriverTest(){

        AddVendorAndDriverReq addVendorAndDriverReq = new AddVendorAndDriverReq();
        Vendor vendor = new Vendor();
        vendor.setVendorName("郭珊");
        vendor.setVendorSource(new Byte("2"));
        vendor.setVendorType(new Byte("1"));
        vendor.setIdCardNo("513723199212254229");
        vendor.setContactPhone("18380438056");
        vendor.setContactUserName("shanshan");
        vendor.setIsShowYourPrice(new Byte("1"));
        vendor.setIdCardImg1("[{\"name\":\"20121228112051287-1554348352421.jpg\",\"path\":\"jumaOss/20121228112051287-1554348352421.jpg\"}]");
        vendor.setIdCardImg2("[{\"name\":\"20121228112051287-1554348357481.jpg\",\"path\":\"jumaOss/20121228112051287-1554348357481.jpg\"}]");

        VendorTenant tenant = new VendorTenant();
        tenant.setAreaCode("00");

        Driver driver = new Driver();
        driver.setDriveLicenseImg1("[{\"name\":\"20121228112051287-1554348352421.jpg\",\"path\":\"jumaOss/20121228112051287-1554348352421.jpg\"}]");
        driver.setDriveLicenseImg2("[{\"name\":\"20121228112051287-1554348352421.jpg\",\"path\":\"jumaOss/20121228112051287-1554348352421.jpg\"}]");
        driver.setCanDriveType(new Byte("1"));
        driver.setDriveLicenseEndTime(new Date());
        driver.setDriveLicenseFirstTakeTime(new Date());
        addVendorAndDriverReq.setBindDriver(true);
        addVendorAndDriverReq.setDriver(driver);
        addVendorAndDriverReq.setVendor(vendor);
        addVendorAndDriverReq.setVendorTenant(tenant);

        transportService.addVendorAndBindDriver(addVendorAndDriverReq, loginEmployee);
    }

    @Test
    public void hashCodeTest(){
        CapacityPool capacityPool = new CapacityPool();
        capacityPool.setDriverId(1);
        System.out.println((capacityPool.hashCode()));
    }

    @Test
    public void addTruckTest(){
        TruckBo truckBo = new TruckBo();
        truckBo.setPlateNumber("粤AD00B3");
        truckBo.setTruckIdentificationNo("LFNA4LCA5HAM31110");
        truckBo.setTruckStatus(TruckStatusEnum.WAIT_RECEIVE.getCode());
        truckBo.setTruckBelongToCompany(2875);
        truckBo.setGoCityLicenseType(0);
        truckService.addTruck(truckBo, loginEmployee);
    }

    @Test
    public void equelsTest(){

        Map<String, PropertyValueBO> property = new HashMap<>();
        PropertyValueBO bo = new PropertyValueBO();
        bo.setPropertyValueId("x");
        property.put("test", bo);

        Integer.parseInt(property.get("test").getPropertyValueId());

    }

}
