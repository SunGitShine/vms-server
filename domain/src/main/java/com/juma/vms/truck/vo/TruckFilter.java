package com.juma.vms.truck.vo;

import com.juma.vms.truck.domain.Truck;

import java.io.Serializable;
import java.util.List;

/**
 * 功能 :
 *
 * @author : Bruce(刘正航) 16:37 2019-06-24
 */
public class TruckFilter extends Truck implements Serializable {

    private List<Integer> truckIds;

    public List<Integer> getTruckIds() {
        return truckIds;
    }

    public void setTruckIds(List<Integer> truckIds) {
        this.truckIds = truckIds;
    }
}
