package com.juma.vms.vendor.vo;

import com.juma.vms.vendor.domain.Vendor;

import java.io.Serializable;

public class VendorIdentification implements Serializable {

    // 承运商ID
    private Integer vendorId;
    // 承运商类型（枚举vendorTypeEnum）
    private Integer vendorType;
    // 承运商名称
    private String  vendorName;
    // 身份证号
    private String idCardNo;
    // 企业社会信用代码
    private String enterpriseCode;
    // 身份证正面
    private String idCardImg1;
    // 身份证反面
    private String idCardImg2;

    public VendorIdentification() {
    }

    public VendorIdentification(Vendor vendor) {
        if (null == vendor) {
            return;
        }
        this.vendorId = vendor.getVendorId();
        this.vendorType = vendor.getVendorType().intValue();
        this.vendorName = vendor.getVendorName();
        this.idCardNo = vendor.getIdCardNo();
        this.enterpriseCode = vendor.getEnterpriseCode();
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getVendorType() {
        return vendorType;
    }

    public void setVendorType(Integer vendorType) {
        this.vendorType = vendorType;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    public String getIdCardImg1() {
        return idCardImg1;
    }

    public void setIdCardImg1(String idCardImg1) {
        this.idCardImg1 = idCardImg1;
    }

    public String getIdCardImg2() {
        return idCardImg2;
    }

    public void setIdCardImg2(String idCardImg2) {
        this.idCardImg2 = idCardImg2;
    }
}
