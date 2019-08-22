package com.juma.vms.driver.vo;

import java.io.Serializable;

public class DriverIdentification implements Serializable {

    private Integer driverId;
    private String name;
    private String idCardNo;
    // 身份正正面
    private String idCardImg1;
    // 身份证反面
    private String idCardImg2;

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getIdCardImg1() {
        return idCardImg1;
    }

    public void setIdCardImg1(String idCardImg1) {
        this.idCardImg1 = idCardImg1;
    }

    public String getIdCardImg2() {
        return idCardImg2;
    }

    public void setIdCardImg2(String idCardImg2) {
        this.idCardImg2 = idCardImg2;
    }
}
