package com.juma.vms.driver.dao;

import com.juma.vms.driver.domain.DriverTenant;
import com.juma.vms.driver.domain.DriverTenantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DriverTenantMapper {
    long countByExample(DriverTenantExample example);

    int deleteByExample(DriverTenantExample example);

    int deleteByPrimaryKey(Integer driverTenantId);

    int insert(DriverTenant record);

    int insertSelective(DriverTenant record);

    List<DriverTenant> selectByExample(DriverTenantExample example);

    DriverTenant selectByPrimaryKey(Integer driverTenantId);

    int updateByExampleSelective(@Param("record") DriverTenant record, @Param("example") DriverTenantExample example);

    int updateByExample(@Param("record") DriverTenant record, @Param("example") DriverTenantExample example);

    int updateByPrimaryKeySelective(DriverTenant record);

    int updateByPrimaryKey(DriverTenant record);

    int insertBatch(List<DriverTenant> list);

    int updateBatchByPrimaryKeySelective(List<DriverTenant> list);

    int updateBatch(List<DriverTenant> list);
}