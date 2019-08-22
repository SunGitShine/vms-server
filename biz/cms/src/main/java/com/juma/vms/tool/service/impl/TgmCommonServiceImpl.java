package com.juma.vms.tool.service.impl;

import com.juma.tgm.truck.service.TruckTypeService;
import com.juma.vms.tool.service.TgmCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能 :
 *
 * @author : Bruce(刘正航) 09:09 2019-04-23
 */
@Service
public class TgmCommonServiceImpl implements TgmCommonService {

    @Autowired
    private TruckTypeService truckTypeService;

    /**
     * 根据箱型箱长,获取卡车型号完整描述
     * @param boxType 箱型
     * @param boxLength 箱长
     * @return
     */
    public String findTruckTypeDesc(Integer boxType,Integer boxLength){
        return truckTypeService.findTruckTypeNameBy(boxType,boxLength);
    }
}
