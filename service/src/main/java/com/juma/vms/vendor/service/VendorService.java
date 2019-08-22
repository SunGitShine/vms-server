package com.juma.vms.vendor.service;

import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.giants.common.tools.PageQueryCondition;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.external.VendorQueryConditionDto;
import com.juma.vms.vendor.vo.VendorBo;
import com.juma.vms.vendor.vo.VendorFilter;
import com.juma.vms.vendor.vo.VendorQuery;

import java.util.List;

/**
 * @author Libin.Wei
 * @version 1.0.0
 * @ClassName VendorService.java
 * @Description 承运商信息
 * @Date 2018年10月30日 下午7:32:48
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

public interface VendorService {

    /**
     * 分页获取
     *
     * @param loginUser
     * @return
     * @throws BusinessException
     * @author Libin.Wei
     * @Date 2018年10月31日 上午9:33:11
     */
    Page<VendorQuery> search(QueryCond<VendorFilter> queryCond, LoginUser loginUser) throws BusinessException;

    /**
     * 根据承运商名称获取
     *
     * @param pageSize
     * @param loginUser
     * @return
     * @author Libin.Wei
     * @Date 2018年11月2日 下午2:55:24
     */
    List<VendorQuery> listByVendorFilter(VendorFilter vendorFilter, Integer pageSize, LoginUser loginUser);

    /**
     * 根据主键获取,基础信息
     *
     * @param vendorId
     * @return
     * @throws BusinessException
     * @author Libin.Wei
     * @Date 2018年10月30日 下午7:35:33
     */
    Vendor getVendor(Integer vendorId) throws BusinessException;

    /**
     * 根据主键获取，包含基础信息、租户信息
     *
     * @param vendorId
     * @param loginUser
     * @return
     * @throws BusinessException
     * @author Libin.Wei
     * @Date 2018年11月1日 下午5:58:06
     */
    VendorQuery getVendorDetail(Integer vendorId, LoginUser loginUser) throws BusinessException;

    /**
     * 添加
     *
     * @param vendorBo
     * @param loginUser
     * @throws BusinessException
     * @author Libin.Wei
     * @Date 2018年10月31日 上午9:38:04
     */
    Integer insert(VendorBo vendorBo, LoginUser loginUser) throws BusinessException;

    /**
     * 修改
     *
     * @param vendorBo
     * @param loginUser
     * @throws BusinessException
     * @author Libin.Wei
     * @Date 2018年10月31日 上午9:38:04
     */
    void update(VendorBo vendorBo, LoginUser loginUser) throws BusinessException;

    /**
     * 修改基础信息
     *
     * @param vendor
     * @param loginUser
     * @throws BusinessException
     * @author Libin.Wei
     * @Date 2018年10月31日 上午9:38:04
     */
    void updateBase(Vendor vendor, LoginUser loginUser) throws BusinessException;

    /**
     * 删除承运商
     *
     * @param vendorId
     * @param loginUser
     * @throws BusinessException
     * @author Libin.Wei
     * @Date 2018年10月31日 上午9:38:04
     */
    void delete(Integer vendorId, LoginUser loginUser) throws BusinessException;

    /**
     * 根据手机号获取承运商信息
     *
     * @param phone  不能为空
     * @param isOpen 可空
     * @return
     * @author Libin.Wei
     * @Date 2018年11月1日 上午10:52:52
     */
    Vendor loadByPhone(String phone, Byte isOpen);

    /**
     * 根据身份证号获取承运商信息
     *
     * @param idCardNo 不能为空
     * @param isOpen   可空
     * @return
     * @author Libin.Wei
     * @Date 2018年11月1日 上午10:52:52
     */
    Vendor loadByIdCardNo(String idCardNo, Byte isOpen);

    /**
     * 根据企业信用代码获取承运商信息
     *
     * @param enterpriseCode 企业信用代码，不能为空
     * @param isOpen         可空
     * @return
     */
    Vendor loadByEnterpriseCode(String enterpriseCode, Byte isOpen);

    /**
     * 根据userId获取
     *
     * @param userId
     * @param isDelete
     * @return
     * @author Libin.Wei
     * @Date 2018年11月5日 下午5:42:09
     */
    Vendor findByUserId(Integer userId, Boolean isDelete);

    /**
     * 修改承运商或联系人信息
     *
     * @param vendorId
     * @param name         个人承运商名称或企业承运商联系人名称
     * @param contactPhone
     * @author Libin.Wei
     * @Date 2018年11月5日 下午6:12:04
     */
    void updateNameAndPhone(Integer vendorId, String name, String contactPhone);

    /**
     * 转为账号
     *
     * @param vendorId
     * @param loginUser
     * @throws BusinessException
     */
    Integer vendor2user(Integer vendorId, LoginUser loginUser) throws BusinessException;

    /**
     * 分页获取，简单数据
     *
     * @param pageQueryCondition
     * @return
     * @throws BusinessException
     * @author Libin.Wei
     * @Date 2018年10月31日 上午9:33:11
     */
    Page<VendorQuery> searchSimple(PageQueryCondition<VendorQueryConditionDto> pageQueryCondition) throws BusinessException;

    /**
     * 校验客户的证件号和承运商的证件号是不是一致
     * @param vendorId
     * @param crmCustomerName
     * @param crmIdentityCardNo
     * @return true：一致； false：不一致
     * @throws BusinessException
     */
    boolean checkCrmCustomer(Integer vendorId, String crmCustomerName, String crmIdentityCardNo) throws BusinessException;
}
