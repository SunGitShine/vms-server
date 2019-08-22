package com.juma.vms.transport.service;

import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.tool.domain.CrmCustomerInfo;
import com.juma.vms.transport.domain.TransportCapacity;
import com.juma.vms.transport.domain.TransportCapacityItem;
import com.juma.vms.transport.request.*;
import com.juma.vms.transport.response.TransportBeforeAddVendorResp;
import com.juma.vms.transport.response.TransportReceiveDetailResp;
import com.juma.vms.transport.response.TransportReceivePageResp;
import com.juma.vms.transport.response.TransportReceiveResp;

import java.util.List;

/**
 * 运力接收服务
 * 功能 :
 * vms-manage使用:
 *  列表查询:
 *  1.输送公司列表查询功能(下拉列表). 用户中心
 *  2.接收公司列表查询功能(下拉列表). 用户中心
 *  3.根据名字/证件号,查询客户ID列表(用于查询运力列表). 用户中心
 *  4.运力列表查询(transport_capacity). vms数据库
 *
 *  运力接收:
 *  1.车辆信息(AMS系统)用vehicle_id查询
 *  2.客户信息(CRM系统)用客户ID查询
 *
 *  运力完善:
 *  1.接收方信息(用户中心).根据ID获取公司名称
 *      接收公司
 *      认领公司
 *  2.承运商信息(vendor/vendor_tenant)
 *  3.司机信息(driver/driver_tenant)
 *
 *  详情查询:
 *  1.运力详情(transport_capacity_item).
 *  2.客户信息
 *  3.车辆信息(transport_capacity_item)
 *  4.车辆信息(部分补充信息):
 *      认领部门
 *      业务范围
 *      载货体积
 *      最大允许载重
 *      其他
 *  新建承运商:
 *  1.进入新建承运商页面是,提供接口返回指定的几个字段.
 *  2.页面中,提供调用OCR公共功能的接口.
 * @author: xieqiang
 * @create: 2019-03-19 17:27
 * @modify : Bruce(刘正航) 17:37 2019-03-22
 **/
public interface TransportReceiveService {

	/**
	 * 根据客户名称或者客户证件号 查询客户列表
	 * @param request
	 * @param loginUser
	 * @return
	 * @throws BusinessException
	 */
	List<CrmCustomerInfo> findTransportCustomers(TransportCustomerReq request, boolean useTenant, LoginEmployee loginUser) throws BusinessException;

	/**根据条件:查询车辆输送主键**/
	List<TransportCapacity> findByFilter(TransportFilter filter, LoginEmployee loginUser) throws BusinessException;

	/**根据条件:查询车辆输送详情**/
	List<TransportCapacityItem> findItemByFilter(TransportItemFilter filter, LoginEmployee loginUser) throws BusinessException;

	/**
	 * 分页查询运力接收列表
	 * @param queryCond
	 * @param loginUser
	 * @return
	 */
	Page<TransportReceivePageResp> findTransportReceivePage(QueryCond<TransportReceivePageReq> queryCond, LoginEmployee loginUser) throws BusinessException;

	/**
	 * 查询输送单详情
	 * @param itemId
	 * @param loginUser
	 * @return
	 * @throws BusinessException
	 */
	TransportReceiveDetailResp findTransportReceiveDetail(Integer itemId, LoginEmployee loginUser) throws BusinessException;

	/**
	 * 接收运力
	 * @param itemId
	 * @param loginUser
	 * @return
	 * @throws BusinessException
	 */
	TransportReceiveResp receiveTransportInfo(Integer itemId, LoginEmployee loginUser) throws BusinessException;

	/**
	 * 完善运力
	 * @param completeTransportReq
	 * @param loginUser
	 * @throws BusinessException
	 */
	void completeTransport(CompleteTransportReq completeTransportReq, LoginEmployee loginUser) throws BusinessException;

	/**
	 * 添加运营商前置信息获取
	 */
	TransportBeforeAddVendorResp beforeAddVendor(String truckIdentificationNo, LoginEmployee loginUser) throws BusinessException;
}
