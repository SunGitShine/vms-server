package com.juma.vms.external.service;

import java.util.List;

import com.giants.common.exception.BusinessException;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.vendor.domain.VendorVehicle;

/**
 * @ClassName VendorExternalService.java
 * @Description 承运商对外类
 * @author Libin.Wei
 * @Date 2018年10月31日 下午7:07:57
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

@Deprecated
public interface VendorVehicleExternalService {

    /**
     * 
     * 获取单条承运商与车辆的关系
     * 
     * @author Libin.Wei
     * @Date 2018年11月2日 下午2:02:22
     * @param vendorId
     *            承运商ID，必填
     * @param vehicleId
     *            车辆ID，必填
     * @param tenantId
     *            租户ID，必填
     * @return
     * @throws BusinessException
     */
    VendorVehicle loadByVendorAndVehicle(Integer vendorId, Integer vehicleId, Integer tenantId)
            throws BusinessException;

    /**
     * 
     * 获取单条承运商与车辆的关系
     * 
     * @author Libin.Wei
     * @Date 2018年11月2日 下午2:02:22
     * @param vendorId
     *            承运商ID，必填
     * @param plateNumber
     *            车车牌号，必填
     * @param loginUser
     *            当前登录人信息, 不能为空，必须含有租户信息
     * @return
     * @throws BusinessException
     */
    VendorVehicle loadByVendorAndPlateNumber(Integer vendorId, String plateNumber, LoginUser loginUser)
            throws BusinessException;

    /**
     * 
     * 不再对外提供服务：----解除车辆
     * 
     * @author Libin.Wei
     * @Date 2018年11月1日 上午10:45:02
     * @param vendorId
     *            承运商ID，不能为空
     * @param vehicleId
     *            车辆ID，不能为空
     * @param authKey
     *            系统KEY， 必填
     * @param loginUser
     *            当前登录人信息, 不能为空，必须含有租户信息
     */
    @Deprecated
    void unbindVehicle(Integer vendorId, Integer vehicleId, String authKey, LoginUser loginUser)
            throws BusinessException;

    /**
     * 
     * 不再对外提供服务：----绑定车辆
     * 
     * @author Libin.Wei
     * @Date 2018年11月1日 上午11:50:40
     * @param listVehicleId
     *            车辆ID列表
     * @param vendorId
     *            承运商ID
     * @param authKey
     *            系统KEY， 必填
     * @param loginUser
     *            当前登录人信息, 不能为空，必须含有租户信息
     * @throws BusinessException
     */
    @Deprecated
    void bindVehicle(List<Integer> listVehicleId, Integer vendorId, String authKey, LoginUser loginUser)
            throws BusinessException;

    /**
     * 
     * 请写注释...
     * 
     * @author Libin.Wei
     * @Date 2018年11月14日 下午6:44:28
     * @param vendorId
     *            承运商ID， 必填
     * @param tenantId
     *            租户ID， 必填
     * @return
     * @throws BusinessException
     */
    List<VendorVehicle> listVendorVehicleBy(Integer vendorId, Integer tenantId)
            throws BusinessException;
}
