package com.juma.vms.transport.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 功能 :
 * 告知其他系统,车辆目前的状态(告知TSL系统)
 * @author : Bruce(刘正航) 13:58 2019-04-10
 */
@ApiModel("车辆状态")
public class TruckStatusResp implements Serializable {

    @ApiModelProperty("车牌号")
    private String plateNumber;

    @ApiModelProperty("车架号")
    private String truckIdentificationNo;

    @ApiModelProperty("车辆运营类型(1自营,2加盟,3外请,4非自营)")
    private Integer truckRunType;

    @ApiModelProperty("租户车辆状态")
    private List<TruckStatusInfo> statusInfos;

    @ApiModelProperty("车辆状态:可退车(true),不可退车(false)")
    private boolean canReturn;

    @ApiModelProperty("车辆状态描述")
    private String desc;

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

    public Integer getTruckRunType() {
        return truckRunType;
    }

    public void setTruckRunType(Integer truckRunType) {
        this.truckRunType = truckRunType;
    }

    public List<TruckStatusInfo> getStatusInfos() {
        return statusInfos;
    }

    public void setStatusInfos(List<TruckStatusInfo> statusInfos) {
        this.statusInfos = statusInfos;
    }

    public boolean isCanReturn() {
        return canReturn;
    }

    public void setCanReturn(boolean canReturn) {
        this.canReturn = canReturn;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
