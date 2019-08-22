package com.juma.vms.operateLog.service;

import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.juma.auth.user.domain.LoginUser;
import com.juma.log.domain.OperationLogInfo;
import com.juma.vms.common.query.QueryCond;
import com.juma.vms.operateLog.domain.OperateLog;
import com.juma.vms.operateLog.vo.OperateLogFilter;
import com.juma.vms.operateLog.vo.OperateLogHistoryQuery;
import com.juma.vms.operateLog.vo.OperateLogQuery;

/**
 * @author Libin.Wei
 * @version 1.0.0
 * @ClassName OperateLogService.java
 * @Description 操作记录
 * @Date 2018年10月31日 上午10:48:16
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

public interface OperateLogService {

    /**
     * 分页获取
     *
     * @param queryCond
     * @param loginUser
     * @return
     * @throws BusinessException
     * @author Libin.Wei
     * @Date 2018年10月31日 上午11:14:27
     */
    Page<OperateLogQuery> search(QueryCond<OperateLogFilter> queryCond, LoginUser loginUser) throws BusinessException;

    /**
     *
     * 分页获取:承运商的历史操作记录
     *
     * @author Libin.Wei
     * @Date 2018年10月31日 上午11:14:27
     * @param queryCond
     * @param loginUser
     * @return
     * @throws BusinessException
     */
    Page<OperateLogHistoryQuery> searchHistory(QueryCond<OperateLog> queryCond, LoginUser loginUser) throws BusinessException;

    /**
     * 添加日志
     * 需要在用户中心的资源管理配置日志模版
     *
     * @param operationLogInfo
     * @param loginUser
     */
    void writelog(OperationLogInfo operationLogInfo, LoginUser loginUser);
}
