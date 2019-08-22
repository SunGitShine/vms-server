package com.juma.vms.transport.service;

import java.util.List;

import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.auth.tenant.domain.Tenant;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.mq.domain.WorkFlowInstance;
import com.juma.vms.mq.domain.WorkFlowMessage;
import com.juma.vms.transport.domain.TransportCapacity;
import com.juma.vms.transport.domain.TransportCapacityItem;
import com.juma.vms.transport.request.AddTransportSendReq;
import com.juma.vms.transport.request.SelectVehicleReq;
import com.juma.vms.transport.request.TransportSendPageReq;
import com.juma.vms.transport.response.TransportSendDetailResp;
import com.juma.vms.transport.response.TransportSendPageResp;
import com.juma.vms.transport.response.TransportVehicleDetail;
import com.juma.workflow.core.domain.TaskDetail;

/**
 * @description: 运力输送
 *
 * @author: xieqiang
 *
 * @create: 2019-03-19 17:27
 **/
public interface TransportSendService {

	/**
	 * 分页查询输送列表
	 * @param queryCond
	 * @param loginUser
	 * @return
	 * @throws BusinessException
	 */
	Page<TransportSendPageResp> findTransportSendPage(QueryCond<TransportSendPageReq> queryCond, LoginUser loginUser) throws BusinessException;

	/**
	 * 选择车辆列表
	 * @param selectVehicleReq
	 * @param loginEmployee
	 * @return
	 * @throws BusinessException
	 */
	List<TransportVehicleDetail> selectVehicleList(SelectVehicleReq selectVehicleReq, LoginEmployee loginEmployee) throws BusinessException;

	/**
	 * 查询选择车辆详情
	 * @param selectVehicleReq
	 * @param loginEmployee
	 * @return
	 * @throws BusinessException
	 */
	TransportVehicleDetail selectVehicleDetail(SelectVehicleReq selectVehicleReq, LoginEmployee loginEmployee) throws BusinessException;

	/**
	 * 添加运力输送单
	 * @param addTransportSendReq
	 * @param loginUser
	 */
	void addTransportSend(AddTransportSendReq addTransportSendReq, LoginEmployee loginUser) throws BusinessException;

	/**
	 * 查询输送单详情
	 * @param transportId
	 * @return
	 */
	TransportSendDetailResp findTransportSendDetail(Integer transportId, LoginEmployee loginEmployee) throws BusinessException;

	/**
	 * 修改输送单
	 * @param addTransportSendReq
	 * @param loginUser
	 */
	void updateTransportSend(AddTransportSendReq addTransportSendReq, LoginEmployee loginUser) throws BusinessException;


	/**
	 * 通过流程id查询任务详情
	 * @param processInstanceId
	 * @return
	 * @throws BusinessException
	 */
	TaskDetail findTaskByProcessInstanceId(String processInstanceId, LoginEmployee loginEmployee) throws BusinessException;

	/**
	 * 撤销工作流
	 * @param transportId
	 * @param loginEmployee
	 * @throws BusinessException
	 */
	void cancelWorkFlowTask(Integer transportId, LoginEmployee loginEmployee) throws BusinessException;

	/**
	 * 审批工作流
	 * @param message
	 * @throws BusinessException
	 */
	void doWorkFlowTask(WorkFlowMessage message) throws BusinessException;

	/**
	 * 通过taskId查询任务详情
	 * @param taskId
	 * @param loginEmployee
	 * @return
	 */
	TaskDetail getWorkflowElement(String taskId, LoginEmployee loginEmployee) throws BusinessException;

	/**
	 * 查询所有租户列表
	 * @return
	 * @throws BusinessException
	 */
	List<Tenant> findAllTenant() throws BusinessException;

	/**
	 * 根据车架号获取输送单状态
	 * @param truckIdentificationNo
	 * @return
	 */
	List<TransportCapacityItem> getCapacityItemByTruckIdentificationNo(String truckIdentificationNo) throws BusinessException;

	/**
	 * 根据id获取输送单信息
	 * @param transportId
	 * @return
	 * @throws BusinessException
	 */
	TransportCapacity getCapacityById(Integer transportId) throws BusinessException;

	/**
	 * 查询可输送租户
	 * @return
	 * @throws BusinessException
	 */
	List<Tenant> findTransportTenantList() throws BusinessException;

	/**
	 * 重新申请通知工作流
	 * @param workFlowInstance
	 * @throws BusinessException
	 */
	void reapplyToWorkflow(WorkFlowInstance workFlowInstance, LoginEmployee loginEmployee) throws BusinessException;

	/**
	 * 放弃申请通知工作流
	 * @param workFlowInstance
	 * @throws BusinessException
	 */
	void giveUpToWorkflow(WorkFlowInstance workFlowInstance, LoginEmployee loginEmployee) throws BusinessException;

	/**
	 * 处理工作流审核通过，vms还在审核中的数据
	 * @param transportId
	 * @param loginUser
	 * @throws BusinessException
	 */
	void handleTransportSendAudit(Integer transportId, LoginUser loginUser) throws BusinessException;
}
