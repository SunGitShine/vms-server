package com.juma.vms.tool.service;

import com.giants.common.exception.BusinessException;
import com.juma.auth.employee.domain.Department;
import com.juma.auth.employee.domain.DepartmentBo;
import com.juma.auth.tenant.domain.Tenant;
import com.juma.auth.user.domain.LoginUser;
import com.juma.auth.user.domain.User;
import com.juma.conf.domain.ConfParamOption;
import com.juma.vms.driver.domain.Driver;
import com.juma.vms.driver.domain.DriverTenant;
import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.domain.VendorTenant;

import java.util.List;

/**
 * @author Libin.Wei
 * @version 1.0.0
 * @ClassName AuthCommonService.java
 * @Description 请填写注释...
 * @Date 2018年11月6日 下午2:54:32
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

public interface AuthCommonService {

    /**
     * 转为账号
     *
     * @param vendor
     * @param vendorTenant
     * @param loginUser
     * @throws BusinessException
     * @author Libin.Wei
     * @Date 2018年11月6日 下午2:56:55
     */
    Integer vendor2User(Vendor vendor, VendorTenant vendorTenant, LoginUser loginUser) throws BusinessException;

    /**
     * 司机转为账号
     *
     * @param driver
     * @param driverTenant
     * @param loginUser
     * @throws BusinessException
     */
    Integer driver2User(Driver driver, DriverTenant driverTenant, LoginUser loginUser) throws BusinessException;

    /**
     * 获取ecoUserId
     *
     * @param userId
     * @param loginUser
     * @return
     * @author Libin.Wei
     * @Date 2018年11月20日 上午11:43:05
     */
    Integer loadEcoUserId(Integer userId, LoginUser loginUser);

    /**
     * 根据租户ID获取租户信息
     *
     * @param tenantId
     * @return
     */
    Tenant loadByTenantId(Integer tenantId);

    /**
     * 根据userid获取用户信息
     *
     * @param userId
     * @return
     */
    User loadUser(Integer userId);

    /**
     * 查询所有数据字典项
     */
    List<ConfParamOption> getAllOption(String optionKey);

    /**
     * 查询数据字典项名称
     */
    String getOptionName(String optionKey, String optionValue);

    /**
     * 根据部门ID获取部门信息
     * @param departmentId
     * @return
     */
    Department loadDepartment(Integer departmentId);

    /**
     * 根据部门ID获取当前租户下部门信息
     * @param departmentId
     * @return
     */
    Department loadDepartment(Integer departmentId,LoginUser loginUser);

    /**
     * 根据部门Code获取当前租户下部门信息
     * @param departmentCode
     * @return
     */
    Department loadDepartment(String departmentCode, LoginUser loginUser);

    /**
     * 根据部门ID获取当前租户下部门信息以及扩展信息
     * @param departmentId
     * @param loginUser
     * @return
     */
    DepartmentBo findDepartmentBo(Integer departmentId,LoginUser loginUser);


    /**
     * 查询登录租户下的所有部门
     *
     */
    List<Department> loadDepartmentList(LoginUser loginUser);

    /**
     * 根据父部门ID返回所有子部门
     * @param parentDepartmentId
     * @param loginUser
     * @return
     * @throws BusinessException
     */
    List<Department> listChildDepartment(Integer parentDepartmentId, LoginUser loginUser)throws BusinessException;


    /**
     * 通过当前部门CODE查找当前部门及其所有下级部门
     * @param tenantId
     * @param departmentCode
     * @return
     * @throws BusinessException
     */
    List<Department> findAllLevelsChildDepartment(Integer tenantId, String departmentCode) throws BusinessException;
}
