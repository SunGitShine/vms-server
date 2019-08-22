package com.juma.vms.transport.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 功能 : 
 *
 * @author : Bruce(刘正航) 11:18 2019-05-17
 */
@ApiModel("车辆输送详情")
public class TransportFilter implements Serializable {
    @ApiModelProperty("车辆输送ID集合")
    private Integer transportId;
    @ApiModelProperty("车辆输送ID集合")
    private List<Integer> transportIds;
    @ApiModelProperty("车辆输送部门ID")
    private Integer fromDepartmentId;
    @ApiModelProperty("车辆输送部门集合")
    private List<Integer> fromDepartmentIds;
    @ApiModelProperty("车辆输送部门ID")
    private Integer toDepartmentId;
    @ApiModelProperty("车辆输送部门集合")
    private List<Integer> toDepartmentIds;

    public Integer getTransportId() {
        return transportId;
    }

    public void setTransportId(Integer transportId) {
        this.transportId = transportId;
    }

    public List<Integer> getTransportIds() {
        return transportIds;
    }

    public void setTransportIds(List<Integer> transportIds) {
        this.transportIds = transportIds;
    }

    public Integer getFromDepartmentId() {
        return fromDepartmentId;
    }

    public void setFromDepartmentId(Integer fromDepartmentId) {
        this.fromDepartmentId = fromDepartmentId;
    }

    public List<Integer> getFromDepartmentIds() {
        return fromDepartmentIds;
    }

    public void setFromDepartmentIds(List<Integer> fromDepartmentIds) {
        this.fromDepartmentIds = fromDepartmentIds;
    }

    public Integer getToDepartmentId() {
        return toDepartmentId;
    }

    public void setToDepartmentId(Integer toDepartmentId) {
        this.toDepartmentId = toDepartmentId;
    }

    public List<Integer> getToDepartmentIds() {
        return toDepartmentIds;
    }

    public void setToDepartmentIds(List<Integer> toDepartmentIds) {
        this.toDepartmentIds = toDepartmentIds;
    }
}
