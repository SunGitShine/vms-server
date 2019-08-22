package com.juma.vms.transport.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 功能 : 
 *
 * @author : Bruce(刘正航) 11:18 2019-05-17
 */
@ApiModel("车辆输送详情")
public class TransportItemFilter implements Serializable {
    @ApiModelProperty("车辆输送ID集合")
    private Integer transportId;
    @ApiModelProperty("车辆输送ID集合")
    private List<Integer> transportIds;
    @ApiModelProperty("车辆输送详情ID")
    private Integer itemId;
    @ApiModelProperty("车辆输送详情ID集合")
    private List<Integer> itemIds;
    @ApiModelProperty("车辆ID集合")
    private List<Integer> truckIds;
    @ApiModelProperty("车辆接收状态:0未接收,1已接收")
    private Integer status;

    public Integer getTransportId() {
        return transportId;
    }

    public void setTransportId(Integer transportId) {
        this.transportId = transportId;
    }

    public List<Integer> getTransportIds() {
        return transportIds;
    }

    public void setTransportIds(List<Integer> transportIds) {
        this.transportIds = transportIds;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public List<Integer> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Integer> itemIds) {
        this.itemIds = itemIds;
    }

    public List<Integer> getTruckIds() {
        return truckIds;
    }

    public void setTruckIds(List<Integer> truckIds) {
        this.truckIds = truckIds;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
