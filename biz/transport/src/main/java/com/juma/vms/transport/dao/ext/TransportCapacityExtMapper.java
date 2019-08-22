package com.juma.vms.transport.dao.ext;

import java.util.List;

import com.juma.vms.common.query.QueryCond;
import com.juma.vms.transport.domain.TransportCapacity;
import com.juma.vms.transport.request.TransportSendPageReq;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-25 17:19
 **/
public interface TransportCapacityExtMapper {

	List<TransportCapacity> findCapacityPoolPage(QueryCond<TransportSendPageReq> queryCond);

	Integer findCapacityPoolPageCount(QueryCond<TransportSendPageReq> queryCond);
}
