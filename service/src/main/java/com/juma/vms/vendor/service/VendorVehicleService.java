package com.juma.vms.vendor.service;

import java.util.List;

import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.giants.common.tools.PageCondition;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.vendor.domain.VendorTenant;
import com.juma.vms.vendor.domain.VendorVehicle;
import com.juma.vms.vendor.vo.VendorVehicleQuery;

/**
 * @ClassName VendorVehicleService.java
 * @Description 已废弃
 * @author Libin.Wei
 * @Date 2018年10月30日 下午8:03:27
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

@Deprecated
public interface VendorVehicleService {

    /**
     * 
     * 分页查询
     * 
     * @author Libin.Wei
     * @Date 2018年11月2日 上午10:06:27
     * @param pageCondition
     * @param loginUser
     * @return
     */
    Page<VendorVehicleQuery> search(PageCondition pageCondition, LoginUser loginUser);

    /**
     * 
     * 根据主键获取
     * 
     * @author Libin.Wei
     * @Date 2018年10月31日 上午10:01:09
     * @param vendorVehicleId
     * @return
     * @throws BusinessException
     */
    VendorVehicle getVendorVehicle(Integer vendorVehicleId) throws BusinessException;

    /**
     * 
     * 根据承运商ID与车辆ID获取
     * 
     * @author Libin.Wei
     * @Date 2018年10月31日 上午10:04:18
     * @param vendorId
     *            可空
     * @param vehicleId
     *            可空
     * @param loginUser
     *            必填
     * @return
     * @throws BusinessException
     */
    List<VendorVehicle> listVendorVehicleBy(Integer vendorId, Integer vehicleId, LoginUser loginUser)
            throws BusinessException;

    /**
     * 
     * 添加
     * 
     * @author Libin.Wei
     * @Date 2018年10月31日 上午10:05:16
     * @param vendorVehicle
     * @param loginUser
     * @throws BusinessException
     */
    void insert(VendorVehicle vendorVehicle, LoginUser loginUser) throws BusinessException;

    /**
     * 
     * 批量添加
     * 
     * @author Libin.Wei
     * @Date 2018年11月1日 上午11:54:35
     * @param listVehicleId
     *            车辆ID集合
     * @param vendorId
     *            承运商ID
     * @param loginUser
     *            当前登录人信息
     * @throws BusinessException
     */
    void batchInsert(List<Integer> listVehicleId, Integer vendorId, LoginUser loginUser) throws BusinessException;

    /**
     * 
     * 删除
     * 
     * @author Libin.Wei
     * @Date 2018年10月31日 上午10:05:16
     * @param vendorVehicleId
     * @param loginUser
     * @throws BusinessException
     */
    void delete(Integer vendorVehicleId, LoginUser loginUser) throws BusinessException;

    /**
     * 
     * 根据条件查询
     * 
     * @author Libin.Wei
     * @Date 2018年11月14日 下午8:04:36
     * @param vendorId
     * @param areaCode
     * @param tenantId
     * @return
     */
    List<VendorVehicle> listVendorVehicleBy(Integer vendorId, String areaCode, Integer tenantId);
}
