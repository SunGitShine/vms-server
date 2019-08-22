package com.juma.vms.vendor.service.impl;

import com.juma.vms.vendor.dao.VendorWhiteListMapper;
import com.juma.vms.vendor.domain.VendorWhiteList;
import com.juma.vms.vendor.domain.VendorWhiteListExample;
import com.juma.vms.vendor.service.VendorWhiteListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VendorWhiteListServiceImpl implements VendorWhiteListService {

    @Resource
    private VendorWhiteListMapper vendorWhiteListMapper;

    @Override
    public VendorWhiteList loadVendorWhiteListByVendorId(Integer vendorId) {
        if (null == vendorId) {
            return null;
        }

        List<VendorWhiteList> list = vendorWhiteListMapper.selectByExample(
                new VendorWhiteListExample().createCriteria()
                        .andVendorIdEqualTo(vendorId)
                        .example());

        return list.isEmpty() ? null : list.get(0);
    }
}
