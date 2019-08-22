package com.juma.vms.mq.rabbit.sync;

import com.juma.auth.user.domain.User;
import com.juma.auth.user.service.UserService;
import com.juma.vms.driver.service.DriverService;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @ClassName DriverSync
 * @Description TODO
 * @Author weilibin
 * @Date 2019-06-14 11:36
 * @Version 1.0.0
 */

@Component
public class DriverSync {

    @Resource
    private DriverService driverService;
    @Resource
    private UserService userService;

    public void doDriverNameAndPhoneSync(Integer userId) {
        if (null == userId) {
            return;
        }

        User user = userService.loadUser(userId);
        if (null == user) {
            return;
        }

        driverService.updateDriverByUserId(userId, user.getName(), user.getMobileNumber(), null);
    }
}
