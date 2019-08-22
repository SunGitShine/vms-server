package com.juma.vms.vendor.external;

import java.io.Serializable;
import java.util.List;

import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.domain.VendorTenant;
import com.juma.vms.vendor.domain.VendorTruck;
import com.juma.vms.vendor.domain.VendorVehicle;

/**
 * @ClassName VendorExternal.java
 * @Description 承运商对外类，VMS不能使用，更改或删除请发全员邮件确认
 * @author Libin.Wei
 * @Date 2018年11月1日 上午10:19:26
 * @version 1.0.0
 * @Copyright 2016 www.jumapeisong.com Inc. All rights reserved.
 */

public class VendorExternal implements Serializable {

    private Vendor vendor;
    private VendorTenant vendorTenant;
    private List<VendorTruck> listVendorTruck;

    // 禁止使用；保留原因为了防止FMS接入前报错
    @Deprecated
    private List<VendorVehicle> listVendorVehicle;

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public VendorTenant getVendorTenant() {
        return vendorTenant;
    }

    public void setVendorTenant(VendorTenant vendorTenant) {
        this.vendorTenant = vendorTenant;
    }

    public List<VendorTruck> getListVendorTruck() {
        return listVendorTruck;
    }

    public void setListVendorTruck(List<VendorTruck> listVendorTruck) {
        this.listVendorTruck = listVendorTruck;
    }

    public List<VendorVehicle> getListVendorVehicle() {
        return listVendorVehicle;
    }

    public void setListVendorVehicle(List<VendorVehicle> listVendorVehicle) {
        this.listVendorVehicle = listVendorVehicle;
    }
}
