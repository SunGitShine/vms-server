package com.juma.vms.mq.rabbit.receive;

import java.nio.charset.Charset;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import com.alibaba.fastjson.JSON;
import com.juma.crm.ams.domain.RenterSync;
import com.juma.vms.mq.rabbit.sync.VendorSync;

public class MessageCrmVendorListener implements MessageListener {

    private final Logger log = LoggerFactory.getLogger(MessageCrmVendorListener.class);
    @Resource
    private VendorSync vendorSync;
    
    @Override
    public void onMessage(Message message) {
        log.info("同步crm承运商信息 start...");
        try {
            String jsonStr = new String(message.getBody(), Charset.forName("utf-8"));
            log.info("同步crm承运商信息参数{}.", jsonStr);
            RenterSync renterSync = JSON.parseObject(jsonStr, RenterSync.class);
            if (StringUtils.isBlank(renterSync.getProjectOwnershipBrand())) {
                return;
            }
            vendorSync.doVendorSync(renterSync);
        } catch (Exception e) {
            log.warn("同步crm承运商信息异常 :{}" + e.getMessage());
        }
    }

}
