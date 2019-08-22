package com.juma.vms.vendor.vo;

import com.juma.vms.vendor.enumeration.VendorSourceEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.StringUtils;

import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.enumeration.VendorTypeEnum;

/**
 * @ClassName VendorQuery.java
 * @Description 请填写注释...
 * @author Libin.Wei
 * @Date 2018年10月30日 下午8:15:52
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

@ApiModel(value = "承运商详情")
public class VendorQuery extends Vendor {

    private Integer vendorTenantId;
    @ApiModelProperty(value = "租户ID")
    private Integer tenantId;
    @ApiModelProperty(value = "业务区域编码")
    private String areaCode;
    @ApiModelProperty(value = "司机类型的客户ID")
    private Integer customerId;
    @ApiModelProperty(value = "是否归属方：1、是；0、否")
    private boolean isOwner;
    @ApiModelProperty(value = "业务区域名称")
    private String areaName;
    @ApiModelProperty(value = "承运商类型名称")
    private String vendorTypeDesc;
    @ApiModelProperty(value = "承运商运营类型名称")
    private String vendorSourceDesc;
    private Boolean isEnable;
    @ApiModelProperty(value = "创建方名称")
    private String ownerName;
    @ApiModelProperty(value = "承运商状态名称")
    private String enableName;
    @ApiModelProperty(value = "证件号")
    private String credentialNo;

    public Integer getVendorTenantId() {
        return vendorTenantId;
    }

    public void setVendorTenantId(Integer vendorTenantId) {
        this.vendorTenantId = vendorTenantId;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public boolean getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(boolean owner) {
        isOwner = owner;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getVendorTypeDesc() {
        if (StringUtils.isNotBlank(vendorTypeDesc)) {
            return vendorTypeDesc;
        }

        return VendorTypeEnum.getVendorTypeDesc(super.getVendorType());
    }

    public void setVendorTypeDesc(String vendorTypeDesc) {
        this.vendorTypeDesc = vendorTypeDesc;
    }

    public String getVendorSourceDesc() {
        if (StringUtils.isNotBlank(vendorSourceDesc)) {
            return vendorSourceDesc;
        }

        return VendorSourceEnum.getSourceDesc(super.getVendorSource());
    }

    public void setVendorSourceDesc(String vendorSourceDesc) {
        this.vendorSourceDesc = vendorSourceDesc;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public String getEnableName() {
        if (StringUtils.isNotBlank(enableName)) {
            return enableName;
        }

        return isEnable == null ? "未知" : (isEnable ? "正常" : "已停用");
    }

    public void setEnableName(String enableName) {
        this.enableName = enableName;
    }

    public String getCredentialNo() {
        if (StringUtils.isNotBlank(credentialNo)) {
            return credentialNo;
        }

        if (null != super.getVendorType() && super.getVendorType()== VendorTypeEnum.ENTERPRISE.getCode()) {
            return super.getEnterpriseCode();
        }

        return super.getIdCardNo();
    }

    public void setCredentialNo(String credentialNo) {
        this.credentialNo = credentialNo;
    }
}
