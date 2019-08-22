package com.juma.vms.vendor.dao;

import com.juma.vms.vendor.domain.VendorTenant;
import com.juma.vms.vendor.domain.VendorTenantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VendorTenantMapper {
    long countByExample(VendorTenantExample example);

    int deleteByExample(VendorTenantExample example);

    int deleteByPrimaryKey(Integer vendorTenantId);

    int insert(VendorTenant record);

    int insertSelective(VendorTenant record);

    List<VendorTenant> selectByExample(VendorTenantExample example);

    VendorTenant selectByPrimaryKey(Integer vendorTenantId);

    int updateByExampleSelective(@Param("record") VendorTenant record, @Param("example") VendorTenantExample example);

    int updateByExample(@Param("record") VendorTenant record, @Param("example") VendorTenantExample example);

    int updateByPrimaryKeySelective(VendorTenant record);

    int updateByPrimaryKey(VendorTenant record);

    int insertBatch(List<VendorTenant> list);

    int updateBatchByPrimaryKeySelective(List<VendorTenant> list);

    int updateBatch(List<VendorTenant> list);
}