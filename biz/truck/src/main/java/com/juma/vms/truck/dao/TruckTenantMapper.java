package com.juma.vms.truck.dao;

import com.juma.vms.truck.domain.TruckTenant;
import com.juma.vms.truck.domain.TruckTenantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TruckTenantMapper {
    long countByExample(TruckTenantExample example);

    int deleteByExample(TruckTenantExample example);

    int deleteByPrimaryKey(Integer truckTenantId);

    int insert(TruckTenant record);

    int insertSelective(TruckTenant record);

    List<TruckTenant> selectByExample(TruckTenantExample example);

    TruckTenant selectByPrimaryKey(Integer truckTenantId);

    int updateByExampleSelective(@Param("record") TruckTenant record, @Param("example") TruckTenantExample example);

    int updateByExample(@Param("record") TruckTenant record, @Param("example") TruckTenantExample example);

    int updateByPrimaryKeySelective(TruckTenant record);

    int updateByPrimaryKey(TruckTenant record);

    int insertBatch(List<TruckTenant> list);

    int updateBatchByPrimaryKeySelective(List<TruckTenant> list);

    int updateBatch(List<TruckTenant> list);
}