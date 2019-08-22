package com.juma.vms.vendor.vo;

import java.io.Serializable;

import com.juma.vms.vendor.domain.VendorVehicle;

/**
 * @ClassName VendorVehicleQuery.java
 * @Description 承运商车辆查询
 * @author Libin.Wei
 * @Date 2018年11月2日 上午9:59:51
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

public class VendorVehicleQuery implements Serializable {

    private VendorVehicle vendorVehicle;
    private String plateNumber;
    private String frameNo;
    private String brand;
    private String vehicleBoxTypeName;
    private String vehicleBoxLengthName;

    public VendorVehicle getVendorVehicle() {
        return vendorVehicle;
    }

    public void setVendorVehicle(VendorVehicle vendorVehicle) {
        this.vendorVehicle = vendorVehicle;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getFrameNo() {
        return frameNo;
    }

    public void setFrameNo(String frameNo) {
        this.frameNo = frameNo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVehicleBoxTypeName() {
        return vehicleBoxTypeName;
    }

    public void setVehicleBoxTypeName(String vehicleBoxTypeName) {
        this.vehicleBoxTypeName = vehicleBoxTypeName;
    }

    public String getVehicleBoxLengthName() {
        return vehicleBoxLengthName;
    }

    public void setVehicleBoxLengthName(String vehicleBoxLengthName) {
        this.vehicleBoxLengthName = vehicleBoxLengthName;
    }

}
