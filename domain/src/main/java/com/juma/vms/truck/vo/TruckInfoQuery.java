package com.juma.vms.truck.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 功能 :
 * 卡车信息查询:不关联运力池的车辆状态
 * 注意 :
 * 这里的车牌号,是精确查询;
 * 车牌号是主查询条件
 * @author : Bruce(刘正航) 10:13 2019-04-04
 */
@ApiModel("车辆查询参数")
public class TruckInfoQuery {
    @ApiModelProperty("车牌号(用于精确查询的车牌号)")
    private String plateNumber;
    @ApiModelProperty("当前车辆的认领公司")
    private Integer departmentId;
    @ApiModelProperty("当前车辆的认领公司")
    private String departmentCode;
    @ApiModelProperty("车辆运营类型")
    private Integer truckRunType;
    @ApiModelProperty("车辆运营类型(多个值)")
    private List<Integer> truckRunTypes;
    @ApiModelProperty("车辆状态")
    private Integer truckStatus;
    @ApiModelProperty("每页条数")
    private Integer pageSize;

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getTruckRunType() {
        return truckRunType;
    }

    public void setTruckRunType(Integer truckRunType) {
        this.truckRunType = truckRunType;
    }

    public List<Integer> getTruckRunTypes() {
        return truckRunTypes;
    }

    public void setTruckRunTypes(List<Integer> truckRunTypes) {
        this.truckRunTypes = truckRunTypes;
    }

    public Integer getTruckStatus() {
        return truckStatus;
    }

    public void setTruckStatus(Integer truckStatus) {
        this.truckStatus = truckStatus;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
}
