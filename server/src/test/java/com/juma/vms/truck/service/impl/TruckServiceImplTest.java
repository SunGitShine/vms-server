package com.juma.vms.truck.service.impl;

import com.alibaba.fastjson.JSON;
import com.juma.vms.truck.domain.Truck;
import com.juma.vms.truck.service.TruckService;
import javax.annotation.Resource;
import org.testng.annotations.Test;
import testng.BaseTestNGTest;

/**
 * @ClassName TruckServiceImplTest
 * @Description TODO
 * @Author weilibin
 * @Date 2019-06-24 11:00
 * @Version 1.0.0
 */

public class TruckServiceImplTest extends BaseTestNGTest {

    @Resource
    private TruckService truckService;

    @Test
    public void loadTruckById() {
        Truck truck = truckService.getTruck(331);
        System.out.println(JSON.toJSONString(truck));

    }
}
