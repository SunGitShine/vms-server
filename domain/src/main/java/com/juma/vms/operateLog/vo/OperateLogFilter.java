package com.juma.vms.operateLog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "日志")
public class OperateLogFilter implements Serializable {

    @ApiModelProperty(value = "查询模块主键，例如：vendorId、truckId")
    private Integer ralationId;
    @ApiModelProperty(value = "业务标识前缀：承运商：VMS_VENDOR；车辆：VMS_TRUCK；司机：VMS_DRIVER")
    private String businessIdentificationPre;

    public Integer getRalationId() {
        return ralationId;
    }

    public void setRalationId(Integer ralationId) {
        this.ralationId = ralationId;
    }

    public String getBusinessIdentificationPre() {
        return businessIdentificationPre;
    }

    public void setBusinessIdentificationPre(String businessIdentificationPre) {
        this.businessIdentificationPre = businessIdentificationPre;
    }
}
