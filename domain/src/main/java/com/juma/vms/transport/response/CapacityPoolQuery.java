package com.juma.vms.transport.response;

import com.juma.vms.transport.domain.CapacityPool;
import com.juma.vms.truck.enumeration.TruckRunTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.StringUtils;

@ApiModel(value = "承运商运力")
public class CapacityPoolQuery extends CapacityPool {

    @ApiModelProperty(value = "车牌号")
    private String plateNumber;
    @ApiModelProperty(value = "车架号")
    private String frameNo;
    @ApiModelProperty(value = "车型")
    private String truckTypeName;
    @ApiModelProperty(value = "业务区域名称")
    private String areaName;
    @ApiModelProperty(value = "车辆类型代码")
    private Integer truckRunType;
    @ApiModelProperty(value = "车辆类型名称")
    private String truckRunTypeName;
    @ApiModelProperty(value = "司机名称")
    private String driverName;
    @ApiModelProperty(value = "司机手机号")
    private String driverPhone;
    @ApiModelProperty(value = "运力状态名称")
    private String transPortStatusName;

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getFrameNo() {
        return frameNo;
    }

    public void setFrameNo(String frameNo) {
        this.frameNo = frameNo;
    }

    public String getTruckTypeName() {
        return truckTypeName;
    }

    public void setTruckTypeName(String truckTypeName) {
        this.truckTypeName = truckTypeName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getTruckRunType() {
        return truckRunType;
    }

    public void setTruckRunType(Integer truckRunType) {
        this.truckRunType = truckRunType;
    }

    public String getTruckRunTypeName() {
        if (StringUtils.isNotBlank(truckRunTypeName)) {
            return truckRunTypeName;
        }

        return TruckRunTypeEnum.getDescByCode(truckRunType);
    }

    public void setTruckRunTypeName(String truckRunTypeName) {
        this.truckRunTypeName = truckRunTypeName;
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

    public String getTransPortStatusName() {
        if (StringUtils.isNotBlank(transPortStatusName)) {
            return transPortStatusName;
        }

        return super.getStatus() == null ? "未知" : (super.getStatus() ? "有效" : "无效");
    }

    public void setTransPortStatusName(String transPortStatusName) {
        this.transPortStatusName = transPortStatusName;
    }
}
