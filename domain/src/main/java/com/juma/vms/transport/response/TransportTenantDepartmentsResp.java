package com.juma.vms.transport.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 功能 :
 *
 * @author : Bruce(刘正航) 09:25 2019-03-25
 */
@ApiModel(value = "当前租户的全部部门")
public class TransportTenantDepartmentsResp implements Serializable {

    @ApiModelProperty(value = "输送公司ID")
    private Integer departmentId;

    @ApiModelProperty(value = "输送公司ID")
    private String departmentName;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
