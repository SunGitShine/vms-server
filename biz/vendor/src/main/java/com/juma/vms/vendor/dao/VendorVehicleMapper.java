package com.juma.vms.vendor.dao;

import com.juma.vms.vendor.domain.VendorVehicle;
import com.juma.vms.vendor.domain.VendorVehicleExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface VendorVehicleMapper {
    int countByExample(VendorVehicleExample example);

    int deleteByExample(VendorVehicleExample example);

    @Delete({
        "delete from vendor_vehicle",
        "where vendor_vehicle_id = #{vendorVehicleId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer vendorVehicleId);

    @Insert({
        "insert into vendor_vehicle (vendor_id, tenant_id, ",
        "vehicle_id, create_time, ",
        "create_user_id, last_update_time, ",
        "last_update_user_id)",
        "values (#{vendorId,jdbcType=INTEGER}, #{tenantId,jdbcType=INTEGER}, ",
        "#{vehicleId,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{createUserId,jdbcType=INTEGER}, #{lastUpdateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdateUserId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="vendorVehicleId", before=false, resultType=Integer.class)
    int insert(VendorVehicle record);

    int insertSelective(VendorVehicle record);

    List<VendorVehicle> selectByExample(VendorVehicleExample example);

    @Select({
        "select",
        "vendor_vehicle_id, vendor_id, tenant_id, vehicle_id, create_time, create_user_id, ",
        "last_update_time, last_update_user_id",
        "from vendor_vehicle",
        "where vendor_vehicle_id = #{vendorVehicleId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    VendorVehicle selectByPrimaryKey(Integer vendorVehicleId);

    int updateByExampleSelective(@Param("record") VendorVehicle record, @Param("example") VendorVehicleExample example);

    int updateByExample(@Param("record") VendorVehicle record, @Param("example") VendorVehicleExample example);

    int updateByPrimaryKeySelective(VendorVehicle record);

    @Update({
        "update vendor_vehicle",
        "set vendor_id = #{vendorId,jdbcType=INTEGER},",
          "tenant_id = #{tenantId,jdbcType=INTEGER},",
          "vehicle_id = #{vehicleId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_user_id = #{createUserId,jdbcType=INTEGER},",
          "last_update_time = #{lastUpdateTime,jdbcType=TIMESTAMP},",
          "last_update_user_id = #{lastUpdateUserId,jdbcType=INTEGER}",
        "where vendor_vehicle_id = #{vendorVehicleId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(VendorVehicle record);
}