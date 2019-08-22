package com.juma.vms.transport.domain;

import java.io.Serializable;
import java.util.Date;

public class TransportCapacityItem implements Serializable {
    private Integer itemId;

    private Integer transportId;

    private String areaCode;

    private Integer truckId;

    private Integer vehicleId;

    private String plateNumber;

    private String truckIdentificationNo;

    private Integer vehicleBoxType;

    private Integer vehicleBoxLength;

    private String tslOrderNo;

    private Integer crmCustomerId;

    private Boolean status;

    private Integer createUserId;

    private Date createTime;

    private Date lastUpdateTime;

    private Integer lastUpdateUserId;

    private static final long serialVersionUID = 1L;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getTransportId() {
        return transportId;
    }

    public void setTransportId(Integer transportId) {
        this.transportId = transportId;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

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

    public String getTslOrderNo() {
        return tslOrderNo;
    }

    public void setTslOrderNo(String tslOrderNo) {
        this.tslOrderNo = tslOrderNo == null ? null : tslOrderNo.trim();
    }

    public Integer getCrmCustomerId() {
        return crmCustomerId;
    }

    public void setCrmCustomerId(Integer crmCustomerId) {
        this.crmCustomerId = crmCustomerId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
        TransportCapacityItem other = (TransportCapacityItem) that;
        return (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getTransportId() == null ? other.getTransportId() == null : this.getTransportId().equals(other.getTransportId()))
            && (this.getAreaCode() == null ? other.getAreaCode() == null : this.getAreaCode().equals(other.getAreaCode()))
            && (this.getTruckId() == null ? other.getTruckId() == null : this.getTruckId().equals(other.getTruckId()))
            && (this.getVehicleId() == null ? other.getVehicleId() == null : this.getVehicleId().equals(other.getVehicleId()))
            && (this.getPlateNumber() == null ? other.getPlateNumber() == null : this.getPlateNumber().equals(other.getPlateNumber()))
            && (this.getTruckIdentificationNo() == null ? other.getTruckIdentificationNo() == null : this.getTruckIdentificationNo().equals(other.getTruckIdentificationNo()))
            && (this.getVehicleBoxType() == null ? other.getVehicleBoxType() == null : this.getVehicleBoxType().equals(other.getVehicleBoxType()))
            && (this.getVehicleBoxLength() == null ? other.getVehicleBoxLength() == null : this.getVehicleBoxLength().equals(other.getVehicleBoxLength()))
            && (this.getTslOrderNo() == null ? other.getTslOrderNo() == null : this.getTslOrderNo().equals(other.getTslOrderNo()))
            && (this.getCrmCustomerId() == null ? other.getCrmCustomerId() == null : this.getCrmCustomerId().equals(other.getCrmCustomerId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateUserId() == null ? other.getLastUpdateUserId() == null : this.getLastUpdateUserId().equals(other.getLastUpdateUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getTransportId() == null) ? 0 : getTransportId().hashCode());
        result = prime * result + ((getAreaCode() == null) ? 0 : getAreaCode().hashCode());
        result = prime * result + ((getTruckId() == null) ? 0 : getTruckId().hashCode());
        result = prime * result + ((getVehicleId() == null) ? 0 : getVehicleId().hashCode());
        result = prime * result + ((getPlateNumber() == null) ? 0 : getPlateNumber().hashCode());
        result = prime * result + ((getTruckIdentificationNo() == null) ? 0 : getTruckIdentificationNo().hashCode());
        result = prime * result + ((getVehicleBoxType() == null) ? 0 : getVehicleBoxType().hashCode());
        result = prime * result + ((getVehicleBoxLength() == null) ? 0 : getVehicleBoxLength().hashCode());
        result = prime * result + ((getTslOrderNo() == null) ? 0 : getTslOrderNo().hashCode());
        result = prime * result + ((getCrmCustomerId() == null) ? 0 : getCrmCustomerId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
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
        sb.append(", itemId=").append(itemId);
        sb.append(", transportId=").append(transportId);
        sb.append(", areaCode=").append(areaCode);
        sb.append(", truckId=").append(truckId);
        sb.append(", vehicleId=").append(vehicleId);
        sb.append(", plateNumber=").append(plateNumber);
        sb.append(", truckIdentificationNo=").append(truckIdentificationNo);
        sb.append(", vehicleBoxType=").append(vehicleBoxType);
        sb.append(", vehicleBoxLength=").append(vehicleBoxLength);
        sb.append(", tslOrderNo=").append(tslOrderNo);
        sb.append(", crmCustomerId=").append(crmCustomerId);
        sb.append(", status=").append(status);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", lastUpdateUserId=").append(lastUpdateUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        itemId,
        transportId,
        areaCode,
        truckId,
        vehicleId,
        plateNumber,
        truckIdentificationNo,
        vehicleBoxType,
        vehicleBoxLength,
        tslOrderNo,
        crmCustomerId,
        status,
        createUserId,
        createTime,
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