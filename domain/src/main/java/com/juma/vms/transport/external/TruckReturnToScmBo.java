package com.juma.vms.transport.external;

import java.io.Serializable;
import java.util.List;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-06-20 09:58
 **/
public class TruckReturnToScmBo implements Serializable{

	private List<TruckReturn> goodsList;

	private String systemName = "vms";

	private TenantInfo tenantInfo;

	private ConsigneeDepartmentInfo consigneeDepartmentInfo;

	public List<TruckReturn> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<TruckReturn> goodsList) {
		this.goodsList = goodsList;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public TenantInfo getTenantInfo() {
		return tenantInfo;
	}

	public void setTenantInfo(TenantInfo tenantInfo) {
		this.tenantInfo = tenantInfo;
	}

	public ConsigneeDepartmentInfo getConsigneeDepartmentInfo() {
		return consigneeDepartmentInfo;
	}

	public void setConsigneeDepartmentInfo(ConsigneeDepartmentInfo consigneeDepartmentInfo) {
		this.consigneeDepartmentInfo = consigneeDepartmentInfo;
	}
}
