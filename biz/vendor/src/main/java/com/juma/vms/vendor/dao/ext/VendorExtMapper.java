package com.juma.vms.vendor.dao.ext;

import com.juma.vms.common.query.QueryCond;
import com.juma.vms.vendor.domain.VendorTenant;
import com.juma.vms.vendor.domain.VendorVehicle;
import com.juma.vms.vendor.vo.VendorFilter;
import com.juma.vms.vendor.vo.VendorQuery;

import java.util.List;

/**
 * 
 * @ClassName VendorCustomMapper.java 自定义mapper
 * @author Libin.Wei
 * @Date 2018年10月31日 下午5:40:17
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

public interface VendorExtMapper {

    /**
     * 
     * 统计
     * 
     * @author Libin.Wei
     * @Date 2018年10月31日 下午5:41:47
     * @param queryCond
     * @return
     */
    int searchCount(QueryCond<VendorFilter> queryCond);

    /**
     * 
     * 根据条件查询
     * 
     * @author Libin.Wei
     * @Date 2018年10月31日 下午5:41:59
     * @param queryCond
     * @return
     */
    List<VendorQuery> search(QueryCond<VendorFilter> queryCond);

    /**
     * 
     * 根据条件查询
     * 
     * @author Libin.Wei
     * @Date 2018年11月14日 下午7:48:05
     * @param vendorTenant
     * @return
     */
    List<VendorVehicle> listVendorVehicleBy(VendorTenant vendorTenant);
}