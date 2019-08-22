package com.juma.vms.tool.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class SmsCode implements Serializable {

    @ApiModelProperty(value="名称")
    private String name;

    @ApiModelProperty(value="旧手机号")
    private String pastPhone;

    @ApiModelProperty(value="手机号")
    private String phone;

    @ApiModelProperty(value="手机验证码")
    private String smsCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPastPhone() {
        return pastPhone;
    }

    public void setPastPhone(String pastPhone) {
        this.pastPhone = pastPhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
}
