package com.juma.vms.operateLog.dao;

import com.juma.vms.operateLog.domain.OperateLog;
import com.juma.vms.operateLog.domain.OperateLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperateLogMapper {
    long countByExample(OperateLogExample example);

    int deleteByExample(OperateLogExample example);

    int deleteByPrimaryKey(Integer operateLogId);

    int insert(OperateLog record);

    int insertSelective(OperateLog record);

    List<OperateLog> selectByExample(OperateLogExample example);

    OperateLog selectByPrimaryKey(Integer operateLogId);

    int updateByExampleSelective(@Param("record") OperateLog record, @Param("example") OperateLogExample example);

    int updateByExample(@Param("record") OperateLog record, @Param("example") OperateLogExample example);

    int updateByPrimaryKeySelective(OperateLog record);

    int updateByPrimaryKey(OperateLog record);

    int insertBatch(List<OperateLog> list);

    int updateBatchByPrimaryKeySelective(List<OperateLog> list);

    int updateBatch(List<OperateLog> list);
}