package com.juma.vms.transport.response;

import com.juma.vms.truck.domain.bo.TruckResp;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-22 11:55
 **/
@ApiModel(value = "运力接收详情")
public class TransportReceiveDetailResp implements Serializable {

	private TruckResp truckResp;

	@ApiModelProperty(value = "输送单号")
	private String transportNo;

	@ApiModelProperty(value = "输送类型 1:推送")
	private Integer transportType;

	@ApiModelProperty(value = "客户名称")
	private String crmCustomerName;

	@ApiModelProperty(value = "联系人手机")
	private String crmMobileNumber;

	@ApiModelProperty(value = "客户类型")
	private Integer crmCustomerType;

	// 客户类型:个人/公司,证件号有值/社会信用代码有值
	@ApiModelProperty(value = "证件号")
	private String crmIdentityCardNo;

	@ApiModelProperty(value = "输送部门")
	private String fromDepartmentName;

	@ApiModelProperty(value = "接收部门")
	private String toDepartmentName;

	@ApiModelProperty(value = "输送部门租户名称")
	private String fromTenantName;

	@ApiModelProperty(value = "接收部门租户名称")
	private String toTenantName;

	@ApiModelProperty(value = "创建人")
	private String createName;

	@ApiModelProperty(value = "附件地址")
	private String attachUrl;

	public TruckResp getTruckResp() {
		return truckResp;
	}

	public void setTruckResp(TruckResp truckResp) {
		this.truckResp = truckResp;
	}

	public String getTransportNo() {
		return transportNo;
	}

	public void setTransportNo(String transportNo) {
		this.transportNo = transportNo;
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

	public Integer getCrmCustomerType() {
		return crmCustomerType;
	}

	public void setCrmCustomerType(Integer crmCustomerType) {
		this.crmCustomerType = crmCustomerType;
	}

	public Integer getTransportType() {
		return transportType;
	}

	public void setTransportType(Integer transportType) {
		this.transportType = transportType;
	}

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

	public String getCrmIdentityCardNo() {
		return crmIdentityCardNo;
	}

	public void setCrmIdentityCardNo(String crmIdentityCardNo) {
		this.crmIdentityCardNo = crmIdentityCardNo;
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