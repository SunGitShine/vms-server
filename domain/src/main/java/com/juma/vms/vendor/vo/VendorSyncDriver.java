package com.juma.vms.vendor.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName VendorSyncDriver.java
 * @Description 同步为司机必填信息
 * @author Libin.Wei
 * @Date 2018年11月6日 下午2:09:58
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

@Deprecated
public class VendorSyncDriver implements Serializable {

    private Byte driverType;
    private Byte canDriveType;
    private Date driveLicenseEndTime;
    private String driveLicenseImg;

    public Byte getDriverType() {
        return driverType;
    }

    public void setDriverType(Byte driverType) {
        this.driverType = driverType;
    }

    public Byte getCanDriveType() {
        return canDriveType;
    }

    public void setCanDriveType(Byte canDriveType) {
        this.canDriveType = canDriveType;
    }

    public Date getDriveLicenseEndTime() {
        return driveLicenseEndTime;
    }

    public void setDriveLicenseEndTime(Date driveLicenseEndTime) {
        this.driveLicenseEndTime = driveLicenseEndTime;
    }

    public String getDriveLicenseImg() {
        return driveLicenseImg;
    }

    public void setDriveLicenseImg(String driveLicenseImg) {
        this.driveLicenseImg = driveLicenseImg;
    }
}
