package com.juma.vms.vendor.service;

import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.vendor.domain.VendorDriver;
import com.juma.vms.vendor.vo.VendorDriverQuery;
import java.util.List;

public interface VendorDriverService {

    /**
     * 添加
     *
     * @param vendorDriver
     * @param loginUser
     * @throws BusinessException
     */
    void insert(VendorDriver vendorDriver, LoginUser loginUser) throws BusinessException;

    /**
     * 删除
     */
    void delete(Integer vendorDriverId) throws BusinessException;

    /**
     * 根据承运商ID获取
     *
     * @param vendorId
     * @param loginUser
     * @return
     */
    VendorDriver loadByVendorId(Integer vendorId, LoginUser loginUser);

    List<VendorDriver> loadVendorDriverBy(Integer vendorId, Integer driverId, LoginUser loginUser);

    /**
     * 分页
     *
     * @param queryCond
     * @param loginUser
     * @return
     */
    Page<VendorDriverQuery> search(QueryCond<VendorDriver> queryCond, LoginUser loginUser);

    /**
     * 根据司机ID获取
     *
     * @param driverId
     * @param loginUser
     * @return
     */
    VendorDriver loadByDriverId(Integer driverId, LoginUser loginUser);

    /**
     * 更新
     *
     * @param vendorDriver
     * @param loginUser
     * @return
     */
    void update(VendorDriver vendorDriver, LoginUser loginUser) throws BusinessException;
    
    /**
     * 批量更新
     */
    void batchInsert(List<VendorDriver> rows) throws BusinessException;

    /**
     * 获取承运商下的所有司机
     *
     * @param vendorId
     * @return
     */
    List<VendorDriver> listAllDriverByVendorId(Integer vendorId);
}
