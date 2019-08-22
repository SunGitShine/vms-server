package com.juma.vms.vendor.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class Vendor implements Serializable {
    @ApiModelProperty(value = "承运商ID")
    private Integer vendorId;
    @ApiModelProperty(value = "承运商名称")
    private String vendorName;
    @ApiModelProperty(value = "juma pin码")
    private String jumaPin;
    @ApiModelProperty(value = "承运商userId")
    private Integer userId;
    @ApiModelProperty(value = "承运商编码")
    private String serialNo;
    @ApiModelProperty(value = "联系人姓名")
    private String contactUserName;
    @ApiModelProperty(value = "联系电话")
    private String contactPhone;
    @ApiModelProperty(value = "紧急联系电话")
    private String emergencyContactPhone;
    @ApiModelProperty(value = "身份证号")
    private String idCardNo;
    @ApiModelProperty(value = "身份证有效期")
    private Date idCardNoExpireTime;
    @ApiModelProperty(value = "税号")
    private String taxNo;
    @ApiModelProperty(value = "承运商来源")
    private Byte source;
    @ApiModelProperty(value = "承运商运营方式")
    private Byte vendorSource;
    @ApiModelProperty(value = "开户银行")
    private String bankOfDeposit;
    @ApiModelProperty(value = "银行卡号")
    private String bankAccount;
    @ApiModelProperty(value = "企业信用代码")
    private String enterpriseCode;
    @ApiModelProperty(value = "从业资格证有效期")
    private Date skillLicenseExpireTime;
    @ApiModelProperty(value = "承运商类型Id")
    private Byte vendorType;
    @ApiModelProperty(value = "身份证正面")
    private String idCardImg1;
    @ApiModelProperty(value = "身份证反面")
    private String idCardImg2;
    @ApiModelProperty(value = "从业资格证正面")
    private String qualityCertImg1;
    @ApiModelProperty(value = "从业资格证反面")
    private String qualityCertImg2;
    @ApiModelProperty(value = "道路运输许可证正面")
    private String roadTransPermitImg1;
    @ApiModelProperty(value = "道路运输许可证反面")
    private String roadTransPermitImg2;
    @ApiModelProperty(value = "营业执照正面")
    private String businessLicenseImg1;
    @ApiModelProperty(value = "营业执照反面")
    private String businessLicenseImg2;
    private String vendorAddress;
    @ApiModelProperty(value = "是否展示司机价格：0、否；1、是")
    private Byte isShowYourPrice;
    @ApiModelProperty(value = "是否已同步为承运商：0、否；1、是")
    private Byte isSyncAsVendor;
    @ApiModelProperty(value = "是否已同步为司机：0、否；1、是")
    private Byte isSyncAsDriver;
    @ApiModelProperty(value = "是否已删除：0、否；1、是")
    private Byte isDelete;
    @ApiModelProperty(value = "是否全局开放：：0、否；1、是")
    private Byte isOpen;
    @ApiModelProperty(value = "承运商备注")
    private String remark;


    private Integer createUserId;

    private Date createTime;

    private Date lastUpdateTime;

    private Integer lastUpdateUserId;

    private static final long serialVersionUID = 1L;

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getJumaPin() {
        return jumaPin;
    }

    public void setJumaPin(String jumaPin) {
        this.jumaPin = jumaPin == null ? null : jumaPin.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName == null ? null : vendorName.trim();
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    public String getContactUserName() {
        return contactUserName;
    }

    public void setContactUserName(String contactUserName) {
        this.contactUserName = contactUserName == null ? null : contactUserName.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone == null ? null : emergencyContactPhone.trim();
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo == null ? null : idCardNo.trim();
    }

    public Date getIdCardNoExpireTime() {
        return idCardNoExpireTime;
    }

    public void setIdCardNoExpireTime(Date idCardNoExpireTime) {
        this.idCardNoExpireTime = idCardNoExpireTime;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo == null ? null : taxNo.trim();
    }

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }

    public Byte getVendorSource() {
        return vendorSource;
    }

    public void setVendorSource(Byte vendorSource) {
        this.vendorSource = vendorSource;
    }

    public String getBankOfDeposit() {
        return bankOfDeposit;
    }

    public void setBankOfDeposit(String bankOfDeposit) {
        this.bankOfDeposit = bankOfDeposit == null ? null : bankOfDeposit.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode == null ? null : enterpriseCode.trim();
    }

    public Date getSkillLicenseExpireTime() {
        return skillLicenseExpireTime;
    }

    public void setSkillLicenseExpireTime(Date skillLicenseExpireTime) {
        this.skillLicenseExpireTime = skillLicenseExpireTime;
    }

    public Byte getVendorType() {
        return vendorType;
    }

    public void setVendorType(Byte vendorType) {
        this.vendorType = vendorType;
    }

    public String getIdCardImg1() {
        return idCardImg1;
    }

    public void setIdCardImg1(String idCardImg1) {
        this.idCardImg1 = idCardImg1 == null ? null : idCardImg1.trim();
    }

    public String getIdCardImg2() {
        return idCardImg2;
    }

    public void setIdCardImg2(String idCardImg2) {
        this.idCardImg2 = idCardImg2 == null ? null : idCardImg2.trim();
    }

    public String getQualityCertImg1() {
        return qualityCertImg1;
    }

    public void setQualityCertImg1(String qualityCertImg1) {
        this.qualityCertImg1 = qualityCertImg1 == null ? null : qualityCertImg1.trim();
    }

    public String getQualityCertImg2() {
        return qualityCertImg2;
    }

    public void setQualityCertImg2(String qualityCertImg2) {
        this.qualityCertImg2 = qualityCertImg2 == null ? null : qualityCertImg2.trim();
    }

    public String getRoadTransPermitImg1() {
        return roadTransPermitImg1;
    }

    public void setRoadTransPermitImg1(String roadTransPermitImg1) {
        this.roadTransPermitImg1 = roadTransPermitImg1 == null ? null : roadTransPermitImg1.trim();
    }

    public String getRoadTransPermitImg2() {
        return roadTransPermitImg2;
    }

    public void setRoadTransPermitImg2(String roadTransPermitImg2) {
        this.roadTransPermitImg2 = roadTransPermitImg2 == null ? null : roadTransPermitImg2.trim();
    }

    public String getBusinessLicenseImg1() {
        return businessLicenseImg1;
    }

    public void setBusinessLicenseImg1(String businessLicenseImg1) {
        this.businessLicenseImg1 = businessLicenseImg1 == null ? null : businessLicenseImg1.trim();
    }

    public String getBusinessLicenseImg2() {
        return businessLicenseImg2;
    }

    public void setBusinessLicenseImg2(String businessLicenseImg2) {
        this.businessLicenseImg2 = businessLicenseImg2 == null ? null : businessLicenseImg2.trim();
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress == null ? null : vendorAddress.trim();
    }

    public Byte getIsShowYourPrice() {
        return isShowYourPrice;
    }

    public void setIsShowYourPrice(Byte isShowYourPrice) {
        this.isShowYourPrice = isShowYourPrice;
    }

    public Byte getIsSyncAsVendor() {
        return isSyncAsVendor;
    }

    public void setIsSyncAsVendor(Byte isSyncAsVendor) {
        this.isSyncAsVendor = isSyncAsVendor;
    }

    public Byte getIsSyncAsDriver() {
        return isSyncAsDriver;
    }

    public void setIsSyncAsDriver(Byte isSyncAsDriver) {
        this.isSyncAsDriver = isSyncAsDriver;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Byte getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Byte isOpen) {
        this.isOpen = isOpen;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(Integer lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Vendor other = (Vendor) that;
        return (this.getVendorId() == null ? other.getVendorId() == null : this.getVendorId().equals(other.getVendorId()))
            && (this.getJumaPin() == null ? other.getJumaPin() == null : this.getJumaPin().equals(other.getJumaPin()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getVendorName() == null ? other.getVendorName() == null : this.getVendorName().equals(other.getVendorName()))
            && (this.getSerialNo() == null ? other.getSerialNo() == null : this.getSerialNo().equals(other.getSerialNo()))
            && (this.getContactUserName() == null ? other.getContactUserName() == null : this.getContactUserName().equals(other.getContactUserName()))
            && (this.getContactPhone() == null ? other.getContactPhone() == null : this.getContactPhone().equals(other.getContactPhone()))
            && (this.getEmergencyContactPhone() == null ? other.getEmergencyContactPhone() == null : this.getEmergencyContactPhone().equals(other.getEmergencyContactPhone()))
            && (this.getIdCardNo() == null ? other.getIdCardNo() == null : this.getIdCardNo().equals(other.getIdCardNo()))
            && (this.getIdCardNoExpireTime() == null ? other.getIdCardNoExpireTime() == null : this.getIdCardNoExpireTime().equals(other.getIdCardNoExpireTime()))
            && (this.getTaxNo() == null ? other.getTaxNo() == null : this.getTaxNo().equals(other.getTaxNo()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getVendorSource() == null ? other.getVendorSource() == null : this.getVendorSource().equals(other.getVendorSource()))
            && (this.getBankOfDeposit() == null ? other.getBankOfDeposit() == null : this.getBankOfDeposit().equals(other.getBankOfDeposit()))
            && (this.getBankAccount() == null ? other.getBankAccount() == null : this.getBankAccount().equals(other.getBankAccount()))
            && (this.getEnterpriseCode() == null ? other.getEnterpriseCode() == null : this.getEnterpriseCode().equals(other.getEnterpriseCode()))
            && (this.getSkillLicenseExpireTime() == null ? other.getSkillLicenseExpireTime() == null : this.getSkillLicenseExpireTime().equals(other.getSkillLicenseExpireTime()))
            && (this.getVendorType() == null ? other.getVendorType() == null : this.getVendorType().equals(other.getVendorType()))
            && (this.getIdCardImg1() == null ? other.getIdCardImg1() == null : this.getIdCardImg1().equals(other.getIdCardImg1()))
            && (this.getIdCardImg2() == null ? other.getIdCardImg2() == null : this.getIdCardImg2().equals(other.getIdCardImg2()))
            && (this.getQualityCertImg1() == null ? other.getQualityCertImg1() == null : this.getQualityCertImg1().equals(other.getQualityCertImg1()))
            && (this.getQualityCertImg2() == null ? other.getQualityCertImg2() == null : this.getQualityCertImg2().equals(other.getQualityCertImg2()))
            && (this.getRoadTransPermitImg1() == null ? other.getRoadTransPermitImg1() == null : this.getRoadTransPermitImg1().equals(other.getRoadTransPermitImg1()))
            && (this.getRoadTransPermitImg2() == null ? other.getRoadTransPermitImg2() == null : this.getRoadTransPermitImg2().equals(other.getRoadTransPermitImg2()))
            && (this.getBusinessLicenseImg1() == null ? other.getBusinessLicenseImg1() == null : this.getBusinessLicenseImg1().equals(other.getBusinessLicenseImg1()))
            && (this.getBusinessLicenseImg2() == null ? other.getBusinessLicenseImg2() == null : this.getBusinessLicenseImg2().equals(other.getBusinessLicenseImg2()))
            && (this.getVendorAddress() == null ? other.getVendorAddress() == null : this.getVendorAddress().equals(other.getVendorAddress()))
            && (this.getIsShowYourPrice() == null ? other.getIsShowYourPrice() == null : this.getIsShowYourPrice().equals(other.getIsShowYourPrice()))
            && (this.getIsSyncAsVendor() == null ? other.getIsSyncAsVendor() == null : this.getIsSyncAsVendor().equals(other.getIsSyncAsVendor()))
            && (this.getIsSyncAsDriver() == null ? other.getIsSyncAsDriver() == null : this.getIsSyncAsDriver().equals(other.getIsSyncAsDriver()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getIsOpen() == null ? other.getIsOpen() == null : this.getIsOpen().equals(other.getIsOpen()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateUserId() == null ? other.getLastUpdateUserId() == null : this.getLastUpdateUserId().equals(other.getLastUpdateUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getVendorId() == null) ? 0 : getVendorId().hashCode());
        result = prime * result + ((getJumaPin() == null) ? 0 : getJumaPin().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getVendorName() == null) ? 0 : getVendorName().hashCode());
        result = prime * result + ((getSerialNo() == null) ? 0 : getSerialNo().hashCode());
        result = prime * result + ((getContactUserName() == null) ? 0 : getContactUserName().hashCode());
        result = prime * result + ((getContactPhone() == null) ? 0 : getContactPhone().hashCode());
        result = prime * result + ((getEmergencyContactPhone() == null) ? 0 : getEmergencyContactPhone().hashCode());
        result = prime * result + ((getIdCardNo() == null) ? 0 : getIdCardNo().hashCode());
        result = prime * result + ((getIdCardNoExpireTime() == null) ? 0 : getIdCardNoExpireTime().hashCode());
        result = prime * result + ((getTaxNo() == null) ? 0 : getTaxNo().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getVendorSource() == null) ? 0 : getVendorSource().hashCode());
        result = prime * result + ((getBankOfDeposit() == null) ? 0 : getBankOfDeposit().hashCode());
        result = prime * result + ((getBankAccount() == null) ? 0 : getBankAccount().hashCode());
        result = prime * result + ((getEnterpriseCode() == null) ? 0 : getEnterpriseCode().hashCode());
        result = prime * result + ((getSkillLicenseExpireTime() == null) ? 0 : getSkillLicenseExpireTime().hashCode());
        result = prime * result + ((getVendorType() == null) ? 0 : getVendorType().hashCode());
        result = prime * result + ((getIdCardImg1() == null) ? 0 : getIdCardImg1().hashCode());
        result = prime * result + ((getIdCardImg2() == null) ? 0 : getIdCardImg2().hashCode());
        result = prime * result + ((getQualityCertImg1() == null) ? 0 : getQualityCertImg1().hashCode());
        result = prime * result + ((getQualityCertImg2() == null) ? 0 : getQualityCertImg2().hashCode());
        result = prime * result + ((getRoadTransPermitImg1() == null) ? 0 : getRoadTransPermitImg1().hashCode());
        result = prime * result + ((getRoadTransPermitImg2() == null) ? 0 : getRoadTransPermitImg2().hashCode());
        result = prime * result + ((getBusinessLicenseImg1() == null) ? 0 : getBusinessLicenseImg1().hashCode());
        result = prime * result + ((getBusinessLicenseImg2() == null) ? 0 : getBusinessLicenseImg2().hashCode());
        result = prime * result + ((getVendorAddress() == null) ? 0 : getVendorAddress().hashCode());
        result = prime * result + ((getIsShowYourPrice() == null) ? 0 : getIsShowYourPrice().hashCode());
        result = prime * result + ((getIsSyncAsVendor() == null) ? 0 : getIsSyncAsVendor().hashCode());
        result = prime * result + ((getIsSyncAsDriver() == null) ? 0 : getIsSyncAsDriver().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getIsOpen() == null) ? 0 : getIsOpen().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateUserId() == null) ? 0 : getLastUpdateUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", vendorId=").append(vendorId);
        sb.append(", jumaPin=").append(jumaPin);
        sb.append(", userId=").append(userId);
        sb.append(", vendorName=").append(vendorName);
        sb.append(", serialNo=").append(serialNo);
        sb.append(", contactUserName=").append(contactUserName);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", emergencyContactPhone=").append(emergencyContactPhone);
        sb.append(", idCardNo=").append(idCardNo);
        sb.append(", idCardNoExpireTime=").append(idCardNoExpireTime);
        sb.append(", taxNo=").append(taxNo);
        sb.append(", source=").append(source);
        sb.append(", vendorSource=").append(vendorSource);
        sb.append(", bankOfDeposit=").append(bankOfDeposit);
        sb.append(", bankAccount=").append(bankAccount);
        sb.append(", enterpriseCode=").append(enterpriseCode);
        sb.append(", skillLicenseExpireTime=").append(skillLicenseExpireTime);
        sb.append(", vendorType=").append(vendorType);
        sb.append(", idCardImg1=").append(idCardImg1);
        sb.append(", idCardImg2=").append(idCardImg2);
        sb.append(", qualityCertImg1=").append(qualityCertImg1);
        sb.append(", qualityCertImg2=").append(qualityCertImg2);
        sb.append(", roadTransPermitImg1=").append(roadTransPermitImg1);
        sb.append(", roadTransPermitImg2=").append(roadTransPermitImg2);
        sb.append(", businessLicenseImg1=").append(businessLicenseImg1);
        sb.append(", businessLicenseImg2=").append(businessLicenseImg2);
        sb.append(", vendorAddress=").append(vendorAddress);
        sb.append(", isShowYourPrice=").append(isShowYourPrice);
        sb.append(", isSyncAsVendor=").append(isSyncAsVendor);
        sb.append(", isSyncAsDriver=").append(isSyncAsDriver);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", isOpen=").append(isOpen);
        sb.append(", remark=").append(remark);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", lastUpdateUserId=").append(lastUpdateUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        vendorId,
        jumaPin,
        userId,
        vendorName,
        serialNo,
        contactUserName,
        contactPhone,
        emergencyContactPhone,
        idCardNo,
        idCardNoExpireTime,
        taxNo,
        source,
        vendorSource,
        bankOfDeposit,
        bankAccount,
        enterpriseCode,
        skillLicenseExpireTime,
        vendorType,
        idCardImg1,
        idCardImg2,
        qualityCertImg1,
        qualityCertImg2,
        roadTransPermitImg1,
        roadTransPermitImg2,
        businessLicenseImg1,
        businessLicenseImg2,
        vendorAddress,
        isShowYourPrice,
        isSyncAsVendor,
        isSyncAsDriver,
        isDelete,
        isOpen,
        remark,
        createUserId,
        createTime,
        lastUpdateTime,
        lastUpdateUserId;

        public String asc() {
            return column() + " ASC";
        }

        public String desc() {
            return column() + " DESC";
        }

        private String column() {
            StringBuilder buffer = new StringBuilder();
            char[] charArray = this.name().toCharArray();
            for(char ch : charArray) {
                if(Character.isUpperCase(ch)){
                    buffer.append("_");
                    buffer.append(Character.toLowerCase(ch));
                } else {
                    buffer.append(ch);
                }
            }
            return buffer.toString();
        }
    }
}