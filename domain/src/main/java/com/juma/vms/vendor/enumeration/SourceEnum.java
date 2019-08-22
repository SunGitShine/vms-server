package com.juma.vms.vendor.enumeration;

/**
 * @ClassName SourceEnum.java
 * @Description 承运商来源
 * @author Libin.Wei
 * @Date 2018年10月31日 下午3:25:14
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

public enum SourceEnum {

    BACKSTAGE((byte) 1, "后台添加", "VMS_MANAGE"), CRM((byte) 2, "CRM", "CRM_MANAGE"), AMS((byte) 3, "AMS", "VM_MANAGE");

    private byte code;
    private String desc;
    private String anthKey;

    private SourceEnum(byte code, String desc, String anthKey) {
        this.code = code;
        this.desc = desc;
        this.anthKey = anthKey;
    }

    public byte getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getAnthKey() {
        return anthKey;
    }

    public static String getSourceDesc(Byte code) {
        if (null == code) {
            return null;
        }

        for (SourceEnum v : SourceEnum.values()) {
            if (v.getCode() == code) {
                return v.getDesc();
            }
        }

        return null;
    }
}
