package com.juma.vms.tool.service;

import com.giants.common.exception.BusinessException;
import com.juma.auth.user.domain.LoginUser;
import com.juma.message.exception.PushMessageException;
import com.juma.vms.tool.domain.SmsCode;

import java.util.Map;

/**
 * 发送消息接口
 * 功能 :
 * 1.封装公共消息发送工具.
 * 2.作为vms系统统一的消息发送服务入口
 * @author : Bruce(刘正航) 10:55 2019-03-26
 */
public interface MessageService {

    /**
     * 发送带租户验证的短信
     * @param loginUser 租户(当前登录用户)
     * @param sceneKey 消息配置中心,业务唯一识别码
     * @param extras 短信模板内容
     * @param mobile 电话号码(可以多个)
     * @throws PushMessageException
     */
    void pushSmsMessage(LoginUser loginUser, String sceneKey, Map<String,Object> extras, String... mobile);

    /**
     * 发送不带租户验证的短信
     * @param sceneKey 消息配置中心,业务唯一识别码
     * @param extras 短信模板内容
     * @param mobile 电话号码(可以多个)
     * @throws PushMessageException
     */
    void pushSmsMessage(String sceneKey, Map<String,Object> extras, String... mobile);

    /**
     * 发送短信验证码
     */
    void pushSmsCode(SmsCode smsCode, LoginUser loginUser) throws BusinessException;

    /**
     * 验证短信验证码
     */
    Boolean verifySmsCode(SmsCode smsCode) throws BusinessException;
}
