package com.juma.vms.external.service;

import com.giants.common.exception.BusinessException;
import com.juma.server.vm.domain.dto.RenterQueryConditionDTO;
import com.juma.server.vm.domain1.bo.RenterBO;

/**
 * @ClassName VendorTemporaryExternalService.java
 * @Description 专为FMS临时提供，其它系统请勿使用
 * @author Libin.Wei
 * @Date 2018年11月15日 上午10:09:35
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

@Deprecated
public interface VendorForFmsExternalService {

    /**
     * 专为FMS临时提供，其它系统请勿使用
     */
    RenterBO getByPlateNumberForFMS(String plateNo, Integer tenantId) throws BusinessException;

    /**
     * 专为FMS临时提供，其它系统请勿使用
     */
    RenterBO getById(RenterQueryConditionDTO renterQueryConditionDTO) throws BusinessException;
}
