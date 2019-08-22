package com.juma.vms.transport.external;

import java.io.Serializable;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-06-20 10:51
 **/
public class ConsigneeDepartmentInfo implements Serializable{

	//接收方部门id
	private Integer consigneeDepartmentId;

	//接收方部门code
	private String consigneeDepartmentNo;

	//接收方部门名称
	private String consigneeDepartmentName;

	public Integer getConsigneeDepartmentId() {
		return consigneeDepartmentId;
	}

	public void setConsigneeDepartmentId(Integer consigneeDepartmentId) {
		this.consigneeDepartmentId = consigneeDepartmentId;
	}

	public String getConsigneeDepartmentNo() {
		return consigneeDepartmentNo;
	}

	public void setConsigneeDepartmentNo(String consigneeDepartmentNo) {
		this.consigneeDepartmentNo = consigneeDepartmentNo;
	}

	public String getConsigneeDepartmentName() {
		return consigneeDepartmentName;
	}

	public void setConsigneeDepartmentName(String consigneeDepartmentName) {
		this.consigneeDepartmentName = consigneeDepartmentName;
	}
}
