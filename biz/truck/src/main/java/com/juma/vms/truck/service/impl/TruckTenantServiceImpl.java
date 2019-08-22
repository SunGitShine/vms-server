package com.juma.vms.truck.service.impl;

import com.giants.common.exception.BusinessException;
import com.juma.auth.employee.domain.Department;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.auth.employee.service.DepartmentService;
import com.juma.auth.support.service.DepartmentSupportService;
import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.truck.dao.TruckTenantMapper;
import com.juma.vms.truck.domain.TruckTenant;
import com.juma.vms.truck.domain.TruckTenantExample;
import com.juma.vms.truck.enumeration.TruckStatusEnum;
import com.juma.vms.truck.service.TruckTenantService;
import com.juma.vms.truck.vo.TruckBo;
import com.juma.vms.truck.vo.TruckTenantQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * Title: TruckServiceImpl
 * Description:运力车辆
 * Created by gzq on 2019/3/19.
 */
@Service
public class TruckTenantServiceImpl implements TruckTenantService {

	private final static Logger log = LoggerFactory.getLogger(TruckTenantServiceImpl.class);

	@Autowired
	private TruckTenantMapper truckTenantMapper;

	@Autowired
	private DepartmentService departmentService;

	@Override
	public TruckTenant getByTruckId(Integer truckId, LoginUser loginUser) {
		if(null == truckId || null == loginUser || null == loginUser.getTenantId()){
			return null;
		}
		List<TruckTenant> list = truckTenantMapper.selectByExample(new TruckTenantExample().createCriteria()
				.andTruckIdEqualTo(truckId).andTenantIdEqualTo(loginUser.getTenantId()).example());
		return list.isEmpty()? null : list.get(0);
	}

	@Override
	public void addTruckTenant(TruckBo truckBo, boolean isOwner, LoginEmployee loginUser) {

		TruckTenant truckTenant = new TruckTenant();
		truckTenant.setTruckId(truckBo.getTruckId());
		truckTenant.setAreaCode(truckBo.getAreaCode());
		truckTenant.setIsOwner(isOwner);
		truckTenant.setTruckBelongToCompany(truckBo.getTruckBelongToCompany());
		Department department = departmentService.loadDepartment(truckBo.getTruckBelongToCompany());
		truckTenant.setTruckBelongToCompanyCode(department.getDepartmentCode());
		truckTenant.setTenantId(loginUser.getTenantId());
		truckTenant.setTenantCode(loginUser.getTenantCode());
		truckTenant.setCreateTime(new Date());
		truckTenant.setCreateUserId(loginUser.getUserId());
		truckTenant.setStatus(truckBo.getTruckStatus());
		truckTenantMapper.insertSelective(truckTenant);
	}

	@Override
	public void update(TruckTenant truckTenant, LoginUser loginUser) {
		if(truckTenant.getTruckBelongToCompany() != null){
			Department department = departmentService.loadDepartment(truckTenant.getTruckBelongToCompany());
			truckTenant.setTruckBelongToCompanyCode(department.getDepartmentCode());
		}
		truckTenant.setLastUpdateUserId(loginUser.getUserId());
		truckTenant.setLastUpdateTime(new Date());
		truckTenantMapper.updateByPrimaryKey(truckTenant);
	}

	@Override
	public void insert(TruckTenant truckTenant, LoginUser loginUser) throws BusinessException {
		truckTenant.setTenantId(loginUser.getTenantId());
		truckTenant.setTenantCode(loginUser.getTenantCode());
		truckTenant.setCreateUserId(loginUser.getUserId());
		truckTenant.setCreateTime(new Date());
		truckTenantMapper.insert(truckTenant);
	}

	@Override
	public List<TruckTenant> getByTruckId(Integer truckId) {
		if(null == truckId){
			return null;
		}
		List<TruckTenant> list = truckTenantMapper.selectByExample(new TruckTenantExample().createCriteria()
			.andTruckIdEqualTo(truckId).example());
		return list;
	}

	/**清除车辆和认领公司的关系并修改车辆状态**/
	@Override
	public void clearRelationInfoAfterReturn(Integer truckId, Integer tenantId) {
		TruckTenantExample example = new TruckTenantExample().createCriteria()
				.andTruckIdEqualTo(truckId)
				.andTenantIdEqualTo(tenantId)
				.example();
		List<TruckTenant> list = truckTenantMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(list)){
			log.error("clear params:truckId:{},tenantId:{},departmentId:{} error : null list ",new Object[]{truckId,tenantId});
		}
		if( list.size() > 1){
			log.error("clear params:truckId:{},tenantId:{},departmentId:{} error : more than one cell",new Object[]{truckId,tenantId});
		}
		for (TruckTenant truckTenant : list) {
			truckTenant.setTruckBelongToCompany(null);
			truckTenant.setTruckBelongToCompanyCode("");
			truckTenant.setStatus(TruckStatusEnum.ALREADY_CAR_BACK.getCode());
			truckTenantMapper.updateByPrimaryKey(truckTenant);
		}
	}

	@Override
	public List<TruckTenant> listByQuery(TruckTenantQuery query, Integer tenantId) throws BusinessException {
		TruckTenantExample example = new TruckTenantExample().createCriteria()
				.andTruckBelongToCompanyIn(query.getDepartmentIds())
				.andTruckBelongToCompanyCodeLike(query.getDepartmentCode()+"%")
				.andTruckIdIn(query.getTruckIds())
				.andTenantIdEqualTo(tenantId)
				.example();
		return truckTenantMapper.selectByExample(example);
	}

    @Override
    public void batchInsert(List<TruckTenant> rows) {
        truckTenantMapper.insertBatch(rows);
    }
}
