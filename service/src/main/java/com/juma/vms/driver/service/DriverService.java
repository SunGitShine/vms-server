package com.juma.vms.driver.service;

import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.driver.domain.Driver;
import com.juma.vms.driver.enumeration.RemindSwitchType;
import com.juma.vms.driver.enumeration.RemindSwitchValue;
import com.juma.vms.driver.external.DriverExternalFilter;
import com.juma.vms.driver.vo.DriverBo;
import com.juma.vms.driver.vo.DriverQuery;
import com.juma.vms.transport.request.CapacityPoolFilter;

import java.util.List;

/**
 * Title: DriverService
 * Description:司机管理
 * Created by gzq on 2019/3/19.
 */

public interface DriverService {

    /**
     * 司机列表
     *
     * @param queryCond
     * @param loginUser
     * @return
     * @throws BusinessException
     */
    Page<DriverQuery> search(QueryCond<DriverQuery> queryCond, LoginUser loginUser);

    /**
     *
     * 添加基本信息
     *
     * @param driverBo
     * @param loginUser
     * @throws BusinessException
     */
    Integer insertBasciInfo(DriverBo driverBo, LoginUser loginUser) throws BusinessException;

    /**
     *
     * 添加
     *
     * @param driverBo
     * @param loginUser
     * @throws BusinessException
     */
    Integer insert(DriverBo driverBo, LoginUser loginUser) throws BusinessException;

    /**
     *
     * 修改
     *
     * @param driverBo
     * @param loginUser
     * @throws BusinessException
     */
    void update(DriverBo driverBo, LoginUser loginUser) throws BusinessException;

    /**
     *
     * 修改司机
     *
     * @param driver
     * @param loginUser
     * @throws BusinessException
     */
    void updateDriver(Driver driver, LoginUser loginUser) throws BusinessException;

    /**
     *
     * 修改承运商
     *
     * @param driverBo
     * @param loginUser
     * @throws BusinessException
     */
    void updateVendor(DriverBo driverBo, LoginUser loginUser) throws BusinessException;

    /**
     * 司机详情
     */
    DriverQuery getDriverDetail(Integer driverId, LoginUser loginUser) throws BusinessException;

    /**
     *
     * 转为账号
     *
     * @param driverId
     * @param loginUser
     * @throws BusinessException
     */
    Integer driver2user(Integer driverId, LoginUser loginUser) throws BusinessException;

    /**
     * 通过id查询司机
     * @param driverId
     * @return
     */
    Driver loadDriverById(Integer driverId);

    /**
     * 根据手机号获取当前租户司机
     */
    Driver loadByPhone(String phone,LoginUser loginUser);

    /**
     * 根据身份证号获取当前租户司机
     */
    Driver loadByIdCardNo(String idCardNo,LoginUser loginUser);

    /**
     * 司机列表模糊匹配
     */
    List<DriverQuery> listByDriverFilter(DriverQuery driverQuery, LoginEmployee loginEmployee);

    /**
     * 司机名称或电话模糊搜索
     */
    List<DriverQuery> listByDriver(DriverQuery driverQuery, Integer pageSize, LoginUser loginUser);
    
    /**
     * 批量更新
     */
    void batchUpdate(List<Driver> rows);
    
    /**
     * 获取所有数据  初始化数据用，后续移除
     */
    List<Driver> all();

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
     *
     * @param userId
     * @return
     */
    Driver loadDriverByUserId(Integer userId);

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
     * 司机接单开关
     *
     * @param driverId
     * @param isReceiveWaybill
     * @param loginUser
     */
    void updateIsReceiveWaybill(Integer driverId, Boolean isReceiveWaybill, LoginUser loginUser);

    
    /**
     * 
     * @Title: listDriverBy   
     * @Description: 租户、业务区域下的司机 
     * @param: @param tenantId
     * @param: @param areaCode
     * @param: @return      
     * @return: List<Driver>      
     * @throws
     */
    List<Driver> listDriverBy(Integer tenantId,String areaCode);

    /**
     * 获取司机列表
     *
     * @param areaCodeList
     * @param driverRunType
     * @param callbackPageSize
     * @param loginUser
     * @return
     */
    List<DriverQuery> listDriverBy(List<String> areaCodeList, Integer driverRunType, Integer callbackPageSize, LoginUser loginUser);

    /**
     * 获取是有效运力的司机信息
     *
     * @param capacityPoolFilter
     * @param loginUser
     * @return
     */
    List<Driver> listEffectiveCapacityDriver(CapacityPoolFilter capacityPoolFilter, LoginUser loginUser);

    /**
     * 根据userId修改司机的姓名和电话
     *
     * @param userId
     * @param name
     * @param phone
     * @param loginUser
     */
    void updateDriverByUserId(Integer userId, String name, String phone, LoginUser loginUser);

    /**根据关键词查询司机列表**/
    List<Driver> listDriverByFilter(DriverExternalFilter filter, LoginUser loginUser) throws BusinessException;
}
