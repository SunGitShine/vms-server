package com.juma.vms.mq.rabbit.send;

import org.springframework.amqp.core.AmqpTemplate;

public class MqSendService {

    private AmqpTemplate amqpTemplate;

    /**发送广播消息**/
    public void send(String exchange, Object data) {
        this.send(exchange, null, data);
    }

    /**
     * 发送点对点消息
     * @param queue 消息指定的对应名称
     */
    public void send(String exchange,String queue, Object data) {
        amqpTemplate.convertAndSend(exchange, queue, data);
    }

    public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

}