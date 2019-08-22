package com.juma.vms.transport.domain;

import java.io.Serializable;
import java.util.Date;

public class TransportCapacity implements Serializable {
    private Integer transportId;

    private Integer tenantId;

    private String tenantCode;

    private Integer receiveTenantId;

    private String receiveTenantCode;

    private String transportNo;

    private Integer transportType;

    private Integer fromDepartmentId;

    private String fromDepartmentCode;

    private String fromDepartmentCreditcode;

    private Integer toDepartmentId;

    private String toDepartmentCode;

    private String toDepartmentCreditcode;

    private String processInstanceId;

    private Integer approvalStatus;

    private String attachUrl;

    private Integer submitUserId;

    private Date submitTime;

    private Integer createUserId;

    private Date createTime;

    private Date lastUpdateTime;

    private Integer lastUpdateUserId;

    private static final long serialVersionUID = 1L;

    public Integer getTransportId() {
        return transportId;
    }

    public void setTransportId(Integer transportId) {
        this.transportId = transportId;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode == null ? null : tenantCode.trim();
    }

    public Integer getReceiveTenantId() {
        return receiveTenantId;
    }

    public void setReceiveTenantId(Integer receiveTenantId) {
        this.receiveTenantId = receiveTenantId;
    }

    public String getReceiveTenantCode() {
        return receiveTenantCode;
    }

    public void setReceiveTenantCode(String receiveTenantCode) {
        this.receiveTenantCode = receiveTenantCode == null ? null : receiveTenantCode.trim();
    }

    public String getTransportNo() {
        return transportNo;
    }

    public void setTransportNo(String transportNo) {
        this.transportNo = transportNo == null ? null : transportNo.trim();
    }

    public Integer getTransportType() {
        return transportType;
    }

    public void setTransportType(Integer transportType) {
        this.transportType = transportType;
    }

    public Integer getFromDepartmentId() {
        return fromDepartmentId;
    }

    public void setFromDepartmentId(Integer fromDepartmentId) {
        this.fromDepartmentId = fromDepartmentId;
    }

    public String getFromDepartmentCode() {
        return fromDepartmentCode;
    }

    public void setFromDepartmentCode(String fromDepartmentCode) {
        this.fromDepartmentCode = fromDepartmentCode == null ? null : fromDepartmentCode.trim();
    }

    public String getFromDepartmentCreditcode() {
        return fromDepartmentCreditcode;
    }

    public void setFromDepartmentCreditcode(String fromDepartmentCreditcode) {
        this.fromDepartmentCreditcode = fromDepartmentCreditcode == null ? null : fromDepartmentCreditcode.trim();
    }

    public Integer getToDepartmentId() {
        return toDepartmentId;
    }

    public void setToDepartmentId(Integer toDepartmentId) {
        this.toDepartmentId = toDepartmentId;
    }

    public String getToDepartmentCode() {
        return toDepartmentCode;
    }

    public void setToDepartmentCode(String toDepartmentCode) {
        this.toDepartmentCode = toDepartmentCode == null ? null : toDepartmentCode.trim();
    }

    public String getToDepartmentCreditcode() {
        return toDepartmentCreditcode;
    }

    public void setToDepartmentCreditcode(String toDepartmentCreditcode) {
        this.toDepartmentCreditcode = toDepartmentCreditcode == null ? null : toDepartmentCreditcode.trim();
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId == null ? null : processInstanceId.trim();
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getAttachUrl() {
        return attachUrl;
    }

    public void setAttachUrl(String attachUrl) {
        this.attachUrl = attachUrl == null ? null : attachUrl.trim();
    }

    public Integer getSubmitUserId() {
        return submitUserId;
    }

    public void setSubmitUserId(Integer submitUserId) {
        this.submitUserId = submitUserId;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
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
        TransportCapacity other = (TransportCapacity) that;
        return (this.getTransportId() == null ? other.getTransportId() == null : this.getTransportId().equals(other.getTransportId()))
            && (this.getTenantId() == null ? other.getTenantId() == null : this.getTenantId().equals(other.getTenantId()))
            && (this.getTenantCode() == null ? other.getTenantCode() == null : this.getTenantCode().equals(other.getTenantCode()))
            && (this.getReceiveTenantId() == null ? other.getReceiveTenantId() == null : this.getReceiveTenantId().equals(other.getReceiveTenantId()))
            && (this.getReceiveTenantCode() == null ? other.getReceiveTenantCode() == null : this.getReceiveTenantCode().equals(other.getReceiveTenantCode()))
            && (this.getTransportNo() == null ? other.getTransportNo() == null : this.getTransportNo().equals(other.getTransportNo()))
            && (this.getTransportType() == null ? other.getTransportType() == null : this.getTransportType().equals(other.getTransportType()))
            && (this.getFromDepartmentId() == null ? other.getFromDepartmentId() == null : this.getFromDepartmentId().equals(other.getFromDepartmentId()))
            && (this.getFromDepartmentCode() == null ? other.getFromDepartmentCode() == null : this.getFromDepartmentCode().equals(other.getFromDepartmentCode()))
            && (this.getFromDepartmentCreditcode() == null ? other.getFromDepartmentCreditcode() == null : this.getFromDepartmentCreditcode().equals(other.getFromDepartmentCreditcode()))
            && (this.getToDepartmentId() == null ? other.getToDepartmentId() == null : this.getToDepartmentId().equals(other.getToDepartmentId()))
            && (this.getToDepartmentCode() == null ? other.getToDepartmentCode() == null : this.getToDepartmentCode().equals(other.getToDepartmentCode()))
            && (this.getToDepartmentCreditcode() == null ? other.getToDepartmentCreditcode() == null : this.getToDepartmentCreditcode().equals(other.getToDepartmentCreditcode()))
            && (this.getProcessInstanceId() == null ? other.getProcessInstanceId() == null : this.getProcessInstanceId().equals(other.getProcessInstanceId()))
            && (this.getApprovalStatus() == null ? other.getApprovalStatus() == null : this.getApprovalStatus().equals(other.getApprovalStatus()))
            && (this.getAttachUrl() == null ? other.getAttachUrl() == null : this.getAttachUrl().equals(other.getAttachUrl()))
            && (this.getSubmitUserId() == null ? other.getSubmitUserId() == null : this.getSubmitUserId().equals(other.getSubmitUserId()))
            && (this.getSubmitTime() == null ? other.getSubmitTime() == null : this.getSubmitTime().equals(other.getSubmitTime()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateUserId() == null ? other.getLastUpdateUserId() == null : this.getLastUpdateUserId().equals(other.getLastUpdateUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTransportId() == null) ? 0 : getTransportId().hashCode());
        result = prime * result + ((getTenantId() == null) ? 0 : getTenantId().hashCode());
        result = prime * result + ((getTenantCode() == null) ? 0 : getTenantCode().hashCode());
        result = prime * result + ((getReceiveTenantId() == null) ? 0 : getReceiveTenantId().hashCode());
        result = prime * result + ((getReceiveTenantCode() == null) ? 0 : getReceiveTenantCode().hashCode());
        result = prime * result + ((getTransportNo() == null) ? 0 : getTransportNo().hashCode());
        result = prime * result + ((getTransportType() == null) ? 0 : getTransportType().hashCode());
        result = prime * result + ((getFromDepartmentId() == null) ? 0 : getFromDepartmentId().hashCode());
        result = prime * result + ((getFromDepartmentCode() == null) ? 0 : getFromDepartmentCode().hashCode());
        result = prime * result + ((getFromDepartmentCreditcode() == null) ? 0 : getFromDepartmentCreditcode().hashCode());
        result = prime * result + ((getToDepartmentId() == null) ? 0 : getToDepartmentId().hashCode());
        result = prime * result + ((getToDepartmentCode() == null) ? 0 : getToDepartmentCode().hashCode());
        result = prime * result + ((getToDepartmentCreditcode() == null) ? 0 : getToDepartmentCreditcode().hashCode());
        result = prime * result + ((getProcessInstanceId() == null) ? 0 : getProcessInstanceId().hashCode());
        result = prime * result + ((getApprovalStatus() == null) ? 0 : getApprovalStatus().hashCode());
        result = prime * result + ((getAttachUrl() == null) ? 0 : getAttachUrl().hashCode());
        result = prime * result + ((getSubmitUserId() == null) ? 0 : getSubmitUserId().hashCode());
        result = prime * result + ((getSubmitTime() == null) ? 0 : getSubmitTime().hashCode());
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
        sb.append(", transportId=").append(transportId);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", tenantCode=").append(tenantCode);
        sb.append(", receiveTenantId=").append(receiveTenantId);
        sb.append(", receiveTenantCode=").append(receiveTenantCode);
        sb.append(", transportNo=").append(transportNo);
        sb.append(", transportType=").append(transportType);
        sb.append(", fromDepartmentId=").append(fromDepartmentId);
        sb.append(", fromDepartmentCode=").append(fromDepartmentCode);
        sb.append(", fromDepartmentCreditcode=").append(fromDepartmentCreditcode);
        sb.append(", toDepartmentId=").append(toDepartmentId);
        sb.append(", toDepartmentCode=").append(toDepartmentCode);
        sb.append(", toDepartmentCreditcode=").append(toDepartmentCreditcode);
        sb.append(", processInstanceId=").append(processInstanceId);
        sb.append(", approvalStatus=").append(approvalStatus);
        sb.append(", attachUrl=").append(attachUrl);
        sb.append(", submitUserId=").append(submitUserId);
        sb.append(", submitTime=").append(submitTime);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", lastUpdateUserId=").append(lastUpdateUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        transportId,
        tenantId,
        tenantCode,
        receiveTenantId,
        receiveTenantCode,
        transportNo,
        transportType,
        fromDepartmentId,
        fromDepartmentCode,
        fromDepartmentCreditcode,
        toDepartmentId,
        toDepartmentCode,
        toDepartmentCreditcode,
        processInstanceId,
        approvalStatus,
        attachUrl,
        submitUserId,
        submitTime,
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