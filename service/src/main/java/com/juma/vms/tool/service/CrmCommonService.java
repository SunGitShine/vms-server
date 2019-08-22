package com.juma.vms.tool.service;

import com.giants.common.exception.BusinessException;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.crm.support.domain.CustomerInfoFilters;
import com.juma.vms.tool.domain.CrmCustomerInfo;
import com.juma.vms.tool.domain.VmsDriverCustomerInfo;

import java.util.List;

/**
 * CRM公共类
 */

public interface CrmCommonService {

    /**
     * 根据司机类型的客户名称获取
     *
     * @param crmDriverCustomerName
     *         客户名称（司机类型的）
     * @param callbackPageSize
     *         默认15条，最大返回200条
     * @param loginEmployee
     * @return
     */
    List<VmsDriverCustomerInfo> listByName(String crmDriverCustomerName, Integer callbackPageSize,
                                           LoginEmployee loginEmployee) throws BusinessException;

    /**
     * 根据客户ID获取
     *
     * @param customerId
     * @return
     * @throws BusinessException
     */
    VmsDriverCustomerInfo findByCustomerId(Integer customerId,
                                           LoginEmployee loginEmployee) throws BusinessException;
    /**
     * 根据条件,查询客户列表
     * @param filters
     * @param pageSize
     * @return
     */
    List<CrmCustomerInfo> listByFilters(CustomerInfoFilters filters, Integer pageSize);
}
