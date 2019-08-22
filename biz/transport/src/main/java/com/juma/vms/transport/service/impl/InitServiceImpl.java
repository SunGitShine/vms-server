package com.juma.vms.transport.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.juma.auth.user.domain.LoginUser;
import com.juma.scm.product.bo.PropertyValueBO;
import com.juma.scm.storage.service.GoodsService;
import com.juma.scm.storage.vo.GoodsVO;
import com.juma.server.vm.common.ExternalTypeEnum;
import com.juma.server.vm.common.LicenseImgTypeEnum;
import com.juma.server.vm.domain.DrivingLicense;
import com.juma.server.vm.domain.LicenseImg;
import com.juma.server.vm.domain.TenantVehicleRelation;
import com.juma.server.vm.domain.bo.DriverDetailBo;
import com.juma.server.vm.domain.dto.DriverQueryConditionDTO;
import com.juma.server.vm.domain1.VehicleExtend;
import com.juma.server.vm.domain1.vo.DriverTenantVO;
import com.juma.server.vm.service.vehicle.AmsServiceV2;
import com.juma.server.vm.service.vehicle.DrivingLicenseService;
import com.juma.server.vm.service.vehicle.TenantVehicleRelationService;
import com.juma.server.vm.service.vehicle.VehicleExtendService;
import com.juma.vms.driver.domain.Driver;
import com.juma.vms.driver.domain.DriverTenant;
import com.juma.vms.driver.service.DriverService;
import com.juma.vms.driver.service.DriverTenantService;
import com.juma.vms.transport.dao.CapacityPoolMapper;
import com.juma.vms.transport.domain.CapacityPool;
import com.juma.vms.transport.domain.CapacityPoolExample;
import com.juma.vms.transport.service.CapacityPoolService;
import com.juma.vms.transport.service.InitService;
import com.juma.vms.truck.domain.Truck;
import com.juma.vms.truck.domain.TruckTenant;
import com.juma.vms.truck.enumeration.TruckStatusEnum;
import com.juma.vms.truck.service.TruckService;
import com.juma.vms.truck.service.TruckTenantService;
import com.juma.vms.truck.vo.TruckTenantQuery;
import com.juma.vms.vendor.domain.VendorDriver;
import com.juma.vms.vendor.domain.VendorTruck;
import com.juma.vms.vendor.service.VendorDriverService;
import com.juma.vms.vendor.service.VendorTruckService;

@Service
public class InitServiceImpl implements InitService {

    private static final Logger log = LoggerFactory.getLogger(InitServiceImpl.class);

    @Resource
    private AmsServiceV2 amsServiceV2;

    @Resource
    private VehicleExtendService vehicleExtendService;

    @Resource
    private DrivingLicenseService drivingLicenseService;

    @Resource
    private DriverService driverService;

    @Resource
    private TruckService truckService;

    @Resource
    private GoodsService goodsService;

    @Resource
    private TruckTenantService truckTenantService;

    @Resource
    private DriverTenantService driverTenantService;

    @Resource
    private VendorTruckService vendorTruckService;

    @Resource
    private VendorDriverService vendorDriverService;

    @Resource
    private CapacityPoolService capacityPoolService;

    @Resource
    private TenantVehicleRelationService tenantVehicleRelationService;

    @Resource
    private CapacityPoolMapper capacityPoolMapper;

    @Override
    public void initDriver() {
        buildDriver();
    }

    @Override
    public void initTruck() {
        buildTruck();
    }

    private void buildTruck() {
        log.info("[InitService] buildTruck.");
        List<TruckTenant> truckTenants = new ArrayList<TruckTenant>();
        List<Truck> trucks = new ArrayList<Truck>();
        List<Truck> rows = truckService.all();
        for (Truck truckQ : rows) {
            Truck truck = new Truck();
            truck.setTruckId(truckQ.getTruckId());
            if (truckQ.getVehicleId() == null) continue;

            /*
             * DeviceBindBo v = amsServiceV2.getBoByVehicleId(truckQ.getVehicleId()); if (v == null || v.getVehicleBo() == null) continue; VehicleExtend extend =
             * v.getVehicleBo().getVehicleExtend(); VehicleBo vehicleBo = v.getVehicleBo();
             */

            VehicleExtend extend = vehicleExtendService.getByVehicleId(truckQ.getVehicleId());

            if (extend == null || extend.getIsExternal() == null) continue;

            if (ExternalTypeEnum.EXTERNAL.getCode().equals(extend.getIsExternal())) {
                List<DrivingLicense> drivingLicenses = drivingLicenseService.getByVehicleId(truckQ.getVehicleId());
                if (drivingLicenses != null && !drivingLicenses.isEmpty()) {
                    truck.setLicenseType(drivingLicenses.get(0).getPlateNumberType() != null
                            ? drivingLicenses.get(0).getPlateNumberType().intValue() : null);
                }

                truck.setTruckRunType(3);// 外请

                truck.setGoCityLicenseType(
                        extend.getGoCityLicenseType() == null ? null : extend.getGoCityLicenseType().intValue());
                truck.setEnergyType(extend.getEnergyType() == null ? null : extend.getEnergyType().intValue());
                truck.setEnergyOutType(
                        extend.getEmissionStandard() == null ? null : extend.getEmissionStandard().intValue());
            } else {
                // 自营 、 加盟
                if (extend.getBusinessType() != null) {
                    if (extend.getBusinessType().intValue() == 1 || extend.getBusinessType().intValue() == 2) {
                        truck.setTruckRunType(extend.getBusinessType().intValue());
                    }
                }
                // 车辆牌照、能耗、排放类型
                if (StringUtils.isNotBlank(extend.getVehicleFrameNo())) {
                    GoodsVO goodsVO = goodsService.getDetailByCode(extend.getVehicleFrameNo());
                    if (goodsVO != null) {
                        Map<String, PropertyValueBO> property = goodsVO.getProperty();
                        if (null != property.get("pzlx31")
                                && NumberUtils.isDigits(property.get("pzlx31").getPropertyValueId())) {// 牌照
                            truck.setLicenseType(Integer.parseInt(property.get("pzlx31").getPropertyValueId()));
                        }
                        if (null != property.get("energyType")
                                && NumberUtils.isDigits(property.get("energyType").getPropertyValueId())) {// 能耗类型
                            truck.setEnergyType(Integer.parseInt(property.get("energyType").getPropertyValueId()));
                        }
                        if (null != property.get("emissionStandard")
                                && NumberUtils.isDigits(property.get("emissionStandard").getPropertyValueId())) {// 排放
                            truck.setEnergyOutType(
                                    Integer.parseInt(property.get("emissionStandard").getPropertyValueId()));
                        }
                    }
                }
            }

            truck.setTruckIdentificationNo(extend.getVehicleFrameNo());

            // 车辆图片
            String[] truckImgArr = getTruckImg(truckQ.getVehicleId(), LicenseImgTypeEnum.VEHICLE_BODY_IMG);
            truck.setTruckBodyImg(truckImgArr[0]);
            // 行驶证图片
            String[] licenseImgArr = getTruckImg(truckQ.getVehicleId(), LicenseImgTypeEnum.VEHICLE_LICENSE);
            truck.setLicenseCertificateImg1(licenseImgArr[0]);
            truck.setLicenseCertificateImg2(licenseImgArr[1]);
            // 运营证图片
            String[] permitImgArr = getTruckImg(truckQ.getVehicleId(), LicenseImgTypeEnum.TRANSPORT_LICENSE_ONE);
            truck.setPermitLicenseImg1(permitImgArr[0]);
            truck.setPermitLicenseImg2(permitImgArr[1]);

            trucks.add(truck);

            if (trucks.size() == 500) {
                log.info("[InitService] trucks update : {}.");
                truckService.batchUpdate(trucks);
                trucks.clear();
            }
        }
        if (!trucks.isEmpty()) {
            log.info("[InitService] trucks update 2: {}.");
            truckService.batchUpdate(trucks);
            trucks.clear();
        }

        rows.clear();
        // 车归属租户
        rows = truckService.all();
        for (Truck truckQ : rows) {
            if (truckQ.getVehicleId() == null) continue;
            List<TenantVehicleRelation> tenantVehicleRelations = tenantVehicleRelationService
                    .getTenantVehicleRelation(truckQ.getVehicleId());
            for (TenantVehicleRelation tvr : tenantVehicleRelations) {
                LoginUser loginUser = new LoginUser();
                loginUser.setTenantId(tvr.getTenantId());
                TruckTenant tt = truckTenantService.getByTruckId(truckQ.getTruckId(), loginUser);
                if (tt != null) continue;
                TruckTenant truckTenant = new TruckTenant();
                truckTenant.setTenantId(tvr.getTenantId());
                truckTenant.setTruckId(truckQ.getTruckId());
                truckTenant.setAreaCode(tvr.getAreaCode());
                truckTenant.setCreateTime(new Date());
                int owner = tvr.getIsAssetOwner() != null ? tvr.getIsAssetOwner().intValue() : 0;
                truckTenant.setIsOwner(owner == 1 ? true : false);
                truckTenant.setIsReceivable(true);
                truckTenant.setStatus(0);
                truckTenants.add(truckTenant);
                if (truckTenants.size() == 500) {
                    log.info("[InitService] truckTenants update : {}.");
                    truckTenantService.batchInsert(truckTenants);
                    truckTenants.clear();
                }
            }
        }
        if (!truckTenants.isEmpty()) {
            log.info("[InitService] truckTenants update 2: {}.");
            truckTenantService.batchInsert(truckTenants);
            truckTenants.clear();
        }

    }

    private String[] getTruckImg(Integer vehicleId, LicenseImgTypeEnum imgTypeEnum) {
        String[] reSlutImgArr = new String[2];
        try {
            LicenseImg licenseImg = amsServiceV2.getLicenseImgByVehicleIdAndType(vehicleId, imgTypeEnum);
            if (licenseImg == null || StringUtils.isBlank(licenseImg.getImg())) {
                return reSlutImgArr;
            }
            String[] imgArr = licenseImg.getImg().split(",");
            if (imgArr.length == 0) {
                return reSlutImgArr;
            }
            for (int i = 0; i < imgArr.length; i++) {
                reSlutImgArr[i] = imgArr[i];
                if (i == 1) {
                    break;
                }
            }
        } catch (Exception e) {

        }

        return reSlutImgArr;
    }

    private void buildDriver() {
        log.info("[InitService] buildDriver.");
        List<DriverTenant> driverTenants = new ArrayList<DriverTenant>();
        List<Driver> drivers = new ArrayList<Driver>();
        List<Driver> rows = driverService.all();
        for (Driver driverQ : rows) {
            Driver driver = new Driver();
            if (driverQ.getAmsDriverId() == null) continue;
            DriverDetailBo d = amsServiceV2.getDriverDetailBoById(driverQ.getAmsDriverId());
            if (d == null || d.getDriver() == null) continue;
            driver.setDriverId(driverQ.getDriverId());
            driver.setAmsDriverId(d.getDriver().getId());

            driver.setCanDriveType(d.getDriver().getCanDriveType());
            driver.setSex(d.getDriver().getSex());
            driver.setIdCardNo(d.getDriver().getIdCardNo());
            driver.setEmergencyContactPhone(d.getDriver().getEmergencyContactPhone());

            if (d.getDriverExt() != null) {
                driver.setIcon(d.getDriverExt().getIcon());
                driver.setIdCardImg1(d.getDriverExt().getTakeIdCardImg());
                driver.setDriveLicenseImg1(d.getDriverExt().getDriveLicenseImg());
                driver.setDriveLicenseFirstTakeTime(d.getDriverExt().getDriveLicenseFirstTakeTime());
                driver.setDriveLicenseStartTime(d.getDriverExt().getDriveLicenseStartTime());
                driver.setDriveLicenseEndTime(d.getDriverExt().getDriveLicenseEndTime());
            }
            drivers.add(driver);
            if (drivers.size() == 500) {
                log.info("[InitService] drivers update : {}.");
                driverService.batchUpdate(drivers);
                drivers.clear();
            }
        }
        if (!drivers.isEmpty()) {
            log.info("[InitService] drivers update 2: {}.");
            driverService.batchUpdate(drivers);
            drivers.clear();
        }

        // 司机归属租户
        rows.clear();
        rows = driverService.all();
        for (Driver driverQ : rows) {
            if (driverQ.getAmsDriverId() == null) continue;

            List<DriverTenantVO> driverTenantVOs = amsServiceV2.getTenantListByDriverId(driverQ.getAmsDriverId());
            for (DriverTenantVO vo : driverTenantVOs) {
                DriverTenant dt = new DriverTenant();
                dt.setTenantId(vo.getTenantId());
                dt.setDriverId(driverQ.getDriverId());
                dt.setAreaCode(vo.getAreaCode());
                dt.setCreateTime(new Date());
                dt.setCreateUserId(1);

                LoginUser loginUser = new LoginUser();
                loginUser.setTenantId(vo.getTenantId());
                DriverTenant dtt = driverTenantService.loadByDriverId(driverQ.getDriverId(), loginUser);
                if (dtt != null) continue;

                com.juma.server.vm.domain.Driver d = amsServiceV2.getDriverById(vo.getDriverId());
                if (d != null && d.getStatus() != null) {
                    dt.setStatus(d.getStatus().intValue() == 1 ? 0 : 1);
                }

                DriverQueryConditionDTO driverQueryConditionDTO = new DriverQueryConditionDTO();
                driverQueryConditionDTO.setTenantId(vo.getTenantId());
                driverQueryConditionDTO.setDriverId(vo.getDriverId());
                DriverDetailBo driverDetailBo = amsServiceV2.getDriverDetailBoById(driverQueryConditionDTO);
                if (driverDetailBo != null && driverDetailBo.getIsAssetOwner() != null) {
                    dt.setIsOwner(driverDetailBo.getIsAssetOwner().intValue() == 0 ? false : true);
                }

                driverTenants.add(dt);
                if (driverTenants.size() == 500) {
                    log.info("[InitService] driverTenants update : {}.");
                    driverTenantService.batchInsert(driverTenants);
                    driverTenants.clear();
                }
            }
        }
        if (!driverTenants.isEmpty()) {
            log.info("[InitService] drivers update 2: {}.");
            driverTenantService.batchInsert(driverTenants);
            driverTenants.clear();
        }
    }

    @Override
    public void initPool() {
        // 司机归属承运商，看他绑定的车是哪个承运商
        // 运力池的初始化 有效
        driverToVendor();
    }

    private void driverToVendor() {
        log.info("[InitService] driverToVendor.");
        List<CapacityPool> pools = new ArrayList<CapacityPool>();
        List<VendorDriver> rows = new ArrayList<VendorDriver>();
        List<Driver> drivers = driverService.all();
        for (Driver driver : drivers) {
            if (driver.getAmsDriverId() == null) continue;
            // 确认司机绑定的哪个车
            com.juma.server.vm.domain.Driver amsDriver = amsServiceV2.getDriverById(driver.getAmsDriverId());
            if (amsDriver == null || amsDriver.getVehicleId() == null) continue;
            // 确认关联的truck id
            Truck truck = truckService.findByVehicleId(amsDriver.getVehicleId());
            if (truck == null || truck.getTruckId() == null) continue;
            // 确认车归属哪个承运商 司机归属哪个承运商关联的车就归属哪个承运商
            List<VendorTruck> vendorTrucks = vendorTruckService.listVendorTruck(truck.getTruckId());
            for (VendorTruck vt : vendorTrucks) {
                VendorDriver vd = new VendorDriver();
                vd.setDriverId(driver.getDriverId());
                vd.setVendorId(vt.getVendorId());
                vd.setTenantId(vt.getTenantId());
                vd.setCreateTime(vt.getCreateTime());
                vd.setCreateUserId(vt.getCreateUserId());

                LoginUser loginUser = new LoginUser();
                loginUser.setTenantId(vt.getTenantId());
                List<VendorDriver> r = vendorDriverService.loadVendorDriverBy(vt.getVendorId(), driver.getDriverId(),
                        loginUser);
                if (r.size() != 0) continue;

                rows.add(vd);
                if (rows.size() == 500) {
                    log.info("[InitService] VendorDriver update : {}.");
                    vendorDriverService.batchInsert(rows);
                    rows.clear();
                }
                // 确认车归属租户
                TruckTenant truckTenant = truckTenantService.getByTruckId(vt.getTruckId(), loginUser);
                if (truckTenant == null) {
                    continue;
                }

                CapacityPool pool = new CapacityPool();
                pool.setTenantId(vt.getTenantId());
                pool.setVendorId(vt.getVendorId());
                pool.setAreaCode(truckTenant.getAreaCode());
                pool.setTruckId(truck.getTruckId());
                pool.setDriverId(driver.getDriverId());
                pool.setVehicleBoxType(truck.getVehicleBoxType());
                pool.setVehicleBoxLength(truck.getVehicleBoxLength());
                pool.setVehicleRunType(truck.getTruckRunType());
                pool.setGoCityLicenseType(truck.getGoCityLicenseType());
                pool.setCreateTime(vt.getCreateTime());
                pool.setCreateUserId(vt.getCreateUserId());
                pool.setIsDelete(false);
                
                //车的状态
                if(TruckStatusEnum.ENABLE.getCode().equals(truckTenant.getStatus())) {
                    pool.setStatus(true);
                } else {
                    pool.setStatus(false);
                }
                //退车状态
                if(TruckStatusEnum.CAR_BACK.getCode().equals(truckTenant.getStatus())) {
                    pool.setIsDelete(true);
                }

                pools.add(pool);
                if (pools.size() == 500) {
                    log.info("[InitService] pools update : {}.");
                    capacityPoolService.batchInsert(pools);
                    pools.clear();
                }
            }
        }
        if (!rows.isEmpty()) {
            log.info("[InitService] VendorDriver update 2: {}.");
            vendorDriverService.batchInsert(rows);
            rows.clear();
        }

        // 无效运力池初始

        List<TruckTenant> trucks = truckTenantService.listByQuery(new TruckTenantQuery(), null);
        for (TruckTenant truck : trucks) {

            List<CapacityPool> _pools = capacityPoolMapper
                    .selectByExample(new CapacityPoolExample().createCriteria().andTenantIdEqualTo(truck.getTenantId())
                            .andTruckIdEqualTo(truck.getTruckId()).andIsDeleteEqualTo(false).example());

            if (_pools.isEmpty()) {
                CapacityPool pool = new CapacityPool();
                pool.setTenantId(truck.getTenantId());
                pool.setAreaCode(truck.getAreaCode());
                pool.setTruckId(truck.getTruckId());

                Truck _truck = truckService.getTruck(truck.getTruckId());
                if (_truck == null) {
                    continue;
                }
                pool.setVehicleBoxLength(_truck.getVehicleBoxLength());
                pool.setVehicleRunType(_truck.getTruckRunType());
                pool.setGoCityLicenseType(_truck.getGoCityLicenseType());
                pool.setCreateTime(_truck.getCreateTime());
                pool.setCreateUserId(_truck.getCreateUserId());
                pool.setIsDelete(false);
                pool.setStatus(false);

                pools.add(pool);
                if (pools.size() == 500) {
                    log.info("[InitService] pools update 3: {}.");
                    capacityPoolService.batchInsert(pools);
                    pools.clear();
                }
            }
        }

        if (!pools.isEmpty()) {
            log.info("[InitService] pools update 4: {}.");
            capacityPoolService.batchInsert(pools);
            pools.clear();
        }
    }
    
    public static void main(String[] args) {
        List<String> strs = new ArrayList();
        strs.add("a");
        strs.add(null);
        for (String string : strs) {
            System.out.println(string);
        }
        String a = null;
        System.out.println(a!=null && a.equals("b"));
        System.out.println("b".equals(a));
    }
    
}
