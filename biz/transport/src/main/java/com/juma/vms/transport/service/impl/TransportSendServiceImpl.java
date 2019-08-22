package com.juma.vms.transport.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.juma.vms.mq.domain.WorkFlowInstance;
import com.juma.vms.mq.domain.WorkFlowMessage;
import com.juma.vms.tool.service.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.giants.common.tools.PageCondition;
import com.juma.auth.employee.domain.Department;
import com.juma.auth.employee.domain.DepartmentCompany;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.auth.employee.service.DepartmentService;
import com.juma.auth.employee.service.ECompanyService;
import com.juma.auth.support.service.DepartmentSupportService;
import com.juma.auth.tenant.domain.Tenant;
import com.juma.auth.tenant.service.TenantService;
import com.juma.auth.user.domain.LoginUser;
import com.juma.auth.user.domain.User;
import com.juma.auth.user.service.UserService;
import com.juma.conf.domain.ConfParamOption;
import com.juma.log.domain.OperationLogInfo;
import com.juma.scm.product.bo.PropertyValueBO;
import com.juma.scm.storage.service.GoodsService;
import com.juma.scm.storage.vo.GoodsVO;
import com.juma.scm.support.service.Scm4VmsService;
import com.juma.server.vm.common.LicenseImgTypeEnum;
import com.juma.server.vm.domain.LicenseImg;
import com.juma.server.vm.domain.bo.TenantVehicleBo;
import com.juma.server.vm.domain.dto.VehicleQueryConditionDTO;
import com.juma.server.vm.domain1.VehicleExtend;
import com.juma.server.vm.domain1.VehicleExtraFunction;
import com.juma.server.vm.domain1.bo.VehicleBo;
import com.juma.tgm.truck.service.TruckTypeService;
import com.juma.tsl.domain.bo.CustomerInfoBO;
import com.juma.tsl.support.service.TslCustomerInfoService;
import com.juma.vms.common.id.IdGeneratorTable;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.mq.domain.TruckCompanyChangeMq;
import com.juma.vms.mq.service.MqService;
import com.juma.vms.operateLog.service.OperateLogService;
import com.juma.vms.transport.dao.TransportCapacityItemMapper;
import com.juma.vms.transport.dao.TransportCapacityMapper;
import com.juma.vms.transport.dao.ext.TransportCapacityExtMapper;
import com.juma.vms.transport.dao.ext.TransportCapacityItemExtMapper;
import com.juma.vms.transport.domain.CapacityPool;
import com.juma.vms.transport.domain.TransportCapacity;
import com.juma.vms.transport.domain.TransportCapacityEnum;
import com.juma.vms.transport.domain.TransportCapacityExample;
import com.juma.vms.transport.domain.TransportCapacityItem;
import com.juma.vms.transport.domain.TransportCapacityItemExample;
import com.juma.vms.transport.enumeration.ApprovalStatus;
import com.juma.vms.transport.request.AddTransportSendReq;
import com.juma.vms.transport.request.SelectVehicleReq;
import com.juma.vms.transport.request.TransportSendPageReq;
import com.juma.vms.transport.response.TransportSendDetailResp;
import com.juma.vms.transport.response.TransportSendPageResp;
import com.juma.vms.transport.response.TransportVehicleDetail;
import com.juma.vms.transport.service.CapacityPoolService;
import com.juma.vms.transport.service.TransportSendService;
import com.juma.vms.transport.service.TransportService;
import com.juma.vms.truck.domain.Truck;
import com.juma.vms.truck.domain.TruckTenant;
import com.juma.vms.truck.enumeration.TruckRunTypeEnum;
import com.juma.vms.truck.enumeration.TruckStatusEnum;
import com.juma.vms.truck.service.TruckService;
import com.juma.vms.truck.service.TruckTenantService;
import com.juma.vms.truck.vo.TruckBo;
import com.juma.workflow.core.domain.ProcessInstance;
import com.juma.workflow.core.domain.TaskDetail;
import com.juma.workflow.core.service.ProcessService;
import com.juma.workflow.core.service.TaskService;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-19 17:30
 **/
@Service
public class TransportSendServiceImpl implements TransportSendService {

	private final static Logger log = LoggerFactory.getLogger(TransportSendServiceImpl.class);

	private final static String PROCESS_KEY = "transport_send";

	@Autowired
	private TransportCapacityExtMapper transportCapacityExtMapper;

	@Autowired
	private TransportCapacityMapper transportCapacityMapper;

	@Autowired
	private TransportCapacityItemExtMapper transportCapacityItemExtMapper;

	@Autowired
	private TransportCapacityItemMapper transportCapacityItemMapper;

	@Autowired
	private CapacityPoolService capacityPoolService;

	@Autowired
	private AuthCommonService authCommonService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private IdGeneratorService idGeneratorService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private TenantService tenantService;

	@Autowired
	private ProcessService processService;

	@Autowired
	private TruckTypeService truckTypeService;

	@Autowired
	private BusinessAreaCommonService businessAreaCommonService;

	@Autowired
	private TruckService truckService;

	@Autowired
	private TransportService transportService;

	@Autowired
	private TruckTenantService truckTenantService;

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private TslCustomerInfoService tslCustomerInfoService;

	@Autowired
	private OperateLogService operateLogService;

	@Autowired
	private MqService mqService;

	@Autowired
	private AmsCommonService amsCommonService;

	@Autowired
	private Scm4VmsService scm4VmsService;

	@Autowired
	private ECompanyService eCompanyService;

	@Autowired
	private UserService userService;

	@Autowired
	private DepartmentSupportService departmentSupportService;

	@Autowired
	private WorkflowCommonService workflowCommonService;

	@Override
	public Page<TransportSendPageResp> findTransportSendPage(QueryCond<TransportSendPageReq> queryCond, LoginUser loginUser) throws BusinessException {

		Page<TransportSendPageResp> transportSendPageResp = new Page<>(queryCond.getPageNo(), queryCond.getPageSize(), 0, null);
		if(queryCond.getFilters() == null){
			queryCond.setFilters(new TransportSendPageReq());
		}
		queryCond.getFilters().setTenantId(loginUser.getTenantId());

		//单据状态转审核状态
		Integer documentStatus = queryCond.getFilters().getDocumentStatus();
		if(documentStatus != null){
			List<Integer> approvalStatusList = new ArrayList<>();
			if(documentStatus.compareTo(1) == 0){
				approvalStatusList.add(TransportCapacityEnum.AuditStatus.SUBMIT.getCode());
				approvalStatusList.add(TransportCapacityEnum.AuditStatus.REJECT.getCode());
			}else if(documentStatus.compareTo(2) == 0){
				approvalStatusList.add(TransportCapacityEnum.AuditStatus.AGREE.getCode());
			}else{
				approvalStatusList.add(TransportCapacityEnum.AuditStatus.REVOKE.getCode());
				approvalStatusList.add(TransportCapacityEnum.AuditStatus.CANCEL.getCode());
			}
			queryCond.getFilters().setApprovalStatusList(approvalStatusList);
		}

		Integer capacityPoolCount = transportCapacityExtMapper.findCapacityPoolPageCount(queryCond);
		if(capacityPoolCount == 0){
			return transportSendPageResp;
		}

		List<TransportSendPageResp> transportSendPageResps = new ArrayList<>();

		List<TransportCapacity> transportCapacitys = transportCapacityExtMapper.findCapacityPoolPage(queryCond);

		for(TransportCapacity transportCapacity : transportCapacitys){
			TransportSendPageResp pageResp = new TransportSendPageResp();
			BeanUtils.copyProperties(transportCapacity, pageResp);
			pageResp.setSendType(transportCapacity.getTransportType());
			pageResp.setFromCompanyTenantName(authCommonService.loadByTenantId(transportCapacity.getTenantId()).getTenantName());
			pageResp.setToCompanyTenantName(authCommonService.loadByTenantId(transportCapacity.getReceiveTenantId()).getTenantName());
			Department fromDepartment = departmentService.loadDepartment(transportCapacity.getFromDepartmentId());
			if(fromDepartment != null){
				pageResp.setFromCompanyName(fromDepartment.getDepartmentName());
			}
			Department toDepartment = departmentService.loadDepartment(transportCapacity.getToDepartmentId());
			if(toDepartment != null){
				pageResp.setToCompanyName(toDepartment.getDepartmentName());
			}
			pageResp.setPlateNumberList(transportCapacityItemExtMapper.selectPlateNumber(transportCapacity.getTransportId()));

			transportSendPageResps.add(pageResp);
		}

		transportSendPageResp.setTotal(capacityPoolCount);
		transportSendPageResp.setResults(transportSendPageResps);
		return transportSendPageResp;
	}

	@Override
	public List<TransportVehicleDetail> selectVehicleList(SelectVehicleReq selectVehicleReq, LoginEmployee loginEmployee) throws BusinessException {

		List<TransportVehicleDetail> vehicleDetails = new ArrayList<>();
		if(selectVehicleReq == null || StringUtils.isBlank(selectVehicleReq.getTruckIdentificationNo())
			|| StringUtils.isBlank(selectVehicleReq.getFromDepartmentCode())){
			return vehicleDetails;
		}
		//从AMS查询车辆列表
		List<VehicleBo> vehicleBos = findVehicleFromAms(selectVehicleReq.getTruckIdentificationNo(), selectVehicleReq.getFromDepartmentCode(), loginEmployee);
		for(VehicleBo vehicleBo : vehicleBos){
			if(vehicleBo != null && vehicleBo.getVehicleExtend() != null){
				VehicleExtend vehicleExtend = vehicleBo.getVehicleExtend();
				TransportVehicleDetail vehicleDetail = new TransportVehicleDetail();
				vehicleDetail.setTruckIdentificationNo(vehicleExtend.getVehicleFrameNo());
				vehicleDetail.setPlateNumber(vehicleExtend.getPlateNumber());
				vehicleDetails.add(vehicleDetail);
			}
		}
		return vehicleDetails;
	}

	@Override
	public TransportVehicleDetail selectVehicleDetail(SelectVehicleReq selectVehicleReq, LoginEmployee loginEmployee) throws BusinessException {

		TransportVehicleDetail detail = new TransportVehicleDetail();

		if(selectVehicleReq == null || StringUtils.isBlank(selectVehicleReq.getTruckIdentificationNo())
			|| StringUtils.isBlank(selectVehicleReq.getFromDepartmentCode())){
			return detail;
		}
		//从AMS查询车辆列表
		List<VehicleBo> vehicleBos = findVehicleFromAms(selectVehicleReq.getTruckIdentificationNo(), selectVehicleReq.getFromDepartmentCode(), loginEmployee);
		if(vehicleBos.isEmpty()){
			return detail;
		}

		VehicleBo vehicleBo = vehicleBos.get(0);
		// 2,"整备完成" 3,"自营" 4,"加盟"
		log.info("选择车辆，AMS返回数据：" + JSON.toJSONString(vehicleBo));
		//只返回整备完成、自营、加盟的车辆
		if(vehicleBo != null){
			detail = makeVehicleDetail(vehicleBo, selectVehicleReq.getReceiveTenantId(), selectVehicleReq.getToDepartmentId(), loginEmployee);
		}
		return detail;
	}

	/**
	 * 组装车辆详情数据
	 * @param vehicleBo
	 * @return
	 */
	private TransportVehicleDetail makeVehicleDetail(VehicleBo vehicleBo, Integer receiveTenantId, Integer toDepartmentId, LoginUser loginUser){

		TransportVehicleDetail vehicleDetail = new TransportVehicleDetail();
		vehicleDetail.setVehicleId(vehicleBo.getVehicleId());

		VehicleExtend vehicleExtend = vehicleBo.getVehicleExtend();
		if(vehicleExtend != null){
			vehicleDetail.setPlateNumber(vehicleExtend.getPlateNumber());
			vehicleDetail.setTruckIdentificationNo(vehicleExtend.getVehicleFrameNo());

			Byte vehicleBoxType = vehicleExtend.getVehicleBoxType();
			Integer boxLevel = vehicleExtend.getBoxLevel();
			if(vehicleBoxType == null){
				throw new BusinessException("vehicleBoxTypeNullError", "errors.common.prompt", "车辆箱型为空不能输送");
			}
			if(boxLevel == null){
				throw new BusinessException("boxLevelNullError", "errors.common.prompt", "车辆箱长为空不能输送");
			}
			vehicleDetail.setVehicleBoxType(vehicleBoxType.intValue());
			vehicleDetail.setBoxLength(boxLevel);

			vehicleDetail.setPropertyType(vehicleExtend.getPropertyStatus() == null ? null : vehicleExtend.getPropertyStatus().intValue());
			vehicleDetail.setInventoryType(vehicleExtend.getAssetStatus() == null ? null : vehicleExtend.getAssetStatus().intValue());

			//客户信息
			CustomerInfoBO customerInfoBO = tslCustomerInfoService.getCustomerByVehicleFrameNo(vehicleExtend.getVehicleFrameNo());
			if(customerInfoBO != null){
				vehicleDetail.setCrmCustomerName(customerInfoBO.getCustomerName());
				vehicleDetail.setCrmMobileNumber(customerInfoBO.getCustomerPhone());
				vehicleDetail.setCrmIdentityCardNo(customerInfoBO.getCustomerIdNumber());
			}

			//车型名称
			String truckTypeName = truckTypeService.findTruckTypeNameBy(vehicleExtend.getVehicleBoxType().intValue(), vehicleExtend.getBoxLevel());
			vehicleDetail.setVehicleBoxName(truckTypeName);
		}

		Truck truck = truckService.findByVehicleId(vehicleBo.getVehicleId());
		//为空时表示没有此运力也没有认领公司
		vehicleDetail.setCapacityPoolStatus(0);
		vehicleDetail.setClaimStatus(0);
		if(truck != null && vehicleExtend != null){
			//自营车只能输送一次，不管租户
			CapacityPool capacityPool;
			List<CapacityPool> capacityPools;
			if("3".equals(vehicleExtend.getPropertyStatus().toString())){
				capacityPools = capacityPoolService.loadCapacityPoolByTruckId(truck.getTruckId());
				if(capacityPools != null && !capacityPools.isEmpty()){
					vehicleDetail.setCapacityPoolStatus(1);
					vehicleDetail.setClaimStatus(1);
				}
			}else if("2".equals(vehicleExtend.getPropertyStatus().toString())
				|| "4".equals(vehicleExtend.getPropertyStatus().toString())){

				//设置租户id为接收的租户id，判断该租户是否已存在该运力
				capacityPool = capacityPoolService.loadCapacityPoolByTruckId(truck.getTruckId(), new LoginUser(receiveTenantId, null));
				if(capacityPool != null){
					vehicleDetail.setCapacityPoolStatus(1);
				}
				TruckTenant truckTenant = truckTenantService.getByTruckId(truck.getTruckId(), new LoginUser(receiveTenantId, null));
				if(truckTenant != null && truckTenant.getTruckBelongToCompany() != null){
					vehicleDetail.setClaimStatus(1);
				}
			}
		}

		//车辆所有权主体信用代码
		if(StringUtils.isNotBlank(vehicleBo.getDepartmentCode())){
			LoginUser departmentLoginUser = new LoginUser(vehicleBo.getTenantId(), loginUser.getUserId());
			String vehicleCreditCode = findCreditCodeByDcode(vehicleBo.getDepartmentCode(), departmentLoginUser);
			vehicleDetail.setVehicleCreditCode(vehicleCreditCode);
		}
		//接收方经营权信用代码
		DepartmentCompany toDc = eCompanyService.findOperationECompanyByDepartment(toDepartmentId);
		vehicleDetail.setToDepartmentCreditCode(toDc == null ? "" : toDc.getUniformSocialCreditCode());

		//是否有在审核中的记录
		TransportCapacityItemExample example = new TransportCapacityItemExample().createCriteria()
			.andVehicleIdEqualTo(vehicleBo.getVehicleId()).example();
		List<TransportCapacityItem> items = transportCapacityItemMapper.selectByExample(example);
		for(TransportCapacityItem item : items){
			TransportCapacity transportCapacity = transportCapacityMapper.selectByPrimaryKey(item.getTransportId());
			Integer approvalStatus = transportCapacity.getApprovalStatus();
			vehicleDetail.setReceiptsStatus(0);
			/**
			 * //是否存在审核中的记录（自营车不看租户）
			 */
			if((approvalStatus.compareTo(TransportCapacityEnum.AuditStatus.SUBMIT.getCode()) == 0
				|| approvalStatus.compareTo(TransportCapacityEnum.AuditStatus.REJECT.getCode()) == 0)){
				if(vehicleExtend != null && "3".equals(vehicleExtend.getPropertyStatus().toString())){
					vehicleDetail.setReceiptsStatus(1);
					break;
				}else {
					if(receiveTenantId.equals(transportCapacity.getReceiveTenantId())){
						vehicleDetail.setReceiptsStatus(1);
						break;
					}
				}

			}
		}


		return vehicleDetail;
	}

	private String findCreditCodeByDcode(String departmentCode, LoginUser loginUser){
		String creditCode = "";
		if(StringUtils.isBlank(departmentCode)){
			return creditCode;
		}
		Department vehicleDe = departmentService.loadDepartment(departmentCode, loginUser);
		if(vehicleDe == null){
			return creditCode;
		}
		DepartmentCompany vehicleDc = eCompanyService.findOperationECompanyByDepartment(vehicleDe.getDepartmentId());
		if(vehicleDc != null && StringUtils.isNotBlank(vehicleDc.getUniformSocialCreditCode())){
			creditCode = vehicleDc.getUniformSocialCreditCode();
		}
		return creditCode;
	}

	@Override
	public void addTransportSend(AddTransportSendReq addTransportSendReq, LoginEmployee loginUser) {

		if(addTransportSendReq == null){
			throw new BusinessException("paramError", "errors.paramsError");
		}
		TransportCapacity transportCapacity = addTransportSendReq.getTransportCapacity();
		List<TransportCapacityItem> transportCapacityItems = addTransportSendReq.getTransportCapacityItems();

		checkTransportCapacity(transportCapacity);
		checkTransportCapacityItem(transportCapacityItems, transportCapacity.getReceiveTenantId(), transportCapacity.getToDepartmentId(), loginUser);

		addTransportCapacity(transportCapacity, loginUser);
		batchAddTransportCapacityItem(transportCapacityItems, transportCapacity.getTransportId(), loginUser);

		//SCM锁定车辆
		lockTrucks(transportCapacityItems, transportCapacity.getTransportNo());

		ProcessInstance processInstance = createProcess(PROCESS_KEY, transportCapacity, loginUser);
		transportCapacity.setSubmitTime(new Date());
		transportCapacity.setSubmitUserId(loginUser.getUserId());
		transportCapacity.setLastUpdateTime(new Date());
		transportCapacity.setLastUpdateUserId(loginUser.getUserId());
		transportCapacity.setProcessInstanceId(processInstance.getProcessInstanceId());
		transportCapacity.setApprovalStatus(1);
		transportCapacityMapper.updateByPrimaryKeySelective(transportCapacity);
	}

	private void lockTrucks(List<TransportCapacityItem> transportCapacityItems, String transportNo){

		List<String> truckIdentificationNos = new ArrayList<>();
		for(TransportCapacityItem item : transportCapacityItems){
			truckIdentificationNos.add(item.getTruckIdentificationNo());
		}
		try {
			scm4VmsService.lockByGoodsCodeList(truckIdentificationNos, "VMS", transportNo);
		} catch (Exception e) {
			if (e instanceof BusinessException) {
				throw e;
			}
			e.printStackTrace();
			throw new BusinessException("scmServiceError", "errors.scmServiceError", "lockByGoodsCodeList->"+e.getMessage());
		}

	}

	private void checkTransportCapacity(TransportCapacity transportCapacity){

		if(transportCapacity == null || transportCapacity.getTransportType() == null
			|| transportCapacity.getReceiveTenantId() == null || StringUtils.isBlank(transportCapacity.getReceiveTenantCode())
			|| transportCapacity.getFromDepartmentId() == null || StringUtils.isBlank(transportCapacity.getFromDepartmentCode())
			|| transportCapacity.getToDepartmentId() == null || StringUtils.isBlank(transportCapacity.getToDepartmentCode())){

			throw new BusinessException("paramError", "errors.paramsError");
		}
	}

	private void checkTransportCapacityItem(List<TransportCapacityItem> transportCapacityItems, Integer receiveTenantId, Integer toDepartmentId, LoginEmployee loginUser){

		if(transportCapacityItems == null || transportCapacityItems.isEmpty()){
			throw new BusinessException("transportCapacityItemNullError", "errors.common.prompt", "请选择车辆");
		}
		for(TransportCapacityItem item : transportCapacityItems){

			VehicleBo vehicleBo = amsCommonService.getByVehicleId(item.getVehicleId(), loginUser);
			if(vehicleBo == null){
				throw new BusinessException("vehicleNotExistError", "errors.common.prompt", "AMS不存在该车辆，车架号：" + item.getTruckIdentificationNo());
			}
			if(StringUtils.isBlank(item.getPlateNumber())){
				throw new BusinessException("plateNumberNullError", "errors.common.prompt", "车牌号不能为空");
			}
			if(StringUtils.isBlank(item.getTruckIdentificationNo())){
				throw new BusinessException("truckIdentificationNoNullError", "errors.common.prompt", "车架号不能为空");
			}
			log.info("校验车辆，AMS返回数据：" + JSON.toJSONString(vehicleBo));
			TransportVehicleDetail vehicleDetail = makeVehicleDetail(vehicleBo, receiveTenantId, toDepartmentId, loginUser);
			if(Integer.valueOf(1).equals(vehicleDetail.getClaimStatus()) && Integer.valueOf(1).equals(vehicleDetail.getCapacityPoolStatus())){
				throw new BusinessException("capacityPoolStatusError", "errors.common.prompt", "已是运力车辆不可重复输送，车架号：" + item.getTruckIdentificationNo());
			}
			//2、整备完成，3、自营，4、加盟
			if(!Integer.valueOf(2).equals(vehicleDetail.getPropertyType())){
				if(StringUtils.isBlank(vehicleDetail.getCrmCustomerName()) || StringUtils.isBlank(vehicleDetail.getCrmIdentityCardNo())
					|| StringUtils.isBlank(vehicleDetail.getCrmMobileNumber())){
					throw new BusinessException("customerInfoError", "errors.common.prompt", "车辆必须有客户、证件号和客户手机，车架号：" + item.getTruckIdentificationNo());
				}
			}

			if(Integer.valueOf(4).equals(vehicleDetail.getPropertyType()) || Integer.valueOf(3).equals(vehicleDetail.getPropertyType())){
				if(!Integer.valueOf(4).equals(vehicleDetail.getInventoryType())){
					throw new BusinessException("inventoryTypeError", "errors.common.prompt", "只能输送【已出库】车辆，车架号：" + item.getTruckIdentificationNo());
				}
			}

			if(Integer.valueOf(2).equals(vehicleDetail.getPropertyType()) && !Integer.valueOf(3).equals(vehicleDetail.getInventoryType())){
				throw new BusinessException("inventoryTypeError", "errors.common.prompt", "只能输送【在子公司库】的车辆，车架号：" + item.getTruckIdentificationNo());
			}

//			if(Integer.valueOf(2).equals(vehicleDetail.getPropertyType())
//				&& (StringUtils.isBlank(vehicleDetail.getVehicleCreditCode()) || StringUtils.isBlank(vehicleDetail.getToDepartmentCreditCode())
//				|| !vehicleDetail.getVehicleCreditCode().equals(vehicleDetail.getToDepartmentCreditCode()))){
//				throw new BusinessException("creditCodeError", "errors.common.prompt", "车辆所有权和接收所有权不一致不能输送，请走内部租赁流程，车架号：" + item.getTruckIdentificationNo());
//			}

		}
	}

	@Override
	public TransportSendDetailResp findTransportSendDetail(Integer transportId, LoginEmployee loginUser) {

		if(transportId == null){
			throw new BusinessException("paramError", "errors.paramsError");
		}
		TransportCapacity transportCapacity = transportCapacityMapper.selectByPrimaryKey(transportId);
		if(transportCapacity == null){
			throw new BusinessException("paramError", "errors.common.prompt", "输送单不存在");
		}

		TransportSendDetailResp resp = new TransportSendDetailResp();
		BeanUtils.copyProperties(transportCapacity, resp);
		resp.setToTenantName(tenantService.loadTenant(transportCapacity.getReceiveTenantId()).getTenantName());
		resp.setFromTenantName(tenantService.loadTenant(transportCapacity.getTenantId()).getTenantName());
		Department fromDepartment = departmentService.loadDepartment(transportCapacity.getFromDepartmentId());
		if(fromDepartment != null){
			resp.setFromDepartmentName(fromDepartment.getDepartmentName());
		}
		Department toDepartment = departmentService.loadDepartment(transportCapacity.getToDepartmentId());
		if(toDepartment != null){
			resp.setToDepartmentName(toDepartment.getDepartmentName());
		}
		//跨租户审批时要用输送租户id才能查到车
		LoginEmployee loginEmployee = new LoginEmployee();
		loginEmployee.setTenantId(transportCapacity.getTenantId());
		List<TransportVehicleDetail> vehicleDetails = makeVehicleData(transportCapacity, loginEmployee);
		resp.setVehicleDetails(vehicleDetails);
		User user = userService.loadUser(transportCapacity.getCreateUserId());
		if(user != null){
			resp.setCreateName(user.getName());
		}
		return resp;
	}

	private List<TransportVehicleDetail> makeVehicleData(TransportCapacity transportCapacity, LoginEmployee loginUser){

		List<TransportCapacityItem> items = findCapacityItems(transportCapacity.getTransportId());

		List<TransportVehicleDetail> vehicleDetails = new ArrayList<>();
		for(TransportCapacityItem item : items){

			TransportVehicleDetail vehicleDetail = new TransportVehicleDetail();
			BeanUtils.copyProperties(item, vehicleDetail);
			//箱型名称
			vehicleDetail.setVehicleBoxName(truckTypeService.findTruckTypeNameBy(item.getVehicleBoxType(), item.getVehicleBoxLength()));
			vehicleDetail.setBoxLength(item.getVehicleBoxLength());
			//客户信息
			CustomerInfoBO customerInfoBO = tslCustomerInfoService.getCustomerByVehicleFrameNo(item.getTruckIdentificationNo());
			if(customerInfoBO != null){
				vehicleDetail.setCrmCustomerName(customerInfoBO.getCustomerName());
				vehicleDetail.setCrmMobileNumber(customerInfoBO.getCustomerPhone());
				vehicleDetail.setCrmIdentityCardNo(customerInfoBO.getCustomerIdNumber());
			}
			LoginUser makeLoginUser = new LoginUser();
			makeLoginUser.setTenantId(transportCapacity.getReceiveTenantId());
			makeLoginUser.setTenantCode(transportCapacity.getReceiveTenantCode());
			vehicleDetail.setTruckAreaCodeName(businessAreaCommonService.loadLogicAndSelfAreaName(item.getAreaCode(), makeLoginUser));

			//资产状态
			List<VehicleBo> vehicleBos = findVehicleFromAms(item.getTruckIdentificationNo(), transportCapacity.getFromDepartmentCode(), loginUser);
			if(!vehicleBos.isEmpty()){
				VehicleBo vehicleBo = vehicleBos.get(0);
				if(vehicleBo != null && vehicleBo.getVehicleExtend() != null){
					vehicleDetail.setPropertyType(vehicleBo.getVehicleExtend().getPropertyStatus() == null ?
						null : vehicleBo.getVehicleExtend().getPropertyStatus().intValue());
				}
			}
			vehicleDetails.add(vehicleDetail);
		}
		return vehicleDetails;
	}

	@Override
	public void updateTransportSend(AddTransportSendReq addTransportSendReq, LoginEmployee loginUser) throws BusinessException {

		if(addTransportSendReq.getTransportCapacity() == null){
			throw new BusinessException("paramError", "errors.paramsError");
		}
		Integer transportId = addTransportSendReq.getTransportCapacity().getTransportId();
		TransportCapacity transportCapacity = transportCapacityMapper.selectByPrimaryKey(transportId);
		if(transportCapacity == null){
			throw new BusinessException("transportCapacityNotExist", "errors.common.prompt", "输送单不存在");
		}
		if(loginUser.getUserId().compareTo(transportCapacity.getCreateUserId()) != 0){
			throw new BusinessException("isNotCreateUser", "errors.common.prompt", "创建人才能修改");
		}

		List<TransportCapacityItem> transportCapacityItems = addTransportSendReq.getTransportCapacityItems();
		checkTransportCapacityItem(transportCapacityItems, transportCapacity.getReceiveTenantId(), transportCapacity.getToDepartmentId(), loginUser);

		//更新主数据附件信息
		TransportCapacity updateTransportCapacity = new TransportCapacity();
		updateTransportCapacity.setTransportId(transportId);
		updateTransportCapacity.setAttachUrl(addTransportSendReq.getTransportCapacity().getAttachUrl());
		transportCapacityMapper.updateByPrimaryKeySelective(updateTransportCapacity);

		TransportCapacityItemExample example = new TransportCapacityItemExample().createCriteria()
			.andTransportIdEqualTo(transportId).example();

		List<TransportCapacityItem> items = transportCapacityItemMapper.selectByExample(example);
		this.unLockTrucks(items);
		transportCapacityItemMapper.deleteByExample(example);

		batchAddTransportCapacityItem(addTransportSendReq.getTransportCapacityItems(), transportId, loginUser);
		this.lockTrucks(addTransportSendReq.getTransportCapacityItems(), transportCapacity.getTransportNo());
	}

	@Override
	public TaskDetail findTaskByProcessInstanceId(String processInstanceId, LoginEmployee loginEmployee) throws BusinessException {

		TransportCapacityExample example = new TransportCapacityExample().createCriteria()
			.andProcessInstanceIdEqualTo(processInstanceId).example();
		List<TransportCapacity> transportCapacities = transportCapacityMapper.selectByExample(example);
		if(transportCapacities.isEmpty()){
			return null;
		}
		if(!transportCapacities.get(0).getSubmitUserId().equals(loginEmployee.getUserId())){
			throw new BusinessException("isNotCreateUser", "errors.common.prompt", "只有提交人可编辑输送单");
		}
		return taskService.findTask(processInstanceId, loginEmployee);
	}

	@Override
	public void cancelWorkFlowTask(Integer transportId, LoginEmployee loginEmployee) throws BusinessException {

		if(transportId == null){
			throw new BusinessException("paramError", "errors.paramsError");
		}
		TransportCapacity transportCapacity = transportCapacityMapper.selectByPrimaryKey(transportId);
		if(transportCapacity == null || StringUtils.isBlank(transportCapacity.getProcessInstanceId())){
			throw new BusinessException("WorkflowNotExist", "errors.common.prompt", "审批流程不存在");
		}
		if(transportCapacity.getApprovalStatus().compareTo(TransportCapacityEnum.AuditStatus.REJECT.getCode()) == 0
			|| transportCapacity.getApprovalStatus().compareTo(TransportCapacityEnum.AuditStatus.AGREE.getCode()) == 0){
			throw new BusinessException("workflowStart", "errors.common.prompt", "审批流程已被审批，不能撤销");
		}
		if(loginEmployee.getUserId().compareTo(transportCapacity.getCreateUserId()) != 0){
			throw new BusinessException("isNotCreateUser", "errors.common.prompt", "创建人才能撤销");
		}

		//通知SCM对车辆解锁
		List<TransportCapacityItem> items = findCapacityItems(transportId);
		this.unLockTrucks(items);

		try {
			//审核中撤回工作流
			processService.revokeProcessInstance(transportCapacity.getProcessInstanceId(), "", loginEmployee);
		} catch (Exception e) {
			log.error("cancelProcess is error,transportId is {},error is {}: " , transportCapacity.getProcessInstanceId(), e.getMessage());
			if(e instanceof BusinessException) {
				throw e;
			}
			e.printStackTrace();
			throw new BusinessException("unknown.error", "外部错误:"+e.getMessage());
		}

		TransportCapacity updateCapacity = new TransportCapacity();
		updateCapacity.setTransportId(transportId);
		updateCapacity.setApprovalStatus(TransportCapacityEnum.AuditStatus.REVOKE.getCode());
		transportCapacityMapper.updateByPrimaryKeySelective(updateCapacity);
	}

	@Override
	public void doWorkFlowTask(WorkFlowMessage message) throws BusinessException {
		if(null == message || StringUtils.isBlank(message.getNumber())){
			return;
		}
		TransportCapacity transportCapacity = null;
		if(StringUtils.isNotBlank(message.getBusinessKey()) && NumberUtils.isNumber(message.getBusinessKey())){
			transportCapacity = transportCapacityMapper.selectByPrimaryKey(Integer.valueOf(message.getBusinessKey()));
			if(transportCapacity == null){
				throw new BusinessException("workflowNotExist", "审批流程不存在");
			}
		}else {
			//对工作流未返回businessKey容错处理
			List<TransportCapacity> transportCapacities = transportCapacityMapper.selectByExample(new TransportCapacityExample()
					.createCriteria().andTransportNoEqualTo(message.getNumber()).example());
			if(CollectionUtils.isEmpty(transportCapacities)){
				throw new BusinessException("workflowNotExist", "审批流程不存在");
			}
			transportCapacity = transportCapacities.get(0);
		}

		if(transportCapacity.getApprovalStatus().compareTo(TransportCapacityEnum.AuditStatus.AGREE.getCode()) == 0){
			throw new BusinessException("workflowAgree", "该审批流程已审核通过");
		}

		this.handleWorkFlowMsg(transportCapacity, message);
	}

	private void handleWorkFlowMsg(TransportCapacity transportCapacity, WorkFlowMessage message){
		if(null == message.getStatus()){ return;}
		String workFlowKey = message.getStatus().getWorkFlowKey();

		transportCapacity.setApprovalStatus(TransportCapacityEnum.AuditStatus.getCodeByWorkFlowKey(workFlowKey));
		transportCapacityMapper.updateByPrimaryKeySelective(transportCapacity);

		//同意的逻辑操作
		if (TransportCapacityEnum.AuditStatus.AGREE.getWorkFlowKey().equals(workFlowKey)) {
			List<TransportCapacityItem> items = findCapacityItems(transportCapacity.getTransportId());
			for (TransportCapacityItem item : items){

				//组装登录信息
				LoginEmployee loginEmployee = makeLoginEmployee(transportCapacity);
				//组装车辆对象
				TruckBo truckBo = makeTruckBoDate(item, transportCapacity, transportCapacity.getTenantId());
				log.info("审核通过，组装的车辆信息：" + JSON.toJSONString(truckBo));

				//写入车俩和车辆租户绑定表
				truckService.addTruck(truckBo, loginEmployee);
				//写入运力池
				CapacityPool capacityPool = new CapacityPool();
				capacityPool.setStatus(false);
				capacityPool.setAreaCode(item.getAreaCode());
				capacityPool.setTruckId(truckBo.getTruckId());
				capacityPool.setVehicleBoxType(item.getVehicleBoxType());
				capacityPool.setVehicleBoxLength(item.getVehicleBoxLength());
				capacityPool.setVehicleRunType(truckBo.getTruckRunType());
				capacityPool.setGoCityLicenseType(truckBo.getGoCityLicenseType());
				transportService.insertCapacityPool(capacityPool, loginEmployee);

				//回写输送明细truckId
				item.setTruckId(truckBo.getTruckId());
				transportCapacityItemMapper.updateByPrimaryKeySelective(item);

				//向AMS发送认领公司变更通知，并广播变更消息
				Department department = departmentService.loadDepartment(truckBo.getTruckBelongToCompany());
				if(null != department && null != truckBo.getTruckIdentificationNo()){
					TenantVehicleBo tenantVehicleBo = new TenantVehicleBo();
					tenantVehicleBo.setVehicleFrameNo(truckBo.getTruckIdentificationNo());
					tenantVehicleBo.setDepartmentCode(department.getDepartmentCode());
					tenantVehicleBo.setTenantId(loginEmployee.getTenantId());
					tenantVehicleBo.setUserId(loginEmployee.getUserId());
//					amsCommonService.changeCompany2Ams(tenantVehicleBo);

					TruckCompanyChangeMq companyChangeMq = new TruckCompanyChangeMq();
					BeanUtils.copyProperties(tenantVehicleBo, companyChangeMq);
					companyChangeMq.setTransportNo(transportCapacity.getTransportNo());
					mqService.sendTruckCompanyChange(companyChangeMq);
				}

				//写车辆添加操作日志
				this.writeTruckLog(truckBo.getTruckId(), transportCapacity.getTransportNo(), loginEmployee);
				this.writeTruckBlongLog(truckBo.getTruckId(), transportCapacity.getTransportNo(), loginEmployee);
			}
		}
	}

	private void writeTruckLog(Integer truckId, String transportNo, LoginUser loginUser){
		OperationLogInfo info = new OperationLogInfo();
		info.setMethodName("com.juma.vms.transport.service.TransportSendService.doWorkFlowTask");
		Map<String, Object> map = new HashMap<>();
		map.put("truckId", truckId);
		map.put("remark", transportNo);
		info.setParam(JSON.toJSONString(map));
		operateLogService.writelog(info, loginUser);
	}

	private void writeTruckBlongLog(Integer truckId, String transportNo, LoginUser loginUser){
		OperationLogInfo info = new OperationLogInfo();
		info.setMethodName("com.juma.vms.transport.service.TransportSendService.truckBlong");
		Map<String, Object> map = new HashMap<>();
		map.put("truckId", truckId);
		map.put("remark", transportNo);
		info.setParam(JSON.toJSONString(map));
		operateLogService.writelog(info, loginUser);
	}

	private void unLockTrucks(List<TransportCapacityItem> transportCapacityItems){

		List<String> truckIdentificationNos = new ArrayList<>();
		for(TransportCapacityItem item : transportCapacityItems){
			truckIdentificationNos.add(item.getTruckIdentificationNo());
		}
		try {
			scm4VmsService.unlockByGoodsCodeList(truckIdentificationNos, "VMS");
		} catch (Exception e) {
			if (e instanceof BusinessException) {
				throw e;
			}
			e.printStackTrace();
			throw new BusinessException("scmServiceError", "errors.scmServiceError", "unlockByGoodsCodeList->"+e.getMessage());
		}
	}

	@Override
	public TaskDetail getWorkflowElement(String taskId, LoginEmployee loginEmployee) {

		return taskService.findTaskDetail(taskId, loginEmployee);
	}

	@Override
	public List<Tenant> findAllTenant() throws BusinessException {
		return tenantService.findAllTenant();
	}

	@Override
	public List<TransportCapacityItem> getCapacityItemByTruckIdentificationNo(String truckIdentificationNo) throws BusinessException {
		TransportCapacityItemExample example = new TransportCapacityItemExample().createCriteria()
			.andTruckIdentificationNoEqualTo(truckIdentificationNo)
			.example();
		return transportCapacityItemMapper.selectByExample(example);
	}

	@Override
	public TransportCapacity getCapacityById(Integer transportId) throws BusinessException {
		return transportCapacityMapper.selectByPrimaryKey(transportId);
	}

	private void addTransportCapacity(TransportCapacity transportCapacity, LoginUser loginUser){

		String transportNo = idGeneratorService.genTransportSendNo(IdGeneratorTable.IdType.SS);
		DepartmentCompany fromDeCom = eCompanyService.findOperationECompanyByDepartment(transportCapacity.getFromDepartmentId());
		DepartmentCompany toDeCom = eCompanyService.findOperationECompanyByDepartment(transportCapacity.getToDepartmentId());
		transportCapacity.setFromDepartmentCreditcode(fromDeCom == null ? "" : fromDeCom.getUniformSocialCreditCode());
		transportCapacity.setToDepartmentCreditcode(toDeCom == null ? "" : toDeCom.getUniformSocialCreditCode());
		transportCapacity.setTransportType(1);
		transportCapacity.setTransportNo(transportNo);
		transportCapacity.setApprovalStatus(TransportCapacityEnum.AuditStatus.Append.getCode());
		transportCapacity.setCreateTime(new Date());
		transportCapacity.setCreateUserId(loginUser.getUserId());
		transportCapacity.setTenantId(loginUser.getTenantId());
		transportCapacity.setTenantCode(loginUser.getTenantCode());
		transportCapacityMapper.insertSelective(transportCapacity);
	}

	private void batchAddTransportCapacityItem(List<TransportCapacityItem> transportCapacityItems, Integer transportId, LoginUser loginUser){

		for(TransportCapacityItem item : transportCapacityItems){
			item.setTransportId(transportId);
			item.setStatus(false);
			item.setCreateTime(new Date());
			item.setCreateUserId(loginUser.getUserId());
			//TSL查询订单号及客户id
			CustomerInfoBO customerInfoBO = tslCustomerInfoService.getCustomerByVehicleFrameNo(item.getTruckIdentificationNo());
			if(customerInfoBO != null){
				if(customerInfoBO.getOrders() != null && !customerInfoBO.getOrders().isEmpty()){
					item.setTslOrderNo(customerInfoBO.getOrders().get(0));
				}
				item.setCrmCustomerId(customerInfoBO.getCustomerId());
			}
		}

		transportCapacityItemMapper.insertBatch(transportCapacityItems);
	}

	/**
	 * 创建工作流
	 * @param processKey
	 * @param transportCapacity
	 * @param loginEmployee
	 * @return
	 */
	private ProcessInstance createProcess(String processKey, TransportCapacity transportCapacity, LoginEmployee loginEmployee){

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("number", transportCapacity.getTransportNo());
		variables.put("auditTenantId", transportCapacity.getReceiveTenantId());
		ProcessInstance ins = null;
		try {
			ins = processService.startProcessInstance(processKey, transportCapacity.getTransportId().toString(), variables, loginEmployee);
		} catch (Exception e) {
			log.error("startProcess is error,transportId is {},error is {}: " , transportCapacity.getTransportId(), e.getMessage());
			if(e instanceof BusinessException) {
				throw e;
			}
			e.printStackTrace();
			throw new BusinessException("unknown.error", "外部错误:"+e.getMessage());
		}
		return ins;
	}

	private List<TransportCapacityItem> findCapacityItems(Integer transportId){

		TransportCapacityItemExample example = new TransportCapacityItemExample().createCriteria()
			.andTransportIdEqualTo(transportId).example();
		return transportCapacityItemMapper.selectByExample(example);
	}

	private TruckBo makeTruckBoDate(TransportCapacityItem item, TransportCapacity transportCapacity, Integer tenantId){

		TruckBo truckBo = new TruckBo();
		BeanUtils.copyProperties(item, truckBo);

		//车辆牌照、能耗、排放类型
		GoodsVO goodsVO = goodsService.getDetailByCode(item.getTruckIdentificationNo());
		if(goodsVO != null){
			Map<String, PropertyValueBO> property = goodsVO.getProperty();
			if(null != property.get("pzlx31") && StringUtils.isNumeric(property.get("pzlx31").getPropertyValueId())){//牌照
				truckBo.setLicenseType(Integer.parseInt(property.get("pzlx31").getPropertyValueId()));
			}
			if(null != property.get("energyType") && StringUtils.isNumeric(property.get("energyType").getPropertyValueId())){//能耗类型
				truckBo.setEnergyType(Integer.parseInt(property.get("energyType").getPropertyValueId()));
			}
			if(null != property.get("emissionStandard") && StringUtils.isNumeric(property.get("emissionStandard").getPropertyValueId())){//排放
				truckBo.setEnergyOutType(Integer.parseInt(property.get("emissionStandard").getPropertyValueId()));
			}
		}

		//车辆图片
		String[] truckImgArr = getTruckImg(item.getVehicleId(), LicenseImgTypeEnum.VEHICLE_BODY_IMG);
		truckBo.setTruckBodyImg(truckImgArr[0]);
		//行驶证图片
		String[] licenseImgArr = getTruckImg(item.getVehicleId(), LicenseImgTypeEnum.VEHICLE_LICENSE);
		truckBo.setLicenseCertificateImg1(licenseImgArr[0]);
		truckBo.setLicenseCertificateImg2(licenseImgArr[1]);
		//运营证图片
		String[] permitImgArr = getTruckImg(item.getVehicleId(), LicenseImgTypeEnum.TRANSPORT_LICENSE_ONE);
		truckBo.setPermitLicenseImg1(permitImgArr[0]);
		truckBo.setPermitLicenseImg2(permitImgArr[1]);
		//入城证
		String[] entryCityImg = getTruckImg(item.getVehicleId(), LicenseImgTypeEnum.ENTRY_CITY_LICENSE);
		if(StringUtils.isBlank(entryCityImg[0]) && StringUtils.isBlank(entryCityImg[1])){
			truckBo.setGoCityLicenseType(0);
		}else{
			truckBo.setGoCityLicenseType(1);
		}

		VehicleQueryConditionDTO vehicleQueryConditionDTO = new VehicleQueryConditionDTO();
		vehicleQueryConditionDTO.setTenantId(tenantId);
		vehicleQueryConditionDTO.setVehicleId(item.getVehicleId());
		vehicleQueryConditionDTO.setFunctionId(1);

		VehicleExtraFunction vehicleExtraFunction;
		try {
			vehicleExtraFunction = amsCommonService.getByVehicleIdFunctionId(vehicleQueryConditionDTO);
		}catch (Exception e) {
			if (e instanceof BusinessException) {
				throw e;
			}
			log.warn("amsServiceError->getByVehicleIdFunctionId:{}", e.getMessage());
			throw new BusinessException("amsServiceError", "errors.amsServiceError", "getByVehicleIdFunctionId");
		}
		if(vehicleExtraFunction != null && vehicleExtraFunction.getExtraFunctionId() != null){
			truckBo.setIsTailBoard(vehicleExtraFunction.getExtraFunctionId() == 1);//等于1时车辆有尾板属性
		}else{
			truckBo.setIsTailBoard(false);
		}

		//设置车辆运营类型
		LoginEmployee employee = new LoginEmployee();
		employee.setTenantId(transportCapacity.getTenantId());
		employee.setTenantCode(transportCapacity.getTenantCode());
		List<VehicleBo> vehicleBos = findVehicleFromAms(item.getTruckIdentificationNo(), transportCapacity.getFromDepartmentCode(), employee);
		if(!vehicleBos.isEmpty()){
			VehicleBo vehicleBo = vehicleBos.get(0);
			if(vehicleBo != null && vehicleBo.getVehicleExtend() != null){
				if(vehicleBo.getVehicleExtend().getPropertyStatus() == 4) {
					//资产状态为【加盟】设置为【加盟】
					truckBo.setTruckRunType(TruckRunTypeEnum.JOIN.getCode());
				}else if(vehicleBo.getVehicleExtend().getPropertyStatus() == 3
					|| vehicleBo.getVehicleExtend().getPropertyStatus() == 2){
					//资产状态为【自营】或【整备完成】设置为【自营】；
					truckBo.setTruckRunType(TruckRunTypeEnum.OWN_SALE.getCode());
				}
			}
		}
		//车辆待接收
		truckBo.setTruckStatus(TruckStatusEnum.WAIT_RECEIVE.getCode());
		truckBo.setTruckBelongToCompany(transportCapacity.getToDepartmentId());
		return truckBo;
	}

	private String[] getTruckImg(Integer vehicleId, LicenseImgTypeEnum imgTypeEnum){

		LicenseImg licenseImg;
		try {
			licenseImg = amsCommonService.getLicenseImgByVehicleIdAndType(vehicleId, imgTypeEnum);
		}catch (Exception e) {
			if (e instanceof BusinessException) {
				throw e;
			}
			log.warn("amsServiceError->getLicenseImgByVehicleIdAndType:{}", e.getMessage());
			throw new BusinessException("amsServiceError", "errors.amsServiceError", "getLicenseImgByVehicleIdAndType");
		}
		String[] reSlutImgArr = new String[2];
		if(licenseImg == null || StringUtils.isBlank(licenseImg.getImg())){
			return reSlutImgArr;
		}
		String[] imgArr = licenseImg.getImg().split(",");
		if(imgArr.length == 0){
			return reSlutImgArr;
		}
		for(int i = 0; i < imgArr.length; i++){
			reSlutImgArr[i] = imgArr[i];
			if(i == 1){
				break;
			}
		}

		return reSlutImgArr;
	}

	private LoginEmployee makeLoginEmployee(TransportCapacity transportCapacity){

		LoginEmployee loginEmployee = new LoginEmployee();
		loginEmployee.setTenantId(transportCapacity.getReceiveTenantId());
		loginEmployee.setTenantCode(transportCapacity.getReceiveTenantCode());
		loginEmployee.setUserId(transportCapacity.getCreateUserId());

		Department department = new Department(transportCapacity.getReceiveTenantId(), transportCapacity.getToDepartmentId());
		loginEmployee.initLoginDepartment(department, null);

		return loginEmployee;
	}

	private List<VehicleBo> findVehicleFromAms(String truckIdentificationNo,
		String fromDepartmentCode, LoginEmployee loginEmployee){

		PageCondition pageCondition = new PageCondition();
		pageCondition.setPageNo(1);
		pageCondition.setPageSize(10);

		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("departmentCode", fromDepartmentCode);
		paramMap.put("vehicleFrameNo", truckIdentificationNo);

		//权限状态
		List<Object> isAssetOwnerList = new ArrayList<>();
		isAssetOwnerList.add(1);
		isAssetOwnerList.add(3);
		paramMap.put("isAssetOwnerList", isAssetOwnerList);

		//资产状态 准备完成、加盟、自营
		List<Object> propertyStatusList = new ArrayList<>();
		propertyStatusList.add(2);
		propertyStatusList.add(3);
		propertyStatusList.add(4);
		paramMap.put("propertyStatusList", propertyStatusList);

		pageCondition.setFilters(paramMap);

		Page<VehicleBo> vehicleBoPage = amsCommonService.queryVehicleBoForInner(pageCondition, loginEmployee);
		Collection<VehicleBo> objects = vehicleBoPage.getResults();
		return new ArrayList<>(objects);
	}

	@Override
	public List<Tenant> findTransportTenantList() throws BusinessException {

		List<ConfParamOption> confParamOptions = authCommonService.getAllOption("TRANSPORT_TENANT_LIST");
		List<Tenant> resultTenant = new ArrayList<>();
		for(ConfParamOption confParamOption : confParamOptions){

			if(StringUtils.isNotBlank(confParamOption.getOptionValue())){
				Tenant tenant = authCommonService.loadByTenantId(Integer.parseInt(confParamOption.getOptionValue()));
				resultTenant.add(tenant);
			}
		}
		return resultTenant;
	}

	@Override
	public void reapplyToWorkflow(WorkFlowInstance workFlowInstance, LoginEmployee loginEmployee) throws BusinessException {
		log.info("send eventbus to workflow for transport send reapply start :{}", JSON.toJSONString(workFlowInstance));
		//修改处理中状态
		updateApprovalStatus(workFlowInstance);
		workflowCommonService.reopenWorkflow(workFlowInstance,loginEmployee);
		log.info("send eventbus to workflow for transport send reapply end");
	}

	@Override
	public void giveUpToWorkflow(WorkFlowInstance workFlowInstance, LoginEmployee loginEmployee) throws BusinessException {
		log.info("send eventbus to workflow for transport send give up start:{}", JSON.toJSONString(workFlowInstance));
		String businessKey = workFlowInstance.getBusinessKey();
		Integer transportId = StringUtils.isBlank(businessKey) ? null : Integer.valueOf(businessKey);
		TransportCapacityItemExample example = new TransportCapacityItemExample().createCriteria()
			.andTransportIdEqualTo(transportId).example();
		List<TransportCapacityItem> items = transportCapacityItemMapper.selectByExample(example);
		this.unLockTrucks(items);
		//修改处理中状态
		updateApprovalStatus(workFlowInstance);
		workflowCommonService.giveUpWorkflow(workFlowInstance,loginEmployee);
		log.info("send eventbus to workflow for transport send give up end");
	}

	private void updateApprovalStatus(WorkFlowInstance workFlowInstance) {
		if (StringUtils.isNotBlank(workFlowInstance.getTransportId())) {
			TransportCapacity transportCapacity = transportCapacityMapper.selectByPrimaryKey(Integer.valueOf(workFlowInstance.getTransportId()));
			if (null != transportCapacity) {
				transportCapacity.setApprovalStatus(TransportCapacityEnum.AuditStatus.PROCESS.getCode());
				transportCapacityMapper.updateByPrimaryKeySelective(transportCapacity);
			}
		}
	}

	@Override
	public void handleTransportSendAudit(Integer transportId, LoginUser loginUser) throws BusinessException {

		if(transportId == null){
			return;
		}
		TransportCapacity transportCapacity = transportCapacityMapper.selectByPrimaryKey(transportId);
		if(transportCapacity == null){
			throw new BusinessException("transportCapacityNotExist", "errors.common.prompt", "输送单不存在");
		}

		WorkFlowMessage message = WorkFlowMessage.builder().status(ApprovalStatus.APPROVAL_AGREE).build();
		handleWorkFlowMsg(transportCapacity, message);
	}
}
