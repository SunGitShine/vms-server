package com.juma.vms.transport.external;

import java.io.Serializable;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-06-20 10:50
 **/
public class TenantInfo implements Serializable{

	//接收方租户id
	private Integer tenantId;
	//接收方租户code
	private String tenantCode;
	//接收方租户名称
	private String tenantName;

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

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
}
