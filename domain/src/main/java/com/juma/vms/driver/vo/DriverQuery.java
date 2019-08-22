package com.juma.vms.driver.vo;

import com.juma.vms.driver.domain.Driver;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DriverQuery extends Driver implements Serializable {

    private static final long serialVersionUID = -5233542547103031255L;
    private Integer tenantId;
    private String areaCode;
    private List<String> areaCodeList = new ArrayList<>();
    @ApiModelProperty(value="是否归属关系")
    private Boolean isOwner;
    @ApiModelProperty(value="创健方")
    private String tenantName;
    @ApiModelProperty(value="业务区域名称")
    private String areaName;
    @ApiModelProperty(value="承运商id")
    private Integer vendorId;
    @ApiModelProperty(value="承运商名称")
    private String vendorName;
    @ApiModelProperty(value="承运商手机号")
    private String vendorPhone;
    @ApiModelProperty(value="承运商类型")
    private String vendorTypeDesc;
    @ApiModelProperty(value="承运商业务范围")
    private String vendorAreaName;
    @ApiModelProperty(value="承运业务联系人")
    private String contactUserName;
    @ApiModelProperty(value="承运商状态")
    private String enableName;
    @ApiModelProperty(value="车辆ID")
    private Integer truckId;
    @ApiModelProperty(value="车牌号")
    private String plateNumber;
    @ApiModelProperty(value="车型")
    private String truckTypeName;
    @ApiModelProperty(value="车辆类型")
    private Integer truckRunType;
    @ApiModelProperty(value="车辆业务范围")
    private String truckAreaName;
    @ApiModelProperty(value="车辆状态 0:已停用  1:正常 2退车中 3已退车")
    private Integer truckStatus;
    @ApiModelProperty(value="司机名称或手机号")
    private String nameOrPhone;
    private Integer label;
    private String driverCanDriveType;
    @ApiModelProperty(value="司机准驾车型名称")
    private String canDriveTypeName;
    private String remark;
    private Integer status;
    private Integer driverTenantId;
    private Boolean excludeTenant;

    public String getContactUserName() {
        return contactUserName;
    }

    public void setContactUserName(String contactUserName) {
        this.contactUserName = contactUserName;
    }

    public Integer getDriverTenantId() {
        return driverTenantId;
    }

    public void setDriverTenantId(Integer driverTenantId) {
        this.driverTenantId = driverTenantId;
    }

    public Boolean getExcludeTenant() {
        return excludeTenant;
    }

    public void setExcludeTenant(Boolean excludeTenant) {
        this.excludeTenant = excludeTenant;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCanDriveTypeName() {
        return canDriveTypeName;
    }

    public void setCanDriveTypeName(String canDriveTypeName) {
        this.canDriveTypeName = canDriveTypeName;
    }

    public String getDriverCanDriveType() {
        return driverCanDriveType;
    }

    public void setDriverCanDriveType(String driverCanDriveType) {
        this.driverCanDriveType = driverCanDriveType;
    }

    public Integer getLabel() {
        return label;
    }

    public void setLabel(Integer label) {
        this.label = label;
    }

    public String getNameOrPhone() {
        return nameOrPhone;
    }

    public void setNameOrPhone(String nameOrPhone) {
        this.nameOrPhone = nameOrPhone;
    }

    public List<String> getAreaCodeList() {
        return areaCodeList;
    }

    public void setAreaCodeList(List<String> areaCodeList) {
        this.areaCodeList = areaCodeList;
    }

    public Boolean getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(Boolean isOwner) {
        this.isOwner = isOwner;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorPhone() {
        return vendorPhone;
    }

    public void setVendorPhone(String vendorPhone) {
        this.vendorPhone = vendorPhone;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getVendorTypeDesc() {
        return vendorTypeDesc;
    }

    public void setVendorTypeDesc(String vendorTypeDesc) {
        this.vendorTypeDesc = vendorTypeDesc;
    }

    public String getEnableName() {
        return enableName;
    }

    public void setEnableName(String enableName) {
        this.enableName = enableName;
    }

    public Integer getTruckId() {
        return truckId;
    }

    public void setTruckId(Integer truckId) {
        this.truckId = truckId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getTruckTypeName() {
        return truckTypeName;
    }

    public void setTruckTypeName(String truckTypeName) {
        this.truckTypeName = truckTypeName;
    }

    public Integer getTruckRunType() {
        return truckRunType;
    }

    public void setTruckRunType(Integer truckRunType) {
        this.truckRunType = truckRunType;
    }

    public Integer getTruckStatus() {
        return truckStatus;
    }

    public void setTruckStatus(Integer truckStatus) {
        this.truckStatus = truckStatus;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getVendorAreaName() {
        return vendorAreaName;
    }

    public void setVendorAreaName(String vendorAreaName) {
        this.vendorAreaName = vendorAreaName;
    }

    public String getTruckAreaName() {
        return truckAreaName;
    }

    public void setTruckAreaName(String truckAreaName) {
        this.truckAreaName = truckAreaName;
    }
}
