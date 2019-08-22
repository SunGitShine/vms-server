package com.juma.vms.transport.service.impl;

import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.google.common.collect.Lists;
import com.juma.auth.employee.domain.Department;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.auth.employee.service.DepartmentService;
import com.juma.auth.support.service.DepartmentSupportService;
import com.juma.auth.tenant.domain.Tenant;
import com.juma.auth.user.domain.LoginUser;
import com.juma.server.vm.domain.Vehicle;
import com.juma.server.vm.domain1.bo.VehicleBo;
import com.juma.server.vm.domain1.bo.VehicleOwnerDeptBo;
import com.juma.vms.common.id.IdGeneratorTable;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.mq.domain.TruckReturnMq;
import com.juma.vms.mq.domain.WorkFlowMessage;
import com.juma.vms.mq.service.MqService;
import com.juma.vms.tool.service.*;
import com.juma.vms.transport.dao.TransportTruckRefundMapper;
import com.juma.vms.transport.domain.CapacityPool;
import com.juma.vms.transport.domain.TransportCapacityEnum;
import com.juma.vms.transport.domain.TransportTruckRefund;
import com.juma.vms.transport.domain.TransportTruckRefundExample;
import com.juma.vms.transport.enumeration.ApprovalStatus;
import com.juma.vms.transport.enumeration.RefundStatus;
import com.juma.vms.transport.external.ConsigneeDepartmentInfo;
import com.juma.vms.transport.external.TenantInfo;
import com.juma.vms.transport.external.TruckReturn;
import com.juma.vms.transport.external.TruckReturnToScmBo;
import com.juma.vms.transport.request.TransportTruckRefundPageReq;
import com.juma.vms.transport.request.TransportTruckRefundStorageReq;
import com.juma.vms.transport.request.TransportTruckRefundTruckReq;
import com.juma.vms.transport.response.ParentDepartment;
import com.juma.vms.transport.response.TransportReturnTruckInfoResp;
import com.juma.vms.transport.response.TransportTruckReturnResp;
import com.juma.vms.transport.service.CapacityPoolService;
import com.juma.vms.transport.service.TransportTruckReturnService;
import com.juma.vms.truck.domain.Truck;
import com.juma.vms.truck.domain.TruckTenant;
import com.juma.vms.truck.enumeration.TruckRunTypeEnum;
import com.juma.vms.truck.enumeration.TruckStatusEnum;
import com.juma.vms.truck.service.TruckService;
import com.juma.vms.truck.service.TruckTenantService;
import com.juma.vms.truck.vo.TruckInfoQuery;
import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.domain.VendorTruck;
import com.juma.vms.vendor.service.VendorService;
import com.juma.vms.vendor.service.VendorTruckService;
import com.juma.workflow.core.domain.ProcessInstance;
import com.juma.workflow.core.domain.TaskDetail;
import com.juma.workflow.core.service.ProcessService;
import com.juma.workflow.core.service.TaskService;

import org.apache.commons.collections.ArrayStack;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能 :
 * 运力退回功能
 * @author : Bruce(刘正航) 14:01 2019-04-03
 */
@Service
public class TransportTruckReturnServiceImpl implements TransportTruckReturnService {

    private final static Logger log = LoggerFactory.getLogger(TransportTruckReturnServiceImpl.class);

    private final static String PROCESS_KEY = "transport_truck_refund";
    private final static String PROCESS_KEY_STOCK = "transport_truck_refund_stock";

    @Autowired
    private MqService mqService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TruckService truckService;

    @Autowired
    private VendorService vendorService;

    @Autowired
    private ProcessService processService;

    @Autowired
    private AmsCommonService amsCommonService;

    @Autowired
    private TslCommonService tslCommonService;

    @Autowired
    private TgmCommonService tgmCommonService;

    @Autowired
    private AuthCommonService authCommonService;

    @Autowired
    private TruckTenantService truckTenantService;

    @Autowired
    private VendorTruckService vendorTruckService;

    @Autowired
    private IdGeneratorService idGeneratorService;

    @Autowired
    private CapacityPoolService capacityPoolService;

    @Autowired
    private BusinessAreaCommonService businessAreaCommonService;

    @Autowired
    private TransportTruckRefundMapper transportTruckRefundMapper;

    @Autowired
    private DepartmentSupportService departmentSupportService;

    @Autowired
    private DepartmentService departmentService;

    /**查询运力退回单列表**/
    @Override
    public Page<TransportTruckReturnResp> findTransportTruckRefundPage(QueryCond<TransportTruckRefundPageReq> request, LoginEmployee loginUser) throws BusinessException {

        Page<TransportTruckReturnResp> response = new Page<>(request.getPageNo(), request.getPageSize(), 0, null);

        if( null == request.getFilters() ){
            request.setFilters(new TransportTruckRefundPageReq());
        }

        //默认查询登录部门上级子公司的下级部门的数据
        if(StringUtils.isBlank(request.getFilters().getDepartmentCode())){
            Department superDepartment = departmentSupportService.findParentCompanyDepartment(loginUser.getLoginDepartment().getDepartmentId());
            if(superDepartment != null){
                request.getFilters().setDepartmentCode(superDepartment.getDepartmentCode());
            }
        }

//        List<Integer> deparmentIds = Lists.newArrayList();
//        if( null == request.getFilters().getDepartmentId() ){ // 如果前端未选择车辆认领公司,则默认为当前登录的账号,所在的部门
//            deparmentIds.add(loginUser.getLoginDepartment().getDepartmentId());
//            List<Department> departments = authCommonService.findAllLevelsChildDepartment(loginUser.getTenantId(),loginUser.getLoginDepartment().getDepartmentCode());
//            for (Department department : departments) {
//                deparmentIds.add(department.getDepartmentId());
//            }
//        }else{
//            deparmentIds.add(request.getFilters().getDepartmentId());
//        }

        TransportTruckRefundExample example = new TransportTruckRefundExample().createCriteria()
                .andTruckIdentificationNoLike(transferLikeParam(request.getFilters().getTruckIdentificationNo()))
                .andRefundReasonTypeEqualTo(request.getFilters().getRefundReasonType())
                .andApprovalStatusEqualTo(request.getFilters().getApprovalStatus())
                .andRefundStatusEqualTo(request.getFilters().getRefundStatus())
                .andPlateNumberLike(transferLikeParam(request.getFilters().getPlateNumber()))
                .andRefundNoLike(transferLikeParam(request.getFilters().getRefundNo()))
                .andCreateTimeGreaterThanOrEqualTo(request.getFilters().getStartDate())
                .andCreateTimeLessThanOrEqualTo(request.getFilters().getEndDate())
                .andTenantIdEqualTo(loginUser.getTenantId())
                .andDepartmentCodeLike(request.getFilters().getDepartmentCode()+"%")
                .example();


        long count = transportTruckRefundMapper.countByExample(example);

        if(count == 0){
            return response;
        }

        example.setSize(request.getPageSize());
        example.setStartOffSet(request.getStartOffset());
        example.setOrderByClause(" create_time desc ");
        List<TransportTruckRefund> list = transportTruckRefundMapper.selectByExample(example);

        if(CollectionUtils.isEmpty(list)){
            return response;
        }

        List<TransportTruckReturnResp> datas = Lists.newArrayList();
        for (TransportTruckRefund refund : list) {
            TransportTruckReturnResp resp = new TransportTruckReturnResp();
            resp.setTransportTruckRefund(refund);
            Department department = authCommonService.loadDepartment(refund.getDepartmentId(),loginUser);
            if( null != department ){
                resp.setDepartmentName(department.getDepartmentName());
                Tenant tenant = authCommonService.loadByTenantId(department.getTenantId());
                if( null != tenant ){
                    resp.setTenantName(tenant.getTenantName());
                }
            }
            // 增加退车部门租户名和部门名称
            Department toDepartment = authCommonService.loadDepartment(refund.getToDepartmentId());
            if( null != toDepartment ){
                resp.setToDepartmentId(toDepartment.getDepartmentId());
                resp.setToDepartmentCode(toDepartment.getDepartmentCode());
                resp.setToDepartmentName(toDepartment.getDepartmentName());
                Tenant tenant = authCommonService.loadByTenantId(toDepartment.getTenantId());
                if (null != tenant) {
                    resp.setToTenantId(tenant.getTenantId());
                    resp.setToTenantCode(tenant.getTenantCode());
                    resp.setToTenantName(tenant.getTenantName());
                }
            }
            datas.add(resp);
        }

        response.setTotal((int)count);
        response.setResults(datas);
        return response;
    }

    /**撤销运力退回单**/
    @Override
    public void cancelTruckRefund(Integer refundId, LoginEmployee loginUser) throws BusinessException {
        if(null == refundId){
            throw new BusinessException("paramError", "errors.paramsError");
        }
        TransportTruckRefund refund = transportTruckRefundMapper.selectByPrimaryKey(refundId);
        if( null == refund ){
            throw new BusinessException("refundNotExist", "运力退回单不存在");
        }

        // 只有提交本人才可以撤销
        if( !loginUser.getUserId().equals(refund.getCreateUserId()) ){
            throw new BusinessException("isNotCreateUser", "你没有当前运力退回单的操作权限");
        }
        if(StringUtils.isBlank(refund.getProcessInstanceId())){
            throw new BusinessException("workflowNotExist", "审批流程不存在");
        }
        if(refund.getApprovalStatus().compareTo(TransportCapacityEnum.AuditStatus.REJECT.getCode()) == 0
                || refund.getApprovalStatus().compareTo(TransportCapacityEnum.AuditStatus.AGREE.getCode()) == 0){
            throw new BusinessException("workflowStart", "审批流程已被审批，不能撤销");
        }

        try {
            //审核中撤回工作流
            processService.revokeProcessInstance(refund.getProcessInstanceId(), "", loginUser);
        } catch (Exception e) {
            log.error("cancelProcess is error,transportId is {},error is {}: " , refund.getProcessInstanceId(), e.getMessage());
            if(e instanceof BusinessException) {
                throw e;
            }
            e.printStackTrace();
            throw new BusinessException("unknown.error", "外部错误:"+e.getMessage());
        }

        TransportTruckRefund uRefund = new TransportTruckRefund();
        uRefund.setRefundId(refundId);
        uRefund.setLastUpdateTime(new Date());
        uRefund.setLastUpdateUserId(loginUser.getUserId());
        uRefund.setRefundStatus(RefundStatus.REFUND_APPROVAL_CANCEL.getCode());
        uRefund.setApprovalStatus(ApprovalStatus.APPROVAL_GIVE_UP.getCode());
        transportTruckRefundMapper.updateByPrimaryKeySelective(uRefund);
    }

    /**
     * 根据车牌号,查询车辆列表
     * 什么样的车可以走运力退回流程:
     * 2.运力池中有,车辆状态处于:启用
     * @param request
     * @param loginUser
     * @return
     * @throws BusinessException
     */
    @Override
    public List<TransportReturnTruckInfoResp> findRefundTruckInfos(TransportTruckRefundTruckReq request, LoginEmployee loginUser) throws BusinessException {
        // 没有输入车牌号,则不返回结果,因为这里是精确查询
        if( StringUtils.isBlank(request.getPlateNumber()) ){
            return Lists.newArrayList();
        }
        TruckInfoQuery truckQuery = new TruckInfoQuery();
        truckQuery.setPageSize(request.getPageSize());
        truckQuery.setPlateNumber(request.getPlateNumber());
//        truckQuery.setDepartmentId(loginUser.getLoginDepartment().getDepartmentId());
        truckQuery.setTruckStatus(TruckStatusEnum.ENABLE.getCode());
        truckQuery.setTruckRunTypes(Lists.newArrayList(TruckRunTypeEnum.OWN_SALE.getCode(),TruckRunTypeEnum.JOIN.getCode()));
        Department superDepartment = departmentSupportService.findParentCompanyDepartment(loginUser.getLoginDepartment().getDepartmentId());
        if(superDepartment == null){
            return Lists.newArrayList();
        }
        truckQuery.setDepartmentCode(superDepartment.getDepartmentCode());
        List<Truck> list = truckService.listByPlateNumber(truckQuery,loginUser);

        if( CollectionUtils.isEmpty(list) ){
            return Lists.newArrayList();
        }

        List<TransportReturnTruckInfoResp> results = Lists.newArrayList();
        for (Truck truck : list) {
            TransportReturnTruckInfoResp response = new TransportReturnTruckInfoResp();
            BeanUtils.copyProperties(truck,response);
            response.setDepartmentId(loginUser.getLoginDepartment().getDepartmentId());
            response.setDepartmentName(loginUser.getLoginDepartment().getDepartmentName());
            // 补充退车接收公司(运力输送-输送公司)信息
            fillFromDepartmentInfo(loginUser, truck, response);
            // 补充承运商相关信息
            fillVendorInfo(loginUser, truck, response);
            // 补充车辆运营范围
            fillTruckArea(loginUser, truck, response);
            // 补充车辆类型
            fillTruckType(truck, response);
            results.add(response);
        }
        return results;
    }

    /**添加运力退回单**/
    @Override
    public void addTransportTruckRefund(TransportTruckRefund refund, LoginEmployee loginUser) throws BusinessException {
        validParams(refund);

        validExists(refund, loginUser);

        validUnique(refund, loginUser);

        saveTransportTruckRefund(refund, loginUser);

        String processKey = PROCESS_KEY;
        Map<String, Object> variables = new HashMap<>();
        variables.put("number", refund.getRefundNo());
        variables.put("isRefundStock", false);
        boolean needReturn = tslCommonService.hasVehicleNeedReturn(refund.getTruckIdentificationNo());
//		boolean needReturn = true;
        //需要退库的车走特定的工作流，
        //工作流某节点配置审批页面为退库页面
        if(needReturn){
            processKey = PROCESS_KEY;
            TruckReturnToScmBo returnToScmBo = makeReturnToScmBo(refund.getRefundId(), loginUser);
            variables.put("inStorageInfo", returnToScmBo);
            VehicleBo vehicleBo = getTruckRunCompany(refund.getTruckIdentificationNo());
            //发送车辆经营权部门数据给工作流，决定谁去操作退库操作
            if(vehicleBo == null){
                throw new BusinessException("runCompanyIsNull", "车辆无经营权公司，流程无法进行");
            }
            variables.put("runTenantId", vehicleBo.getTenantId());
            variables.put("runDepartmentCode", vehicleBo.getDepartmentCode());
            variables.put("isRefundStock", true);
        }

        ProcessInstance processInstance = createProcess(processKey, refund.getRefundId(), variables, loginUser);

        updateTransportTruckRefund(refund,loginUser,processInstance);
    }

    private VehicleBo getTruckRunCompany(String identifyNo){
        Vehicle vehicle = amsCommonService.getByVehicleFrameNo(identifyNo);
        if(vehicle == null){
            return null;
        }
        List<VehicleBo> vehicleBos = amsCommonService.getVehicleBoListById(vehicle.getVehicleId());
        for(VehicleBo vehicleBo : vehicleBos){
            /** 返回经营权的信息
             * OWNER((byte) 0, "所有权"),
             * USER((byte) 1, "使用权"),
             * MANAGEMENT((byte)2, "经营权");
             */
            if(vehicleBo != null && 2 == vehicleBo.getRights()){
                return vehicleBo;
            }
        }
        return null;
    }

    private TruckReturnToScmBo makeReturnToScmBo(Integer returnId, LoginEmployee loginUser){

        TransportTruckRefund refund = transportTruckRefundMapper.selectByPrimaryKey(returnId);

        TransportTruckReturnResp resp = new TransportTruckReturnResp();
        resp.setTransportTruckRefund(refund);
        Department department = authCommonService.loadDepartment(refund.getDepartmentId(),loginUser);
        if( null != department ){
            resp.setDepartmentName(department.getDepartmentName());
            Tenant tenant = authCommonService.loadByTenantId(department.getTenantId());
            if( null != tenant ){
                resp.setTenantName(tenant.getTenantName());
            }
        }
        // 增加退车部门租户名和部门名称
        Department toDepartment = authCommonService.loadDepartment(refund.getToDepartmentId());
        if( null != toDepartment ){
            resp.setToDepartmentId(toDepartment.getDepartmentId());
            resp.setToDepartmentCode(toDepartment.getDepartmentCode());
            resp.setToDepartmentName(toDepartment.getDepartmentName());
            Tenant tenant = authCommonService.loadByTenantId(toDepartment.getTenantId());
            if (null != tenant) {
                resp.setToTenantCode(tenant.getTenantCode());
                resp.setToTenantId(tenant.getTenantId());
                resp.setToTenantName(tenant.getTenantName());
            }
        }
        TruckReturnToScmBo returnToScmBo = new TruckReturnToScmBo();

        TruckReturn truckReturn = new TruckReturn();
        truckReturn.setUniqueCode(resp.getTransportTruckRefund().getTruckIdentificationNo());
        truckReturn.setSourceNo(resp.getTransportTruckRefund().getRefundNo());
        truckReturn.setSourceId(resp.getTransportTruckRefund().getRefundId());

        List<TruckReturn> truckReturns = new ArrayList<>();
        truckReturns.add(truckReturn);

        TenantInfo tenantInfo = new TenantInfo();
        tenantInfo.setTenantCode(resp.getToTenantCode());
        tenantInfo.setTenantId(resp.getToTenantId());
        tenantInfo.setTenantName(resp.getToTenantName());

        ConsigneeDepartmentInfo departmentInfo = new ConsigneeDepartmentInfo();
        departmentInfo.setConsigneeDepartmentId(resp.getTransportTruckRefund().getToDepartmentId());
        departmentInfo.setConsigneeDepartmentNo(resp.getToDepartmentCode());
        departmentInfo.setConsigneeDepartmentName(resp.getToDepartmentName());

        returnToScmBo.setGoodsList(truckReturns);
        returnToScmBo.setTenantInfo(tenantInfo);
        returnToScmBo.setConsigneeDepartmentInfo(departmentInfo);

        return returnToScmBo;
    }

    /**运力退回单详情**/
    @Override
    public TransportTruckReturnResp findDetailByRefundId(Integer refundId, LoginEmployee loginUser) throws BusinessException {
        if(null == refundId){
            throw new BusinessException("paramError", "errors.paramsError");
        }
        TransportTruckRefund refund = transportTruckRefundMapper.selectByPrimaryKey(refundId);
        if( null == refund ){
            throw new BusinessException("refundNotExist", "运力退回单不存在");
        }

        TransportTruckReturnResp response = new TransportTruckReturnResp();
        response.setTransportTruckRefund(refund);

        Department department = authCommonService.loadDepartment(refund.getDepartmentId());
        if( null != department ){
            response.setDepartmentName(department.getDepartmentName());
            Tenant tenant = authCommonService.loadByTenantId(department.getTenantId());
            if( null != tenant ){
                response.setTenantName(tenant.getTenantName());
            }
        }

        // 增加退车部门租户名和部门名称
        Department toDepartment = authCommonService.loadDepartment(refund.getToDepartmentId());
        if( null != toDepartment ){
            response.setToDepartmentName(toDepartment.getDepartmentName());
            Tenant tenant = authCommonService.loadByTenantId(toDepartment.getTenantId());
            if (null != tenant) {
                response.setToTenantName(tenant.getTenantName());
            }
        }

        // 跨租户审批的嘶吼,考虑非当前租户,数据查询的问题.
        LoginUser returnLoginUser = new LoginUser();
        returnLoginUser.setTenantId(refund.getTenantId());
        Vendor vendor = vendorService.getVendorDetail(refund.getVendorId(),returnLoginUser);
        if( null != vendor ){
            response.setVendorName(vendor.getVendorName());
        }


        String truckTypeName = tgmCommonService.findTruckTypeDesc(refund.getVehicleBoxType(),refund.getVehicleBoxLength());
        response.setTruckTypeName(truckTypeName);

        String areaName = businessAreaCommonService.loadAreaName(refund.getAreaCode(),returnLoginUser);
        if( StringUtils.isNotBlank(areaName) ){
            response.setAreaName(areaName);
        }
        return response;
    }

    /**根据任务ID:获取工作流节点信息**/
    @Override
    public TaskDetail getWorkflowElement(String taskId, LoginEmployee loginEmployee) throws BusinessException {
        return taskService.findTaskDetail(taskId, loginEmployee);
    }

    /**根据流程ID:获取工作流节点信息**/
    @Override
    public TaskDetail findTaskByProcessInstanceId(String processInstanceId, LoginEmployee loginEmployee) throws BusinessException {
        return taskService.findTask(processInstanceId, loginEmployee);
    }

    /**完成工作流**/
    @Override
    public void doWorkFlowTask(WorkFlowMessage message) throws BusinessException {
        if(null == message || StringUtils.isBlank(message.getNumber())){
            return;
        }
        LoginEmployee loginEmployee = message.getLoginEmployee();
        TransportTruckRefund refund = null;
        if(StringUtils.isNotBlank(message.getBusinessKey()) && NumberUtils.isNumber(message.getBusinessKey())){
            refund = transportTruckRefundMapper.selectByPrimaryKey(Integer.valueOf(message.getBusinessKey()));
            if(null == refund){
                throw new BusinessException("refundNotExist", "运力退回单不存在");
            }
        }else {
            //对工作流未返回businessKey容错处理
            List<TransportTruckRefund> transportTruckRefunds = transportTruckRefundMapper.selectByExample(new TransportTruckRefundExample()
                    .createCriteria().andRefundNoEqualTo(message.getNumber()).example());
            if(CollectionUtils.isEmpty(transportTruckRefunds)){
                throw new BusinessException("refundNotExist", "运力退回单不存在");
            }
            refund = transportTruckRefunds.get(0);
        }

        if(refund.getApprovalStatus().compareTo(TransportCapacityEnum.AuditStatus.AGREE.getCode()) == 0){
            throw new BusinessException("workflowAgree", "该审批流程已审核通过");
        }
        try {
            this.updateRelationsAfterProcess(refund, message, loginEmployee);
        } catch ( BusinessException e){
            throw new BusinessException(e.getErrorKey(),e.getMessage());
        } catch (Exception e) {
            log.error("transportCapacity completeProcess is error, processInstanceId is {},error is {}: " ,refund.getProcessInstanceId(),e.getMessage());
            throw new BusinessException("unknown.error", "外部错误:"+e.getMessage());
        }
    }

    @Override
    public void doRefundTruckStorage(TransportTruckRefundStorageReq request, LoginEmployee loginEmployee) throws BusinessException {
        if( null == request ){
            throw new BusinessException("paramError", "errors.paramsError");
        }
        if( null == request.getRefundId() ){
            throw new BusinessException("paramError", "errors.paramsError");
        }
        TransportTruckRefund refund = new TransportTruckRefund();
        refund.setRefundId(request.getRefundId());
        refund.setStorageNo(refund.getStorageNo());
        refund.setRefundStatus(RefundStatus.REFUND_APPROVAL_AGREE.getCode());
        transportTruckRefundMapper.updateByPrimaryKeySelective(refund);
    }

    @Override
    public List<TransportTruckRefund> findDetailByTruckIdentificationNo(String truckIdentificationNo) {
        TransportTruckRefundExample example = new TransportTruckRefundExample().createCriteria()
                .andTruckIdentificationNoEqualTo(truckIdentificationNo)
                .example();
        return transportTruckRefundMapper.selectByExample(example);
    }

    @Override
    public void updateTruckReturnWithStorageNo(String refundNo, Integer tenantId, String storageNo) {

        TransportTruckRefundExample example = new TransportTruckRefundExample().createCriteria()
                .andRefundNoEqualTo(refundNo)
                .example();
        List<TransportTruckRefund> returns = transportTruckRefundMapper.selectByExample(example);
        // 运力退回单无效
        if( CollectionUtils.isEmpty(returns) ){
            return;
        }
        // 出现脏数据
        if( returns.size() > 1 ){
            return;
        }
        TransportTruckRefund refund = returns.get(0);
        refund.setStorageNo(storageNo);
        refund.setRefundStatus(RefundStatus.REFUND_APPROVAL_AGREE.getCode());
        transportTruckRefundMapper.updateByPrimaryKeySelective(refund);
    }

    /**工作流审批完成之后,做相应的数据处理工作**/
    private void updateRelationsAfterProcess(TransportTruckRefund refund, WorkFlowMessage message, LoginEmployee loginEmployee) {

        if(null == message.getStatus()){ return;}
        String workFlowKey = message.getStatus().getWorkFlowKey();

        // 更新运力退回单工作流状态
        if( StringUtils.isBlank(workFlowKey) ){
            throw new BusinessException("workflowAgree", "审批流程状态错误");
        }
        refund.setApprovalStatus(ApprovalStatus.getApprovalStatusWithWorkKey(workFlowKey));
        // 审批通过
        if (ApprovalStatus.APPROVAL_AGREE.getWorkFlowKey().equals(workFlowKey)) {
            // 运力退回审核通过
            // 1.车辆状态:已退车
            Truck truck = truckService.findByPlateNumber(refund.getPlateNumber());
            truckService.updateStatus(truck.getTruckId(),TruckStatusEnum.ALREADY_CAR_BACK.getCode(),loginEmployee);
            // 1.1删除车辆和租户vendor_truck/vendor_driver/capacity_pool
            boolean needReturn = tslCommonService.hasVehicleNeedReturn(refund.getTruckIdentificationNo());
            // 2.1运力退回单状态: 已交车: 已完成
            refund.setRefundStatus(RefundStatus.REFUND_APPROVAL_AGREE.getCode());
            refund.setLastUpdateTime(new Date());
            refund.setLastUpdateUserId(loginEmployee.getUserId());
            refund.setApprovalStatus(ApprovalStatus.APPROVAL_AGREE.getCode());
            transportTruckRefundMapper.updateByPrimaryKeySelective(refund);
            // 3.清除车辆的认领公司信息
            truckTenantService.clearRelationInfoAfterReturn(truck.getTruckId(),refund.getTenantId());
            LoginUser loginUser = new LoginUser();
            loginUser.setTenantId(refund.getTenantId());
            CapacityPool pool = capacityPoolService.loadCapacityPoolByTruckId(truck.getTruckId(),loginUser);
            if( null != pool && !pool.getIsDelete() ){
                pool.setIsDelete(true);
                capacityPoolService.update(pool);
            }
            // 3.1删除承运商和卡车的关联信息
            vendorTruckService.clearRelationInfoAfterReturn(truck.getTruckId(),refund.getVendorId(),refund.getTenantId());
            // 4.1 车辆类型为加盟+不管是否已交车: 通知AMS+TSL
            if( TruckRunTypeEnum.JOIN.getCode().equals(truck.getTruckRunType()) ){
                notifyOtherSystem(refund, loginEmployee, truck, needReturn);
            }
            // 4.2 车辆类型为自营+不是自有资产(已交车): 通知AMS+TSL
            if( TruckRunTypeEnum.OWN_SALE.getCode().equals(truck.getTruckRunType())){
                notifyOtherSystem(refund, loginEmployee, truck, needReturn);
            }
        }else if(ApprovalStatus.APPROVAL_GIVE_UP.getWorkFlowKey().equals(workFlowKey)){
            // 被驳回
            // 更改单据状态为未通过,更改审批状态为已驳回
            refund.setLastUpdateTime(new Date());
            refund.setLastUpdateUserId(loginEmployee.getUserId());
            refund.setRefundStatus(RefundStatus.REFUND_APPROVAL_FAIL.getCode());
            refund.setApprovalStatus(ApprovalStatus.APPROVAL_REJECTED.getCode());
            transportTruckRefundMapper.updateByPrimaryKeySelective(refund);
        }
    }

    /**保存运力退回单**/
    private void saveTransportTruckRefund(TransportTruckRefund refund, LoginEmployee loginUser) {
        Department department = departmentService.loadDepartment(refund.getDepartmentId());
        String refundNo = idGeneratorService.genTransportSendNo(IdGeneratorTable.IdType.TC);
        if(department != null){
            refund.setDepartmentCode(department.getDepartmentCode());
        }
        refund.setRefundNo(refundNo);
        refund.setTenantId(loginUser.getTenantId());
        refund.setCreateTime(new Date());
        refund.setCreateUserId(loginUser.getUserId());
        refund.setRefundStatus(RefundStatus.REFUND_APPROVALING.getCode());
        refund.setApprovalStatus(ApprovalStatus.APPROVAL_UN_SUBMIT.getCode());
        transportTruckRefundMapper.insert(refund);
    }

    /**回填工作流ID**/
    private void updateTransportTruckRefund(TransportTruckRefund refund, LoginEmployee loginUser, ProcessInstance processInstance) {
        refund.setSubmitTime(new Date());
        refund.setSubmitUserId(loginUser.getUserId());
        refund.setProcessInstanceId(processInstance.getProcessInstanceId());
        refund.setApprovalStatus(ApprovalStatus.APPROVAL_SUBMIT.getCode());
        refund.setRefundStatus(RefundStatus.REFUND_APPROVALING.getCode());
        refund.setLastUpdateUserId(loginUser.getUserId());
        refund.setLastUpdateTime(new Date());
        transportTruckRefundMapper.updateByPrimaryKey(refund);
    }

    /**创建工作流**/
    private ProcessInstance createProcess(String processKey, Integer refundId, Map<String, Object> variables, LoginEmployee loginEmployee){

        ProcessInstance ins;
        try {
            ins = processService.startProcessInstance(processKey, refundId.toString(), variables, loginEmployee);
        } catch (Exception e) {
            log.error("startProcess is error,refundId is {},error is {}: " , refundId, e.getMessage());
            if(e instanceof BusinessException) {
                throw e;
            }
            e.printStackTrace();
            throw new BusinessException("unknown.error", "外部错误:"+e.getMessage());
        }
        return ins;
    }

    /**like参数非空判断**/
    private String transferLikeParam(String identificationNo) {
        if( StringUtils.isNotBlank(identificationNo) ){
            identificationNo = "%"+identificationNo+"%";
        }
        return identificationNo;
    }

    /**校验非空**/
    private void validParams(TransportTruckRefund refund) {
        if( null == refund ){
            throw new BusinessException("paramError", "errors.paramsError");
        }
        if( StringUtils.isBlank(refund.getPlateNumber()) ){
            throw new BusinessException("paramError", "车牌号不能为空");
        }
        if( StringUtils.isBlank(refund.getTruckIdentificationNo()) ){
            throw new BusinessException("paramError", "车架号不能为空");
        }
        if( null == refund.getVehicleBoxType() ){
            throw new BusinessException("paramError", "车辆箱型不能为空");
        }
        if( null == refund.getVehicleBoxLength() ){
            throw new BusinessException("paramError", "车辆长度不能为空");
        }
        if( null == refund.getTruckRunType() ){
            throw new BusinessException("paramError", "车辆运营类型不能为空");
        }
        if( null == refund.getDepartmentId() ){
            throw new BusinessException("paramError", "车辆认领部门不能为空");
        }
        if( null == refund.getToDepartmentId() ){
            throw new BusinessException("paramError", "退车部门不能为空");
        }
        if( StringUtils.isBlank(refund.getAreaCode()) ){
            throw new BusinessException("paramError", "车辆服务区域不能为空");
        }
        if( null == refund.getRefundReasonType() ){
            throw new BusinessException("paramError", "车辆退回原因类型不能为空");
        }
        if( StringUtils.isBlank(refund.getRefundReason()) ){
            throw new BusinessException("paramError", "车辆退回原因不能为空");
        }
    }

    /**校验唯一性**/
    private void validUnique(TransportTruckRefund refund, LoginEmployee loginUser) {
        TransportTruckRefundExample example = new TransportTruckRefundExample().createCriteria()
                .andTenantIdEqualTo(loginUser.getTenantId())
                .andPlateNumberEqualTo(refund.getPlateNumber())
                .andTruckIdentificationNoEqualTo(refund.getTruckIdentificationNo())
                .andRefundStatusIn(Lists.newArrayList(RefundStatus.REFUND_APPROVALING.getCode(),RefundStatus.REFUND_WAITING_STORAGE.getCode()))
                .example();
        List<TransportTruckRefund> refunds = transportTruckRefundMapper.selectByExample(example);
        if( !CollectionUtils.isEmpty(refunds) ){
            throw new BusinessException("paramError", "该卡车在当前租户下已存在运力退回单,不可重复创建");
        }
    }

    /**校验存在性**/
    private void validExists(TransportTruckRefund refund, LoginEmployee loginUser) {
        Truck truck = truckService.loadTruckBytruckIdentificationNo(refund.getTruckIdentificationNo());
        CapacityPool pool = capacityPoolService.loadCapacityPoolByTruckId(truck.getTruckId(),loginUser);
        if( null == pool ){
            throw new BusinessException("paramError", "当前卡车在运力系统不存在,不能走运力退回流程");
        }
    }

    private void notifyOtherSystem(TransportTruckRefund refund, LoginEmployee loginEmployee, Truck truck, boolean needReturn) {
        TruckReturnMq body = new TruckReturnMq();
        body.setReturnId(refund.getRefundId());
        body.setReturnNo(refund.getRefundNo());
        body.setTenantId(refund.getTenantId());
        body.setTruckIdentificationNo(truck.getTruckIdentificationNo());
        body.setTruckRunType(truck.getTruckRunType());
        body.setDepartmentId(refund.getDepartmentId());
        body.setBeSelf(needReturn);
        mqService.sendAfterTruckReturn(body);
    }

    /**填充车辆类型**/
    private void fillTruckType(Truck truck, TransportReturnTruckInfoResp response) {
        String truckTypeName = tgmCommonService.findTruckTypeDesc(truck.getVehicleBoxType(),truck.getVehicleBoxLength());
        response.setTruckTypeName(truckTypeName);
    }

    private void fillTruckArea(LoginEmployee loginUser, Truck truck, TransportReturnTruckInfoResp response) {
        TruckTenant truckTenant = truckTenantService.getByTruckId(truck.getTruckId(),loginUser);
        if( null == truckTenant ){ return; }
        if(StringUtils.isBlank(truckTenant.getAreaCode())) { return; }
        response.setAreaCode(truckTenant.getAreaCode());
        String areaName = businessAreaCommonService.loadAreaName(truckTenant.getAreaCode(),loginUser);
        if( StringUtils.isNotBlank(areaName) ){
            response.setAreaName(areaName);
        }
    }

    /**补充承运商相关信息**/
    private void fillVendorInfo(LoginEmployee loginUser, Truck truck, TransportReturnTruckInfoResp response) {
        VendorTruck vendorTruck = vendorTruckService.loadByTruckId(truck.getTruckId(),loginUser);
        if( null == vendorTruck ){ return; }
        response.setVendorId(vendorTruck.getVendorId());
        Vendor vendor = vendorService.getVendor(vendorTruck.getVendorId());
        if( null == vendor ){ return; }
        response.setVendorId(vendor.getVendorId());
        response.setVendorName(vendor.getVendorName());
        response.setVendorType((int)vendor.getVendorType());
        response.setContactPhone(vendor.getContactPhone());
    }

    /**补充退车接收公司(运力输送-输送公司)信息**/
    private void fillFromDepartmentInfo(LoginEmployee loginUser, Truck truck, TransportReturnTruckInfoResp response) {
        if( TruckRunTypeEnum.JOIN.getCode().equals(truck.getTruckRunType()) ){
            response.setNeedReturn(false);
            return;
        }
        response.setNeedReturn(tslCommonService.hasVehicleNeedReturn(truck.getTruckIdentificationNo()));
        if( !response.isNeedReturn() ){ return; }

        Department department = getRemoteFromDepartment(loginUser,truck);

        if( null == department ){ return; }

        response.setFromDepartmentId(department.getDepartmentId());
        response.setFromDepartmentCode(department.getDepartmentCode());
        response.setFromDepartmentName(department.getDepartmentName());
        Tenant tenant = authCommonService.loadByTenantId(department.getTenantId());

        if( null == tenant ){ return; }

        response.setFromTenantId(tenant.getTenantId());
        response.setFromTenantCode(tenant.getTenantCode());
        response.setFromTenantName(tenant.getTenantName());
    }

    /**远程查询:车辆所有权公司**/
    private Department getRemoteFromDepartment(LoginEmployee loginUser, Truck truck) {
        VehicleOwnerDeptBo vehicleOwnerDeptBo = amsCommonService.getOwnVehicleBOByVehicleFrameNo(truck.getTruckIdentificationNo());
        return authCommonService.loadDepartment(vehicleOwnerDeptBo.getDepartmentCode(),new LoginUser(vehicleOwnerDeptBo.getTenantId(),loginUser.getUserId()));
    }


    @Override
    public Department findSuperCompany(Integer departmentId) throws BusinessException {
        if(departmentId == null){
            return null;
        }
        return departmentSupportService.findParentCompanyDepartment(departmentId);
    }
}
