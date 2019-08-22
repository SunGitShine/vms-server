package com.juma.vms.vendor.dao;

import com.juma.vms.vendor.domain.VendorWhiteList;
import com.juma.vms.vendor.domain.VendorWhiteListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VendorWhiteListMapper {
    long countByExample(VendorWhiteListExample example);

    int deleteByExample(VendorWhiteListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VendorWhiteList record);

    int insertSelective(VendorWhiteList record);

    List<VendorWhiteList> selectByExample(VendorWhiteListExample example);

    VendorWhiteList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VendorWhiteList record, @Param("example") VendorWhiteListExample example);

    int updateByExample(@Param("record") VendorWhiteList record, @Param("example") VendorWhiteListExample example);

    int updateByPrimaryKeySelective(VendorWhiteList record);

    int updateByPrimaryKey(VendorWhiteList record);

    int insertBatch(List<VendorWhiteList> list);

    int updateBatchByPrimaryKeySelective(List<VendorWhiteList> list);

    int updateBatch(List<VendorWhiteList> list);
}