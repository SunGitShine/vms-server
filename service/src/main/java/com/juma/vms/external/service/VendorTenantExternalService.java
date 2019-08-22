package com.juma.vms.external.service;

import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.vendor.external.VendorTenantExternal;

/**
 * @author Libin.Wei
 * @version 1.0.0
 * @ClassName VendorTenantExternalService.java
 * @Description 承运商租户信息对外类
 * @Date 2018年10月31日 下午7:07:57
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

public interface VendorTenantExternalService {

    /**
     * 根据承运商ID获取
     *
     * @param vendorId
     *         为空返回NULL
     * @param loginUser
     *         为空或loginUser.tenantId为空返回NULL
     * @return
     */
    VendorTenantExternal loadVendorTenantByVendorId(Integer vendorId, LoginUser loginUser);
}
