package com.juma.vms.vendor.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.juma.vms.driver.domain.DriverTenant;
import com.juma.vms.driver.service.DriverTenantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.driver.domain.Driver;
import com.juma.vms.driver.service.DriverService;
import com.juma.vms.vendor.dao.VendorDriverMapper;
import com.juma.vms.vendor.domain.VendorDriver;
import com.juma.vms.vendor.domain.VendorDriverExample;
import com.juma.vms.vendor.service.VendorDriverService;
import com.juma.vms.vendor.vo.VendorDriverQuery;

@Service
public class VendorDriverServiceImpl implements VendorDriverService {

    @Autowired
    private VendorDriverMapper vendorDriverMapper;
    @Resource
    private DriverService driverService;
    @Resource
    private DriverTenantService driverTenantService;

    @Override
    public void insert(VendorDriver vendorDriver, LoginUser loginUser) throws BusinessException {
        List<VendorDriver> vendorDrivers = loadVendorDriverBy(vendorDriver.getVendorId(), vendorDriver.getDriverId(), loginUser);
        if(vendorDrivers == null || vendorDrivers.isEmpty()){
            vendorDriver.setTenantId(loginUser.getTenantId());
            vendorDriver.setTenantCode(loginUser.getTenantCode());
            vendorDriver.setCreateUserId(loginUser.getUserId());
            vendorDriver.setCreateTime(new Date());
            vendorDriverMapper.insert(vendorDriver);
        }
    }

    @Override
    public void delete(Integer vendorDriverId) throws BusinessException {
        vendorDriverMapper.deleteByPrimaryKey(vendorDriverId);
    }

    @Override
    public VendorDriver loadByVendorId(Integer vendorId, LoginUser loginUser) {
        if (null == vendorId || null == loginUser || null == loginUser.getTenantId()) {
            return null;
        }

        VendorDriverExample example = new VendorDriverExample();
        example.createCriteria().andVendorIdEqualTo(vendorId).andTenantIdEqualTo(loginUser.getTenantId()).example();

        List<VendorDriver> list = vendorDriverMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<VendorDriver> loadVendorDriverBy(Integer vendorId, Integer driverId, LoginUser loginUser) {
        if (null == vendorId || null == driverId
            ||null == loginUser || null == loginUser.getTenantId()) {
            return null;
        }

        VendorDriverExample example = new VendorDriverExample();
        example.createCriteria().andVendorIdEqualTo(vendorId).andTenantIdEqualTo(loginUser.getTenantId())
            .andDriverIdEqualTo(driverId).example();

        return vendorDriverMapper.selectByExample(example);
    }

    @Override
    public Page<VendorDriverQuery> search(QueryCond<VendorDriver> queryCond, LoginUser loginUser) {
        List<VendorDriverQuery> result = new ArrayList<>();
        VendorDriver filters = queryCond.getFilters();
        if (null == filters || null == filters.getVendorId() || null == loginUser || null == loginUser.getTenantId()) {
            return new Page<>(queryCond.getPageNo(), queryCond.getPageSize(),0, result);
        }

        VendorDriverExample example = new VendorDriverExample();
        example.createCriteria().andTenantIdEqualTo(loginUser.getTenantId())
                .andVendorIdEqualTo(filters.getVendorId())
                .example();

        example.setStartOffSet(queryCond.getStartOffset());
        example.setSize(queryCond.getPageSize());
        example.setOrderByClause(VendorDriver.Column.vendorDriverId.desc());

        long total = vendorDriverMapper.countByExample(example);
        List<VendorDriver> rows = vendorDriverMapper.selectByExample(example);
        for (VendorDriver d : rows) {
            VendorDriverQuery q = new VendorDriverQuery(d);
            BeanUtils.copyProperties(d, q);
            q.setCreateTime(d.getCreateTime());

            // 司机信息
            Driver driver = driverService.loadDriverById(d.getDriverId());
            if (null != driver) {
                q.setDriverName(driver.getName());
                q.setDriverPhone(driver.getPhone());
            }

            DriverTenant driverTenant = driverTenantService.loadByDriverId(d.getDriverId(), loginUser);
            q.setDriverStatus(driverTenant == null ? null : driverTenant.getStatus());
            result.add(q);
        }

        return new Page<VendorDriverQuery>(queryCond.getPageNo(), queryCond.getPageSize(), Integer.parseInt(String.valueOf(total)), result);
    }

    @Override
    public VendorDriver loadByDriverId(Integer driverId, LoginUser loginUser) {
        if (null == driverId || null == loginUser || null == loginUser.getTenantId()) {
            return null;
        }

        List<VendorDriver> list = vendorDriverMapper.selectByExample(new VendorDriverExample().createCriteria()
                .andDriverIdEqualTo(driverId).andTenantIdEqualTo(loginUser.getTenantId()).example());

        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void update(VendorDriver vendorDriver, LoginUser loginUser) throws BusinessException {
        if (null == vendorDriver || null == loginUser) {
            throw new BusinessException("paramsError", "errors.paramsError");
        }
        VendorDriver oldVendorDriver = vendorDriverMapper.selectByPrimaryKey(vendorDriver.getVendorDriverId());
        if(null == oldVendorDriver){
            return;
        }
        vendorDriver.setLastUpdateUserId(loginUser.getUserId());
        vendorDriver.setLastUpdateTime(new Date());
        vendorDriverMapper.updateByPrimaryKeySelective(vendorDriver);
    }

    @Override
    public void batchInsert(List<VendorDriver> rows) {
        vendorDriverMapper.insertBatch(rows);
    }

    @Override
    public List<VendorDriver> listAllDriverByVendorId(Integer vendorId) {
        if (null == vendorId) {
            return new ArrayList<>();
        }

        return vendorDriverMapper
            .selectByExample(new VendorDriverExample().createCriteria().andVendorIdEqualTo(vendorId).example());
    }
}
