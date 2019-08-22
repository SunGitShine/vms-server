package com.juma.vms.tool.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.juma.scm.product.service.PropertyValueService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.giants.common.exception.BusinessException;
import com.juma.scm.product.bo.PropertyBO;
import com.juma.scm.product.domain.PropertyValue;
import com.juma.scm.product.service.PropertyService;
import com.juma.vms.common.Constants;
import com.juma.vms.tool.domain.BaseEnumDomian;
import com.juma.vms.tool.service.ScmCommonService;

@Service
public class ScmCommonServiceImpl implements ScmCommonService {

    private final Logger log = LoggerFactory.getLogger(ScmCommonServiceImpl.class);

    @Resource
    private PropertyService propertyService;
    @Resource
    private PropertyValueService propertyValueService;

    @Override
    public String findVehicleBoxTypeName(Integer vehicleBoxType) throws BusinessException {
        if (null == vehicleBoxType) {
            return null;
        }

        return this.handlePropertyValue(Constants.SCM_BOX_TYPE).get(vehicleBoxType + "");
    }

    @Override
    public String findVehicleBoxLengthName(Integer vehicleBoxLength) throws BusinessException {
        if (null == vehicleBoxLength) {
            return null;
        }

        return this.handlePropertyValue(Constants.SCM_BOX_LEVEL).get(vehicleBoxLength + "");
    }

    // 处理SCM获取的PropertyValue数据
    private Map<String, String> handlePropertyValue(String key) {
        Map<String, String> result = new HashMap<String, String>();
        List<String> keys = new ArrayList<String>();
        keys.add(key);

        Map<String, List<PropertyBO>> map = null;
        try {
            map = propertyService.listByKeys(keys);
        } catch (BusinessException e) {
            log.warn("从SCM获取数据错误", e);
        }

        if (null == map || map.isEmpty()) {
            return result;
        }

        List<PropertyBO> list = map.get(key);
        if (CollectionUtils.isEmpty(list)) {
            return result;
        }

        List<PropertyValue> propertyValues = new ArrayList<PropertyValue>();
        for (PropertyBO propertyBO : list) {
            if (StringUtils.isNotBlank(propertyBO.getKey()) && propertyBO.getKey().equals(key)) {
                propertyValues = propertyBO.getPropertyValues();
            }
        }

        if (CollectionUtils.isEmpty(propertyValues)) {
            return result;
        }

        for (PropertyValue propertyValue : propertyValues) {
            result.put(propertyValue.getId() + "", propertyValue.getName());
        }

        return result;
    }

    @Override
    public Map<String, List<BaseEnumDomian>> getPropertyValueByKeys(List<String> keys) {

        Map<String, List<BaseEnumDomian>> resultMap = new HashMap<>();

        Map<String, List<PropertyBO>> map = null;
        try {
            map = propertyService.listByKeys(keys);
        } catch (BusinessException e) {
            log.warn("从SCM获取数据错误", e);
        }

        if (null == map || map.isEmpty()) {
            return resultMap;
        }

        for(String key : keys){
            List<PropertyBO> list = map.get(key);
            if (CollectionUtils.isEmpty(list)) {
                resultMap.put(key, null);
                continue;
            }
            List<PropertyValue> propertyValues = new ArrayList<PropertyValue>();
            for (PropertyBO propertyBO : list) {
                if (StringUtils.isNotBlank(propertyBO.getKey()) && propertyBO.getKey().equals(key)) {
                    propertyValues = propertyBO.getPropertyValues();
                }
            }

            if (CollectionUtils.isEmpty(propertyValues)) {
                resultMap.put(key, null);
                continue;
            }

            List<BaseEnumDomian> baseEnumDomians = new ArrayList<>();
            for (PropertyValue propertyValue : propertyValues) {
                BaseEnumDomian domain = new BaseEnumDomian();
                domain.setCode(propertyValue.getId());
                domain.setDesc(propertyValue.getName());
                baseEnumDomians.add(domain);
            }
            resultMap.put(key, baseEnumDomians);
        }

        return resultMap;
    }

    @Override
    public Map<String, String> mapBoxType() {
        return this.handlePropertyValue(Constants.SCM_BOX_TYPE);
    }

    @Override
    public Map<String, String> mapBoxLength() {
        return this.handlePropertyValue(Constants.SCM_BOX_LEVEL);
    }

    @Override
    public String getByPropertyValueId(Integer propertyValueId) {
        PropertyValue propertyValue = null;
        try {
            propertyValue = propertyValueService.selectByPropertyValueId(propertyValueId);
        } catch (BusinessException e) {
            log.warn("从SCM获取数据错误", e);
        }
        return propertyValue == null ? "" : propertyValue.getName();
    }
}
