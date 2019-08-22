package com.juma.vms.transport.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 功能 :
 *
 * @author : Bruce(刘正航) 20:09 2019-04-03
 */
@ApiModel
public class TransportTruckRefundTruckReq implements Serializable {

    @ApiModelProperty("车牌号")
    private String plateNumber;

    @ApiModelProperty("每页条数")
    private Integer pageSize=10;

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
