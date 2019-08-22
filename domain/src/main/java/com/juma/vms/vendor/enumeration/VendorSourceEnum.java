package com.juma.vms.vendor.enumeration;

/**
 * @ClassName SourceEnum.java
 * @Description 承运商运营类型
 * @author Libin.Wei
 * @Date 2019年03月20日 下午3:25:14
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

public enum VendorSourceEnum {

    SELF_SUPPORT((byte) 1, "自营"),
    NO_SELF_SUPPORT((byte) 2, "非自营");

    private byte code;
    private String desc;

    private VendorSourceEnum(byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public byte getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }


    public static String getSourceDesc(Byte code) {
        if (null == code) {
            return null;
        }

        for (VendorSourceEnum v : VendorSourceEnum.values()) {
            if (v.getCode() == code) {
                return v.getDesc();
            }
        }

        return null;
    }
}
