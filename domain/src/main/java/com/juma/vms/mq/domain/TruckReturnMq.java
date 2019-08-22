package com.juma.vms.mq.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 功能 :
 *
 * @author : Bruce(刘正航) 21:42 2019-04-15
 */
@ApiModel("卡车退回消息")
public class TruckReturnMq implements Serializable {
    @ApiModelProperty("运力退回单ID")
    private Integer returnId;
    @ApiModelProperty("运力退回单号")
    private String returnNo;
    @ApiModelProperty("车架号")
    private String truckIdentificationNo;
    @ApiModelProperty("车辆运营类型")
    private Integer truckRunType;
    @ApiModelProperty("车辆认领部门")
    private Integer departmentId;
    @ApiModelProperty("是否是自有资产")
    private boolean beSelf;
    @ApiModelProperty("租户ID")
    private Integer tenantId;

    public Integer getReturnId() {
        return returnId;
    }

    public void setReturnId(Integer returnId) {
        this.returnId = returnId;
    }

    public String getReturnNo() {
        return returnNo;
    }

    public void setReturnNo(String returnNo) {
        this.returnNo = returnNo;
    }

    public String getTruckIdentificationNo() {
        return truckIdentificationNo;
    }

    public void setTruckIdentificationNo(String truckIdentificationNo) {
        this.truckIdentificationNo = truckIdentificationNo;
    }

    public Integer getTruckRunType() {
        return truckRunType;
    }

    public void setTruckRunType(Integer truckRunType) {
        this.truckRunType = truckRunType;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public boolean isBeSelf() {
        return beSelf;
    }

    public void setBeSelf(boolean beSelf) {
        this.beSelf = beSelf;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

}
