package com.juma.vms.tool.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 功能 :
 * 身份证OCR识别信息
 * @author : Bruce(刘正航) 11:12 2019-03-27
 */
@ApiModel(value = "身份证信息")
public class IdentificationCardInfo implements Serializable {
    /**
     * 地址
     * */
    @ApiModelProperty(value = "地址(正面)")
    private String address;

    /**
     * 姓名
     * */
    @ApiModelProperty(value = "姓名(正面)")
    private String name;

    /**
     * 民族
     * */
    @ApiModelProperty(value = "民族(正面)")
    private String nationality;

    /**
     * 身份证号
     * */
    @ApiModelProperty(value = "身份证号(正面)")
    private String num;

    /**
     * 性别
     * */
    @ApiModelProperty(value = "性别(正面)")
    private String sex;

    /**
     * 出生日期
     * */
    @ApiModelProperty(value = "出生日期(正面)")
    private String birth;

    /**
     * 身份证有效期起始日期
     * */
    @ApiModelProperty(value = "身份证有效期起始日期(背面)")
    private String startDate;

    /**
     * 身份证有效期截止日期
     * */
    @ApiModelProperty(value = "身份证有效期截止日期(背面)")
    private String endDate;

    /**
     * 签发机关
     * */
    @ApiModelProperty(value = "签发机关(背面)")
    private String issue;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }
}
