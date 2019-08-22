package com.juma.vms.mq.rabbit.receive;

import com.alibaba.fastjson.JSON;
import com.juma.scm.storage.bo.StoreInMsgBO;
import com.juma.vms.common.Constants;
import com.juma.vms.transport.service.TransportTruckReturnService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.Charset;

/**
 * 功能 :
 * 退车入库:SCM发送消息,VMS接收消息
 * 消息内容:推车单号+入库单号
 * @author : Bruce(刘正航) 16:20 2019-04-18
 */
public class MessageScmReturnStorageListener implements MessageListener {

    private final Logger log = LoggerFactory.getLogger(MessageScmReturnStorageListener.class);

    @Autowired
    private TransportTruckReturnService transportTruckReturnService;

    @Override
    public void onMessage(Message body) {
        log.info("退车入库: 接收到SCM消息.");
        String message = new String(body.getBody(), Charset.forName("utf-8"));
        log.info("退车入库: SCM消息内容: {}", message);
        if (StringUtils.isBlank(message)) { return; }
        try {
            StoreInMsgBO bo = JSON.parseObject(message, StoreInMsgBO.class);
            if( null == bo ){
                log.warn("退车入库：SCM同步信息未成功，返回信息：{}, 异常：{}",message,"数据转换异常");
                return;
            }
            if( null == bo.getTenantId() ){
                log.warn("退车入库：SCM同步信息未成功，返回信息：{}, 异常：{}",message,"租户ID(tenantId)为空");
                return;
            }
            if( StringUtils.isBlank(bo.getSourceNo()) ){
                log.warn("退车入库：SCM同步信息未成功，返回信息：{}, 异常：{}",message,"来源单号(sourceNo)为空");
                return;
            }
            if( StringUtils.isBlank(bo.getOrderNo()) ){
                log.warn("退车入库：SCM同步信息未成功，返回信息：{}, 异常：{}",message,"入库单号(orderNo)为空");
                return;
            }
            if( StringUtils.isBlank(bo.getSystemName()) ){
                log.warn("退车入库：不是发给VMS的消息，返回信息：{}, 异常：{}",message,"不是发给VMS系统的消息");
            }
            if( !Constants.SYSTEM_NAME.toLowerCase().equals(bo.getSystemName()) ){
                log.warn("退车入库：不是发给VMS的消息，返回信息：{}, 异常：{}",message,"不是发给VMS系统的消息");
            }
            transportTruckReturnService.updateTruckReturnWithStorageNo(bo.getSourceNo(), bo.getTenantId(), bo.getOrderNo());
        } catch (Exception e) {
            log.warn("退车入库：SCM同步信息未成功，返回信息：{}, 异常：{}",message, e.getMessage());
        }
    }
}
