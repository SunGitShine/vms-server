package com.juma.vms.vendor.service.impl;

import com.giants.common.exception.BusinessException;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.transport.service.CapacityPoolService;
import com.juma.vms.vendor.dao.VendorTenantMapper;
import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.domain.VendorTenant;
import com.juma.vms.vendor.domain.VendorTenantExample;
import com.juma.vms.vendor.domain.VendorTenantExample.Criteria;
import com.juma.vms.vendor.service.VendorService;
import com.juma.vms.vendor.service.VendorTenantService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Libin.Wei
 * @version 1.0.0
 * @ClassName VendorTenantServiceImpl.java
 * @Description 承运商租户管理
 * @Date 2018年10月30日 下午8:03:49
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

@Service
public class VendorTenantServiceImpl implements VendorTenantService {

    @Resource
    private VendorTenantMapper vendorTenantMapper;
    @Resource
    private VendorService vendorService;
    @Resource
    private CapacityPoolService capacityPoolService;

    @Override
    public VendorTenant getVendorTenant(Integer vendorTenantId) throws BusinessException {
        if (null == vendorTenantId) {
            return null;
        }

        return vendorTenantMapper.selectByPrimaryKey(vendorTenantId);
    }

    @Override
    public List<VendorTenant> listVendorTenantByVendorId(Integer vendorId) throws BusinessException {
        if (null == vendorId) {
            return new ArrayList<VendorTenant>();
        }

        VendorTenantExample example = new VendorTenantExample();
        example.createCriteria().andVendorIdEqualTo(vendorId);
        return vendorTenantMapper.selectByExample(example);
    }

    @Override
    public void insert(VendorTenant vendorTenant, LoginUser loginUser) throws BusinessException {
        this.check(vendorTenant, loginUser);
        vendorTenant.setIsEnable(true);
        vendorTenant.setCreateUserId(loginUser.getUserId());
        vendorTenant.setCreateTime(new Date());
        vendorTenantMapper.insert(vendorTenant);
    }

    @Override
    public void update(VendorTenant vendorTenant, LoginUser loginUser) throws BusinessException {
        this.check(vendorTenant, loginUser);
        VendorTenant vt = this.getVendorTenant(vendorTenant.getVendorTenantId());
        vt.setAreaCode(vendorTenant.getAreaCode());
        vt.setCustomerId(vendorTenant.getCustomerId());
        vt.setLastUpdateUserId(loginUser.getUserId());
        vt.setLastUpdateTime(new Date());
        vendorTenantMapper.updateByPrimaryKey(vt);
    }

    // 校验
    private void check(VendorTenant vendorTenant, LoginUser loginUser) {
        if (null == vendorTenant || null == loginUser) {
            throw new BusinessException("paramsError", "errors.paramsError");
        }

        if (null == loginUser.getTenantId()) {
            throw new BusinessException("tenantRequired", "vendorTenant.error.tenantRequired");
        }

        if (StringUtils.isBlank(vendorTenant.getAreaCode())) {
            throw new BusinessException("areaCodeRequired", "vendorTenant.error.areaCodeRequired");
        }

        VendorTenant byVendorId = this.loadByVendorId(vendorTenant.getVendorId(), loginUser);
        if (null == byVendorId) {
            return;
        }

        if (null == vendorTenant.getVendorTenantId()) {
            throw new BusinessException("vendorTenantExist", "vendorTenant.error.vendorTenantExist");
        }

        if (!vendorTenant.getVendorTenantId().equals(byVendorId.getVendorTenantId())) {
            throw new BusinessException("vendorTenantExist", "vendorTenant.error.vendorTenantExist");
        }

    }

    @Override
    public void delete(Integer vendorTenantId, LoginUser loginUser) throws BusinessException {
        VendorTenant vendorTenant = this.getVendorTenant(vendorTenantId);
        if (null == vendorTenant) {
            return;
        }

        if (null != vendorTenant.getIsOwner() && vendorTenant.getIsOwner() == (byte) 1) {
            throw new BusinessException("vendorTenantOwnerCannotDelete",
                    "vendorTenant.error.vendorTenantOwnerCannotDelete");
        }
        vendorTenantMapper.deleteByPrimaryKey(vendorTenantId);
    }

    @Override
    public VendorTenant loadByVendorId(Integer vendorId, LoginUser loginUser) {
        if (null == vendorId || null == loginUser || null == loginUser.getTenantId()) {
            return null;
        }

        VendorTenantExample example = new VendorTenantExample();
        Criteria criteria = example.createCriteria();
        criteria.andVendorIdEqualTo(vendorId);
        criteria.andTenantIdEqualTo(loginUser.getTenantId());

        List<VendorTenant> list = vendorTenantMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public VendorTenant findByCustomerId(Integer driverTypeCustomerId, LoginUser loginUser) {
        if (null == driverTypeCustomerId || null == loginUser || null == loginUser.getTenantId()) {
            return null;
        }

        VendorTenantExample example =
                new VendorTenantExample().createCriteria().andCustomerIdEqualTo(driverTypeCustomerId)
                        .andTenantIdEqualTo(loginUser.getTenantId()).example();

        List<VendorTenant> list = vendorTenantMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void doEnable(Integer vendorTenantId, LoginUser loginUser) throws BusinessException {
        if (null == vendorTenantId) {
            return;
        }

        VendorTenant vt = this.getVendorTenant(vendorTenantId);
        if (null == vt) {
            return;
        }

        VendorTenant vendorTenant = new VendorTenant();
        vendorTenant.setVendorTenantId(vendorTenantId);
        vendorTenant.setIsEnable(true);
        vendorTenantMapper.updateByPrimaryKeySelective(vendorTenant);

        // 通知运力可以更改为可用状态
        capacityPoolService.updateCapacityToAvailableByVendor(vt.getVendorId(), loginUser);
    }

    @Override
    public void doDisable(Integer vendorTenantId, LoginUser loginUser) throws BusinessException {
        if (null == vendorTenantId) {
            return;
        }

        VendorTenant vt = this.getVendorTenant(vendorTenantId);
        if (null == vt) {
            return;
        }

        VendorTenant vendorTenant = new VendorTenant();
        vendorTenant.setVendorTenantId(vendorTenantId);
        vendorTenant.setIsEnable(false);
        vendorTenantMapper.updateByPrimaryKeySelective(vendorTenant);

        // 将运力置为无效状态
        capacityPoolService.updateCapacityToValiedByVendor(vt.getVendorId(), loginUser);
    }

    @Override
    public List<VendorTenant> listByAraCode(String areaCode, Boolean isEnable, LoginUser loginUser) {
        if (StringUtils.isBlank(areaCode) || null == loginUser || null == loginUser.getTenantId()) {
            return new ArrayList<>();
        }

        VendorTenantExample example = new VendorTenantExample();
        example.createCriteria().andTenantIdEqualTo(loginUser.getTenantId())
                .andIsEnableEqualTo(isEnable)
                .andAreaCodeLike(areaCode + "%")
                .example();
        example.setOrderByClause(VendorTenant.Column.vendorTenantId.desc());
        return vendorTenantMapper.selectByExample(example);
    }

    @Override
    public void doBindCrmDriverTypeCustomer(Integer vendorTenantId, Integer customerId, LoginUser loginUser) throws BusinessException {
        if (null == vendorTenantId) {
            return;
        }

        if (null == customerId) {
            throw new BusinessException("customerIdRequired", "vendorTenant.error.customerIdRequired");
        }

        VendorTenant vendorTenant = this.findByCustomerId(customerId, loginUser);
        if (null != vendorTenant && !vendorTenantId.equals(vendorTenant.getVendorTenantId())) {
            Vendor vendor = vendorService.getVendor(vendorTenant.getVendorId());
            throw new BusinessException("customerIdHasBind", "vendorTenant.error.customerIdHasBind", vendor == null ? null : vendor.getVendorName());
        }

        VendorTenant vt = new VendorTenant();
        vt.setVendorTenantId(vendorTenantId);
        vt.setCustomerId(customerId);

        vendorTenantMapper.updateByPrimaryKeySelective(vt);
    }
}
