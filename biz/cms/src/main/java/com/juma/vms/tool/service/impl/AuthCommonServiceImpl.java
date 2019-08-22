package com.juma.vms.tool.service.impl;

import com.giants.common.exception.BusinessException;
import com.juma.auth.authority.service.AuthorityService;
import com.juma.auth.employee.domain.Department;
import com.juma.auth.employee.domain.DepartmentBo;
import com.juma.auth.employee.service.DepartmentService;
import com.juma.auth.tenant.domain.Tenant;
import com.juma.auth.tenant.service.TenantService;
import com.juma.auth.user.domain.EcoUser;
import com.juma.auth.user.domain.EcoUserAuthInfo;
import com.juma.auth.user.domain.LoginUser;
import com.juma.auth.user.domain.User;
import com.juma.auth.user.service.EcoUserService;
import com.juma.auth.user.service.UserService;
import com.juma.conf.domain.ConfParamOption;
import com.juma.conf.service.ConfParamService;
import com.juma.vms.common.Constants;
import com.juma.vms.driver.domain.Driver;
import com.juma.vms.driver.domain.DriverTenant;
import com.juma.vms.tool.service.AuthCommonService;
import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.domain.VendorTenant;
import com.juma.vms.vendor.enumeration.VendorTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AuthCommonServiceImpl.java
 * @Description 用户中心公共类
 * @author Libin.Wei
 * @Date 2018年11月6日 下午2:54:50
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

@Service
public class AuthCommonServiceImpl implements AuthCommonService {

    private final Logger log = LoggerFactory.getLogger(AuthCommonServiceImpl.class);
    @Resource
    private UserService userService;
    @Resource
    private EcoUserService ecoUserService;
    @Resource
    private AuthorityService authorityService;
    @Resource
    private TenantService tenantService;
    @Autowired
    private ConfParamService confParamService;
    @Autowired
    private DepartmentService departmentService;

    @Override
    public Integer vendor2User(Vendor vendor, VendorTenant vendorTenant, LoginUser loginUser) throws BusinessException {
        EcoUserAuthInfo ecoUserAuthInfo = new EcoUserAuthInfo();
        User user = userService.loadUser(User.UserUniqueAttribute.mobileNumber, vendor.getContactPhone());
        if (user == null) {
            user = new User();
            // 用户基础信息
            user.setMobileNumber(vendor.getContactPhone());
            user.setName(vendor.getVendorType() == VendorTypeEnum.PERSONAL.getCode() ? vendor.getVendorName()
                    : vendor.getContactUserName());
        }

        ecoUserAuthInfo.setUser(user);
        // 系统角色
        ecoUserAuthInfo.setAuthKey(Constants.AUTH_KEY_TGM_DRIVER);
        ecoUserAuthInfo.setRoleKey(Constants.ROLE_KEY_VENDOR);

        // 业务区域
        ecoUserAuthInfo.setAreaCode(vendorTenant.getAreaCode());

        try {
            EcoUser ecoUser = authorityService.authorizationEcoUser(ecoUserAuthInfo, loginUser);
            if (null != ecoUser) {
                return ecoUser.getUserId();
            }
        } catch (BusinessException e) {
            log.warn("用户中心创建货主错误;", e);
            throw e;
        }

        return null;
    }

    @Override
    public Integer driver2User(Driver driver, DriverTenant driverTenant, LoginUser loginUser) throws BusinessException {
        EcoUserAuthInfo ecoUserAuthInfo = new EcoUserAuthInfo();
        User user = userService.loadUser(User.UserUniqueAttribute.mobileNumber, driver.getPhone());
        if (user == null) {
            user = new User();
            user.setMobileNumber(driver.getPhone());
            user.setName(driver.getName());
        }

        ecoUserAuthInfo.setUser(user);
        // 系统角色
        ecoUserAuthInfo.setAuthKey(Constants.AUTH_KEY_TGM_DRIVER);
        ecoUserAuthInfo.setRoleKey(Constants.ROLE_KEY_DRIVER);

        // 业务区域
        ecoUserAuthInfo.setAreaCode(driverTenant.getAreaCode());

        try {
            EcoUser ecoUser = authorityService.authorizationEcoUser(ecoUserAuthInfo, loginUser);
            if (null != ecoUser) {
                return ecoUser.getUserId();
            }
        } catch (BusinessException e) {
            log.warn("用户中心创建司机错误;", e);
            throw e;
        }

        return null;
    }

    @Override
    public Integer loadEcoUserId(Integer userId, LoginUser loginUser) {
        if (null == userId || null == loginUser || null == loginUser.getTenantId()) {
            return null;
        }

        try {
            EcoUser ecoUser = ecoUserService.loadEcoUserByUserId(userId, loginUser);
            if (null == ecoUser) {
                return null;
            }
            return ecoUser.getEcoUserId();
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                throw e;
            }

            throw new BusinessException("authServiceError", "errors.authServiceError");
        }
    }

    @Override
    public Tenant loadByTenantId(Integer tenantId) {
        if (null == tenantId) {
            return null;
        }

        return tenantService.loadTenant(tenantId);
    }

    @Override
    public User loadUser(Integer userId) {
        if (null == userId) {
            return null;
        }

        return userService.loadUser(userId);
    }

    @Override
    public List<ConfParamOption> getAllOption(String optionKey) {
        if(optionKey == null) {
            return new ArrayList<>();
        }
        List<ConfParamOption> paramOptions = null;
        try {
            paramOptions = confParamService.findParamOptions(optionKey);
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                throw e;
            }
            throw new BusinessException("callAuthSystemException", "errors.callAuthSystemException");
        }
        return paramOptions == null ? new ArrayList<ConfParamOption>() : paramOptions;
    }

    @Override
    public String getOptionName(String optionKey, String optionValue) {
        if(optionKey == null || optionValue == null) {
            return null;
        }
        ConfParamOption option = null;
        try {
            option = confParamService.findParamOption(optionKey, optionValue);
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                throw e;
            }
            throw new BusinessException("callAuthSystemException", "errors.callAuthSystemException");
        }
        return option == null ? null : option.getOptionName();
    }

    @Override
    public Department loadDepartment(Integer departmentId){
        return departmentService.loadDepartment(departmentId);
    }

    @Override
    public Department loadDepartment(Integer departmentId, LoginUser loginUser) {
        return departmentService.loadDepartment(departmentId,loginUser);
    }

    @Override
    public Department loadDepartment(String departmentCode, LoginUser loginUser) {
        return departmentService.loadDepartment(departmentCode,loginUser);
    }

    @Override
    public DepartmentBo findDepartmentBo(Integer departmentId, LoginUser loginUser) {
        return departmentService.findDepartmentBo(departmentId,loginUser);
    }

    @Override
    public List<Department> loadDepartmentList(LoginUser loginUser) {
        return departmentService.loadDepartmentList(loginUser);
    }

    @Override
    public List<Department> listChildDepartment(Integer parentDepartmentId, LoginUser loginUser) throws BusinessException {
        if (null != parentDepartmentId && parentDepartmentId.equals(0)) {
            parentDepartmentId = null;
        }

        return departmentService.findChildDepartment(parentDepartmentId, loginUser);
    }

    @Override
    public List<Department> findAllLevelsChildDepartment(Integer tenantId, String departmentCode) throws BusinessException {
        return departmentService.findAllLevelsChildDepartment(tenantId,departmentCode);
    }
}
