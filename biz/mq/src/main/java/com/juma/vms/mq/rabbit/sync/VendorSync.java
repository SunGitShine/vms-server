package com.juma.vms.mq.rabbit.sync;

import com.juma.auth.tenant.domain.Tenant;
import com.juma.auth.tenant.service.TenantService;
import com.juma.auth.user.domain.LoginUser;
import com.juma.auth.user.domain.User;
import com.juma.auth.user.service.UserService;
import com.juma.crm.ams.domain.RenterSync;
import com.juma.server.vm.domain1.bo.VehicleBo;
import com.juma.vms.common.Constants;
import com.juma.vms.tool.service.AmsCommonService;
import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.domain.VendorTenant;
import com.juma.vms.vendor.enumeration.SourceEnum;
import com.juma.vms.vendor.service.VendorService;
import com.juma.vms.vendor.service.VendorTenantService;
import com.juma.vms.vendor.service.VendorVehicleService;
import com.juma.vms.vendor.vo.VendorBo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName VendorSync.java
 * @Description 同步承运商信息至VMS
 * @author Libin.Wei
 * @Date 2018年10月31日 下午2:49:58
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

@Component
public class VendorSync {

    @Resource
    private VendorService vendorService;
    @Resource
    private VendorVehicleService vendorVehicleService;
    @Resource
    private VendorTenantService vendorTenantService;
    @Resource
    private UserService userService;
    @Resource
    private AmsCommonService amsCommonService;
    @Resource
    private TenantService tenantService;

    public void doVendorSync(RenterSync renterSync) {
        Tenant tenant = tenantService.findTenant(renterSync.getProjectOwnershipBrand());
        LoginUser loginUser = new LoginUser();
        loginUser.setTenantCode(tenant.getTenantCode());
        loginUser.setTenantId(tenant.getTenantId());
        loginUser.setUserId(renterSync.getCreateUserId());

        // 验证承租人是否存在
        Vendor vendor = vendorService.loadByPhone(renterSync.getPhone(), null);

        if (null == vendor) {
            // 新增 租户
            VendorBo bo = new VendorBo();
            vendor = new Vendor();
            VendorTenant vendorTenant = new VendorTenant();

            vendor.setVendorName(renterSync.getName());
            if (null != renterSync.getUserType()) {
                vendor.setVendorType(Byte.valueOf(renterSync.getUserType()));
            }
            vendor.setContactPhone(renterSync.getPhone().replace(" ", ""));
            if (StringUtils.isNotBlank(renterSync.getIdCardNo())) {
                vendor.setIdCardNo(renterSync.getIdCardNo().replace(" ", ""));
            }
            vendor.setIdCardNoExpireTime(renterSync.getIdCardNoExpireTime());
            vendorTenant.setAreaCode(Constants.DEFAULT_AREA_CODE);
            vendor.setEnterpriseCode(renterSync.getCreditCode());
            vendor.setIdCardImg1(renterSync.getIdentityUrl());
            vendor.setQualityCertImg1(renterSync.getQualificationLicenceUrl());
            vendor.setSource(SourceEnum.CRM.getCode());

            bo.setVendor(vendor);
            bo.setVendorTenant(vendorTenant);
            Integer vendorId = vendorService.insert(bo, loginUser);
            Integer userId = this.vendorSyncUser(vendorId, loginUser);
            vendor.setUserId(userId);

            // 新增承运商 并 绑定车辆关系
            bindVehicle(renterSync, vendorId, loginUser);
            return;
        }

        if (null == vendor.getUserId()) {
            vendor.setIdCardNoExpireTime(renterSync.getIdCardNoExpireTime());
            VendorBo bo = new VendorBo();
            bo.setVendor(vendor);
            bo.setVendorTenant(vendorTenantService.loadByVendorId(vendor.getVendorId(), loginUser));
            vendorService.update(bo, loginUser);
        }

        // 更改车辆合同信息
        bindVehicle(renterSync, vendor.getVendorId(), loginUser);
    }

    // 创建承运商账号
    private Integer vendorSyncUser(@PathVariable Integer vendorId, LoginUser loginUser) {
        return vendorService.vendor2user(vendorId, loginUser);
    }

    private void bindVehicle(RenterSync renterSync, Integer vendorId, LoginUser loginUser) {
        if (CollectionUtils.isEmpty(renterSync.getPlateNumberList())) {
            return;
        }

        List<Integer> listVehicleId = new ArrayList<Integer>();
        for (String plateNumber : renterSync.getPlateNumberList()) {
            VehicleBo vehicleBo = amsCommonService.findByPlateNumber(plateNumber, loginUser.getTenantId(),
                    loginUser.getTenantCode());
            if (null != vehicleBo) {
                listVehicleId.add(vehicleBo.getVehicleId());
            }
        }

        vendorVehicleService.batchInsert(listVehicleId, vendorId, loginUser);
    }

    public void doNamePhoneSync(Integer userId) {
        if (null == userId) {
            return;
        }

        Vendor vendor = vendorService.findByUserId(userId, false);
        if (null == vendor) {
            return;
        }

        User user = userService.loadUser(userId);
        if (null == user) {
            return;
        }

        // 手机号与姓名都没有更改，承运商不做更改
        if (vendor.getContactPhone().equals(user.getMobileNumber()) && vendor.getVendorName().equals(user.getName())) {
            return;
        }

        vendorService.updateNameAndPhone(vendor.getVendorId(), user.getName(), user.getMobileNumber());
    }

}
