package com.juma.vms.mq.rabbit.receive;

import com.alibaba.fastjson.JSON;
import com.juma.log.domain.OperationLogInfo;
import com.juma.log.service.OperationLogService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import javax.annotation.Resource;
import java.nio.charset.Charset;

public class MessageVmsWritelogListener implements MessageListener {

    private final Logger log = LoggerFactory.getLogger(MessageAuthUserListener.class);
    @Resource
    private OperationLogService operationLogService;

    @Override
    public void onMessage(Message message) {
        log.info("VMS写日志start...");
        String jsonStr = new String(message.getBody(), Charset.forName("utf-8"));
        log.info("用VMS写日志{}", jsonStr);
        try {
            if (StringUtils.isBlank(jsonStr)) {
                return;
            }

            OperationLogInfo operationLogInfo = JSON.parseObject(jsonStr, OperationLogInfo.class);
            if (null == operationLogInfo.getUserId() || null == operationLogInfo.getMethodName() || null == operationLogInfo.getParam()) {
                return;
            }

            operationLogService.writingLog(operationLogInfo);
        } catch (Exception e) {
            log.warn("用VMS写日志未成功，返回信息：{}, 异常：{}", jsonStr, e.getMessage());
        }
    }
}
