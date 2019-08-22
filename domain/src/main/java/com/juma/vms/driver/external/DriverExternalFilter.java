package com.juma.vms.driver.external;

import java.io.Serializable;
import java.util.List;

/**
 * 司机外部接口使用的接收参数
 */

public class DriverExternalFilter implements Serializable {

    /**司机姓名**/
    private String name;
    /**司机手机号**/
    private String phone;
    /**车架号**/
    private String truckIdentificationNo;
    private List<Integer> driverIds;
    /**返回的数据条数**/
    private Integer size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTruckIdentificationNo() {
        return truckIdentificationNo;
    }

    public void setTruckIdentificationNo(String truckIdentificationNo) {
        this.truckIdentificationNo = truckIdentificationNo;
    }

    public List<Integer> getDriverIds() {
        return driverIds;
    }

    public void setDriverIds(List<Integer> driverIds) {
        this.driverIds = driverIds;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
