package com.juma.vms.transport.service;

import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.driver.domain.Driver;
import com.juma.vms.driver.vo.DriverBo;
import com.juma.vms.tool.domain.BaseEnumDomian;
import com.juma.vms.transport.domain.CapacityPool;
import com.juma.vms.transport.request.AddExternalTransportReq;
import com.juma.vms.transport.request.AddVendorAndDriverReq;
import com.juma.vms.transport.request.TransportPageReq;
import com.juma.vms.transport.response.DriverBeCurrResp;
import com.juma.vms.transport.response.TransportDetailResp;
import com.juma.vms.transport.response.TransportPageResp;

import java.util.List;
import java.util.Map;

/**
 * @description: 运力管理
 *
 * @author: xieqiang
 *
 * @create: 2019-03-19 17:27
 **/
public interface TransportService {

	/**
	 * 分页查询运力管理列表
	 * @param capacityPoolQueryCond
	 * @param loginUser
	 * @return
	 */
	Page<TransportPageResp> findTransportByPage(QueryCond<TransportPageReq> capacityPoolQueryCond, LoginUser loginUser) throws BusinessException;

	/**
	 * 添加外请运力
	 * @param addExternalTransportReq
	 * @param loginEmployee
	 */
	void addExternalTransport(AddExternalTransportReq addExternalTransportReq, LoginEmployee loginEmployee) throws BusinessException;

	/**
	 * 查询运力详情
	 * @param capacityPoolId
	 * @param loginUser
	 * @return
	 */
	TransportDetailResp findTransportDetail(Integer capacityPoolId, LoginUser loginUser) throws BusinessException;

	/**
	 * 添加承运商并绑定司机
	 * @param addVendorAndDriverReq
	 * @param loginUser
	 */
	Map<String, Integer> addVendorAndBindDriver(AddVendorAndDriverReq addVendorAndDriverReq, LoginUser loginUser) throws BusinessException;

	/**
	 * 添加司机
	 * @param driverBo
	 * @param loginUser
	 */
	Integer addDriver(DriverBo driverBo, LoginUser loginUser) throws BusinessException;

	/**
	 * 更新运力池
	 *
	 * @param capacityPool
	 * @param loginUser
	 * @return
	 */
	void updateCapacityPool(CapacityPool capacityPool, LoginUser loginUser) throws BusinessException;

	/**
	 * 更新运力池基本信息
	 *
	 * @param capacityPool
	 * @return
	 */
	void updateBasicCapacityPool(CapacityPool capacityPool) throws BusinessException;

	/**
	 * 添加运力池
	 *
	 * @param capacityPool
	 * @param loginUser
	 * @return
	 */
	void insertCapacityPool(CapacityPool capacityPool, LoginUser loginUser) throws BusinessException;

	/**
	 *
	 * 条件搜索运力池
	 */
	List<CapacityPool> findByCapacityPool(CapacityPool capacityPool) throws BusinessException;

	/**
	 * 查询scm属性
	 * @param keys
	 * @return
	 */
	Map<String, List<BaseEnumDomian>> getPropertyValueByKeys(List<String> keys) throws BusinessException;

	/**
	 * 通过身份证号查询司机
	 * @param idCordNo
	 * @param loginUser
	 * @return
	 */
	DriverBeCurrResp loadDriverByIdCardNo(String idCordNo, LoginUser loginUser);

}
