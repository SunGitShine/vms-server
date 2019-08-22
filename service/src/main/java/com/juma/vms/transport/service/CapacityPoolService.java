package com.juma.vms.transport.service;

import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.transport.domain.CapacityPool;
import com.juma.vms.transport.request.CapacityPoolFilter;
import com.juma.vms.transport.response.CapacityPoolQuery;

import java.util.List;

public interface CapacityPoolService {

    /**
     * 承运商运力分页
     *
     * @param queryCond
     * @param loginUser
     * @return
     */
    Page<CapacityPoolQuery> searchByVendor(QueryCond<CapacityPoolFilter> queryCond, LoginUser loginUser);

    /**
     * 运力池分页
     *
     * @param queryCond
     * @param loginUser
     * @return
     */
    Page<CapacityPool> search(QueryCond<CapacityPoolFilter> queryCond, LoginUser loginUser);

    /**
     * 承运商有效运力统计
     *
     * @param vendorId
     * @param loginUser
     * @return
     */
    Integer countValidCapacity(Integer vendorId, LoginUser loginUser);

    /**
     * 更新运力池数据
     *
     * @param pool 运力池独享
     */
    void update(CapacityPool pool);

    /**
     * 更新运力池
     */
    void batchInsert(List<CapacityPool> rows);

    /**
     * 根据司机ID获取
     *
     * @param driverId
     * @param loginUser
     * @return
     */
    CapacityPool loadCapacityPoolByDriverId(Integer driverId, LoginUser loginUser);

    /**根据司机ID集合获取运力池数据**/
    List<CapacityPool> loadCapacityPoolByFilter(CapacityPoolFilter filter, LoginUser loginUser);

    /**
     * 根据车辆ID获取
     *
     * @param truckId
     * @param loginUser
     * @return
     */
    CapacityPool loadCapacityPoolByTruckId(Integer truckId, LoginUser loginUser);

    /**
     * 根据车辆ID获取
     *
     * @param truckId
     * @return
     */
    List<CapacityPool> loadCapacityPoolByTruckId(Integer truckId);

    /**
     * 根据承运商ID将运力置为无效状态
     *
     * @param vendorId
     * @param loginUser
     * @throws BusinessException
     */
    void updateCapacityToValiedByVendor(Integer vendorId, LoginUser loginUser) throws BusinessException;

    /**
     * 根据承运商ID将运力置为可用状态，需要检查司机和车的状态，若车或司机不可用，则不能变更
     *
     * @param vendorId
     * @param loginUser
     * @throws BusinessException
     */
    void updateCapacityToAvailableByVendor(Integer vendorId, LoginUser loginUser) throws BusinessException;

    /**
     * 根据车辆ID将运力置为可用状态，需要检查司机和承运商的状态，若车或司机不可用，则不能变更
     *
     * @param truckId
     * @param loginUser
     * @throws BusinessException
     */
    void updateCapacityToAvailableByTruck(Integer truckId, LoginUser loginUser) throws BusinessException;
}
