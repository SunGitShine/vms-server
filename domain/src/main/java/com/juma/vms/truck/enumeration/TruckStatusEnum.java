package com.juma.vms.truck.enumeration;

public enum TruckStatusEnum {
    DISABLED(0, "已停用"),
    ENABLE( 1, "正常"),
    CAR_BACK( 2, "退车中"),
    ALREADY_CAR_BACK( 3, "已退车"),
    WAIT_RECEIVE( 4, "待接收");

    private Integer code;
    private String desc;

    TruckStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static TruckStatusEnum get(Integer code) {
        for (TruckStatusEnum typeEnum : TruckStatusEnum.values()) {
            if (typeEnum.code.equals(code)) {
                return typeEnum;
            }
        }
        return null;
    }

    public static String getDescByCode(Integer code) {
        TruckStatusEnum driverTypeEnum = get(code);
        if (driverTypeEnum == null) {
            return null;
        }
        return driverTypeEnum.getDesc();
    }

}
