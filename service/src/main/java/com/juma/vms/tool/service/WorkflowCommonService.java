package com.juma.vms.tool.service;


import com.giants.common.exception.BusinessException;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.vms.mq.domain.WorkFlowInstance;
import com.juma.workflow.core.domain.ProcessInstance;

/**
 * 工作流公共接口
 */
public interface WorkflowCommonService {

    /**发起工作流**/
    ProcessInstance startWorkflow(WorkFlowInstance workFlowInstance, LoginEmployee loginUser) throws BusinessException;

    /**撤销工作流**/
    void revokeWorkflow(WorkFlowInstance workFlowInstance, LoginEmployee loginEmployee) throws BusinessException;

    /**放弃申请工作流**/
    void giveUpWorkflow(WorkFlowInstance workFlowInstance, LoginEmployee loginUser) throws BusinessException;

    /**修改后再次审批工作流**/
    void reopenWorkflow(WorkFlowInstance workFlowInstance, LoginEmployee loginEmployee) throws BusinessException;

}
