package com.juma.vms.operateLog.service;

import com.alibaba.fastjson.JSON;
import com.giants.common.tools.Page;
import com.google.common.collect.Maps;
import com.juma.auth.user.domain.LoginUser;
import com.juma.log.domain.OperationLogInfo;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.operateLog.domain.OperateLog;
import com.juma.vms.operateLog.vo.OperateLogFilter;
import com.juma.vms.operateLog.vo.OperateLogHistoryQuery;
import com.juma.vms.vendor.vo.VendorTenantBo;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import testng.BaseTestNGTest;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class OperateLogServiceImplTest  extends BaseTestNGTest {

    @Resource
    private OperateLogService operateLogService;

    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Test
    public void search() {
        OperateLogFilter filter = new OperateLogFilter();
        filter.setBusinessIdentificationPre("VMS_TRUCK");
        filter.setRalationId(26);

        QueryCond<OperateLogFilter> queryCond = new QueryCond<>();
        queryCond.setFilters(filter);
        queryCond.setPageNo(1);
        queryCond.setPageSize(30);


        operateLogService.search(queryCond, null);
    }

    @Test
    public void searchHistory() {
        OperateLog filter = new OperateLog();
        filter.setRelationTableId(16418);

        QueryCond<OperateLog> queryCond = new QueryCond<>();
        queryCond.setFilters(filter);
        queryCond.setPageNo(1);
        queryCond.setPageSize(30);


        Page<OperateLogHistoryQuery> history = operateLogService.searchHistory(queryCond, null);

    }

    @Test
    public void add() {
        OperationLogInfo info = new OperationLogInfo();
        info.setMethodName("com.juma.vms.vendor.service.VendorTenantService.doDisable");
        VendorTenantBo vendorTenantBo = new VendorTenantBo();
        vendorTenantBo.setVendorTenantId(12369);
        vendorTenantBo.setVendorId(2);
        vendorTenantBo.setRemark("异步写日志测试");
        info.setParam(JSON.toJSONString(vendorTenantBo));
        operateLogService.writelog(info, new LoginUser(2,1));
    }

    @Test
    public void asyncLog(){
//        log.info("绑定司机:日志记录,开始");
        executorService.execute(new Runnable() {
            @Override
            public void run() {
//                log.info("绑定司机:日志记录,线程内开始");
                OperationLogInfo info = new OperationLogInfo();
                info.setMethodName("com.juma.vms.transport.service.impl.TransportReceiveServiceImpl.completeTransport");
                Map<String,Object> params = Maps.newConcurrentMap();
                params.put("vendorId",1);
                params.put("driverId",1);
                params.put("vendorName","测试租户");
                params.put("vendorIdCardNo","51052198810213879");
                params.put("driverName","张三");
                params.put("driverIdCardNo","51052198810213870");
                info.setParam(JSON.toJSONString(params));
                operateLogService.writelog(info, new LoginUser(2,1));
            }
        });
    }

}
