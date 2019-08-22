package com.juma.vms.transport.request;

import java.io.Serializable;

import com.juma.vms.driver.domain.Driver;
import com.juma.vms.driver.domain.DriverTenant;
import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.domain.VendorTenant;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-22 14:17
 **/
public class AddVendorAndDriverReq implements Serializable{

	private Vendor vendor;

	private VendorTenant vendorTenant;

	private Driver driver;

	private DriverTenant driverTenant;

	@ApiModelProperty(value = "是否绑定司机")
	private boolean isBindDriver;

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public VendorTenant getVendorTenant() {
		return vendorTenant;
	}

	public void setVendorTenant(VendorTenant vendorTenant) {
		this.vendorTenant = vendorTenant;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public DriverTenant getDriverTenant() {
		return driverTenant;
	}

	public void setDriverTenant(DriverTenant driverTenant) {
		this.driverTenant = driverTenant;
	}

	public boolean isBindDriver() {
		return isBindDriver;
	}

	public void setBindDriver(boolean bindDriver) {
		isBindDriver = bindDriver;
	}
}
