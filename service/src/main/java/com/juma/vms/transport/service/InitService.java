package com.juma.vms.transport.service;

public interface InitService {

    /**
     * 司机的初始化
     */
    void initDriver();
    
    /**
     * 车的初始化
     */
    void initTruck();
    
    /**
     * 运力池的初始化
     */
    void initPool();
    
}
