package com.juma.vms.transport.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 功能 :
 *
 * @author : Bruce(刘正航) 09:33 2019-03-25
 */
@ApiModel
public class TransportCustomerReq implements Serializable {
    @ApiModelProperty(value = "客户名称")
    private String crmCustomerName;

    @ApiModelProperty(value = "客户证件号")
    private String crmIdentityCardNo;

    @ApiModelProperty(value = "返回数量")
    private Integer pageSize=10;

    public String getCrmCustomerName() {
        return crmCustomerName;
    }

    public void setCrmCustomerName(String crmCustomerName) {
        this.crmCustomerName = crmCustomerName;
    }

    public String getCrmIdentityCardNo() {
        return crmIdentityCardNo;
    }

    public void setCrmIdentityCardNo(String crmIdentityCardNo) {
        this.crmIdentityCardNo = crmIdentityCardNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
