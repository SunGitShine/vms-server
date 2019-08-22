package com.juma.vms.vendor.vo;

import com.juma.vms.driver.domain.DriverTenant;
import com.juma.vms.driver.enumeration.DriverStatusEnum;
import com.juma.vms.vendor.domain.VendorDriver;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "承运商关联司机")
public class VendorDriverQuery implements Serializable {

    private Integer vendorDriverId;
    private Integer vendorId;
    private Integer driverId;
    private Integer tenantId;
    private String tenantCode;
    @ApiModelProperty(value = "司机姓名")
    private String driverName;
    @ApiModelProperty(value = "司机电话")
    private String driverPhone;
    @ApiModelProperty(value = "司机状态代码")
    private Integer driverStatus;
    @ApiModelProperty(value = "司机状态名称")
    private String driverStatusName;
    @ApiModelProperty(value = "司机加入时间")
    private Date createTime;

    public VendorDriverQuery() {
    }

    public VendorDriverQuery(VendorDriver vendorDriver) {
        if (null == vendorDriver) {
            return;
        }

        this.vendorDriverId = vendorDriver.getVendorDriverId();
        this.vendorId = vendorDriver.getTenantId();
        this.driverId = vendorDriver.getDriverId();
        this.tenantId = vendorDriver.getTenantId();
        this.tenantCode = vendorDriver.getTenantCode();
    }

    public Integer getVendorDriverId() {
        return vendorDriverId;
    }

    public void setVendorDriverId(Integer vendorDriverId) {
        this.vendorDriverId = vendorDriverId;
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

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
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

    public Integer getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(Integer driverStatus) {
        this.driverStatus = driverStatus;
    }

    public String getDriverStatusName() {
        if (StringUtils.isNotBlank(driverStatusName)) {
            return driverStatusName;
        }

        return DriverStatusEnum.getDescByCode(driverStatus);
    }

    public void setDriverStatusName(String driverStatusName) {
        this.driverStatusName = driverStatusName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
