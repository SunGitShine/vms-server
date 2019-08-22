package com.juma.vms.transport.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 运力退回请求参数
 * @author : Bruce(刘正航) 20:03 2019-03-28
 */
@ApiModel("运力退回参数")
public class TransportTruckRefundPageReq implements Serializable {

    @ApiModelProperty("开始日期")
    private Date startDate;
    @ApiModelProperty("结束日期")
    private Date endDate;
    @ApiModelProperty("运力退回单编号")
    private String refundNo;
    @ApiModelProperty("车牌号")
    private String plateNumber;
    @ApiModelProperty("车架号")
    private String truckIdentificationNo;
    @ApiModelProperty("退车原因")
    private Byte refundReasonType;
    @ApiModelProperty("审批状态(0未提,1审核中,2被驳回,3已通过)")
    private Integer approvalStatus;
    @ApiModelProperty("单据状态(0审批中,1待入库,2已通过,3已撤销)")
    private Integer refundStatus;
    @ApiModelProperty("车辆认领部门(车辆认领公司)")
    private Integer departmentId;
    @ApiModelProperty("车辆认领部门code(车辆认领公司)")
    private String departmentCode;
    @ApiModelProperty("接收部门(车辆退回公司)")
    private Integer toDepartmentId;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getTruckIdentificationNo() {
        return truckIdentificationNo;
    }

    public void setTruckIdentificationNo(String truckIdentificationNo) {
        this.truckIdentificationNo = truckIdentificationNo;
    }

    public Byte getRefundReasonType() {
        return refundReasonType;
    }

    public void setRefundReasonType(Byte refundReasonType) {
        this.refundReasonType = refundReasonType;
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getToDepartmentId() {
        return toDepartmentId;
    }

    public void setToDepartmentId(Integer toDepartmentId) {
        this.toDepartmentId = toDepartmentId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
}
