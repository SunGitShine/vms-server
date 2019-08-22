package com.juma.vms.transport.enumeration;

/**
 * 功能 :
 *
 * @author : Bruce(刘正航) 16:57 2019-04-15
 */
public enum TransportType {

    PUSH(1,"推送"),
    ;

    private Integer code;
    private String desc;

    TransportType(Integer code, String desc) {
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

    public static String getDescByCode(Integer code){
        if( null == code ){
            return null;
        }
        for (TransportType type : TransportType.values()) {
            if( type.getCode().equals(code) ){
                return type.getDesc();
            }
        }
        return null;
    }
}
