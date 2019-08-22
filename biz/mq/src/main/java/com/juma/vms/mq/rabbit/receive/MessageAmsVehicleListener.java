package com.juma.vms.mq.rabbit.receive;

import com.alibaba.fastjson.JSON;
import com.juma.auth.tenant.domain.Tenant;
import com.juma.auth.tenant.service.TenantService;
import com.juma.server.vm.domain.dto.VehicleQueryConditionDTO;
import com.juma.server.vm.domain1.bo.VehicleBo;
import com.juma.vms.basic.domain.VmEvent;
import com.juma.vms.mq.rabbit.sync.TruckSync;
import com.juma.vms.tool.service.AmsCommonService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import javax.annotation.Resource;
import java.nio.charset.Charset;

public class MessageAmsVehicleListener implements MessageListener {

    private static final Logger log = LoggerFactory.getLogger(MessageAmsVehicleListener.class);

    @Resource
    private TruckSync truckSync;

    @Resource
    private TenantService tenantService;

    @Resource
    private AmsCommonService amsCommonService;

    @Override
    public void onMessage(Message message) {
        log.info("AMS车辆信息同步start");
        String jsonStr = new String(message.getBody(), Charset.forName("utf-8"));
        log.info("AMS车辆信息同步：收到MQ返回信息：{}", jsonStr);
        try {
            if (StringUtils.isBlank(jsonStr)) {
                return;
            }

            VmEvent vmEvent = JSON.parseObject(jsonStr, VmEvent.class);
            String event = vmEvent.getOperateKey();
            log.info("AMS车辆信息同步：operateKey：{}", event);
            if (VmEvent.OperateKey.UPDATE.toString().equals(event)) {
                if (null == vmEvent.getTenantId()) {
                    return;
                }

                Tenant tenant = tenantService.loadTenant(vmEvent.getTenantId());
                if (null == tenant) {
                    return;
                }

                VehicleQueryConditionDTO vehicleQueryConditionDTO = new VehicleQueryConditionDTO();
                vehicleQueryConditionDTO.setVehicleId(vmEvent.getVehicleId());
                vehicleQueryConditionDTO.setTenantId(vmEvent.getTenantId());
                vehicleQueryConditionDTO.setTenantCode(tenant.getTenantCode());
                VehicleBo vehicleBo = amsCommonService.getVehicleBoById(vehicleQueryConditionDTO);
                if (null == vehicleBo || null == vehicleBo.getVehicleExtend()) {
                    return;
                }

                truckSync.syncTruck(vehicleBo, vmEvent.getTenantId());
                log.info("AMS车辆信息同步end");
            }
        } catch (Exception e) {
            log.warn("车辆信息同步：MQ同步信息未成功，返回信息：{}", jsonStr, e);
        }
    }

}
