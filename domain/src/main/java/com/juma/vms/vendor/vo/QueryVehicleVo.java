package com.juma.vms.vendor.vo;

import java.io.Serializable;

/**
 * @ClassName QueryVehicleVo.java
 * @Description 请填写注释...
 * @author Libin.Wei
 * @Date 2018年11月6日 下午3:33:21
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

public class QueryVehicleVo implements Serializable {

    private Integer vehicleId;
    private String plateNumber;
    private String vehicleFrameNo;

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getVehicleFrameNo() {
        return vehicleFrameNo;
    }

    public void setVehicleFrameNo(String vehicleFrameNo) {
        this.vehicleFrameNo = vehicleFrameNo;
    }

}
