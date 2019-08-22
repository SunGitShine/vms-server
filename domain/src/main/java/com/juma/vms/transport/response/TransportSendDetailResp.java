package com.juma.vms.transport.response;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-25 15:49
 **/
public class TransportSendDetailResp implements Serializable{

	@ApiModelProperty(value = "输送租户名称")
	private String fromTenantName;

	@ApiModelProperty(value = "输送公司id")
	private Integer fromDepartmentId;

	@ApiModelProperty(value = "输送公司")
	private String fromDepartmentCode;

	@ApiModelProperty(value = "输送公司")
	private String fromDepartmentName;

	@ApiModelProperty(value = "接收租户id")
	private Integer receiveTenantId;

	@ApiModelProperty(value = "接收租户名称")
	private String toTenantName;

	@ApiModelProperty(value = "接收公司Id")
	private Integer toDepartmentId;

	@ApiModelProperty(value = "接收公司")
	private String toDepartmentName;

	@ApiModelProperty(value = "输送单号")
	private String transportNo;

	@ApiModelProperty(value = "输送类型")
	private Integer transportType;

	@ApiModelProperty(value = "审核状态 1,审核中2,被驳回3,已通过")
	private Integer approvalStatus;

	@ApiModelProperty(value = "创建人")
	private String createName;

	@ApiModelProperty(value = "附件地址")
	private String attachUrl;

	@ApiModelProperty(value = "车辆列表")
	private List<TransportVehicleDetail> vehicleDetails;

	public String getFromDepartmentName() {
		return fromDepartmentName;
	}

	public void setFromDepartmentName(String fromDepartmentName) {
		this.fromDepartmentName = fromDepartmentName;
	}

	public String getToDepartmentName() {
		return toDepartmentName;
	}

	public void setToDepartmentName(String toDepartmentName) {
		this.toDepartmentName = toDepartmentName;
	}

	public String getTransportNo() {
		return transportNo;
	}

	public void setTransportNo(String transportNo) {
		this.transportNo = transportNo;
	}

	public Integer getTransportType() {
		return transportType;
	}

	public void setTransportType(Integer transportType) {
		this.transportType = transportType;
	}

	public Integer getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(Integer approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public List<TransportVehicleDetail> getVehicleDetails() {
		return vehicleDetails;
	}

	public void setVehicleDetails(List<TransportVehicleDetail> vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}

	public String getFromTenantName() {
		return fromTenantName;
	}

	public void setFromTenantName(String fromTenantName) {
		this.fromTenantName = fromTenantName;
	}

	public String getToTenantName() {
		return toTenantName;
	}

	public void setToTenantName(String toTenantName) {
		this.toTenantName = toTenantName;
	}

	public Integer getFromDepartmentId() {
		return fromDepartmentId;
	}

	public void setFromDepartmentId(Integer fromDepartmentId) {
		this.fromDepartmentId = fromDepartmentId;
	}

	public Integer getToDepartmentId() {
		return toDepartmentId;
	}

	public void setToDepartmentId(Integer toDepartmentId) {
		this.toDepartmentId = toDepartmentId;
	}

	public Integer getReceiveTenantId() {
		return receiveTenantId;
	}

	public void setReceiveTenantId(Integer receiveTenantId) {
		this.receiveTenantId = receiveTenantId;
	}

	public String getFromDepartmentCode() {
		return fromDepartmentCode;
	}

	public void setFromDepartmentCode(String fromDepartmentCode) {
		this.fromDepartmentCode = fromDepartmentCode;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getAttachUrl() {
		return attachUrl;
	}

	public void setAttachUrl(String attachUrl) {
		this.attachUrl = attachUrl;
	}
}
