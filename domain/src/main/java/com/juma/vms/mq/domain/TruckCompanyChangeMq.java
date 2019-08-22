package com.juma.vms.mq.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-04-19 10:24
 **/
public class TruckCompanyChangeMq implements Serializable{

	/** 租户ID */
	private Integer tenantId;

	/** 租户Code */
	private String tenantCode;

	/** 车辆id */
	private Integer vehicleId;

	/** 车架号 */
	private String vehicleFrameNo;

	/**操作人id**/
	private Integer userId;

	/**部门code**/
	private String departmentCode;

	/**部门id**/
	private Integer departmentId;

	/**输送单号**/
	private String transportNo;

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantCode() {
		return tenantCode;
	}

	public void setTenantCode(String tenantCode) {
		this.tenantCode = tenantCode;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getVehicleFrameNo() {
		return vehicleFrameNo;
	}

	public void setVehicleFrameNo(String vehicleFrameNo) {
		this.vehicleFrameNo = vehicleFrameNo;
	}

	public String getTransportNo() {
		return transportNo;
	}

	public void setTransportNo(String transportNo) {
		this.transportNo = transportNo;
	}
}
