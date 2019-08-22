package com.juma.vms.driver.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.juma.vms.driver.enumeration.DriverStatusEnum;
import org.springframework.stereotype.Service;

import com.giants.common.exception.BusinessException;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.driver.dao.DriverTenantMapper;
import com.juma.vms.driver.domain.DriverTenant;
import com.juma.vms.driver.domain.DriverTenantExample;
import com.juma.vms.driver.service.DriverTenantService;

@Service
public class DriverTenantServiceImpl implements DriverTenantService {

    @Resource
    private DriverTenantMapper driverTenantMapper;

    @Override
    public DriverTenant getDriverTenant(Integer driverTenantId) throws BusinessException {
        if (null == driverTenantId) {
            return null;
        }
        return driverTenantMapper.selectByPrimaryKey(driverTenantId);
    }

    @Override
    public void insert(DriverTenant driverTenant, LoginUser loginUser) throws BusinessException {
        driverTenant.setStatus(DriverStatusEnum.WORK.getCode());
        driverTenant.setCreateUserId(loginUser.getUserId());
        driverTenant.setCreateTime(new Date());
        driverTenantMapper.insert(driverTenant);
    }

    @Override
    public void update(DriverTenant driverTenant, LoginUser loginUser) throws BusinessException {
        driverTenant.setLastUpdateUserId(loginUser.getUserId());
        driverTenant.setLastUpdateTime(new Date());
        driverTenantMapper.updateByPrimaryKeySelective(driverTenant);
    }

    @Override
    public DriverTenant loadByDriverId(Integer driverId, LoginUser loginUser) {
        if (null == driverId || null == loginUser || null == loginUser.getTenantId()) {
            return null;
        }
        List<DriverTenant> list = driverTenantMapper.selectByExample(new DriverTenantExample().createCriteria()
                .andDriverIdEqualTo(driverId).andTenantIdEqualTo(loginUser.getTenantId()).example());

        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public DriverTenant loadByDriverIdAnsOwner(Integer driverId, Boolean isOwner) {
        if (null == driverId || null == isOwner) {
            return null;
        }
        List<DriverTenant> list = driverTenantMapper.selectByExample(new DriverTenantExample().createCriteria()
                .andDriverIdEqualTo(driverId).andIsOwnerEqualTo(isOwner).example());

        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void batchInsert(List<DriverTenant> rows) {
        driverTenantMapper.insertBatch(rows);
        
    }

    @Override
    public List<DriverTenant> listDriverTenantByDriverId(Integer driverId) {
        return driverTenantMapper.selectByExample(new DriverTenantExample()
                .createCriteria().andDriverIdEqualTo(driverId)
                .andStatusEqualTo(DriverStatusEnum.WORK.getCode())
                .example());
    }
}
