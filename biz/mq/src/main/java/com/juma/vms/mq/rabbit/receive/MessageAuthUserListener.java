package com.juma.vms.mq.rabbit.receive;

import com.juma.vms.mq.rabbit.sync.DriverSync;
import java.nio.charset.Charset;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import com.alibaba.fastjson.JSON;
import com.juma.auth.user.domain.UserOperateMQ;
import com.juma.vms.mq.rabbit.sync.VendorSync;

public class MessageAuthUserListener implements MessageListener {

    private final Logger log = LoggerFactory.getLogger(MessageAuthUserListener.class);
    @Resource
    private VendorSync VendorSync;
    @Resource
    private DriverSync driverSync;

    @Override
    public void onMessage(Message message) {
        log.info("用户中心用户同步承运商司机start...");
        String jsonStr = new String(message.getBody(), Charset.forName("utf-8"));
        log.info("用户中心用户同步承运商司机：收到用户中心MQ返回信息：{}", jsonStr);
        if (StringUtils.isBlank(jsonStr)) {
            return;
        }

        UserOperateMQ userOperateMQ = JSON.parseObject(jsonStr, UserOperateMQ.class);

        try {
            VendorSync.doNamePhoneSync(userOperateMQ.getUserId());
        } catch (Exception e) {
            log.warn("用户中心用户同步承运商：用户中心MQ同步信息未成功，返回信息：{}, 异常：{}", jsonStr, e.getMessage());
        }

        try {
            driverSync.doDriverNameAndPhoneSync(userOperateMQ.getUserId());
        } catch (Exception e) {
            log.warn("用户中心用户同步司机：用户中心MQ同步信息未成功，返回信息：{}, 异常：{}", jsonStr, e.getMessage());
        }
    }
}
