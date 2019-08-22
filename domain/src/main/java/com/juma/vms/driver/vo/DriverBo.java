package com.juma.vms.driver.vo;

import com.juma.vms.driver.domain.Driver;
import com.juma.vms.driver.domain.DriverTenant;
import com.juma.vms.vendor.domain.VendorDriver;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class DriverBo implements Serializable {

    private Driver driver;
    private DriverTenant driverTenant;
    private VendorDriver vendorDriver;
    private Integer truckId;
    private Boolean vendorFlag;
    @ApiModelProperty(value = "验证码")
    private String smsCode;
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public Boolean getVendorFlag() {
        return vendorFlag;
    }

    public void setVendorFlag(Boolean vendorFlag) {
        this.vendorFlag = vendorFlag;
    }

    public Integer getTruckId() {
        return truckId;
    }

    public void setTruckId(Integer truckId) {
        this.truckId = truckId;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public DriverTenant getDriverTenant() {
        return driverTenant;
    }

    public void setDriverTenant(DriverTenant driverTenant) {
        this.driverTenant = driverTenant;
    }

    public VendorDriver getVendorDriver() {
        return vendorDriver;
    }

    public void setVendorDriver(VendorDriver vendorDriver) {
        this.vendorDriver = vendorDriver;
    }

}
