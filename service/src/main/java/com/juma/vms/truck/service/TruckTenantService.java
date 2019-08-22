package com.juma.vms.truck.service;

import java.util.List;

import com.giants.common.exception.BusinessException;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.truck.domain.TruckTenant;
import com.juma.vms.truck.vo.TruckBo;
import com.juma.vms.truck.vo.TruckTenantQuery;

/**
 * Title: TruckService
 * Description:运力车辆
 * Created by gzq on 2019/3/19.
 */

public interface TruckTenantService {

	TruckTenant getByTruckId(Integer truckId, LoginUser loginUser);

	void addTruckTenant(TruckBo truckBo, boolean isOwner, LoginEmployee loginUser);

	void update(TruckTenant truckTenant, LoginUser loginUser);

	void insert(TruckTenant truckTenant, LoginUser loginUser) throws BusinessException;

	List<TruckTenant> getByTruckId(Integer truckId);

	void clearRelationInfoAfterReturn(Integer truckId, Integer tenantId);

	/**根据认领公司查询列比哦啊**/
	List<TruckTenant> listByQuery(TruckTenantQuery query, Integer tenantId) throws BusinessException;
	
	void batchInsert(List<TruckTenant> rows);
}
