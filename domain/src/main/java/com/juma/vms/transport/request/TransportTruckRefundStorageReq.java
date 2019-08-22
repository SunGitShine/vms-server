package com.juma.vms.transport.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 功能 :
 *
 * @author : Bruce(刘正航) 22:15 2019-04-09
 */
@ApiModel("运力退回单-退库")
public class TransportTruckRefundStorageReq implements Serializable {
    @ApiModelProperty("运力退回单ID")
    private Integer refundId;

    public Integer getRefundId() {
        return refundId;
    }

    public void setRefundId(Integer refundId) {
        this.refundId = refundId;
    }

}
