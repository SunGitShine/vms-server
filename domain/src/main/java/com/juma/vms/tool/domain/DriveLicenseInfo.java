package com.juma.vms.tool.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 功能 :
 * 驾驶证OCR识别信息
 * @author : Bruce(刘正航) 11:11 2019-03-27
 */
@ApiModel(value = "驾驶证信息")
public class DriveLicenseInfo implements Serializable {
    /**
     * 姓名
     * */
    @ApiModelProperty(value = "司机姓名(正面/背面)")
    private String name;

    /**
     * 驾驶证号
     * */
    @ApiModelProperty(value = "驾驶证号(正面/背面)")
    private String num;

    /**
     * 驾驶证准驾车型
     * */
    @ApiModelProperty(value = "驾驶证准驾车型(正面)")
    private String vehicleType;

    /**
     * 驾驶证有效期开始时间
     * */
    @ApiModelProperty(value = "驾驶证有效期开始时间(正面)")
    private String startDate;

    /**
     * 驾驶证到期时间
     * */
    @ApiModelProperty(value = "驾驶证到期时间(正面)")
    private String endDate;

    /**
     * 地址
     * */
    @ApiModelProperty(value = "地址(正面)")
    private String addr;

    /**
     * 性别
     * */
    @ApiModelProperty(value = "性别(正面)")
    private String sex;

    /**
     * 档案编号
     * */
    @ApiModelProperty(value = "档案编号(背面)")
    private String archiveNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getArchiveNo() {
        return archiveNo;
    }

    public void setArchiveNo(String archiveNo) {
        this.archiveNo = archiveNo;
    }
}
