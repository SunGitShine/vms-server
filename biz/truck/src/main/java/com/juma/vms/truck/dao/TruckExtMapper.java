package com.juma.vms.truck.dao;

import com.juma.vms.common.query.QueryCond;
import com.juma.vms.transport.domain.CapacityPool;
import com.juma.vms.truck.vo.TruckFilters;
import com.juma.vms.truck.vo.TruckQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-20 16:26
 **/
public interface TruckExtMapper {

	Integer findByPlateNumberAndIdentificationNo(@Param("plateNumber") String plateNumber,
		@Param("truckIdentificationNo") String truckIdentificationNo, @Param("tenantId") Integer tenantId);

	int searchCount(QueryCond<TruckQuery> queryCond);

	List<TruckQuery> search(QueryCond<TruckQuery> queryCond);

	List<TruckQuery> listByDriverFilter(QueryCond<TruckQuery> queryCond);

	List<CapacityPool> findByPlateNumber(QueryCond<TruckFilters> truckFilters);

	int findByPlateNumberCount(QueryCond<TruckFilters> truckFilters);
}
