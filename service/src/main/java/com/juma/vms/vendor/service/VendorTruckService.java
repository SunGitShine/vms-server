package com.juma.vms.vendor.service;

import java.util.List;

import com.giants.common.exception.BusinessException;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.vendor.domain.VendorTruck;

/**
 * @description: ${description}
 * @author: xieqiang
 * @create: 2019-03-20 17:24
 **/
public interface VendorTruckService {

    void addVendorTruck(VendorTruck vendorTruck, LoginUser loginUser);

    /**
     * 根据车辆ID获取
     *
     * @param truckId
     * @param loginUser
     * @return
     */
    VendorTruck loadByTruckId(Integer truckId, LoginUser loginUser);

    /**
     * 根据条件获取承运商车辆关联信息
     *
     * @param vendorId
     * @param truckId
     * @param loginUser
     * @return
     */
    List<VendorTruck> listVendorTruckBy(Integer vendorId, Integer truckId, LoginUser loginUser);

    /**
     *
     * 修改
     *
     * @param vendorTruck
     * @param loginUser
     * @throws BusinessException
     */
    void update(VendorTruck vendorTruck, LoginUser loginUser) throws BusinessException;

    /**
     * 添加
     *
     * @param vendorTruck
     * @param loginUser
     * @throws BusinessException
     */
    void insert(VendorTruck vendorTruck, LoginUser loginUser) throws BusinessException;
    
    
    /**
     * 
     * @Title: listVendorTruck   
     * @Description: 车所属承运商
     * @param: @param truckId
     * @param: @return      
     * @return: List<VendorTruck>      
     * @throws
     */
    List<VendorTruck> listVendorTruck(Integer truckId);

    /**
     * 1.退车成功之后,清除车辆和承运商关联关系
     * 2.历史数据,存在数据冲突的,则需要解除关系
     * @param truckId
     * @param vendorId
     * @param tenantId
     */
    void clearRelationInfoAfterReturn(Integer truckId, Integer vendorId, Integer tenantId);
}
