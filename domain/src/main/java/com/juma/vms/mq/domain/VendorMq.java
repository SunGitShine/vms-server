package com.juma.vms.mq.domain;

import java.io.Serializable;

/**
 * @ClassName VendorMq.java
 * @Description 请填写注释...
 * @author Libin.Wei
 * @Date 2018年11月7日 下午8:05:19
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

public class VendorMq implements Serializable {

    private Integer vendorId;
    private Integer tenantId;
    private String jumaPin;

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getJumaPin() {
        return jumaPin;
    }

    public void setJumaPin(String jumaPin) {
        this.jumaPin = jumaPin;
    }
}
