package com.juma.vms.driver.dao;

import com.juma.vms.driver.domain.Driver;
import com.juma.vms.driver.domain.DriverExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DriverMapper {
    long countByExample(DriverExample example);

    int deleteByExample(DriverExample example);

    int deleteByPrimaryKey(Integer driverId);

    int insert(Driver record);

    int insertSelective(Driver record);

    List<Driver> selectByExample(DriverExample example);

    Driver selectByPrimaryKey(Integer driverId);

    int updateByExampleSelective(@Param("record") Driver record, @Param("example") DriverExample example);

    int updateByExample(@Param("record") Driver record, @Param("example") DriverExample example);

    int updateByPrimaryKeySelective(Driver record);

    int updateByPrimaryKey(Driver record);

    int insertBatch(List<Driver> list);

    int updateBatchByPrimaryKeySelective(List<Driver> list);

    int updateBatch(List<Driver> list);
}