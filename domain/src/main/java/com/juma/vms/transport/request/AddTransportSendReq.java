package com.juma.vms.transport.request;

import java.io.Serializable;
import java.util.List;

import com.juma.vms.transport.domain.TransportCapacity;
import com.juma.vms.transport.domain.TransportCapacityItem;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-26 11:45
 **/
public class AddTransportSendReq implements Serializable {

	private TransportCapacity transportCapacity;

	private List<TransportCapacityItem> transportCapacityItems;

	public TransportCapacity getTransportCapacity() {
		return transportCapacity;
	}

	public void setTransportCapacity(TransportCapacity transportCapacity) {
		this.transportCapacity = transportCapacity;
	}

	public List<TransportCapacityItem> getTransportCapacityItems() {
		return transportCapacityItems;
	}

	public void setTransportCapacityItems(
		List<TransportCapacityItem> transportCapacityItems) {
		this.transportCapacityItems = transportCapacityItems;
	}
}
