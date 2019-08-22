package com.juma.vms.truck.vo;

import com.juma.vms.truck.domain.Truck;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class TruckBo extends Truck implements Serializable {
    @ApiModelProperty(value="业务区域")
    private String areaCode;
    @ApiModelProperty(value = "车型id")
    private Integer truckTypeId;
    @ApiModelProperty(value="承运商id")
    private Integer vendorId;
    @ApiModelProperty(value="司机id")
    private Integer driverId;
    @ApiModelProperty(value="车辆认领公司")
    private Integer truckBelongToCompany;
    @ApiModelProperty(value="更换认领公司原因")
    private String reason;
    private String remark;
    private Integer truckStatus;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getTruckBelongToCompany() {
        return truckBelongToCompany;
    }

    public void setTruckBelongToCompany(Integer truckBelongToCompany) {
        this.truckBelongToCompany = truckBelongToCompany;
    }

    public Integer getTruckTypeId() {
        return truckTypeId;
    }

    public void setTruckTypeId(Integer truckTypeId) {
        this.truckTypeId = truckTypeId;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
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

    public Integer getTruckStatus() {
        return truckStatus;
    }

    public void setTruckStatus(Integer truckStatus) {
        this.truckStatus = truckStatus;
    }
}