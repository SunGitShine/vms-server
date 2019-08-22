package com.juma.vms.transport.dao;

import com.juma.vms.transport.domain.TransportCapacityItem;
import com.juma.vms.transport.domain.TransportCapacityItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransportCapacityItemMapper {
    long countByExample(TransportCapacityItemExample example);

    int deleteByExample(TransportCapacityItemExample example);

    int deleteByPrimaryKey(Integer itemId);

    int insert(TransportCapacityItem record);

    int insertSelective(TransportCapacityItem record);

    List<TransportCapacityItem> selectByExample(TransportCapacityItemExample example);

    TransportCapacityItem selectByPrimaryKey(Integer itemId);

    int updateByExampleSelective(@Param("record") TransportCapacityItem record, @Param("example") TransportCapacityItemExample example);

    int updateByExample(@Param("record") TransportCapacityItem record, @Param("example") TransportCapacityItemExample example);

    int updateByPrimaryKeySelective(TransportCapacityItem record);

    int updateByPrimaryKey(TransportCapacityItem record);

    int insertBatch(List<TransportCapacityItem> list);

    int updateBatchSelective(List<TransportCapacityItem> list);
}