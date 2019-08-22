package com.juma.vms.external.service;

import com.juma.vms.transport.response.TruckStatusResp;

/**
 * 功能 :
 * 提供给第三方系统接口
 * 规则:
 * 1.返回提供整个对象,后期可以用缓存降低并发风险
 * 2.但是内网带宽会多占用一部分
 * @author : Bruce(刘正航) 11:03 2019-04-10
 */
public interface ReturnExternalService {

    /**
     * 业务逻辑:
     * 1. 车架号在运力池中的运力车辆状态为“待接收“或”正常”；提示：车辆在运力池中未退回，不可退车
     * 2. 车架号在状态为“审批中”的输送单中；提示：车辆正在运力输送中，不可退车
     * 以上任一条件满足都不可退车，且不区分租户查询
     * 功能:
     * 1.提供给TSL系统接口(无租户ID-->不区分租户查询)
     *  参数:
     *      车架号
     *  返回值:
     *      车牌号
     *      车架号
     *      运营类型(1自营2加盟3外请4非自营)
     *      非空 代表已退车
     */
    TruckStatusResp loadStatusByTruckIdentificationNo(String truckIdentificationNo);

}
