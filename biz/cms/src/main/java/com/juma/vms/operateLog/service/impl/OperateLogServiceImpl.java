package com.juma.vms.operateLog.service.impl;

import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.giants.common.tools.PageQueryCondition;
import com.juma.auth.conf.domain.SystemAuth;
import com.juma.auth.conf.service.SystemAuthService;
import com.juma.auth.user.domain.LoginUser;
import com.juma.auth.user.domain.User;
import com.juma.log.domain.OperationLogBo;
import com.juma.log.domain.OperationLogFilter;
import com.juma.log.domain.OperationLogInfo;
import com.juma.log.service.OperationLogService;
import com.juma.vms.common.Constants;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.mq.service.MqService;
import com.juma.vms.operateLog.dao.OperateLogMapper;
import com.juma.vms.operateLog.domain.OperateLog;
import com.juma.vms.operateLog.domain.OperateLogExample;
import com.juma.vms.operateLog.enumeration.LogSignEnum;
import com.juma.vms.operateLog.service.OperateLogService;
import com.juma.vms.operateLog.vo.OperateLogFilter;
import com.juma.vms.operateLog.vo.OperateLogHistoryQuery;
import com.juma.vms.operateLog.vo.OperateLogQuery;
import com.juma.vms.tool.service.AuthCommonService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OperateLogServiceImpl.java
 * @Description 操作记录
 * @author Libin.Wei
 * @Date 2018年10月31日 上午11:12:54
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

@Service
public class OperateLogServiceImpl implements OperateLogService {

    private  final Logger log = LoggerFactory.getLogger(OperateLogServiceImpl.class);
    @Resource
    private OperateLogMapper operateLogMapper;
    @Resource
    private OperationLogService operationLogService;
    @Resource
    private SystemAuthService systemAuthService;
    @Resource
    private AuthCommonService authCommonService;
    @Resource
    private MqService mqService;

    @Override
    public Page<OperateLogQuery> search(QueryCond<OperateLogFilter> queryCond, LoginUser loginUser) throws BusinessException {
        List<OperateLogQuery> result = new ArrayList<>();

        OperateLogFilter filters = queryCond.getFilters();
        if (null == filters || null == filters.getRalationId()
                || StringUtils.isBlank(filters.getBusinessIdentificationPre())
                || null == loginUser || null == loginUser.getTenantId()
        ) {
            return new Page<>(queryCond.getPageNo(), queryCond.getPageSize(), 0, result);
        }

        // 获取系统ID
        SystemAuth systemAuth = systemAuthService.loadSystemAuth(Constants.AUTH_KEY_VMS_MANAGE);
        if (null == systemAuth) {
            return new Page<>(queryCond.getPageNo(), queryCond.getPageSize(), 0, result);
        }

        // 组装业务标识
        String BusinessIdentification = filters.getBusinessIdentificationPre().trim() + ":" + filters.getRalationId();

        OperationLogFilter filter = new OperationLogFilter();
        filter.setPrimaryKeyValue(BusinessIdentification);
        filter.setSystemType(Constants.SYSTEM_TYPE);
        filter.setSystemAuthId(systemAuth.getSystemAuthId());
        filter.setTenantId(loginUser.getTenantId());
        filter.setSuccess(true);
        PageQueryCondition<OperationLogFilter> pageQueryCondition = new PageQueryCondition<>(filter);
        pageQueryCondition.setPageNo(queryCond.getPageNo());
        pageQueryCondition.setPageSize(queryCond.getPageSize());

        Page<OperationLogBo> page = null;
        try {
            page = operationLogService.searchPages(pageQueryCondition);

        } catch (Exception e) {
            if (e instanceof BusinessException) {
                throw e;
            }

            log.info("调用用户中心获取日志失败: {}", e.getMessage());
            throw new BusinessException("errors.common.prompt", "errors.common.prompt", "调用用户中心获取日志失败");

        }

        if (null == page || CollectionUtils.isEmpty(page.getResults())) {
            return new Page<>(queryCond.getPageNo(), queryCond.getPageSize(), 0, result);
        }


        // 组装数据
        for (OperationLogBo bo : page.getResults()) {
            OperateLogQuery q = new OperateLogQuery();
//            q.setOperateLogId(bo.getLogId().intValue());
            // 操作类型
            q.setOperateTypeName(bo.getResourceName());
            // 操作时间
            q.setCreateTime(bo.getOperationTime());
            // 操作人
            q.setCreateUserId(bo.getUserId());
            User user = authCommonService.loadUser(bo.getUserId());
            if (null != user) {
                q.setCreateUserName(user.getName());
                q.setCreateUserPhone(user.getMobileNumber());
            }
            // 备注
            q.setRemark(bo.getLogDetails());
            result.add(q);
        }

        return new Page<OperateLogQuery>(queryCond.getPageNo(), queryCond.getPageSize(), page.getTotal(), result);
    }

    @Override
    public Page<OperateLogHistoryQuery> searchHistory(QueryCond<OperateLog> queryCond, LoginUser loginUser) throws BusinessException {
        List<OperateLogHistoryQuery> result = new ArrayList<>();
        OperateLog filters = queryCond.getFilters();
        if (null == filters || null == filters.getRelationTableId()) {
            return new Page<>(queryCond.getPageNo(), queryCond.getPageSize(), 0, result);
        }

        OperateLogExample example = new OperateLogExample().createCriteria()
                .andRelationTableIdEqualTo(filters.getRelationTableId())
                .andLogSignEqualTo(LogSignEnum.VENDOR.getCode())
                .example();
        example.setSize(queryCond.getPageSize());
        example.setStartOffSet(queryCond.getStartOffset());
        example.setOrderByClause(OperateLog.Column.operateLogId.desc());


        long count = operateLogMapper.countByExample(example);
        List<OperateLog> rows = operateLogMapper.selectByExample(example);
        for (OperateLog p : rows) {
            OperateLogHistoryQuery q = new OperateLogHistoryQuery();
            BeanUtils.copyProperties(p, q);

            // 操作人
            User user = authCommonService.loadUser(p.getCreateUserId());
            if (null != user) {
                q.setCreateUserName(user.getName());
                q.setCreateUserPhone(user.getMobileNumber());
            }
            result.add(q);
        }
        return new Page<>(queryCond.getPageNo(), queryCond.getPageSize(), Integer.valueOf(String.valueOf(count)), result);
    }

    @Override
    public void writelog(OperationLogInfo operationLogInfo, LoginUser loginUser) {
        if (null == operationLogInfo || null == operationLogInfo.getMethodName()
                || null == operationLogInfo.getParam() || null == loginUser
                || null == loginUser.getUserId() || null == loginUser.getTenantId()
        ) {
            return;
        }

        operationLogInfo.setTenantId(loginUser.getTenantId());
        operationLogInfo.setUserId(loginUser.getUserId());
        operationLogInfo.setSuccess(true);
        mqService.sendWritelog(operationLogInfo);
    }

}
