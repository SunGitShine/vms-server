package com.juma.vms.external.service;

/**
 * @author Libin.Wei
 * @version 1.0.0
 * @ClassName VmsV1Service.java
 * @Description 请填写注释...
 * @Date 2018年10月31日 下午7:18:35
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

public interface VmsService extends VendorExternalService, VendorTruckExternalService, VendorVehicleExternalService,
    VendorTenantExternalService, VendorForFmsExternalService, CapacityExternalService, TruckExternalService,
    TruckTenantExternalService, DriverExternalService, DriverTenantExternalService, ReturnExternalService,
    VendorWhiteListExternalService {

}
