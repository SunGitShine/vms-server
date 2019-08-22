package com.juma.vms.transport.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 功能:添加承运商之前,需要加载的部分信息
 * 返回结果:
 * crmCustomerType(个人/公司)
 * crmCustomerName(客户名称=承运商名称=联系人)
 * 个人:
 * 	crmIdentificationCard(身份证号)
 * 	contactPhone联系电话(客户电话)
 * 公司:
 * 	crmCreditCode(客户(公司)信用代码)
 * 	前端设置:运营方式(默认:非自营)
 * 	业务范围(客户对应的业务范围)
 * 判断当前客户是否是司机,如果是,则返回driverId
 * 添加承运商 准备信息
 * @author : Bruce(刘正航) 12:52 2019-03-27
 */
@ApiModel("创建承运商前置信息")
public class TransportBeforeAddVendorResp implements Serializable {

    @ApiModelProperty(value = "客户类型:2公司/1个人")
    private Integer crmCustomerType;
    @ApiModelProperty(value = "客户名称/承运商名称/联系人")
    private String crmCustomerName;
    @ApiModelProperty(value = "证件号(身份证/社会信用代码)")
    private String crmIdentityCardNo;
    @ApiModelProperty(value = "联系电话")
    private String contactPhone;
    /**tsl系统不提供,不返回给前端**/
    @Deprecated
    @ApiModelProperty(value = "业务范围")
    private String areaCode;
    /**tsl系统不提供,不返回给前端**/
    @Deprecated
    @ApiModelProperty(value = "证件正面")
    private String crmIdentityCardFace;
    /**tsl系统不提供,不返回给前端**/
    @Deprecated
    @ApiModelProperty(value = "证件反面")
    private String crmIdentityCardBack;
    @ApiModelProperty(value = "司机是否属于当前承运商")
    private boolean beCurrDriver;
    @ApiModelProperty(value = "司机ID")
    private Integer driverId;

    public Integer getCrmCustomerType() {
        return crmCustomerType;
    }

    public void setCrmCustomerType(Integer crmCustomerType) {
        this.crmCustomerType = crmCustomerType;
    }

    public String getCrmCustomerName() {
        return crmCustomerName;
    }

    public void setCrmCustomerName(String crmCustomerName) {
        this.crmCustomerName = crmCustomerName;
    }

    public String getCrmIdentityCardNo() {
        return crmIdentityCardNo;
    }

    public void setCrmIdentityCardNo(String crmIdentityCardNo) {
        this.crmIdentityCardNo = crmIdentityCardNo;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getCrmIdentityCardFace() {
        return crmIdentityCardFace;
    }

    public void setCrmIdentityCardFace(String crmIdentityCardFace) {
        this.crmIdentityCardFace = crmIdentityCardFace;
    }

    public String getCrmIdentityCardBack() {
        return crmIdentityCardBack;
    }

    public void setCrmIdentityCardBack(String crmIdentityCardBack) {
        this.crmIdentityCardBack = crmIdentityCardBack;
    }

    public boolean isBeCurrDriver() {
        return beCurrDriver;
    }

    public void setBeCurrDriver(boolean beCurrDriver) {
        this.beCurrDriver = beCurrDriver;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }
}
