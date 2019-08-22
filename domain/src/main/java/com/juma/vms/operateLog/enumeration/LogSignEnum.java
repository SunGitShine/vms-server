package com.juma.vms.operateLog.enumeration;

/**
 * @ClassName LogSignEnum.java
 * @Description 日志分类枚举
 * @author Libin.Wei
 * @Date 2018年10月30日 上午10:36:49
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

public enum LogSignEnum {

    VENDOR((byte) 1, "承运商管理");

    private byte code;
    private String desc;

    private LogSignEnum(byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public byte getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}