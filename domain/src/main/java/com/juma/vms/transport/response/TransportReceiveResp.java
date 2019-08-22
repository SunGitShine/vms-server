package com.juma.vms.transport.response;

import com.juma.vms.truck.domain.bo.TruckResp;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 功能 :
 *
 * @author : Bruce(刘正航) 09:33 2019-03-25
 **/
@ApiModel(value = "接收运力")
public class TransportReceiveResp implements Serializable{

	@ApiModelProperty(value = "卡车信息")
	private TruckResp truckResp;

	@ApiModelProperty(value = "输送单号")
	private String transportNo;

	@ApiModelProperty(value = "客户ID")
	private Integer crmCustomerId;

	@ApiModelProperty(value = "客户名称")
	private String crmCustomerName;

	@ApiModelProperty(value = "联系人手机")
	private String crmMobileNumber;

	@ApiModelProperty(value = "客户类型")
	private Integer crmCustomerType;

	@ApiModelProperty(value = "客户类型名")
	private String crmCustomerTypeName;

	@ApiModelProperty(value = "输送类型 1:推送")
	private Integer transportType;

	@ApiModelProperty(value = "输送部门")
	private String fromDepartmentName;

	@ApiModelProperty(value = "接收部门(名称)")
	private String toDepartmentName;

	@ApiModelProperty(value = "接收部门ID")
	private Integer toDepartmentId;

	@ApiModelProperty(value = "接收部门业务范围")
	private List<String> toDepartmentAreas;

	// 客户类型:个人/公司,证件号有值/社会信用代码有值
	@ApiModelProperty(value = "证件号")
	private String crmIdentityCardNo;

	@ApiModelProperty(value = "车辆类型:1自营/2加盟")
	private Integer truckRunType;

	@ApiModelProperty(value = "是否是承运商:true/false")
	private boolean beVendor;

	@ApiModelProperty(value = "是否有承运商:true/false")
	private boolean hasVendor;

	@ApiModelProperty(value = "承运商ID")
	private Integer vendorId;

	@ApiModelProperty(value = "司机ID")
	private Integer driverId;

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

	public Integer getCrmCustomerId() {
		return crmCustomerId;
	}

	public void setCrmCustomerId(Integer crmCustomerId) {
		this.crmCustomerId = crmCustomerId;
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

	public String getCrmCustomerTypeName() {
		return crmCustomerTypeName;
	}

	public void setCrmCustomerTypeName(String crmCustomerTypeName) {
		this.crmCustomerTypeName = crmCustomerTypeName;
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

	public Integer getToDepartmentId() {
		return toDepartmentId;
	}

	public void setToDepartmentId(Integer toDepartmentId) {
		this.toDepartmentId = toDepartmentId;
	}

	public List<String> getToDepartmentAreas() {
		return toDepartmentAreas;
	}

	public void setToDepartmentAreas(List<String> toDepartmentAreas) {
		this.toDepartmentAreas = toDepartmentAreas;
	}

	public String getCrmIdentityCardNo() {
		return crmIdentityCardNo;
	}

	public void setCrmIdentityCardNo(String crmIdentityCardNo) {
		this.crmIdentityCardNo = crmIdentityCardNo;
	}

	public Integer getTruckRunType() {
		return truckRunType;
	}

	public void setTruckRunType(Integer truckRunType) {
		this.truckRunType = truckRunType;
	}

	public boolean isBeVendor() {
		return beVendor;
	}

	public void setBeVendor(boolean beVendor) {
		this.beVendor = beVendor;
	}

	public boolean isHasVendor() {
		return hasVendor;
	}

	public void setHasVendor(boolean hasVendor) {
		this.hasVendor = hasVendor;
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
}
