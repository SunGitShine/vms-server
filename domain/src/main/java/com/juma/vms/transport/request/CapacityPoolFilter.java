package com.juma.vms.transport.request;

import com.juma.vms.transport.domain.CapacityPool;

import java.util.List;

public class CapacityPoolFilter extends CapacityPool {

    private List<String> areaCodeList;
    private List<Integer> driverIds;

    public List<String> getAreaCodeList() {
        return areaCodeList;
    }

    public void setAreaCodeList(List<String> areaCodeList) {
        this.areaCodeList = areaCodeList;
    }

    public List<Integer> getDriverIds() {
        return driverIds;
    }

    public void setDriverIds(List<Integer> driverIds) {
        this.driverIds = driverIds;
    }
}
