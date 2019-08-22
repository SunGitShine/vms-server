package com.juma.vms.transport.dao;

import com.juma.vms.transport.domain.TransportTruckRefund;
import com.juma.vms.transport.domain.TransportTruckRefundExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransportTruckRefundMapper {
    long countByExample(TransportTruckRefundExample example);

    int deleteByExample(TransportTruckRefundExample example);

    int deleteByPrimaryKey(Integer refundId);

    int insert(TransportTruckRefund record);

    int insertSelective(TransportTruckRefund record);

    List<TransportTruckRefund> selectByExample(TransportTruckRefundExample example);

    TransportTruckRefund selectByPrimaryKey(Integer refundId);

    int updateByExampleSelective(@Param("record") TransportTruckRefund record, @Param("example") TransportTruckRefundExample example);

    int updateByExample(@Param("record") TransportTruckRefund record, @Param("example") TransportTruckRefundExample example);

    int updateByPrimaryKeySelective(TransportTruckRefund record);

    int updateByPrimaryKey(TransportTruckRefund record);

    int insertBatch(List<TransportTruckRefund> list);

    int updateBatchByPrimaryKeySelective(List<TransportTruckRefund> list);

    int updateBatch(List<TransportTruckRefund> list);
}