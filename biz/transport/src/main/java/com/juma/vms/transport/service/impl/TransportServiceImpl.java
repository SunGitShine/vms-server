package com.juma.vms.transport.service.impl;

import com.alibaba.fastjson.JSON;
import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.juma.auth.conf.domain.BusinessArea;
import com.juma.auth.conf.service.BusinessAreaService;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.auth.user.domain.LoginUser;
import com.juma.log.domain.OperationLogInfo;
import com.juma.server.vm.domain.Vehicle;
import com.juma.server.vm.domain1.bo.VehicleBo;
import com.juma.tgm.truck.domain.TruckType;
import com.juma.tgm.truck.service.TruckTypeService;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.driver.domain.Driver;
import com.juma.vms.driver.domain.DriverTenant;
import com.juma.vms.driver.enumeration.DriverTypeEnum;
import com.juma.vms.driver.service.DriverService;
import com.juma.vms.driver.service.DriverTenantService;
import com.juma.vms.driver.vo.DriverBo;
import com.juma.vms.driver.vo.DriverQuery;
import com.juma.vms.operateLog.service.OperateLogService;
import com.juma.vms.tool.domain.BaseEnumDomian;
import com.juma.vms.tool.service.AmsCommonService;
import com.juma.vms.tool.service.MessageService;
import com.juma.vms.tool.service.ScmCommonService;
import com.juma.vms.transport.dao.CapacityPoolMapper;
import com.juma.vms.transport.domain.CapacityPool;
import com.juma.vms.transport.domain.CapacityPoolExample;
import com.juma.vms.transport.request.AddExternalTransportReq;
import com.juma.vms.transport.request.AddVendorAndDriverReq;
import com.juma.vms.transport.request.TransportPageReq;
import com.juma.vms.transport.response.DriverBeCurrResp;
import com.juma.vms.transport.response.TransportDetailResp;
import com.juma.vms.transport.response.TransportPageResp;
import com.juma.vms.transport.service.TransportService;
import com.juma.vms.truck.domain.Truck;
import com.juma.vms.truck.domain.bo.TruckResp;
import com.juma.vms.truck.enumeration.TruckRunTypeEnum;
import com.juma.vms.truck.enumeration.TruckStatusEnum;
import com.juma.vms.truck.service.TruckService;
import com.juma.vms.truck.vo.TruckBo;
import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.domain.VendorDriver;
import com.juma.vms.vendor.domain.VendorTenant;
import com.juma.vms.vendor.domain.VendorTruck;
import com.juma.vms.vendor.enumeration.VendorTypeEnum;
import com.juma.vms.vendor.service.VendorDriverService;
import com.juma.vms.vendor.service.VendorService;
import com.juma.vms.vendor.service.VendorTenantService;
import com.juma.vms.vendor.service.VendorTruckService;
import com.juma.vms.vendor.vo.VendorBo;
import com.juma.vms.vendor.vo.VendorQuery;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-19 17:29
 **/
@Service
public class TransportServiceImpl implements TransportService {

	private static final Logger log = LoggerFactory.getLogger(TransportServiceImpl.class);

	@Autowired
	private CapacityPoolMapper capacityPoolMapper;

	@Autowired
	private ScmCommonService scmCommonService;

	@Autowired
	private BusinessAreaService businessAreaService;

	@Autowired
	private TruckService truckService;

	@Autowired
	private AmsCommonService amsCommonService;

	@Autowired
	private VendorService vendorService;

	@Autowired
	private DriverService driverService;

	@Autowired
	private VendorDriverService vendorDriverService;

	@Autowired
	private VendorTruckService vendorTruckService;

	@Autowired
	private TruckTypeService truckTypeService;

	@Autowired
	private DriverTenantService driverTenantService;

	@Autowired
	private MessageService messageService;

	@Autowired
	private VendorTenantService vendorTenantService;

	@Autowired
	private OperateLogService operateLogService;

	@Override
	public Page<TransportPageResp> findTransportByPage(QueryCond<TransportPageReq> queryCond, LoginUser loginUser) {

		if(queryCond == null || queryCond.getFilters() == null
			|| queryCond.getFilters().getStatus() == null){
			throw new BusinessException("paramError", "errors.paramsError");
		}
		queryCond.getFilters().setTenantId(loginUser.getTenantId());
		Page<TransportPageResp> transportPageRespPage = new Page<>(queryCond.getPageNo(), queryCond.getPageSize(), 0, null);

		TruckType truckType = null;
		if(queryCond.getFilters().getTruckType() != null){
			//前端传车型id（通过车型id获取箱型和箱长）
			truckType = truckTypeService.getTruckType(queryCond.getFilters().getTruckType());
		}

		Integer truckLengthId = null;
		Integer vehicleBoxType = null;
		if(truckType != null){
			truckLengthId = truckType.getTruckLengthId();
			vehicleBoxType = truckType.getVehicleBoxType();
		}

		CapacityPoolExample capacityPoolExample = new CapacityPoolExample().createCriteria()
			.andIsDeleteEqualTo(false)
			.andStatusEqualTo(queryCond.getFilters().getStatus())
			.andTenantIdEqualTo(loginUser.getTenantId())
			.andDriverIdEqualTo(queryCond.getFilters().getDriverId())
			.andTruckIdEqualTo(queryCond.getFilters().getTruckId())
			.andVendorIdEqualTo(queryCond.getFilters().getVendorId())
			.andVehicleRunTypeEqualTo(queryCond.getFilters().getVehicleRunType())
			.andVehicleBoxTypeEqualTo(vehicleBoxType)
			.andVehicleBoxLengthEqualTo(truckLengthId)
			.andAreaCodeLikeList(queryCond.getFilters().getAreaCodeList())
			.example();
		capacityPoolExample.setSize(queryCond.getPageSize());
		capacityPoolExample.setStartOffSet(queryCond.getStartOffset());
		capacityPoolExample.setOrderByClause("create_time DESC");

		long capacityPoolCount = capacityPoolMapper.countByExample(capacityPoolExample);
		if(capacityPoolCount == 0){
			return transportPageRespPage;
		}

		List<CapacityPool> capacityPools = capacityPoolMapper.selectByExample(capacityPoolExample);

		List<TransportPageResp> transportPageResps = new ArrayList<>();
		for(CapacityPool capacityPool : capacityPools){
			TransportPageResp resp = new TransportPageResp();
			BeanUtils.copyProperties(capacityPool, resp);

			//组装车辆数据
			Truck truck = truckService.getTruck(resp.getTruckId());
			resp.setPlateNumber(truck.getPlateNumber());
			resp.setTruckIdentificationNo(truck.getTruckIdentificationNo());
			//车型名称
			String truckTypeName = truckTypeService.findTruckTypeNameBy(capacityPool.getVehicleBoxType(), capacityPool.getVehicleBoxLength());
			resp.setVehicleBoxName(truckTypeName);
			BusinessArea businessArea = businessAreaService.loadBusinessArea(capacityPool.getAreaCode(), loginUser);
			if(businessArea != null){
				resp.setTruckAreaCodeName(businessArea.getAreaName());
			}

			//组装司机信息
			if(resp.getDriverId() != null){
				Driver driver = driverService.loadDriverById(resp.getDriverId());
				resp.setDriverName(driver.getName());
				resp.setDriverPhone(driver.getPhone());
			}

			//组装承运商信息
			if(resp.getVendorId() != null){
				Vendor vendor = vendorService.getVendor(resp.getVendorId());
				resp.setVendorName(vendor.getVendorName());
				resp.setContactPhone(vendor.getContactPhone());
			}
			transportPageResps.add(resp);
		}
		return new Page<>(queryCond.getPageNo(), queryCond.getPageSize(), (int)capacityPoolCount, transportPageResps);
	}

	@Override
	public void addExternalTransport(AddExternalTransportReq addExternalTransportReq, LoginEmployee loginEmployee) {

		TruckBo truckBo = addExternalTransportReq.getTruckBo();
		checkTruck(truckBo, loginEmployee);

		VendorQuery vendor = vendorService.getVendorDetail(addExternalTransportReq.getVendorId(), loginEmployee);
		if(vendor == null){
			throw new BusinessException("vendorNotExistError", "errors.common.prompt", "承运商不存在");
		}
		Driver driver = driverService.loadDriverById(addExternalTransportReq.getDriverId());
		if(driver == null){
			throw new BusinessException("driverNotExistError", "errors.common.prompt", "司机不存在");
		}
		//租户下一个司机只能绑定一个车
		CapacityPoolExample example = new CapacityPoolExample().createCriteria()
			.andTenantIdEqualTo(loginEmployee.getTenantId())
			.andDriverIdEqualTo(driver.getDriverId())
			.andIsDeleteEqualTo(false).example();
		List<CapacityPool> capacityPools = capacityPoolMapper.selectByExample(example);
		if(!capacityPools.isEmpty() && null != capacityPools.get(0)){
			CapacityPool capacityPool = capacityPools.get(0);
			Truck truck = truckService.getTruck(capacityPool.getTruckId());
			String plateNumber = truck == null ? "" : truck.getPlateNumber();
			throw new BusinessException("driverExistError", "errors.common.prompt", "司机已与其他车辆("+ plateNumber +")绑定");
		}

		VendorDriver vendorDriverExit = vendorDriverService.loadByDriverId(addExternalTransportReq.getDriverId(), loginEmployee);
		if(vendorDriverExit != null && !vendorDriverExit.getVendorId().equals(addExternalTransportReq.getVendorId())){
			throw new BusinessException("driverExistError", "errors.common.prompt", "所选择司机不是承运商的关联司机，请重新选择");
		}

		//添加车辆及关联
		truckBo.setAreaCode(vendor.getAreaCode());
		truckBo.setTruckRunType(TruckRunTypeEnum.EMPLOY.getCode());
		//TruckTypeId转化为厢型、厢长
		if(truckBo.getTruckTypeId() != null){
			TruckType truckType = truckTypeService.getTruckType(truckBo.getTruckTypeId());
			truckBo.setVehicleBoxType(truckType == null ? null : truckType.getVehicleBoxType());
			truckBo.setVehicleBoxLength(truckType == null ? null : truckType.getTruckLengthId());
		}
		//设置状态为正常、认领公司为登录部门
		truckBo.setTruckStatus(TruckStatusEnum.ENABLE.getCode());
		truckBo.setTruckBelongToCompany(loginEmployee.getLoginDepartment().getDepartmentId());
		truckService.addTruck(truckBo, loginEmployee);

		//承运商车辆绑定
		VendorTruck vendorTruck = new VendorTruck();
		vendorTruck.setVendorId(addExternalTransportReq.getVendorId());
		vendorTruck.setTruckId(truckBo.getTruckId());
		vendorTruckService.addVendorTruck(vendorTruck, loginEmployee);

		//绑定司机
		VendorDriver vendorDriver = new VendorDriver();
		vendorDriver.setDriverId(addExternalTransportReq.getDriverId());
		vendorDriver.setVendorId(addExternalTransportReq.getVendorId());
		vendorDriverService.insert(vendorDriver, loginEmployee);

		//写入运力池
		CapacityPool capacityPool = new CapacityPool();
		capacityPool.setAreaCode(vendor.getAreaCode());
		capacityPool.setVendorId(addExternalTransportReq.getVendorId());
		capacityPool.setTruckId(truckBo.getTruckId());
		capacityPool.setDriverId(addExternalTransportReq.getDriverId());
		capacityPool.setVehicleBoxType(truckBo.getVehicleBoxType());
		capacityPool.setVehicleBoxLength(truckBo.getVehicleBoxLength());
		capacityPool.setStatus(true);
		capacityPool.setVehicleRunType(TruckRunTypeEnum.EMPLOY.getCode());
		insertCapacityPool(capacityPool, loginEmployee);

		//发送短信给承运商
		Map<String,Object> vendorTruckExtras = new HashMap<>();
		vendorTruckExtras.put("vendorName", vendor.getVendorName());
		vendorTruckExtras.put("plateNumber", truckBo.getPlateNumber());
		messageService.pushSmsMessage(loginEmployee,"VMS_VENDOR_BIND_TRUCK", vendorTruckExtras, vendor.getContactPhone());
		//发送短信给司机
		Map<String,Object> vendorDriverExtras = new HashMap<>();
		vendorDriverExtras.put("driverName", driver.getName());
		vendorDriverExtras.put("plateNumber", truckBo.getPlateNumber());
		messageService.pushSmsMessage(loginEmployee,"VMS_DRIVER_BIND_TRUCK", vendorDriverExtras, driver.getPhone());

		//绑定承运商操作记录
		this.writeBindVendorLog(truckBo.getTruckId(), vendor, loginEmployee);
		//绑定司机写操作日志
		this.writeBindDriverLog(truckBo.getTruckId(), driver, loginEmployee);
	}

	private void writeBindVendorLog(Integer truckId, Vendor vendor, LoginUser loginUser){
		OperationLogInfo info = new OperationLogInfo();
		info.setMethodName("com.juma.vms.transport.service.impl.TransportServiceImpl.addExternalTransport");
		Map<String, Object> map = new HashMap<>();
		map.put("truckId", truckId);
		StringBuilder bf = new StringBuilder();
		bf.append("承运商：");
		bf.append(vendor.getVendorName());
		bf.append(" 证件号：");
		if(vendor.getVendorType().equals(VendorTypeEnum.ENTERPRISE.getCode())){
			bf.append(vendor.getEnterpriseCode());
		}else{
			bf.append(vendor.getIdCardNo());
		}
		map.put("remark", bf.toString());
		info.setParam(JSON.toJSONString(map));
		operateLogService.writelog(info, loginUser);
	}

	private void writeBindDriverLog(Integer truckId, Driver driver, LoginUser loginUser){
		OperationLogInfo info = new OperationLogInfo();
		info.setMethodName("com.juma.vms.transport.service.impl.TransportServiceImpl.truckBindDriver");
		Map<String, Object> map = new HashMap<>();
		map.put("truckId", truckId);
		String bf = "司机："
			+ driver.getName()
			+ " 证件号："
			+ driver.getIdCardNo();
		map.put("remark", bf);
		info.setParam(JSON.toJSONString(map));
		operateLogService.writelog(info, loginUser);
	}

	@Override
	public TransportDetailResp findTransportDetail(Integer capacityPoolId, LoginUser loginUser) {

		if(capacityPoolId == null){
			throw new BusinessException("paramError", "errors.paramsError");
		}
		CapacityPool capacityPool = capacityPoolMapper.selectByPrimaryKey(capacityPoolId);
		if(capacityPool == null){
			throw new BusinessException("transportNotExist", "errors.common.prompt", "运力不存在");
		}
		TransportDetailResp transportDetailResp = new TransportDetailResp();
		TruckResp truckResp = truckService.getTruckDetail(capacityPool.getTruckId(), loginUser);
		DriverQuery driverQuery = driverService.getDriverDetail(capacityPool.getDriverId(), loginUser);
		VendorQuery vendorQuery = vendorService.getVendorDetail(capacityPool.getVendorId(), loginUser);

		transportDetailResp.setDriverQuery(driverQuery);
		transportDetailResp.setVendorQuery(vendorQuery);
		transportDetailResp.setTruckResp(truckResp);
		return transportDetailResp;
	}

	@Override
	public Map<String, Integer> addVendorAndBindDriver(AddVendorAndDriverReq addVendorAndDriverReq, LoginUser loginUser) {

		Map<String, Integer> map = new HashMap<>();

		boolean isSendMsg = true;
		VendorBo vendorBo = new VendorBo();
		//查询是否已存在该承运商，并把vendorId传入
		Vendor vendor = addVendorAndDriverReq.getVendor();
		Vendor vendorDB = null;
		if (vendor.getVendorType() == 1 || vendor.getVendorType() == 2){
			vendorDB = vendorService.loadByIdCardNo(vendor.getIdCardNo(), null);
		}
		if (vendor.getVendorType() == 3){
			vendorDB = vendorService.loadByEnterpriseCode(vendor.getEnterpriseCode(), null);
		}
		if(vendorDB == null){
			vendorDB = vendorService.loadByPhone(vendor.getContactPhone(), null);
		}
		if(vendorDB != null && vendorDB.getIsDelete().equals((byte) 0)){
			VendorTenant vendorTenant = vendorTenantService.loadByVendorId(vendorDB.getVendorId(), loginUser);
			if(vendorTenant != null){
				throw new BusinessException("vendorIsExist", "errors.common.prompt", "承运商已存在，不能重复添加");
			}
			vendor.setVendorId(vendorDB.getVendorId());
			isSendMsg = false;
		}

		vendorBo.setVendor(vendor);
		vendorBo.setVendorTenant(addVendorAndDriverReq.getVendorTenant());
		Integer vendorId = vendorService.insert(vendorBo, loginUser);
		map.put("vendorId", vendorId);

		if(addVendorAndDriverReq.isBindDriver()){
			DriverBo driverBo = new DriverBo();
			driverBo.setDriver(addVendorAndDriverReq.getDriver());
			driverBo.setDriverTenant(addVendorAndDriverReq.getDriverTenant());
			makeDriverBo(vendorBo, driverBo);
			Integer driverId = driverService.insertBasciInfo(driverBo, loginUser);
			map.put("driverId", driverId);

			VendorDriver vendorDriver = new VendorDriver();
			vendorDriver.setDriverId(driverBo.getDriver().getDriverId());
			vendorDriver.setVendorId(vendorBo.getVendor().getVendorId());
			vendorDriverService.insert(vendorDriver, loginUser);

			this.writeDriverLog(driverId, loginUser);
		}
		//新承运商发短信
		if(isSendMsg){
			messageService.pushSmsMessage(loginUser,"VMS_CREATE_VENDOR", null, vendor.getContactPhone());
		}
		return map;
	}

	private void writeDriverLog(Integer driverId, LoginUser loginUser){
		OperationLogInfo info = new OperationLogInfo();
		info.setMethodName("com.juma.vms.transport.service.TransportService.addVendorAndBindDriver");
		Driver driver = new Driver();
		driver.setDriverId(driverId);
		info.setParam(JSON.toJSONString(driver));
		operateLogService.writelog(info, loginUser);
	}

	private void makeDriverBo(VendorBo vendorBo, DriverBo driverBo){

		Vendor vendor = vendorBo.getVendor();
		VendorTenant vendorTenant = vendorBo.getVendorTenant();

		driverBo.getDriver().setName(vendor.getVendorName());
		driverBo.getDriver().setIdCardNo(vendor.getIdCardNo());
		driverBo.getDriver().setPhone(vendor.getContactPhone());
		driverBo.getDriver().setDriverRunType(vendor.getVendorSource().intValue());
		driverBo.getDriver().setIdCardImg1(vendor.getIdCardImg1());
		driverBo.getDriver().setIdCardImg2(vendor.getIdCardImg2());
		driverBo.getDriver().setDriverRunType(vendor.getVendorSource().intValue());

		DriverTenant driverTenant = new DriverTenant();
		driverTenant.setAreaCode(vendorTenant.getAreaCode());
		driverBo.setDriverTenant(driverTenant);
	}

	private void checkTruck(TruckBo truck, LoginEmployee loginEmployee) {
		if (truck == null || StringUtils.isBlank(truck.getPlateNumber()) || StringUtils.isBlank(
			truck.getTruckIdentificationNo())) {
			throw new BusinessException("paramError", "errors.paramsError");
		}

		if (null == truck.getTruckTypeId()) {
			throw new BusinessException("truckTypeIdNull", "errors.paramCanNotNullWithName", "车型");
		}

		Vehicle vehicle;
		List<VehicleBo> vehicles;
		try {
			vehicle = amsCommonService.getByVehicleFrameNo(truck.getTruckIdentificationNo());
			vehicles = amsCommonService.getVehicleListByPlateNo(Arrays.asList(truck.getPlateNumber()));
		}catch (Exception e) {
			if (e instanceof BusinessException) {
				throw e;
			}
			log.error("amsServiceError->findByPlateNumberOrVehicleFrameNo:{}", e.getMessage());
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

		Integer truckNum = truckService.findByPlateNumberAndIdentificationNo(truck.getPlateNumber(),
			truck.getTruckIdentificationNo(), loginEmployee);
		if (truckNum > 0) {
			throw new BusinessException("isExistError", "errors.common.prompt", "车辆已经是运力，不可重复添加");
		}
	}

	@Override
	public Integer addDriver(DriverBo driverBo, LoginUser loginUser) {

		driverBo.getDriver().setDriverRunType(DriverTypeEnum.NOT_OWN_SALE.getCode());//设置司机类型为非自营
		Integer driverId = driverService.insertBasciInfo(driverBo, loginUser);

		//发送短信给司机
		Map<String,Object> driverExtras = new HashMap<>();
		driverExtras.put("driverName", driverBo.getDriver().getName());
		messageService.pushSmsMessage(loginUser,"VMS_CREATE_DRIVER", driverExtras, driverBo.getDriver().getPhone());

		return driverId;
	}

	@Override
	public void updateCapacityPool(CapacityPool capacityPool, LoginUser loginUser) throws BusinessException {
		if (null == capacityPool || null == loginUser) {
			throw new BusinessException("paramsError", "errors.paramsError");
		}
		CapacityPool oldCapacityPool = capacityPoolMapper.selectByPrimaryKey(capacityPool.getCapacityPoolId());
		if(null == oldCapacityPool){
			return;
		}
		capacityPool.setLastUpdateUserId(loginUser.getUserId());
		capacityPool.setLastUpdateTime(new Date());
		capacityPoolMapper.updateByPrimaryKey(capacityPool);
	}

	@Override
	public void updateBasicCapacityPool(CapacityPool capacityPool) throws BusinessException {
		CapacityPool oldCapacityPool = capacityPoolMapper.selectByPrimaryKey(capacityPool.getCapacityPoolId());
		if(null == oldCapacityPool){
			return;
		}
		capacityPool.setLastUpdateTime(new Date());
		capacityPoolMapper.updateByPrimaryKey(capacityPool);
	}

	@Override
	public void insertCapacityPool(CapacityPool capacityPool, LoginUser loginUser) throws BusinessException {
		if (null == capacityPool || null == loginUser) {
			throw new BusinessException("paramsError", "errors.paramsError");
		}
		CapacityPool searchCapacityPool = new CapacityPool();
		searchCapacityPool.setTruckId(capacityPool.getTruckId());
		searchCapacityPool.setTenantId(loginUser.getTenantId());
		searchCapacityPool.setIsDelete(false);
		//运力池中存在记录先删除再新增
		List<CapacityPool> capacityPools = findByCapacityPool(searchCapacityPool);
        for(CapacityPool c:capacityPools){
            c.setCapacityPoolId(c.getCapacityPoolId());
            c.setIsDelete(true);
            c.setLastUpdateTime(new Date());
            c.setLastUpdateUserId(loginUser.getUserId());
            capacityPoolMapper.updateByPrimaryKey(c);
        }

		capacityPool.setTenantId(loginUser.getTenantId());
		capacityPool.setTenantCode(loginUser.getTenantCode());
		capacityPool.setIsDelete(false);
		capacityPool.setCreateUserId(loginUser.getUserId());
		capacityPool.setCreateTime(new Date());
		capacityPool.setLastUpdateTime(null);
		capacityPool.setLastUpdateUserId(null);
		capacityPoolMapper.insert(capacityPool);

	}

	@Override
	public List<CapacityPool> findByCapacityPool(CapacityPool capacityPool) {
		if (null == capacityPool) {
			return null;
		}

		List<CapacityPool> list = capacityPoolMapper.selectByExample(new CapacityPoolExample().createCriteria()
				.andTenantIdEqualTo(capacityPool.getTenantId())
				.andDriverIdEqualTo(capacityPool.getDriverId())
				.andVendorIdEqualTo(capacityPool.getVendorId())
				.andTruckIdEqualTo(capacityPool.getTruckId())
				.andVehicleRunTypeEqualTo(capacityPool.getVehicleRunType())
				.andStatusEqualTo(capacityPool.getStatus())
				.andIsDeleteEqualTo(capacityPool.getIsDelete())
				.example());

		return list;
	}

	@Override
	public Map<String, List<BaseEnumDomian>> getPropertyValueByKeys(List<String> keys) {

		return scmCommonService.getPropertyValueByKeys(keys);
	}

	@Override
	public DriverBeCurrResp loadDriverByIdCardNo(String idCordNo, LoginUser loginUser) {
		DriverBeCurrResp resp = new DriverBeCurrResp();
		Driver driver = driverService.loadByIdCardNo(idCordNo, loginUser);
		if( null != driver ){
			DriverTenant driverTenant = driverTenantService.loadByDriverId(driver.getDriverId(),loginUser);
			resp.setBeCurrDriver(null != driverTenant); // true 属于当前租户
			resp.setDriver(driver);
		}
		return resp;
	}
}
