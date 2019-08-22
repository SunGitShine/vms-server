package com.juma.vms.transport.response;

import java.io.Serializable;

import com.juma.vms.driver.domain.Driver;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-04-03 17:07
 **/
public class DriverBeCurrResp implements Serializable{

	private Driver driver;

	private boolean beCurrDriver;

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public boolean isBeCurrDriver() {
		return beCurrDriver;
	}

	public void setBeCurrDriver(boolean beCurrDriver) {
		this.beCurrDriver = beCurrDriver;
	}
}
