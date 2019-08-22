package com.juma.vms.mq.domain;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * 功能 : 
 *
 * @author : Bruce(刘正航) 13:46 2019-05-17
 */
@ApiModel("司机更新事件")
public class DriverUpdateEvent implements Serializable {
    /**司机ID**/
    private Integer driverId;
    /**司机电话**/
    private String phone;
    /**司机对应的jumaPin**/
    private String jumaPin;
    /**司机身份证号**/
    private String idCardNo;
    /**更新原因**/
    private String reason;

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJumaPin() {
        return jumaPin;
    }

    public void setJumaPin(String jumaPin) {
        this.jumaPin = jumaPin;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
