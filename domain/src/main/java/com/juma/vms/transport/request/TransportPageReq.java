package com.juma.vms.transport.request;

import java.io.Serializable;
import java.util.List;

import com.juma.vms.transport.domain.CapacityPool;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-29 11:50
 **/
public class TransportPageReq extends CapacityPool implements Serializable{

	private Integer truckType;

	private List<String> areaCodeList;

	public Integer getTruckType() {
		return truckType;
	}

	public void setTruckType(Integer truckType) {
		this.truckType = truckType;
	}

	public List<String> getAreaCodeList() {
		return areaCodeList;
	}

	public void setAreaCodeList(List<String> areaCodeList) {
		this.areaCodeList = areaCodeList;
	}
}
