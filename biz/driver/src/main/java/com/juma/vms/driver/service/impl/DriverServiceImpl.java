package com.juma.vms.driver.service.impl;

import com.alibaba.fastjson.JSON;
import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.google.common.collect.Lists;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.auth.tenant.domain.Tenant;
import com.juma.auth.user.domain.LoginUser;
import com.juma.auth.user.domain.User;
import com.juma.auth.user.service.UserService;
import com.juma.tgm.truck.service.TruckTypeService;
import com.juma.vms.common.BaseUtil;
import com.juma.vms.common.Constants;
import com.juma.vms.common.idcard.validator.IDValidatorUtils;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.driver.dao.DriverMapper;
import com.juma.vms.driver.dao.DriverTenantMapper;
import com.juma.vms.driver.dao.ext.DriverExtMapper;
import com.juma.vms.driver.domain.Driver;
import com.juma.vms.driver.domain.DriverExample;
import com.juma.vms.driver.domain.DriverTenant;
import com.juma.vms.driver.domain.DriverTenantExample;
import com.juma.vms.driver.enumeration.DriverTypeEnum;
import com.juma.vms.driver.enumeration.RemindSwitchType;
import com.juma.vms.driver.enumeration.RemindSwitchValue;
import com.juma.vms.driver.external.DriverExternalFilter;
import com.juma.vms.driver.service.DriverService;
import com.juma.vms.driver.service.DriverTenantService;
import com.juma.vms.driver.vo.DriverBo;
import com.juma.vms.driver.vo.DriverIdentification;
import com.juma.vms.driver.vo.DriverQuery;
import com.juma.vms.external.service.VmsService;
import com.juma.vms.mq.service.MqService;
import com.juma.vms.tool.domain.SmsCode;
import com.juma.vms.tool.service.*;
import com.juma.vms.transport.domain.CapacityPool;
import com.juma.vms.transport.request.CapacityPoolFilter;
import com.juma.vms.transport.service.TransportService;
import com.juma.vms.truck.domain.Truck;
import com.juma.vms.truck.domain.TruckTenant;
import com.juma.vms.truck.service.TruckService;
import com.juma.vms.truck.service.TruckTenantService;
import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.domain.VendorDriver;
import com.juma.vms.vendor.domain.VendorTenant;
import com.juma.vms.vendor.enumeration.VendorSourceEnum;
import com.juma.vms.vendor.enumeration.VendorTypeEnum;
import com.juma.vms.vendor.service.VendorDriverService;
import com.juma.vms.vendor.service.VendorTenantService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Title: DriverServiceImpl
 * Description:司机管理
 * Created by gzq on 2019/3/19.
 */

@Service
public class DriverServiceImpl implements DriverService {

    private static final Logger log = LoggerFactory.getLogger(DriverService.class);

    private final static Integer DRIVER_VENDOR_TRUCK_FILTER = 1;
    private final static Integer DRIVER_AREACODE_FILTER = 2;
    private final static Integer DRIVER_VENDOR_FILTER = 3;

    @Autowired
    private MqService mqService;
    @Autowired
    private DriverMapper driverMapper;
    @Autowired
    private DriverTenantMapper driverTenantMapper;
    @Autowired
    private DriverExtMapper driverExtMapper;
    @Autowired
    private BusinessAreaCommonService businessAreaCommonService;
    @Autowired
    private DriverTenantService driverTenantService;
    @Autowired
    private VendorDriverService vendorDriverService;
    @Autowired
    private VmsService vmsService;
    @Autowired
    private AuthCommonService authCommonService;
    @Autowired
    private ThirdpartyCommonService thirdpartyCommonService;
    @Autowired
    private TruckTenantService truckTenantService;
    @Autowired
    private VendorTenantService vendorTenantService;
    @Autowired
    private TransportService transportService;
    @Autowired
    private TruckService truckService;
    @Autowired
    private TruckTypeService truckTypeService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;
    @Autowired
    private MdcCommonService mdcCommonService;

    @Override
    public Page<DriverQuery> search(QueryCond<DriverQuery> queryCond, LoginUser loginUser) {
        if (null == loginUser || null == loginUser.getTenantId()) {
            return new Page<>(queryCond.getPageNo(), queryCond.getPageSize(), 0, new ArrayList<DriverQuery>());
        }

        queryCond.getFilters().setTenantId(loginUser.getTenantId());

        int total = driverExtMapper.searchCount(queryCond);
        List<DriverQuery> rows = driverExtMapper.search(queryCond);
        for (DriverQuery query : rows) {
            query.setAreaName(businessAreaCommonService.loadLogicAndSelfAreaName(query.getAreaCode(), loginUser));
            Vendor vendor = vmsService.loadByVenorId(query.getVendorId());
            if(null != vendor){
                query.setVendorName(vendor.getVendorName());
                query.setVendorPhone(vendor.getContactPhone());
                CapacityPool capacityPool = new CapacityPool();
                capacityPool.setVendorId(query.getVendorId());
                capacityPool.setDriverId(query.getDriverId());
                capacityPool.setTenantId(loginUser.getTenantId());
                capacityPool.setIsDelete(false);
                List<CapacityPool> capacityPools = transportService.findByCapacityPool(capacityPool);
                if(CollectionUtils.isNotEmpty(capacityPools)){
                    Integer truckId = capacityPools.get(0).getTruckId();
                    Truck truck = truckService.getTruck(truckId);
                    query.setPlateNumber(truck == null ? null : truck.getPlateNumber());
                }
            }
        }
        return new Page<>(queryCond.getPageNo(), queryCond.getPageSize(), total, rows);
    }

    @Override
    public Integer insertBasciInfo(DriverBo driverBo, LoginUser loginUser) throws BusinessException {
        if (null == driverBo) {
            throw new BusinessException("driverNull", "errors.paramCanNotNullWithName", "司机");
        }

        if (null == driverBo.getDriver()) {
            throw new BusinessException("driverBoNull", "errors.paramCanNotNullWithName", "司机信息");
        }
        Driver driver = driverBo.getDriver();

        if (null == driverBo.getDriverTenant()) {
            throw new BusinessException("driverTenantNull", "errors.paramCanNotNullWithName", "租户");
        }
        DriverTenant driverTenant = driverBo.getDriverTenant();

        checkParm(driver, driverTenant);
        Driver driverDB = this.loadByIdCardNo(driver.getIdCardNo(),loginUser);
        if(driverDB == null){
            driverDB = this.loadByPhone(driver.getPhone(),loginUser);
        }
        if (null != driverDB) {
            DriverTenant driverTenantDB = driverTenantService.loadByDriverId(driverDB.getDriverId(),loginUser);
            if(driverTenantDB != null){
                throw new BusinessException("areaCodeNull", "errors.common.prompt", "当前租户下已存在该司机");
            }
            //关联租户
            driverTenant.setIsOwner(false);
            driver.setDriverId(driverDB.getDriverId());
            insertDriverTenant(loginUser, driver, driverTenant);
            return driverDB.getDriverId();
        }else{
            //实名认证
            if (!thirdpartyCommonService.validateIdCardAndName(driver.getName(), driver.getIdCardNo(), loginUser)) {
                throw new BusinessException("idCardNoAndNameValidateFailed", "vendor.error.idCardNoAndNameValidateFailed");
            }
            //获取性别
            driver.setSex(IDValidatorUtils.getGenderByIdCardNo(driver.getIdCardNo()));
            //司机信息
            insertDriver(loginUser, driver);
            //绑定jumaPin
            bindingJumaPin(loginUser, driver);
            driverMapper.updateByPrimaryKeySelective(driver);
            //关联租户
            driverTenant.setIsOwner(true);
            insertDriverTenant(loginUser, driver, driverTenant);
            return driver.getDriverId();
        }
    }

    @Override
    public Integer insert(DriverBo driverBo, LoginUser loginUser) throws BusinessException {
        if (null == driverBo) {
            throw new BusinessException("driverBoNull", "errors.paramCanNotNullWithName", "司机");
        }

        if (null == driverBo.getVendorDriver() || null == driverBo.getVendorDriver().getVendorId()) {
            throw new BusinessException("vendorDriverNull", "errors.paramCanNotNullWithName", "承运商");
        }

        if (null == driverBo.getDriver()) {
            throw new BusinessException("driverNull", "errors.paramCanNotNullWithName", "司机信息");
        }
        Driver driver = driverBo.getDriver();

        //使用方创建进入update操作
        if(null != driver.getDriverId()){
            DriverTenant dt = driverTenantService.loadByDriverId(driver.getDriverId(), loginUser);
            if(dt != null){
                throw new BusinessException("driverIsExist", "errors.common.prompt", "司机已存在，不能重复添加");
            }
            this.update(driverBo,loginUser);
            return driver.getDriverId();
        }

        if (null == driverBo.getDriverTenant()) {
            throw new BusinessException("driverTenantNull", "errors.paramCanNotNullWithName", "租户");
        }
        DriverTenant driverTenant = driverBo.getDriverTenant();

        checkParm(driver, driverTenant);
        checkPhone(loginUser, driver);
        checkIdCard(loginUser, driver);

        //实名认证
        if (!thirdpartyCommonService.validateIdCardAndName(driver.getName(), driver.getIdCardNo(), loginUser)) {
            throw new BusinessException("idCardNoAndNameValidateFailed", "vendor.error.idCardNoAndNameValidateFailed");
        }

        VendorDriver vendorDriver = driverBo.getVendorDriver();
        //承运商自营->司机自营，承运商非自营->司机非自营
        Vendor vendor = vmsService.loadByVenorId(vendorDriver.getVendorId());
        if(null != vendor && null != vendor.getVendorSource()){
            if(VendorSourceEnum.SELF_SUPPORT.getCode() == vendor.getVendorSource()){
                driver.setDriverRunType(DriverTypeEnum.OWN_SALE.getCode());
            }else {
                driver.setDriverRunType(DriverTypeEnum.NOT_OWN_SALE.getCode());
            }
        }
        //获取性别
        driver.setSex(IDValidatorUtils.getGenderByIdCardNo(driver.getIdCardNo()));

        //司机信息
        insertDriver(loginUser, driver);

        //绑定jumaPin
        bindingJumaPin(loginUser, driver);
        driverMapper.updateByPrimaryKeySelective(driver);

        //关联租户
        driverTenant.setIsOwner(true);
        insertDriverTenant(loginUser, driver, driverTenant);

        //关联承运商
        vendorDriver.setDriverId(driver.getDriverId());
        vendorDriver.setVendorId(vendorDriver.getVendorId());
        vendorDriverService.insert(vendorDriver,loginUser);

        //关联车辆（运力池）
        if(null != driverBo.getTruckId()){
            insertTruckRelation(driverBo, loginUser, driver, driverTenant, vendorDriver);
        }

        //发短信
        Map<String,Object> extras = new HashMap<>(16);
        extras.put("name",driver.getName());
        messageService.pushSmsMessage(loginUser,Constants.MESSAGE_DRIVER_CREATE,extras,driver.getPhone());

        return driver.getDriverId();
    }

    private void bindingJumaPin(LoginUser loginUser, Driver driver) {
        DriverIdentification driverIdentification = new DriverIdentification();
        BeanUtils.copyProperties(driver,driverIdentification);
        driver.setJumaPin(mdcCommonService.addDriverToMdata(driverIdentification, loginUser));
    }

    private void insertTruckRelation(DriverBo driverBo, LoginUser loginUser, Driver driver, DriverTenant driverTenant, VendorDriver vendorDriver) {
        CapacityPool capacityPool = new CapacityPool();
        capacityPool.setVendorId(vendorDriver.getVendorId());
        capacityPool.setAreaCode(driverTenant.getAreaCode());
        capacityPool.setDriverId(driver.getDriverId());
        capacityPool.setTruckId(driverBo.getTruckId());
        Truck truck = truckService.getTruck(driverBo.getTruckId());
        if(null != truck){
            capacityPool.setVehicleBoxType(truck.getVehicleBoxType());
            capacityPool.setVehicleBoxLength(truck.getVehicleBoxLength());
            capacityPool.setVehicleRunType(truck.getTruckRunType());
        }
        capacityPool.setStatus(true);
        transportService.insertCapacityPool(capacityPool,loginUser);
    }

    private void insertDriver(LoginUser loginUser, Driver driver) {
        driver.setTelRemindSwitch(true);
        driver.setSmsRemindSwitch(true);
        driver.setIsReceiveWaybill(true);
        driver.setCreateTime(new Date());
        driver.setCreateUserId(loginUser.getUserId());
        driverMapper.insert(driver);
    }

    private void insertDriverTenant(LoginUser loginUser, Driver driver, DriverTenant driverTenant) {
        driverTenant.setTenantId(loginUser.getTenantId());
        driverTenant.setTenantCode(loginUser.getTenantCode());
        driverTenant.setDriverId(driver.getDriverId());
        driverTenantService.insert(driverTenant,loginUser);
        // 创建用户
        this.driver2user(driver.getDriverId(), loginUser);
    }

    private void checkPhone(LoginUser loginUser, Driver driver) {
        // 手机号唯一
        Driver byPhone = this.loadByPhone(driver.getPhone(),loginUser);
        if (null != byPhone) {
            if (null == driver.getDriverId()) {
                throw new BusinessException("contactPhoneExist", "vendor.error.contactPhoneExist");
            }

            if (null != driver.getDriverId() && !driver.getDriverId().equals(byPhone.getDriverId())) {
                throw new BusinessException("contactPhoneExist", "vendor.error.contactPhoneExist");
            }
        }
    }

    private void checkIdCard(LoginUser loginUser, Driver driver) {
        // 身份证唯一
        Driver byIdCardNo = this.loadByIdCardNo(driver.getIdCardNo(),loginUser);
        if (null != byIdCardNo) {
            if (null == driver.getDriverId()) {
                throw new BusinessException("idCardNoExist", "vendor.error.idCardNoExist");
            }
            if (null != driver.getDriverId() && !driver.getDriverId().equals(byIdCardNo.getDriverId())) {
                throw new BusinessException("idCardNoExist", "vendor.error.idCardNoExist");
            }
        }
    }

    private void checkParm(Driver driver, DriverTenant driverTenant) {
        if (StringUtils.isBlank(driverTenant.getAreaCode())) {
            throw new BusinessException("areaCodeNull", "errors.paramCanNotNullWithName", "业务范围");
        }

        if (StringUtils.isBlank(driver.getName())) {
            throw new BusinessException("driveLicenseNull", "errors.paramCanNotNullWithName", "姓名");
        }

        if (StringUtils.isBlank(driver.getIdCardNo())) {
            throw new BusinessException("driveLicenseNull", "errors.paramCanNotNullWithName", "身份证号");
        }

        if (StringUtils.isBlank(driver.getPhone())) {
            throw new BusinessException("phoneNull", "errors.paramCanNotNullWithName", "手机号");
        }

        if (!BaseUtil.checkMobilePhone(driver.getPhone())) {
            throw new BusinessException("contactPhoneError", "vendor.error.contactPhoneError");
        }

        if (null == driver.getCanDriveType()) {
            throw new BusinessException("canDriveTypeNull", "errors.paramCanNotNullWithName", "准驾车型");
        }
    }

    @Override
    public void update(DriverBo driverBo, LoginUser loginUser) throws BusinessException {
        if (null == driverBo) {
            throw new BusinessException("driverBoNull", "errors.paramCanNotNullWithName", "司机");
        }

        if (null == driverBo.getDriver()) {
            throw new BusinessException("driverNull", "errors.paramCanNotNullWithName", "司机信息");
        }
        Driver driver = driverBo.getDriver();

        if (null == driverBo.getDriverTenant()) {
            throw new BusinessException("driverTenantNull", "errors.paramCanNotNullWithName", "租户");
        }
        DriverTenant driverTenant = driverBo.getDriverTenant();

        checkParm(driver, driverTenant);
        checkPhone(loginUser, driver);

        // 判断是不是归属方更改
        DriverTenant historyDriverTenant = driverTenantService.loadByDriverId(driver.getDriverId(), loginUser);
        if (null == historyDriverTenant) {
            // 若查询不到，则只建立关联关系
            driverTenant.setIsOwner(false);
            insertDriverTenant(loginUser, driver, driverTenant);

            //关联承运商
            if(null != driverBo.getVendorDriver()){
                VendorDriver vendorDriver = driverBo.getVendorDriver();
                vendorDriver.setDriverId(driver.getDriverId());
                vendorDriver.setVendorId(vendorDriver.getVendorId());
                vendorDriverService.insert(vendorDriver,loginUser);

                //关联车辆（运力池）
                if(null != driverBo.getTruckId()){
                    insertTruckRelation(driverBo, loginUser, driver, driverTenant, vendorDriver);
                }
            }
            return;
        }

        // 若不是归属方，则只更改绑定关系
        if (!historyDriverTenant.getIsOwner()) {
            historyDriverTenant.setAreaCode(driverTenant.getAreaCode());
            driverTenantService.update(historyDriverTenant,loginUser);
            return;
        }

        Driver historyDriver = this.loadDriverById(driver.getDriverId());
        //更改用户中心手机号
        if(null != historyDriver && !historyDriver.getPhone().equals(driver.getPhone())){
            User user = userService.loadUser(loginUser.getUserId());
            if(null != user){
                user.setMobileNumber(driver.getPhone());
                userService.updateUser(user,loginUser);
            }
            //发送短信
            sendSMS(loginUser, driver, historyDriver);
        }

        //绑定jumaPin
        if(null != historyDriver && StringUtils.isBlank(historyDriver.getJumaPin())){
            if (thirdpartyCommonService.validateIdCardAndName(driver.getName(), driver.getIdCardNo(), loginUser)) {
                if(StringUtils.isBlank(historyDriver.getJumaPin())){
                    bindingJumaPin(loginUser, driver);
                }
            }
        }

        // 归属方
        driver.setLastUpdateUserId(loginUser.getUserId());
        driver.setLastUpdateTime(new Date());
        mqService.sendAfterDriverUpdate(driver,"更改归属方+更新jumapin");
        driverMapper.updateByPrimaryKeySelective(driver);

        historyDriverTenant.setAreaCode(driverTenant.getAreaCode());
        driverTenantService.update(historyDriverTenant,loginUser);
    }

    private void sendSMS(LoginUser loginUser, Driver driver, Driver historyDriver) {
        Map<String,Object> extras = new HashMap<>(16);
        extras.put("name",driver.getName());
        extras.put("phone",driver.getPhone());
        //发送给原手机号
        messageService.pushSmsMessage(loginUser,Constants.MESSAGE_DRIVER_PAST_PHONE,extras,historyDriver.getPhone());
        //发送给新手机号
        messageService.pushSmsMessage(loginUser,Constants.MESSAGE_DRIVER_NEW_PHONE,extras,driver.getPhone());
    }

    //校验短信验证码
    private void checkUpdatePhone(Integer driverId, String phone, String smsCode) {
        Driver driver = this.loadDriverById(driverId);
        if (null == driver) {
            return;
        }

        if (!phone.equals(driver.getPhone())){
            return;
        }

        if (StringUtils.isBlank(smsCode)) {
            throw new BusinessException("identifyingCodeRequired", "vendor.error.identifyingCodeRequired");
        }

        SmsCode sms = new SmsCode();
        sms.setPhone(phone);
        sms.setSmsCode(smsCode);
        if (!messageService.verifySmsCode(sms)) {
            throw new BusinessException("identifyingCodeError", "vendor.error.identifyingCodeError");
        }
    }

    @Override
    public void updateDriver(Driver driver, LoginUser loginUser) throws BusinessException {
        if(null == driver || null == driver.getDriverId()){
            return;
        }
        driver.setLastUpdateTime(new Date());
        driver.setLastUpdateUserId(loginUser.getUserId());
        driverMapper.updateByPrimaryKey(driver);
    }

    @Override
    public void updateVendor(DriverBo driverBo, LoginUser loginUser) throws BusinessException {
        if (null == driverBo || null == driverBo.getDriver()){
            throw new BusinessException("paramsError", "errors.paramsError");
        }

        Driver driver = driverBo.getDriver();
        VendorDriver vendorDriver = vendorDriverService.loadByDriverId(driver.getDriverId(), loginUser);
        Driver d = this.loadDriverById(driver.getDriverId());
        Integer oldVendorId = null;

        if(null != driverBo.getVendorDriver() && null != driverBo.getVendorDriver().getVendorId()){
            Integer newVendorId = driverBo.getVendorDriver().getVendorId();
            Vendor v = vmsService.loadByVenorId(newVendorId);
            //修改司机运营类型
            if(null != v && null != v.getVendorSource()){
                if(VendorSourceEnum.SELF_SUPPORT.getCode() == v.getVendorSource()){
                    d.setDriverRunType(DriverTypeEnum.OWN_SALE.getCode());
                }else {
                    d.setDriverRunType(DriverTypeEnum.NOT_OWN_SALE.getCode());
                }
            }
            d.setLastUpdateUserId(loginUser.getUserId());
            d.setLastUpdateTime(new Date());
            driverMapper.updateByPrimaryKey(d);
            mqService.sendAfterDriverUpdate(driver,"更改司机运营类型");
            if(null == vendorDriver){
                //创建司机、承运商关系
                VendorDriver vd = new VendorDriver();
                vd.setDriverId(driver.getDriverId());
                vd.setVendorId(newVendorId);
                vendorDriverService.insert(vd,loginUser);
            }else {
                oldVendorId = vendorDriver.getVendorId();
                //修改司机、承运商关系
                vendorDriver.setVendorId(newVendorId);
                vendorDriverService.update(vendorDriver,loginUser);
            }
            //发短信
            if(null != d && null != v && !d.getPhone().equals(v.getContactPhone())){
                Map<String,Object> extras = new HashMap<>(16);
                extras.put("name",d.getName());
                extras.put("vendorName",v.getVendorName());
                messageService.pushSmsMessage(loginUser,Constants.MESSAGE_DRIVER_CHANGE_VENDOR,extras,d.getPhone());
            }

        }else {
            //vendorId为空 删除绑定关系
            if(null != vendorDriver){
                oldVendorId = vendorDriver.getVendorId();
                vendorDriverService.delete(vendorDriver.getVendorDriverId());
            }
        }

        log.info("driver update vendor complete :{}", JSON.toJSONString(driverBo));

        //修改运力池（置空driverId）
        if(null != vendorDriver && null != oldVendorId){
            CapacityPool capacityPool = new CapacityPool();
            capacityPool.setDriverId(driver.getDriverId());
            capacityPool.setVendorId(oldVendorId);
            capacityPool.setTenantId(loginUser.getTenantId());
            capacityPool.setIsDelete(false);
            List<CapacityPool> capacityPools = transportService.findByCapacityPool(capacityPool);
            if(CollectionUtils.isNotEmpty(capacityPools)){
                CapacityPool c = capacityPools.get(0);
                c.setDriverId(null);
                c.setStatus(false);
                transportService.updateCapacityPool(c,loginUser);
            }
        }
    }

    @Override
    public Integer driver2user(Integer driverId, LoginUser loginUser) throws BusinessException {
        Driver driver = this.loadDriverById(driverId);
        if (null == driver) {
            return null;
        }

        DriverTenant driverTenant = driverTenantService.loadByDriverId(driverId, loginUser);
        if(null == driverTenant){
            return null;
        }

        Integer userId = authCommonService.driver2User(driver, driverTenant, loginUser);
        if (null == userId) {
            return null;
        }

        // 若不是归属方调用，则只是授权，不去更新driver表
        if (!driverTenant.getIsOwner()) {
            return null;
        }

        driver.setUserId(userId);
        driver.setLastUpdateTime(new Date());
        driver.setLastUpdateUserId(loginUser.getUserId());
        driverMapper.updateByPrimaryKey(driver);

        return userId;
    }

    @Override
    public Driver loadDriverById(Integer driverId) {
        if (null == driverId) {
            return null;
        }
        return driverMapper.selectByPrimaryKey(driverId);
    }

    @Override
    public Driver loadByPhone(String phone,LoginUser loginUser) {
        List<Driver> list = driverMapper.selectByExample(new DriverExample().createCriteria().andPhoneEqualTo(phone).example());
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Driver loadByIdCardNo(String idCardNo,LoginUser loginUser) {
        List<Driver> list = driverMapper.selectByExample(new DriverExample().createCriteria().andIdCardNoEqualTo(idCardNo).example());
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public DriverQuery getDriverDetail(Integer driverId, LoginUser loginUser) throws BusinessException {
        Driver driver = this.loadDriverById(driverId);
        if (null == driver) {
            return null;
        }

        DriverQuery query = new DriverQuery();
        BeanUtils.copyProperties(driver, query);

        DriverTenant driverTenant = driverTenantService.loadByDriverId(driverId, loginUser);
        if (null == driverTenant) {
            return query;
        }

        query.setAreaCode(driverTenant.getAreaCode());
        query.setStatus(driverTenant.getStatus());
        query.setAreaName(businessAreaCommonService.loadLogicAndSelfAreaName(driverTenant.getAreaCode(), loginUser));
        //归属方名称
        DriverTenant dt = driverTenantService.loadByDriverIdAnsOwner(driverId, true);
        if(null != dt){
            Tenant tenant = authCommonService.loadByTenantId(dt.getTenantId());
            query.setTenantName(tenant == null ? null : tenant.getTenantName());
        }
        query.setIsOwner(driverTenant.getIsOwner() == true ? true : false);
        if(null != driver.getCanDriveType()){
            query.setCanDriveTypeName(authCommonService.getOptionName(Constants.CRM_DRIVERS_LICENSE_TYPE,driver.getCanDriveType().toString()));
        }

        //关联承运商
        loadRelation(driverId, loginUser, query);
        return query;
    }

    private void loadRelation(Integer driverId, LoginUser loginUser, DriverQuery query) {
        VendorDriver vendorDriver = vendorDriverService.loadByDriverId(driverId, loginUser);
        if(null != vendorDriver && null != vendorDriver.getVendorId()){
            Vendor vendor = vmsService.loadByVenorId(vendorDriver.getVendorId());
            if(null != vendor){
                query.setVendorId(vendor.getVendorId());
                query.setVendorName(vendor.getVendorName());
                query.setVendorPhone(vendor.getContactPhone());
                query.setVendorTypeDesc(VendorTypeEnum.getVendorTypeDesc(vendor.getVendorType()));
                query.setContactUserName(vendor.getContactUserName());
                VendorTenant vendorTenant = vendorTenantService.loadByVendorId(vendor.getVendorId(), loginUser);
                if(null != vendorTenant){
                    query.setVendorAreaName(businessAreaCommonService.loadLogicAndSelfAreaName(vendorTenant.getAreaCode(), loginUser));
                    query.setEnableName(null != vendorTenant.getIsEnable() ? (vendorTenant.getIsEnable() ? "启用" : "停用") : "");
                }
            }
            //关联车辆
            CapacityPool capacityPool = new CapacityPool();
            capacityPool.setDriverId(driverId);
            capacityPool.setVendorId(vendorDriver.getVendorId());
            capacityPool.setTenantId(loginUser.getTenantId());
            capacityPool.setIsDelete(false);
            List<CapacityPool> capacityPools = transportService.findByCapacityPool(capacityPool);
            if(CollectionUtils.isNotEmpty(capacityPools)){
                Truck truck = truckService.getTruck(capacityPools.get(0).getTruckId());
                if(null != truck){
                    query.setTruckId(truck.getTruckId());
                    query.setPlateNumber(truck.getPlateNumber());
                    query.setTruckTypeName(truckTypeService.findTruckTypeNameBy(truck.getVehicleBoxType(), truck.getVehicleBoxLength()));
                    query.setTruckRunType(truck.getTruckRunType());
                    TruckTenant truckTenant = truckTenantService.getByTruckId(truck.getTruckId(), loginUser);
                    if(null != truckTenant){
                        query.setTruckStatus(truckTenant.getStatus());
                        query.setTruckAreaName(businessAreaCommonService.loadLogicAndSelfAreaName(truckTenant.getAreaCode(), loginUser));
                    }
                }
            }
        }
    }

    @Override
    public List<DriverQuery> listByDriverFilter(DriverQuery driverQuery, LoginEmployee loginEmployee) {
        if (null != loginEmployee && null != loginEmployee.getTenantId()) {
            driverQuery.setTenantId(loginEmployee.getTenantId());
        }
        //当前承运商下的司机
        if(driverQuery.getLabel().equals(DRIVER_VENDOR_TRUCK_FILTER)){
            List<DriverQuery> drivers = driverExtMapper.listByDriverFilter(driverQuery);
            for(DriverQuery d : drivers){
                if(null != d.getCanDriveType()){
                    d.setDriverCanDriveType(authCommonService.getOptionName(Constants.CRM_DRIVERS_LICENSE_TYPE,d.getCanDriveType().toString()));
                }
            }
            return drivers;
        //当前登录部门业务范围查询
        }else if(driverQuery.getLabel().equals(DRIVER_AREACODE_FILTER)){
            List<LoginEmployee.LoginDepartment.BusinessArea> businessAreas = loginEmployee.getLoginDepartment().getBusinessAreas();
            if (CollectionUtils.isNotEmpty(businessAreas)) {
                for (LoginEmployee.LoginDepartment.BusinessArea businessArea: businessAreas) {
                    driverQuery.getAreaCodeList().add(businessArea.getAreaCode()) ;
                }
            }
            return driverExtMapper.listByDriverAreaFilter(driverQuery);
        //当前承运商关联的未设置车辆的司机或未关联承运商的司机
        }else if(driverQuery.getLabel().equals(DRIVER_VENDOR_FILTER)){
            return driverExtMapper.listByDriverVendorFilter(driverQuery);
        }
        return null;
    }

    @Override
    public List<DriverQuery> listByDriver(DriverQuery driverQuery, Integer pageSize, LoginUser loginUser) {
        QueryCond<DriverQuery> cond = new QueryCond<>();
        cond.setPageNo(1);
        cond.setPageSize((pageSize == null || pageSize < 0) ? 100 : pageSize);

        if (null != loginUser && null != loginUser.getTenantId()) {
            driverQuery.setTenantId(loginUser.getTenantId());
        } else {
            driverQuery.setIsOwner(true);
        }

        cond.setFilters(driverQuery);
        List<DriverQuery> list = driverExtMapper.search(cond);
        return list;
    }

    @Override
    public List<Driver> listDriverByName(String name) {
        if (StringUtils.isBlank(name)) {
            return new ArrayList<>();
        }

        DriverExample example = new DriverExample().createCriteria()
                .andNameEqualTo(name)
                .example();

        return driverMapper.selectByExample(example);
    }

    @Override
    public Driver loadDriverByAmsDriverId(Integer amsDriverId) {
        if (null == amsDriverId) {
            return null;
        }

        DriverExample example = new DriverExample().createCriteria()
                .andAmsDriverIdEqualTo(amsDriverId)
                .example();

        List<Driver> list = driverMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Driver loadDriverByUserId(Integer userId) {
        if (null == userId) {
            return null;
        }

        DriverExample example = new DriverExample().createCriteria()
                .andUserIdEqualTo(userId)
                .example();

        List<Driver> list = driverMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void updateRemindSwitch(Integer driverId, RemindSwitchValue remindSwitchValue, RemindSwitchType remindSwitchType, LoginUser loginUser) {
        if (null == driverId || null == remindSwitchValue || null == remindSwitchType) {
            return;
        }

        Driver driver = new Driver();
        driver.setDriverId(driverId);
        if (remindSwitchType.equals(RemindSwitchType.SMS)) {
            driver.setSmsRemindSwitch(remindSwitchValue.getCode() == 1 ? true : false);
        } else if (remindSwitchType.equals(RemindSwitchType.TEL)) {
            driver.setTelRemindSwitch(remindSwitchValue.getCode() == 1 ? true : false);
        } else {
            return;
        }

        driver.setLastUpdateUserId(loginUser == null ? null : loginUser.getUserId());
        driver.setLastUpdateTime(new Date());
        driverMapper.updateByPrimaryKeySelective(driver);
        mqService.sendAfterDriverUpdate(driver,"更改司机电话或短信提醒开关状态");
    }

    @Override
    public void updateIsReceiveWaybill(Integer driverId, Boolean isReceiveWaybill, LoginUser loginUser) {
        if (null == driverId || null == isReceiveWaybill) {
            return;
        }

        Driver driver = new Driver();
        driver.setDriverId(driverId);
        driver.setIsReceiveWaybill(isReceiveWaybill);
        driver.setLastUpdateUserId(loginUser == null ? null : loginUser.getUserId());
        driver.setLastUpdateTime(new Date());
        driverMapper.updateByPrimaryKeySelective(driver);
        mqService.sendAfterDriverUpdate(driver,"更改司机是否接单状态");
    }

    @Override
    public List<DriverQuery> listDriverBy(List<String> areaCodeList, Integer driverRunType, Integer callbackPageSize, LoginUser loginUser) {
        if (null == loginUser || null == loginUser.getTenantId()) {
            return new ArrayList<>();
        }

        QueryCond<DriverQuery> queryCond = new QueryCond<>();

        DriverQuery query = new DriverQuery();
        query.setTenantId(loginUser.getTenantId());
        query.setDriverRunType(driverRunType);
        query.setAreaCodeList(areaCodeList);
        queryCond.setFilters(query);
        queryCond.setPageNo(1);
        queryCond.setPageSize(callbackPageSize == null ? 15 : callbackPageSize);
        return driverExtMapper.listByDriverFilter(query);
    }

    @Override
    public List<Driver> all() {
        return driverMapper.selectByExample(new DriverExample().createCriteria().example());
    }

    @Override
    public void batchUpdate(List<Driver> rows) {
        driverMapper.updateBatchByPrimaryKeySelective(rows);
    }

    @Override
    public List<Driver> listDriverBy(Integer tenantId, String areaCode) {
        List<Driver> rows = new ArrayList<Driver>();
        DriverTenantExample example = new DriverTenantExample().createCriteria().andTenantIdEqualTo(tenantId).andAreaCodeLike(areaCode+"%").example();
        List<DriverTenant> driverTenants = driverTenantMapper.selectByExample(example);
        for(DriverTenant driverTenant : driverTenants) {
            rows.add(loadDriverById(driverTenant.getDriverId()));
        }
        return rows;
    }

    @Override
    public List<Driver> listEffectiveCapacityDriver(CapacityPoolFilter capacityPoolFilter, LoginUser loginUser) {
        if (null == capacityPoolFilter || null == loginUser || null == loginUser.getTenantId()) {
            return new ArrayList<>();
        }

        capacityPoolFilter.setTenantId(loginUser.getTenantId());
        capacityPoolFilter.setIsDelete(false);
        capacityPoolFilter.setStatus(true);
        return driverExtMapper.listEffectiveCapacityDriver(capacityPoolFilter);
    }

    @Override
    public void updateDriverByUserId(Integer userId, String name, String phone, LoginUser loginUser) {
        if (null == userId || (StringUtils.isBlank(name) && StringUtils.isBlank(phone))) {
            return;
        }

        Driver driver = this.loadDriverByUserId(userId);
        if (null == driver) {
            return;
        }

        // 校验手机号是否已存在
        if (StringUtils.isNotBlank(phone)) {
            DriverExample example = new DriverExample().createCriteria()
                .andPhoneEqualTo(phone)
                .example();
            List<Driver> drivers = driverMapper.selectByExample(example);
            for (Driver d : drivers) {
                if (!d.getDriverId().equals(driver.getDriverId())) {
                    return;
                }
            }
        }

        driver.setName(name);
        driver.setPhone(phone);
        driver.setLastUpdateUserId(loginUser == null ? null : loginUser.getUserId());
        driver.setLastUpdateTime(new Date());

        driverMapper.updateByPrimaryKeySelective(driver);
    }

    @Override
    public List<Driver> listDriverByFilter(DriverExternalFilter filter, LoginUser loginUser) throws BusinessException {
        if( null == filter || null == loginUser || null == loginUser.getTenantId() ){
            return Lists.newArrayList();
        }
        DriverExample example = new DriverExample().createCriteria()
                .andDriverIdIn(setIfNotEmpty(filter.getDriverIds()))
                .andNameLike(setLikeIFNotNull(filter.getName()))
                .andPhoneLike(setLikeIFNotNull(filter.getPhone()))
                .example();
        example.setStartOffSet(0);
        example.setSize(null == filter.getSize() ? 15 : filter.getSize());
        return driverMapper.selectByExample(example);
    }

    private String setLikeIFNotNull(String field) {
        if( StringUtils.isBlank(field) ){ return field; }
        return "%" + field + "%";
    }

    private List<Integer> setIfNotEmpty(List<Integer> ids) {
        if( CollectionUtils.isEmpty(ids) ){ return null; }
        return ids;
    }
}
