package com.juma.vms.truck.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "车辆信息")
public class Truck implements Serializable {
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

    private Integer createUserId;

    private Date lastUpdateTime;

    private Integer lastUpdateUserId;

    private static final long serialVersionUID = 1L;

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
        this.plateNumber = plateNumber == null ? null : plateNumber.trim();
    }

    public String getTruckIdentificationNo() {
        return truckIdentificationNo;
    }

    public void setTruckIdentificationNo(String truckIdentificationNo) {
        this.truckIdentificationNo = truckIdentificationNo == null ? null : truckIdentificationNo.trim();
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
        this.licenseCertificateImg1 = licenseCertificateImg1 == null ? null : licenseCertificateImg1.trim();
    }

    public String getLicenseCertificateImg2() {
        return licenseCertificateImg2;
    }

    public void setLicenseCertificateImg2(String licenseCertificateImg2) {
        this.licenseCertificateImg2 = licenseCertificateImg2 == null ? null : licenseCertificateImg2.trim();
    }

    public String getPermitLicenseImg1() {
        return permitLicenseImg1;
    }

    public void setPermitLicenseImg1(String permitLicenseImg1) {
        this.permitLicenseImg1 = permitLicenseImg1 == null ? null : permitLicenseImg1.trim();
    }

    public String getPermitLicenseImg2() {
        return permitLicenseImg2;
    }

    public void setPermitLicenseImg2(String permitLicenseImg2) {
        this.permitLicenseImg2 = permitLicenseImg2 == null ? null : permitLicenseImg2.trim();
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
        this.truckBodyImg = truckBodyImg == null ? null : truckBodyImg.trim();
    }

    public Boolean getIsTailBoard() {
        return isTailBoard;
    }

    public void setIsTailBoard(Boolean isTailBoard) {
        this.isTailBoard = isTailBoard;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(Integer lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Truck other = (Truck) that;
        return (this.getTruckId() == null ? other.getTruckId() == null : this.getTruckId().equals(other.getTruckId()))
            && (this.getVehicleId() == null ? other.getVehicleId() == null : this.getVehicleId().equals(other.getVehicleId()))
            && (this.getPlateNumber() == null ? other.getPlateNumber() == null : this.getPlateNumber().equals(other.getPlateNumber()))
            && (this.getTruckIdentificationNo() == null ? other.getTruckIdentificationNo() == null : this.getTruckIdentificationNo().equals(other.getTruckIdentificationNo()))
            && (this.getLicenseType() == null ? other.getLicenseType() == null : this.getLicenseType().equals(other.getLicenseType()))
            && (this.getLicenseCertificateImg1() == null ? other.getLicenseCertificateImg1() == null : this.getLicenseCertificateImg1().equals(other.getLicenseCertificateImg1()))
            && (this.getLicenseCertificateImg2() == null ? other.getLicenseCertificateImg2() == null : this.getLicenseCertificateImg2().equals(other.getLicenseCertificateImg2()))
            && (this.getPermitLicenseImg1() == null ? other.getPermitLicenseImg1() == null : this.getPermitLicenseImg1().equals(other.getPermitLicenseImg1()))
            && (this.getPermitLicenseImg2() == null ? other.getPermitLicenseImg2() == null : this.getPermitLicenseImg2().equals(other.getPermitLicenseImg2()))
            && (this.getVehicleBoxType() == null ? other.getVehicleBoxType() == null : this.getVehicleBoxType().equals(other.getVehicleBoxType()))
            && (this.getVehicleBoxLength() == null ? other.getVehicleBoxLength() == null : this.getVehicleBoxLength().equals(other.getVehicleBoxLength()))
            && (this.getTruckRunType() == null ? other.getTruckRunType() == null : this.getTruckRunType().equals(other.getTruckRunType()))
            && (this.getEnergyType() == null ? other.getEnergyType() == null : this.getEnergyType().equals(other.getEnergyType()))
            && (this.getEnergyOutType() == null ? other.getEnergyOutType() == null : this.getEnergyOutType().equals(other.getEnergyOutType()))
            && (this.getGoCityLicenseType() == null ? other.getGoCityLicenseType() == null : this.getGoCityLicenseType().equals(other.getGoCityLicenseType()))
            && (this.getTruckBodyImg() == null ? other.getTruckBodyImg() == null : this.getTruckBodyImg().equals(other.getTruckBodyImg()))
            && (this.getIsTailBoard() == null ? other.getIsTailBoard() == null : this.getIsTailBoard().equals(other.getIsTailBoard()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateUserId() == null ? other.getLastUpdateUserId() == null : this.getLastUpdateUserId().equals(other.getLastUpdateUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTruckId() == null) ? 0 : getTruckId().hashCode());
        result = prime * result + ((getVehicleId() == null) ? 0 : getVehicleId().hashCode());
        result = prime * result + ((getPlateNumber() == null) ? 0 : getPlateNumber().hashCode());
        result = prime * result + ((getTruckIdentificationNo() == null) ? 0 : getTruckIdentificationNo().hashCode());
        result = prime * result + ((getLicenseType() == null) ? 0 : getLicenseType().hashCode());
        result = prime * result + ((getLicenseCertificateImg1() == null) ? 0 : getLicenseCertificateImg1().hashCode());
        result = prime * result + ((getLicenseCertificateImg2() == null) ? 0 : getLicenseCertificateImg2().hashCode());
        result = prime * result + ((getPermitLicenseImg1() == null) ? 0 : getPermitLicenseImg1().hashCode());
        result = prime * result + ((getPermitLicenseImg2() == null) ? 0 : getPermitLicenseImg2().hashCode());
        result = prime * result + ((getVehicleBoxType() == null) ? 0 : getVehicleBoxType().hashCode());
        result = prime * result + ((getVehicleBoxLength() == null) ? 0 : getVehicleBoxLength().hashCode());
        result = prime * result + ((getTruckRunType() == null) ? 0 : getTruckRunType().hashCode());
        result = prime * result + ((getEnergyType() == null) ? 0 : getEnergyType().hashCode());
        result = prime * result + ((getEnergyOutType() == null) ? 0 : getEnergyOutType().hashCode());
        result = prime * result + ((getGoCityLicenseType() == null) ? 0 : getGoCityLicenseType().hashCode());
        result = prime * result + ((getTruckBodyImg() == null) ? 0 : getTruckBodyImg().hashCode());
        result = prime * result + ((getIsTailBoard() == null) ? 0 : getIsTailBoard().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateUserId() == null) ? 0 : getLastUpdateUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", truckId=").append(truckId);
        sb.append(", vehicleId=").append(vehicleId);
        sb.append(", plateNumber=").append(plateNumber);
        sb.append(", truckIdentificationNo=").append(truckIdentificationNo);
        sb.append(", licenseType=").append(licenseType);
        sb.append(", licenseCertificateImg1=").append(licenseCertificateImg1);
        sb.append(", licenseCertificateImg2=").append(licenseCertificateImg2);
        sb.append(", permitLicenseImg1=").append(permitLicenseImg1);
        sb.append(", permitLicenseImg2=").append(permitLicenseImg2);
        sb.append(", vehicleBoxType=").append(vehicleBoxType);
        sb.append(", vehicleBoxLength=").append(vehicleBoxLength);
        sb.append(", truckRunType=").append(truckRunType);
        sb.append(", energyType=").append(energyType);
        sb.append(", energyOutType=").append(energyOutType);
        sb.append(", goCityLicenseType=").append(goCityLicenseType);
        sb.append(", truckBodyImg=").append(truckBodyImg);
        sb.append(", isTailBoard=").append(isTailBoard);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", lastUpdateUserId=").append(lastUpdateUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        truckId,
        vehicleId,
        plateNumber,
        truckIdentificationNo,
        licenseType,
        licenseCertificateImg1,
        licenseCertificateImg2,
        permitLicenseImg1,
        permitLicenseImg2,
        vehicleBoxType,
        vehicleBoxLength,
        truckRunType,
        energyType,
        energyOutType,
        goCityLicenseType,
        truckBodyImg,
        isTailBoard,
        createTime,
        createUserId,
        lastUpdateTime,
        lastUpdateUserId;

        public String asc() {
            return column() + " ASC";
        }

        public String desc() {
            return column() + " DESC";
        }

        private String column() {
            StringBuilder buffer = new StringBuilder();
            char[] charArray = this.name().toCharArray();
            for(char ch : charArray) {
                if(Character.isUpperCase(ch)){
                    buffer.append("_");
                    buffer.append(Character.toLowerCase(ch));
                } else {
                    buffer.append(ch);
                }
            }
            return buffer.toString();
        }
    }
}