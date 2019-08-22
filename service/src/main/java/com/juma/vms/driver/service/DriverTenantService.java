package com.juma.vms.driver.service;

import java.util.List;

import com.giants.common.exception.BusinessException;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.driver.domain.DriverTenant;


public interface DriverTenantService {

    /**
     * 
     * 根据主键获取
     */
    DriverTenant getDriverTenant(Integer driverTenantId) throws BusinessException;

    /**
     * 
     * 添加
     */
    void insert(DriverTenant driverTenant, LoginUser loginUser) throws BusinessException;

    /**
     *
     * 修改
     */
    void update(DriverTenant driverTenant, LoginUser loginUser) throws BusinessException;

    /**
     * 
     * 根据司机ID获取
     */
    DriverTenant loadByDriverId(Integer driverId, LoginUser loginUser);

    /**
     *
     * 根据司机ID、归属方获取
     */
    DriverTenant loadByDriverIdAnsOwner(Integer driverId, Boolean isOwner);

    /**
     * 批量添加
     */
    void batchInsert(List<DriverTenant> rows);


    /**
     * 获取司机所在的租户
     *
     * @param driverId
     * @return
     */
    List<DriverTenant> listDriverTenantByDriverId(Integer driverId);
}
