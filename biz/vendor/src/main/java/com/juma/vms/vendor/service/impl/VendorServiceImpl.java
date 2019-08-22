package com.juma.vms.vendor.service.impl;

import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.giants.common.tools.PageQueryCondition;
import com.juma.auth.tenant.domain.Tenant;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.common.BaseUtil;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.tool.domain.SmsCode;
import com.juma.vms.tool.service.AuthCommonService;
import com.juma.vms.tool.service.BusinessAreaCommonService;
import com.juma.vms.tool.service.MdcCommonService;
import com.juma.vms.tool.service.MessageService;
import com.juma.vms.tool.service.ThirdpartyCommonService;
import com.juma.vms.vendor.dao.VendorMapper;
import com.juma.vms.vendor.dao.ext.VendorExtMapper;
import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.domain.VendorExample;
import com.juma.vms.vendor.domain.VendorTenant;
import com.juma.vms.vendor.enumeration.VendorTypeEnum;
import com.juma.vms.vendor.external.VendorQueryConditionDto;
import com.juma.vms.vendor.service.VendorService;
import com.juma.vms.vendor.service.VendorTenantService;
import com.juma.vms.vendor.vo.VendorBo;
import com.juma.vms.vendor.vo.VendorFilter;
import com.juma.vms.vendor.vo.VendorIdentification;
import com.juma.vms.vendor.vo.VendorQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author Libin.Wei
 * @version 1.0.0
 * @ClassName VendorServiceImpl.java
 * @Description 承运商信息
 * @Date 2018年10月30日 下午7:33:28
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

@Service
public class VendorServiceImpl implements VendorService {

    private static final byte PREFIX_IS_FALSE = (byte) 0;
    private static final byte PREFIX_IS_TRUE = (byte) 1;
    @Resource
    private VendorMapper vendorMapper;
    @Resource
    private VendorExtMapper vendorExtMapper;
    @Resource
    private VendorTenantService vendorTenantService;
    @Resource
    private AuthCommonService authCommonService;
    @Resource
    private BusinessAreaCommonService businessAreaCommonService;
    @Resource
    private ThirdpartyCommonService thirdpartyCommonService;
    @Resource
    private MdcCommonService mdcCommonService;
    @Resource
    private MessageService messageService;

    @Override
    public Page<VendorQuery> search(QueryCond<VendorFilter> queryCond, LoginUser loginUser) throws BusinessException {
        if (null == loginUser || null == loginUser.getTenantId()) {
            return new Page<>(queryCond.getPageNo(), queryCond.getPageSize(), 0, new ArrayList<VendorQuery>());
        }

        queryCond.getFilters().setTenantId(loginUser.getTenantId());
        queryCond.getFilters().setIsDelete(PREFIX_IS_FALSE);

        int total = vendorExtMapper.searchCount(queryCond);
        List<VendorQuery> rows = vendorExtMapper.search(queryCond);
        for (VendorQuery q : rows) {
            q.setAreaName(businessAreaCommonService.loadLogicAndSelfAreaName(q.getAreaCode(), loginUser));
        }
        return new Page<>(queryCond.getPageNo(), queryCond.getPageSize(), total, rows);
    }

    @Override
    public List<VendorQuery> listByVendorFilter(VendorFilter vendorFilter, Integer pageSize, LoginUser loginUser) {
        QueryCond<VendorFilter> cond = new QueryCond<>();
        cond.setPageNo(1);
        cond.setPageSize((pageSize == null || pageSize < 0) ? 100 : pageSize);

        if (null != loginUser && null != loginUser.getTenantId()) {
            vendorFilter.setTenantId(loginUser.getTenantId());
        } else {
            vendorFilter.setIsOwner((byte) 1);
        }

        cond.setFilters(vendorFilter);
        List<VendorQuery> rows = vendorExtMapper.search(cond);
        // 注意：此方法为承运商关键字查询，为保证其效率，for循环中不得添加任何查询方法
        for (VendorQuery q : rows) {
            q.setCredentialNo(q.getVendorType() == VendorTypeEnum.ENTERPRISE.getCode() ? q.getEnterpriseCode() : q.getIdCardNo());
        }
        return rows;
    }

    @Override
    public Vendor getVendor(Integer vendorId) throws BusinessException {
        if (null == vendorId) {
            return null;
        }

        return vendorMapper.selectByPrimaryKey(vendorId);
    }

    @Override
    public VendorQuery getVendorDetail(Integer vendorId, LoginUser loginUser) throws BusinessException {
        Vendor vendor = this.getVendor(vendorId);
        if (null == vendor) {
            return null;
        }

        VendorQuery query = new VendorQuery();
        BeanUtils.copyProperties(vendor, query);


        VendorTenant vendorTenant = vendorTenantService.loadByVendorId(vendorId, loginUser);
        if (null == vendorTenant) {
            return query;
        }

        query.setIsOwner(vendorTenant.getIsOwner() == (byte) 1 ? true : false);
        query.setTenantId(vendorTenant.getTenantId());
        query.setAreaCode(vendorTenant.getAreaCode());
        query.setEnable(vendorTenant.getIsEnable());
        query.setCustomerId(vendorTenant.getCustomerId());
        query.setVendorTenantId(vendorTenant.getVendorTenantId());
        query.setAreaName(businessAreaCommonService.loadLogicAndSelfAreaName(vendorTenant.getAreaCode(), loginUser));
        if (!query.getIsOwner()) {
            // 不是创建方，去获取创建方
            List<VendorTenant> list = vendorTenantService.listVendorTenantByVendorId(vendorId);
            for (VendorTenant t : list) {
                if (null != t.getIsOwner() && t.getIsOwner() == (byte) 1) {
                    Tenant tenant = authCommonService.loadByTenantId(t.getTenantId());
                    query.setOwnerName(tenant == null ? null : tenant.getTenantName());
                }
            }
        } else {
            Tenant tenant = authCommonService.loadByTenantId(vendorTenant.getTenantId());
            query.setOwnerName(tenant == null ? null : tenant.getTenantName());
        }
        return query;
    }

    @Override
    public Integer insert(VendorBo vendorBo, LoginUser loginUser) throws BusinessException {
        Vendor vendor = vendorBo.getVendor();
        // 创建方新建承运商
        if (null == vendor.getVendorId()) {
            this.check(vendor, loginUser);
            this.validate(vendor, loginUser);
            vendor.setSerialNo(BaseUtil.generationCoding(loginUser.getTenantId()));
            vendor.setCreateUserId(loginUser.getUserId());
            vendor.setCreateTime(new Date());
            vendor.setIsDelete(PREFIX_IS_FALSE);
            vendor.setIsOpen(PREFIX_IS_TRUE);
//            vendor.setIsShowYourPrice(PREFIX_IS_TRUE);
            vendor.setIsSyncAsDriver(PREFIX_IS_FALSE);
            vendorMapper.insert(vendor);

            VendorTenant vendorTenant = vendorBo.getVendorTenant();
            vendorTenant.setVendorId(vendor.getVendorId());
            vendorTenant.setTenantId(loginUser.getTenantId());
            vendorTenant.setIsOwner((byte) 1);
            vendorTenantService.insert(vendorTenant, loginUser);
            this.vendor2user(vendor.getVendorId(), loginUser);

            // 写入主数据中心
            vendor.setJumaPin(mdcCommonService.addVendorToMdata(new VendorIdentification(vendor), loginUser));
            // 回写到vendor表
            vendorMapper.updateByPrimaryKeySelective(vendor);
            return vendor.getVendorId();
        }

        // 使用方认领
        VendorTenant historyVendorTenant = vendorTenantService.loadByVendorId(vendor.getVendorId(), loginUser);
        if (null == historyVendorTenant) {
            // 若查询不到，则建立绑定关系
            VendorTenant vendorTenant = vendorBo.getVendorTenant();
            vendorTenant.setVendorId(vendor.getVendorId());
            vendorTenant.setTenantId(loginUser.getTenantId());
            vendorTenant.setIsOwner((byte) 0);
            vendorTenantService.insert(vendorTenant, loginUser);
            // 授权
            this.vendor2user(vendor.getVendorId(), loginUser);
        }

        return vendor.getVendorId();
    }

    @Override
    public void update(VendorBo vendorBo, LoginUser loginUser) throws BusinessException {
        Vendor vendor = vendorBo.getVendor();
        // 判断是不是归属方更改
        VendorTenant historyVendorTenant = vendorTenantService.loadByVendorId(vendor.getVendorId(), loginUser);

        // 若不是归属方，则只更改绑定关系
        if (historyVendorTenant.getIsOwner() == (byte) 0) {
            historyVendorTenant.setAreaCode(vendorBo.getVendorTenant().getAreaCode());
            vendorTenantService.update(historyVendorTenant, loginUser);
            return;
        }

        // 归属方
        String oldJumaPin = this.check(vendor, loginUser);
        this.checkUpdatePhone(vendor.getVendorId(), vendor.getContactPhone(),vendorBo.getIdentifyingCode());
        vendor.setLastUpdateUserId(loginUser.getUserId());
        vendor.setLastUpdateTime(new Date());
        vendorMapper.updateByPrimaryKeySelective(vendor);

        historyVendorTenant.setAreaCode(vendorBo.getVendorTenant().getAreaCode());
        historyVendorTenant.setCustomerId(vendorBo.getVendorTenant().getCustomerId());
        vendorTenantService.update(historyVendorTenant, loginUser);

        // 处理历史数据，若jumaPin不为空，则直接返回
        if (StringUtils.isNotBlank(oldJumaPin)) {
            return;
        }

        // 身份证或企业信用代码有效性验证，未通过直接返回
        try {
            this.validate(vendor, loginUser);
        } catch (Exception e) {
            return;
        }

        // 防止数据已经写入主数据中心但是VMS报错，故放在最后
        // 写入主数据中心
        vendor.setJumaPin(mdcCommonService.addVendorToMdata(new VendorIdentification(vendor), loginUser));
        // 回写到vendor表
        vendorMapper.updateByPrimaryKeySelective(vendor);
    }

    @Override
    public void updateBase(Vendor vendor, LoginUser loginUser) throws BusinessException {
        if (null == vendor || null == vendor.getVendorId()) {
            return;
        }

        vendor.setLastUpdateUserId(loginUser == null ? null : loginUser.getUserId());
        vendor.setLastUpdateTime(new Date());
        vendorMapper.updateByPrimaryKeySelective(vendor);
    }

    // 短信验证码校验
    private void checkUpdatePhone(Integer vendorId, String phone, String identifyingCode) {
        Vendor vendor = this.getVendor(vendorId);
        if (null == vendor) {
            return;
        }

        if (phone.equals(vendor.getContactPhone())) {
            return;
        }

        if (StringUtils.isBlank(identifyingCode)) {
            throw new BusinessException("identifyingCodeRequired", "vendor.error.identifyingCodeRequired");
        }

        SmsCode smsCode = new SmsCode();
        smsCode.setPhone(phone);
        smsCode.setSmsCode(identifyingCode);
        if (!messageService.verifySmsCode(smsCode)) {
            throw new BusinessException("identifyingCodeError", "vendor.error.identifyingCodeError");
        }
    }

    // 校验
    private String check(Vendor vendor, LoginUser loginUser) {
        if (null == vendor) {
            throw new BusinessException("paramsError", "errors.paramsError");
        }

        if (null == vendor.getVendorType() || vendor.getVendorType() == 0) {
            throw new BusinessException("vendorTypeRequired", "vendor.error.vendorTypeRequired");
        }

        if (null == vendor.getVendorSource()) {
            throw new BusinessException("vendorSourceRequired", "vendor.error.vendorSourceRequired");
        }

        if (StringUtils.isBlank(vendor.getVendorName())) {
            throw new BusinessException("vendorNameRequired", "vendor.error.vendorNameRequired");
        }

        if (vendor.getVendorName().length() > 200) {
            throw new BusinessException("vendorNameTooLong", "vendor.error.vendorNameTooLong", 200);
        }

        if (StringUtils.isBlank(vendor.getContactUserName())) {
            throw new BusinessException("contactUserNameRequired", "vendor.error.contactUserNameRequired");
        }

        if (vendor.getContactUserName().length() > 15) {
            throw new BusinessException("contactUserNameTooLong", "vendor.error.contactUserNameTooLong", 15);
        }

        if (StringUtils.isBlank(vendor.getContactPhone())) {
            throw new BusinessException("contactPhoneRequired", "vendor.error.contactPhoneRequired");
        }

        if (!BaseUtil.checkMobilePhone(vendor.getContactPhone())) {
            throw new BusinessException("contactPhoneError", "vendor.error.contactPhoneError");
        }

        if (null == vendor.getIsShowYourPrice()) {
            throw new BusinessException("showYourPriceRequired", "vendor.error.showYourPriceRequired");
        }

        if (StringUtils.isNotBlank(vendor.getVendorAddress()) && vendor.getVendorAddress().length() > 30) {
            throw new BusinessException("vendoAddressTooLong", "vendor.error.vendoAddressTooLong", 30);
        }

        if (StringUtils.isNotBlank(vendor.getBankOfDeposit()) && vendor.getBankOfDeposit().length() > 200) {
            throw new BusinessException("bankOfDepositTooLong", "vendor.error.bankOfDepositTooLong", 200);
        }

        if (StringUtils.isNotBlank(vendor.getBankAccount()) && vendor.getBankAccount().length() > 100) {
            throw new BusinessException("bankAccountTooLong", "vendor.error.bankAccountTooLong", 100);
        }

        // 手机号唯一
        Vendor byPhone = this.loadByPhone(vendor.getContactPhone(), null);
        if (null != byPhone && byPhone.getIsDelete().equals((byte) 0)) {
            if (null == vendor.getVendorId()) {
                throw new BusinessException("contactPhoneExist", "vendor.error.contactPhoneExist");
            }

            if (null != vendor.getVendorId() && !vendor.getVendorId().equals(byPhone.getVendorId())) {
                throw new BusinessException("contactPhoneExist", "vendor.error.contactPhoneExist");
            }

            return byPhone.getJumaPin();
        }

        return null;
    }

    // 实名认证
    private void validate(Vendor vendor, LoginUser loginUser) {
        if (vendor.getVendorType() == VendorTypeEnum.ENTERPRISE.getCode()) {
//            if (StringUtils.isBlank(vendor.getBusinessLicenseImg1())) {
//                throw new BusinessException("businessLicenseImg1Required", "vendor.error.businessLicenseImg1Required");
//            }
//
//            if (StringUtils.isBlank(vendor.getBusinessLicenseImg2())) {
//                throw new BusinessException("businessLicenseImg2Required", "vendor.error.businessLicenseImg2Required");
//            }
//            if (StringUtils.isBlank(vendor.getRoadTransPermitImg1())) {
//                throw new BusinessException("roadTransPermitImg1Required", "vendor.error.roadTransPermitImg1Required");
//            }
//
//            if (StringUtils.isBlank(vendor.getRoadTransPermitImg2())) {
//                throw new BusinessException("roadTransPermitImg2Required", "vendor.error.roadTransPermitImg2Required");
//            }

            if (StringUtils.isBlank(vendor.getEnterpriseCode())) {
                throw new BusinessException("enterpriseCodeRequired", "vendor.error.enterpriseCodeRequired");
            }

            // 企业信用代码唯一
            Vendor byEnterpriseCode = this.loadByEnterpriseCode(vendor.getEnterpriseCode(), null);
            if (null != byEnterpriseCode && byEnterpriseCode.getIsDelete().equals((byte) 0)) {
                if (null == vendor.getVendorId()) {
                    throw new BusinessException("enterpriseCodeExist", "vendor.error.enterpriseCodeExist");
                }

                if (null != vendor.getVendorId() && !vendor.getVendorId().equals(byEnterpriseCode.getVendorId())) {
                    throw new BusinessException("enterpriseCodeExist", "vendor.error.enterpriseCodeExist");
                }
            }


            // 企业认证
            if (!thirdpartyCommonService.validateEnterprise(vendor.getVendorName(),vendor.getEnterpriseCode(),loginUser)) {
                throw new BusinessException("enterpriseCodeAndNameValidateFailed", "vendor.error.enterpriseCodeAndNameValidateFailed");
            }
        }

        if (vendor.getVendorType() == VendorTypeEnum.PERSONAL.getCode()
                || vendor.getVendorType() == VendorTypeEnum.TRUCK_FLEET.getCode()) {
//            if (StringUtils.isBlank(vendor.getIdCardImg1())) {
//                throw  new BusinessException("idCardImg1Required", "vendor.error.idCardImg1Required");
//            }
//
//            if (StringUtils.isBlank(vendor.getIdCardImg2())) {
//                throw  new BusinessException("idCardImg2Required", "vendor.error.idCardImg2Required");
//            }

            if (StringUtils.isBlank(vendor.getIdCardNo())) {
                throw new BusinessException("idCardNoRequired", "vendor.error.idCardNoRequired");
            }

            // 身份证唯一
            Vendor byIdCardNo = this.loadByIdCardNo(vendor.getIdCardNo(), null);
            if (null != byIdCardNo && byIdCardNo.getIsDelete().equals((byte) 0)) {
                if (null == vendor.getVendorId()) {
                    throw new BusinessException("idCardNoExist", "vendor.error.idCardNoExist");
                }

                if (null != vendor.getVendorId() && !vendor.getVendorId().equals(byIdCardNo.getVendorId())) {
                    throw new BusinessException("idCardNoExist", "vendor.error.idCardNoExist");
                }
            }

            // 实名认证
            if (!thirdpartyCommonService.validateIdCardAndName(vendor.getVendorName(), vendor.getIdCardNo(), loginUser)) {
                throw new BusinessException("idCardNoAndNameValidateFailed", "vendor.error.idCardNoAndNameValidateFailed");
            }
        }
    }

    @Override
    public void delete(Integer vendorId, LoginUser loginUser) throws BusinessException {
        Vendor vendor = this.getVendor(vendorId);
        if (null == vendor) {
            return;
        }

        vendor.setIsDelete(PREFIX_IS_TRUE);
        vendorMapper.updateByPrimaryKeySelective(vendor);
    }

    @Override
    public Vendor loadByPhone(String phone, Byte isOpen) {
        if (StringUtils.isBlank(phone)) {
            return null;
        }

        VendorExample example =
                new VendorExample().createCriteria().andContactPhoneEqualTo(phone).andIsOpenEqualTo(isOpen).example();
        List<Vendor> list = vendorMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Vendor loadByIdCardNo(String idCardNo, Byte isOpen) {
        if (StringUtils.isBlank(idCardNo)) {
            return null;
        }

        VendorExample example =
                new VendorExample().createCriteria().andIdCardNoEqualTo(idCardNo).andIsOpenEqualTo(isOpen).example();
        List<Vendor> list = vendorMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Vendor loadByEnterpriseCode(String enterpriseCode, Byte isOpen) {
        if (StringUtils.isBlank(enterpriseCode)) {
            return null;
        }

        VendorExample example = new VendorExample();
        VendorExample.Criteria criteria = example.createCriteria();
        criteria.andEnterpriseCodeEqualTo(enterpriseCode);
        criteria.andIsDeleteEqualTo(PREFIX_IS_FALSE);
        if (null != isOpen) {
            criteria.andIsOpenEqualTo(isOpen);
        }

        List<Vendor> list = vendorMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);

    }

    @Override
    public Vendor findByUserId(Integer userId, Boolean isDelete) {
        if (null == userId) {
            return null;
        }

        VendorExample example =
                new VendorExample().createCriteria().andUserIdEqualTo(userId).andIsDeleteEqualTo(isDelete == null ?
                        null : (isDelete ? PREFIX_IS_TRUE : PREFIX_IS_FALSE)).example();

        List<Vendor> list = vendorMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void updateNameAndPhone(Integer vendorId, String name, String contactPhone) {
        if (null == vendorId) {
            return;
        }

        if (StringUtils.isBlank(name) && StringUtils.isBlank(contactPhone)) {
            return;
        }

        Vendor vendor = this.getVendor(vendorId);
        if (null == vendor || null == vendor.getVendorType()) {
            return;
        }

        if (vendor.getVendorType() == VendorTypeEnum.PERSONAL.getCode()) {
            vendor.setVendorName(name);
        } else {
            vendor.setContactUserName(name);
        }
        vendor.setContactPhone(contactPhone);
        vendorMapper.updateByPrimaryKeySelective(vendor);
    }

    @Override
    public Integer vendor2user(Integer vendorId, LoginUser loginUser) throws BusinessException {
        Vendor vendor = this.getVendor(vendorId);
        if (null == vendor) {
            return null;
        }

        VendorTenant vendorTenant = vendorTenantService.loadByVendorId(vendorId, loginUser);
        if (null == vendorTenant) {
            return null;
        }

        Integer userId = authCommonService.vendor2User(vendor, vendorTenant, loginUser);
        if (null == userId) {
            return null;
        }

        // 若不是归属方调用，则只是授权，不去更新vendor表
        if (vendorTenant.getIsOwner() != (byte) 1) {
            return null;
        }

        vendor.setUserId(userId);
        vendor.setIsSyncAsVendor(PREFIX_IS_TRUE);
        vendorMapper.updateByPrimaryKey(vendor);

        return userId;
    }

    @Override
    public Page<VendorQuery> searchSimple(PageQueryCondition<VendorQueryConditionDto> pageQueryCondition) throws BusinessException {
        if (null == pageQueryCondition) {
            return new Page<VendorQuery>();
        }

        VendorQueryConditionDto dto = pageQueryCondition.getFilters();
        if (null == dto || null == dto.getTenantId()) {
            return new Page<VendorQuery>(pageQueryCondition.getPageNo(), pageQueryCondition.getPageSize(), 0, new ArrayList<VendorQuery>());
        }

        List<String> areaCodeList = new ArrayList<>();
        if (StringUtils.isNotBlank(dto.getAreaCode())) {
            areaCodeList.add(dto.getAreaCode());
        }

        QueryCond<VendorFilter> cond = new QueryCond<>();
        cond.setPageNo(pageQueryCondition.getPageNo());
        cond.setPageSize(pageQueryCondition.getPageSize());
        VendorFilter filter = new VendorFilter();
        filter.setTenantId(dto.getTenantId());
        filter.setIsDelete(PREFIX_IS_FALSE);
        filter.setVendorName(StringUtils.isNotBlank(dto.getVendorName()) ? dto.getVendorName() : null);
        filter.setAreaCodeList(areaCodeList.isEmpty() ? null : areaCodeList);
        cond.setFilters(filter);

        int total = vendorExtMapper.searchCount(cond);
        List<VendorQuery> rows = vendorExtMapper.search(cond);
        return new Page<VendorQuery>(pageQueryCondition.getPageNo(), pageQueryCondition.getPageSize(), total, rows);
    }

    @Override
    public boolean checkCrmCustomer(Integer vendorId, String crmCustomerName, String crmIdentityCardNo) throws BusinessException {
        if (null == vendorId) {
            throw new BusinessException("pleaseSelectCustomer", "errors.common.prompt", "未知承运商，请刷新重试或联系客服，谢谢");
        }

        if (StringUtils.isBlank(crmCustomerName) || StringUtils.isBlank(crmIdentityCardNo)) {
            return false;
        }

        Vendor vendor = this.getVendor(vendorId);
        if (null == vendor) {
            throw new BusinessException("pleaseSelectCustomer", "errors.common.prompt", "未知承运商，请刷新重试或联系客服，谢谢");
        }

        if (vendor.getVendorType() == VendorTypeEnum.ENTERPRISE.getCode()) {
            if (!crmCustomerName.equals(vendor.getVendorName()) || !crmIdentityCardNo.equals(vendor.getEnterpriseCode())) {
                return false;
            }
        } else {
            if (!crmCustomerName.equals(vendor.getVendorName()) || !crmIdentityCardNo.equals(vendor.getIdCardNo())) {
                return false;
            }
        }

        return true;
    }

}
