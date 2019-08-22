package com.juma.vms.vendor.vo;

import com.juma.vms.tool.domain.VmsDriverCustomerInfo;
import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.domain.VendorTenant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @ClassName VendorBo.java
 * @Description 承运商BO类
 * @author Libin.Wei
 * @Date 2018年11月1日 上午10:19:26
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */
@ApiModel
public class VendorBo implements Serializable {

    private Vendor vendor;
    private VendorTenant vendorTenant;
    private VmsDriverCustomerInfo vmsDriverCustomerInfo;
    @ApiModelProperty(value = "验证码")
    private String identifyingCode;

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public VendorTenant getVendorTenant() {
        return vendorTenant;
    }

    public void setVendorTenant(VendorTenant vendorTenant) {
        this.vendorTenant = vendorTenant;
    }

    public VmsDriverCustomerInfo getVmsDriverCustomerInfo() {
        return vmsDriverCustomerInfo;
    }

    public void setVmsDriverCustomerInfo(VmsDriverCustomerInfo vmsDriverCustomerInfo) {
        this.vmsDriverCustomerInfo = vmsDriverCustomerInfo;
    }

    public String getIdentifyingCode() {
        return identifyingCode;
    }

    public void setIdentifyingCode(String identifyingCode) {
        this.identifyingCode = identifyingCode;
    }
}
