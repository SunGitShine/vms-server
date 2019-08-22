package com.juma.vms.vendor.domain;

import java.io.Serializable;
import java.util.Date;

public class VendorTruck implements Serializable {
    private Integer vendorTruckId;

    private Integer tenantId;

    private String tenantCode;

    private Integer vendorId;

    private Integer truckId;

    private Date createTime;

    private Integer createUserId;

    private Date lastUpdateTime;

    private Integer lastUpdateUserId;

    private static final long serialVersionUID = 1L;

    public Integer getVendorTruckId() {
        return vendorTruckId;
    }

    public void setVendorTruckId(Integer vendorTruckId) {
        this.vendorTruckId = vendorTruckId;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode == null ? null : tenantCode.trim();
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getTruckId() {
        return truckId;
    }

    public void setTruckId(Integer truckId) {
        this.truckId = truckId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        VendorTruck other = (VendorTruck) that;
        return (this.getVendorTruckId() == null ? other.getVendorTruckId() == null : this.getVendorTruckId().equals(other.getVendorTruckId()))
            && (this.getTenantId() == null ? other.getTenantId() == null : this.getTenantId().equals(other.getTenantId()))
            && (this.getTenantCode() == null ? other.getTenantCode() == null : this.getTenantCode().equals(other.getTenantCode()))
            && (this.getVendorId() == null ? other.getVendorId() == null : this.getVendorId().equals(other.getVendorId()))
            && (this.getTruckId() == null ? other.getTruckId() == null : this.getTruckId().equals(other.getTruckId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateUserId() == null ? other.getLastUpdateUserId() == null : this.getLastUpdateUserId().equals(other.getLastUpdateUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getVendorTruckId() == null) ? 0 : getVendorTruckId().hashCode());
        result = prime * result + ((getTenantId() == null) ? 0 : getTenantId().hashCode());
        result = prime * result + ((getTenantCode() == null) ? 0 : getTenantCode().hashCode());
        result = prime * result + ((getVendorId() == null) ? 0 : getVendorId().hashCode());
        result = prime * result + ((getTruckId() == null) ? 0 : getTruckId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateUserId() == null) ? 0 : getLastUpdateUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", vendorTruckId=").append(vendorTruckId);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", tenantCode=").append(tenantCode);
        sb.append(", vendorId=").append(vendorId);
        sb.append(", truckId=").append(truckId);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", lastUpdateUserId=").append(lastUpdateUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        vendorTruckId,
        tenantId,
        tenantCode,
        vendorId,
        truckId,
        createTime,
        createUserId,
        lastUpdateTime,
        lastUpdateUserId;

        public String asc() {
            return column() + " ASC";
        }

        public String desc() {
            return column() + " DESC";
        }

        private String column() {
            StringBuilder buffer = new StringBuilder();
            char[] charArray = this.name().toCharArray();
            for(char ch : charArray) {
                if(Character.isUpperCase(ch)){
                    buffer.append("_");
                    buffer.append(Character.toLowerCase(ch));
                } else {
                    buffer.append(ch);
                }
            }
            return buffer.toString();
        }
    }
}