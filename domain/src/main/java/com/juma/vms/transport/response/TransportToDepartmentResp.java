package com.juma.vms.transport.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 功能 :
 *
 * @author : Bruce(刘正航) 09:25 2019-03-25
 */
@ApiModel(value = "接收公司下拉列表")
public class TransportToDepartmentResp implements Serializable {

    @ApiModelProperty(value = "输送公司ID")
    private Integer deliveryDepartmentId;

    @ApiModelProperty(value = "输送公司ID")
    private String deliveryDepartmentName;

    @ApiModelProperty(value = "输送公司对应子租户名称")
    private String deliveryDepartmentSubTenantName;

    public Integer getDeliveryDepartmentId() {
        return deliveryDepartmentId;
    }

    public void setDeliveryDepartmentId(Integer deliveryDepartmentId) {
        this.deliveryDepartmentId = deliveryDepartmentId;
    }

    public String getDeliveryDepartmentName() {
        return deliveryDepartmentName;
    }

    public void setDeliveryDepartmentName(String deliveryDepartmentName) {
        this.deliveryDepartmentName = deliveryDepartmentName;
    }

    public String getDeliveryDepartmentSubTenantName() {
        return deliveryDepartmentSubTenantName;
    }

    public void setDeliveryDepartmentSubTenantName(String deliveryDepartmentSubTenantName) {
        this.deliveryDepartmentSubTenantName = deliveryDepartmentSubTenantName;
    }
}
