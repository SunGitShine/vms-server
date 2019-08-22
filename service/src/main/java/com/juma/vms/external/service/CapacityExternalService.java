package com.juma.vms.external.service;

import com.giants.common.tools.Page;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.transport.domain.CapacityPool;
import com.juma.vms.transport.external.CapacityPoolExternalQuery;
import com.juma.vms.transport.request.CapacityPoolFilter;
import com.juma.vms.truck.vo.TruckFilters;

import java.util.List;

/**
 * 对外：运力池
 */

public interface CapacityExternalService {

    /**
     * 获取运力基础信息
     *
     * @param queryCond
     * @param loginUser
     * @return
     */
    Page<CapacityPool> searchCommonCapacity(QueryCond<CapacityPoolFilter> queryCond, LoginUser loginUser);

    /**
     * 获取运力信息,返回包含承运商、车辆、司机的部分信息，最大返回200条
     *
     * @param queryCond
     * @param loginUser
     * @return
     */
    Page<CapacityPoolExternalQuery> searchCapacity(QueryCond<CapacityPoolFilter> queryCond, LoginUser loginUser);

    /**
     * 根据司机ID获取
     *
     * @param driverId
     * @param loginUser
     * @return
     */
    CapacityPool loadCapacityPoolByDriverId(Integer driverId, LoginUser loginUser);

    /**
     * 根据车辆ID获取
     *
     * @param truckId
     * @param loginUser
     * @return
     */
    CapacityPool loadCapacityPoolByTruckId(Integer truckId, LoginUser loginUser);

    /**
     * 根据车牌号模糊查询
     *
     * @param truckFilters
     * @return
     */
    Page<CapacityPool> loadCapacityPoolByPlateNumber(QueryCond<TruckFilters> truckFilters);
}
