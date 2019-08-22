package com.juma.vms.driver.domain;

import java.io.Serializable;
import java.util.Date;

public class Driver implements Serializable {
    private Integer driverId;

    private String jumaPin;

    private Integer userId;

    private Integer amsDriverId;

    private String name;

    private String sex;

    private String icon;

    private String idCardNo;

    private String idCardImg1;

    private String idCardImg2;

    private String phone;

    private String emergencyContactPhone;

    private Byte canDriveType;

    private Integer driverRunType;

    private String driveLicenseImg1;

    private String driveLicenseImg2;

    private Date driveLicenseFirstTakeTime;

    private Date driveLicenseStartTime;

    private Date driveLicenseEndTime;

    private Boolean telRemindSwitch;

    private Boolean smsRemindSwitch;

    private Boolean isReceiveWaybill;

    private Integer createUserId;

    private Date createTime;

    private Integer lastUpdateUserId;

    private Date lastUpdateTime;

    private static final long serialVersionUID = 1L;

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getJumaPin() {
        return jumaPin;
    }

    public void setJumaPin(String jumaPin) {
        this.jumaPin = jumaPin == null ? null : jumaPin.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAmsDriverId() {
        return amsDriverId;
    }

    public void setAmsDriverId(Integer amsDriverId) {
        this.amsDriverId = amsDriverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo == null ? null : idCardNo.trim();
    }

    public String getIdCardImg1() {
        return idCardImg1;
    }

    public void setIdCardImg1(String idCardImg1) {
        this.idCardImg1 = idCardImg1 == null ? null : idCardImg1.trim();
    }

    public String getIdCardImg2() {
        return idCardImg2;
    }

    public void setIdCardImg2(String idCardImg2) {
        this.idCardImg2 = idCardImg2 == null ? null : idCardImg2.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone == null ? null : emergencyContactPhone.trim();
    }

    public Byte getCanDriveType() {
        return canDriveType;
    }

    public void setCanDriveType(Byte canDriveType) {
        this.canDriveType = canDriveType;
    }

    public Integer getDriverRunType() {
        return driverRunType;
    }

    public void setDriverRunType(Integer driverRunType) {
        this.driverRunType = driverRunType;
    }

    public String getDriveLicenseImg1() {
        return driveLicenseImg1;
    }

    public void setDriveLicenseImg1(String driveLicenseImg1) {
        this.driveLicenseImg1 = driveLicenseImg1 == null ? null : driveLicenseImg1.trim();
    }

    public String getDriveLicenseImg2() {
        return driveLicenseImg2;
    }

    public void setDriveLicenseImg2(String driveLicenseImg2) {
        this.driveLicenseImg2 = driveLicenseImg2 == null ? null : driveLicenseImg2.trim();
    }

    public Date getDriveLicenseFirstTakeTime() {
        return driveLicenseFirstTakeTime;
    }

    public void setDriveLicenseFirstTakeTime(Date driveLicenseFirstTakeTime) {
        this.driveLicenseFirstTakeTime = driveLicenseFirstTakeTime;
    }

    public Date getDriveLicenseStartTime() {
        return driveLicenseStartTime;
    }

    public void setDriveLicenseStartTime(Date driveLicenseStartTime) {
        this.driveLicenseStartTime = driveLicenseStartTime;
    }

    public Date getDriveLicenseEndTime() {
        return driveLicenseEndTime;
    }

    public void setDriveLicenseEndTime(Date driveLicenseEndTime) {
        this.driveLicenseEndTime = driveLicenseEndTime;
    }

    public Boolean getTelRemindSwitch() {
        return telRemindSwitch;
    }

    public void setTelRemindSwitch(Boolean telRemindSwitch) {
        this.telRemindSwitch = telRemindSwitch;
    }

    public Boolean getSmsRemindSwitch() {
        return smsRemindSwitch;
    }

    public void setSmsRemindSwitch(Boolean smsRemindSwitch) {
        this.smsRemindSwitch = smsRemindSwitch;
    }

    public Boolean getIsReceiveWaybill() {
        return isReceiveWaybill;
    }

    public void setIsReceiveWaybill(Boolean isReceiveWaybill) {
        this.isReceiveWaybill = isReceiveWaybill;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(Integer lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
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
        Driver other = (Driver) that;
        return (this.getDriverId() == null ? other.getDriverId() == null : this.getDriverId().equals(other.getDriverId()))
            && (this.getJumaPin() == null ? other.getJumaPin() == null : this.getJumaPin().equals(other.getJumaPin()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAmsDriverId() == null ? other.getAmsDriverId() == null : this.getAmsDriverId().equals(other.getAmsDriverId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getIdCardNo() == null ? other.getIdCardNo() == null : this.getIdCardNo().equals(other.getIdCardNo()))
            && (this.getIdCardImg1() == null ? other.getIdCardImg1() == null : this.getIdCardImg1().equals(other.getIdCardImg1()))
            && (this.getIdCardImg2() == null ? other.getIdCardImg2() == null : this.getIdCardImg2().equals(other.getIdCardImg2()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getEmergencyContactPhone() == null ? other.getEmergencyContactPhone() == null : this.getEmergencyContactPhone().equals(other.getEmergencyContactPhone()))
            && (this.getCanDriveType() == null ? other.getCanDriveType() == null : this.getCanDriveType().equals(other.getCanDriveType()))
            && (this.getDriverRunType() == null ? other.getDriverRunType() == null : this.getDriverRunType().equals(other.getDriverRunType()))
            && (this.getDriveLicenseImg1() == null ? other.getDriveLicenseImg1() == null : this.getDriveLicenseImg1().equals(other.getDriveLicenseImg1()))
            && (this.getDriveLicenseImg2() == null ? other.getDriveLicenseImg2() == null : this.getDriveLicenseImg2().equals(other.getDriveLicenseImg2()))
            && (this.getDriveLicenseFirstTakeTime() == null ? other.getDriveLicenseFirstTakeTime() == null : this.getDriveLicenseFirstTakeTime().equals(other.getDriveLicenseFirstTakeTime()))
            && (this.getDriveLicenseStartTime() == null ? other.getDriveLicenseStartTime() == null : this.getDriveLicenseStartTime().equals(other.getDriveLicenseStartTime()))
            && (this.getDriveLicenseEndTime() == null ? other.getDriveLicenseEndTime() == null : this.getDriveLicenseEndTime().equals(other.getDriveLicenseEndTime()))
            && (this.getTelRemindSwitch() == null ? other.getTelRemindSwitch() == null : this.getTelRemindSwitch().equals(other.getTelRemindSwitch()))
            && (this.getSmsRemindSwitch() == null ? other.getSmsRemindSwitch() == null : this.getSmsRemindSwitch().equals(other.getSmsRemindSwitch()))
            && (this.getIsReceiveWaybill() == null ? other.getIsReceiveWaybill() == null : this.getIsReceiveWaybill().equals(other.getIsReceiveWaybill()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastUpdateUserId() == null ? other.getLastUpdateUserId() == null : this.getLastUpdateUserId().equals(other.getLastUpdateUserId()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDriverId() == null) ? 0 : getDriverId().hashCode());
        result = prime * result + ((getJumaPin() == null) ? 0 : getJumaPin().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAmsDriverId() == null) ? 0 : getAmsDriverId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getIdCardNo() == null) ? 0 : getIdCardNo().hashCode());
        result = prime * result + ((getIdCardImg1() == null) ? 0 : getIdCardImg1().hashCode());
        result = prime * result + ((getIdCardImg2() == null) ? 0 : getIdCardImg2().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getEmergencyContactPhone() == null) ? 0 : getEmergencyContactPhone().hashCode());
        result = prime * result + ((getCanDriveType() == null) ? 0 : getCanDriveType().hashCode());
        result = prime * result + ((getDriverRunType() == null) ? 0 : getDriverRunType().hashCode());
        result = prime * result + ((getDriveLicenseImg1() == null) ? 0 : getDriveLicenseImg1().hashCode());
        result = prime * result + ((getDriveLicenseImg2() == null) ? 0 : getDriveLicenseImg2().hashCode());
        result = prime * result + ((getDriveLicenseFirstTakeTime() == null) ? 0 : getDriveLicenseFirstTakeTime().hashCode());
        result = prime * result + ((getDriveLicenseStartTime() == null) ? 0 : getDriveLicenseStartTime().hashCode());
        result = prime * result + ((getDriveLicenseEndTime() == null) ? 0 : getDriveLicenseEndTime().hashCode());
        result = prime * result + ((getTelRemindSwitch() == null) ? 0 : getTelRemindSwitch().hashCode());
        result = prime * result + ((getSmsRemindSwitch() == null) ? 0 : getSmsRemindSwitch().hashCode());
        result = prime * result + ((getIsReceiveWaybill() == null) ? 0 : getIsReceiveWaybill().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastUpdateUserId() == null) ? 0 : getLastUpdateUserId().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", driverId=").append(driverId);
        sb.append(", jumaPin=").append(jumaPin);
        sb.append(", userId=").append(userId);
        sb.append(", amsDriverId=").append(amsDriverId);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", icon=").append(icon);
        sb.append(", idCardNo=").append(idCardNo);
        sb.append(", idCardImg1=").append(idCardImg1);
        sb.append(", idCardImg2=").append(idCardImg2);
        sb.append(", phone=").append(phone);
        sb.append(", emergencyContactPhone=").append(emergencyContactPhone);
        sb.append(", canDriveType=").append(canDriveType);
        sb.append(", driverRunType=").append(driverRunType);
        sb.append(", driveLicenseImg1=").append(driveLicenseImg1);
        sb.append(", driveLicenseImg2=").append(driveLicenseImg2);
        sb.append(", driveLicenseFirstTakeTime=").append(driveLicenseFirstTakeTime);
        sb.append(", driveLicenseStartTime=").append(driveLicenseStartTime);
        sb.append(", driveLicenseEndTime=").append(driveLicenseEndTime);
        sb.append(", telRemindSwitch=").append(telRemindSwitch);
        sb.append(", smsRemindSwitch=").append(smsRemindSwitch);
        sb.append(", isReceiveWaybill=").append(isReceiveWaybill);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastUpdateUserId=").append(lastUpdateUserId);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        driverId,
        jumaPin,
        userId,
        amsDriverId,
        name,
        sex,
        icon,
        idCardNo,
        idCardImg1,
        idCardImg2,
        phone,
        emergencyContactPhone,
        canDriveType,
        driverRunType,
        driveLicenseImg1,
        driveLicenseImg2,
        driveLicenseFirstTakeTime,
        driveLicenseStartTime,
        driveLicenseEndTime,
        telRemindSwitch,
        smsRemindSwitch,
        isReceiveWaybill,
        createUserId,
        createTime,
        lastUpdateUserId,
        lastUpdateTime;

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