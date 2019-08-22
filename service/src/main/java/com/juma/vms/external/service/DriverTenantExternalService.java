package com.juma.vms.external.service;

import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.driver.domain.DriverTenant;

import java.util.List;

public interface DriverTenantExternalService {

    /**
     * 根据司机ID获取司机租户关系
     *
     * @param driverId
     * @param loginUser
     * @return
     */
    DriverTenant loadDriverTenantByDriverId(Integer driverId, LoginUser loginUser);

    /**
     * 获取司机所在的租户
     *
     * @param driverId
     * @return
     */
    List<DriverTenant> listDriverTenantByDriverId(Integer driverId);
}
