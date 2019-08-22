package com.juma.vms.transport.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-22 11:23
 **/
@ApiModel
public class TransportReceivePageReq implements Serializable{

	@ApiModelProperty(value = "车牌号")
	private String plateNumber;

	@ApiModelProperty(value = "车架号")
	private String truckIdentificationNo;

	/**
	 * crm客户id
	 */
	@ApiModelProperty(value = "crm客户id")
	private Integer crmCustomerId;

	/**
	 * 输送公司
	 */
	@ApiModelProperty(value = "输送部门")
	private Integer fromDepartmentId;

	/**
	 * 接收公司
	 */
	@ApiModelProperty(value = "接收部门")
	private Integer toDepartmentId;

	/**
	 * 接收公司code
	 */
	@ApiModelProperty(value = "接收部门code")
	private String toDepartmentCode;

	/**
	 * 接收状态0:未接收  1:已接收
	 */
	@ApiModelProperty(value = "接收状态0:未接收  1:已接收")
	private Integer receiveStatus;

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

	public Integer getCrmCustomerId() {
		return crmCustomerId;
	}

	public void setCrmCustomerId(Integer crmCustomerId) {
		this.crmCustomerId = crmCustomerId;
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

	public Integer getReceiveStatus() {
		return receiveStatus;
	}

	public void setReceiveStatus(Integer receiveStatus) {
		this.receiveStatus = receiveStatus;
	}

	public String getToDepartmentCode() {
		return toDepartmentCode;
	}

	public void setToDepartmentCode(String toDepartmentCode) {
		this.toDepartmentCode = toDepartmentCode;
	}
}
