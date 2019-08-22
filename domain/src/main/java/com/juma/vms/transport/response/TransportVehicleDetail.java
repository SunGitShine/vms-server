package com.juma.vms.transport.response;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-25 16:04
 **/
public class TransportVehicleDetail implements Serializable {

	@ApiModelProperty(value = "车辆id")
	private Integer vehicleId;

	@ApiModelProperty(value = "车牌号")
	private String plateNumber;

	@ApiModelProperty(value = "车架号")
	private String truckIdentificationNo;

	@ApiModelProperty(value = "箱型名称")
	private String vehicleBoxName;//箱型名称

	@ApiModelProperty(value = "箱型")
	private Integer vehicleBoxType;

	@ApiModelProperty(value = "箱长")
	private Integer boxLength;

	@ApiModelProperty(value = "证件号")
	private String crmIdentityCardNo;

	@ApiModelProperty(value = "客户名称")
	private String crmCustomerName;

	@ApiModelProperty(value = "联系人手机")
	private String crmMobileNumber;

	@ApiModelProperty(value = "车辆业务类型")
	private String areaCode;//车辆业务类型

	@ApiModelProperty(value = "车辆业务类型名称")
	private String truckAreaCodeName;//车辆业务类型

	@ApiModelProperty(value = "车辆类型")
	private Integer truckType;

	@ApiModelProperty(value = "资产类型，1、待整备，2、整备完成，3、自营，4、加盟，5、已过户")
	private Integer propertyType;

	@ApiModelProperty(value = "库存类型，1、在中心库，2、在途，3、在市场库，4、已出库")
	private Integer inventoryType;

	@ApiModelProperty(value = "运力池状态 0：无，1；有")
	private Integer capacityPoolStatus;

	@ApiModelProperty(value = "认领状态，0：未认领，1：有认领")
	private Integer claimStatus;

	@ApiModelProperty(value = "是否有在审核中的单据，0：无，1：有")
	private Integer receiptsStatus;

	@ApiModelProperty(value = "车辆所有权信用代码")
	private String vehicleCreditCode;

	@ApiModelProperty(value = "接收方经营主体信用代码")
	private String toDepartmentCreditCode;


	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
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

	public String getVehicleBoxName() {
		return vehicleBoxName;
	}

	public void setVehicleBoxName(String vehicleBoxName) {
		this.vehicleBoxName = vehicleBoxName;
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

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public Integer getTruckType() {
		return truckType;
	}

	public void setTruckType(Integer truckType) {
		this.truckType = truckType;
	}

	public String getTruckAreaCodeName() {
		return truckAreaCodeName;
	}

	public void setTruckAreaCodeName(String truckAreaCodeName) {
		this.truckAreaCodeName = truckAreaCodeName;
	}

	public Integer getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(Integer propertyType) {
		this.propertyType = propertyType;
	}

	public Integer getInventoryType() {
		return inventoryType;
	}

	public void setInventoryType(Integer inventoryType) {
		this.inventoryType = inventoryType;
	}

	public Integer getCapacityPoolStatus() {
		return capacityPoolStatus;
	}

	public void setCapacityPoolStatus(Integer capacityPoolStatus) {
		this.capacityPoolStatus = capacityPoolStatus;
	}

	public Integer getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(Integer claimStatus) {
		this.claimStatus = claimStatus;
	}

	public Integer getReceiptsStatus() {
		return receiptsStatus;
	}

	public void setReceiptsStatus(Integer receiptsStatus) {
		this.receiptsStatus = receiptsStatus;
	}

	public Integer getVehicleBoxType() {
		return vehicleBoxType;
	}

	public void setVehicleBoxType(Integer vehicleBoxType) {
		this.vehicleBoxType = vehicleBoxType;
	}

	public Integer getBoxLength() {
		return boxLength;
	}

	public void setBoxLength(Integer boxLength) {
		this.boxLength = boxLength;
	}

	public String getVehicleCreditCode() {
		return vehicleCreditCode;
	}

	public void setVehicleCreditCode(String vehicleCreditCode) {
		this.vehicleCreditCode = vehicleCreditCode;
	}

	public String getToDepartmentCreditCode() {
		return toDepartmentCreditCode;
	}

	public void setToDepartmentCreditCode(String toDepartmentCreditCode) {
		this.toDepartmentCreditCode = toDepartmentCreditCode;
	}
}
