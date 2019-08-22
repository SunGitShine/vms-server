package com.juma.vms.vendor.service.impl;

import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.giants.common.tools.PageCondition;
import com.juma.auth.user.domain.LoginUser;
import com.juma.scm.product.domain.Brand;
import com.juma.scm.product.service.BrandService;
import com.juma.server.vm.domain1.bo.VehicleBo;
import com.juma.vms.tool.service.AmsCommonService;
import com.juma.vms.tool.service.ScmCommonService;
import com.juma.vms.vendor.dao.ext.VendorExtMapper;
import com.juma.vms.vendor.dao.VendorVehicleMapper;
import com.juma.vms.vendor.domain.VendorTenant;
import com.juma.vms.vendor.domain.VendorVehicle;
import com.juma.vms.vendor.domain.VendorVehicleExample;
import com.juma.vms.vendor.domain.VendorVehicleExample.Criteria;
import com.juma.vms.vendor.service.VendorVehicleService;
import com.juma.vms.vendor.vo.VendorVehicleQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName VendorVehicleServiceImpl.java
 * @Description 承运商车辆管理
 * @author Libin.Wei
 * @Date 2018年10月30日 下午8:04:01
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

@Service
public class VendorVehicleServiceImpl implements VendorVehicleService {

    @Resource
    private VendorVehicleMapper vendorVehicleMapper;
    @Resource
    private VendorExtMapper vendorExtMapper;
    @Resource
    private AmsCommonService amsCommonService;
    @Resource
    private ScmCommonService scmCommonService;
    @Resource
    private BrandService brandService;

    @Override
    public Page<VendorVehicleQuery> search(PageCondition pageCondition, LoginUser loginUser) {
        List<VendorVehicleQuery> result = new ArrayList<VendorVehicleQuery>();
        if (null == loginUser || null == loginUser.getTenantId()) {
            return new Page<VendorVehicleQuery>(pageCondition.getStartOffSet(), pageCondition.getPageSize(), 0, result);
        }

        Map<String, Object> filters = pageCondition.getFilters();
        if (null == filters) {
            return new Page<VendorVehicleQuery>(pageCondition.getStartOffSet(), pageCondition.getPageSize(), 0, result);
        }

        if (null == filters.get("vendorId") || !StringUtils.isNumeric(filters.get("vendorId").toString())) {
            return new Page<VendorVehicleQuery>(pageCondition.getStartOffSet(), pageCondition.getPageSize(), 0, result);
        }

        VendorVehicleExample example = this.buildExample(pageCondition, loginUser);
        int total = vendorVehicleMapper.countByExample(example);
        List<VendorVehicle> rows = vendorVehicleMapper.selectByExample(example);
        for (VendorVehicle v : rows) {
            result.add(this.buildVendorVehicleQuery(v, loginUser));
        }

        return new Page<VendorVehicleQuery>(pageCondition.getStartOffSet(), pageCondition.getPageSize(), total, result);
    }

    // 组装查询条件
    private VendorVehicleExample buildExample(PageCondition pageCondition, LoginUser loginUser) {
        VendorVehicleExample example = new VendorVehicleExample();
        Map<String, Object> filters = pageCondition.getFilters();
        Criteria criteria = example.createCriteria();
        criteria.andVendorIdEqualTo(Integer.valueOf(filters.get("vendorId").toString()));
        criteria.andTenantIdEqualTo(loginUser.getTenantId());
        if (null != filters.get("vehicleId") && StringUtils.isNumeric(filters.get("vehicleId").toString())) {
            criteria.andVehicleIdEqualTo(Integer.valueOf(filters.get("vehicleId").toString()));
        }

        example.setStartOffSet(pageCondition.getStartOffSet());
        example.setSize(pageCondition.getEndOffSet());
        example.setOrderByClause(" create_time desc ");

        return example;
    }

    // 组装VendorVehicleQuery
    private VendorVehicleQuery buildVendorVehicleQuery(VendorVehicle vendorVehicle, LoginUser loginUser) {
        VendorVehicleQuery query = new VendorVehicleQuery();
        query.setVendorVehicle(vendorVehicle);
        try {
            VehicleBo vehicleBo = amsCommonService.findByVehicleId(vendorVehicle.getVehicleId(),
                    loginUser.getTenantId(), loginUser.getTenantCode());
            if (null == vehicleBo || null == vehicleBo.getVehicleExtend()) {
                return query;
            }
            query.setPlateNumber(vehicleBo.getVehicleExtend().getPlateNumber());
            query.setFrameNo(vehicleBo.getVehicleFrameNo());
            if (null != vehicleBo.getVehicleExtend().getBrandId()) {
                Brand brand = brandService.get(vehicleBo.getVehicleExtend().getBrandId());
                query.setBrand(brand == null ? null : brand.getName());
            }
            if (null != vehicleBo.getVehicleExtend().getVehicleBoxType()) {
                query.setVehicleBoxTypeName(scmCommonService
                        .findVehicleBoxTypeName(vehicleBo.getVehicleExtend().getVehicleBoxType().intValue()));
            }

            if (null != vehicleBo.getVehicleExtend().getBoxLevel()) {
                query.setVehicleBoxLengthName(scmCommonService
                        .findVehicleBoxLengthName(vehicleBo.getVehicleExtend().getBoxLevel().intValue()));
            }
        } catch (Exception e) {
        }

        return query;
    }

    @Override
    public VendorVehicle getVendorVehicle(Integer vendorVehicleId) throws BusinessException {
        if (null == vendorVehicleId) {
            return null;
        }

        return vendorVehicleMapper.selectByPrimaryKey(vendorVehicleId);
    }

    @Override
    public List<VendorVehicle> listVendorVehicleBy(Integer vendorId, Integer vehicleId, LoginUser loginUser)
            throws BusinessException {
        return new ArrayList<>();
//        if (null == loginUser || null == loginUser.getTenantId()) {
//            return new ArrayList<VendorVehicle>();
//        }
//
//        VendorVehicleExample example = new VendorVehicleExample();
//        Criteria criteria = example.createCriteria();
//        criteria.andTenantIdEqualTo(loginUser.getTenantId());
//        if (null != vendorId) {
//            criteria.andVendorIdEqualTo(vendorId);
//        }
//        if (null != vehicleId) {
//            criteria.andVehicleIdEqualTo(vehicleId);
//        }
//        return vendorVehicleMapper.selectByExample(example);
    }

    @Override
    public void insert(VendorVehicle vendorVehicle, LoginUser loginUser) throws BusinessException {
        if (null == vendorVehicle.getVendorId()) {
            return;
        }
        this.check(vendorVehicle, loginUser);
        vendorVehicle.setTenantId(
                vendorVehicle.getTenantId() == null ? loginUser.getTenantId() : vendorVehicle.getTenantId());
        vendorVehicle.setCreateUserId(loginUser.getUserId());
        vendorVehicle.setCreateTime(new Date());
        vendorVehicleMapper.insert(vendorVehicle);
    }

    // 校验
    private void check(VendorVehicle vendorVehicle, LoginUser loginUser) {
        if (null == vendorVehicle) {
            throw new BusinessException("paramsError", "errors.paramsError");
        }

        if (null == vendorVehicle.getVehicleId()) {
            throw new BusinessException("vehicleRequired", "vendorVehicle.error.vehicleRequired");
        }

        if (null == vendorVehicle.getTenantId() && (null == loginUser || null == loginUser.getTenantId())) {
            throw new BusinessException("tenantRequired", "vendorVehicle.error.tenantRequired");
        }

        List<VendorVehicle> list = this.listVendorVehicleBy(null, vendorVehicle.getVehicleId(), loginUser);
        if (!list.isEmpty()) {
            throw new BusinessException("theTenantVehicleExist", "vendorVehicle.error.theTenantVehicleExist");
        }
    }

    @Override
    public void batchInsert(List<Integer> listVehicleId, Integer vendorId, LoginUser loginUser)
            throws BusinessException {
        if (listVehicleId.isEmpty() || null == vendorId) {
            return;
        }

        for (Integer vehicleId : listVehicleId) {
            VendorVehicle vendorVehicle = new VendorVehicle();
            vendorVehicle.setVendorId(vendorId);
            vendorVehicle.setVehicleId(vehicleId);
            vendorVehicle.setTenantId(loginUser.getTenantId());
            vendorVehicle.setCreateUserId(loginUser.getUserId());
            vendorVehicle.setCreateTime(new Date());
            this.insert(vendorVehicle, loginUser);
        }
    }

    @Override
    public void delete(Integer vendorVehicleId, LoginUser loginUser) throws BusinessException {
        if (null == vendorVehicleId) {
            return;
        }

        vendorVehicleMapper.deleteByPrimaryKey(vendorVehicleId);
    }

    @Override
    public List<VendorVehicle> listVendorVehicleBy(Integer vendorId, String areaCode, Integer tenantId) {
        if (null == vendorId || null == tenantId) {
            return null;
        }
        VendorTenant vendorTenant = new VendorTenant();
        vendorTenant.setAreaCode(areaCode);
        vendorTenant.setTenantId(tenantId);
        vendorTenant.setVendorId(vendorId);
        return vendorExtMapper.listVendorVehicleBy(vendorTenant);
    }
}
