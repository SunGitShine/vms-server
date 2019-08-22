package com.juma.vms.mq.eventbus;

import com.alibaba.fastjson.JSON;
import com.giants.common.exception.BusinessException;
import com.juma.vms.common.Constants;
import com.juma.vms.transport.service.TransportSendService;
import com.juma.vms.transport.service.TransportTruckReturnService;
import com.third.eventbus.handler.EventHandler;
import com.third.service.boot.starter.eventbus.domain.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 功能 : 工作流监听器
 */

@Slf4j
@Component
public class WorkflowCommonListener extends AbstractWorkflowCommonListener {

    @Autowired
    private TransportTruckReturnService transportTruckReturnService;
    @Autowired
    private TransportSendService transportSendService;


    /**运力退车**/
    @EventHandler(value = Constants.EVENT_NAME_SCM_TO_VMS_RETURN_STORAGE_NO)
    public void doWorkflowForTruckReturn(Event event) throws BusinessException {
        log.info("listener workflow for truck return param :{}", JSON.toJSONString(event));
        transportTruckReturnService.doWorkFlowTask(parseMessage(event));
    }

    /**运力输送**/
    @EventHandler(value = Constants.EVENT_NAME_TRANSPORT_SEND)
    public void doWorkflowForTransportSend(Event event) throws BusinessException {
        log.info("listener workflow for transport send param :{}", JSON.toJSONString(event));
        transportSendService.doWorkFlowTask(parseMessage(event));
    }
}
