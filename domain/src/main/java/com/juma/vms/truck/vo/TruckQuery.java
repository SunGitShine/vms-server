package com.juma.vms.truck.vo;

import com.juma.vms.truck.domain.Truck;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TruckQuery extends Truck implements Serializable {

    private Integer tenantId;
    private Byte isOwner;
    private List<String> areaCodeList = new ArrayList<>();
    @ApiModelProperty(value = "业务区域编码")
    private String areaCode;
    @ApiModelProperty(value = "业务区域名称")
    private String areaName;
    @ApiModelProperty(value = "车型id")
    private Integer truckTypeId;
    @ApiModelProperty(value = "车型名称")
    private String truckTypeName;
    @ApiModelProperty(value = "承运商id")
    private Integer vendorId;
    @ApiModelProperty(value = "承运商名称")
    private String vendorName;
    @ApiModelProperty(value = "承运商证件号")
    private String vendorIdCardNo;
    @ApiModelProperty(value = "承运商手机")
    private String vendorPhone;
    @ApiModelProperty(value = "司机id")
    private Integer driverId;
    @ApiModelProperty(value = "司机名称")
    private String driverName;
    @ApiModelProperty(value = "司机手机号")
    private String driverPhone;
    @ApiModelProperty(value = "认领公司id")
    private Integer truckBelongToCompany;
    @ApiModelProperty(value = "认领公司名称")
    private String truckBelongToCompanyName;
    @ApiModelProperty(value = "部门code")
    private String departmentCode;
    @ApiModelProperty(value = "是否绑定司机")
    private Boolean haveDriver;
    @ApiModelProperty(value = "是否删除")
    private Boolean isDelete;
    private Integer truckTenantId;
    private Integer status;
    @ApiModelProperty(value = "承运商状态")
    private Boolean isEnable;
    @ApiModelProperty(value = "开始时间")
    private Date startTime;
    @ApiModelProperty(value = "结束时间")
    private Date endTime;


    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTruckTenantId() {
        return truckTenantId;
    }

    public void setTruckTenantId(Integer truckTenantId) {
        this.truckTenantId = truckTenantId;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean delete) {
        isDelete = delete;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public Boolean getHaveDriver() {
        return haveDriver;
    }

    public void setHaveDriver(Boolean haveDriver) {
        this.haveDriver = haveDriver;
    }

    public List<String> getAreaCodeList() {
        return areaCodeList;
    }

    public void setAreaCodeList(List<String> areaCodeList) {
        this.areaCodeList = areaCodeList;
    }

    public String getTruckTypeName() {
        return truckTypeName;
    }

    public void setTruckTypeName(String truckTypeName) {
        this.truckTypeName = truckTypeName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorIdCardNo() {
        return vendorIdCardNo;
    }

    public void setVendorIdCardNo(String vendorIdCardNo) {
        this.vendorIdCardNo = vendorIdCardNo;
    }

    public String getVendorPhone() {
        return vendorPhone;
    }

    public void setVendorPhone(String vendorPhone) {
        this.vendorPhone = vendorPhone;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getTruckBelongToCompanyName() {
        return truckBelongToCompanyName;
    }

    public void setTruckBelongToCompanyName(String truckBelongToCompanyName) {
        this.truckBelongToCompanyName = truckBelongToCompanyName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public Byte getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(Byte isOwner) {
        this.isOwner = isOwner;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getTruckTypeId() {
        return truckTypeId;
    }

    public void setTruckTypeId(Integer truckTypeId) {
        this.truckTypeId = truckTypeId;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Integer getTruckBelongToCompany() {
        return truckBelongToCompany;
    }

    public void setTruckBelongToCompany(Integer truckBelongToCompany) {
        this.truckBelongToCompany = truckBelongToCompany;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
