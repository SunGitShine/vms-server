package com.juma.vms.transport.dao;

import com.juma.vms.transport.domain.CapacityPool;
import com.juma.vms.transport.domain.CapacityPoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CapacityPoolMapper {
    long countByExample(CapacityPoolExample example);

    int deleteByExample(CapacityPoolExample example);

    int deleteByPrimaryKey(Integer capacityPoolId);

    int insert(CapacityPool record);

    int insertSelective(CapacityPool record);

    List<CapacityPool> selectByExample(CapacityPoolExample example);

    CapacityPool selectByPrimaryKey(Integer capacityPoolId);

    int updateByExampleSelective(@Param("record") CapacityPool record, @Param("example") CapacityPoolExample example);

    int updateByExample(@Param("record") CapacityPool record, @Param("example") CapacityPoolExample example);

    int updateByPrimaryKeySelective(CapacityPool record);

    int updateByPrimaryKey(CapacityPool record);

    int insertBatch(List<CapacityPool> list);

    int updateBatchByPrimaryKeySelective(List<CapacityPool> list);

    int updateBatch(List<CapacityPool> list);
}