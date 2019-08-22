package com.juma.vms.transport.response;

import java.io.Serializable;

import com.juma.vms.driver.vo.DriverBo;
import com.juma.vms.driver.vo.DriverQuery;
import com.juma.vms.truck.domain.bo.TruckResp;
import com.juma.vms.vendor.vo.VendorQuery;
import io.swagger.annotations.ApiModel;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-22 10:27
 **/
@ApiModel(value = "运力详情")
public class TransportDetailResp implements Serializable{

	private TruckResp truckResp;

	private VendorQuery vendorQuery;

	private DriverQuery driverQuery;

	public TruckResp getTruckResp() {
		return truckResp;
	}

	public void setTruckResp(TruckResp truckResp) {
		this.truckResp = truckResp;
	}

	public VendorQuery getVendorQuery() {
		return vendorQuery;
	}

	public void setVendorQuery(VendorQuery vendorQuery) {
		this.vendorQuery = vendorQuery;
	}

	public DriverQuery getDriverQuery() {
		return driverQuery;
	}

	public void setDriverQuery(DriverQuery driverQuery) {
		this.driverQuery = driverQuery;
	}
}
