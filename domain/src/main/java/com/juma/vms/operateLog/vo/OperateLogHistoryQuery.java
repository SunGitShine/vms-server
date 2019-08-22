package com.juma.vms.operateLog.vo;

import com.juma.vms.operateLog.domain.OperateLog;
import com.juma.vms.operateLog.enumeration.OperateTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Libin.Wei
 * @version 1.0.0
 * @ClassName OperateLogQuery.java
 * @Description 请填写注释...
 * @Date 2018年10月30日 上午10:56:04
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

@ApiModel(value = "历史承运商操作记录")
public class OperateLogHistoryQuery extends OperateLog {

    @ApiModelProperty(value = "日志创建人名称")
    private String createUserName;
    @ApiModelProperty(value = "日志创建人手机号")
    private String createUserPhone;
    @ApiModelProperty(value = "操作类型")
    private String operateTypeName;

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
        if (StringUtils.isNotBlank(operateTypeName)) {
            return operateTypeName;
        }

        return OperateTypeEnum.getTypeDesc(super.getOperateType());
    }

    public void setOperateTypeName(String operateTypeName) {
        this.operateTypeName = operateTypeName;
    }
}
