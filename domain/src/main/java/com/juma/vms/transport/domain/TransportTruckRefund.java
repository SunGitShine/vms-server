package com.juma.vms.transport.domain;

import java.io.Serializable;
import java.util.Date;

public class TransportTruckRefund implements Serializable {
    private Integer refundId;

    private String refundNo;

    private Integer tenantId;

    private String plateNumber;

    private String truckIdentificationNo;

    private Integer vehicleBoxType;

    private Integer vehicleBoxLength;

    private Integer truckRunType;

    private String areaCode;

    private Integer vendorId;

    private String contactPhone;

    private Byte vendorType;

    private Integer departmentId;

    private String departmentCode;

    private Integer toDepartmentId;

    private Integer refundStatus;

    private Byte refundReasonType;

    private String refundReason;

    private String refundAttachments;

    private Integer approvalStatus;

    private String approvalOpinion;

    private String storageNo;

    private String processInstanceId;

    private Date submitTime;

    private Integer submitUserId;

    private Date createTime;

    private Integer createUserId;

    private Date lastUpdateTime;

    private Integer lastUpdateUserId;

    private static final long serialVersionUID = 1L;

    public Integer getRefundId() {
        return refundId;
    }

    public void setRefundId(Integer refundId) {
        this.refundId = refundId;
    }

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo == null ? null : refundNo.trim();
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber == null ? null : plateNumber.trim();
    }

    public String getTruckIdentificationNo() {
        return truckIdentificationNo;
    }

    public void setTruckIdentificationNo(String truckIdentificationNo) {
        this.truckIdentificationNo = truckIdentificationNo == null ? null : truckIdentificationNo.trim();
    }

    public Integer getVehicleBoxType() {
        return vehicleBoxType;
    }

    public void setVehicleBoxType(Integer vehicleBoxType) {
        this.vehicleBoxType = vehicleBoxType;
    }

    public Integer getVehicleBoxLength() {
        return vehicleBoxLength;
    }

    public void setVehicleBoxLength(Integer vehicleBoxLength) {
        this.vehicleBoxLength = vehicleBoxLength;
    }

    public Integer getTruckRunType() {
        return truckRunType;
    }

    public void setTruckRunType(Integer truckRunType) {
        this.truckRunType = truckRunType;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public Byte getVendorType() {
        return vendorType;
    }

    public void setVendorType(Byte vendorType) {
        this.vendorType = vendorType;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode == null ? null : departmentCode.trim();
    }

    public Integer getToDepartmentId() {
        return toDepartmentId;
    }

    public void setToDepartmentId(Integer toDepartmentId) {
        this.toDepartmentId = toDepartmentId;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Byte getRefundReasonType() {
        return refundReasonType;
    }

    public void setRefundReasonType(Byte refundReasonType) {
        this.refundReasonType = refundReasonType;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason == null ? null : refundReason.trim();
    }

    public String getRefundAttachments() {
        return refundAttachments;
    }

    public void setRefundAttachments(String refundAttachments) {
        this.refundAttachments = refundAttachments == null ? null : refundAttachments.trim();
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getApprovalOpinion() {
        return approvalOpinion;
    }

    public void setApprovalOpinion(String approvalOpinion) {
        this.approvalOpinion = approvalOpinion == null ? null : approvalOpinion.trim();
    }

    public String getStorageNo() {
        return storageNo;
    }

    public void setStorageNo(String storageNo) {
        this.storageNo = storageNo == null ? null : storageNo.trim();
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId == null ? null : processInstanceId.trim();
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Integer getSubmitUserId() {
        return submitUserId;
    }

    public void setSubmitUserId(Integer submitUserId) {
        this.submitUserId = submitUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
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
        TransportTruckRefund other = (TransportTruckRefund) that;
        return (this.getRefundId() == null ? other.getRefundId() == null : this.getRefundId().equals(other.getRefundId()))
            && (this.getRefundNo() == null ? other.getRefundNo() == null : this.getRefundNo().equals(other.getRefundNo()))
            && (this.getTenantId() == null ? other.getTenantId() == null : this.getTenantId().equals(other.getTenantId()))
            && (this.getPlateNumber() == null ? other.getPlateNumber() == null : this.getPlateNumber().equals(other.getPlateNumber()))
            && (this.getTruckIdentificationNo() == null ? other.getTruckIdentificationNo() == null : this.getTruckIdentificationNo().equals(other.getTruckIdentificationNo()))
            && (this.getVehicleBoxType() == null ? other.getVehicleBoxType() == null : this.getVehicleBoxType().equals(other.getVehicleBoxType()))
            && (this.getVehicleBoxLength() == null ? other.getVehicleBoxLength() == null : this.getVehicleBoxLength().equals(other.getVehicleBoxLength()))
            && (this.getTruckRunType() == null ? other.getTruckRunType() == null : this.getTruckRunType().equals(other.getTruckRunType()))
            && (this.getAreaCode() == null ? other.getAreaCode() == null : this.getAreaCode().equals(other.getAreaCode()))
            && (this.getVendorId() == null ? other.getVendorId() == null : this.getVendorId().equals(other.getVendorId()))
            && (this.getContactPhone() == null ? other.getContactPhone() == null : this.getContactPhone().equals(other.getContactPhone()))
            && (this.getVendorType() == null ? other.getVendorType() == null : this.getVendorType().equals(other.getVendorType()))
            && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()))
            && (this.getDepartmentCode() == null ? other.getDepartmentCode() == null : this.getDepartmentCode().equals(other.getDepartmentCode()))
            && (this.getToDepartmentId() == null ? other.getToDepartmentId() == null : this.getToDepartmentId().equals(other.getToDepartmentId()))
            && (this.getRefundStatus() == null ? other.getRefundStatus() == null : this.getRefundStatus().equals(other.getRefundStatus()))
            && (this.getRefundReasonType() == null ? other.getRefundReasonType() == null : this.getRefundReasonType().equals(other.getRefundReasonType()))
            && (this.getRefundReason() == null ? other.getRefundReason() == null : this.getRefundReason().equals(other.getRefundReason()))
            && (this.getRefundAttachments() == null ? other.getRefundAttachments() == null : this.getRefundAttachments().equals(other.getRefundAttachments()))
            && (this.getApprovalStatus() == null ? other.getApprovalStatus() == null : this.getApprovalStatus().equals(other.getApprovalStatus()))
            && (this.getApprovalOpinion() == null ? other.getApprovalOpinion() == null : this.getApprovalOpinion().equals(other.getApprovalOpinion()))
            && (this.getStorageNo() == null ? other.getStorageNo() == null : this.getStorageNo().equals(other.getStorageNo()))
            && (this.getProcessInstanceId() == null ? other.getProcessInstanceId() == null : this.getProcessInstanceId().equals(other.getProcessInstanceId()))
            && (this.getSubmitTime() == null ? other.getSubmitTime() == null : this.getSubmitTime().equals(other.getSubmitTime()))
            && (this.getSubmitUserId() == null ? other.getSubmitUserId() == null : this.getSubmitUserId().equals(other.getSubmitUserId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateUserId() == null ? other.getLastUpdateUserId() == null : this.getLastUpdateUserId().equals(other.getLastUpdateUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRefundId() == null) ? 0 : getRefundId().hashCode());
        result = prime * result + ((getRefundNo() == null) ? 0 : getRefundNo().hashCode());
        result = prime * result + ((getTenantId() == null) ? 0 : getTenantId().hashCode());
        result = prime * result + ((getPlateNumber() == null) ? 0 : getPlateNumber().hashCode());
        result = prime * result + ((getTruckIdentificationNo() == null) ? 0 : getTruckIdentificationNo().hashCode());
        result = prime * result + ((getVehicleBoxType() == null) ? 0 : getVehicleBoxType().hashCode());
        result = prime * result + ((getVehicleBoxLength() == null) ? 0 : getVehicleBoxLength().hashCode());
        result = prime * result + ((getTruckRunType() == null) ? 0 : getTruckRunType().hashCode());
        result = prime * result + ((getAreaCode() == null) ? 0 : getAreaCode().hashCode());
        result = prime * result + ((getVendorId() == null) ? 0 : getVendorId().hashCode());
        result = prime * result + ((getContactPhone() == null) ? 0 : getContactPhone().hashCode());
        result = prime * result + ((getVendorType() == null) ? 0 : getVendorType().hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        result = prime * result + ((getDepartmentCode() == null) ? 0 : getDepartmentCode().hashCode());
        result = prime * result + ((getToDepartmentId() == null) ? 0 : getToDepartmentId().hashCode());
        result = prime * result + ((getRefundStatus() == null) ? 0 : getRefundStatus().hashCode());
        result = prime * result + ((getRefundReasonType() == null) ? 0 : getRefundReasonType().hashCode());
        result = prime * result + ((getRefundReason() == null) ? 0 : getRefundReason().hashCode());
        result = prime * result + ((getRefundAttachments() == null) ? 0 : getRefundAttachments().hashCode());
        result = prime * result + ((getApprovalStatus() == null) ? 0 : getApprovalStatus().hashCode());
        result = prime * result + ((getApprovalOpinion() == null) ? 0 : getApprovalOpinion().hashCode());
        result = prime * result + ((getStorageNo() == null) ? 0 : getStorageNo().hashCode());
        result = prime * result + ((getProcessInstanceId() == null) ? 0 : getProcessInstanceId().hashCode());
        result = prime * result + ((getSubmitTime() == null) ? 0 : getSubmitTime().hashCode());
        result = prime * result + ((getSubmitUserId() == null) ? 0 : getSubmitUserId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
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
        sb.append(", refundId=").append(refundId);
        sb.append(", refundNo=").append(refundNo);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", plateNumber=").append(plateNumber);
        sb.append(", truckIdentificationNo=").append(truckIdentificationNo);
        sb.append(", vehicleBoxType=").append(vehicleBoxType);
        sb.append(", vehicleBoxLength=").append(vehicleBoxLength);
        sb.append(", truckRunType=").append(truckRunType);
        sb.append(", areaCode=").append(areaCode);
        sb.append(", vendorId=").append(vendorId);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", vendorType=").append(vendorType);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", departmentCode=").append(departmentCode);
        sb.append(", toDepartmentId=").append(toDepartmentId);
        sb.append(", refundStatus=").append(refundStatus);
        sb.append(", refundReasonType=").append(refundReasonType);
        sb.append(", refundReason=").append(refundReason);
        sb.append(", refundAttachments=").append(refundAttachments);
        sb.append(", approvalStatus=").append(approvalStatus);
        sb.append(", approvalOpinion=").append(approvalOpinion);
        sb.append(", storageNo=").append(storageNo);
        sb.append(", processInstanceId=").append(processInstanceId);
        sb.append(", submitTime=").append(submitTime);
        sb.append(", submitUserId=").append(submitUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", lastUpdateUserId=").append(lastUpdateUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        refundId,
        refundNo,
        tenantId,
        plateNumber,
        truckIdentificationNo,
        vehicleBoxType,
        vehicleBoxLength,
        truckRunType,
        areaCode,
        vendorId,
        contactPhone,
        vendorType,
        departmentId,
        departmentCode,
        toDepartmentId,
        refundStatus,
        refundReasonType,
        refundReason,
        refundAttachments,
        approvalStatus,
        approvalOpinion,
        storageNo,
        processInstanceId,
        submitTime,
        submitUserId,
        createTime,
        createUserId,
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