package com.juma.vms.transport.dao;

import com.juma.vms.transport.domain.TransportCapacity;
import com.juma.vms.transport.domain.TransportCapacityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransportCapacityMapper {
    long countByExample(TransportCapacityExample example);

    int deleteByExample(TransportCapacityExample example);

    int deleteByPrimaryKey(Integer transportId);

    int insert(TransportCapacity record);

    int insertSelective(TransportCapacity record);

    List<TransportCapacity> selectByExample(TransportCapacityExample example);

    TransportCapacity selectByPrimaryKey(Integer transportId);

    int updateByExampleSelective(@Param("record") TransportCapacity record, @Param("example") TransportCapacityExample example);

    int updateByExample(@Param("record") TransportCapacity record, @Param("example") TransportCapacityExample example);

    int updateByPrimaryKeySelective(TransportCapacity record);

    int updateByPrimaryKey(TransportCapacity record);

    int insertBatch(List<TransportCapacity> list);

    int updateBatchByPrimaryKeySelective(List<TransportCapacity> list);

    int updateBatch(List<TransportCapacity> list);
}