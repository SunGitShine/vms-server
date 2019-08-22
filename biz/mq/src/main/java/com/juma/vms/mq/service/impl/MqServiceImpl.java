package com.juma.vms.mq.service.impl;

import com.alibaba.fastjson.JSON;
import com.juma.log.domain.OperationLogInfo;
import com.juma.vms.driver.domain.Driver;
import com.juma.vms.mq.domain.*;
import com.juma.vms.mq.rabbit.send.MqSendService;
import com.juma.vms.mq.service.MqService;
import com.juma.vms.truck.domain.Truck;
import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.service.VendorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MqServiceImpl implements MqService {

    private final Logger log = LoggerFactory.getLogger(MqServiceImpl.class);

    @Value("${rabbit.vendor.info.change.exchange}")
    private String vendorExchange;
    @Value("${rabbit.vms.writelog.info.change.exchange}")
    private String writelogExchange;
    @Value("${vms.fanout.truck.company.change.exchange}")
    private String truckCompanyChangeExchange;
    @Value("${rabbit.truck.return.change.exchange}")
    private String truckReturnExchange;
    /**车辆基础信息更新:发送广播消息**/
    @Value("${rabbit.truck.update.exchange}")
    private String truckUpdateExchange;
    /**司机基础信息更新:发送广播消息**/
    @Value("${rabbit.driver.update.exchange}")
    private String driverUpdateExchange;

    @Resource
    private MqSendService mqSendService;
    @Resource
    private VendorService vendorService;

    @Override
    public void sendVendorAfterUpdate(Integer vendorId, Integer tenantId) {
        if (null == vendorId || null == tenantId) {
            return;
        }

        Vendor vendor = vendorService.getVendor(vendorId);
        VendorMq mq = new VendorMq();
        if (null != vendor) {
            mq.setJumaPin(vendor.getJumaPin());
        }

        mq.setVendorId(vendorId);
        mq.setTenantId(tenantId);
        mqSendService.send(vendorExchange, mq);
        log.info("承运商信息修改后发送success,vendorId:{}", vendorId);
    }

    @Override
    public void sendWritelog(OperationLogInfo operationLogInfo) {
        mqSendService.send(writelogExchange, operationLogInfo);
        log.info("异步记录日志发送success,operationLogInfo:{}", JSON.toJSONString(operationLogInfo));
    }

    @Override
    public void sendAfterTruckReturn(TruckReturnMq body) {
        mqSendService.send(truckReturnExchange, body);
        log.info("卡车退车审批通过之后,告知AMS和TSL,truckIdentificationNo:{},tenantId:{}",body.getTruckIdentificationNo(),body.getTenantId());
    }

    @Override
    public void sendTruckCompanyChange(TruckCompanyChangeMq truckCompanyChangeMq) {
        mqSendService.send(truckCompanyChangeExchange, truckCompanyChangeMq);
        log.info("异步通知认领公司变更发送success,truckCompanyChangeMq:{}", JSON.toJSONString(truckCompanyChangeMq));
    }

    @Override
    /**车辆基础信息更新:发送广播消息**/
    public void sendAfterTruckUpdate(Truck truck,String operation){
        if( null == truck ){ return; }
        TruckUpdateEvent event = new TruckUpdateEvent();
        event.setTruckId(truck.getTruckId());
        event.setPlateNumber(truck.getPlateNumber());
        event.setTruckIdentificationNo(truck.getTruckIdentificationNo());
        mqSendService.send(truckUpdateExchange, event);
    }

    @Override
    /**司机基础信息更新:发送广播消息**/
    public void sendAfterDriverUpdate(Driver driver,String operation) {
        if( null == driver ){ return; }
        DriverUpdateEvent event = new DriverUpdateEvent();
        event.setDriverId(driver.getDriverId());
        event.setPhone(driver.getPhone());
        event.setIdCardNo(driver.getIdCardNo());
        mqSendService.send(driverUpdateExchange, event);
    }
}
