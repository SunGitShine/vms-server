package com.juma.vms.vendor.vo;

import com.juma.vms.vendor.domain.VendorTenant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class VendorTenantBo extends VendorTenant {

    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "客户名称")
    private String crmCustomerName;
    @ApiModelProperty(value = "客户联系电话")
    private String crmCustomerPhone;
    @ApiModelProperty(value = "客户证件号")
    private String crmIdentityCardNo;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCrmCustomerName() {
        return crmCustomerName;
    }

    public void setCrmCustomerName(String crmCustomerName) {
        this.crmCustomerName = crmCustomerName;
    }

    public String getCrmCustomerPhone() {
        return crmCustomerPhone;
    }

    public void setCrmCustomerPhone(String crmCustomerPhone) {
        this.crmCustomerPhone = crmCustomerPhone;
    }

    public String getCrmIdentityCardNo() {
        return crmIdentityCardNo;
    }

    public void setCrmIdentityCardNo(String crmIdentityCardNo) {
        this.crmIdentityCardNo = crmIdentityCardNo;
    }
}
