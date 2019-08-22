package com.juma.vms.tool.service;

import com.giants.common.exception.BusinessException;
import com.juma.auth.user.domain.LoginUser;

public interface ThirdpartyCommonService {

    /**
     * 校验企业名称与统一社会信用代码
     *
     * @param name       企业名称
     * @param creditCode 统一社会信用代码
     * @param loginUser  登陆人信息
     * @return true 认证成功； false 认证失败
     * @throws BusinessException
     */
    boolean validateEnterprise(String name, String creditCode, LoginUser loginUser) throws BusinessException;

    /**
     * 校验身份证号与姓名
     *
     * @param name      姓名
     * @param idCardNo  身份证号
     * @param loginUser 登陆人信息
     * @return true 认证成功； false 认证失败
     * @throws BusinessException
     */
    boolean validateIdCardAndName(String name, String idCardNo, LoginUser loginUser) throws BusinessException;

}
