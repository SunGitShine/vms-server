package com.juma.vms.transport.response;

import java.io.Serializable;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-26 17:33
 **/
public class DepartmentResp implements Serializable{

	private Integer departmentId;
	private Integer parentDepartmentId;
	private Integer tenantId;
	private String tenantName;
	private String tenantCode;
	private Integer businessLineId;
	private String departmentCode;
	private String departmentName;
	private String erpCompany;
	private boolean isCompany;
	private boolean isLeaf;
	private Integer orderNo;
	private String departmentFunction;
	private String organizationCode;

	public String getDepartmentFunction() {
		return this.departmentFunction;
	}

	public void setDepartmentFunction(String departmentFunction) {
		this.departmentFunction = departmentFunction;
	}

	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getParentDepartmentId() {
		return this.parentDepartmentId;
	}

	public void setParentDepartmentId(Integer parentDepartmentId) {
		this.parentDepartmentId = parentDepartmentId;
	}

	public Integer getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantCode() {
		return this.tenantCode;
	}

	public void setTenantCode(String tenantCode) {
		this.tenantCode = tenantCode;
	}

	public Integer getBusinessLineId() {
		return this.businessLineId;
	}

	public void setBusinessLineId(Integer businessLineId) {
		this.businessLineId = businessLineId;
	}

	public String getDepartmentCode() {
		return this.departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getErpCompany() {
		return this.erpCompany;
	}

	public void setErpCompany(String erpCompany) {
		this.erpCompany = erpCompany;
	}

	public boolean isCompany() {
		return this.isCompany;
	}

	public void setCompany(boolean isCompany) {
		this.isCompany = isCompany;
	}

	public boolean isLeaf() {
		return this.isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public Integer getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrganizationCode() {
		return this.organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
}
