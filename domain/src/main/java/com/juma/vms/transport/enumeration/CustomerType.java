package com.juma.vms.transport.enumeration;

import org.apache.commons.lang3.StringUtils;

/**
 * TSL系统对应的枚举值:
 *  ID_CARD("身份证"),
 * 	MILITARY_ID("军官证"),
 * 	BUSINESS_LICENCES("营业执照(企业信用代码)"),
 * 	OTHER("其他"),
 * @author : Bruce(刘正航) 16:44 2019-04-15
 */
public enum CustomerType {
    INDIVIDUAL(1,"个人"),
    ENTERPRISE(2,"企业");

    private Integer code;
    private String desc;

    CustomerType(Integer code, String desc) {
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

    public static String getDescByCode(Integer code) {
        if( null == code ){
            return null;
        }
        for (CustomerType type : CustomerType.values()) {
            if( type.getCode().equals(code) ){
                return type.getDesc();
            }
        }
        return null;
    }

    public static Integer getCodeByScmCode(String scmCode){
        if(StringUtils.isBlank(scmCode) ){
            return null;
        }
        if( "ID_CARD".equals(scmCode) ){
            return CustomerType.INDIVIDUAL.getCode();
        }
        if( "MILITARY_ID".equals(scmCode) ){
            return CustomerType.INDIVIDUAL.getCode();
        }
        if( "BUSINESS_LICENCES".equals(scmCode) ){
            return CustomerType.ENTERPRISE.getCode();
        }
        return null;
    }
}
