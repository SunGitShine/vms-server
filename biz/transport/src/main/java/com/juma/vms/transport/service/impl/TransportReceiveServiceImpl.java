package com.juma.vms.transport.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.juma.auth.conf.domain.BusinessArea;
import com.juma.auth.employee.domain.Department;
import com.juma.auth.employee.domain.DepartmentBo;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.auth.employee.service.DepartmentService;
import com.juma.auth.support.service.DepartmentSupportService;
import com.juma.auth.tenant.domain.Tenant;
import com.juma.auth.user.domain.LoginUser;
import com.juma.auth.user.domain.User;
import com.juma.auth.user.service.UserService;
import com.juma.crm.customer.domain.CustomerInfo;
import com.juma.crm.support.domain.CustomerInfoFilters;
import com.juma.log.domain.OperationLogInfo;
import com.juma.server.vm.domain.bo.TenantVehicleBo;
import com.juma.tsl.common.CustomerTypeEnum;
import com.juma.tsl.domain.bo.CustomerInfoBO;
import com.juma.vms.common.Constants;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.driver.domain.Driver;
import com.juma.vms.driver.domain.DriverTenant;
import com.juma.vms.driver.service.DriverService;
import com.juma.vms.driver.service.DriverTenantService;
import com.juma.vms.mq.service.MqService;
import com.juma.vms.operateLog.service.OperateLogService;
import com.juma.vms.tool.domain.CrmCustomerInfo;
import com.juma.vms.tool.service.AmsCommonService;
import com.juma.vms.tool.service.AuthCommonService;
import com.juma.vms.tool.service.CrmCommonService;
import com.juma.vms.tool.service.MessageService;
import com.juma.vms.tool.service.TslCommonService;
import com.juma.vms.transport.dao.TransportCapacityItemMapper;
import com.juma.vms.transport.dao.TransportCapacityMapper;
import com.juma.vms.transport.domain.CapacityPool;
import com.juma.vms.transport.domain.TransportCapacity;
import com.juma.vms.transport.domain.TransportCapacityExample;
import com.juma.vms.transport.domain.TransportCapacityItem;
import com.juma.vms.transport.domain.TransportCapacityItemExample;
import com.juma.vms.transport.enumeration.ApprovalStatus;
import com.juma.vms.transport.enumeration.CustomerType;
import com.juma.vms.transport.enumeration.TransportType;
import com.juma.vms.transport.request.CompleteTransportReq;
import com.juma.vms.transport.request.TransportCustomerReq;
import com.juma.vms.transport.request.TransportFilter;
import com.juma.vms.transport.request.TransportItemFilter;
import com.juma.vms.transport.request.TransportReceivePageReq;
import com.juma.vms.transport.response.TransportBeforeAddVendorResp;
import com.juma.vms.transport.response.TransportReceiveDetailResp;
import com.juma.vms.transport.response.TransportReceivePageResp;
import com.juma.vms.transport.response.TransportReceiveResp;
import com.juma.vms.transport.service.CapacityPoolService;
import com.juma.vms.transport.service.TransportReceiveService;
import com.juma.vms.truck.domain.Truck;
import com.juma.vms.truck.domain.TruckTenant;
import com.juma.vms.truck.domain.bo.TruckResp;
import com.juma.vms.truck.enumeration.TruckRunTypeEnum;
import com.juma.vms.truck.enumeration.TruckStatusEnum;
import com.juma.vms.truck.service.TruckService;
import com.juma.vms.truck.service.TruckTenantService;
import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.domain.VendorDriver;
import com.juma.vms.vendor.domain.VendorTenant;
import com.juma.vms.vendor.domain.VendorTruck;
import com.juma.vms.vendor.enumeration.VendorSourceEnum;
import com.juma.vms.vendor.service.VendorDriverService;
import com.juma.vms.vendor.service.VendorService;
import com.juma.vms.vendor.service.VendorTenantService;
import com.juma.vms.vendor.service.VendorTruckService;
import com.juma.vms.vendor.vo.VendorFilter;
import com.juma.vms.vendor.vo.VendorQuery;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-19 17:30
 **/
@Service
public class TransportReceiveServiceImpl implements TransportReceiveService {

    private final static Logger log = LoggerFactory.getLogger(TransportReceiveServiceImpl.class);

    @Autowired
    private MqService mqService;
    @Autowired
    private TruckService truckService;

    @Autowired
    private VendorService vendorService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private CrmCommonService crmCommonService;

    @Autowired
    private TslCommonService tslCommonService;

    @Autowired
    private OperateLogService operateLogService;

    @Autowired
    private AuthCommonService authCommonService;

    @Autowired
    private TruckTenantService truckTenantService;

    @Autowired
    private VendorTruckService vendorTruckService;

    @Autowired
    private VendorDriverService vendorDriverService;

    @Autowired
    private VendorTenantService vendorTenantService;

    @Autowired
    private CapacityPoolService capacityPoolService;

    @Autowired
    private DriverTenantService driverTenantService;

    @Autowired
    private TransportCapacityMapper transportCapacityMapper;

    @Autowired
    private TransportCapacityItemMapper transportCapacityItemMapper;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private AmsCommonService amsCommonService;

    @Autowired
	private UserService userService;

    @Autowired
	private DepartmentSupportService departmentSupportService;

    /**根据客户名称或者客户证件号 查询客户列表**/
    @Override
    public List<CrmCustomerInfo> findTransportCustomers(TransportCustomerReq request, boolean useTenant, LoginEmployee loginUser) throws BusinessException {
        CustomerInfoFilters filters = new CustomerInfoFilters();
        if( StringUtils.isNotBlank(request.getCrmCustomerName()) ){
            filters.setCustomerName(request.getCrmCustomerName());
        }
        filters.setCustomerType(CustomerInfo.CustomerType.DRIVER.getValue());
        // credentialNo字段,允许传身份证或者企业信用代码
        if( StringUtils.isNotBlank(request.getCrmIdentityCardNo()) ){
            filters.setCredentialNo(request.getCrmIdentityCardNo());
        }

        if (useTenant) {
            filters.setTenantId(loginUser.getTenantId());
        }

        return crmCommonService.listByFilters(filters,request.getPageSize());
    }

    /**根据条件查询输送单列表**/
    @Override
    public List<TransportCapacity> findByFilter(TransportFilter filter, LoginEmployee loginUser) throws BusinessException {
        TransportCapacityExample example = new TransportCapacityExample().createCriteria()
                .andTransportIdEqualTo(filter.getTransportId())
                .andTransportIdIn(filter.getTransportIds())
                .andFromDepartmentIdEqualTo(filter.getFromDepartmentId())
                .andFromDepartmentIdIn(filter.getFromDepartmentIds())
                .andToDepartmentIdEqualTo(filter.getToDepartmentId())
                .andToDepartmentIdIn(filter.getToDepartmentIds())
                .example();
        return transportCapacityMapper.selectByExample(example);
    }

    /**根据条件查询输送单列表**/
    @Override
    public List<TransportCapacityItem> findItemByFilter(TransportItemFilter filter, LoginEmployee loginUser) throws BusinessException {
        TransportCapacityItemExample example = new TransportCapacityItemExample().createCriteria()
                .andTransportIdEqualTo(filter.getTransportId())
                .andTransportIdIn(filter.getTransportIds())
                .andTruckIdIn(filter.getTruckIds())
                .andItemIdEqualTo(filter.getItemId())
                .andItemIdIn(filter.getItemIds())
                .example();
        return transportCapacityItemMapper.selectByExample(example);
    }

    /**
     * 逻辑说明:
     * 1.参数校验
     * 2.传入条件(输送部门/接收部门),查询主表ID.
     * 3.传入条件(其他条件),查询详情表获得列表主数据
     * 4.拼接列表查询条件
     * 5.结果集数据补齐(主表信息)
     * 6.结果集数据补齐(部门信息)
     * 7.结果集数据补齐(客户信息)
     */
    @Override
    public Page<TransportReceivePageResp> findTransportReceivePage(QueryCond<TransportReceivePageReq> request, LoginEmployee loginUser) throws BusinessException {
        // 必传参数
        if(null == request || null == request.getFilters().getReceiveStatus()){
            throw new BusinessException("paramError", "errors.paramsError");
        }

        //默认查询登录部门上级子公司的下级部门的数据
        if(StringUtils.isBlank(request.getFilters().getToDepartmentCode())){
            Department superDepartment = departmentSupportService.findParentCompanyDepartment(loginUser.getLoginDepartment().getDepartmentId());
            if(superDepartment != null){
                request.getFilters().setToDepartmentCode(superDepartment.getDepartmentCode());
            }
        }

        Page<TransportReceivePageResp> response = new Page<>(request.getPageNo(), request.getPageSize(), 0, null);

        // 1.获取运力主表数据
        List<TransportCapacity> capacities = fetchCapacityCoreInfo(request, loginUser);

        // 如果没有主表数据,则不走后续逻辑
        if( CollectionUtils.isEmpty(capacities) ){
            return response;
        }
        // 运力主表映射词典:key=transportId
        Map<Integer,TransportCapacity> transportMaps = Maps.newHashMap();
        // 部门信息映射词典:key=departmentId
        Map<Integer,Department> departmentInfos = Maps.newHashMap();
        Map<Integer,Tenant> departmentTenantInfos = Maps.newHashMap();
        // 2.获取运力详情表数据
        List<TransportCapacityItem> capacityItems = fetchCapacityDetailInfo(request, transportMaps, departmentInfos, departmentTenantInfos, response, capacities);

        if(CollectionUtils.isEmpty(capacityItems) ){
            return response;
        }

        // 5.结果集数据补齐(客户信息)
        List<TransportReceivePageResp> responseCapacities = fillAdditionalData(transportMaps, departmentInfos, departmentTenantInfos, capacityItems);

        response.setResults(responseCapacities);
        return response;
    }

    @Override
    public TransportReceiveDetailResp findTransportReceiveDetail(Integer itemId, LoginEmployee loginUser) throws BusinessException {

        // 必传参数
        if( null == itemId ){
            throw new BusinessException("paramError", "errors.paramsError");
        }

        TransportReceiveDetailResp resp = new TransportReceiveDetailResp();

        TransportCapacityItem item = transportCapacityItemMapper.selectByPrimaryKey(itemId);
        if( null == item ){
            throw new BusinessException("paramError", "运力输送详细信息不存在");
        }

        TransportCapacity capacity = transportCapacityMapper.selectByPrimaryKey(item.getTransportId());
        if( null == capacity ){
            throw new BusinessException("paramError", "运力输送信息不存在");
        }

        Department fromDepartment = authCommonService.loadDepartment(capacity.getFromDepartmentId());
        if( null == fromDepartment ){
            throw new BusinessException("paramError", "输送部门不存在");
        }
        Department toDepartment = authCommonService.loadDepartment(capacity.getToDepartmentId());
        if( null == toDepartment ){
            throw new BusinessException("paramError", "接收部门不存在");
        }

        TruckResp truckResp = truckService.getTruckDetail(item.getTruckId(),loginUser);
        if( null == truckResp ){
            throw new BusinessException("paramError", "车辆信息不存在");
        }

        Tenant fromTenant = authCommonService.loadByTenantId(fromDepartment.getTenantId());
        if( null == fromTenant ){
            throw new BusinessException("paramError", "输送部门租户信息不存在");
        }
        Tenant toTenant = authCommonService.loadByTenantId(toDepartment.getTenantId());
        if( null == toTenant ){
            throw new BusinessException("paramError", "接收部门租户信息不存在");
        }

        // 卡车信息
        resp.setTruckResp(truckResp);

        resp.setTransportNo(capacity.getTransportNo());
        resp.setTransportType(capacity.getTransportType());
        resp.setFromDepartmentName(fromDepartment.getDepartmentName());
        resp.setToDepartmentName(toDepartment.getDepartmentName());

        if( null != item.getCrmCustomerId() ){ // 自营车,输入运力系统,可以没有客户ID
            CustomerInfoBO customer = tslCommonService.getCustomerByVehicleFrameNo(item.getTruckIdentificationNo());
            if( null != customer ){
                resp.setCrmCustomerName(customer.getCustomerName());
                resp.setCrmCustomerType(CustomerType.getCodeByScmCode(customer.getCustomerIdentityType()));
                resp.setCrmMobileNumber(customer.getCustomerPhone());
                resp.setCrmIdentityCardNo(customer.getCustomerIdNumber());
            }
        }

        // 增加租户名称字段
        resp.setFromTenantName(fromTenant.getTenantName());
        resp.setToTenantName(toTenant.getTenantName());

		User user = userService.loadUser(capacity.getCreateUserId());
		if(user != null){
			resp.setCreateName(user.getName());
		}
		resp.setAttachUrl(capacity.getAttachUrl());
        return resp;
    }

    /**
     * 接收运力:
     * 在运力详情的基础上,增加:车辆类型,是否是承运商,是否有承运商字段
     * @param itemId
     * @param loginUser
     * @return
     * @throws BusinessException
     */
    @Override
    public TransportReceiveResp receiveTransportInfo(Integer itemId, LoginEmployee loginUser) throws BusinessException {
        // 必传参数
        if( null == itemId ){
            throw new BusinessException("paramError", "errors.paramsError");
        }

        TransportReceiveResp resp = new TransportReceiveResp();

        TransportCapacityItem item = transportCapacityItemMapper.selectByPrimaryKey(itemId);
        if( null == item ){
            throw new BusinessException("paramError", "运力输送详细信息不存在");
        }
        TransportCapacity capacity = transportCapacityMapper.selectByPrimaryKey(item.getTransportId());
        if( null == capacity ){
            throw new BusinessException("paramError", "运力输送信息不存在");
        }
        Department fromDepartment = authCommonService.loadDepartment(capacity.getFromDepartmentId());
        if( null == fromDepartment ){
            throw new BusinessException("paramError", "输送部门不存在");
        }
        Department toDepartment = authCommonService.loadDepartment(capacity.getToDepartmentId());
        if( null == toDepartment ){
            throw new BusinessException("paramError", "接收部门不存在");
        }
        TruckResp truckResp = truckService.getTruckDetail(item.getTruckId(),loginUser);
        if( null == truckResp ){
            throw new BusinessException("paramError", "车辆信息不存在");
        }

        // 卡车信息
        resp.setTruckResp(truckResp);

        resp.setCrmCustomerId(item.getCrmCustomerId());
        resp.setTransportNo(capacity.getTransportNo());
        resp.setTransportType(capacity.getTransportType());
        resp.setFromDepartmentName(fromDepartment.getDepartmentName());
        resp.setToDepartmentId(toDepartment.getDepartmentId());
        resp.setToDepartmentName(toDepartment.getDepartmentName());

        DepartmentBo departmentBo = authCommonService.findDepartmentBo(toDepartment.getDepartmentId(),loginUser);
        if( null != departmentBo && !CollectionUtils.isEmpty(departmentBo.getBusinessAreas()) ){
            List<String> areas = Lists.newArrayList();
            for (BusinessArea area : departmentBo.getBusinessAreas()) {
                areas.add(area.getAreaCode());
            }
            resp.setToDepartmentAreas(areas);
        }

        resp.setTruckRunType(truckResp.getTruckRunType()); // 车辆类型:1自营/2加盟
        if( TruckRunTypeEnum.OWN_SALE.getCode().equals(truckResp.getTruckRunType()) ){
            if( null != item.getCrmCustomerId() ){ // 如果有客户ID,则到TSL系统查询对应的客户信息
                setTransportCustomerInfo(resp, item);
            }
            // 校验并设置是否有承运商
            validHasVendor(loginUser, resp, capacity);
        }
        if( TruckRunTypeEnum.JOIN.getCode().equals(truckResp.getTruckRunType()) ){
            if( null == item.getCrmCustomerId() ){
                throw new BusinessException("paramError", "输送单无对应客户信息");
            }
            CustomerInfoBO customer = setTransportCustomerInfo(resp, item);
            // 校验并设置是否是承运商
            validBeVendor(loginUser, resp, customer);
        }
        return resp;
    }

    @Override
    public void completeTransport(final CompleteTransportReq request, final LoginEmployee loginUser) throws BusinessException {
        validComplateParams(request);
        final Truck truck = truckService.getTruck(request.getTruckId());
        if( null == truck ){
            throw new BusinessException("truckTenantNotExistError", "客车信息不存在");
        }

        final Vendor vendor = vendorService.getVendor(request.getVendorId());
        if( null == vendor ){
            throw new BusinessException("vendorNotExistError", "承运商不存在");
        }

        // 2.当前承运商类型为【自营】的更新司机类型为【自营】，承运类型为【非自营】的设置司机类型为【非自营;// 1.自营;2.非自营;
        Driver driver = freshDriverRunType(request,truck,vendor,loginUser);

        // 承运商和司机建立关系
        buildRelationInVendorAndDriver(request, vendor, driver, loginUser);

        // 卡车和承运商建立关系
        buildRelationInVendorAndTruck(request, truck, vendor, loginUser);

        // 更新运力接收状态
        TransportCapacityItem item = freshTransportReceiveStatus(request);

        List<VendorTenant> vendorTenants = vendorTenantService.listVendorTenantByVendorId(request.getVendorId());
        VendorTenant vendorTenant = vendorTenantService.loadByVendorId(request.getVendorId(),loginUser);
        if( CollectionUtils.isEmpty(vendorTenants) ){
            throw new BusinessException("vendorTenantNotExistError", "承运商没有关联任何租户");
        }
        if( null == vendorTenant ){
            // 承运商和租户建立关系
            vendorTenant = buildRelationInVendorAndTenant(request,item,vendorTenants,loginUser);
        }

        // 更新卡车业务范围+认领公司+车辆状态
        freshTruckAreaAndCompany(request, vendorTenant, item, loginUser);

        // 更新运力池表:完善运力信息,形成有效运力
        finishCapacityPool(request, truck, vendor, driver, vendorTenant, loginUser);

        // 短息通知承运商和司机
        notifyVendorAndDriver(request, truck, vendor, driver, loginUser);

        //通知AMS认领公司变更信息
        TruckTenant truckTenant = truckTenantService.getByTruckId(truck.getTruckId(), loginUser);
        sendInformToAms(truck.getTruckIdentificationNo(), truckTenant.getTruckBelongToCompany(), loginUser);
    }

    private void sendInformToAms(String identificationNo, Integer departmentId, LoginUser loginUser){
        Department department = departmentService.loadDepartment(departmentId);
        TenantVehicleBo tenantVehicleBo = new TenantVehicleBo();
        tenantVehicleBo.setVehicleFrameNo(identificationNo);
        tenantVehicleBo.setDepartmentCode(department.getDepartmentCode());
        tenantVehicleBo.setTenantId(loginUser.getTenantId());
        tenantVehicleBo.setUserId(loginUser.getUserId());
        amsCommonService.changeCompany2Ams(tenantVehicleBo);
    }

    /**司机被运力池中其他运力(比如外请运力)绑定,则不能再绑定新的运力**/
    private void validTruckDriverRelationUnique(CompleteTransportReq request,LoginEmployee loginUser) {
        CapacityPool pool = capacityPoolService.loadCapacityPoolByDriverId(request.getDriverId(),loginUser);

        if( null != pool && !request.getTruckId().equals(pool.getTruckId())){
            throw new BusinessException("driverTruckRelationExistError", "该司机已被其他运力绑定,请选择其他司机.");
        }

        if( null != pool && !request.getVendorId().equals(pool.getVendorId()) ){
            throw new BusinessException("driverVendorPoolRelationExistError", "该司机已被其他运力绑定,请选择其他司机.");
        }

        if( null == pool ){
            VendorDriver vendorDriver = vendorDriverService.loadByDriverId(request.getDriverId(),loginUser);
            if( null != vendorDriver && !vendorDriver.getVendorId().equals(request.getVendorId()) ){
                throw new BusinessException("driverVendorRelationExistError", "该司机已被其他运力绑定,请选择其他司机.");
            }
        }
    }

    /**承运商和租户建立关系**/
    private VendorTenant buildRelationInVendorAndTenant(CompleteTransportReq request, TransportCapacityItem item, List<VendorTenant> vendorTenants, LoginEmployee loginUser) {
        VendorTenant vendorTenant = new VendorTenant();
        vendorTenant.setVendorId(request.getVendorId());
        vendorTenant.setTenantId(loginUser.getTenantId());
        vendorTenant.setTenantCode(loginUser.getTenantCode());
        vendorTenant.setAreaCode(request.getAreaCode());
        vendorTenant.setIsOwner(Byte.valueOf("0"));
        vendorTenant.setIsEnable(true);
        vendorTenantService.insert(vendorTenant,loginUser);
        return vendorTenant;
    }

    /**
     * 功能:添加承运商之前,需要加载的部分信息
     * 参数:
     * crmCustomerId 客户ID
     * 返回结果:
     * crmCustomerType(个人/公司)
     * crmCustomerName(客户名称==承运商名称)
     * 个人:
     * 	crmIdentificationCard(身份证号)
     * 	联系人(客户名称)
     * 	联系电话(客户电话)
     * 公司:
     * 	crmCreditCode(客户(公司)信用代码)
     * 	运营方式(默认:非自营)
     * 	业务范围(客户对应的业务范围)
     */
    @Override
    public TransportBeforeAddVendorResp beforeAddVendor(String truckIdentificationNo, LoginEmployee loginUser) throws BusinessException {
        TransportBeforeAddVendorResp resp = new TransportBeforeAddVendorResp();
        CustomerInfoBO customer = findCustomerByTruckIdentificationNo(truckIdentificationNo);
        // 根据承运商身份证号,查询是否有对应的司机
        Driver driver = driverService.loadByIdCardNo(customer.getCustomerIdNumber(),loginUser);
        if( null != driver ){
            DriverTenant driverTenant = driverTenantService.loadByDriverId(driver.getDriverId(),loginUser);
            resp.setBeCurrDriver(null != driverTenant); // true 属于当前租户
            resp.setDriverId(driver.getDriverId());
        }

        resp.setCrmCustomerName(customer.getCustomerName());
        resp.setCrmCustomerType(CustomerType.getCodeByScmCode(customer.getCustomerIdentityType()));
        resp.setContactPhone(customer.getCustomerPhone());
        resp.setCrmIdentityCardNo(customer.getCustomerIdNumber());

        return resp;
    }

    /**设置运力客户信息**/
    private CustomerInfoBO setTransportCustomerInfo(TransportReceiveResp resp, TransportCapacityItem item) {
        // 客户信息
        CustomerInfoBO customer = findCustomerByTruckIdentificationNo(item.getTruckIdentificationNo());
        resp.setCrmCustomerId(customer.getCustomerId());
        resp.setCrmCustomerName(customer.getCustomerName());
        resp.setCrmCustomerType(CustomerType.getCodeByScmCode(customer.getCustomerIdentityType()));
        resp.setCrmCustomerTypeName(CustomerType.getDescByCode(resp.getCrmCustomerType()));
        resp.setCrmMobileNumber(customer.getCustomerPhone());
        resp.setCrmIdentityCardNo(customer.getCustomerIdNumber());
        return customer;
    }

    /**
     * 1.校验并设置是否是承运商
     * 2.设置司机ID
     */
    private void validBeVendor(LoginUser loginUser, TransportReceiveResp resp, CustomerInfoBO customer) {
        Vendor vendor = null;
        String idCardNo = customer.getCustomerIdNumber();

        // 根据承运商身份证号,查询是否有对应的司机
        Driver driver = driverService.loadByIdCardNo(idCardNo,loginUser);
        if( null != driver ){
            resp.setDriverId(driver.getDriverId());
        }

        if( CustomerTypeEnum.INDIVIDUAL.getCode().equals(customer.getCustomerType()) ){// 客户 具体值待定
            vendor = vendorService.loadByIdCardNo(idCardNo,Byte.valueOf("1"));
            if( null == vendor && StringUtils.isNotBlank(customer.getCustomerPhone()) ){
                vendor = vendorService.loadByPhone(customer.getCustomerPhone(),Byte.valueOf("1"));
            }
        }else if( CustomerTypeEnum.ENTERPRISE.getCode().equals(customer.getCustomerType()) ){ //公司 具体值待定
            vendor = vendorService.loadByEnterpriseCode(idCardNo,Byte.valueOf("1"));
            if( null == vendor && StringUtils.isNotBlank(customer.getCustomerPhone())){
                vendor = vendorService.loadByPhone(customer.getCustomerPhone(),Byte.valueOf("1"));
            }
        }

        // 是否是承运商
        resp.setBeVendor(null != vendor);

        // 承运商ID设置
        if( null == vendor ){ return; }

        resp.setVendorId(vendor.getVendorId());
    }

    /**校验并设置是否有承运商**/
    private void validHasVendor(LoginUser loginUser, TransportReceiveResp resp, TransportCapacity capacity) {
        DepartmentBo departmentBo = authCommonService.findDepartmentBo(capacity.getToDepartmentId(),loginUser);
        // 根据部门ID,查询部门服务范围(CRM接口)
        List<BusinessArea> areas = departmentBo.getBusinessAreas();
        List<String> areaCodes = Lists.newArrayList();
        for ( BusinessArea area : areas ) {
            areaCodes.add(area.getAreaCode());
        }
        VendorFilter filter = new VendorFilter();
        filter.setAreaCodeList(areaCodes);
        filter.setTenantId(loginUser.getTenantId());
        filter.setVendorSource(VendorSourceEnum.SELF_SUPPORT.getCode());
        List<VendorQuery> vendorQuerys = vendorService.listByVendorFilter(filter,1,loginUser);
        resp.setHasVendor(!CollectionUtils.isEmpty(vendorQuerys));
    }

    /**根据车架号查询客户信息**/
    private CustomerInfoBO findCustomerByTruckIdentificationNo(String truckIdentificationNo){
        CustomerInfoBO customer = tslCommonService.getCustomerByVehicleFrameNo(truckIdentificationNo);
        if( null == customer ){
            throw new BusinessException("beforeAddVendorNotExistError", "TSL客户信息不存在");
        }
        if( StringUtils.isBlank(customer.getCustomerIdNumber()) ){
            throw new BusinessException("beforeAddVendorNotExistError", "TSL客户信息不完整,缺少证件号");
        }
        return customer;
    }

    private void finishCapacityPool(CompleteTransportReq request, Truck truck, Vendor vendor, Driver driver, VendorTenant vendorTenant, LoginEmployee loginUser) {
        CapacityPool pool = capacityPoolService.loadCapacityPoolByTruckId(request.getTruckId(),loginUser);
        if( null == pool ){
            throw new BusinessException("capacityPoolNotExistError", "异常情况:运力池中无对应的运力数据,更新失败");
        }
        if( null != pool.getVendorId() ){
            throw new BusinessException("vendorIdExistError", "异常情况:运力池中运力已绑定承运商,更新失败");
        }
        if( null != pool.getDriverId() ){
            throw new BusinessException("driverIdExistError", "异常情况:运力池中运力已绑定司机,更新失败");
        }
        if( pool.getStatus() ){
            throw new BusinessException("statusCanUseError", "异常情况:运力池中运力已处于可用状态,更新失败");
        }
        pool.setVendorId(vendor.getVendorId());
        pool.setDriverId(request.getDriverId());
        pool.setAreaCode(vendorTenant.getAreaCode());
        pool.setStatus(null != driver);
        capacityPoolService.update(pool);
        if( null != driver ){ //自营车辆,可以没有司机,这里如果有,则需要记录
            logTruckDriverBind(request, driver, loginUser);
        }
    }

    /**like参数非空判断**/
    private String transferLikeParam(String identificationNo) {
        if( StringUtils.isNotBlank(identificationNo) ){
            identificationNo = identificationNo+"%";
        }
        return identificationNo;
    }

    private void validComplateParams(CompleteTransportReq request) {
        if( null == request.getItemId() ){
            throw new BusinessException("paramError", "退车单ID不能为空");
        }
        if( null == request.getVendorId() ){
            throw new BusinessException("paramError", "承运商ID不能为空");
        }
        if( null == request.getTruckId() ){
            throw new BusinessException("paramError", "车辆ID不能为空");
        }
    }

    /**短息通知承运商和司机**/
    private void notifyVendorAndDriver(CompleteTransportReq request, final Truck truck, final Vendor vendor, final Driver driver, final LoginEmployee loginUser) {
        // 	4.2.向司机发送短信(司机电话+司机名字)
        if( null != driver && StringUtils.isNotBlank(driver.getPhone()) ){
            log.info("短信通知司机:开始");
            Map<String,Object> params = Maps.newHashMap();
            params.put("driverName",driver.getName());
            params.put("plateNumber",truck.getPlateNumber());
            messageService.pushSmsMessage(loginUser,Constants.MESSAGE_COMPLETE_TRANSPORT_DRIVER,params,driver.getPhone());
        }
        // 4.发送短信:
        // 	4.1.向承运商发送短信(承运商电话+承运商名字)
        if(StringUtils.isNotBlank(vendor.getContactPhone()) ){
            log.info("短信通知承运商:开始");
            Map<String,Object> params = Maps.newHashMap();
            params.put("vendorName",vendor.getVendorName());
            params.put("plateNumber",truck.getPlateNumber());
            messageService.pushSmsMessage(loginUser,Constants.MESSAGE_COMPLETE_TRANSPORT_VENDOR,params,vendor.getContactPhone());
        }
    }

    /**卡车和承运商建立关系**/
    private void buildRelationInVendorAndTruck(CompleteTransportReq request, Truck truck, Vendor vendor, LoginEmployee loginUser) {
        VendorTruck oldVendorTruck = vendorTruckService.loadByTruckId(request.getTruckId(),loginUser);
        if( null != oldVendorTruck && !oldVendorTruck.getVendorId().equals(request.getVendorId()) ){
            // 这里不提示异常情况,而是清理历史数据,并增加新的数据
            vendorTruckService.clearRelationInfoAfterReturn(request.getTruckId(),oldVendorTruck.getVendorId(),oldVendorTruck.getTenantId());
            oldVendorTruck = null; // 清空数据, 走新建关联关系逻辑.
        }
        if( null == oldVendorTruck ){
            // 关联承运商+车辆
            VendorTruck vendorTruck = new VendorTruck();
            vendorTruck.setTenantId(loginUser.getTenantId());
            vendorTruck.setTenantCode(loginUser.getTenantCode());
            vendorTruck.setVendorId(request.getVendorId());
            vendorTruck.setTruckId(request.getTruckId());
            vendorTruckService.insert(vendorTruck,loginUser);
            logTruckVendorBind(request,truck,vendor,loginUser);
        }
    }

    /**建立司机和承运商的关系**/
    private void buildRelationInVendorAndDriver(CompleteTransportReq request, Vendor vendor, Driver driver, LoginEmployee loginUser) {

        if( null == driver ){ return; }

        VendorDriver oldVendorDriver = vendorDriverService.loadByDriverId(request.getDriverId(),loginUser);
        if( null != oldVendorDriver && !oldVendorDriver.getVendorId().equals(request.getVendorId()) ){
            throw new BusinessException("driverTenantNotExistError", "当前司机已有承运商，请重新选择司机或到 司机管理>中更换为当前承运商后再选择");
        }

        if( null == oldVendorDriver ){ //新增司机和承运商的关联关系
            // 关联承运商+司机
            VendorDriver vendorDriver = new VendorDriver();
            vendorDriver.setVendorId(request.getVendorId());
            vendorDriver.setDriverId(request.getDriverId());
            vendorDriver.setTenantId(loginUser.getTenantId());
            vendorDriver.setTenantCode(loginUser.getTenantCode());
            vendorDriverService.insert(vendorDriver,loginUser);
            logDriverVendorBind(request, vendor, loginUser);
        }
    }

    /**更新卡车业务范围+认领公司**/
    private void freshTruckAreaAndCompany(CompleteTransportReq request, VendorTenant vendorTenant, TransportCapacityItem item, LoginEmployee loginUser) {
        // 1.更新当前车辆的业务范围设置为承运商的业务范围
        TruckTenant truckTenant = truckTenantService.getByTruckId(request.getTruckId(),loginUser);
        if( null == truckTenant ){
            throw new BusinessException("truckTenantNotExistError", "当前租户没有关联的卡车");
        }
        TransportCapacity capacity = transportCapacityMapper.selectByPrimaryKey(item.getTransportId());
        truckTenant.setTruckBelongToCompany(capacity.getToDepartmentId());
        truckTenant.setAreaCode(vendorTenant.getAreaCode());
        truckTenant.setStatus(TruckStatusEnum.ENABLE.getCode());
        truckTenantService.update(truckTenant,loginUser);
    }

    /**更新运力接收状态**/
    private TransportCapacityItem freshTransportReceiveStatus(CompleteTransportReq request) {
        TransportCapacityItem item = transportCapacityItemMapper.selectByPrimaryKey(request.getItemId());
        item.setItemId(request.getItemId());
        item.setStatus(true);
        transportCapacityItemMapper.updateByPrimaryKeySelective(item);
        return item;
    }

    /**更新司机运营类型**/
    private Driver freshDriverRunType(CompleteTransportReq request,Truck truck,Vendor vendor,LoginEmployee loginUser) {
        // 加盟车,司机不能没有,司机电话也不能为空
        if( null == request.getDriverId() && TruckRunTypeEnum.JOIN.getCode().equals(truck.getTruckRunType()) ){
            throw new BusinessException("driverTenantNotExistError", "加盟车,不能没有司机");
        }

        if( null == request.getDriverId() ){ return null; }

        final Driver driver = driverService.loadDriverById(request.getDriverId());
        if( TruckRunTypeEnum.JOIN.getCode().equals(truck.getTruckRunType()) ){
            if( null == driver ){
                throw new BusinessException("driverTenantNotExistError", "司机信息不存在");
            }
            if( StringUtils.isBlank(driver.getPhone()) ){
                throw new BusinessException("driverTenantNotExistError", "司机电话号码未设置");
            }
        }

        if( null == driver ){ return null; }

        // 1.判断司机是否有关联其他车辆
        validTruckDriverRelationUnique(request,loginUser);

        // 2.当前承运商类型为【自营】的更新司机类型为【自营】，承运类型为【非自营】的设置司机类型为【非自营;// 1.自营;2.非自营;
        driver.setDriverRunType(Integer.valueOf(vendor.getVendorSource()));
        driverService.updateDriver(driver,loginUser);
        mqService.sendAfterDriverUpdate(driver,"更改司机运营类型");
        return driver;
    }

    /**绑定承运商:日志记录**/
    private void logTruckVendorBind(final CompleteTransportReq request, final Truck truck, final Vendor vendor, final LoginEmployee loginUser) {
        log.info("绑定承运商:日志记录,开始");
        OperationLogInfo info = new OperationLogInfo();
        info.setMethodName("com.juma.vms.transport.service.impl.TransportReceiveServiceImpl.logTruckVendorBind");
        Map<String,Object> params = Maps.newConcurrentMap();
        params.put("truckId",request.getTruckId());
        params.put("remark","承运商:"+vendor.getVendorName()+" 证件号:"+vendor.getIdCardNo());
        info.setParam(JSON.toJSONString(params));
        operateLogService.writelog(info, loginUser);
        log.info("车辆绑定承运商:日志记录,结束");
    }

    /**车辆绑定司机:日志记录**/
    private void logTruckDriverBind(CompleteTransportReq request, Driver driver, LoginEmployee loginUser) {
        log.info("绑定承运商:日志记录,开始");
        OperationLogInfo info = new OperationLogInfo();
        info.setMethodName("com.juma.vms.transport.service.impl.TransportReceiveServiceImpl.logTruckDriverBind");
        Map<String,Object> params = Maps.newConcurrentMap();
        params.put("truckId",request.getTruckId());
        params.put("remark","司机:"+driver.getName()+" 证件号:"+driver.getIdCardNo());
        info.setParam(JSON.toJSONString(params));
        operateLogService.writelog(info, loginUser);
        log.info("车辆绑定司机:日志记录,结束");
    }

    /**绑定司机:日志记录**/
    private void logDriverVendorBind(final CompleteTransportReq request, final Vendor vendor, final LoginEmployee loginUser) {
        log.info("绑定司机:日志记录,开始");
        OperationLogInfo info = new OperationLogInfo();
        info.setMethodName("com.juma.vms.transport.service.impl.TransportReceiveServiceImpl.logDriverVendorBind");
        Map<String,Object> params = Maps.newConcurrentMap();
        params.put("driverId",request.getDriverId());
        params.put("remark","承运商:"+vendor.getVendorName()+" 证件号:"+vendor.getIdCardNo());
        info.setParam(JSON.toJSONString(params));
        operateLogService.writelog(info, loginUser);
        log.info("司机绑定承运商:日志记录,结束");
    }

    /**5.结果集数据补齐(客户信息)**/
    private List<TransportReceivePageResp> fillAdditionalData(Map<Integer, TransportCapacity> transportMaps, Map<Integer, Department> departmentInfos, Map<Integer, Tenant> departmentTenantInfos, List<TransportCapacityItem> transportCapacityItems) {
        // 6.因为目前外部的接口是单条查询,因此客户信息,在for循环里边循环调用
        List<TransportReceivePageResp> responseCapacities = Lists.newArrayList();
        for ( TransportCapacityItem item : transportCapacityItems ) {
            TransportReceivePageResp resp = new TransportReceivePageResp();
            resp.setTransportCapacityItem(item);
            resp.setCrmCustomerId(item.getCrmCustomerId());
            if( !CollectionUtils.isEmpty(transportMaps) ){
                TransportCapacity capacity = transportMaps.get(item.getTransportId());
                resp.setTransportNo(capacity.getTransportNo());
                resp.setTransportType(capacity.getTransportType());
                resp.setProcessInstanceId(capacity.getProcessInstanceId());
                resp.setTransportTypeName(TransportType.getDescByCode(capacity.getTransportType()));
                // 设置部门名称
                Department fromDepartment = departmentInfos.get(capacity.getFromDepartmentId());
                if( null != fromDepartment ){
                    resp.setFromDepartmentName(fromDepartment.getDepartmentName());
                    Tenant fromTenant = departmentTenantInfos.get(fromDepartment.getDepartmentId());
                    if( null != fromTenant ){
                        resp.setFromTenantName(fromTenant.getTenantName());
                    }
                }
                Department toDepartment = departmentInfos.get(capacity.getToDepartmentId());
                if( null != toDepartment ){
                    resp.setToDepartmentName(toDepartment.getDepartmentName());
                    Tenant toTenant = departmentTenantInfos.get(toDepartment.getDepartmentId());
                    if( null != toTenant ){
                        resp.setToTenantName(toTenant.getTenantName());
                    }
                }
            }

            Truck truck = truckService.getTruck(item.getTruckId());
            if( null != truck ){
                resp.setTruckType(truck.getTruckRunType());
                resp.setTruckTypeName(TruckRunTypeEnum.getDescByCode(truck.getTruckRunType()));
            }

            if( null != item.getCrmCustomerId() ){ // 自营车,输入运力系统,可以没有客户ID
                CustomerInfoBO customer = tslCommonService.getCustomerByVehicleFrameNo(item.getTruckIdentificationNo());
                if( null != customer ){
                    resp.setCrmCustomerId(item.getCrmCustomerId());
                    resp.setCrmCustomerName(customer.getCustomerName());
                    resp.setCrmMobileNumber(customer.getCustomerPhone());
                    resp.setCrmIdentityCardNo(customer.getCustomerIdNumber());
                }
            }

            responseCapacities.add(resp);
        }
        return responseCapacities;
    }

    /**获取运力详情表数据**/
    private List<TransportCapacityItem> fetchCapacityDetailInfo(QueryCond<TransportReceivePageReq> request, Map<Integer, TransportCapacity> transportMaps, Map<Integer, Department> departmentInfos, Map<Integer, Tenant> departmentTenantInfos, Page<TransportReceivePageResp> response, List<TransportCapacity> transportCapacities) {
        // 部门ID集合
        Set<Integer> departmentIds = new HashSet<>();
        // 运力ID集合
        List<Integer> transportIds = Lists.newArrayList();
        // 2.拼接列表查询条件
        if( !CollectionUtils.isEmpty(transportCapacities) ){
            for (TransportCapacity capacity : transportCapacities) {
                transportIds.add(capacity.getTransportId());
                departmentIds.add(capacity.getToDepartmentId());
                departmentIds.add(capacity.getFromDepartmentId());
                transportMaps.put(capacity.getTransportId(),capacity);
            }
        }
        // 3.结果集数据补齐(部门信息)
        if( !CollectionUtils.isEmpty(departmentIds) ){
            for (Integer departmentId : departmentIds) {
                Department department = authCommonService.loadDepartment(departmentId);
                if( null == department ){ continue; }
                departmentInfos.put(departmentId,department);
                Tenant tenant = authCommonService.loadByTenantId(department.getTenantId());
                if( null != tenant ){
                    departmentTenantInfos.put(departmentId,tenant);
                }
            }
        }

        TransportCapacityItemExample example = new TransportCapacityItemExample().createCriteria()
                .andStatusEqualTo(request.getFilters().getReceiveStatus() == 1)
                .andPlateNumberLike(transferLikeParam(request.getFilters().getPlateNumber()))
                .andTruckIdentificationNoLike(transferLikeParam(request.getFilters().getTruckIdentificationNo()))
                .andCrmCustomerIdEqualTo(request.getFilters().getCrmCustomerId())
                .andTransportIdIn(transportIds)
                .example();

        long count = transportCapacityItemMapper.countByExample(example);
        if(count == 0){ return Lists.newArrayList(); }
        response.setTotal((int)count);

        example.setStartOffSet(request.getStartOffset());
        example.setSize(request.getPageSize());
        example.setOrderByClause(TransportCapacityItem.Column.createTime.desc() +","+ TransportCapacityItem.Column.itemId.desc());

        return transportCapacityItemMapper.selectByExample(example);
    }

    /**获取运力主表数据**/
    private List<TransportCapacity> fetchCapacityCoreInfo(QueryCond<TransportReceivePageReq> request, LoginEmployee loginUser) {
        TransportCapacityExample transportExample = new TransportCapacityExample().createCriteria()
                .andFromDepartmentIdEqualTo(request.getFilters().getFromDepartmentId())
//                .andToDepartmentIdEqualTo(request.getFilters().getToDepartmentId())
                .andToDepartmentCodeLike(request.getFilters().getToDepartmentCode()+"%")
                .andApprovalStatusEqualTo(ApprovalStatus.APPROVAL_AGREE.getCode())
                .andReceiveTenantIdEqualTo(loginUser.getTenantId())
                .example();

        return transportCapacityMapper.selectByExample(transportExample);
    }
}
