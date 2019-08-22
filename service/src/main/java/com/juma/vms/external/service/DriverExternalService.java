package com.juma.vms.external.service;

import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.driver.domain.Driver;
import com.juma.vms.driver.enumeration.RemindSwitchType;
import com.juma.vms.driver.enumeration.RemindSwitchValue;
import com.juma.vms.driver.external.DriverExternalFilter;
import com.juma.vms.driver.vo.DriverExtend;
import com.juma.vms.driver.vo.DriverQuery;
import com.juma.vms.transport.request.CapacityPoolFilter;

import java.util.List;

public interface DriverExternalService {

    /**
     * 获取司机基本信息
     *
     * @param driverId
     * @return
     */
    Driver loadByDriverId(Integer driverId);
    
    /**
     * 获取租户下的司机信息
     * @param: @param driverId
     * @param: @param loginUser
     * @param: @return      
     * @return: Driver      
     * @throws
     */
    Driver loadByDriverId(Integer driverId, LoginUser loginUser);
    
    /**
     * 
     * @Title: listDriverBy   查询租户下的司机
     * @param: @param tenantId
     * @param: @param areaCode
     * @param: @return      
     * @return: List<Driver>      
     * @throws
     */
    List<Driver> listDriverBy(Integer tenantId,String areaCode);

    /**
     * 根据手机号获取
     *
     * @param phone
     * @return
     */
    Driver loadDriverByPhone(String phone);

    /**
     * 根据司机姓名获取
     *
     * @param name
     * @return
     */
    List<Driver> listDriverByName(String name);

    /**
     * 根据amsdriverId获取
     *
     * @param amsDriverId
     * @return
     */
    Driver loadDriverByAmsDriverId(Integer amsDriverId);

    /**
     * 根据USERID获取
     *
     * @param userId
     * @return
     */
    Driver loadDriverByUserId(Integer userId);

    /**
     * 根据USERID获取,有租户限制
     *
     * @param userId
     * @param loginUser
     * @return
     */
    Driver loadDriverByUserId(Integer userId, LoginUser loginUser);

    /**
     * 修改司机接单开关
     *
     * @param driverId
     * @param isAcceptAllocateOrder
     * @param loginUser
     */
    void updateDriverIsAcceptAllocateOrder(Integer driverId, Integer isAcceptAllocateOrder, LoginUser loginUser);

    /**
     * 根据条件查询
     *
     * @param driverExternalFilter
     * @param callbackPageSize
     * @param loginUser
     * @return
     */
    List<Driver> listDriverBy(DriverExternalFilter driverExternalFilter, Integer callbackPageSize, LoginUser loginUser);

    /**
     * 根据条件查询
     *
     * @param driverExternalFilter
     * @param callbackPageSize
     * @param loginUser
     * @return
     */
    List<DriverExtend> listDriverByFilter(DriverExternalFilter driverExternalFilter, Integer callbackPageSize, LoginUser loginUser);

    /**
     * 司机提醒开关
     *
     * @param driverId
     * @param remindSwitchValue
     * @param remindSwitchType
     * @param loginUser
     */
    void updateRemindSwitch(Integer driverId, RemindSwitchValue remindSwitchValue, RemindSwitchType remindSwitchType,
                            LoginUser loginUser);

    /**
     * 获取司机列表
     *
     * @param areaCodeList
     * @param driverRunType
     * @param callbackPageSize
     * @param loginUser
     * @return
     */
    List<Driver> listDriverBy(List<String> areaCodeList, Integer driverRunType, Integer callbackPageSize, LoginUser loginUser);

    /**
     * 根据车牌号获取司机
     *
     * @param plateNumber
     * @param loginUser
     * @return
     */
    Driver loadDriverByPlateNumber(String plateNumber, LoginUser loginUser);

    /**
     * 根据truckId获取司机
     *
     * @param truckId
     * @param loginUser
     * @return
     */
    Driver loadDriverByTruckId(Integer truckId, LoginUser loginUser);

    /**
     * 获取是有效运力的司机信息
     *
     * @param capacityPoolFilter
     * @param loginUser
     * @return
     */
    List<Driver> listEffectiveCapacityDriver(CapacityPoolFilter capacityPoolFilter, LoginUser loginUser);

    /**
     * 获取承运商下所有的司机
     *
     * @param vendorId
     *
     * @return
     */
    List<Driver> listAllDriverByVendorId(Integer vendorId);

    /*
     * 司机名称模糊查询司机列表
     * @param driverQuery
     * @param pageSize
     * @param loginUser
     * @return
     */
    List<DriverQuery> listByDriver(DriverQuery driverQuery, Integer pageSize, LoginUser loginUser);
}
