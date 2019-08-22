package com.juma.vms.transport.request;

import java.io.Serializable;

import com.juma.vms.truck.domain.Truck;
import com.juma.vms.truck.vo.TruckBo;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-20 15:35
 **/
public class AddExternalTransportReq implements Serializable{

	private TruckBo truckBo;

	@ApiModelProperty(value = "承运商id")
	private Integer vendorId;

	@ApiModelProperty(value = "司机id")
	private Integer driverId;

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public TruckBo getTruckBo() {
		return truckBo;
	}

	public void setTruckBo(TruckBo truckBo) {
		this.truckBo = truckBo;
	}
}
