package com.juma.vms.transport.service;

import java.util.List;

import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.juma.auth.employee.domain.Department;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.mq.domain.WorkFlowMessage;
import com.juma.vms.transport.domain.TransportTruckRefund;
import com.juma.vms.transport.request.TransportTruckRefundPageReq;
import com.juma.vms.transport.request.TransportTruckRefundStorageReq;
import com.juma.vms.transport.request.TransportTruckRefundTruckReq;
import com.juma.vms.transport.response.TransportReturnTruckInfoResp;
import com.juma.vms.transport.response.TransportTruckReturnResp;
import com.juma.workflow.core.domain.TaskDetail;

/**
 * 运力退回
 * 功能 :
 * 1.运力退回列表.
 * 2.添加运力退回单.
 * 3.运力退回单详情.
 * @author : Bruce(刘正航) 20:00 2019-03-28
 */
public interface TransportTruckReturnService {

    /**查询运力退回单列表**/
    Page<TransportTruckReturnResp> findTransportTruckRefundPage(QueryCond<TransportTruckRefundPageReq> request, LoginEmployee loginUser) throws BusinessException;

    /**撤销运力退回单**/
    void cancelTruckRefund(Integer refundId,LoginEmployee loginUser) throws BusinessException;

    /**根据车牌号,查询车辆列表**/
    List<TransportReturnTruckInfoResp> findRefundTruckInfos(TransportTruckRefundTruckReq request, LoginEmployee loginUser) throws BusinessException;
    /**添加运力退回单**/
    void addTransportTruckRefund(TransportTruckRefund refund,LoginEmployee loginUser) throws BusinessException;

    /**运力退回单详情**/
    TransportTruckReturnResp findDetailByRefundId(Integer refundId, LoginEmployee loginUser) throws BusinessException;

    /**根据taskId返回工作流详情**/
    TaskDetail getWorkflowElement(String taskId, LoginEmployee loginEmployee) throws BusinessException;

    /**根据processId返回工作流详情**/
    TaskDetail findTaskByProcessInstanceId(String processInstanceId, LoginEmployee loginEmployee) throws BusinessException;

    /**执行工作流**/
    void doWorkFlowTask(WorkFlowMessage message) throws BusinessException;

    /**退库之后,修改运力退回单状态,修改**/
    void doRefundTruckStorage(TransportTruckRefundStorageReq request, LoginEmployee loginEmployee) throws BusinessException;

    /**根据车架号,返回运力退回单信息**/
    List<TransportTruckRefund> findDetailByTruckIdentificationNo(String truckIdentificationNo);

    /**更新运力退回单信息: 插入入库单号**/
    void updateTruckReturnWithStorageNo(String refundNo, Integer tenantId, String storageNo);

    /**
     * 查询部门的上级子公司
     * @param departmentId
     * @return
     * @throws BusinessException
     */
    Department findSuperCompany(Integer departmentId) throws BusinessException;

}
