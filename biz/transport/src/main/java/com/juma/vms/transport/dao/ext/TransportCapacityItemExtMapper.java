package com.juma.vms.transport.dao.ext;

import java.util.List;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-26 10:59
 **/
public interface TransportCapacityItemExtMapper {

	List<String> selectPlateNumber(Integer transportId);
}
