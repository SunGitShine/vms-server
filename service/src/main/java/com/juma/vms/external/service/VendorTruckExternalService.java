package com.juma.vms.external.service;

import com.giants.common.exception.BusinessException;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.vendor.domain.VendorTruck;
import com.juma.vms.vendor.domain.VendorVehicle;

import java.util.List;

/**
 * @ClassName VendorExternalService.java
 * @Description 承运商对外类
 * @author Libin.Wei
 * @Date 2018年10月31日 下午7:07:57
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

public interface VendorTruckExternalService {

    /**
     * 
     * 获取单条承运商与车辆的关系
     * 
     * @author Libin.Wei
     * @Date 2018年11月2日 下午2:02:22
     * @param vendorId
     *            承运商ID，必填
     * @param truckId
     *            车辆ID，必填
     * @param tenantId
     *            租户ID，必填
     * @return
     * @throws BusinessException
     */
    VendorTruck loadByVendorAndTruck(Integer vendorId, Integer truckId, Integer tenantId)
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
    VendorTruck loadByVendorIdAndPlateNumber(Integer vendorId, String plateNumber, LoginUser loginUser)
            throws BusinessException;

    /**
     * 
     * 获取租户下承运商与
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
    List<VendorTruck> listVendorTruckBy(Integer vendorId, Integer tenantId)
            throws BusinessException;

    /**
     * 根据truckId获取关联关系
     *
     * @param truckId
     * @param loginUser
     * @return
     */
    VendorTruck loadVendorTruckByTruckId(Integer truckId, LoginUser loginUser);
}
