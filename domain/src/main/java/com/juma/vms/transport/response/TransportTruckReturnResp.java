package com.juma.vms.transport.response;

import com.juma.vms.transport.domain.TransportTruckRefund;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 功能 :
 *
 * @author : Bruce(刘正航) 11:32 2019-04-02
 */
@ApiModel("运力退回单结果集")
public class TransportTruckReturnResp implements Serializable {

    private TransportTruckRefund transportTruckRefund;

    @ApiModelProperty("认领部门-租户名称")
    private String tenantName;
    @ApiModelProperty("认领部门-部门名称")
    private String departmentName;
    @ApiModelProperty("退车部门-租户ID")
    private Integer toTenantId;
    @ApiModelProperty("退车部门-租户Code")
    private String toTenantCode;
    @ApiModelProperty("退车部门-租户名称")
    private String toTenantName;
    @ApiModelProperty("退车部门-部门Id")
    private Integer toDepartmentId;
    @ApiModelProperty("退车部门-部门Code")
    private String toDepartmentCode;
    @ApiModelProperty("退车部门-部门名称")
    private String toDepartmentName;
    @ApiModelProperty("关联承运商名称")
    private String vendorName;
    @ApiModelProperty("卡车车型全名")
    private String truckTypeName;
    @ApiModelProperty("服务范围名称")
    private String areaName;

    public TransportTruckRefund getTransportTruckRefund() {
        return transportTruckRefund;
    }

    public void setTransportTruckRefund(TransportTruckRefund transportTruckRefund) {
        this.transportTruckRefund = transportTruckRefund;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getToTenantId() {
        return toTenantId;
    }

    public void setToTenantId(Integer toTenantId) {
        this.toTenantId = toTenantId;
    }

    public String getToTenantCode() {
        return toTenantCode;
    }

    public void setToTenantCode(String toTenantCode) {
        this.toTenantCode = toTenantCode;
    }

    public Integer getToDepartmentId() {
        return toDepartmentId;
    }

    public void setToDepartmentId(Integer toDepartmentId) {
        this.toDepartmentId = toDepartmentId;
    }

    public String getToDepartmentCode() {
        return toDepartmentCode;
    }

    public void setToDepartmentCode(String toDepartmentCode) {
        this.toDepartmentCode = toDepartmentCode;
    }

    public String getToTenantName() {
        return toTenantName;
    }

    public void setToTenantName(String toTenantName) {
        this.toTenantName = toTenantName;
    }

    public String getToDepartmentName() {
        return toDepartmentName;
    }

    public void setToDepartmentName(String toDepartmentName) {
        this.toDepartmentName = toDepartmentName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getTruckTypeName() {
        return truckTypeName;
    }

    public void setTruckTypeName(String truckTypeName) {
        this.truckTypeName = truckTypeName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
