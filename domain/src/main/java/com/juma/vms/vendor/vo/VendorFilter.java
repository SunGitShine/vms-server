package com.juma.vms.vendor.vo;

import com.juma.vms.vendor.domain.Vendor;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

public class VendorFilter extends Vendor {

    private String vendorNameOrPhone;
    // 证件号
    private String credentialNo;
    private Integer tenantId;
    private Byte isOwner;
    private Byte isEnable;
    private List<String> areaCodeList = new ArrayList<>();

    // 列表页查询需要支持全模糊，不能直接使用联系人姓名、联系电话、证件号条件查询，为了支持页面，需要这几个条件转为vendorId
    @ApiModelProperty("联系人姓名查询条件转vendorId")
    private Integer contactUserNameToVendorId;
    @ApiModelProperty("联系电话查询条件转vendorId")
    private Integer emergencyContactPhoneToVendorId;
    @ApiModelProperty("证件号查询条件转vendorId")
    private Integer credentialNoToVendorId;

    public String getVendorNameOrPhone() {
        return vendorNameOrPhone;
    }

    public void setVendorNameOrPhone(String vendorNameOrPhone) {
        this.vendorNameOrPhone = vendorNameOrPhone;
    }

    public String getCredentialNo() {
        return credentialNo;
    }

    public void setCredentialNo(String credentialNo) {
        this.credentialNo = credentialNo;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public Byte getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(Byte isOwner) {
        this.isOwner = isOwner;
    }

    public Byte getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Byte isEnable) {
        this.isEnable = isEnable;
    }

    public List<String> getAreaCodeList() {
        return areaCodeList;
    }

    public void setAreaCodeList(List<String> areaCodeList) {
        this.areaCodeList = areaCodeList;
    }

    public Integer getContactUserNameToVendorId() {
        return contactUserNameToVendorId;
    }

    public void setContactUserNameToVendorId(Integer contactUserNameToVendorId) {
        this.contactUserNameToVendorId = contactUserNameToVendorId;
    }

    public Integer getEmergencyContactPhoneToVendorId() {
        return emergencyContactPhoneToVendorId;
    }

    public void setEmergencyContactPhoneToVendorId(Integer emergencyContactPhoneToVendorId) {
        this.emergencyContactPhoneToVendorId = emergencyContactPhoneToVendorId;
    }

    public Integer getCredentialNoToVendorId() {
        return credentialNoToVendorId;
    }

    public void setCredentialNoToVendorId(Integer credentialNoToVendorId) {
        this.credentialNoToVendorId = credentialNoToVendorId;
    }
}
