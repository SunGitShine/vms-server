package com.juma.vms.transport.response;

import java.io.Serializable;

import com.juma.auth.employee.domain.Department;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-06-20 14:18
 **/
public class ParentDepartment extends Department implements Serializable{

	private String parentDepartmentName;

	public String getParentDepartmentName() {
		return parentDepartmentName;
	}

	public void setParentDepartmentName(String parentDepartmentName) {
		this.parentDepartmentName = parentDepartmentName;
	}
}
