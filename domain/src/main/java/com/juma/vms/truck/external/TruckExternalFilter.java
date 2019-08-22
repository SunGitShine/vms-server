package com.juma.vms.truck.external;

import java.io.Serializable;

public class TruckExternalFilter implements Serializable {

    // 车牌号
    private String plateNumber;
    // 车架号
    private String truckIdentificationNo;

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
