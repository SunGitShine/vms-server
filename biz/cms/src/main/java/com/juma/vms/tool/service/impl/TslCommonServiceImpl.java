package com.juma.vms.tool.service.impl;

import com.alibaba.fastjson.JSON;
import com.giants.common.exception.BusinessException;
import com.juma.tsl.domain.bo.CustomerInfoBO;
import com.juma.tsl.support.service.TslCustomerInfoService;
import com.juma.vms.tool.service.TslCommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TslCommonServiceImpl implements TslCommonService {

    @Autowired
    TslCustomerInfoService tslCustomerInfoService;

    @Override
    public CustomerInfoBO getCustomerByVehicleFrameNo(String vehicleFrameNo) throws BusinessException {

        CustomerInfoBO customerInfoBO;
        try {
            customerInfoBO = tslCustomerInfoService.getCustomerByVehicleFrameNo(vehicleFrameNo);
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                throw e;
            }
            throw new BusinessException("tslSystemException", "errors.tslSystemException");
        }
        return customerInfoBO;
    }

    /**根据车牌号查询:是否需要退库**/
    @Override
    public boolean hasVehicleNeedReturn(String vehicleFrameNo) throws BusinessException {
        // 逻辑: null != customerInfoBO --> 已交车 --> 不用退库
        // 逻辑: null == customerInfoBO --> 未交车 --> 需要退库
        CustomerInfoBO customerInfoBO;
        try {
            log.info("接口{}请求数据:{}", "tslCustomerInfoService.getCustomerByVehicleFrameNo",vehicleFrameNo);
            customerInfoBO = tslCustomerInfoService.getCustomerByVehicleFrameNo(vehicleFrameNo);
            log.info("接口{}返回数据:{}", "tslCustomerInfoService.getCustomerByVehicleFrameNo", JSON.toJSONString(customerInfoBO));
        } catch(BusinessException e){
            throw e;
        } catch (Exception e) {
            throw new BusinessException("tslSystemException", "errors.tslSystemException");
        }
        return null == customerInfoBO;
    }
}
