package com.juma.vms.tool.service.impl;

import com.giants.common.exception.BusinessException;
import com.juma.auth.common.SystemAuthKey;
import com.juma.auth.user.domain.LoginUser;
import com.juma.thirdparty.service.EnterpriseInformationService;
import com.juma.thirdparty.service.IdentificationCardAuthenticateService;
import com.juma.thirdparty.xinyan.domain.Result;
import com.juma.vms.common.Constants;
import com.juma.vms.tool.service.ThirdpartyCommonService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ThirdpartyCommonServiceImpl implements ThirdpartyCommonService {

    @Resource
    private EnterpriseInformationService enterpriseInformationService;

    @Resource
    private IdentificationCardAuthenticateService identificationCardAuthenticateService;


    @Override
    public boolean validateEnterprise(String name, String creditCode, LoginUser loginUser) throws BusinessException {
        if (StringUtils.isBlank(name) || StringUtils.isBlank(creditCode)) {
            return false;
        }

        SystemAuthKey systemAuthKey = new SystemAuthKey();
        systemAuthKey.setAuthKey(Constants.AUTH_KEY_VMS_MANAGE);

        Boolean falg = null;
        try {
            falg = enterpriseInformationService.validateEnterprise(name, creditCode, loginUser, systemAuthKey);
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                throw e;
            }
            throw new BusinessException("thirdpartySystemException", "errors.thirdpartySystemException");
        }

        return falg;
    }

    @Override
    public boolean validateIdCardAndName(String name, String idCardNo, LoginUser loginUser) throws BusinessException {
        if (StringUtils.isBlank(name) || StringUtils.isBlank(idCardNo)) {
            return false;
        }

        SystemAuthKey systemAuthKey = new SystemAuthKey();
        systemAuthKey.setAuthKey(Constants.AUTH_KEY_VMS_MANAGE);

        Result<?> result = null;
        try {
            result = identificationCardAuthenticateService.authenticate(idCardNo, name, loginUser, systemAuthKey);
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                throw e;
            }
            throw new BusinessException("thirdpartySystemException", "errors.thirdpartySystemException");
        }

        return result == null ? false : result.isSuccess();
    }

}
