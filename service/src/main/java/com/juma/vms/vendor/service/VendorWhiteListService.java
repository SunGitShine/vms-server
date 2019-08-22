package com.juma.vms.vendor.service;

import com.juma.vms.vendor.domain.VendorWhiteList;

/**
 * 承运商白名单
 */

public interface VendorWhiteListService {

    /**
     * 根据承运商ID获取
     *
     * @param vendorId
     * @return
     */
    VendorWhiteList loadVendorWhiteListByVendorId(Integer vendorId);
}
