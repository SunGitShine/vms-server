package com.juma.vms.operateLog.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class OperateLog implements Serializable {

    @ApiModelProperty(value = "操作日志ID")
    private Integer operateLogId;
    private Byte logSign;
    @ApiModelProperty(value = "关联表I，例如承运商的主键vendorId")
    private Integer relationTableId;
    @ApiModelProperty(value = "操作类型")
    private Byte operateType;
    private Byte operateApplicatoin;
    @ApiModelProperty(value = "操作人userId")
    private Integer createUserId;
    @ApiModelProperty(value = "操作时间")
    private Date createTime;
    @ApiModelProperty(value = "备注")
    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getOperateLogId() {
        return operateLogId;
    }

    public void setOperateLogId(Integer operateLogId) {
        this.operateLogId = operateLogId;
    }

    public Byte getLogSign() {
        return logSign;
    }

    public void setLogSign(Byte logSign) {
        this.logSign = logSign;
    }

    public Integer getRelationTableId() {
        return relationTableId;
    }

    public void setRelationTableId(Integer relationTableId) {
        this.relationTableId = relationTableId;
    }

    public Byte getOperateType() {
        return operateType;
    }

    public void setOperateType(Byte operateType) {
        this.operateType = operateType;
    }

    public Byte getOperateApplicatoin() {
        return operateApplicatoin;
    }

    public void setOperateApplicatoin(Byte operateApplicatoin) {
        this.operateApplicatoin = operateApplicatoin;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        OperateLog other = (OperateLog) that;
        return (this.getOperateLogId() == null ? other.getOperateLogId() == null : this.getOperateLogId().equals(other.getOperateLogId()))
                && (this.getLogSign() == null ? other.getLogSign() == null : this.getLogSign().equals(other.getLogSign()))
                && (this.getRelationTableId() == null ? other.getRelationTableId() == null : this.getRelationTableId().equals(other.getRelationTableId()))
                && (this.getOperateType() == null ? other.getOperateType() == null : this.getOperateType().equals(other.getOperateType()))
                && (this.getOperateApplicatoin() == null ? other.getOperateApplicatoin() == null : this.getOperateApplicatoin().equals(other.getOperateApplicatoin()))
                && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOperateLogId() == null) ? 0 : getOperateLogId().hashCode());
        result = prime * result + ((getLogSign() == null) ? 0 : getLogSign().hashCode());
        result = prime * result + ((getRelationTableId() == null) ? 0 : getRelationTableId().hashCode());
        result = prime * result + ((getOperateType() == null) ? 0 : getOperateType().hashCode());
        result = prime * result + ((getOperateApplicatoin() == null) ? 0 : getOperateApplicatoin().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", operateLogId=").append(operateLogId);
        sb.append(", logSign=").append(logSign);
        sb.append(", relationTableId=").append(relationTableId);
        sb.append(", operateType=").append(operateType);
        sb.append(", operateApplicatoin=").append(operateApplicatoin);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        operateLogId,
        logSign,
        relationTableId,
        operateType,
        operateApplicatoin,
        createUserId,
        createTime,
        remark;

        public String asc() {
            return column() + " ASC";
        }

        public String desc() {
            return column() + " DESC";
        }

        private String column() {
            StringBuilder buffer = new StringBuilder();
            char[] charArray = this.name().toCharArray();
            for (char ch : charArray) {
                if (Character.isUpperCase(ch)) {
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