package com.juma.vms.driver.dao.ext;

import com.juma.vms.common.query.QueryCond;
import com.juma.vms.driver.domain.Driver;
import com.juma.vms.driver.vo.DriverQuery;
import com.juma.vms.transport.request.CapacityPoolFilter;

import java.util.List;

public interface DriverExtMapper {

    int searchCount(QueryCond<DriverQuery> queryCond);

    List<DriverQuery> search(QueryCond<DriverQuery> queryCond);

    //当前承运商下未关联车辆的司机
    List<DriverQuery> listByDriverFilter(DriverQuery driverQuery);

    //当前登录部门业务范围查询
    List<DriverQuery> listByDriverAreaFilter(DriverQuery driverQuery);

    //当前承运商关联的未设置车辆的司机或未关联承运商的司机
    List<DriverQuery> listByDriverVendorFilter(DriverQuery driverQuery);


    /**
     * 获取是有效运力的司机信息
     *
     * @param capacityPoolFilter
     * @return
     */
    List<Driver> listEffectiveCapacityDriver(CapacityPoolFilter capacityPoolFilter);
}