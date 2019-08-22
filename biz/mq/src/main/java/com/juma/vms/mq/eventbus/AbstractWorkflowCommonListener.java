package com.juma.vms.mq.eventbus;

import com.alibaba.fastjson.JSON;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.vms.mq.domain.WorkFlowMessage;
import com.juma.vms.transport.enumeration.ApprovalStatus;
import com.third.service.boot.starter.eventbus.domain.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * 功能 : 解析Event转换为WorkFlowMessage
 *
 * @author : Bruce(刘正航) 17:44 2019-05-16
 */
@Slf4j
public abstract class AbstractWorkflowCommonListener {

    protected WorkFlowMessage parseMessage(Event event) {
        if( null == event ){
            log.error("事件对象为空,终止处理");
            return null;
        }
        if( null == event.getValue() ){
            log.error("事件返回结果为空,终止处理");
            return null;
        }
        if( !(event.getValue() instanceof Map) ){
            log.error("事件返回结果为非Map结构:{},终止处理", JSON.toJSONString(event.getValue()));
            return null;
        }
        Map<String,Object> data = (Map<String, Object>) event.getValue();
        if(CollectionUtils.isEmpty(data)){
            log.error("事件返回结果为空Map");
            return null;
        }

        LoginEmployee loginEmployee = new LoginEmployee();
        loginEmployee.setUserId((Integer)data.get("examineUserId"));
        loginEmployee.setTenantId((Integer)data.get("examineTenantId"));
        loginEmployee.setTenantCode((String)data.get("examineTenantCode"));
        loginEmployee.setEmployeeId((Integer)data.get("examineEmployeeId"));

        return WorkFlowMessage.builder()
                .processInstanceId((String)data.get("processInstanceId"))
                .number((String)data.get("number"))
                .businessKey((String)data.get("businessKey"))
                .status(ApprovalStatus.getApprovalWithWorkKey((String)data.get("status")))
                .loginEmployee(loginEmployee)
                .build();
    }
}
