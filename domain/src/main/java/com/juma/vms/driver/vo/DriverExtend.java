package com.juma.vms.driver.vo;

import com.juma.vms.driver.domain.Driver;

import java.io.Serializable;

/**
 * 功能 :
 *
 * @author : Bruce(刘正航) 16:48 2019-06-24
 */
public class DriverExtend implements Serializable {
    private static final long serialVersionUID = 1L;
    /**司机信息**/
    private Driver driver;
    /**司机所在租户ID**/
    private Integer tenentId;
    /**车辆ID**/
    private Integer truckId;
    /**车牌号**/
    private String plateNumber;
    /**车架号**/
    private String truckIdentificationNo;

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Integer getTenentId() {
        return tenentId;
    }

    public void setTenentId(Integer tenentId) {
        this.tenentId = tenentId;
    }

    public Integer getTruckId() {
        return truckId;
    }

    public void setTruckId(Integer truckId) {
        this.truckId = truckId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getTruckIdentificationNo() {
        return truckIdentificationNo;
    }

    public void setTruckIdentificationNo(String truckIdentificationNo) {
        this.truckIdentificationNo = truckIdentificationNo;
    }
}
