package com.juma.vms.external.service;

import java.util.List;

import com.giants.common.exception.BusinessException;
import com.juma.auth.user.domain.LoginUser;
import com.juma.tgm.truck.domain.TruckType;
import com.juma.vms.truck.domain.Truck;
import com.juma.vms.truck.external.TruckExternalFilter;
import com.juma.vms.truck.vo.TruckQuery;

public interface TruckExternalService {

    /**
     * 获取车辆基本信息
     *
     * @param truckId
     * @return
     */
    Truck loadByTruckId(Integer truckId);

    /**
     * 根据vehicleID获取
     *
     * @param vehicleId
     * @return
     */
    Truck loadTruckByVehicleId(Integer vehicleId);

    /**
     * 根据车牌号获取
     *
     * @param plateNumber
     * @return
     */
    Truck loadTruckByPlateNumber(String plateNumber);

    /**
     * 根据车牌号和租户获取
     *
     * @param plateNumber
     * @return
     */
    Truck loadTruckByPlateNumberAndTenant(String plateNumber, LoginUser loginUser);

    /**
     * 根据车架号获取
     *
     * @param truckIdentificationNo
     * @return
     */
    Truck loadTruckBytruckIdentificationNo(String truckIdentificationNo);

    /**
     * 根据车辆状态获取
     *
     * @param statusList
     * @return
     */
    List<Truck> listTruckByStatus(List<Integer> statusList,LoginUser loginUser);

    /**
     * 根据司机ID获取车辆信息
     *
     * @param driverId
     * @param loginUser
     * @return
     */
    Truck loadTruckByDriverId(Integer driverId, LoginUser loginUser);

    /**
     * 根据条件模糊匹配
     *
     * @param truckExternalFilter
     * @param callbackPageSize
     * @param loginUser
     * @return
     */
    List<Truck> listTruckBy(TruckExternalFilter truckExternalFilter, Integer callbackPageSize, LoginUser loginUser);

    /**
     * 车牌号模糊搜索车辆
     * @param truckQuery
     * @param pageSize
     * @param loginUser
     * @return
     */
    List<TruckQuery> listByPlateNumber(TruckQuery truckQuery, Integer pageSize, LoginUser loginUser);
}
