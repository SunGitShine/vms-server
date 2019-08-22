package com.juma.vms.vendor.dao;

import com.juma.vms.vendor.domain.VendorDriver;
import com.juma.vms.vendor.domain.VendorDriverExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VendorDriverMapper {
    long countByExample(VendorDriverExample example);

    int deleteByExample(VendorDriverExample example);

    int deleteByPrimaryKey(Integer vendorDriverId);

    int insert(VendorDriver record);

    int insertSelective(VendorDriver record);

    List<VendorDriver> selectByExample(VendorDriverExample example);

    VendorDriver selectByPrimaryKey(Integer vendorDriverId);

    int updateByExampleSelective(@Param("record") VendorDriver record, @Param("example") VendorDriverExample example);

    int updateByExample(@Param("record") VendorDriver record, @Param("example") VendorDriverExample example);

    int updateByPrimaryKeySelective(VendorDriver record);

    int updateByPrimaryKey(VendorDriver record);

    int insertBatch(List<VendorDriver> list);

    int updateBatchSelective(List<VendorDriver> list);
}