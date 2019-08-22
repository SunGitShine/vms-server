package com.juma.vms.truck.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 功能 :
 * 关联表查询条件
 * @author : Bruce(刘正航) 10:59 2019-04-04
 */
@ApiModel("卡车租户表查询条件")
public class TruckTenantQuery {

    @ApiModelProperty("认领公司ID集合")
    private List<Integer> departmentIds;
    @ApiModelProperty("认领公司ID集合")
    private List<Integer> truckIds;
    private String departmentCode;

    public List<Integer> getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(List<Integer> departmentIds) {
        this.departmentIds = departmentIds;
    }

    public List<Integer> getTruckIds() {
        return truckIds;
    }

    public void setTruckIds(List<Integer> truckIds) {
        this.truckIds = truckIds;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
}
