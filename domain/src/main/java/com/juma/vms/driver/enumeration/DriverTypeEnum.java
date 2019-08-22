package com.juma.vms.driver.enumeration;

public enum DriverTypeEnum {
    OWN_SALE( 1, "自营"),
    NOT_OWN_SALE( 2, "非自营");

    private Integer code;
    private String desc;

    DriverTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static DriverTypeEnum get(Integer code) {
        for (DriverTypeEnum typeEnum : DriverTypeEnum.values()) {
            if (typeEnum.code.equals(code)) {
                return typeEnum;
            }
        }
        return null;
    }

    public static String getDescByCode(Integer code) {
        DriverTypeEnum driverTypeEnum = get(code);
        if (driverTypeEnum == null) {
            return null;
        }
        return driverTypeEnum.getDesc();
    }

}
