package com.juma.vms.mq.eventbus;

import com.alibaba.fastjson.JSON;
import com.giants.common.exception.BusinessException;
import com.google.common.collect.Maps;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.vms.common.Constants;
import com.juma.vms.mq.domain.WorkFlowInstance;
import com.juma.vms.tool.service.WorkflowCommonService;
import com.juma.workflow.core.domain.ProcessInstance;
import com.juma.workflow.core.service.ProcessService;
import com.third.eventbus.EventBus;
import com.third.service.boot.starter.eventbus.domain.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class WorkflowCommonServiceImpl implements WorkflowCommonService {

    @Autowired
    private EventBus eventBus;

    @Autowired
    private ProcessService processService;

    @Override
    public ProcessInstance startWorkflow(WorkFlowInstance instance, LoginEmployee loginUser) throws BusinessException {
        instance.getVariables().put("number", instance.getNumber());
        try {
            return processService.startProcessInstance(
                    instance.getProcessDefinitionKey(),
                    instance.getBusinessKey(),
                    instance.getVariables(), loginUser);
        } catch (BusinessException e){
            log.error("启动工作流异常: 业务:{},唯一标识: {},错误信息: {}" , instance.getWorkflowDesc(), instance.getBusinessKey(), e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("启动工作流异常: 业务:{},唯一标识: {},错误信息: {}" , instance.getWorkflowDesc(), instance.getBusinessKey(), e.getMessage());
            throw new BusinessException("unknown.error", "外部错误:"+e.getMessage());
        }
    }

    @Override
    public void giveUpWorkflow(WorkFlowInstance instance, LoginEmployee loginEmployee) throws BusinessException {
        try {
            Event<String> event = new Event<>();
            event.setEventId(Constants.WORK_FLOW_EXTERNAL_NEXT_EVENT_BUS_KEY);
            event.setSystemAuthKey(Constants.SYSTEM_NAME.toLowerCase());
            Map<String, Object> data = Maps.newHashMap();
            data.put("nextKeyCode", "CANCEL");
            data.put("processInstanceId", instance.getProcessInstanceId());
            data.put("businessKey", instance.getBusinessKey());
            data.put("number", instance.getNumber());
            //审核人信息
            data.put("userId", loginEmployee.getUserId());
            data.put("employeeId", loginEmployee.getEmployeeId());
            data.put("tenantId", loginEmployee.getTenantId());
            event.setValue(JSON.toJSONString(data));
            eventBus.push(event);
        } catch (BusinessException e){
            log.error("放弃申请工作流异常: 业务:{},唯一标识: {},错误信息: {}" , instance.getWorkflowDesc(), instance.getBusinessKey(), e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("放弃申请工作流异常: 业务:{},唯一标识: {},错误信息: {}" , instance.getWorkflowDesc(), instance.getBusinessKey(), e.getMessage());
            throw new BusinessException("unknown.error", "外部错误:"+e.getMessage());
        }
    }

    @Override
    public void revokeWorkflow(WorkFlowInstance executeWorkflowInfo, LoginEmployee loginUser) throws BusinessException {
    }

    @Override
    public void reopenWorkflow(WorkFlowInstance instance, LoginEmployee loginEmployee) throws BusinessException {
        try {
            Event<String> event = new Event<>();
            event.setEventId(Constants.WORK_FLOW_EXTERNAL_NEXT_EVENT_BUS_KEY);
            event.setSystemAuthKey(Constants.SYSTEM_NAME.toLowerCase());
            Map<String, Object> data = Maps.newHashMap();
            data.put("nextKeyCode", "REAPPLY");
            data.put("processInstanceId", instance.getProcessInstanceId());
            data.put("businessKey", instance.getBusinessKey());
            data.put("number", instance.getNumber());
            //审核人信息
            data.put("userId", loginEmployee.getUserId());
            data.put("employeeId", loginEmployee.getEmployeeId());
            data.put("tenantId", loginEmployee.getTenantId());
            event.setValue(JSON.toJSONString(data));
            eventBus.push(event);
        } catch (BusinessException e){
            log.error("驳回后重新发起工作流异常: 业务:{}唯一标识: {},错误信息: {}" , instance.getWorkflowDesc(), instance.getBusinessKey(), e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("驳回后重新发起工作流异常: 业务:{}唯一标识: {},错误信息: {}" , instance.getWorkflowDesc(), instance.getBusinessKey(), e.getMessage());
            throw new BusinessException("unknown.error", "外部错误:"+e.getMessage());
        }
    }

}
