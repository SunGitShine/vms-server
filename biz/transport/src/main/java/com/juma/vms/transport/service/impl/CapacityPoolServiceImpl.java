package com.juma.vms.transport.service.impl;

import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.google.common.collect.Lists;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.driver.domain.Driver;
import com.juma.vms.driver.domain.DriverTenant;
import com.juma.vms.driver.enumeration.DriverStatusEnum;
import com.juma.vms.driver.service.DriverService;
import com.juma.vms.driver.service.DriverTenantService;
import com.juma.vms.tool.service.BusinessAreaCommonService;
import com.juma.vms.tool.service.ScmCommonService;
import com.juma.vms.transport.dao.CapacityPoolMapper;
import com.juma.vms.transport.domain.CapacityPool;
import com.juma.vms.transport.domain.CapacityPoolExample;
import com.juma.vms.transport.request.CapacityPoolFilter;
import com.juma.vms.transport.response.CapacityPoolQuery;
import com.juma.vms.transport.service.CapacityPoolService;
import com.juma.vms.truck.domain.Truck;
import com.juma.vms.truck.domain.TruckTenant;
import com.juma.vms.truck.enumeration.TruckStatusEnum;
import com.juma.vms.truck.service.TruckService;
import com.juma.vms.truck.service.TruckTenantService;
import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.domain.VendorTenant;
import com.juma.vms.vendor.service.VendorService;
import com.juma.vms.vendor.service.VendorTenantService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CapacityPoolServiceImpl implements CapacityPoolService {

    @Resource
    private CapacityPoolMapper capacityPoolMapper;
    @Resource
    private TruckService truckService;
    @Resource
    private ScmCommonService scmCommonService;
    @Resource
    private DriverService driverService;
    @Resource
    private BusinessAreaCommonService businessAreaCommonService;
    @Resource
    private TruckTenantService truckTenantService;
    @Resource
    private DriverTenantService driverTenantService;
    @Resource
    private VendorService vendorService;
    @Resource
    private VendorTenantService vendorTenantService;

    @Override
    public Page<CapacityPoolQuery> searchByVendor(QueryCond<CapacityPoolFilter> queryCond, LoginUser loginUser) {
        List<CapacityPoolQuery> result = new ArrayList<>();
        CapacityPool filters = queryCond.getFilters();
        if (null == filters || null == filters.getVendorId()) {
            return new Page<>(queryCond.getPageNo(), queryCond.getPageSize(), 0, result);
        }

        filters.setIsDelete(false);

        // 厢型map
        Map<String, String> mapBoxType = scmCommonService.mapBoxType();
        // 厢长map
        Map<String, String> mapBoxLength = scmCommonService.mapBoxLength();

        Page<CapacityPool> page = this.search(queryCond, loginUser);

        for (CapacityPool p : page.getResults()) {
            CapacityPoolQuery q = new CapacityPoolQuery();
            BeanUtils.copyProperties(p, q);

            // 车辆信息
            Truck truck = truckService.getTruck(p.getTruckId());
            if (null != truck) {
                q.setPlateNumber(truck.getPlateNumber());
                q.setFrameNo(truck.getTruckIdentificationNo());

                String boxType = mapBoxType.get(truck.getVehicleBoxType() + "");
                String boxLength = mapBoxLength.get(truck.getVehicleBoxLength() + "");
                q.setTruckTypeName((StringUtils.isBlank(boxType) ? "" : boxType) + (StringUtils.isBlank(boxLength) ? "" : boxLength));
                q.setTruckRunType(truck.getTruckRunType());
            }

            // 司机信息
            Driver driver = driverService.loadDriverById(p.getDriverId());
            if (null != driver) {
                q.setDriverName(driver.getName());
                q.setDriverPhone(driver.getPhone());
            }

            // 业务区域名称
            q.setAreaName(businessAreaCommonService.loadLogicAndSelfAreaName(p.getAreaCode(), loginUser));
            result.add(q);
        }

        return new Page<>(queryCond.getPageNo(), queryCond.getPageSize(), page.getTotal(), result);
    }

    @Override
    public Page<CapacityPool> search(QueryCond<CapacityPoolFilter> queryCond, LoginUser loginUser) {
        if (null == loginUser || null == loginUser.getTenantId()) {
            return new Page<>(queryCond.getPageNo(), queryCond.getPageSize(), 0, new ArrayList<CapacityPool>());
        }
        CapacityPoolFilter filters = queryCond.getFilters();
        CapacityPoolExample example = new CapacityPoolExample().createCriteria()
                .andTenantIdEqualTo(loginUser.getTenantId())
                .andVendorIdEqualTo(filters.getVendorId())
                .andDriverIdEqualTo(filters.getDriverId())
                .andTruckIdEqualTo(filters.getTruckId())
                .andVehicleBoxTypeEqualTo(filters.getVehicleBoxType())
                .andVehicleBoxLengthEqualTo(filters.getVehicleBoxLength())
                .andVehicleRunTypeEqualTo(filters.getVehicleRunType())
                .andGoCityLicenseTypeEqualTo(filters.getGoCityLicenseType())
                .andStatusEqualTo(filters.getStatus())
                .andIsDeleteEqualTo(filters.getIsDelete())
                .andAreaCodeLikeList(filters.getAreaCodeList())
                .example();

        example.setStartOffSet(queryCond.getStartOffset());
        example.setSize(queryCond.getPageSize());
        example.setOrderByClause(CapacityPool.Column.capacityPoolId.desc());

        long total = capacityPoolMapper.countByExample(example);
        List<CapacityPool> rows = capacityPoolMapper.selectByExample(example);
        return new Page<>(queryCond.getPageNo(), queryCond.getPageSize(), Integer.parseInt(String.valueOf(total)), rows);
    }

    @Override
    public Integer countValidCapacity(Integer vendorId, LoginUser loginUser) {
        if (null == vendorId || null == loginUser || null == loginUser.getTenantId()) {
            return 0;
        }

        CapacityPoolExample example = new CapacityPoolExample();
        example.createCriteria().andTenantIdEqualTo(loginUser.getTenantId())
                .andVendorIdEqualTo(vendorId)
                .example();
        long count = capacityPoolMapper.countByExample(example);
        return Integer.parseInt(String.valueOf(count));
    }

    @Override
    public void update(CapacityPool pool) {
        if( null == pool.getCapacityPoolId() ){
            return;
        }
        capacityPoolMapper.updateByPrimaryKeySelective(pool);
    }

    @Override
    public CapacityPool loadCapacityPoolByDriverId(Integer driverId, LoginUser loginUser) {
        if (null == driverId || null == loginUser || null == loginUser.getTenantId()) {
            return null;
        }

        CapacityPoolExample example = new CapacityPoolExample().createCriteria()
                .andDriverIdEqualTo(driverId)
                .andTenantIdEqualTo(loginUser.getTenantId())
                .andIsDeleteEqualTo(false)
                .example();

        List<CapacityPool> list = capacityPoolMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<CapacityPool> loadCapacityPoolByFilter(CapacityPoolFilter filter, LoginUser loginUser) {
        if (null == filter || null == loginUser || null == loginUser.getTenantId()) {
            return Lists.newArrayList();
        }

        CapacityPoolExample example = new CapacityPoolExample().createCriteria()
                .andDriverIdIn(filter.getDriverIds())
                .andTenantIdEqualTo(loginUser.getTenantId())
                .andIsDeleteEqualTo(false)
                .andStatusEqualTo(true)
                .example();

        return capacityPoolMapper.selectByExample(example);
    }

    @Override
    public CapacityPool loadCapacityPoolByTruckId(Integer truckId, LoginUser loginUser) {
        if (null == truckId || null == loginUser || null == loginUser.getTenantId()) {
            return null;
        }

        CapacityPoolExample example = new CapacityPoolExample().createCriteria()
                .andTruckIdEqualTo(truckId)
                .andTenantIdEqualTo(loginUser.getTenantId())
                .andIsDeleteEqualTo(false)
                .example();

        List<CapacityPool> list = capacityPoolMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<CapacityPool> loadCapacityPoolByTruckId(Integer truckId) {
        if (null == truckId) {
            return null;
        }
        CapacityPoolExample example = new CapacityPoolExample().createCriteria()
            .andTruckIdEqualTo(truckId)
            .andIsDeleteEqualTo(false)
            .example();

        return capacityPoolMapper.selectByExample(example);
    }

    @Override
    public void updateCapacityToValiedByVendor(Integer vendorId, LoginUser loginUser) throws BusinessException {
        if (null == vendorId || null == loginUser || null == loginUser.getTenantId()) {
            return;
        }

        CapacityPoolExample example = new CapacityPoolExample().createCriteria()
                .andVendorIdEqualTo(vendorId)
                .andTenantIdEqualTo(loginUser.getTenantId())
                .example();

        List<CapacityPool> list = capacityPoolMapper.selectByExample(example);
        for (CapacityPool c : list) {
            c.setStatus(false);
            c.setLastUpdateUserId(loginUser.getUserId());
            c.setLastUpdateTime(new Date());
            capacityPoolMapper.updateByPrimaryKeySelective(c);
        }

    }

    @Override
    public void updateCapacityToAvailableByVendor(Integer vendorId, LoginUser loginUser) throws BusinessException {
        if (null == vendorId || null == loginUser || null == loginUser.getTenantId()) {
            return;
        }

        List<CapacityPool> list = capacityPoolMapper.selectByExample(new CapacityPoolExample().createCriteria()
                .andVendorIdEqualTo(vendorId)
                .andIsDeleteEqualTo(false)
                .andTenantIdEqualTo(loginUser.getTenantId())
                .example());

        for (CapacityPool p : list) {
            Truck truck = truckService.getTruck(p.getTruckId());
            if (null == truck) {
                continue;
            }

            TruckTenant truckTenant = truckTenantService.getByTruckId(truck.getTruckId(), loginUser);
            if (null == truckTenant || null == truckTenant.getStatus() || TruckStatusEnum.ENABLE.getCode() != truckTenant.getStatus()) {
                continue;
            }

            if (null == p.getDriverId()) {
                continue;
            }

            Driver driver = driverService.loadDriverById(p.getDriverId());
            if (null == driver) {
                continue;
            }

            DriverTenant driverTenant = driverTenantService.loadByDriverId(driver.getDriverId(), loginUser);
            if (null == driverTenant || null ==driverTenant.getStatus() || DriverStatusEnum.WORK.getCode() != driverTenant.getStatus()) {
                continue;
            }

            p.setStatus(true);
            capacityPoolMapper.updateByPrimaryKeySelective(p);
        }
    }

    @Override
    public void updateCapacityToAvailableByTruck(Integer truckId, LoginUser loginUser) throws BusinessException {

        List<CapacityPool> list = capacityPoolMapper.selectByExample(new CapacityPoolExample().createCriteria()
            .andTruckIdEqualTo(truckId)
            .andIsDeleteEqualTo(false)
            .andTenantIdEqualTo(loginUser.getTenantId())
            .example());

        for (CapacityPool p : list) {
            Vendor vendor = vendorService.getVendor(p.getVendorId());
            if (null == vendor) {
                continue;
            }

            VendorTenant vendorTenant = vendorTenantService.loadByVendorId(p.getVendorId(), new LoginUser(p.getTenantId(), null));
            if (null == vendorTenant || null == vendorTenant.getIsEnable() || !vendorTenant.getIsEnable()) {
                continue;
            }

            if (null == p.getDriverId()) {
                continue;
            }

            Driver driver = driverService.loadDriverById(p.getDriverId());
            if (null == driver) {
                continue;
            }

            DriverTenant driverTenant = driverTenantService.loadByDriverId(driver.getDriverId(), new LoginUser(p.getTenantId(), null));
            if (null == driverTenant || null == driverTenant.getStatus()
                || DriverStatusEnum.WORK.getCode() != driverTenant.getStatus()) {
                continue;
            }

            p.setStatus(true);
            capacityPoolMapper.updateByPrimaryKeySelective(p);
        }
    }

    @Override
    public void batchInsert(List<CapacityPool> rows) {
        capacityPoolMapper.insertBatch(rows);
    }
}
