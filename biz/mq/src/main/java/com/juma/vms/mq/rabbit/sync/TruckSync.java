package com.juma.vms.mq.rabbit.sync;

import com.juma.server.vm.domain1.bo.VehicleBo;
import com.juma.vms.transport.domain.CapacityPool;
import com.juma.vms.transport.service.TransportService;
import com.juma.vms.truck.domain.Truck;
import com.juma.vms.truck.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class TruckSync {

    @Autowired
    private TruckService truckService;
    @Autowired
    private TransportService transportService;

    public void syncTruck(VehicleBo vehicleBo, Integer tenantId) {

        Truck truck = truckService.findByVehicleId(vehicleBo.getVehicleId());
        //同步车辆
        if(null != truck){
            // 厢型
            int vehicleBoxType = vehicleBo.getVehicleExtend().getVehicleBoxType().intValue();
            truck.setVehicleBoxType(vehicleBoxType);
            // 厢长
            int vehicleBoxLength = vehicleBo.getVehicleExtend().getBoxLevel().intValue();
            truck.setVehicleBoxLength(vehicleBoxLength);
            // 入城证
            int goCityLicenseType = vehicleBo.getVehicleExtend().getGoCityLicenseType().intValue();
            truck.setGoCityLicenseType(goCityLicenseType);
            truckService.updateTruck(truck);

            //同步运力池
            CapacityPool capacityPool = new CapacityPool();
            capacityPool.setTruckId(truck.getTruckId());
            capacityPool.setTenantId(tenantId);
            capacityPool.setIsDelete(false);
            List<CapacityPool> capacityPools = transportService.findByCapacityPool(capacityPool);
            for(CapacityPool c: capacityPools){
                c.setVehicleBoxType(vehicleBoxType);
                c.setVehicleBoxLength(vehicleBoxLength);
                c.setGoCityLicenseType(goCityLicenseType);
                transportService.updateBasicCapacityPool(c);
            }
        }
    }
}
