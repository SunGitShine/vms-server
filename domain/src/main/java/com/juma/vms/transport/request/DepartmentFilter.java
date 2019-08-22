package com.juma.vms.transport.request;

import java.io.Serializable;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-04-01 18:33
 **/
public class DepartmentFilter implements Serializable {
	private Integer departmentId;
	private String departmentCode;
	private String departmentName;
	private Integer tenantId;

	public DepartmentFilter() {
	}

	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public String getDepartmentCode() {
		return this.departmentCode;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public Integer getTenantId() {
		return this.tenantId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

}
