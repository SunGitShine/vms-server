package com.juma.vms.external.service;

import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.giants.common.tools.PageQueryCondition;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.domain.VendorTenant;
import com.juma.vms.vendor.external.VendorExternal;
import com.juma.vms.vendor.external.VendorExternalFilter;
import com.juma.vms.vendor.external.VendorQueryConditionDto;
import com.juma.vms.vendor.vo.VendorFilter;
import com.juma.vms.vendor.vo.VendorIdentification;
import com.juma.vms.vendor.vo.VendorQuery;
import java.util.List;

/**
 * @ClassName VendorExternalService.java
 * @Description 承运商对外类
 * @author Libin.Wei
 * @Date 2018年10月31日 下午7:07:57
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

public interface VendorExternalService {

    /**
     * 
     * 根据承运商ID获取承运商基础信息
     * 
     * @author Libin.Wei
     * @Date 2018年11月7日 上午9:57:25
     * @param vendorId
     *            必填
     * @return
     */
    Vendor loadByVenorId(Integer vendorId);

    /**
     * 
     * 根据承运商ID获取承运商基础信息
     * 
     * @author Libin.Wei
     * @Date 2018年11月7日 上午9:57:25
     * @param vendorId
     *            必填
     * @param tenantId
     *            必填
     * @return
     */
    Vendor loadByVenorIdTenant(Integer vendorId, Integer tenantId);

    /**
     * 
     * 根据承运商名称获取
     * 
     * @author Libin.Wei
     * @Date 2018年11月2日 下午2:44:50
     * @param vendorName
     *            承运商名称,可为空
     * @param areaCode
     *            业务区域,可为空
     * @param backPageSize
     *            返回数量,可为空，默认100
     * @param loginUser
     *            用户登录信息,可为空
     * @return
     */
    @Deprecated
    List<VendorQuery> listVendorByVendorNameLike(String vendorName, String areaCode, Integer backPageSize,
            LoginUser loginUser);

    /**
     * 根据条件获取
     *
     * @param vendorExternalFilter 查询条件
     * @param backPageSize         最大返回条数，默认15，最大100
     * @param loginUser            可以为空，为空则不区分租户
     *
     * @return
     */
    List<VendorQuery> listVendorByFilter(VendorExternalFilter vendorExternalFilter, Integer backPageSize,
        LoginUser loginUser);

    /**
     * 
     * 根据手机号获取承运商信息，只返回基础信息
     * 
     * @author Libin.Wei
     * @Date 2018年11月1日 上午10:30:21
     * @param phone
     *            手机号，不支持模糊查询，不能为空
     * @return
     */
    Vendor loadVendorByPhone(String phone);

    /**
     * 根据用户ID获取承运商信息
     * @param userId
     * @return
     */
    Vendor loadVendorByUserId(Integer userId);

    /**
     * 
     * 根据手机号获取承运商信息，含有租户信息、车辆信息
     * 
     * @author Libin.Wei
     * @Date 2018年11月1日 上午10:30:21
     * @param phone
     *            手机号，不支持模糊查询，不能为空
     * @param loginUser
     *            当前登录人信息, 不能为空，必须含有租户信息
     * @return
     */
    VendorExternal loadVendorByPhoneAndTenant(String phone, LoginUser loginUser);

    /**
     * 
     * 只对AMS提供服，其它系统请不要使用---根据车辆Id获取承运商信息
     * 
     * @author Libin.Wei
     * @Date 2018年11月1日 上午10:36:37
     * @param vehicleId
     *            车辆ID，不能为空
     * @param loginUser
     *            当前登录人信息, 不能为空，必须含有租户信息
     * @return list
     */
    @Deprecated
    List<Vendor> loadByVendorByVehicleId(Integer vehicleId, LoginUser loginUser);

    /**
     * 根据车辆Id获取承运商信息
     *
     * @param truckId
     * @param loginUser
     * @return
     */
    Vendor loadVendorByTruckId(Integer truckId, LoginUser loginUser);

    /**
     * 
     * 根据车牌号获取承运商信息
     * 
     * @author Libin.Wei
     * @Date 2018年11月1日 上午10:36:37
     * @param plateNumber
     *            车牌号，不能为空
     * @param loginUser
     *            当前登录人信息, 不能为空，必须含有租户信息
     * @return list
     */
    List<Vendor> loadByVendorByPlateNumber(String plateNumber, LoginUser loginUser);

    /**
     * 
     * 根据身份证号获取承运商信息，只返回基础信息
     * 
     * @author Libin.Wei
     * @Date 2018年11月1日 上午10:36:37
     * @param idCardNo
     *            身份证号，不能为空
     * @return
     */
    Vendor loadByVendorByIdCardNo(String idCardNo);

    /**
     * 
     * 根据身份证号获取承运商信息，含有租户信息、车辆信息
     * 
     * @author Libin.Wei
     * @Date 2018年11月1日 上午10:36:37
     * @param idCardNo
     *            身份证号，不能为空
     * @param loginUser
     *            当前登录人信息, 不能为空，必须含有租户信息
     * @return
     */
    VendorExternal loadByVendorByIdCardNoAndTenant(String idCardNo, LoginUser loginUser);

    /**
     *
     * 不再对外提供服务：----承运商绑定租户
     *
     * @author Libin.Wei
     * @Date 2018年11月1日 下午3:28:27
     * @param vendorTenant
     *            其中vendorId、tenantId、areaCode 必填
     * @param authKey
     *            系统KEY， 必填
     * @param loginUser
     *            loginUser 必填
     * @throws BusinessException
     */
    @Deprecated
    void bindTenant(VendorTenant vendorTenant, String authKey, LoginUser loginUser) throws BusinessException;

    /**
     *
     * 不再对外提供服务：----新增承运商,若入参含有承运商ID（vendorId），则创建承运商与租户的绑定关系，若绑定关系存在，则继续执行绑定车的操作
     *
     * @author Libin.Wei
     * @Date 2018年11月14日 上午10:38:04
     * @param vendorExternal
     *            承运商信息
     * @param authKey
     *            系统KEY， 必填
     * @param loginUser
     *            登录人信息
     * @return vendorId
     * @throws BusinessException
     */
    @Deprecated
    Integer addVendor(VendorExternal vendorExternal, String authKey, LoginUser loginUser) throws BusinessException;

    /**
     *
     * 分页：根据条件获取
     *
     * @author Libin.Wei
     * @Date 2018年12月11日 下午2:44:50
     * @param pageQueryCondition
     *            可选参数，其中tenantId不能为空
     *            pageNo默认1
     *            pageSize默认15，最大200
     * @return
     * @throws BusinessException
     */
    Page<VendorQuery> listVendorBy(PageQueryCondition<VendorQueryConditionDto> pageQueryCondition) throws BusinessException;

    /**
     * 承运商主数据中心认证
     *
     * @param vendorIdentification
     * @param loginUser
     * @return
     * @throws BusinessException
     */
    String vendorIdentification(VendorIdentification vendorIdentification, LoginUser loginUser) throws BusinessException;

    /**
     * 承运商名称模糊查询承运商列表
     * @param vendorFilter
     * @param pageSize
     * @param loginUser
     * @return
     */
    List<VendorQuery> listByVendorFilter(VendorFilter vendorFilter, Integer pageSize, LoginUser loginUser);

    /**根据司机ID,获取对应租户下的承运商**/
    Vendor loadByDriverWithTenant(Integer driverId, LoginUser loginUser);
}
