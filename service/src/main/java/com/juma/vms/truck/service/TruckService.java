package com.juma.vms.truck.service;

import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.auth.user.domain.LoginUser;
import com.juma.tgm.truck.domain.TruckType;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.tool.domain.BaseEnumDomian;
import com.juma.vms.transport.domain.CapacityPool;
import com.juma.vms.truck.domain.Truck;
import com.juma.vms.truck.domain.bo.TruckResp;
import com.juma.vms.truck.vo.*;

import java.util.List;
import java.util.Map;

/**
 * Title: TruckService
 * Description:运力车辆
 * Created by gzq on 2019/3/19.
 */

public interface TruckService {

	/**
	 * 根据主键获取
	 *
	 * @param truckId
	 * @return
	 * @throws BusinessException
	 */
	Truck getTruck(Integer truckId) throws BusinessException;

	/**
	 * 通过车牌号和车架号查询车辆
	 * @param plateNumber
	 * @param identificationNo
	 * @param loginUser
	 * @return
	 */
	Integer findByPlateNumberAndIdentificationNo(String plateNumber, String identificationNo, LoginUser loginUser);

	/**
	 * 添加车辆
	 * @param truckBo
	 */
	void addTruck(TruckBo truckBo, LoginEmployee loginEmployee);

	/**
	 * 车辆详情
	 */
	TruckResp getTruckDetail(Integer truckId, LoginUser loginUser) throws BusinessException;

	/**
	 * 修改车辆
	 */
	void update(TruckBo truckBo, LoginEmployee loginUser) throws BusinessException;

	/**
	 * 修改车辆基本信息
	 */
	void updateTruck(Truck truck);

	/**
	 * 分页获取
	 */
	Page<TruckQuery> search(QueryCond<TruckQuery> queryCond, LoginUser loginUser) throws BusinessException;

	/**
	 * 牌照、能耗、排放下拉选
	 */
	Map<String, List<BaseEnumDomian>> getProperty() throws BusinessException;

	/**
	 * 车型下拉选
	 */
	List<TruckType> getTruckType(LoginUser loginUser) throws BusinessException;

	/**
	 * 根据vihicleId获取车辆信息
	 *
	 * @param vehicleId
	 * @return
	 */
	Truck findByVehicleId(Integer vehicleId);

	/**
	 * 根据车牌号查询
	 *
	 * @param plateNumber
	 * @return
	 */
	Truck findByPlateNumber(String plateNumber);

	/**
	 * 查询车辆
	 *
	 * @param truck
	 * @return
	 */
	List<Truck> findTruckBy(Truck truck);

	/**
	 * 更换认领公司
	 *
	 * @param truckBo
	 * @return
	 */
	void updateTruckCompany(TruckBo truckBo, LoginUser loginUser) throws BusinessException;

	/**
	 * 更换承运商
	 *
	 * @param truckBo
	 * @return
	 */
	void updateVendor(TruckBo truckBo, LoginUser loginUser) throws BusinessException;

	/**
	 * 校验租户下司机是否绑定车辆，若有提示用户确认换绑
	 * @param truckBo
	 * @param loginUser
	 * @return
	 * @throws BusinessException
	 */
	String checkDriverBindTruck(TruckBo truckBo, LoginUser loginUser) throws BusinessException;

	/**
	 * 更换司机
	 *
	 * @param truckBo
	 * @return
	 */
	void updateDriver(TruckBo truckBo, LoginUser loginUser) throws BusinessException;

	/**
	 * 更新车辆状态
	 */
	void updateStatus(Integer truckId, Integer updateStatus, LoginUser loginUser) throws BusinessException;

	/**
	 * 根据车牌号,车辆类型,车辆状态,查询车辆列表(业务上只会有一个,或者没有)
	 */
	List<Truck> listByPlateNumber(TruckInfoQuery query, LoginEmployee loginUser);

	/**
	 * 车牌号模糊搜索车辆
	 */
	List<TruckQuery> listByPlateNumber(TruckQuery truckQuery, Integer pageSize, LoginUser loginUser);
	
	/**
	 * 批量更新车辆
	 */
	void batchUpdate(List<Truck> rows);
	
	/**
     * 获取所有数据  初始化数据用，后续移除
     */
    List<Truck> all();

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
	 * @param status
	 * @return
	 */
	List<Truck> listTruckByStatus(Integer status,LoginUser loginUser);

	/**
	 * 根据条件模糊查询
	 *
	 * @param queryCond
	 * @param loginUser
	 * @return
	 */
	List<TruckQuery> listTruckBy(QueryCond<TruckQuery> queryCond, LoginUser loginUser);

	/**根据条件,返回车辆列表**/
	List<Truck> findByFilter(TruckFilter filter, LoginUser loginUser);

	/**
	 * 根据车牌号模糊查询
	 * @return
	 */
	Page<CapacityPool> loadCapacityPoolByPlateNumber(QueryCond<TruckFilters> truckFilters);

}
