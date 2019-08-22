package com.juma.vms.transport.response;

import com.juma.vms.transport.domain.TransportCapacityItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-22 11:27
 **/
@ApiModel(value = "运力接收列表")
public class TransportReceivePageResp implements Serializable{

	private TransportCapacityItem transportCapacityItem;

	@ApiModelProperty(value = "输送单号")
	private String transportNo;

	@ApiModelProperty(value = "用户id")
	private Integer crmCustomerId;

	@ApiModelProperty(value = "证件号")
	private String crmIdentityCardNo;

	@ApiModelProperty(value = "客户名称")
	private String crmCustomerName;

	@ApiModelProperty(value = "联系人手机")
	private String crmMobileNumber;

	@ApiModelProperty(value = "车辆类型(运营类型)")
	private Integer truckType;

	@ApiModelProperty(value = "车辆类型(运营类型)名称")
	private String truckTypeName;

	@ApiModelProperty(value = "输送类型 1:推送")
	private Integer transportType;

	@ApiModelProperty(value = "输送类型(名称) 1:推送")
	private String transportTypeName;

	@ApiModelProperty(value = "输送部门")
	private String fromDepartmentName;

	@ApiModelProperty(value = "输送部门对应租户")
	private String fromTenantName;

	@ApiModelProperty(value = "接收部门")
	private String toDepartmentName;

	@ApiModelProperty(value = "接收部门对应租户")
	private String toTenantName;

	@ApiModelProperty(value = "工作流ID")
	private String processInstanceId;

	public TransportCapacityItem getTransportCapacityItem() {
		return transportCapacityItem;
	}

	public void setTransportCapacityItem(TransportCapacityItem transportCapacityItem) {
		this.transportCapacityItem = transportCapacityItem;
	}

	public String getTransportNo() {
		return transportNo;
	}

	public void setTransportNo(String transportNo) {
		this.transportNo = transportNo;
	}

	public Integer getCrmCustomerId() {
		return crmCustomerId;
	}

	public void setCrmCustomerId(Integer crmCustomerId) {
		this.crmCustomerId = crmCustomerId;
	}

	public String getCrmIdentityCardNo() {
		return crmIdentityCardNo;
	}

	public void setCrmIdentityCardNo(String crmIdentityCardNo) {
		this.crmIdentityCardNo = crmIdentityCardNo;
	}

	public String getCrmCustomerName() {
		return crmCustomerName;
	}

	public void setCrmCustomerName(String crmCustomerName) {
		this.crmCustomerName = crmCustomerName;
	}

	public String getCrmMobileNumber() {
		return crmMobileNumber;
	}

	public void setCrmMobileNumber(String crmMobileNumber) {
		this.crmMobileNumber = crmMobileNumber;
	}

	public Integer getTruckType() {
		return truckType;
	}

	public void setTruckType(Integer truckType) {
		this.truckType = truckType;
	}

	public String getTruckTypeName() {
		return truckTypeName;
	}

	public void setTruckTypeName(String truckTypeName) {
		this.truckTypeName = truckTypeName;
	}

	public Integer getTransportType() {
		return transportType;
	}

	public void setTransportType(Integer transportType) {
		this.transportType = transportType;
	}

	public String getTransportTypeName() {
		return transportTypeName;
	}

	public void setTransportTypeName(String transportTypeName) {
		this.transportTypeName = transportTypeName;
	}

	public String getFromDepartmentName() {
		return fromDepartmentName;
	}

	public void setFromDepartmentName(String fromDepartmentName) {
		this.fromDepartmentName = fromDepartmentName;
	}

	public String getFromTenantName() {
		return fromTenantName;
	}

	public void setFromTenantName(String fromTenantName) {
		this.fromTenantName = fromTenantName;
	}

	public String getToDepartmentName() {
		return toDepartmentName;
	}

	public void setToDepartmentName(String toDepartmentName) {
		this.toDepartmentName = toDepartmentName;
	}

	public String getToTenantName() {
		return toTenantName;
	}

	public void setToTenantName(String toTenantName) {
		this.toTenantName = toTenantName;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
}
