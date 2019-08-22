package com.juma.vms.transport.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-22 14:28
 **/
@ApiModel("完善运力参数")
public class CompleteTransportReq implements Serializable{

	@ApiModelProperty(value = "运力ID")
	private Integer itemId;

	@ApiModelProperty(value = "承运商id")
	private Integer vendorId;

	@ApiModelProperty(value = "车辆id")
	private Integer truckId;

	@ApiModelProperty(value = "司机id")
	private Integer driverId;

	@ApiModelProperty(value = "租户ID")
	private Integer tenantId;

	@ApiModelProperty(value = "业务区域编码")
	private String areaCode;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public Integer getTruckId() {
		return truckId;
	}

	public void setTruckId(Integer truckId) {
		this.truckId = truckId;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
}
