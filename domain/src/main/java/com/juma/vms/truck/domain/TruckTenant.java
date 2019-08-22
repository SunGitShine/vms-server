package com.juma.vms.truck.domain;

import java.io.Serializable;
import java.util.Date;

public class TruckTenant implements Serializable {
    private Integer truckTenantId;

    private Integer truckId;

    private Integer tenantId;

    private String tenantCode;

    private String areaCode;

    private Boolean isOwner;

    private Boolean isReceivable;

    private Integer status;

    private Integer truckBelongToCompany;

    private String truckBelongToCompanyCode;

    private Integer createUserId;

    private Date createTime;

    private Integer lastUpdateUserId;

    private Date lastUpdateTime;

    private static final long serialVersionUID = 1L;

    public Integer getTruckTenantId() {
        return truckTenantId;
    }

    public void setTruckTenantId(Integer truckTenantId) {
        this.truckTenantId = truckTenantId;
    }

    public Integer getTruckId() {
        return truckId;
    }

    public void setTruckId(Integer truckId) {
        this.truckId = truckId;
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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public Boolean getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(Boolean isOwner) {
        this.isOwner = isOwner;
    }

    public Boolean getIsReceivable() {
        return isReceivable;
    }

    public void setIsReceivable(Boolean isReceivable) {
        this.isReceivable = isReceivable;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTruckBelongToCompany() {
        return truckBelongToCompany;
    }

    public void setTruckBelongToCompany(Integer truckBelongToCompany) {
        this.truckBelongToCompany = truckBelongToCompany;
    }

    public String getTruckBelongToCompanyCode() {
        return truckBelongToCompanyCode;
    }

    public void setTruckBelongToCompanyCode(String truckBelongToCompanyCode) {
        this.truckBelongToCompanyCode = truckBelongToCompanyCode == null ? null : truckBelongToCompanyCode.trim();
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

    public Integer getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(Integer lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
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
        TruckTenant other = (TruckTenant) that;
        return (this.getTruckTenantId() == null ? other.getTruckTenantId() == null : this.getTruckTenantId().equals(other.getTruckTenantId()))
            && (this.getTruckId() == null ? other.getTruckId() == null : this.getTruckId().equals(other.getTruckId()))
            && (this.getTenantId() == null ? other.getTenantId() == null : this.getTenantId().equals(other.getTenantId()))
            && (this.getTenantCode() == null ? other.getTenantCode() == null : this.getTenantCode().equals(other.getTenantCode()))
            && (this.getAreaCode() == null ? other.getAreaCode() == null : this.getAreaCode().equals(other.getAreaCode()))
            && (this.getIsOwner() == null ? other.getIsOwner() == null : this.getIsOwner().equals(other.getIsOwner()))
            && (this.getIsReceivable() == null ? other.getIsReceivable() == null : this.getIsReceivable().equals(other.getIsReceivable()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTruckBelongToCompany() == null ? other.getTruckBelongToCompany() == null : this.getTruckBelongToCompany().equals(other.getTruckBelongToCompany()))
            && (this.getTruckBelongToCompanyCode() == null ? other.getTruckBelongToCompanyCode() == null : this.getTruckBelongToCompanyCode().equals(other.getTruckBelongToCompanyCode()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastUpdateUserId() == null ? other.getLastUpdateUserId() == null : this.getLastUpdateUserId().equals(other.getLastUpdateUserId()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTruckTenantId() == null) ? 0 : getTruckTenantId().hashCode());
        result = prime * result + ((getTruckId() == null) ? 0 : getTruckId().hashCode());
        result = prime * result + ((getTenantId() == null) ? 0 : getTenantId().hashCode());
        result = prime * result + ((getTenantCode() == null) ? 0 : getTenantCode().hashCode());
        result = prime * result + ((getAreaCode() == null) ? 0 : getAreaCode().hashCode());
        result = prime * result + ((getIsOwner() == null) ? 0 : getIsOwner().hashCode());
        result = prime * result + ((getIsReceivable() == null) ? 0 : getIsReceivable().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTruckBelongToCompany() == null) ? 0 : getTruckBelongToCompany().hashCode());
        result = prime * result + ((getTruckBelongToCompanyCode() == null) ? 0 : getTruckBelongToCompanyCode().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastUpdateUserId() == null) ? 0 : getLastUpdateUserId().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", truckTenantId=").append(truckTenantId);
        sb.append(", truckId=").append(truckId);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", tenantCode=").append(tenantCode);
        sb.append(", areaCode=").append(areaCode);
        sb.append(", isOwner=").append(isOwner);
        sb.append(", isReceivable=").append(isReceivable);
        sb.append(", status=").append(status);
        sb.append(", truckBelongToCompany=").append(truckBelongToCompany);
        sb.append(", truckBelongToCompanyCode=").append(truckBelongToCompanyCode);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastUpdateUserId=").append(lastUpdateUserId);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        truckTenantId,
        truckId,
        tenantId,
        tenantCode,
        areaCode,
        isOwner,
        isReceivable,
        status,
        truckBelongToCompany,
        truckBelongToCompanyCode,
        createUserId,
        createTime,
        lastUpdateUserId,
        lastUpdateTime;

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