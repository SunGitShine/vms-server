package com.juma.vms.external.service;

import com.juma.vms.vendor.domain.VendorWhiteList;

public interface VendorWhiteListExternalService {

    /**
     * 根据承运商ID获取
     *
     * @param vendorId
     * @return
     */
    VendorWhiteList loadVendorWhiteListByVedorId(Integer vendorId);
}
