package com.juma.vms.vendor.dao;

import com.juma.vms.vendor.domain.VendorTruck;
import com.juma.vms.vendor.domain.VendorTruckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VendorTruckMapper {
    long countByExample(VendorTruckExample example);

    int deleteByExample(VendorTruckExample example);

    int deleteByPrimaryKey(Integer vendorTruckId);

    int insert(VendorTruck record);

    int insertSelective(VendorTruck record);

    List<VendorTruck> selectByExample(VendorTruckExample example);

    VendorTruck selectByPrimaryKey(Integer vendorTruckId);

    int updateByExampleSelective(@Param("record") VendorTruck record, @Param("example") VendorTruckExample example);

    int updateByExample(@Param("record") VendorTruck record, @Param("example") VendorTruckExample example);

    int updateByPrimaryKeySelective(VendorTruck record);

    int updateByPrimaryKey(VendorTruck record);

    int insertBatch(List<VendorTruck> list);

    int updateBatchSelective(List<VendorTruck> list);
}