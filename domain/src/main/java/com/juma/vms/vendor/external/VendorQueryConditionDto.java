package com.juma.vms.vendor.external;

import java.io.Serializable;

public class VendorQueryConditionDto implements Serializable {

    // 租户ID，必填
    private Integer tenantId;
    // 承运商名称：支持XXX%，可为空
    private String vendorName;
    // 业务区域，可为空
    private String areaCode;

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
}
