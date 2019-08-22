package com.juma.vms.transport.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 功能 :
 *
 * @author : Bruce(刘正航) 15:53 2019-04-10
 */
@ApiModel("租户卡车状态信息")
public class TruckStatusInfo implements Serializable {
    @ApiModelProperty("租户ID")
    private Integer tenantId;
    @ApiModelProperty("该租户下车辆状态")
    private String statusDesc;
    @ApiModelProperty(value = "车牌号")
    private String plateNumber;
    @ApiModelProperty(value = "车架号")
    private String truckIdentificationNo;
    @ApiModelProperty(value = "运营类型  1自营2加盟3外请")
    private Integer truckRunType;

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
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

    public Integer getTruckRunType() {
        return truckRunType;
    }

    public void setTruckRunType(Integer truckRunType) {
        this.truckRunType = truckRunType;
    }
}
