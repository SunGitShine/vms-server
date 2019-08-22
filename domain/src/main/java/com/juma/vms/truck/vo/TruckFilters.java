package com.juma.vms.truck.vo;

import java.io.Serializable;
import java.util.List;

public class TruckFilters implements Serializable {

    /**租户 (必填)*/
    private Integer tenantId;
    /**车牌号 (选填)*/
    private String plateNumber;
    /**承运商id (选填)*/
    private Integer vendorId;
    /**司机id (选填)*/
    private Integer driverId;
    /**运力池状态 (选填)*/
    private Boolean status;
    /**删除状态 (选填)*/
    private Boolean isDelete;

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
