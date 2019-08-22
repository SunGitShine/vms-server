package com.juma.vms.transport.request;

import java.io.Serializable;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-04-12 15:54
 **/
public class SelectVehicleReq implements Serializable{

	private String truckIdentificationNo;

	private String fromDepartmentCode;

	private Integer receiveTenantId;

	private Integer toDepartmentId;

	public String getTruckIdentificationNo() {
		return truckIdentificationNo;
	}

	public void setTruckIdentificationNo(String truckIdentificationNo) {
		this.truckIdentificationNo = truckIdentificationNo;
	}

	public String getFromDepartmentCode() {
		return fromDepartmentCode;
	}

	public void setFromDepartmentCode(String fromDepartmentCode) {
		this.fromDepartmentCode = fromDepartmentCode;
	}

	public Integer getReceiveTenantId() {
		return receiveTenantId;
	}

	public void setReceiveTenantId(Integer receiveTenantId) {
		this.receiveTenantId = receiveTenantId;
	}

	public Integer getToDepartmentId() {
		return toDepartmentId;
	}

	public void setToDepartmentId(Integer toDepartmentId) {
		this.toDepartmentId = toDepartmentId;
	}
}
