package com.juma.vms.driver.enumeration;

public enum DriverStatusEnum {
    STOP_WORK( 0, "停用"),
    WORK( 1, "正常");

    private Integer code;
    private String desc;

    DriverStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static DriverStatusEnum get(Integer code) {
        for (DriverStatusEnum typeEnum : DriverStatusEnum.values()) {
            if (typeEnum.code.equals(code)) {
                return typeEnum;
            }
        }
        return null;
    }

    public static String getDescByCode(Integer code) {
        DriverStatusEnum driverTypeEnum = get(code);
        if (driverTypeEnum == null) {
            return null;
        }
        return driverTypeEnum.getDesc();
    }

}
