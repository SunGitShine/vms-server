package com.juma.vms.tool.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.juma.auth.user.domain.User;
import com.juma.vms.mq.service.MqService;
import com.juma.vms.transport.service.InitService;
import com.juma.vms.vendor.service.VendorService;

import testng.BaseTestNGTest;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-20 14:06
 **/
public class ToolServiceTest extends BaseTestNGTest {

	@Resource
	private ScmCommonService scmCommonService;
	@Resource
	private VendorService vendorService;
	@Resource
	private MqService mqService;
	@Resource
	private AuthCommonService authCommonService;

	@Resource
	private InitService initService;
	
	@Test
	public void init(){
	    initService.initDriver();
	}
	
	@Test
	public void listByKeys() {
		List<String> keys = new ArrayList<>();
		keys.add("pzlx31");
		keys.add("energyType");
		keys.add("emissionStandard");
		System.out.println(JSON.toJSONString(scmCommonService.getPropertyValueByKeys(keys)));
	}

	@Test
	public void send() {
		mqService.sendVendorAfterUpdate(16427, 9);
	}

	@Test
	public void loadUser() {
		User user = authCommonService.loadUser(1);
		System.out.println(JSON.toJSONString(user));
	}

}
