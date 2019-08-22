package com.juma.vms.operateLog.enumeration;

/**
 * @ClassName OperateTypeEnum.java
 * @Description 请填写注释...
 * @author Libin.Wei
 * @Date 2018年10月30日 上午10:37:12
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

public enum OperateTypeEnum {

    ADD_VNEDOR((byte) 1, "添加承运商"),
    MODIFY_VNEDOR((byte) 2, "编辑承运商"),
    DEL_VNEDOR((byte) 3, "删除承运商"),
    ADD_VEHICLE((byte) 4, "添加车辆"),
    DEL_VEHICLE((byte) 5, "删除车辆"),
    UNBIND_TENANT((byte) 6, "解绑租户"),
    VENDOR_SYNC_DRIVER((byte) 7, "同步为司机"),
    VENDOR_SYNC_USER((byte) 8, "创建承运商账号");

    private byte code;
    private String desc;

    private OperateTypeEnum(byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public byte getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static String getTypeDesc(Byte code) {
        if (null == code) {
            return null;
        }

        for (OperateTypeEnum t : OperateTypeEnum.values()) {
            if (code == t.getCode()) {
                return t.getDesc();
            }
        }
        return null;
    }
}