package com.juma.vms.transport.domain;

import java.io.Serializable;
import java.util.Date;

public class CapacityPool implements Serializable {
    private Integer capacityPoolId;

    private Integer tenantId;

    private String tenantCode;

    private Integer vendorId;

    private String areaCode;

    private Integer truckId;

    private Integer driverId;

    private Integer vehicleBoxType;

    private Integer vehicleBoxLength;

    private Integer vehicleRunType;

    private Integer goCityLicenseType;

    private Boolean status;

    private Boolean isDelete;

    private Integer createUserId;

    private Date createTime;

    private Date lastUpdateTime;

    private Integer lastUpdateUserId;

    private static final long serialVersionUID = 1L;

    public Integer getCapacityPoolId() {
        return capacityPoolId;
    }

    public void setCapacityPoolId(Integer capacityPoolId) {
        this.capacityPoolId = capacityPoolId;
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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public Integer getTruckId() {
        return truckId;
    }

    public void setTruckId(Integer truckId) {
        this.truckId = truckId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Integer getVehicleBoxType() {
        return vehicleBoxType;
    }

    public void setVehicleBoxType(Integer vehicleBoxType) {
        this.vehicleBoxType = vehicleBoxType;
    }

    public Integer getVehicleBoxLength() {
        return vehicleBoxLength;
    }

    public void setVehicleBoxLength(Integer vehicleBoxLength) {
        this.vehicleBoxLength = vehicleBoxLength;
    }

    public Integer getVehicleRunType() {
        return vehicleRunType;
    }

    public void setVehicleRunType(Integer vehicleRunType) {
        this.vehicleRunType = vehicleRunType;
    }

    public Integer getGoCityLicenseType() {
        return goCityLicenseType;
    }

    public void setGoCityLicenseType(Integer goCityLicenseType) {
        this.goCityLicenseType = goCityLicenseType;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
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
        CapacityPool other = (CapacityPool) that;
        return (this.getCapacityPoolId() == null ? other.getCapacityPoolId() == null : this.getCapacityPoolId().equals(other.getCapacityPoolId()))
            && (this.getTenantId() == null ? other.getTenantId() == null : this.getTenantId().equals(other.getTenantId()))
            && (this.getTenantCode() == null ? other.getTenantCode() == null : this.getTenantCode().equals(other.getTenantCode()))
            && (this.getVendorId() == null ? other.getVendorId() == null : this.getVendorId().equals(other.getVendorId()))
            && (this.getAreaCode() == null ? other.getAreaCode() == null : this.getAreaCode().equals(other.getAreaCode()))
            && (this.getTruckId() == null ? other.getTruckId() == null : this.getTruckId().equals(other.getTruckId()))
            && (this.getDriverId() == null ? other.getDriverId() == null : this.getDriverId().equals(other.getDriverId()))
            && (this.getVehicleBoxType() == null ? other.getVehicleBoxType() == null : this.getVehicleBoxType().equals(other.getVehicleBoxType()))
            && (this.getVehicleBoxLength() == null ? other.getVehicleBoxLength() == null : this.getVehicleBoxLength().equals(other.getVehicleBoxLength()))
            && (this.getVehicleRunType() == null ? other.getVehicleRunType() == null : this.getVehicleRunType().equals(other.getVehicleRunType()))
            && (this.getGoCityLicenseType() == null ? other.getGoCityLicenseType() == null : this.getGoCityLicenseType().equals(other.getGoCityLicenseType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateUserId() == null ? other.getLastUpdateUserId() == null : this.getLastUpdateUserId().equals(other.getLastUpdateUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCapacityPoolId() == null) ? 0 : getCapacityPoolId().hashCode());
        result = prime * result + ((getTenantId() == null) ? 0 : getTenantId().hashCode());
        result = prime * result + ((getTenantCode() == null) ? 0 : getTenantCode().hashCode());
        result = prime * result + ((getVendorId() == null) ? 0 : getVendorId().hashCode());
        result = prime * result + ((getAreaCode() == null) ? 0 : getAreaCode().hashCode());
        result = prime * result + ((getTruckId() == null) ? 0 : getTruckId().hashCode());
        result = prime * result + ((getDriverId() == null) ? 0 : getDriverId().hashCode());
        result = prime * result + ((getVehicleBoxType() == null) ? 0 : getVehicleBoxType().hashCode());
        result = prime * result + ((getVehicleBoxLength() == null) ? 0 : getVehicleBoxLength().hashCode());
        result = prime * result + ((getVehicleRunType() == null) ? 0 : getVehicleRunType().hashCode());
        result = prime * result + ((getGoCityLicenseType() == null) ? 0 : getGoCityLicenseType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
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
        sb.append(", capacityPoolId=").append(capacityPoolId);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", tenantCode=").append(tenantCode);
        sb.append(", vendorId=").append(vendorId);
        sb.append(", areaCode=").append(areaCode);
        sb.append(", truckId=").append(truckId);
        sb.append(", driverId=").append(driverId);
        sb.append(", vehicleBoxType=").append(vehicleBoxType);
        sb.append(", vehicleBoxLength=").append(vehicleBoxLength);
        sb.append(", vehicleRunType=").append(vehicleRunType);
        sb.append(", goCityLicenseType=").append(goCityLicenseType);
        sb.append(", status=").append(status);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", lastUpdateUserId=").append(lastUpdateUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        capacityPoolId,
        tenantId,
        tenantCode,
        vendorId,
        areaCode,
        truckId,
        driverId,
        vehicleBoxType,
        vehicleBoxLength,
        vehicleRunType,
        goCityLicenseType,
        status,
        isDelete,
        createUserId,
        createTime,
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