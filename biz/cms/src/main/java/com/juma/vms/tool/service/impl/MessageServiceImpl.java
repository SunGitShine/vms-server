package com.juma.vms.tool.service.impl;

import com.alibaba.fastjson.JSON;
import com.giants.cache.redis.RedisClient;
import com.giants.common.exception.BusinessException;
import com.juma.auth.user.domain.LoginUser;
import com.juma.message.exception.PushMessageException;
import com.juma.message.gateway.service.MessageServiceProvider;
import com.juma.vms.common.Constants;
import com.juma.vms.tool.domain.SmsCode;
import com.juma.vms.tool.service.MessageService;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 发送消息接口
 * 功能 :
 * 1.封装公共消息发送工具.
 * 2.作为vms系统统一的消息发送服务入口
 * @author : Bruce(刘正航) 11:04 2019-03-26
 */
@Service
public class MessageServiceImpl implements MessageService {

    private static final Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);

    private ExecutorService executorService = Executors.newFixedThreadPool(20);

    @Autowired
    private MessageServiceProvider messageServiceProvider;
    @Resource
    private RedisClient redisClient;

    /**
     * 发送带租户验证的短信
     * @param loginUser 租户(当前登录用户)
     * @param sceneKey 消息配置中心,业务唯一识别码
     * @param extras 短信模板内容
     * @param mobile 电话号码(可以多个)
     * @throws PushMessageException
     */
    @Override
    public void pushSmsMessage(final LoginUser loginUser, final String sceneKey, final Map<String, Object> extras, final String... mobile) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    messageServiceProvider.pushSmsMessage(loginUser.getTenantId(),sceneKey,extras,mobile);
                } catch (Exception e) {
                    log.warn("pushSmsMessage->mobile->{}->Exception: {}", JSON.toJSON(mobile), e);
                }
            }
        });
    }

    /**
     * 发送不带租户验证的短信
     */
    @Override
    public void pushSmsMessage(final String sceneKey, final Map<String, Object> extras, final String... mobile) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    messageServiceProvider.pushSmsMessage(sceneKey,extras,mobile);
                } catch (Exception e) {
                    log.warn("pushSmsMessage->mobile->{}->Exception: {}", JSON.toJSON(mobile), e);
                }
            }
        });
    }

    @Override
    public void pushSmsCode(SmsCode smsCode, LoginUser loginUser) throws BusinessException {
        String code = RandomStringUtils.randomNumeric(4);
        redisClient.set(Constants.MESSAGE_AUTHENTICATION_CODE+ smsCode.getPhone(), code, 60);
        Map<String, Object> extras = new HashMap<String, Object>();
        extras.put("code", code);
        extras.put("name", smsCode.getName());
        extras.put("pastPhone", smsCode.getPastPhone());
        this.pushSmsMessage(loginUser,Constants.MESSAGE_AUTHENTICATION_CODE,extras, smsCode.getPhone());
    }

    @Override
    public Boolean verifySmsCode(SmsCode smsCode) throws BusinessException {
        Object obj = redisClient.get(Constants.MESSAGE_AUTHENTICATION_CODE+ smsCode.getPhone());
        if(smsCode.getSmsCode().equals(obj)){
            redisClient.del(Constants.MESSAGE_AUTHENTICATION_CODE+ smsCode.getPhone());
            return true;
        }
        return false;
    }

}
