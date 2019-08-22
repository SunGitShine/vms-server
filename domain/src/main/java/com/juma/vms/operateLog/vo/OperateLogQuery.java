package com.juma.vms.operateLog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName OperateLogQuery.java
 * @Description 请填写注释...
 * @author Libin.Wei
 * @Date 2018年10月30日 上午10:56:04
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

@ApiModel(value = "操作记录")
public class OperateLogQuery implements Serializable {

    @ApiModelProperty(value = "操作日志id")
    private Integer operateLogId;
    @ApiModelProperty(value = "日志创建时间")
    private Date createTime;
    @ApiModelProperty(value = "日志创建人Id")
    private Integer createUserId;
    @ApiModelProperty(value = "日志创建人名称")
    private String createUserName;
    @ApiModelProperty(value = "日志创建人手机号")
    private String createUserPhone;
    @ApiModelProperty(value = "操作类型")
    private String operateTypeName;
    @ApiModelProperty(value = "备注")
    private String remark;

    public Integer getOperateLogId() {
        return operateLogId;
    }

    public void setOperateLogId(Integer operateLogId) {
        this.operateLogId = operateLogId;
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

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getCreateUserPhone() {
        return createUserPhone;
    }

    public void setCreateUserPhone(String createUserPhone) {
        this.createUserPhone = createUserPhone;
    }

    public String getOperateTypeName() {
        return operateTypeName;
    }

    public void setOperateTypeName(String operateTypeName) {
        this.operateTypeName = operateTypeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
