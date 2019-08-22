package com.juma.vms.vendor.external;

import com.juma.vms.vendor.domain.Vendor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VendorExternalFilter implements Serializable {

    private String vendorName;
    private String contactPhone;
    // 证件号
    private String credentialNo;
    private List<String> areaCodeList = new ArrayList<>();

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getCredentialNo() {
        return credentialNo;
    }

    public void setCredentialNo(String credentialNo) {
        this.credentialNo = credentialNo;
    }

    public List<String> getAreaCodeList() {
        return areaCodeList;
    }

    public void setAreaCodeList(List<String> areaCodeList) {
        this.areaCodeList = areaCodeList;
    }
}
