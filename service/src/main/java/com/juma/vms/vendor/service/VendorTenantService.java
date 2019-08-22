package com.juma.vms.vendor.service;

import java.util.List;

import com.giants.common.exception.BusinessException;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.vendor.domain.VendorTenant;

/**
 * @ClassName VendorTenantService.java
 * @Description 请填写注释...
 * @author Libin.Wei
 * @Date 2018年10月30日 下午8:03:10
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

public interface VendorTenantService {

    /**
     * 
     * 根据主键获取
     * 
     * @author Libin.Wei
     * @Date 2018年10月31日 上午9:58:06
     * @param vendorTenantId
     * @return
     * @throws BusinessException
     */
    VendorTenant getVendorTenant(Integer vendorTenantId) throws BusinessException;

    /**
     * 
     * 根据承运商ID获取
     * 
     * @author Libin.Wei
     * @Date 2018年10月31日 上午9:54:28
     * @param vendorId
     * @return
     * @throws BusinessException
     */
    List<VendorTenant> listVendorTenantByVendorId(Integer vendorId) throws BusinessException;

    /**
     * 
     * 添加
     * 
     * @author Libin.Wei
     * @Date 2018年10月31日 上午9:59:35
     * @param vendorTenant
     * @param loginUser
     * @throws BusinessException
     */
    void insert(VendorTenant vendorTenant, LoginUser loginUser) throws BusinessException;

    /**
     * 
     * 修改
     * 
     * @author Libin.Wei
     * @Date 2018年10月31日 上午9:59:35
     * @param vendorTenant
     * @param loginUser
     * @throws BusinessException
     */
    void update(VendorTenant vendorTenant, LoginUser loginUser) throws BusinessException;

    /**
     * 
     * 删除
     * 
     * @author Libin.Wei
     * @Date 2018年10月31日 上午9:59:35
     * @param vendorTenantId
     * @param loginUser
     * @throws BusinessException
     */
    void delete(Integer vendorTenantId, LoginUser loginUser) throws BusinessException;

    /**
     * 
     * 根据承运商ID获取
     * 
     * @author Libin.Wei
     * @Date 2018年11月1日 上午11:03:57
     * @param vendorId
     * @param loginUser
     * @return
     */
    VendorTenant loadByVendorId(Integer vendorId, LoginUser loginUser);

    /**
     * 根据司机类型的客户Id获取承运商名称
     * @param driverTypeCustomerId
     * @param loginUser
     * @return
     */
    VendorTenant findByCustomerId(Integer driverTypeCustomerId, LoginUser loginUser);

    /**
     * 启用承运商
     *
     * @param vendorTenantId
     * @param loginUser
     * @throws BusinessException
     * @author Libin.Wei
     * @Date 2018年10月31日 上午9:38:04
     */
    void doEnable(Integer vendorTenantId, LoginUser loginUser) throws BusinessException;

    /**
     * 停用承运商
     *
     * @param vendorTenantId
     * @param loginUser
     * @throws BusinessException
     * @author Libin.Wei
     * @Date 2018年10月31日 上午9:38:04
     */
    void doDisable(Integer vendorTenantId, LoginUser loginUser) throws BusinessException;

    /**
     * 获取租户下的指定业务区域的所有承运商租户关系信息
     *
     * @param areaCode  业务区域，查询本业务区域以及子业务
     * @param isEnable  启用状态，可以为空； true：启用， false： 已停用
     * @param loginUser
     * @return
     */
    List<VendorTenant> listByAraCode(String areaCode, Boolean isEnable, LoginUser loginUser);

    /**
     * 绑定司机类型的客户（crm）
     * @param vendorTenantId
     * @param customerId
     * @throws BusinessException
     */
    void doBindCrmDriverTypeCustomer(Integer vendorTenantId, Integer customerId, LoginUser loginUser) throws BusinessException;
}
