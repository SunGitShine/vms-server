package com.juma.vms.truck.enumeration;

public enum TruckRunTypeEnum {
    OWN_SALE(1, "自营"),
    JOIN( 2, "加盟"),
    EMPLOY( 3, "外请"),
    NO_OWN_SALE( 4, "非自营");

    private Integer code;
    private String desc;

    TruckRunTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static TruckRunTypeEnum get(Integer code) {
        for (TruckRunTypeEnum typeEnum : TruckRunTypeEnum.values()) {
            if (typeEnum.code.equals(code)) {
                return typeEnum;
            }
        }
        return null;
    }

    public static String getDescByCode(Integer code) {
        TruckRunTypeEnum driverTypeEnum = get(code);
        if (driverTypeEnum == null) {
            return null;
        }
        return driverTypeEnum.getDesc();
    }

}
