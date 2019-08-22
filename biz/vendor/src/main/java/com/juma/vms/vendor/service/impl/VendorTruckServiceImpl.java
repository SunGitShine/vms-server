package com.juma.vms.vendor.service.impl;

import com.giants.common.exception.BusinessException;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.vendor.dao.VendorTruckMapper;
import com.juma.vms.vendor.domain.VendorTruck;
import com.juma.vms.vendor.domain.VendorTruckExample;
import com.juma.vms.vendor.service.VendorTruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-21 10:45
 **/
@Service
public class VendorTruckServiceImpl implements VendorTruckService {

	@Autowired
	private VendorTruckMapper vendorTruckMapper;

	@Override
	public void addVendorTruck(VendorTruck vendorTruck, LoginUser loginUser) {

		List<VendorTruck> vendorTrucks = listVendorTruckBy(vendorTruck.getVendorId(), vendorTruck.getTruckId(), loginUser);
		if(vendorTrucks == null || vendorTrucks.isEmpty()){
			vendorTruck.setTenantId(loginUser.getTenantId());
			vendorTruck.setTenantCode(loginUser.getTenantCode());
			vendorTruck.setCreateTime(new Date());
			vendorTruck.setCreateUserId(loginUser.getUserId());
			vendorTruckMapper.insertSelective(vendorTruck);
		}
	}

	@Override
	public VendorTruck loadByTruckId(Integer truckId, LoginUser loginUser) {
		if (null == truckId || null == loginUser || null == loginUser.getTenantId()) {
			return null;
		}

		List<VendorTruck> list = vendorTruckMapper.selectByExample(new VendorTruckExample().createCriteria()
				.andTruckIdEqualTo(truckId).andTenantIdEqualTo(loginUser.getTenantId()).example());

		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public List<VendorTruck> listVendorTruckBy(Integer vendorId, Integer truckId, LoginUser loginUser) {
		if (null == loginUser || null == loginUser.getTenantId()) {
			return new ArrayList<>();
		}

		VendorTruckExample example = new VendorTruckExample().createCriteria()
				.andVendorIdEqualTo(vendorId)
				.andTruckIdEqualTo(truckId)
				.andTenantIdEqualTo(loginUser.getTenantId())
				.example();

		return vendorTruckMapper.selectByExample(example);
	}

	@Override
	public void update(VendorTruck vendorTruck, LoginUser loginUser) throws BusinessException {
		vendorTruck.setLastUpdateUserId(loginUser.getUserId());
		vendorTruck.setLastUpdateTime(new Date());
		vendorTruckMapper.updateByPrimaryKeySelective(vendorTruck);
	}

	@Override
	public void insert(VendorTruck vendorTruck, LoginUser loginUser) throws BusinessException {
		vendorTruck.setTenantId(loginUser.getTenantId());
		vendorTruck.setTenantCode(loginUser.getTenantCode());
		vendorTruck.setCreateUserId(loginUser.getUserId());
		vendorTruck.setCreateTime(new Date());
		vendorTruckMapper.insert(vendorTruck);
	}

    @Override
    public List<VendorTruck> listVendorTruck(Integer truckId) {
        if(truckId == null) return new ArrayList<VendorTruck>();
        return vendorTruckMapper.selectByExample(new VendorTruckExample().createCriteria().andTruckIdEqualTo(truckId).example());
    }

	@Override
	public void clearRelationInfoAfterReturn(Integer truckId, Integer vendorId, Integer tenantId) {
		VendorTruckExample example = new VendorTruckExample().createCriteria()
				.andTruckIdEqualTo(truckId)
				.andVendorIdEqualTo(vendorId)
				.andTenantIdEqualTo(tenantId)
				.example();
		List<VendorTruck> vendorTrucks = vendorTruckMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(vendorTrucks) ){
			return;
		}
		// 如果有多条,则循环删除; 这个表有唯一索引, 所以不会有多条的情况
		for (VendorTruck vendorTruck : vendorTrucks) {
			vendorTruckMapper.deleteByPrimaryKey(vendorTruck.getVendorTruckId());
		}
	}

}
