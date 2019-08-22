package com.juma.vms.external.service.impl;

import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.giants.common.tools.PageQueryCondition;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.juma.auth.user.domain.LoginUser;
import com.juma.server.vm.domain.dto.RenterQueryConditionDTO;
import com.juma.server.vm.domain1.bo.RenterBO;
import com.juma.server.vm.domain1.bo.VehicleBo;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.driver.domain.Driver;
import com.juma.vms.driver.domain.DriverTenant;
import com.juma.vms.driver.enumeration.RemindSwitchType;
import com.juma.vms.driver.enumeration.RemindSwitchValue;
import com.juma.vms.driver.external.DriverExternalFilter;
import com.juma.vms.driver.service.DriverService;
import com.juma.vms.driver.service.DriverTenantService;
import com.juma.vms.driver.vo.DriverExtend;
import com.juma.vms.driver.vo.DriverQuery;
import com.juma.vms.external.service.VmsService;
import com.juma.vms.tool.service.AmsCommonService;
import com.juma.vms.tool.service.AuthCommonService;
import com.juma.vms.tool.service.MdcCommonService;
import com.juma.vms.tool.service.ThirdpartyCommonService;
import com.juma.vms.transport.domain.CapacityPool;
import com.juma.vms.transport.domain.TransportCapacity;
import com.juma.vms.transport.domain.TransportCapacityItem;
import com.juma.vms.transport.enumeration.ApprovalStatus;
import com.juma.vms.transport.external.CapacityPoolExternalQuery;
import com.juma.vms.transport.request.CapacityPoolFilter;
import com.juma.vms.transport.response.TruckStatusInfo;
import com.juma.vms.transport.response.TruckStatusResp;
import com.juma.vms.transport.service.CapacityPoolService;
import com.juma.vms.transport.service.TransportSendService;
import com.juma.vms.truck.domain.Truck;
import com.juma.vms.truck.domain.TruckTenant;
import com.juma.vms.truck.enumeration.TruckStatusEnum;
import com.juma.vms.truck.external.TruckExternalFilter;
import com.juma.vms.truck.service.TruckService;
import com.juma.vms.truck.service.TruckTenantService;
import com.juma.vms.truck.vo.TruckFilter;
import com.juma.vms.truck.vo.TruckFilters;
import com.juma.vms.truck.vo.TruckQuery;
import com.juma.vms.vendor.domain.*;
import com.juma.vms.vendor.enumeration.SourceEnum;
import com.juma.vms.vendor.enumeration.VendorTypeEnum;
import com.juma.vms.vendor.external.VendorExternal;
import com.juma.vms.vendor.external.VendorExternalFilter;
import com.juma.vms.vendor.external.VendorQueryConditionDto;
import com.juma.vms.vendor.external.VendorTenantExternal;
import com.juma.vms.vendor.service.*;
import com.juma.vms.vendor.vo.VendorFilter;
import com.juma.vms.vendor.vo.VendorIdentification;
import com.juma.vms.vendor.vo.VendorQuery;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName VmsServiceImpl.java
 * @Description 对外统一接口实现类
 * @author Libin.Wei
 * @Date 2018年10月31日 下午7:20:46
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

@Service
public class VmsServiceImpl implements VmsService {

    private final Logger log = LoggerFactory.getLogger(VmsServiceImpl.class);
    @Resource
    private VendorService vendorService;
    @Resource
    private VendorTenantService vendorTenantService;
    @Resource
    private VendorTruckService vendorTruckService;
    @Resource
    private AmsCommonService amsCommonService;
    @Resource
    private AuthCommonService authCommonService;
    @Resource
    private DriverService driverService;
    @Resource
    private VendorDriverService vendorDriverService;
    @Resource
    private TruckService truckService;
    @Resource
    private TruckTenantService truckTenantService;
    @Resource
    private DriverTenantService driverTenantService;
    @Resource
    private MdcCommonService mdcCommonService;
    @Resource
    private CapacityPoolService capacityPoolService;
    @Resource
    private TransportSendService transportSendService;
    @Resource
    private ThirdpartyCommonService thirdpartyCommonService;
    @Resource
    private VendorWhiteListService vendorWhiteListService;

    @Override
    public Vendor loadByVenorId(Integer vendorId) {
        if (null == vendorId) {
            return null;
        }
        return vendorService.getVendor(vendorId);
    }

    @Override
    public Vendor loadByVenorIdTenant(Integer vendorId, Integer tenantId) {
        if (null == vendorId || null == tenantId) {
            return null;
        }

        VendorTenant vendorTenant = vendorTenantService.loadByVendorId(vendorId, new LoginUser(tenantId, 1));
        if (null == vendorTenant) {
            return null;
        }

        return vendorService.getVendor(vendorId);
    }

    @Override
    public Vendor loadVendorByPhone(String phone) {
        if (StringUtils.isBlank(phone)) {
            return null;
        }

        return vendorService.loadByPhone(phone, null);
    }

    @Override
    public Vendor loadVendorByUserId(Integer userId) {
        if (null == userId) {
            return null;
        }

        return vendorService.findByUserId(userId, false);
    }

    @Override
    public VendorExternal loadVendorByPhoneAndTenant(String phone, LoginUser loginUser) {
        if (StringUtils.isBlank(phone) || null == loginUser || null == loginUser.getTenantId()) {
            return null;
        }

        Vendor vendor = vendorService.loadByPhone(phone, null);
        if (null == vendor) {
            return null;
        }

        VendorExternal external = new VendorExternal();
        external.setVendor(vendor);
        external.setVendorTenant(vendorTenantService.loadByVendorId(vendor.getVendorId(), loginUser));
        external.setListVendorTruck(vendorTruckService.listVendorTruckBy(vendor.getVendorId(), null, loginUser));
        return external;
    }

    @Override
    public List<Vendor> loadByVendorByVehicleId(Integer vehicleId, LoginUser loginUser) {
        List<Vendor> result = new ArrayList<Vendor>();
        if (null == vehicleId || null == loginUser || null == loginUser.getTenantId()) {
            return result;
        }

        Truck truck = truckService.findByVehicleId(vehicleId);
        if (null == truck) {
            return result;
        }

        List<VendorTruck> list = vendorTruckService.listVendorTruckBy(null, truck.getTruckId(), loginUser);
        if (list.isEmpty()) {
            return result;
        }

        Set<Integer> vendorIds = new HashSet<>();
        for (VendorTruck v : list) {
            vendorIds.add(v.getVendorId());
        }

        for (Integer vendorId : vendorIds) {
            Vendor vendor = vendorService.getVendor(vendorId);
            if (null == vendor) {
                continue;
            }

            result.add(vendor);
        }
        return result;
    }

    @Override
    public Vendor loadVendorByTruckId(Integer truckId, LoginUser loginUser) {
        if (null == truckId || null == loginUser || null == loginUser.getTenantId()) {
            return null;
        }

        VendorTruck vendorTruck = vendorTruckService.loadByTruckId(truckId, loginUser);

        if (null == vendorTruck || null == vendorTruck.getVendorId()) {
            return null;
        }

        return vendorService.getVendor(vendorTruck.getVendorId());
    }

    @Override
    public List<Vendor> loadByVendorByPlateNumber(String plateNumber, LoginUser loginUser) {
        List<Vendor> result = new ArrayList<>();
        if (StringUtils.isBlank(plateNumber) || null == loginUser || null == loginUser.getTenantId()
                || StringUtils.isBlank(loginUser.getTenantCode())) {
            return result;
        }

        Truck truck = truckService.findByPlateNumber(plateNumber);
        if (null == truck) {
            return result;
        }

        Vendor vendor = this.loadVendorByTruckId(truck.getTruckId(), loginUser);
        if (null == vendor) {
            return result;
        }

        result.add(vendor);
        return result;
    }

    @Override
    public Vendor loadByVendorByIdCardNo(String idCardNo) {
        if (StringUtils.isBlank(idCardNo)) {
            return null;
        }

        return vendorService.loadByIdCardNo(idCardNo, null);
    }

    @Override
    public VendorExternal loadByVendorByIdCardNoAndTenant(String idCardNo, LoginUser loginUser) {
        if (StringUtils.isBlank(idCardNo) || null == loginUser || null == loginUser.getTenantId()) {
            return null;
        }

        Vendor vendor = vendorService.loadByIdCardNo(idCardNo, null);
        if (null == vendor) {
            return null;
        }

        VendorExternal external = new VendorExternal();
        external.setVendor(vendor);
        external.setVendorTenant(vendorTenantService.loadByVendorId(vendor.getVendorId(), loginUser));
        external.setListVendorTruck(vendorTruckService.listVendorTruckBy(vendor.getVendorId(), null, loginUser));
        return external;

    }

    @Override
    public void unbindVehicle(Integer vendorId, Integer vehicleId, String authKey, LoginUser loginUser)
            throws BusinessException {
//        if (StringUtils.isBlank(authKey)) {
//            throw new BusinessException("systemKeyRequired", "errors.systemKeyRequired");
//        }
//
//        if (null == vendorId) {
//            throw new BusinessException("vendorIdRequired", "vendorExternal.errors.vendorIdRequired");
//        }
//
//        if (null == vehicleId) {
//            throw new BusinessException("vehicleIdRequired", "vendorExternal.errors.vehicleIdRequired");
//        }
//
//        if (null == loginUser || null == loginUser.getTenantId()) {
//            throw new BusinessException("tenantIdRequired", "vendorExternal.errors.tenantIdRequired");
//        }
//
//        List<VendorVehicle> list = vendorVehicleService.listVendorVehicleBy(vendorId, vehicleId, loginUser);
//        for (VendorVehicle v : list) {
//            vendorVehicleService.delete(v.getVendorVehicleId(), loginUser);
//        }

    }

    @Override
    public void bindVehicle(List<Integer> listVehicleId, Integer vendorId, String authKey, LoginUser loginUser)
            throws BusinessException {
//        if (StringUtils.isBlank(authKey)) {
//            throw new BusinessException("systemKeyRequired", "errors.systemKeyRequired");
//        }
//
//        if (CollectionUtils.isEmpty(listVehicleId)) {
//            throw new BusinessException("listVehicleIdRequired", "vendorExternal.errors.listVehicleIdRequired");
//        }
//
//        if (null == vendorId) {
//            throw new BusinessException("vendorIdRequired", "vendorExternal.errors.vendorIdRequired");
//        }
//
//        if (null == loginUser || null == loginUser.getTenantId()) {
//            throw new BusinessException("tenantIdRequired", "vendorExternal.errors.tenantIdRequired");
//        }
//
//        vendorVehicleService.batchInsert(listVehicleId, vendorId, loginUser);

    }

    @Override
    public void bindTenant(VendorTenant vendorTenant, String authKey, LoginUser loginUser) throws BusinessException {
//        if (null == vendorTenant) {
//            throw new BusinessException("paramsError", "errors.paramsError");
//        }
//
//        if (StringUtils.isBlank(authKey)) {
//            throw new BusinessException("systemKeyRequired", "errors.systemKeyRequired");
//        }
//
//        if (null == vendorTenant.getTenantId()) {
//            throw new BusinessException("tenantIdRequired", "vendorExternal.errors.tenantIdRequired");
//        }
//
//        if (null == vendorTenant.getVendorId()) {
//            throw new BusinessException("vendorIdRequired", "vendorExternal.errors.vendorIdRequired");
//        }
//
//        if (StringUtils.isBlank(vendorTenant.getAreaCode())) {
//            throw new BusinessException("areaCodeRequired", "vendorExternal.errors.areaCodeRequired");
//        }
//
//        vendorTenant.setIsOwner((byte) 0);
//        vendorTenantService.insert(vendorTenant, loginUser);

    }

    @Override
    public VendorVehicle loadByVendorAndVehicle(Integer vendorId, Integer vehicleId, Integer tenantId)
            throws BusinessException {
        if (null == vendorId || null == vehicleId || null == tenantId) {
            return null;
        }

        LoginUser loginUser = new LoginUser();
        loginUser.setTenantId(tenantId);

        // 获取truckId
        Truck truck = truckService.findByVehicleId(vehicleId);
        if (null == truck) {
            return null;
        }

        List<VendorTruck> trucks = vendorTruckService.listVendorTruckBy(vendorId, truck.getTruckId(), loginUser);
        if (trucks.isEmpty()) {
            return null;
        }

        VendorVehicle v = new VendorVehicle();
        v.setVendorId(trucks.get(0).getVendorId());
        v.setVehicleId(vehicleId);
        v.setTenantId(tenantId);
        return v;
    }

    @Override
    public VendorVehicle loadByVendorAndPlateNumber(Integer vendorId, String plateNumber, LoginUser loginUser)
            throws BusinessException {
//        if (null == vendorId || StringUtils.isBlank(plateNumber) || null == loginUser || null == loginUser.getTenantId()
//                || StringUtils.isBlank(loginUser.getTenantCode())) {
//            return null;
//        }
//
//        VehicleBo vehicleBo = amsCommonService.findByPlateNumber(plateNumber, loginUser.getTenantId(),
//                loginUser.getTenantCode());
//        if (null != vehicleBo) {
//            return this.loadByVendorAndVehicle(vendorId, vehicleBo.getVehicleId(), loginUser.getTenantId());
//        }

        return null;
    }

    @Override
    public List<VendorQuery> listVendorByVendorNameLike(String vendorName, String areaCode, Integer backPageSize,
            LoginUser loginUser) {
        List<String> areaCodeList = new ArrayList<>();
        if (StringUtils.isNotBlank(areaCode)) {
            areaCodeList.add(areaCode);
        }

        VendorFilter filter = new VendorFilter();
        filter.setVendorName(vendorName);
        filter.setIsDelete((byte) 0);
        filter.setAreaCodeList(areaCodeList);

        return vendorService.listByVendorFilter(filter, backPageSize, loginUser);
    }

    @Override
    public List<VendorQuery> listVendorByFilter(VendorExternalFilter vendorExternalFilter, Integer backPageSize,
        LoginUser loginUser) {
        backPageSize = backPageSize == null ? 15 : (backPageSize.compareTo(100) == 1 ? 100 : backPageSize);
        VendorFilter filter = new VendorFilter();
        filter.setVendorName(vendorExternalFilter == null ? null : vendorExternalFilter.getVendorName());
        filter.setContactPhone(vendorExternalFilter == null ? null : vendorExternalFilter.getContactPhone());
        filter.setCredentialNo(vendorExternalFilter == null ? null : vendorExternalFilter.getCredentialNo());
        filter.setAreaCodeList(vendorExternalFilter == null ? null : vendorExternalFilter.getAreaCodeList());
        filter.setIsDelete((byte) 0);
        return vendorService.listByVendorFilter(filter, backPageSize, loginUser);
    }

    @Override
    public Integer addVendor(VendorExternal vendorExternal, String authKey, LoginUser loginUser)
            throws BusinessException {
        return null;
//        if (StringUtils.isBlank(authKey)) {
//            throw new BusinessException("systemKeyRequired", "errors.systemKeyRequired");
//        }
//
//        if (null == vendorExternal || null == vendorExternal.getVendor() || null == vendorExternal.getVendorTenant()) {
//            throw new BusinessException("vendorExternalRequired", "vendorExternal.errors.vendorExternalRequired");
//        }
//
//        Byte source = this.getSource(authKey);
//        if (null == source) {
//            throw new BusinessException("unkonwSource", "vendorExternal.errors.unkonwSource");
//        }
//
//        VendorBo vendorBo = new VendorBo();
//        vendorBo.setVendor(vendorExternal.getVendor());
//        vendorBo.setVendorTenant(vendorExternal.getVendorTenant());
//        Integer vendorId = vendorExternal.getVendor().getVendorId();
//
//        if (null == vendorId) {
//            vendorExternal.getVendor().setSource(this.getSource(authKey));
//            vendorId = vendorService.insert(vendorBo, loginUser);
//            this.vendorSyncUser(vendorId, loginUser);
//        } else {
//            // 判断绑定关系是否存在:不存在，绑定
//            VendorTenant vendorTenant = vendorTenantService.loadByVendorId(vendorId, loginUser);
//            if (null == vendorTenant) {
//                vendorExternal.getVendorTenant().setVendorId(vendorId);
//                vendorExternal.getVendorTenant().setIsOwner((byte) 0);
//                vendorTenantService.insert(vendorExternal.getVendorTenant(), loginUser);
//            }
//        }
//
//        if (CollectionUtils.isEmpty(vendorExternal.getListVendorVehicle())) {
//            return vendorId;
//        }
//
//        // 添加车辆信息
//        List<Integer> vehicleIds = new ArrayList<Integer>();
//        for (VendorVehicle v : vendorExternal.getListVendorVehicle()) {
//            if (null == v.getVehicleId()) {
//                continue;
//            }
//
//            vehicleIds.add(v.getVehicleId());
//        }
//
//        vendorVehicleService.batchInsert(vehicleIds, vendorId, loginUser);
//        return vendorId;
    }

    @Override
    public Page<VendorQuery> listVendorBy(PageQueryCondition<VendorQueryConditionDto> pageQueryCondition) throws BusinessException {
        if (null == pageQueryCondition) {
            throw new BusinessException("errors.paramsError", "errors.paramsError");
        }

        VendorQueryConditionDto dto = pageQueryCondition.getFilters();
        if (null == dto || null == dto.getTenantId()) {
            throw new BusinessException("tenantIdRequired", "vendorExternal.errors.tenantIdRequired");
        }

        // 页码默认第一页
        pageQueryCondition.setPageNo(pageQueryCondition.getPageNo() == null ? 1 : pageQueryCondition.getPageNo());
        // 每页返回条数默认15，最大200
        Integer pageSize = pageQueryCondition.getPageSize() == null ? 15 : pageQueryCondition.getPageSize();
        pageQueryCondition.setPageSize(NumberUtils.compare(pageSize, 200) == 1 ? 200 : pageSize);
        return vendorService.searchSimple(pageQueryCondition);
    }

    @Override
    public String vendorIdentification(VendorIdentification vendorIdentification, LoginUser loginUser) throws BusinessException {
        if (null == vendorIdentification) {
            throw new BusinessException("vendorIdentificationNotNull", "vendorExternal.errors.vendorIdentificationNotNull");
        }

        if (null == loginUser || null == loginUser.getTenantId()) {
            throw new BusinessException("tenantIdRequired", "vendorExternal.errors.tenantIdRequired");

        }

        if (null == vendorIdentification.getVendorId()) {
            throw new BusinessException("vendorIdRequired", "vendorExternal.errors.vendorIdRequired");
        }

        if (null == vendorIdentification.getVendorType()) {
            throw new BusinessException("vendorTypeRequired", "vendorExternal.errors.vendorTypeRequired");
        }

        if (StringUtils.isBlank(vendorIdentification.getVendorName())) {
            throw new BusinessException("vendorNameRequired", "vendorExternal.errors.vendorNameRequired");
        }

        if (vendorIdentification.getVendorType() == VendorTypeEnum.ENTERPRISE.getCode()) {
            if (StringUtils.isBlank(vendorIdentification.getEnterpriseCode())) {
                throw new BusinessException("enterpriseCodeRequired", "vendorExternal.errors.enterpriseCodeRequired");
            }

        } else {
            if (StringUtils.isBlank(vendorIdentification.getIdCardNo())) {
                throw new BusinessException("idCardNoRequired", "vendorExternal.errors.idCardNoRequired");
            }
        }


        if ((vendorIdentification.getVendorType() == VendorTypeEnum.PERSONAL.getCode()
                || vendorIdentification.getVendorType() == VendorTypeEnum.TRUCK_FLEET.getCode())
                && !thirdpartyCommonService.validateIdCardAndName(vendorIdentification.getVendorName(),
            vendorIdentification.getIdCardNo(), loginUser)
        ) {
            throw new BusinessException("idCardNoAndNameValidateFailed", "errors.common.prompt", "个人实名认证不通过，请填写正确的姓名和身份证号");
        } else if (vendorIdentification.getVendorType() == VendorTypeEnum.ENTERPRISE.getCode()
                && !thirdpartyCommonService.validateEnterprise(vendorIdentification.getVendorName(),
            vendorIdentification.getEnterpriseCode(), loginUser)
        ) {
            throw new BusinessException("enterpriseCodeAndNameValidateFailed", "errors.common.prompt", "企业实名认证不通过，请填写正确的企业名称和统一社会信用代码");
        }

        String jumaPin = mdcCommonService.addVendorToMdata(vendorIdentification, loginUser);
        if (StringUtils.isBlank(jumaPin)) {
            return null;
        }


        Vendor vendor = new Vendor();
        vendor.setVendorId(vendorIdentification.getVendorId());
        vendor.setVendorName(vendorIdentification.getVendorName());
        vendor.setIdCardNo(vendorIdentification.getIdCardNo());
        vendor.setEnterpriseCode(vendorIdentification.getEnterpriseCode());
        vendor.setJumaPin(jumaPin);
        vendor.setIdCardImg1(vendorIdentification.getIdCardImg1());
        vendor.setIdCardImg2(vendorIdentification.getIdCardImg2());
        vendorService.updateBase(vendor, loginUser);
        return jumaPin;
    }

    // 获取来源
    private Byte getSource(String authKey) {
        if (StringUtils.isBlank(authKey)) {
            return null;
        }

        for (SourceEnum v : SourceEnum.values()) {
            if (authKey.startsWith(v.getAnthKey())) {
                return v.getCode();
            }
        }

        return null;
    }

    // 创建承运商账号
    private Integer vendorSyncUser(@PathVariable Integer vendorId, LoginUser loginUser) {
        try {
            Integer userId = vendorService.vendor2user(vendorId, loginUser);
            return userId;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public List<VendorQuery> listByVendorFilter(VendorFilter vendorFilter, Integer pageSize, LoginUser loginUser) {
        return vendorService.listByVendorFilter(vendorFilter, pageSize, loginUser);
    }

    @Override
    public Vendor loadByDriverWithTenant(Integer driverId, LoginUser loginUser) {
        VendorDriver vendorDriver = vendorDriverService.loadByDriverId(driverId,loginUser);
        if( null == vendorDriver ){
            return null;
        }
        return vendorService.getVendor(vendorDriver.getVendorId());
    }

    @Override
    public List<VendorVehicle> listVendorVehicleBy(Integer vendorId, Integer tenantId) throws BusinessException {
        return new ArrayList<>();
//        if (null == vendorId) {
//            throw new BusinessException("vendorIdRequired", "vendorExternal.errors.vendorIdRequired");
//        }
//        if (null == tenantId) {
//            throw new BusinessException("tenantIdRequired", "vendorExternal.errors.tenantIdRequired");
//        }
//        return vendorTruckService.listVendorTruckBy(vendorId, null, new LoginUser(tenantId, 1));
    }

    @Override
    public RenterBO getByPlateNumberForFMS(String plateNo, Integer tenantId) throws BusinessException {
        if (StringUtils.isBlank(plateNo)) {
            throw new BusinessException("vendorIdRequired", "vendorExternal.errors.vendorIdRequired");
        }

        if (null == tenantId) {
            throw new BusinessException("tenantIdRequired", "vendorExternal.errors.tenantIdRequired");
        }

        LoginUser loginUser = new LoginUser(tenantId, 1);
        VehicleBo vehicleBo = amsCommonService.findByPlateNumber(plateNo, tenantId, null);
        if (null == vehicleBo) {
            return null;
        }

        Integer vehicleId = vehicleBo.getVehicleId();
        List<Vendor> list = this.loadByVendorByVehicleId(vehicleId, loginUser);
        if (list.isEmpty()) {
            return null;
        }

        Vendor vendor = list.get(0);
        RenterBO bo = new RenterBO();
        bo.setId(vendor.getVendorId());
        bo.setName(vendor.getVendorName());
        bo.setPhone(vendor.getContactPhone());
        bo.setUserId(vendor.getUserId());
        bo.setEcoUserId(authCommonService.loadEcoUserId(vendor.getUserId(), loginUser));

        VendorDriver vendorDriver = vendorDriverService.loadByVendorId(vendor.getVendorId(), loginUser);
        if (null == vendorDriver) {
            return bo;
        }

        // TODO 司机类型更改对FMS有影响
        Driver driver = driverService.loadDriverById(vendorDriver.getDriverId());
        if (null == driver) {
            return bo;
        }

        bo.setDriverType(driver.getDriverRunType().byteValue());

        return bo;
    }

    @Override
    public RenterBO getById(RenterQueryConditionDTO renterQueryConditionDTO) throws BusinessException {
        if (null == renterQueryConditionDTO) {
            throw new BusinessException("paramsError", "errors.paramsError");
        }

        if (null == renterQueryConditionDTO.getId()) {
            throw new BusinessException("vendorIdRequired", "vendorExternal.errors.vendorIdRequired");
        }

        if (null == renterQueryConditionDTO.getTenantId()) {
            throw new BusinessException("tenantIdRequired", "vendorExternal.errors.tenantIdRequired");
        }

        LoginUser loginUser = new LoginUser(renterQueryConditionDTO.getTenantId(), 1);
        VendorTenant vendorTenant = vendorTenantService.loadByVendorId(renterQueryConditionDTO.getId(), loginUser);
        if (null == vendorTenant) {
            return null;
        }

        Vendor vendor = vendorService.getVendor(renterQueryConditionDTO.getId());
        if (null == vendor) {
            return null;
        }

        RenterBO bo = new RenterBO();
        bo.setId(vendor.getVendorId());
        bo.setName(vendor.getVendorName());
        bo.setUserId(vendor.getUserId());
        return bo;
    }

    @Override
    public VendorTenantExternal loadVendorTenantByVendorId(Integer vendorId, LoginUser loginUser) {
        if (null == vendorId || null == loginUser || null == loginUser.getTenantId()) {
            return null;
        }

        VendorTenant vendorTenant = vendorTenantService.loadByVendorId(vendorId, loginUser);
        return vendorTenant == null ? null : new VendorTenantExternal(vendorTenant);
    }

    @Override
    public VendorTruck loadByVendorAndTruck(Integer vendorId, Integer truckId, Integer tenantId) throws BusinessException {
        if (null == vendorId || null == truckId || null == tenantId) {
            return null;
        }


        List<VendorTruck> list = vendorTruckService.listVendorTruckBy(vendorId, truckId, new LoginUser(tenantId, 1));
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public VendorTruck loadByVendorIdAndPlateNumber(Integer vendorId, String plateNumber, LoginUser loginUser) throws BusinessException {
        if (null == vendorId || StringUtils.isBlank(plateNumber) || null == loginUser || null == loginUser.getTenantId()) {
         return null;
        }

        Truck truck = truckService.findByPlateNumber(plateNumber);
        if (null == truck) {
            return null;
        }

        List<VendorTruck> list = vendorTruckService.listVendorTruckBy(vendorId, truck.getTruckId(), loginUser);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<VendorTruck> listVendorTruckBy(Integer vendorId, Integer tenantId) throws BusinessException {
        if (null == vendorId || null == tenantId) {
            return new ArrayList<>();
        }

        return vendorTruckService.listVendorTruckBy(vendorId, null, new LoginUser(tenantId, 1));
    }

    @Override
    public VendorTruck loadVendorTruckByTruckId(Integer truckId, LoginUser loginUser) {
        if (null == truckId || null == loginUser || null == loginUser.getTenantId()) {
            return null;
        }


        return vendorTruckService.loadByTruckId(truckId, loginUser);
    }

    @Override
    public Page<CapacityPool> searchCommonCapacity(QueryCond<CapacityPoolFilter> queryCond, LoginUser loginUser) {
        List<CapacityPool> result = new ArrayList<>();
        if (null == loginUser || null == loginUser.getTenantId()) {
            return new Page<>(queryCond.getPageNo(), queryCond.getPageSize(), 0, result);
        }

        queryCond.getFilters().setIsDelete(false);
        return capacityPoolService.search(queryCond, loginUser);
    }

    @Override
    public Page<CapacityPoolExternalQuery> searchCapacity(QueryCond<CapacityPoolFilter> queryCond, LoginUser loginUser) {
        List<CapacityPoolExternalQuery> result = new ArrayList<>();

        // 限制查询数量最大200条
        if (null != queryCond.getPageSize() && queryCond.getPageSize().compareTo(200) == 1) {
            queryCond.setPageSize(200);
        }

        Page<CapacityPool> page = this.searchCommonCapacity(queryCond, loginUser);

        for (CapacityPool p : page.getResults()) {
            CapacityPoolExternalQuery q = new CapacityPoolExternalQuery();
            BeanUtils.copyProperties(p, q);

            // 承运商信息
            Vendor vendor = vendorService.getVendor(p.getVendorId());
            if (null != vendor) {
                q.setVendorName(vendor.getVendorName());
            }

            // 车辆信息
            Truck truck = truckService.getTruck(p.getTruckId());
            if (null != truck) {
                q.setPlateNumber(truck.getPlateNumber());
                q.setFrameNo(truck.getTruckIdentificationNo());
            }

            // 司机信息
            Driver driver = driverService.loadDriverById(p.getDriverId());
            if (null != driver) {
                q.setDriverName(driver.getName());
                q.setDriverPhone(driver.getPhone());
                q.setUserId(driver.getUserId());
            }

            result.add(q);
        }

        return new Page<>(queryCond.getPageNo(), queryCond.getPageSize(), page.getTotal(), result);
    }

    @Override
    public CapacityPool loadCapacityPoolByDriverId(Integer driverId, LoginUser loginUser) {
        if (null == driverId || null == loginUser || null == loginUser.getTenantId()) {
            return null;
        }

        return capacityPoolService.loadCapacityPoolByDriverId(driverId, loginUser);
    }

    @Override
    public CapacityPool loadCapacityPoolByTruckId(Integer truckId, LoginUser loginUser) {
        if (null == truckId || null == loginUser || null == loginUser.getTenantId()) {
            return null;
        }

        return capacityPoolService.loadCapacityPoolByTruckId(truckId, loginUser);
    }

    @Override
    public Page<CapacityPool> loadCapacityPoolByPlateNumber(QueryCond<TruckFilters> truckFilters) {
        return truckService.loadCapacityPoolByPlateNumber(truckFilters);
    }

    @Override
    public Driver loadByDriverId(Integer driverId) {
        if (null == driverId) {
            return null;
        }

        return driverService.loadDriverById(driverId);
    }

    @Override
    public Driver loadDriverByPhone(String phone) {
        if (StringUtils.isBlank(phone)) {
            return null;
        }

        return driverService.loadByPhone(phone, null);
    }

    @Override
    public List<Driver> listDriverByName(String name) {
        if (StringUtils.isBlank(name)) {
            return new ArrayList<>();
        }

        return driverService.listDriverByName(name);
    }

    @Override
    public Driver loadDriverByAmsDriverId(Integer amsDriverId) {
        if (null == amsDriverId) {
            return null;
        }

        return driverService.loadDriverByAmsDriverId(amsDriverId);
    }

    @Override
    public Driver loadDriverByUserId(Integer userId) {
        if (null == userId) {
            return null;
        }

        return driverService.loadDriverByUserId(userId);
    }

    @Override
    public Driver loadDriverByUserId(Integer userId, LoginUser loginUser) {
        if (null == userId || null == loginUser || null == loginUser.getTenantId()) {
            return null;
        }

        Driver driver = driverService.loadDriverByUserId(userId);
        if (null == driver) {
            return null;
        }

        DriverTenant driverTenant = driverTenantService.loadByDriverId(driver.getDriverId(), loginUser);
        if (null == driverTenant) {
            return null;
        }

        return driver;
    }

    @Override
    public void updateDriverIsAcceptAllocateOrder(Integer driverId, Integer isAcceptAllocateOrder, LoginUser loginUser) {
        if (null == driverId || null == isAcceptAllocateOrder) {
            return;
        }

        driverService.updateIsReceiveWaybill(driverId, (isAcceptAllocateOrder == 0 ? false : true), loginUser);
    }

    @Override
    public List<Driver> listDriverBy(DriverExternalFilter driverExternalFilter, Integer callbackPageSize, LoginUser loginUser) {
        List<Driver> result = new ArrayList<>();
        if (null == loginUser || null == loginUser.getTenantId()) {
            return result;
        }

        callbackPageSize = callbackPageSize == null ? 15 : (callbackPageSize.compareTo(200) == 1 ? 200 : callbackPageSize);

        DriverQuery query = new DriverQuery();
        if (null != driverExternalFilter) {
            query.setName(driverExternalFilter.getName());
            query.setPhone(driverExternalFilter.getPhone());
        }

        List<DriverQuery> list = driverService.listByDriver(query, callbackPageSize, loginUser);
        for (DriverQuery d : list) {
            Driver driver = new Driver();
            BeanUtils.copyProperties(d, driver);
            result.add(driver);
        }
        return result;
    }

    @Override
    public List<DriverExtend> listDriverByFilter(DriverExternalFilter driverExternalFilter, Integer callbackPageSize, LoginUser loginUser) {
        List<DriverExtend> result = new ArrayList<>();
        if (null == loginUser || null == loginUser.getTenantId()) {
            return result;
        }

        Map<Integer,Truck> truckMap = Maps.newConcurrentMap();
        List<Integer> baseTruckIds = Lists.newArrayList();
        if( StringUtils.isNotBlank(driverExternalFilter.getTruckIdentificationNo()) ){
            TruckFilter filter = new TruckFilter();
            filter.setTruckIdentificationNo(driverExternalFilter.getTruckIdentificationNo());
            List<Truck> trucks = truckService.findByFilter(filter,loginUser);
            // 有车架号参数, 没有对应的车辆, 则直接返回空列表
            if( CollectionUtils.isEmpty(trucks) ){ return result; }
            for (Truck truck : trucks){
                truckMap.put(truck.getTruckId(),truck);
                baseTruckIds.add(truck.getTruckId());
            }
        }

        CapacityPoolFilter poolFilter = new CapacityPoolFilter();
        if(!CollectionUtils.isEmpty(baseTruckIds)){
            poolFilter.setTruckId(baseTruckIds.get(0));
        }
        List<CapacityPool> pools = capacityPoolService.loadCapacityPoolByFilter(poolFilter,loginUser);
        Map<Integer,Integer> driverTruckMap = Maps.newConcurrentMap();
        List<Integer> driverIds = Lists.newArrayList();
        for (CapacityPool pool : pools){
            driverIds.add(pool.getDriverId());
            driverTruckMap.put(pool.getDriverId(),pool.getTruckId());
        }

        driverExternalFilter.setDriverIds(driverIds);
        List<Driver> drivers = driverService.listDriverByFilter(driverExternalFilter,loginUser);
        if( CollectionUtils.isEmpty(driverIds) ){ return result; }

        // 未传车架号的情况
        if(StringUtils.isBlank(driverExternalFilter.getTruckIdentificationNo())){
            List<Integer> newDriverIds = Lists.newArrayList();
            for (Driver driver : drivers){
                newDriverIds.add(driver.getDriverId());
            }
            List<Integer> truckIds = Lists.newArrayList();
            for (CapacityPool pool : pools) {
                if( !newDriverIds.contains(pool.getDriverId()) ){
                    continue;
                }
                truckIds.add(pool.getTruckId());
            }
            TruckFilter filter = new TruckFilter();
            filter.setTruckIds(truckIds);
            filter.setTruckIdentificationNo(driverExternalFilter.getTruckIdentificationNo());
            List<Truck> trucks = truckService.findByFilter(filter,loginUser);
            for (Truck truck : trucks){
                truckMap.put(truck.getTruckId(),truck);
            }
        }

        for (Driver driver : drivers) {
            DriverExtend driverExtend = new DriverExtend();
            driverExtend.setDriver(driver);
            driverExtend.setTenentId(loginUser.getTenantId());
            Integer truckId = driverTruckMap.get(driver.getDriverId());
            if( null != truckId ){
                Truck truck = truckMap.get(truckId);
                if( null != truck ){
                    driverExtend.setTruckId(truckId);
                    driverExtend.setPlateNumber(truck.getPlateNumber());
                    driverExtend.setTruckIdentificationNo(truck.getTruckIdentificationNo());
                }
            }
            result.add(driverExtend);
        }
        return result;
    }

    @Override
    public void updateRemindSwitch(Integer driverId, RemindSwitchValue remindSwitchValue, RemindSwitchType remindSwitchType, LoginUser loginUser) {
        if (null == driverId || null == remindSwitchValue || null == remindSwitchType) {
            return;
        }

        driverService.updateRemindSwitch(driverId, remindSwitchValue, remindSwitchType, loginUser);
    }

    @Override
    public List<Driver> listDriverBy(List<String> areaCodeList, Integer driverRunType, Integer callbackPageSize, LoginUser loginUser) {
        List<Driver> result = new ArrayList<>();
        if (null == loginUser || null == loginUser.getTenantId()) {
            return result;
        }

        List<DriverQuery> list = driverService.listDriverBy(areaCodeList, driverRunType, callbackPageSize, loginUser);

        for (DriverQuery q : list) {
            Driver driver = new Driver();
            BeanUtils.copyProperties(driver, q);
            result.add(driver);
        }

        return result;
    }

    @Override
    public Driver loadDriverByPlateNumber(String plateNumber, LoginUser loginUser) {
        if (StringUtils.isBlank(plateNumber)) {
            return null;
        }

        Truck truck = truckService.findByPlateNumber(plateNumber);
        if (null == truck) {
            return null;
        }

        return this.loadDriverByTruckId(truck.getTruckId(), loginUser);
    }

    @Override
    public Driver loadDriverByTruckId(Integer truckId, LoginUser loginUser) {
        if (null == truckId) {
            return null;
        }

        CapacityPool capacityPool = capacityPoolService.loadCapacityPoolByTruckId(truckId, loginUser);
        if (null == capacityPool) {
            return null;
        }

        return driverService.loadDriverById(capacityPool.getDriverId());
    }

    @Override
    public List<Driver> listEffectiveCapacityDriver(CapacityPoolFilter capacityPoolFilter, LoginUser loginUser) {
        if (null == capacityPoolFilter || null == loginUser || null == loginUser.getTenantId()) {
            return new ArrayList<>();
        }
        return driverService.listEffectiveCapacityDriver(capacityPoolFilter, loginUser);
    }

    @Override
    public List<Driver> listAllDriverByVendorId(Integer vendorId) {
        if (null == vendorId) {
            return new ArrayList<>();
        }

        Set<Driver> rows = new HashSet<>();
        List<VendorDriver> vendorDrivers = vendorDriverService.listAllDriverByVendorId(vendorId);
        for (VendorDriver vd : vendorDrivers) {
            rows.add(driverService.loadDriverById(vd.getDriverId()));
        }

        return new ArrayList<>(rows);
    }

    @Override
    public List<DriverQuery> listByDriver(DriverQuery driverQuery, Integer pageSize, LoginUser loginUser) {
        return driverService.listByDriver(driverQuery, pageSize, loginUser);
    }

    @Override
    public Truck loadByTruckId(Integer truckId) {
        if (null == truckId) {
            return null;
        }

        return truckService.getTruck(truckId);
    }

    @Override
    public Truck loadTruckByVehicleId(Integer vehicleId) {
        if (null == vehicleId) {
            return null;
        }

        return truckService.findByVehicleId(vehicleId);
    }

    @Override
    public Truck loadTruckByPlateNumber(String plateNumber) {
        if (StringUtils.isBlank(plateNumber)) {
            return null;
        }

        return truckService.findByPlateNumber(plateNumber);
    }

    @Override
    public Truck loadTruckByPlateNumberAndTenant(String plateNumber, LoginUser loginUser) {
        Truck truck = this.loadTruckByPlateNumber(plateNumber);
        if (null == truck) {
            return null;
        }

        TruckTenant truckTenant = truckTenantService.getByTruckId(truck.getTruckId(), loginUser);
        if (null == truckTenant) {
            return null;
        }

        return truck;
    }

    @Override
    public Truck loadTruckBytruckIdentificationNo(String truckIdentificationNo) {
        if (StringUtils.isBlank(truckIdentificationNo)) {
            return null;
        }

        return truckService.loadTruckBytruckIdentificationNo(truckIdentificationNo);
    }

    @Override
    public List<Truck> listTruckByStatus(List<Integer> statusList,LoginUser loginUser) {
        List<Truck> result = new ArrayList<>();
        if (CollectionUtils.isEmpty(statusList)) {
            return result;
        }


        for (Integer status : statusList) {
            result.addAll(truckService.listTruckByStatus(status,loginUser));
        }

        return result;
    }

    @Override
    public Truck loadTruckByDriverId(Integer driverId, LoginUser loginUser) {
        if (null == driverId) {
            return null;
        }

        CapacityPool capacityPool = capacityPoolService.loadCapacityPoolByDriverId(driverId, loginUser);
        if (null == capacityPool) {
            return null;
        }

        return truckService.getTruck(capacityPool.getTruckId());
    }

    @Override
    public List<Truck> listTruckBy(TruckExternalFilter truckExternalFilter, Integer callbackPageSize, LoginUser loginUser) {
        List<Truck> result = new ArrayList<>();
        callbackPageSize = (callbackPageSize == null || callbackPageSize <= 0) ? 15 : (callbackPageSize.compareTo(200) == 1 ? 200 : callbackPageSize);
        QueryCond<TruckQuery> queryCond = new QueryCond<>();
        TruckQuery filter = new TruckQuery();
        filter.setPlateNumber(truckExternalFilter.getPlateNumber());
        filter.setTruckIdentificationNo(truckExternalFilter.getTruckIdentificationNo());
        queryCond.setFilters(filter);
        queryCond.setPageSize(callbackPageSize);
        List<TruckQuery> list = truckService.listTruckBy(queryCond, loginUser);
        for (TruckQuery q : list) {
            Truck truck = new Truck();
            BeanUtils.copyProperties(q, truck);
            result.add(truck);
        }

        return result;
    }

    @Override
    public List<TruckQuery> listByPlateNumber(TruckQuery truckQuery, Integer pageSize, LoginUser loginUser) {
        return truckService.listByPlateNumber(truckQuery, pageSize, loginUser);
    }

    @Override
    public TruckStatusResp loadStatusByTruckIdentificationNo(String truckIdentificationNo) {
        TruckStatusResp resp = new TruckStatusResp();
        resp.setCanReturn(true);
        List<TruckStatusInfo> truckStatusInfos = Lists.newArrayList();
        List<TransportCapacityItem> items = transportSendService.getCapacityItemByTruckIdentificationNo(truckIdentificationNo);
        if( !CollectionUtils.isEmpty(items) ){
            for (TransportCapacityItem item : items) {
                if( !CollectionUtils.isEmpty(truckStatusInfos) ){ break; } // 只要添加了一条,就终止循环
                TransportCapacity capacity = transportSendService.getCapacityById(item.getTransportId());
                if(ApprovalStatus.APPROVAL_SUBMIT.getCode().equals(capacity.getApprovalStatus())){ //审批中
                    TruckStatusInfo truckStatusInfo = new TruckStatusInfo();
                    truckStatusInfo.setPlateNumber(item.getPlateNumber());
                    truckStatusInfo.setTruckIdentificationNo(item.getTruckIdentificationNo());
                    truckStatusInfo.setTenantId(capacity.getTenantId());
                    truckStatusInfo.setStatusDesc("车辆处于输送审批中");
                    truckStatusInfos.add(truckStatusInfo);
                }
            }
        }

        if( !CollectionUtils.isEmpty(truckStatusInfos) ){
            TruckStatusInfo truckStatusInfo = truckStatusInfos.get(0);
            resp.setPlateNumber(truckStatusInfo.getPlateNumber());
            resp.setTruckIdentificationNo(truckStatusInfo.getTruckIdentificationNo());
            resp.setTruckRunType(truckStatusInfo.getTruckRunType());
            resp.setCanReturn(false);
            resp.setDesc("车辆在租户的运力输送中，不可退车。请先撤回运力输送单后再进行当前操作。");
            return resp;
        }

        Truck truck = truckService.loadTruckBytruckIdentificationNo(truckIdentificationNo);
        if( null == truck ){
            resp.setDesc("车辆在运力系统中不存在,可退车");
            return resp;
        }
        List<TruckTenant> truckTenants = truckTenantService.getByTruckId(truck.getTruckId());

        // 只要有一个租户,存在车辆状态为待接收;则不能退车
        for (TruckTenant truckTenant : truckTenants) {
            if( !CollectionUtils.isEmpty(truckStatusInfos) ){ break; } // 只要添加了一条,就终止循环
            if( TruckStatusEnum.WAIT_RECEIVE.getCode().equals(truckTenant.getStatus())
                    || TruckStatusEnum.ENABLE.getCode().equals(truckTenant.getStatus())){
                TruckStatusInfo truckStatusInfo = new TruckStatusInfo();
                truckStatusInfo.setTenantId(truckTenant.getTenantId());
                truckStatusInfo.setStatusDesc(TruckStatusEnum.getDescByCode(truckTenant.getStatus()));
                truckStatusInfos.add(truckStatusInfo);
            }
        }

        if( !CollectionUtils.isEmpty(truckStatusInfos) ){
            resp.setPlateNumber(truck.getPlateNumber());
            resp.setTruckIdentificationNo(truck.getTruckIdentificationNo());
            resp.setTruckRunType(truck.getTruckRunType());
            resp.setCanReturn(false);
            resp.setDesc("车辆在租户的运力池中，不可退车。请先从对应租户中完成运力退回后再进行当前操作。");
            return resp;
        }

        resp.setDesc("车辆在运力系统,不是有效运力,并且未处于输送审批中,可退车");
        return resp;
    }

    @Override
    public TruckTenant loadTruckTenantByTruckId(Integer truckId, LoginUser loginUser) {
        if (null == truckId || null == loginUser || null == loginUser.getTenantId()) {
            return null;
        }

        return truckTenantService.getByTruckId(truckId, loginUser);
    }

    @Override
    public Driver loadByDriverId(Integer driverId, LoginUser loginUser) {
        DriverTenant driverTenant = driverTenantService.loadByDriverId(driverId, loginUser);
        if(driverTenant == null || driverTenant.getDriverId() == null) { return null; }
        return driverService.loadDriverById(driverTenant.getDriverId());
    }

    @Override
    public List<Driver> listDriverBy(Integer tenantId, String areaCode) {
        return driverService.listDriverBy(tenantId, areaCode);
    }

    @Override
    public DriverTenant loadDriverTenantByDriverId(Integer driverId, LoginUser loginUser) {
        if (null == driverId || null == loginUser || null == loginUser.getTenantId()) {
            return null;
        }

        return driverTenantService.loadByDriverId(driverId, loginUser);
    }

    @Override
    public List<DriverTenant> listDriverTenantByDriverId(Integer driverId) {
        if (null == driverId) {
            return new ArrayList<>();
        }

        return driverTenantService.listDriverTenantByDriverId(driverId);
    }

    @Override
    public VendorWhiteList loadVendorWhiteListByVedorId(Integer vendorId) {
        if (null == vendorId) {
            return null;
        }

        return vendorWhiteListService.loadVendorWhiteListByVendorId(vendorId);
    }
}
