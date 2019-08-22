package com.juma.vms.transport.enumeration;

/**
 * 功能 :
 * 运力退回单状态(0审批中,1待入库,2已通过,3已撤销,4未通过)
 * @author : Bruce(刘正航) 13:52 2019-04-03
 */
public enum RefundStatus {

    REFUND_APPROVALING(0,"审批中"),
    REFUND_WAITING_STORAGE(1,"待退库"),
    REFUND_APPROVAL_AGREE(2,"已通过"),
    REFUND_APPROVAL_CANCEL(3,"已撤销"),
    REFUND_APPROVAL_FAIL(4,"未通过"),

    ;

    private Integer code;
    private String desc;

    RefundStatus(Integer code, String desc) {
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

    public static String getRefundStatusDesc(Integer code) {
        if (null == code) {
            return null;
        }
        for (RefundStatus status : RefundStatus.values()) {
            if (status.getCode().equals(code)) {
                return status.getDesc();
            }
        }
        return null;
    }

}
