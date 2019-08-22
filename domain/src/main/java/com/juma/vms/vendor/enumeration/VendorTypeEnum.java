package com.juma.vms.vendor.enumeration;

/**
 * @ClassName VendorTypeEnum.java
 * @Description 请填写注释...
 * @author Libin.Wei
 * @Date 2018年10月30日 下午8:10:51
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

public enum VendorTypeEnum {

    PERSONAL((byte) 1, "个人"), TRUCK_FLEET((byte) 2, "车队"), ENTERPRISE((byte) 3, "公司");

    private byte code;
    private String desc;

    private VendorTypeEnum(byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public byte getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static String getVendorTypeDesc(Byte vendorType) {
        if (null == vendorType) {
            return null;
        }

        for (VendorTypeEnum v : VendorTypeEnum.values()) {
            if (v.getCode() == vendorType) {
                return v.getDesc();
            }
        }

        return null;
    }
}
