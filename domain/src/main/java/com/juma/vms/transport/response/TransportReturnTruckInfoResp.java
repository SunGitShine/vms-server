package com.juma.vms.transport.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 功能 :
 *
 * @author : Bruce(刘正航) 11:54 2019-04-03
 */
@ApiModel("运力退回信息")
public class TransportReturnTruckInfoResp implements Serializable {

    private Integer truckId;
    private Integer vehicleId;
    @ApiModelProperty(value = "车牌号")
    private String plateNumber;
    @ApiModelProperty(value = "车架号")
    private String truckIdentificationNo;
    @ApiModelProperty(value = "牌照类型 ")
    private Integer licenseType;
    @ApiModelProperty(value = "行驶证正本")
    private String licenseCertificateImg1;
    @ApiModelProperty(value = "行驶证副本")
    private String licenseCertificateImg2;
    @ApiModelProperty(value = "营运证正本")
    private String permitLicenseImg1;
    @ApiModelProperty(value = "营运证副本")
    private String permitLicenseImg2;
    @ApiModelProperty(value = "厢型")
    private Integer vehicleBoxType;
    @ApiModelProperty(value = "长度")
    private Integer vehicleBoxLength;
    @ApiModelProperty(value = "运营类型  1自营2加盟3外请")
    private Integer truckRunType;
    @ApiModelProperty(value = "能耗类型")
    private Integer energyType;
    @ApiModelProperty(value = "能耗排放类别")
    private Integer energyOutType;
    @ApiModelProperty(value = "入城证")
    private Integer goCityLicenseType;
    @ApiModelProperty(value = "车辆图片")
    private String truckBodyImg;
    @ApiModelProperty(value = "尾板")
    private Boolean isTailBoard;

    private Date createTime;

    @ApiModelProperty("输送公司(输送部门)ID")
    private Integer fromTenantId;

    @ApiModelProperty("输送公司(输送部门)CODE")
    private String fromTenantCode;

    @ApiModelProperty("输送公司(输送部门)名称")
    private String fromTenantName;

    @ApiModelProperty("输送公司(输送部门)ID")
    private Integer fromDepartmentId;

    @ApiModelProperty("输送公司(输送部门)Code")
    private String fromDepartmentCode;

    @ApiModelProperty("输送公司(输送部门)名称")
    private String fromDepartmentName;

    @ApiModelProperty("认领公司(认领部门)ID")
    private Integer departmentId;

    @ApiModelProperty("认领公司(认领部门)名称")
    private String departmentName;

    @ApiModelProperty("业务范围")
    private String areaCode;

    @ApiModelProperty("业务范围名称")
    private String areaName;

    @ApiModelProperty("关联承运商ID")
    private Integer vendorId;

    @ApiModelProperty("关联承运商名称")
    private String vendorName;

    @ApiModelProperty("关联承运商电话")
    private String contactPhone;

    @ApiModelProperty("承运商类型:(1个人,2车队,3公司)")
    private Integer vendorType;

    @ApiModelProperty("卡车车型全名")
    private String truckTypeName;

    @ApiModelProperty("是否需要退库")
    private boolean needReturn;

    public Integer getTruckId() {
        return truckId;
    }

    public void setTruckId(Integer truckId) {
        this.truckId = truckId;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getTruckIdentificationNo() {
        return truckIdentificationNo;
    }

    public void setTruckIdentificationNo(String truckIdentificationNo) {
        this.truckIdentificationNo = truckIdentificationNo;
    }

    public Integer getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(Integer licenseType) {
        this.licenseType = licenseType;
    }

    public String getLicenseCertificateImg1() {
        return licenseCertificateImg1;
    }

    public void setLicenseCertificateImg1(String licenseCertificateImg1) {
        this.licenseCertificateImg1 = licenseCertificateImg1;
    }

    public String getLicenseCertificateImg2() {
        return licenseCertificateImg2;
    }

    public void setLicenseCertificateImg2(String licenseCertificateImg2) {
        this.licenseCertificateImg2 = licenseCertificateImg2;
    }

    public String getPermitLicenseImg1() {
        return permitLicenseImg1;
    }

    public void setPermitLicenseImg1(String permitLicenseImg1) {
        this.permitLicenseImg1 = permitLicenseImg1;
    }

    public String getPermitLicenseImg2() {
        return permitLicenseImg2;
    }

    public void setPermitLicenseImg2(String permitLicenseImg2) {
        this.permitLicenseImg2 = permitLicenseImg2;
    }

    public Integer getVehicleBoxType() {
        return vehicleBoxType;
    }

    public void setVehicleBoxType(Integer vehicleBoxType) {
        this.vehicleBoxType = vehicleBoxType;
    }

    public Integer getVehicleBoxLength() {
        return vehicleBoxLength;
    }

    public void setVehicleBoxLength(Integer vehicleBoxLength) {
        this.vehicleBoxLength = vehicleBoxLength;
    }

    public Integer getTruckRunType() {
        return truckRunType;
    }

    public void setTruckRunType(Integer truckRunType) {
        this.truckRunType = truckRunType;
    }

    public Integer getEnergyType() {
        return energyType;
    }

    public void setEnergyType(Integer energyType) {
        this.energyType = energyType;
    }

    public Integer getEnergyOutType() {
        return energyOutType;
    }

    public void setEnergyOutType(Integer energyOutType) {
        this.energyOutType = energyOutType;
    }

    public Integer getGoCityLicenseType() {
        return goCityLicenseType;
    }

    public void setGoCityLicenseType(Integer goCityLicenseType) {
        this.goCityLicenseType = goCityLicenseType;
    }

    public String getTruckBodyImg() {
        return truckBodyImg;
    }

    public void setTruckBodyImg(String truckBodyImg) {
        this.truckBodyImg = truckBodyImg;
    }

    public Boolean getTailBoard() {
        return isTailBoard;
    }

    public void setTailBoard(Boolean tailBoard) {
        isTailBoard = tailBoard;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getFromTenantId() {
        return fromTenantId;
    }

    public void setFromTenantId(Integer fromTenantId) {
        this.fromTenantId = fromTenantId;
    }

    public String getFromTenantCode() {
        return fromTenantCode;
    }

    public void setFromTenantCode(String fromTenantCode) {
        this.fromTenantCode = fromTenantCode;
    }

    public String getFromTenantName() {
        return fromTenantName;
    }

    public void setFromTenantName(String fromTenantName) {
        this.fromTenantName = fromTenantName;
    }

    public Integer getFromDepartmentId() {
        return fromDepartmentId;
    }

    public void setFromDepartmentId(Integer fromDepartmentId) {
        this.fromDepartmentId = fromDepartmentId;
    }

    public String getFromDepartmentCode() {
        return fromDepartmentCode;
    }

    public void setFromDepartmentCode(String fromDepartmentCode) {
        this.fromDepartmentCode = fromDepartmentCode;
    }

    public String getFromDepartmentName() {
        return fromDepartmentName;
    }

    public void setFromDepartmentName(String fromDepartmentName) {
        this.fromDepartmentName = fromDepartmentName;
    }

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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Integer getVendorType() {
        return vendorType;
    }

    public void setVendorType(Integer vendorType) {
        this.vendorType = vendorType;
    }

    public String getTruckTypeName() {
        return truckTypeName;
    }

    public void setTruckTypeName(String truckTypeName) {
        this.truckTypeName = truckTypeName;
    }

    public boolean isNeedReturn() {
        return needReturn;
    }

    public void setNeedReturn(boolean needReturn) {
        this.needReturn = needReturn;
    }
}
