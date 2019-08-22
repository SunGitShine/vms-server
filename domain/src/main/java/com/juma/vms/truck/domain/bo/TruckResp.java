package com.juma.vms.truck.domain.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.juma.vms.truck.domain.Truck;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-21 14:39
 **/
@ApiModel(value = "卡车信息")
public class TruckResp extends Truck implements Serializable{

	@ApiModelProperty(value="创健方")
	private String tenantName;
	@ApiModelProperty(value="业务区域")
	private String areaCode;
	@ApiModelProperty(value="业务区域名称")
	private String areaName;
	@ApiModelProperty(value="能耗类型名称")
	private String energyTypeName;
	@ApiModelProperty(value="能耗排放类别名称")
	private String energyOutTypeName;
	@ApiModelProperty(value="载重")
	private BigDecimal truckLoad;
	@ApiModelProperty(value="体积")
	private BigDecimal truckVolume;
	@ApiModelProperty(value="车型")
	private Integer truckTypeId;
	@ApiModelProperty(value="车型名称")
	private String truckTypeName;
	@ApiModelProperty(value="车认领公司id")
	private Integer truckBelongToCompany;
	@ApiModelProperty(value="车认领公司")
	private String truckBelongToCompanyName;
	@ApiModelProperty(value="车龄")
	private Integer vehicleAge;
	@ApiModelProperty(value="承运商id")
	private Integer vendorId;
	@ApiModelProperty(value="承运商名称")
	private String vendorName;
	@ApiModelProperty(value="业务联系人")
	private String contactUserName;
	@ApiModelProperty(value="承运商手机号")
	private String vendorPhone;
	@ApiModelProperty(value="承运商类型")
	private String vendorTypeDesc;
	@ApiModelProperty(value="承运商业务范围")
	private String vendorAreaName;
	@ApiModelProperty(value="承运商状态")
	private String enableName;
	@ApiModelProperty(value="司机ID")
	private Integer driverId;
	@ApiModelProperty(value="司机姓名")
	private String driverName;
	@ApiModelProperty(value="司机性别")
	private String sex;
	@ApiModelProperty(value="司机准驾车型名称")
	private String driverCanDriveType;
	@ApiModelProperty(value="司机手机号")
	private String driverPhone;
	@ApiModelProperty(value="司机身份证")
	private String driverIdCardNo;
	@ApiModelProperty(value="司机类型  1自营2非自营")
	private Integer driverRunType;
	@ApiModelProperty(value="司机业务范围")
	private String driverAreaName;
	@ApiModelProperty(value="司机状态 0 停工，1出工")
	private Integer driverStatus;
	@ApiModelProperty(value="是否创建方")
	private Boolean isOwner;
	@ApiModelProperty(value="牌照名称")
	private String licenseTypeName;
	@ApiModelProperty(value="车辆状态")
	private Integer status;

	public String getDriverIdCardNo() {
		return driverIdCardNo;
	}

	public void setDriverIdCardNo(String driverIdCardNo) {
		this.driverIdCardNo = driverIdCardNo;
	}

	public String getContactUserName() {
		return contactUserName;
	}

	public void setContactUserName(String contactUserName) {
		this.contactUserName = contactUserName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLicenseTypeName() {
		return licenseTypeName;
	}

	public void setLicenseTypeName(String licenseTypeName) {
		this.licenseTypeName = licenseTypeName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDriverCanDriveType() {
		return driverCanDriveType;
	}

	public void setDriverCanDriveType(String driverCanDriveType) {
		this.driverCanDriveType = driverCanDriveType;
	}

	public Boolean getIsOwner() {
		return isOwner;
	}

	public void setIsOwner(Boolean owner) {
		isOwner = owner;
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

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverPhone() {
		return driverPhone;
	}

	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}

	public Integer getDriverRunType() {
		return driverRunType;
	}

	public void setDriverRunType(Integer driverRunType) {
		this.driverRunType = driverRunType;
	}

	public String getDriverAreaName() {
		return driverAreaName;
	}

	public void setDriverAreaName(String driverAreaName) {
		this.driverAreaName = driverAreaName;
	}

	public Integer getDriverStatus() {
		return driverStatus;
	}

	public void setDriverStatus(Integer driverStatus) {
		this.driverStatus = driverStatus;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorPhone() {
		return vendorPhone;
	}

	public void setVendorPhone(String vendorPhone) {
		this.vendorPhone = vendorPhone;
	}

	public String getVendorTypeDesc() {
		return vendorTypeDesc;
	}

	public void setVendorTypeDesc(String vendorTypeDesc) {
		this.vendorTypeDesc = vendorTypeDesc;
	}

	public String getVendorAreaName() {
		return vendorAreaName;
	}

	public void setVendorAreaName(String vendorAreaName) {
		this.vendorAreaName = vendorAreaName;
	}

	public String getEnableName() {
		return enableName;
	}

	public void setEnableName(String enableName) {
		this.enableName = enableName;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getEnergyTypeName() {
		return energyTypeName;
	}

	public void setEnergyTypeName(String energyTypeName) {
		this.energyTypeName = energyTypeName;
	}

	public String getEnergyOutTypeName() {
		return energyOutTypeName;
	}

	public void setEnergyOutTypeName(String energyOutTypeName) {
		this.energyOutTypeName = energyOutTypeName;
	}

	public BigDecimal getTruckLoad() {
		return truckLoad;
	}

	public void setTruckLoad(BigDecimal truckLoad) {
		this.truckLoad = truckLoad;
	}

	public BigDecimal getTruckVolume() {
		return truckVolume;
	}

	public void setTruckVolume(BigDecimal truckVolume) {
		this.truckVolume = truckVolume;
	}

	public String getTruckTypeName() {
		return truckTypeName;
	}

	public void setTruckTypeName(String truckTypeName) {
		this.truckTypeName = truckTypeName;
	}

	public String getTruckBelongToCompanyName() {
		return truckBelongToCompanyName;
	}

	public void setTruckBelongToCompanyName(String truckBelongToCompanyName) {
		this.truckBelongToCompanyName = truckBelongToCompanyName;
	}

	public Integer getVehicleAge() {
		return vehicleAge;
	}

	public void setVehicleAge(Integer vehicleAge) {
		this.vehicleAge = vehicleAge;
	}
}
