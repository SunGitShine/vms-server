package com.juma.vms.transport.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-25 14:09
 **/
public class TransportSendPageReq implements Serializable{

	@ApiModelProperty(value = "租户id")
	private Integer tenantId;
	@ApiModelProperty(value = "开始时间")
	private Date startTime;
	@ApiModelProperty(value = "结束时间")
	private Date endTime;
	@ApiModelProperty(value = "输送单号")
	private String transportNo;
	@ApiModelProperty(value = "车牌号")
	private String plateNumber;
	@ApiModelProperty(value = "输送公司")
	private Integer fromCompany;
	@ApiModelProperty(value = "接收公司")
	private Integer toCompany;
	@ApiModelProperty(value = "审核状态")
	private List<Integer> approvalStatusList;
	@ApiModelProperty(value = "单据状态")
	private Integer documentStatus;

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getTransportNo() {
		return transportNo;
	}

	public void setTransportNo(String transportNo) {
		this.transportNo = transportNo;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public Integer getFromCompany() {
		return fromCompany;
	}

	public void setFromCompany(Integer fromCompany) {
		this.fromCompany = fromCompany;
	}

	public Integer getToCompany() {
		return toCompany;
	}

	public void setToCompany(Integer toCompany) {
		this.toCompany = toCompany;
	}

	public List<Integer> getApprovalStatusList() {
		return approvalStatusList;
	}

	public void setApprovalStatusList(List<Integer> approvalStatusList) {
		this.approvalStatusList = approvalStatusList;
	}

	public Integer getDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(Integer documentStatus) {
		this.documentStatus = documentStatus;
	}
}
