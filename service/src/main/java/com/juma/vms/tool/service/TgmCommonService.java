package com.juma.vms.tool.service;

/**
 * 功能 :
 * 调用TGM系统的接口
 * @author : Bruce(刘正航) 09:08 2019-04-23
 */
public interface TgmCommonService {

    /**
     * 根据箱型箱长,获取卡车型号完整描述
     * @param boxType 箱型
     * @param boxLength 箱长
     * @return
     */
    String findTruckTypeDesc(Integer boxType,Integer boxLength);

}
