package com.juma.vms.driver.enumeration;

public enum RemindSwitchValue {

    OFF(0, "关闭"), ON(1, "开启");

    private RemindSwitchValue(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    private Integer code;
    private String value;

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
