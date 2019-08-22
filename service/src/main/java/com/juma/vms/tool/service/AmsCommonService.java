package com.juma.vms.tool.service;

import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.giants.common.tools.PageCondition;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.auth.user.domain.LoginUser;
import com.juma.server.vm.common.LicenseImgTypeEnum;
import com.juma.server.vm.domain.LicenseImg;
import com.juma.server.vm.domain.Vehicle;
import com.juma.server.vm.domain.bo.TenantVehicleBo;
import com.juma.server.vm.domain.dto.VehicleQueryConditionDTO;
import com.juma.server.vm.domain1.bo.VehicleBo;
import com.juma.server.vm.domain1.bo.VehicleOwnerDeptBo;
import com.juma.vms.vendor.vo.QueryVehicleVo;

import java.util.List;

/**
 * @author Libin.Wei
 * @version 1.0.0
 * @ClassName AmsCommonService.java
 * @Description 对接AMS接口
 * @Date 2018年11月2日 上午10:30:30
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

public interface AmsCommonService {

    /**
     * 根据车牌号获取
     *
     * @param plateNumber 车牌号，必填
     * @param tenantId    租户ID，必填
     * @param tenantCode  租户编码，必填
     * @return
     * @throws BusinessException
     * @author Libin.Wei
     * @Date 2018年11月2日 上午10:34:30
     */
    VehicleBo findByPlateNumber(String plateNumber, Integer tenantId, String tenantCode) throws BusinessException;

    /**
     * 根据车辆ID获取
     *
     * @param vehicleId  车辆ID，必填
     * @param tenantId   租户ID，必填
     * @param tenantCode 租户编码，必填
     * @return
     * @throws BusinessException
     * @author Libin.Wei
     * @Date 2018年11月2日 上午10:36:14
     */
    VehicleBo findByVehicleId(Integer vehicleId, Integer tenantId, String tenantCode) throws BusinessException;

    /**
     * 根据车牌号获取
     *
     * @param plateNumber
     * @param loginUser
     * @return
     * @throws BusinessException
     * @author Libin.Wei
     * @Date 2018年11月6日 上午11:27:17
     */
    List<QueryVehicleVo> listByPlateNumber(String plateNumber, LoginUser loginUser) throws BusinessException;

    /**
     * 车辆更换认领公司通知AMS
     */
    void changeCompany2Ams(TenantVehicleBo tenantVehicleBo) throws BusinessException;

    /**
     * 根据车辆Id、租户id 获取车辆基本信息和扩展信息（查询vehicle和vehicle_extend表）
     * @param vehicleQueryConditionDTO
     * @return
     */
    VehicleBo getVehicleBoById(VehicleQueryConditionDTO vehicleQueryConditionDTO);

    /**
     * 根据车架号查车辆
     *
     * @param vehicleFrameNo
     * @return
     * @throws BusinessException
     */
    Vehicle getByVehicleFrameNo(String vehicleFrameNo);

    /**
     * 根据车牌号过滤数据
     *
     * @param plateNoList 车牌号列表
     * @return List<Vehicle>
     */
    List<VehicleBo> getVehicleListByPlateNo(List<String> plateNoList);

    /**
     * 根据车辆id、租户信息获取车辆数据
     * @param vehicleId
     * @param loginEmployee
     * @return VehicleBo
     * */
    VehicleBo getByVehicleId(Integer vehicleId, LoginEmployee loginEmployee);

    /**
     * 通过车辆id和附件功能id、租户id 获取附加功能对象
     *
     * @param vehicleQueryConditionDTO （vehicleId、tenantId 为必传)
     * @return VehicleExtraFunction
     */
    com.juma.server.vm.domain1.VehicleExtraFunction getByVehicleIdFunctionId(VehicleQueryConditionDTO vehicleQueryConditionDTO);

    /**
     * 通过车辆id和证件类型，获取对应的证件信息
     *
     * @param vehicleId
     * @param licenseImgTypeEnum
     * @return
     */
    LicenseImg getLicenseImgByVehicleIdAndType(Integer vehicleId, LicenseImgTypeEnum licenseImgTypeEnum);

    /**
     * 内部接口系统查询车辆信息
     * @param pageCondition
     * @return Page<VehicleBo>
     */
    Page<VehicleBo> queryVehicleBoForInner(PageCondition pageCondition, LoginEmployee loginEmployee);

    /**
     * 根据车牌号-查询车辆所有权公司
     * @param vehicleFrameNo
     * @return
     * @throws BusinessException
     */
    VehicleOwnerDeptBo getOwnVehicleBOByVehicleFrameNo(String vehicleFrameNo) throws BusinessException;

    /**
     * 查询车辆三权信息
     * @param vehicleId
     * @return
     * @throws BusinessException
     */
    List<VehicleBo> getVehicleBoListById(Integer vehicleId) throws BusinessException;
}
