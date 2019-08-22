package com.juma.vms.transport.response;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description: 运力管理列表返回数据
 *
 * @author: xieqiang
 *
 * @create: 2019-03-19 17:36
 **/
@ApiModel(value = "运力管理列表")
public class TransportPageResp implements Serializable{

	@ApiModelProperty(value = "运力池id")
	private Integer capacityPoolId;//运力池id

	@ApiModelProperty(value = "车辆id")
	private Integer truckId;//车辆id

	@ApiModelProperty(value = "车架号")
	private String truckIdentificationNo;//车架号

	@ApiModelProperty(value = "车架号")
	private String plateNumber;//车架号

	@ApiModelProperty(value = "承运商id")
	private Integer vendorId;//承运商id

	@ApiModelProperty(value = "承运商名称")
	private String vendorName;//承运商名称

	@ApiModelProperty(value = "承运商联系电话")
	private String contactPhone;//承运商联系电话

	@ApiModelProperty(value = "司机id")
	private Integer driverId;//司机id

	@ApiModelProperty(value = "箱型id")
	private Integer vehicleBoxType;//箱型id

	@ApiModelProperty(value = "箱长id")
	private Integer vehicleBoxLength;//箱长id

	@ApiModelProperty(value = "箱型名称")
	private String vehicleBoxName;//箱型名称

	@ApiModelProperty(value = "司机名称")
	private String driverName;//司机名称

	@ApiModelProperty(value = "司机手机")
	private String driverPhone;//司机手机

	@ApiModelProperty(value = "车辆类型")
	private Integer vehicleRunType;//车辆类型

	@ApiModelProperty(value = "车辆业务类型")
	private String truckAreaCode;//车辆业务类型

	@ApiModelProperty(value = "车辆业务类型名称")
	private String truckAreaCodeName;//车辆业务类型名称

	@ApiModelProperty(value = "运力状态 0:无效  1:有效")
	private Integer capacityPoolStatus;//运力状态'0:无效  1:有效'

	@ApiModelProperty(value = "创建时间")
	private Date createTime;//创建时间

	@ApiModelProperty(value = "创建人")
	private Integer createUserId;//创建人

	public Integer getCapacityPoolId() {
		return capacityPoolId;
	}

	public void setCapacityPoolId(Integer capacityPoolId) {
		this.capacityPoolId = capacityPoolId;
	}

	public Integer getTruckId() {
		return truckId;
	}

	public void setTruckId(Integer truckId) {
		this.truckId = truckId;
	}

	public String getTruckIdentificationNo() {
		return truckIdentificationNo;
	}

	public void setTruckIdentificationNo(String truckIdentificationNo) {
		this.truckIdentificationNo = truckIdentificationNo;
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

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public Integer getVehicleBoxType() {
		return vehicleBoxType;
	}

	public void setVehicleBoxType(Integer vehicleBoxType) {
		this.vehicleBoxType = vehicleBoxType;
	}

	public Integer getVehicleBoxLength() {
		return vehicleBoxLength;
	}

	public void setVehicleBoxLength(Integer vehicleBoxLength) {
		this.vehicleBoxLength = vehicleBoxLength;
	}

	public String getVehicleBoxName() {
		return vehicleBoxName;
	}

	public void setVehicleBoxName(String vehicleBoxName) {
		this.vehicleBoxName = vehicleBoxName;
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

	public Integer getVehicleRunType() {
		return vehicleRunType;
	}

	public void setVehicleRunType(Integer vehicleRunType) {
		this.vehicleRunType = vehicleRunType;
	}

	public String getTruckAreaCode() {
		return truckAreaCode;
	}

	public void setTruckAreaCode(String truckAreaCode) {
		this.truckAreaCode = truckAreaCode;
	}

	public Integer getCapacityPoolStatus() {
		return capacityPoolStatus;
	}

	public void setCapacityPoolStatus(Integer capacityPoolStatus) {
		this.capacityPoolStatus = capacityPoolStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public String getTruckAreaCodeName() {
		return truckAreaCodeName;
	}

	public void setTruckAreaCodeName(String truckAreaCodeName) {
		this.truckAreaCodeName = truckAreaCodeName;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
}
