package com.juma.vms.vendor.dao;

import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.domain.VendorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VendorMapper {
    long countByExample(VendorExample example);

    int deleteByExample(VendorExample example);

    int deleteByPrimaryKey(Integer vendorId);

    int insert(Vendor record);

    int insertSelective(Vendor record);

    List<Vendor> selectByExample(VendorExample example);

    Vendor selectByPrimaryKey(Integer vendorId);

    int updateByExampleSelective(@Param("record") Vendor record, @Param("example") VendorExample example);

    int updateByExample(@Param("record") Vendor record, @Param("example") VendorExample example);

    int updateByPrimaryKeySelective(Vendor record);

    int updateByPrimaryKey(Vendor record);

    int insertBatch(List<Vendor> list);

    int updateBatchByPrimaryKeySelective(List<Vendor> list);

    int updateBatch(List<Vendor> list);
}