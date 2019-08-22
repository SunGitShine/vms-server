package com.juma.vms.driver.service.impl;

import com.juma.vms.driver.service.DriverService;
import org.testng.annotations.Test;
import testng.BaseTestNGTest;

import javax.annotation.Resource;

/**
 * @ClassName DriverServiceImplTest
 * @Description TODO
 * @Author weilibin
 * @Date 2019-06-14 11:48
 * @Version 1.0.0
 */

public class DriverServiceImplTest extends BaseTestNGTest {

    @Resource
    private DriverService driverService;

    @Test
    public void updateDriverByUserId() {
        driverService.updateDriverByUserId(47194,"张三1","17812345679",null);
    }
}
