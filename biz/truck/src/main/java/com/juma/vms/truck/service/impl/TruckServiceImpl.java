package com.juma.vms.truck.service.impl;

import com.alibaba.fastjson.JSON;
import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.juma.auth.employee.domain.Department;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.auth.employee.service.DepartmentService;
import com.juma.auth.tenant.domain.Tenant;
import com.juma.auth.user.domain.LoginUser;
import com.juma.server.vm.domain.Vehicle;
import com.juma.server.vm.domain.bo.TenantVehicleBo;
import com.juma.server.vm.domain1.bo.VehicleBo;
import com.juma.tgm.truck.domain.TruckType;
import com.juma.tgm.truck.service.TruckTypeService;
import com.juma.tsl.domain.bo.CustomerInfoBO;
import com.juma.vms.common.Constants;
import com.juma.vms.common.DateUtils;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.driver.domain.Driver;
import com.juma.vms.driver.domain.DriverTenant;
import com.juma.vms.driver.enumeration.DriverStatusEnum;
import com.juma.vms.driver.service.DriverService;
import com.juma.vms.driver.service.DriverTenantService;
import com.juma.vms.external.service.VmsService;
import com.juma.vms.mq.domain.TruckCompanyChangeMq;
import com.juma.vms.mq.service.MqService;
import com.juma.vms.tool.domain.BaseEnumDomian;
import com.juma.vms.tool.service.*;
import com.juma.vms.transport.domain.CapacityPool;
import com.juma.vms.transport.service.CapacityPoolService;
import com.juma.vms.transport.service.TransportService;
import com.juma.vms.transport.service.TransportTruckReturnService;
import com.juma.vms.truck.dao.TruckExtMapper;
import com.juma.vms.truck.dao.TruckMapper;
import com.juma.vms.truck.dao.TruckTenantMapper;
import com.juma.vms.truck.domain.Truck;
import com.juma.vms.truck.domain.TruckExample;
import com.juma.vms.truck.domain.TruckTenant;
import com.juma.vms.truck.domain.TruckTenantExample;
import com.juma.vms.truck.domain.bo.TruckResp;
import com.juma.vms.truck.enumeration.TruckRunTypeEnum;
import com.juma.vms.truck.enumeration.TruckStatusEnum;
import com.juma.vms.truck.service.TruckService;
import com.juma.vms.truck.service.TruckTenantService;
import com.juma.vms.truck.vo.*;
import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.domain.VendorTenant;
import com.juma.vms.vendor.domain.VendorTruck;
import com.juma.vms.vendor.enumeration.VendorTypeEnum;
import com.juma.vms.vendor.service.VendorTenantService;
import com.juma.vms.vendor.service.VendorTruckService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Title: TruckServiceImpl
 * Description:运力车辆
 * Created by gzq on 2019/3/19.
 */

@Service
public class TruckServiceImpl implements TruckService {

	private static final Logger log = LoggerFactory.getLogger(TruckServiceImpl.class);

	@Autowired
	private TruckExtMapper truckExtMapper;
	@Autowired
	private TruckMapper truckMapper;
	@Autowired
	private TruckTenantMapper truckTenantMapper;
	@Autowired
	private TruckTenantService truckTenantService;
	@Autowired
	private BusinessAreaCommonService businessAreaCommonService;
    @Autowired
    private TruckTypeService truckTypeService;
    @Autowired
    private VmsService vmsService;
    @Autowired
    private DriverService driverService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private ScmCommonService scmCommonService;
	@Autowired
	private AuthCommonService authCommonService;
	@Autowired
	private VendorTruckService vendorTruckService;
	@Autowired
	private VendorTenantService vendorTenantService;
	@Autowired
	private TransportService transportService;
	@Autowired
	private DriverTenantService driverTenantService;
	@Autowired
	private AmsCommonService amsCommonService;
	@Autowired
	private TslCommonService tslCommonService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private MqService mqService;
	@Autowired
	private TransportTruckReturnService transportTruckReturnService;
	@Autowired
	private CapacityPoolService capacityPoolService;


	@Override
    public Truck getTruck(Integer truckId) throws BusinessException {
        if (null == truckId) {
            return null;
        }
        return truckMapper.selectByPrimaryKey(truckId);
    }

    @Override
	public Integer findByPlateNumberAndIdentificationNo(String plateNumber, String identificationNo, LoginUser loginUser) {

		return truckExtMapper.findByPlateNumberAndIdentificationNo(plateNumber, identificationNo, loginUser.getTenantId());
	}

	@Override
	public void addTruck(TruckBo truckBo, LoginEmployee loginEmployee) {
        if (null == truckBo) {
            throw new BusinessException("driverBoNull", "errors.paramCanNotNullWithName", "车辆");
        }

        checkParm(truckBo, loginEmployee);
        //车架号换绑
		exchangeIdentifyNo(truckBo, loginEmployee);
        // 车牌号和车架号是否存在车辆
		Truck truckDB = findIsExistTruck(truckBo);
		if(truckDB != null){

			truckBo.setTruckId(truckDB.getTruckId());
			TruckTenant truckTenant = truckTenantService.getByTruckId(truckDB.getTruckId(), loginEmployee);
			if(truckTenant != null && null != truckTenant.getTruckBelongToCompany()) {
				throw new BusinessException("truckiSExist", "errors.common.prompt", "车辆已存在，不能重复添加");
			}
			//车辆已退车，更新认领公司和车辆状态
			if(truckTenant != null && null == truckTenant.getTruckBelongToCompany()
				&& truckTenant.getStatus().equals(TruckStatusEnum.ALREADY_CAR_BACK.getCode())) {
				truckTenant.setStatus(TruckStatusEnum.WAIT_RECEIVE.getCode());
				truckTenant.setTruckBelongToCompany(loginEmployee.getLoginDepartment().getDepartmentId());
				truckTenantService.update(truckTenant, loginEmployee);
			}
			//按使用方添加
			if(truckTenant == null){
				List<TruckTenant> truckTenants = truckTenantService.getByTruckId(truckDB.getTruckId());
				boolean isOwner = false;
				if(truckTenants == null || truckTenants.isEmpty()) {
					isOwner = true;
				}
				truckTenantService.addTruckTenant(truckBo, isOwner, loginEmployee);
			}
			//不是外请车，修改车辆运营类型（对于输送车辆）
			if(!TruckRunTypeEnum.EMPLOY.getCode().equals(truckDB.getTruckRunType())){
				Truck truck = new Truck();
				truck.setTruckId(truckDB.getTruckId());
				truck.setTruckRunType(truckBo.getTruckRunType());
				truckMapper.updateByPrimaryKeySelective(truck);
			}

		}else {
			//按创建方添加
			Truck truck = new Truck();
			BeanUtils.copyProperties(truckBo,truck);
			truck.setCreateTime(new Date());
			truck.setCreateUserId(loginEmployee.getUserId());
			truckMapper.insertSelective(truck);
			truckBo.setTruckId(truck.getTruckId());
			truckTenantService.addTruckTenant(truckBo, true, loginEmployee);
		}

	}

    @Override
    public void update(TruckBo truckBo, LoginEmployee loginUser) throws BusinessException {
        if (null == truckBo) {
            throw new BusinessException("driverBoNull", "errors.paramCanNotNullWithName", "车辆");
        }

        if (null == truckBo.getTruckId()) {
            throw new BusinessException("driverNull", "errors.paramCanNotNullWithName", "车辆id");
        }

        if (StringUtils.isBlank(truckBo.getAreaCode())) {
            throw new BusinessException("areaCodeNull", "errors.paramCanNotNullWithName", "业务区域");
        }

		checkParm(truckBo, loginUser);
		//车架号换绑
		exchangeIdentifyNo(truckBo, loginUser);
		// 车架号和车牌号唯一
		checkTruckUnique(truckBo);

        //当车辆类型为【外请】时，查询AMS对应信息
		checkAmsData(truckBo);

		// 判断是不是归属方更改
        TruckTenant historyTruckTenant = truckTenantService.getByTruckId(truckBo.getTruckId(), loginUser);
        if (null == historyTruckTenant) {
            // 若查询不到，则建立绑定关系
            TruckTenant truckTenant = new TruckTenant();
            truckTenant.setTruckId(truckBo.getTruckId());
            truckTenant.setAreaCode(truckBo.getAreaCode());
            truckTenant.setIsOwner(false);
			truckTenant.setTruckBelongToCompany(loginUser.getLoginDepartment().getDepartmentId());
			truckTenant.setTruckBelongToCompanyCode(departmentService.loadDepartment(loginUser.getLoginDepartment().getDepartmentId())
			.getDepartmentCode());
			truckTenantService.insert(truckTenant,loginUser);
            return;
        }

        // 若不是归属方，则只更改绑定关系
        if (!historyTruckTenant.getIsOwner()) {
            historyTruckTenant.setAreaCode(truckBo.getAreaCode());
            truckTenantService.update(historyTruckTenant,loginUser);

            //同步运力池（业务区域）
            List<CapacityPool> capacityPools = getCapacityPools(truckBo, loginUser);
            for(CapacityPool c: capacityPools){
                c.setAreaCode(truckBo.getAreaCode());
                transportService.updateCapacityPool(c,loginUser);
            }
            return;
        }

        // 归属方
        Truck truck = new Truck();
        BeanUtils.copyProperties(truckBo,truck);
        //TruckTypeId转化为厢型、厢长
        TruckType truckType = truckTypeService.getTruckType(truckBo.getTruckTypeId());
        truck.setVehicleBoxType(truckType == null ? null : truckType.getVehicleBoxType());
        truck.setVehicleBoxLength(truckType == null ? null : truckType.getTruckLengthId());
        truck.setLastUpdateUserId(loginUser.getUserId());
        truck.setLastUpdateTime(new Date());
        truckMapper.updateByPrimaryKey(truck);
		mqService.sendAfterTruckUpdate(truck,"更新车辆归属方+车长箱长");
        historyTruckTenant.setAreaCode(truckBo.getAreaCode());
        truckTenantService.update(historyTruckTenant,loginUser);

		//同步运力池
        List<CapacityPool> capacityPools = getCapacityPools(truckBo, loginUser);
        for(CapacityPool c: capacityPools){
			c.setVehicleBoxType(truckType == null ? null : truckType.getVehicleBoxType());
			c.setVehicleBoxLength(truckType == null ? null : truckType.getTruckLengthId());
			c.setGoCityLicenseType(truckBo.getGoCityLicenseType());
			c.setAreaCode(truckBo.getAreaCode());
			transportService.updateCapacityPool(c,loginUser);
		}
    }

    private void exchangeIdentifyNo(TruckBo truckBo, LoginEmployee loginEmployee){
		Truck existTruck = this.loadTruckBytruckIdentificationNo(truckBo.getTruckIdentificationNo());
		if(existTruck != null && StringUtils.isNotBlank(existTruck.getPlateNumber())
			&& !existTruck.getTruckId().equals(truckBo.getTruckId())
			&& !existTruck.getPlateNumber().equals(truckBo.getPlateNumber())){
			//解除车架号和老车牌号的绑定关系
			Truck updateTruck = new Truck();
			updateTruck.setTruckId(existTruck.getTruckId());
			updateTruck.setTruckIdentificationNo("");
			updateTruck.setLastUpdateTime(new Date());
			truckMapper.updateByPrimaryKeySelective(updateTruck);

			//更新老牌照车辆状态为不可用
			List<TruckTenant> truckTenants = truckTenantService.getByTruckId(existTruck.getTruckId());
			for(TruckTenant truckTenant : truckTenants){
				if(truckTenant.getStatus().equals(TruckStatusEnum.ENABLE.getCode())){
					truckTenant.setStatus(TruckStatusEnum.DISABLED.getCode());
					truckTenantService.update(truckTenant, loginEmployee);
				}
			}

			//更新老车辆id运力池状态为无效
			List<CapacityPool> capacityPools = capacityPoolService.loadCapacityPoolByTruckId(existTruck.getTruckId());
			for(CapacityPool capacityPool : capacityPools){
				capacityPool.setStatus(false);
				capacityPoolService.update(capacityPool);
			}
		}

		//修改车辆时执行
		//车辆经过换绑车架号，老车无车架号的情况
		if(truckBo.getTruckId() != null){
			Truck truck = truckMapper.selectByPrimaryKey(truckBo.getTruckId());
			if(StringUtils.isBlank(truck.getTruckIdentificationNo())){
				//更新老牌照车辆状态为不可用
				List<TruckTenant> truckTenants = truckTenantService.getByTruckId(truck.getTruckId());
				for(TruckTenant truckTenant : truckTenants){
					if(truckTenant.getStatus().equals(TruckStatusEnum.DISABLED.getCode())){
						truckTenant.setStatus(TruckStatusEnum.ENABLE.getCode());
						truckTenantService.update(truckTenant, loginEmployee);
					}
				}

				capacityPoolService.updateCapacityToAvailableByTruck(truck.getTruckId(), new LoginUser(null,null));
			}
		}
	}

    private List<CapacityPool> getCapacityPools(TruckBo truckBo, LoginEmployee loginUser) {
        CapacityPool capacityPool = new CapacityPool();
        capacityPool.setTruckId(truckBo.getTruckId());
        capacityPool.setTenantId(loginUser.getTenantId());
        capacityPool.setIsDelete(false);
        return transportService.findByCapacityPool(capacityPool);
    }

    @Override
    public void updateTruck(Truck truck){
        truck.setLastUpdateTime(new Date());
        truckMapper.updateByPrimaryKey(truck);
    }

	private void checkAmsData(TruckBo truckBo) {
		if(TruckRunTypeEnum.EMPLOY.getCode().equals(truckBo.getTruckRunType())){
			Vehicle vehicle;
			List<VehicleBo> vehicles;
			try {
				vehicle = amsCommonService.getByVehicleFrameNo(truckBo.getTruckIdentificationNo());
				vehicles = amsCommonService.getVehicleListByPlateNo(Arrays.asList(truckBo.getPlateNumber()));
			}catch (Exception e) {
				if (e instanceof BusinessException) {
					throw e;
				}
				log.warn("amsServiceError->findByPlateNumberOrVehicleFrameNo:{}", e.getMessage());
				throw new BusinessException("amsServiceError", "errors.amsServiceError");
			}
			if(null != vehicle && null != vehicle.getVehicleId() && NumberUtils.BYTE_ZERO.equals(vehicle.getIsExternal())){
				throw new BusinessException("truckRunTypeNotMatch", "当前车辆信息不是外请车请重新输入");
			}
			for (VehicleBo bo:vehicles) {
				if(null != bo.getVehicleExtend() && NumberUtils.BYTE_ZERO.equals(bo.getVehicleExtend().getIsExternal())){
					throw new BusinessException("truckRunTypeNotMatch", "当前车辆信息不是外请车请重新输入");
				}
			}
		}
	}

	private void checkTruckUnique(TruckBo truckBo) {
        List<Truck> list = truckMapper.selectByExample(new TruckExample().createCriteria().
			andTruckIdentificationNoEqualTo(truckBo.getTruckIdentificationNo())
			.andPlateNumberEqualTo(truckBo.getPlateNumber()).example());
        if(CollectionUtils.isNotEmpty(list)){
			if (null == truckBo.getTruckId()) {
				throw new BusinessException("plateNumberAndIdentificationNoExist", "车辆信息已存在，请重新输入");
			}

			if (null != truckBo.getTruckId() && !truckBo.getTruckId().equals(list.get(0).getTruckId())) {
				throw new BusinessException("plateNumberAndIdentificationNoExist", "车辆信息已存在，请重新输入");
			}
		}
    }

	private Truck findIsExistTruck(TruckBo truckBo) {

        List<Truck> list = getTruckExample(truckBo);
        if(list != null && !list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

    private List<Truck> getTruckExample(TruckBo truckBo) {
        TruckExample example = new TruckExample();
        TruckExample.Criteria criteria1 = example.createCriteria();
        criteria1.andPlateNumberEqualTo(truckBo.getPlateNumber());
        TruckExample.Criteria criteria2 = example.createCriteria();
        criteria2.andTruckIdentificationNoEqualTo(truckBo.getTruckIdentificationNo());
        example.or(criteria2);
        return truckMapper.selectByExample(example);
    }

    private void checkParm(TruckBo truckBo, LoginEmployee loginEmployee) {
        if (StringUtils.isBlank(truckBo.getPlateNumber())) {
            throw new BusinessException("plateNumberNull", "errors.paramCanNotNullWithName", "车牌号");
        }

        if (StringUtils.isBlank(truckBo.getTruckIdentificationNo())) {
            throw new BusinessException("truckIdentificationNoNull", "errors.paramCanNotNullWithName", "车架号");
        }

		if (null == truckBo.getGoCityLicenseType()) {
			throw new BusinessException("goCityLicenseTypeNull", "errors.paramCanNotNullWithName", "入城证");
		}

		//加盟、自营车存在审核中的退车单时不能修改
//		if(truckBo.getTruckRunType().equals(TruckRunTypeEnum.JOIN.getCode())
//			|| truckBo.getTruckRunType().equals(TruckRunTypeEnum.OWN_SALE.getCode())){
//
//			List<TransportTruckRefund> truckRefunds = transportTruckReturnService.findDetailByTruckIdentificationNo(truckBo.getTruckIdentificationNo());
//			for(TransportTruckRefund truckRefund : truckRefunds){
//				if(truckRefund.getApprovalStatus().equals(ApprovalStatus.APPROVAL_SUBMIT.getCode())
//					|| truckRefund.getApprovalStatus().equals(ApprovalStatus.APPROVAL_REJECTED.getCode())){
//					throw new BusinessException("truckHasTruckRefund", "errors.common.prompt", "车辆存在审核中的退车单，不能修改");
//				}
//			}
//		}

    }

	@Override
	public TruckResp getTruckDetail(Integer truckId, LoginUser loginUser) throws BusinessException {

		Truck truck = this.getTruck(truckId);
		if (null == truck) {
			return null;
		}
		TruckResp truckResp = new TruckResp();
		BeanUtils.copyProperties(truck, truckResp);

		TruckTenant truckTenant = truckTenantService.getByTruckId(truckId, loginUser);
		if (null == truckTenant) {
			return truckResp;
		}
		truckResp.setStatus(truckTenant.getStatus());
		truckResp.setIsOwner(truckTenant.getIsOwner() == true ? true : false);
		truckResp.setLicenseTypeName(scmCommonService.getByPropertyValueId(truckResp.getLicenseType()));
		truckResp.setEnergyTypeName(scmCommonService.getByPropertyValueId(truckResp.getEnergyType()));
		truckResp.setEnergyOutTypeName(scmCommonService.getByPropertyValueId(truckResp.getEnergyOutType()));
		//ams取车龄
		VehicleBo vehicleBo = amsCommonService.findByPlateNumber(truckResp.getPlateNumber(), loginUser.getTenantId(), loginUser.getTenantCode());
		if(null != vehicleBo && null != vehicleBo.getVehicleExtend()){
			Date outFactoryTime = vehicleBo.getVehicleExtend().getOutFactoryTime();
			if(null != outFactoryTime){
				truckResp.setVehicleAge(DateUtils.distanceYears(DateUtils.create(outFactoryTime),DateUtils.create()));
			}
		}
		TruckType truckType = truckTypeService.findByBoxAndLength(truckResp.getVehicleBoxType(), truckResp.getVehicleBoxLength(), loginUser.getTenantId());
		truckResp.setTruckTypeId(truckType == null ? null : truckType.getTruckTypeId());
		truckResp.setTruckLoad(truckType == null ? null : truckType.getTruckTypeLoad());
		truckResp.setTruckVolume(truckType == null ? null : truckType.getTruckTypeVolume());
		truckResp.setTruckTypeName(truckTypeService.findTruckTypeNameBy(truckResp.getVehicleBoxType(), truckResp.getVehicleBoxLength()));
		Department department = departmentService.loadDepartment(truckTenant.getTruckBelongToCompany());
		truckResp.setTruckBelongToCompany(department == null ? null :department.getDepartmentId());
		truckResp.setTruckBelongToCompanyName(department == null ? "" :department.getDepartmentName());
		truckResp.setAreaCode(truckTenant.getAreaCode());
		truckResp.setAreaName(businessAreaCommonService.loadLogicAndSelfAreaName(truckTenant.getAreaCode(), loginUser));
		Tenant tenant = authCommonService.loadByTenantId(truckTenant.getTenantId());
		truckResp.setTenantName(tenant == null ? null : tenant.getTenantName());

		loadRelation(truckId, loginUser, truckResp);
		return truckResp;
	}

	private void loadRelation(Integer truckId, LoginUser loginUser, TruckResp truckResp){
		CapacityPool capacityPool = new CapacityPool();
		capacityPool.setTruckId(truckId);
		capacityPool.setTenantId(loginUser.getTenantId());
		capacityPool.setIsDelete(false);
		List<CapacityPool> capacityPools = transportService.findByCapacityPool(capacityPool);
		if(CollectionUtils.isNotEmpty(capacityPools)){
			CapacityPool cp = capacityPools.get(0);
			//关联承运商
			Vendor vendor = vmsService.loadByVenorId(cp.getVendorId());
			if(null != vendor){
				truckResp.setVendorId(vendor.getVendorId());
				truckResp.setVendorName(vendor.getVendorName());
				truckResp.setContactUserName(vendor.getContactUserName());
				truckResp.setVendorPhone(vendor.getContactPhone());
				truckResp.setVendorTypeDesc(VendorTypeEnum.getVendorTypeDesc(vendor.getVendorType()));
				VendorTenant vendorTenant = vendorTenantService.loadByVendorId(vendor.getVendorId(), loginUser);
				if(null != vendorTenant){
					truckResp.setVendorAreaName(businessAreaCommonService.loadLogicAndSelfAreaName(vendorTenant.getAreaCode(), loginUser));
					truckResp.setEnableName(null != vendorTenant.getIsEnable() ? (vendorTenant.getIsEnable() ? "启用" : "停用") : "");
				}
			}
			//关联司机
			Driver driver = driverService.loadDriverById(cp.getDriverId());
			if(null != driver){
				truckResp.setDriverId(driver.getDriverId());
				truckResp.setSex(driver.getSex());
				truckResp.setDriverIdCardNo(driver.getIdCardNo());
				truckResp.setDriverCanDriveType(authCommonService.getOptionName(Constants.CRM_DRIVERS_LICENSE_TYPE,driver.getCanDriveType().toString()));
				truckResp.setDriverName(driver.getName());
				truckResp.setDriverPhone(driver.getPhone());
				truckResp.setDriverRunType(driver.getDriverRunType());
				DriverTenant driverTenant = driverTenantService.loadByDriverId(driver.getDriverId(), loginUser);
				if(null != driverTenant){
					truckResp.setDriverStatus(driverTenant.getStatus());
					truckResp.setDriverAreaName(businessAreaCommonService.loadLogicAndSelfAreaName(driverTenant.getAreaCode(), loginUser));
				}
			}
		}
	}

	@Override
	public Page<TruckQuery> search(QueryCond<TruckQuery> queryCond, LoginUser loginUser) throws BusinessException {
		if (null == loginUser || null == loginUser.getTenantId()) {
			return new Page<>(queryCond.getPageNo(), queryCond.getPageSize(), 0, new ArrayList<TruckQuery>());
		}
		queryCond.getFilters().setTenantId(loginUser.getTenantId());
		TruckType truckType = truckTypeService.getTruckType(queryCond.getFilters().getTruckTypeId());
		queryCond.getFilters().setVehicleBoxType(truckType == null ? null : truckType.getVehicleBoxType());
		queryCond.getFilters().setVehicleBoxLength(truckType == null ? null : truckType.getTruckLengthId());

		int total = truckExtMapper.searchCount(queryCond);
		List<TruckQuery> rows = truckExtMapper.search(queryCond);
		for (TruckQuery query : rows) {
			query.setAreaName(businessAreaCommonService.loadLogicAndSelfAreaName(query.getAreaCode(), loginUser));
            query.setTruckTypeName(truckTypeService.findTruckTypeNameBy(query.getVehicleBoxType(), query.getVehicleBoxLength()));
            Vendor vendor = vmsService.loadByVenorId(query.getVendorId());
            if(null != vendor){
                query.setVendorName(vendor.getVendorName());
                query.setVendorPhone(vendor.getContactPhone());
                if(vendor.getVendorType().equals(VendorTypeEnum.ENTERPRISE.getCode())){
					query.setVendorIdCardNo(vendor.getEnterpriseCode());
				}else {
					query.setVendorIdCardNo(vendor.getIdCardNo());
				}
				VendorTenant vendorTenant = vendorTenantService.loadByVendorId(vendor.getVendorId(), loginUser);
                query.setIsEnable(vendorTenant == null ? null : vendorTenant.getIsEnable());
			}
            Driver driver = driverService.loadDriverById(query.getDriverId());
            if(null != driver){
                query.setDriverName(driver.getName());
                query.setDriverPhone(driver.getPhone());
            }
            Department department = departmentService.loadDepartment(query.getTruckBelongToCompany());
            query.setDepartmentCode(department == null ? "" :department.getDepartmentCode());
            query.setTruckBelongToCompanyName(department == null ? "" :department.getDepartmentName());
        }

		return new Page<>(queryCond.getPageNo(), queryCond.getPageSize(), total, rows);
	}

	@Override
	public Map<String, List<BaseEnumDomian>> getProperty() throws BusinessException {
		return scmCommonService.getPropertyValueByKeys(Arrays.asList(Constants.LINCENCE_PLATE_TYPE,Constants.ENERGY_TYPE,Constants.EMISSION_STANDARD));
	}

	@Override
	public List<TruckType> getTruckType(LoginUser loginUser) throws BusinessException {
        return truckTypeService.listAllTruckTypeByOrderNoAsc(loginUser.getTenantId(), false);
	}

	@Override
	public Truck findByVehicleId(Integer vehicleId) {
		if (null == vehicleId) {
			return null;
		}

		TruckExample example = new TruckExample().createCriteria()
				.andVehicleIdEqualTo(vehicleId)
				.example();
		List<Truck> list = truckMapper.selectByExample(example);

		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public Truck findByPlateNumber(String plateNumber) {
		if (StringUtils.isBlank(plateNumber)) {
			return null;
		}

		TruckExample example = new TruckExample().createCriteria()
				.andPlateNumberEqualTo(plateNumber)
				.example();
		List<Truck> list = truckMapper.selectByExample(example);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public List<Truck> findTruckBy(Truck truck) {
		if(truck == null){
			return null;
		}
		TruckExample example = new TruckExample().createCriteria()
			.andPlateNumberEqualTo(truck.getPlateNumber()).andTruckIdentificationNoEqualTo(truck.getTruckIdentificationNo())
			.example();
		return truckMapper.selectByExample(example);
	}

	@Override
	public void updateTruckCompany(TruckBo truckBo, LoginUser loginUser) throws BusinessException{
		if (null == truckBo || null == truckBo.getTruckId() || null == truckBo.getTruckBelongToCompany()) {
			throw new BusinessException("paramsError", "errors.paramsError");
		}
		TruckTenant truckTenant = truckTenantService.getByTruckId(truckBo.getTruckId(), loginUser);
		if(null == truckTenant){
			throw new BusinessException("paramsError","车辆租户信息为空");
		}
		truckTenant.setTruckBelongToCompany(truckBo.getTruckBelongToCompany());
		truckTenantService.update(truckTenant,loginUser);
		//更换成功后向AMS发送通知
        Department department = departmentService.loadDepartment(truckBo.getTruckBelongToCompany());
        if(null != department && null != truckBo.getTruckIdentificationNo()){
            TenantVehicleBo tenantVehicleBo = new TenantVehicleBo();
			tenantVehicleBo.setVehicleFrameNo(truckBo.getTruckIdentificationNo());
			tenantVehicleBo.setDepartmentCode(department.getDepartmentCode());
            tenantVehicleBo.setTenantId(loginUser.getTenantId());
            tenantVehicleBo.setUserId(loginUser.getUserId());
            amsCommonService.changeCompany2Ams(tenantVehicleBo);
			TruckCompanyChangeMq companyChangeMq = new TruckCompanyChangeMq();
			BeanUtils.copyProperties(tenantVehicleBo, companyChangeMq);
			mqService.sendTruckCompanyChange(companyChangeMq);
            log.info("通知AMS变更认领公司{}.", JSON.toJSONString(companyChangeMq));
        }
	}

	@Override
	public void updateVendor(TruckBo truckBo, LoginUser loginUser) throws BusinessException{
		if (null == truckBo || null == truckBo.getTruckId() || null == truckBo.getVendorId()){
			throw new BusinessException("paramsError", "errors.paramsError");
		}
		Truck truck = getTruck(truckBo.getTruckId());
		Vendor vendor = vmsService.loadByVenorId(truckBo.getVendorId());
		checkTSLData(truck, vendor);

		VendorTruck vendorTruck = vendorTruckService.loadByTruckId(truckBo.getTruckId(), loginUser);
		Integer oldVendorId = null;
		if(null == vendorTruck){
			//创建车辆、承运商关系
			VendorTruck vt = new VendorTruck();
			vt.setVendorId(truckBo.getVendorId());
			vt.setTruckId(truckBo.getTruckId());
			vendorTruckService.insert(vt,loginUser);
		}else {
			oldVendorId = vendorTruck.getVendorId();
			//修改车辆、承运商关系
			vendorTruck.setVendorId(truckBo.getVendorId());
			vendorTruckService.update(vendorTruck,loginUser);
		}
		//修改运力池
		CapacityPool capacityPool = new CapacityPool();
		capacityPool.setTruckId(truckBo.getTruckId());
		capacityPool.setTenantId(loginUser.getTenantId());
		capacityPool.setIsDelete(false);
		List<CapacityPool> capacityPools = transportService.findByCapacityPool(capacityPool);
		if(CollectionUtils.isNotEmpty(capacityPools)){
			CapacityPool c = capacityPools.get(0);
			c.setVendorId(truckBo.getVendorId());
			//取消司机绑定关系
			if(!truckBo.getVendorId().equals(oldVendorId)){
				c.setDriverId(null);
				c.setStatus(false);
			}
			transportService.insertCapacityPool(c,loginUser);
		}

		//发送短信
		pushTruckSms(loginUser,truck, vendor, oldVendorId);
	}

	private void checkTSLData(Truck truck, Vendor vendor) {
		if(TruckRunTypeEnum.JOIN.getCode().equals(truck.getTruckRunType())){
			//TSL车架号查询订单信息中已交车的【客户】->比对身份证是否匹配
            if(null != vendor){
                String idCardNo = vendor.getIdCardNo();
                CustomerInfoBO customerInfoBO = tslCommonService.getCustomerByVehicleFrameNo(truck.getTruckIdentificationNo());
                if(null == customerInfoBO || !idCardNo.equals(customerInfoBO.getCustomerIdNumber())){
                    throw new BusinessException("vendorNotMatchError", "新更换的加盟车承运商不是当前车辆在TSL系统订单中的客户");
                }
            }
		}
	}

	private void pushTruckSms(LoginUser loginUser,Truck truck, Vendor vendor, Integer oldVendorId) {
		Map<String,Object> extras = new HashMap<>(16);
		//向原承运商发送短信
		if(null != oldVendorId){
			Vendor oldVendor = vmsService.loadByVenorId(oldVendorId);
			if(null != oldVendor){
				extras.put("name",oldVendor.getVendorName());
				extras.put("plateNumber",truck.getPlateNumber());
				messageService.pushSmsMessage(loginUser,Constants.MESSAGE_TRUCK_CHANGE_VENDOR_PAST_PHONE,extras,oldVendor.getContactPhone());
			}
		}
		extras.clear();
		//向新承运商发送短信
		if(null != vendor){
			extras.put("name",vendor.getVendorName());
			extras.put("plateNumber",truck.getPlateNumber());
			messageService.pushSmsMessage(loginUser,Constants.MESSAGE_TRUCK_CHANGE_VENDOR_NEW_PHONE,extras,vendor.getContactPhone());
		}
	}

	@Override
	public void updateDriver(TruckBo truckBo, LoginUser loginUser) throws BusinessException{
		if (null == truckBo || null == truckBo.getTruckId()){
			throw new BusinessException("paramsError", "errors.paramsError");
		}
		CapacityPool capacityPool = checkRelationData(truckBo, loginUser);
		//司机已经绑定车辆，解除司机与原车辆的绑定
		if(capacityPool != null){
			Integer truckId = capacityPool.getTruckId();

			if(null != truckId && !truckId.equals(truckBo.getTruckId())){
				capacityPool.setDriverId(null);
				capacityPool.setStatus(false);
				transportService.updateCapacityPool(capacityPool, loginUser);
			}
		}

		CapacityPool cp = new CapacityPool();
		cp.setIsDelete(false);
        cp.setTruckId(truckBo.getTruckId());
        cp.setTenantId(loginUser.getTenantId());
		List<CapacityPool> capacityPools = transportService.findByCapacityPool(cp);
		Map<String,Object> extras = new HashMap<>(16);
		if(CollectionUtils.isNotEmpty(capacityPools)){
			CapacityPool c = capacityPools.get(0);
			Driver driver = driverService.loadDriverById(c.getDriverId());
			Truck truck = this.getTruck(truckBo.getTruckId());
			//向原司机发送短信
            if(null != driver){
                extras.put("name",driver.getName());
                extras.put("plateNumber",truck.getPlateNumber());
                messageService.pushSmsMessage(loginUser,Constants.MESSAGE_TRUCK_CHANGE_DRIVER_PAST_PHONE,extras,driver.getPhone());
            }
			if(null == truckBo.getDriverId()){
				c.setDriverId(null);
				c.setStatus(false);
			}else {
				c.setDriverId(truckBo.getDriverId());
				//修改运力状态
				DriverTenant dt = driverTenantService.loadByDriverId(truckBo.getDriverId(), loginUser);
				TruckTenant tt = truckTenantService.getByTruckId(truckBo.getTruckId(), loginUser);
				VendorTenant vt = vendorTenantService.loadByVendorId(c.getVendorId(), loginUser);
				if(null != dt && null != tt && null != vt){
					Boolean driverStatus = DriverStatusEnum.WORK.getCode().equals(dt.getStatus());
					Boolean truckStatus = TruckStatusEnum.ENABLE.getCode().equals(tt.getStatus());
					Boolean vendorStatus = vt.getIsEnable();
					if(driverStatus && truckStatus && vendorStatus){
						c.setStatus(true);
					}else {
						c.setStatus(false);
					}
				}
				//向新司机发送短信
				extras.clear();
				Driver newDriver = driverService.loadDriverById(truckBo.getDriverId());
				extras.put("name",newDriver.getName());
				extras.put("plateNumber",truck.getPlateNumber());
				messageService.pushSmsMessage(loginUser,Constants.MESSAGE_TRUCK_CHANGE_DRIVER_NEW_PHONE,extras,newDriver.getPhone());
			}
			transportService.insertCapacityPool(c,loginUser);
		}
	}

	@Override
	public String checkDriverBindTruck(TruckBo truckBo, LoginUser loginUser) throws BusinessException {

		CapacityPool capacityPool = checkRelationData(truckBo, loginUser);
		if(null != capacityPool && !truckBo.getTruckId().equals(capacityPool.getTruckId())){
			Truck truck = this.getTruck(capacityPool.getTruckId());
			Driver driver = driverService.loadDriverById(capacityPool.getDriverId());
			if(truck != null && driver != null){
				StringBuilder sb = new StringBuilder();
				sb.append("当前司机：");
				sb.append(driver.getName());
				sb.append("已经和车辆：");
				sb.append(truck.getPlateNumber());
				sb.append("绑定，是否确定解绑？");
				return sb.toString();
			}
		}
		return "ok";
	}

	private CapacityPool checkRelationData(TruckBo truckBo, LoginUser loginUser) {
		if(null != truckBo.getDriverId() && null != truckBo.getVendorId()){
			CapacityPool capacityPool = new CapacityPool();
			capacityPool.setDriverId(truckBo.getDriverId());
			capacityPool.setVendorId(truckBo.getVendorId());
			capacityPool.setTenantId(loginUser.getTenantId());
			capacityPool.setIsDelete(false);
			List<CapacityPool> capacityPools = transportService.findByCapacityPool(capacityPool);
			return capacityPools.isEmpty() ? null : capacityPools.get(0);
		}
		return null;
	}

	@Override
	public void updateStatus(Integer truckId, Integer status, LoginUser loginUser) throws BusinessException {
	    if(loginUser == null) throw new BusinessException("noLogin", "登陆信息为空");
	    TruckTenant truckTenant = truckTenantService.getByTruckId(truckId, loginUser);
	    if(truckTenant == null) return;
	    truckTenant.setStatus(status);
		truckTenantService.update(truckTenant, loginUser);
	}

	@Override
	public List<Truck> listByPlateNumber(TruckInfoQuery query, LoginEmployee loginUser) {
		if(null == query){
			return Lists.newArrayList();
		}
		// 1.卡车信息获取
		TruckExample example = new TruckExample().createCriteria()
				.andPlateNumberEqualTo(query.getPlateNumber())
				.andTruckRunTypeIn(query.getTruckRunTypes())
				.example();
		example.setSize(10);
		if( null != query.getPageSize() ){
			example.setStartOffSet(0);
			example.setSize(query.getPageSize());
		}
		List<Truck> trucks = truckMapper.selectByExample(example);
		if( CollectionUtils.isEmpty(trucks) ){
			return Lists.newArrayList();
		}
		Map<Integer,Truck> truckMap = Maps.newConcurrentMap();
		List<Integer> truckIds = Lists.newArrayList();
		for (Truck truck : trucks) {
			truckIds.add(truck.getTruckId());
			truckMap.put(truck.getTruckId(),truck);
		}
		// 2.认领公司过滤
		TruckTenantQuery truckTenantQuery = new TruckTenantQuery();
//		truckTenantQuery.setDepartmentIds(Lists.newArrayList(loginUser.getLoginDepartment().getDepartmentId()));
		truckTenantQuery.setTruckIds(truckIds);
		truckTenantQuery.setDepartmentCode(query.getDepartmentCode());
		List<TruckTenant> truckTenants = truckTenantService.listByQuery(truckTenantQuery, loginUser.getTenantId());
		if( CollectionUtils.isEmpty(truckTenants)){
			return Lists.newArrayList();
		}
		trucks.clear();
		// 3.车辆状态处于:正常
		for (TruckTenant truckTenant : truckTenants) {
			if( TruckStatusEnum.ENABLE.getCode().equals(truckTenant.getStatus()) ){
				trucks.add(truckMap.get(truckTenant.getTruckId()));
			}
		}
		return trucks;
	}

	@Override
    public List<TruckQuery> listByPlateNumber(TruckQuery truckQuery, Integer pageSize, LoginUser loginUser) {
        QueryCond<TruckQuery> cond = new QueryCond<>();
        cond.setPageNo(1);
        cond.setPageSize((pageSize == null || pageSize < 0) ? 100 : pageSize);

        if (null != loginUser && null != loginUser.getTenantId()) {
            truckQuery.setTenantId(loginUser.getTenantId());
        } else {
            truckQuery.setIsOwner((byte) 1);
        }

        cond.setFilters(truckQuery);

		List<TruckQuery> rows = null;

        if(null != truckQuery.getHaveDriver() && !truckQuery.getHaveDriver()){
        	//承运商下未关联司机的车辆
			rows = truckExtMapper.listByDriverFilter(cond);
		}else {
			rows = truckExtMapper.search(cond);
		}

        for (TruckQuery query : rows) {
			TruckType truckType = truckTypeService.findByBoxAndLength(query.getVehicleBoxType(), query.getVehicleBoxLength(), truckQuery.getTruckTenantId());
			query.setTruckTypeId(truckType == null ? null : truckType.getTruckTypeId());
            query.setTruckTypeName(truckTypeService.findTruckTypeNameBy(query.getVehicleBoxType(), query.getVehicleBoxLength()));
        }
        return rows;
    }

	@Override
	public Truck loadTruckBytruckIdentificationNo(String truckIdentificationNo) {
		if (StringUtils.isBlank(truckIdentificationNo)) {
			return null;
		}

		TruckExample example = new TruckExample().createCriteria()
				.andTruckIdentificationNoEqualTo(truckIdentificationNo)
				.example();
		List<Truck> list = truckMapper.selectByExample(example);

		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public List<Truck> listTruckByStatus(Integer status,LoginUser loginUser) {
	    List<Truck> result = new ArrayList<Truck>();
		if (null == status || loginUser == null) {
			return result;
		}
		TruckTenantExample example = new TruckTenantExample().createCriteria().andStatusEqualTo(status).andTenantIdEqualTo(loginUser.getTenantId()).example();
		List<TruckTenant> rows = truckTenantMapper.selectByExample(example);
		for(TruckTenant tt : rows) {
		    Truck truck = getTruck(tt.getTenantId());
		    if(truck == null) continue;
		    result.add(truck);
		}
		return result;
	}

	@Override
	public List<TruckQuery> listTruckBy(QueryCond<TruckQuery> queryCond, LoginUser loginUser) {

		TruckQuery filter = queryCond.getFilters();
		if (null == loginUser || null == loginUser.getTenantId()) {
			filter.setIsOwner((byte) 1);
		} else {
			filter.setTenantId(loginUser.getTenantId());
		}

		queryCond.setPageNo(1);

		return truckExtMapper.search(queryCond);
	}

	@Override
	public List<Truck> findByFilter(TruckFilter filter, LoginUser loginUser) {
		if( null == loginUser || null == loginUser.getTenantId() ){ return Lists.newArrayList(); }
		TruckTenantExample truckTenantExample = new TruckTenantExample().createCriteria()
				.andTenantIdEqualTo(loginUser.getTenantId())
				.andTruckIdIn(filter.getTruckIds())
				.example();
		List<TruckTenant> tenants = truckTenantMapper.selectByExample(truckTenantExample);
		List<Integer> localTruckIds = Lists.newArrayList();
		for (TruckTenant truckTenant : tenants){
			localTruckIds.add(truckTenant.getTruckId());
		}
		if( CollectionUtils.isEmpty(localTruckIds) ){ return Lists.newArrayList(); }
		TruckExample example = new TruckExample().createCriteria()
				.andTruckIdentificationNoLike(setLikeIfNotNull(filter.getTruckIdentificationNo()))
				.andTruckIdIn(localTruckIds)
				.example();
		return truckMapper.selectByExample(example);
	}

	private String setLikeIfNotNull(String field) {
		if( StringUtils.isBlank(field) ){ return field; }
		return "%" + field + "%";
	}

	@Override
    public void batchUpdate(List<Truck> rows) {
        truckMapper.updateBatchByPrimaryKeySelective(rows);
    }

    @Override
    public List<Truck> all() {
        return truckMapper.selectByExample(new TruckExample().createCriteria().example());
    }

	@Override
	public Page<CapacityPool> loadCapacityPoolByPlateNumber(QueryCond<TruckFilters> queryCond) {
		if(null == queryCond || null == queryCond.getFilters() || null == queryCond.getFilters().getTenantId()){
			return new Page<>(queryCond.getPageNo(), queryCond.getPageSize(), 0, new ArrayList<CapacityPool>());
		}
		int total = truckExtMapper.findByPlateNumberCount(queryCond);
		List<CapacityPool> rows = truckExtMapper.findByPlateNumber(queryCond);
		return new Page<>(queryCond.getPageNo(), queryCond.getPageSize(), total, rows);
	}
}
