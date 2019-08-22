package com.juma.vms.mq.service;

import com.juma.log.domain.OperationLogInfo;
import com.juma.vms.driver.domain.Driver;
import com.juma.vms.mq.domain.TruckCompanyChangeMq;
import com.juma.vms.mq.domain.TruckReturnMq;
import com.juma.vms.truck.domain.Truck;

/**
 * @author Libin.Wei
 * @version 1.0.0
 * @ClassName MqSendService.java
 * @Description mq公共类
 * @Date 2018年11月7日 下午7:58:33
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

public interface MqService {

    /**
     * 异步记录日志
     *
     * @param operationLogInfo
     */
    void sendWritelog(OperationLogInfo operationLogInfo);

    /**
     * 承运商信息修改后发送
     *
     * @param vendorId
     * @param tenantId
     * @author Libin.Wei
     * @Date 2018年11月7日 下午8:02:50
     */
    void sendVendorAfterUpdate(Integer vendorId, Integer tenantId);

    /**
     * 运力退回流程走完之后,告知AMS和TSL系统.
     */
    void sendAfterTruckReturn(TruckReturnMq body);

    void sendTruckCompanyChange(TruckCompanyChangeMq truckCompanyChangeMq);

    /**车辆信息更新事件**/
    void sendAfterTruckUpdate(Truck truck,String operation);

    /**司机信息更新事件**/
    void sendAfterDriverUpdate(Driver driver,String operation);
}
