package com.juma.vms.tool.service;

import com.giants.common.exception.BusinessException;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.driver.vo.DriverIdentification;
import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.vo.VendorIdentification;

/**
 * 主数据中心接口
 */

public interface MdcCommonService {


    /**
     * 承运商写入到主数据中心
     *
     * @param vendorIdentification 必填
     * @param loginUser            必填
     * @return
     * @throws BusinessException
     */
    String addVendorToMdata(VendorIdentification vendorIdentification, LoginUser loginUser) throws BusinessException;

    /**
     * 司机写入主数据中心
     *
     * @param driverIdentification 必填
     * @param loginUser 必填
     * @return
     * @throws BusinessException
     */
    String addDriverToMdata(DriverIdentification driverIdentification, LoginUser loginUser) throws BusinessException;
}
