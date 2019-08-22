package com.juma.vms.mq.domain;

import org.apache.commons.lang3.StringUtils;

public enum  WorkFlowOperate{

    WorkFlow_CANCEL(0,"CANCEL","放弃申请"),
    WorkFlow_REAPPLY(1,"REAPPLY","重新申请");

    private Integer code;
    private String workFlowKey;
    private String desc;

    WorkFlowOperate(Integer code, String workFlowKey, String desc) {
        this.code = code;
        this.workFlowKey = workFlowKey;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getWorkFlowKey() {
        return workFlowKey;
    }

    public void setWorkFlowKey(String workFlowKey) {
        this.workFlowKey = workFlowKey;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static String getWorkFlowOperateDesc(Integer code){
        if( null == code ){
            return null;
        }
        for (WorkFlowOperate status : WorkFlowOperate.values()) {
            if( status.getCode().equals(code)){
                return status.getDesc();
            }
        }
        return null;
    }

    public static Integer getWorkFlowOperateWithWorkKey(String workFlowKey){
        if(StringUtils.isBlank(workFlowKey) ){
            return null;
        }
        for (WorkFlowOperate status : WorkFlowOperate.values()) {
            if( status.getWorkFlowKey().equals(workFlowKey) ){
                return status.getCode();
            }
        }
        return null;
    }

}
