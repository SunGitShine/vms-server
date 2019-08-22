package com.juma.vms.transport.enumeration;

/**
 * 功能 :
 *
 * @author : Bruce(刘正航) 12:02 2019-04-03
 */
public enum RefundReasonType {

    DRIVER(0,"司机原因"),
    PROJECT(1,"项目原因"),
    FORCE(2,"强制收车")
    ;

    private Integer code;
    private String desc;

    RefundReasonType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static String getRefundReasonTypeDesc(Integer type){
        if( null == type ){
            return null;
        }
        for (RefundReasonType v : RefundReasonType.values()) {
            if (v.getCode().equals(type)) {
                return v.getDesc();
            }
        }
        return null;
    }
}
