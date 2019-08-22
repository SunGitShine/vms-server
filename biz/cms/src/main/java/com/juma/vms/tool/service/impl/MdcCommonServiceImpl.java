package com.juma.vms.tool.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.juma.mdc.common.domain.CredentialPhotoType;
import com.juma.mdc.mdata.domain.*;
import com.juma.vms.driver.vo.DriverIdentification;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.giants.common.exception.BusinessException;
import com.juma.auth.user.domain.LoginUser;
import com.juma.mdc.common.domain.RoleType;
import com.juma.mdc.mdata.service.EnterpriseService;
import com.juma.mdc.mdata.service.PersonService;
import com.juma.vms.tool.service.MdcCommonService;
import com.juma.vms.vendor.enumeration.VendorTypeEnum;
import com.juma.vms.vendor.vo.VendorIdentification;

@Service
public class MdcCommonServiceImpl implements MdcCommonService {


    private final Logger log = LoggerFactory.getLogger(MdcCommonServiceImpl.class);
    @Resource
    private PersonService personService;
    @Resource
    private EnterpriseService enterpriseService;


    @Override
    public String addVendorToMdata(VendorIdentification vendorIdentification, LoginUser loginUser) throws BusinessException {
        if (null == vendorIdentification || null == vendorIdentification.getVendorType()) {
            return null;
        }

        if (vendorIdentification.getVendorType() == VendorTypeEnum.ENTERPRISE.getCode()) {
            return addEnterPriseToMdata(vendorIdentification.getVendorId(), vendorIdentification.getVendorName(),
                    vendorIdentification.getEnterpriseCode(), RoleType.VENDOR, loginUser);
        }

        return addPersonToMdata(vendorIdentification.getVendorId(), vendorIdentification.getVendorName(),
                vendorIdentification.getIdCardNo(), vendorIdentification.getIdCardImg1(),
                vendorIdentification.getIdCardImg2(), RoleType.VENDOR, loginUser);
    }

    @Override
    public String addDriverToMdata(DriverIdentification driverIdentification, LoginUser loginUser) throws BusinessException {
        if (null == driverIdentification || null == driverIdentification.getDriverId()
                || StringUtils.isBlank(driverIdentification.getName())
                || StringUtils.isBlank(driverIdentification.getIdCardNo())
                || null == loginUser || null == loginUser.getTenantId()
        ) {
            return null;
        }

        return this.addPersonToMdata(driverIdentification.getDriverId(), driverIdentification.getName()
                , driverIdentification.getIdCardNo(), driverIdentification.getIdCardImg1(),
                driverIdentification.getIdCardImg2(), RoleType.DRIVER, loginUser);
    }

    // 个人与车队
    private String addPersonToMdata(Integer id, String name, String idCardNo, String idCardImg1,
                                    String idCardImg2, RoleType roleType, LoginUser loginUser) throws BusinessException {
        if (null == id || StringUtils.isBlank(name) || StringUtils.isBlank(idCardNo)
                || null == loginUser || null == loginUser.getTenantId() || null == roleType) {
            return null;
        }

        // 组装数据
        PersonDetails personDetails = new PersonDetails();
        personDetails.setName(name);
        personDetails.setIdCardNo(idCardNo);

        List<Role> roleList = new ArrayList<>();
        Role role = new Role();
        role.setRoleId(id + "");
        role.setRoleType(roleType);
        role.setTenantId(loginUser.getTenantId());
        roleList.add(role);
        personDetails.setRoleList(roleList);


        List<CredentialPhoto> photoList = new ArrayList<>();
        if (StringUtils.isNotBlank(idCardImg1)) {
            CredentialPhoto photo = new CredentialPhoto();
            photo.setType(CredentialPhotoType.IDENTIFICATION_CARD_FRONT);
            photo.setPhoto(idCardImg1);
            photoList.add(photo);
        }
        if (StringUtils.isNotBlank(idCardImg2)) {
            CredentialPhoto photo = new CredentialPhoto();
            photo.setType(CredentialPhotoType.IDENTIFICATION_CARD_BACK);
            photo.setPhoto(idCardImg2);
            photoList.add(photo);
        }

        if (!photoList.isEmpty()) {
            IdentificationCardCredential identificationCardCredential = new IdentificationCardCredential();
            identificationCardCredential.setPhotoList(photoList);
            List<CredentialBo> credentialBoList = new ArrayList<>();
            credentialBoList.add(identificationCardCredential);
            personDetails.setCredentialBoList(credentialBoList);
        }



        log.info("个人 param:{}", JSON.toJSONString(personDetails));
        String jumaPin = personService.save(personDetails, loginUser);
        log.info("个人 return jumaPin:{}", jumaPin);

        return jumaPin;
    }

    // 公司
    private String addEnterPriseToMdata(Integer id, String name, String enterpriseCode,
                                        RoleType roleType, LoginUser loginUser) throws BusinessException {
        if (null == id || StringUtils.isBlank(name) || StringUtils.isBlank(enterpriseCode)
                || null == loginUser || null == loginUser.getTenantId()) {
            return null;
        }

        // 组装数据
        EnterpriseDetails enterpriseDetails = new EnterpriseDetails();
        enterpriseDetails.setName(name);
        enterpriseDetails.setUniformSocialCreditCode(enterpriseCode);

        List<Role> roleList = new ArrayList<>();
        Role role = new Role();
        role.setRoleId(id + "");
        role.setRoleType(roleType);
        role.setTenantId(loginUser.getTenantId());
        roleList.add(role);
        enterpriseDetails.setRoleList(roleList);


        log.info("公司 param:{}", JSON.toJSONString(enterpriseDetails));
        String jumaPin = enterpriseService.save(enterpriseDetails, loginUser);
        log.info("公司 return jumaPin:{}", jumaPin);
        return jumaPin;
    }

}
