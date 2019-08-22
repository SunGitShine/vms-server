package com.juma.vms.tool.service;

import com.giants.common.exception.BusinessException;
import com.juma.vms.tool.domain.BaseEnumDomian;

import java.util.List;
import java.util.Map;

/**
 * @author Libin.Wei
 * @version 1.0.0
 * @ClassName ScmCommonService.java
 * @Description 对接SCM公共类
 * @Date 2018年11月2日 上午11:06:10
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

public interface ScmCommonService {

    /**
     * 获取厢型名称
     *
     * @param vehicleBoxType
     * @return
     * @author Libin.Wei
     * @Date 2018年11月2日 上午11:07:16
     */
    String findVehicleBoxTypeName(Integer vehicleBoxType) throws BusinessException;

    /**
     * 获取厢长名称
     *
     * @param vehicleBoxLength
     * @return
     * @author Libin.Wei
     * @Date 2018年11月2日 上午11:07:16
     */
    String findVehicleBoxLengthName(Integer vehicleBoxLength) throws BusinessException;

    /**
     * 通过key列表到scm查询对应的值
     *
     * @param keys
     * @return
     */
    Map<String, List<BaseEnumDomian>> getPropertyValueByKeys(List<String> keys);

    /**
     * 获取厢型map
     *
     * @return
     */
    Map<String, String> mapBoxType();

    /**
     * 获取厢长map
     *
     * @return
     */
    Map<String, String> mapBoxLength();

    /**
     * 通过 propertyValue id，查询Property value名称
     *
     * @param propertyValueId
     * @return
     */
    String getByPropertyValueId(Integer propertyValueId);

}
