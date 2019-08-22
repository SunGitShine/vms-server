package com.juma.vms.external.service;

import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.truck.domain.TruckTenant;

/**
 * 车辆租户关系
 */

public interface TruckTenantExternalService {

    /**
     * 根据车辆ID获取车辆租户关系
     *
     * @param truckId
     * @param loginUser
     * @return
     */
    TruckTenant loadTruckTenantByTruckId(Integer truckId, LoginUser loginUser);
}
