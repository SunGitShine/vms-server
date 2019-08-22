package com.juma.vms.vendor.external;

import com.juma.vms.vendor.domain.VendorTenant;

import java.io.Serializable;
import java.util.Date;

public class VendorTenantExternal implements Serializable {
    private Integer vendorTenantId;

    private Integer vendorId;

    private Integer customerId;

    private Integer tenantId;

    private String areaCode;

    private Byte isOwner;

    private Boolean isEnable;

    private Integer createUserId;

    private Date createTime;

    private Date lastUpdateTime;

    private Integer lastUpdateUserId;

    public VendorTenantExternal() {
    }

    public VendorTenantExternal(VendorTenant vendorTenant) {
        if (null != vendorTenant) {
            this.vendorTenantId = vendorTenant.getVendorTenantId();
            this.vendorId = vendorTenant.getVendorId();
            this.customerId = vendorTenant.getCustomerId();
            this.tenantId = vendorTenant.getTenantId();
            this.areaCode = vendorTenant.getAreaCode();
            this.isOwner = vendorTenant.getIsOwner();
            this.isEnable = vendorTenant.getIsEnable();
            this.createUserId = vendorTenant.getCreateUserId();
            this.createTime = vendorTenant.getCreateTime();
            this.lastUpdateTime = vendorTenant.getLastUpdateTime();
            this.lastUpdateUserId = vendorTenant.getLastUpdateUserId();
        }
    }

    public Integer getVendorTenantId() {
        return vendorTenantId;
    }

    public void setVendorTenantId(Integer vendorTenantId) {
        this.vendorTenantId = vendorTenantId;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Byte getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(Byte isOwner) {
        this.isOwner = isOwner;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(Integer lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }
}
