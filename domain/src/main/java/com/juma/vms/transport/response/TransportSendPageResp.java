package com.juma.vms.transport.response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-25 14:16
 **/
public class TransportSendPageResp implements Serializable{

	@ApiModelProperty(value = "输送id")
	private Integer transportId;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "输送单号")
	private String transportNo;

	@ApiModelProperty(value = "车牌号列表")
	private List<String> plateNumberList;

	@ApiModelProperty(value = "输送公司")
	private String fromCompanyName;

	@ApiModelProperty(value = "输送公司租户")
	private String fromCompanyTenantName;

	@ApiModelProperty(value = "接收公司")
	private String toCompanyName;

	@ApiModelProperty(value = "接收公司租户")
	private String toCompanyTenantName;

	@ApiModelProperty(value = "输送类型")
	private Integer sendType;

	@ApiModelProperty(value = "审核状态")
	private Integer approvalStatus;

	@ApiModelProperty(value = "工作流id")
	private String processInstanceId;

	@ApiModelProperty(value = "创建人id")
	private Integer createUserId;

	public Integer getTransportId() {
		return transportId;
	}

	public void setTransportId(Integer transportId) {
		this.transportId = transportId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTransportNo() {
		return transportNo;
	}

	public void setTransportNo(String transportNo) {
		this.transportNo = transportNo;
	}

	public List<String> getPlateNumberList() {
		return plateNumberList;
	}

	public void setPlateNumberList(List<String> plateNumberList) {
		this.plateNumberList = plateNumberList;
	}

	public String getFromCompanyName() {
		return fromCompanyName;
	}

	public void setFromCompanyName(String fromCompanyName) {
		this.fromCompanyName = fromCompanyName;
	}

	public String getToCompanyName() {
		return toCompanyName;
	}

	public void setToCompanyName(String toCompanyName) {
		this.toCompanyName = toCompanyName;
	}

	public Integer getSendType() {
		return sendType;
	}

	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}

	public Integer getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(Integer approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getFromCompanyTenantName() {
		return fromCompanyTenantName;
	}

	public void setFromCompanyTenantName(String fromCompanyTenantName) {
		this.fromCompanyTenantName = fromCompanyTenantName;
	}

	public String getToCompanyTenantName() {
		return toCompanyTenantName;
	}

	public void setToCompanyTenantName(String toCompanyTenantName) {
		this.toCompanyTenantName = toCompanyTenantName;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
}
