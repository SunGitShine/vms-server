package com.juma.vms.tool.service;

import com.giants.common.exception.BusinessException;
import com.juma.tsl.domain.bo.CustomerInfoBO;

/**
 * TSL公共类
 */

public interface TslCommonService {

    CustomerInfoBO getCustomerByVehicleFrameNo(String vehicleFrameNo) throws BusinessException;

    /**根据车牌号查询:是否已交车**/
    boolean hasVehicleNeedReturn(String vehicleFrameNo) throws BusinessException;
}
