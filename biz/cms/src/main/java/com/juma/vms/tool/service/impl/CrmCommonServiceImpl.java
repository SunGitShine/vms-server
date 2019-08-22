package com.juma.vms.tool.service.impl;

import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.giants.common.tools.PageCondition;
import com.giants.common.tools.PageQueryCondition;
import com.google.common.collect.Lists;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.crm.customer.domain.CustomerInfo;
import com.juma.crm.support.domain.CustomerInfoBo;
import com.juma.crm.support.domain.CustomerInfoFilters;
import com.juma.crm.support.service.CrmService;
import com.juma.vms.tool.domain.CrmCustomerInfo;
import com.juma.vms.tool.domain.VmsDriverCustomerInfo;
import com.juma.vms.tool.service.CrmCommonService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CrmCommonServiceImpl implements CrmCommonService {

    @Resource
    private CrmService crmService;

    @Override
    public List<VmsDriverCustomerInfo> listByName(String crmDriverCustomerName, Integer callbackPageSize,
                                                  LoginEmployee loginEmployee) {
        List<VmsDriverCustomerInfo> result = new ArrayList<>();
        callbackPageSize = callbackPageSize == null ? 15 : (callbackPageSize <= 0 ? 15 :
                (callbackPageSize.compareTo(200) == 1 ? 200 : callbackPageSize));
        List<CustomerInfo> listCustomerInfo = null;
        try {
            PageCondition condition = new PageCondition();
            Map<String, Object> filters = new HashMap<>();
            filters.put("customerType", CustomerInfo.CustomerType.DRIVER.getValue());
            filters.put("status", CustomerInfo.CustomerStatus.SIGNED.getValue());
            filters.put("tenantId", loginEmployee.getTenantId());
            if (StringUtils.isNotBlank(crmDriverCustomerName)) {
                filters.put("customerName", crmDriverCustomerName);
            }
            condition.setPageNo(1);
            condition.setPageSize(callbackPageSize);
            condition.setFilters(filters);

            Page<CustomerInfo> page = crmService.searchBaseCustomerInfo(condition, loginEmployee);
            if (null != page && null != page.getResults()) {
                listCustomerInfo = (List<CustomerInfo>) page.getResults();
            }
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                throw e;
            }

            throw new BusinessException("crmSystemException", "errors.crmSystemException");
        }
        if (CollectionUtils.isEmpty(listCustomerInfo)) {
            return result;
        }

        for (CustomerInfo c : listCustomerInfo) {
            VmsDriverCustomerInfo vc = new VmsDriverCustomerInfo();
            vc.setCrmDriverCustomerId(c.getCustomerId());
            vc.setCrmDrivercustomerName(c.getCustomerName());
            vc.setMobileNumber(c.getContactsPhone());
            result.add(vc);
        }
        return result;
    }

    @Override
    public VmsDriverCustomerInfo findByCustomerId(Integer customerId,
                                                  LoginEmployee loginEmployee) throws BusinessException {
        if (null == customerId) {
            return null;
        }

        CustomerInfo customerInfo = null;
        try {
            customerInfo = crmService.find(customerId, loginEmployee);
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                throw e;
            }

            throw new BusinessException("crmSystemException", "errors.crmSystemException");
        }

        if (null == customerInfo) {
            return null;
        }

        VmsDriverCustomerInfo info = new VmsDriverCustomerInfo();
        info.setCrmDriverCustomerId(customerInfo.getCustomerId());
        info.setCrmDrivercustomerName(customerInfo.getCustomerName());
        info.setMobileNumber(customerInfo.getContactsPhone());
        return info;
    }

    /**根据条件,查询客户列表**/
    @Override
    public List<CrmCustomerInfo> listByFilters(CustomerInfoFilters filters, Integer pageSize){
        PageQueryCondition<CustomerInfoFilters> customerParams = new PageQueryCondition<>(filters,1,pageSize);
        Page<CustomerInfoBo> customerInfos = crmService.findCustomerInfoBo(customerParams);

        if( null == customerInfos ){
            return Lists.newArrayList();
        }

        if( org.springframework.util.CollectionUtils.isEmpty(customerInfos.getResults()) ){
            return Lists.newArrayList();
        }

        List<CrmCustomerInfo> list = Lists.newArrayList();
        for (CustomerInfoBo bo : customerInfos.getResults()) {
            CrmCustomerInfo info = new CrmCustomerInfo();
            info.setCrmCustomerId(Integer.valueOf(bo.getCustomerId()));
            info.setCrmCustomerName(bo.getCustomerName());
            info.setCrmMobileNumber(bo.getPhoneNumber());
            // 客户身份类型（1：个人 2：企业）
            if( 1 == bo.getCustomerIdentityType() ){ // 身份证
                info.setCrmIdentityCardNo(bo.getCertId());
            }else if( 2 == bo.getCustomerIdentityType() ){ // 信用代码
                info.setCrmIdentityCardNo(bo.getCreditCode());
            }
            info.setCrmCustomerType(Integer.valueOf(bo.getCustomerIdentityType()));
            info.setAreaCode(bo.getAreaCode());
            list.add(info);
        }
        return list;
    }
}
