package com.juma.vms.mq.domain;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * 功能 : 
 *
 * @author : Bruce(刘正航) 13:43 2019-05-17
 */
@ApiModel("车辆更新事件")
public class TruckUpdateEvent implements Serializable {
    /**卡车ID**/
    private Integer truckId;
    /**车牌号**/
    private String plateNumber;
    /**车架号**/
    private String truckIdentificationNo;
    /**更新原因**/
    private String reason;

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
