package com.juma.vms.tool.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 功能 :
 *
 * @author : Bruce(刘正航) 20:12 2019-04-15
 */
@ApiModel("客户信息")
public class CrmCustomerInfo implements Serializable {
    @ApiModelProperty(value = "客户ID")
    private Integer crmCustomerId;
    @ApiModelProperty(value = "客户名称")
    private String crmCustomerName;
    @ApiModelProperty(value = "客户类型(个人/公司)")
    private Integer crmCustomerType;
    @ApiModelProperty(value = "客户联系电话(个人/空)")
    private String crmMobileNumber;
    @ApiModelProperty(value = "客户证件号:身份证/社会信用代码")
    private String crmIdentityCardNo;
    @ApiModelProperty(value = "业务范围")
    private String areaCode;
    @ApiModelProperty(value = "证件正面")
    private String crmIdentityCardFace;
    @ApiModelProperty(value = "证件反面")
    private String crmIdentityCardBack;

    public Integer getCrmCustomerId() {
        return crmCustomerId;
    }

    public void setCrmCustomerId(Integer crmCustomerId) {
        this.crmCustomerId = crmCustomerId;
    }

    public String getCrmCustomerName() {
        return crmCustomerName;
    }

    public void setCrmCustomerName(String crmCustomerName) {
        this.crmCustomerName = crmCustomerName;
    }

    public Integer getCrmCustomerType() {
        return crmCustomerType;
    }

    public void setCrmCustomerType(Integer crmCustomerType) {
        this.crmCustomerType = crmCustomerType;
    }

    public String getCrmMobileNumber() {
        return crmMobileNumber;
    }

    public void setCrmMobileNumber(String crmMobileNumber) {
        this.crmMobileNumber = crmMobileNumber;
    }

    public String getCrmIdentityCardNo() {
        return crmIdentityCardNo;
    }

    public void setCrmIdentityCardNo(String crmIdentityCardNo) {
        this.crmIdentityCardNo = crmIdentityCardNo;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getCrmIdentityCardFace() {
        return crmIdentityCardFace;
    }

    public void setCrmIdentityCardFace(String crmIdentityCardFace) {
        this.crmIdentityCardFace = crmIdentityCardFace;
    }

    public String getCrmIdentityCardBack() {
        return crmIdentityCardBack;
    }

    public void setCrmIdentityCardBack(String crmIdentityCardBack) {
        this.crmIdentityCardBack = crmIdentityCardBack;
    }
}
