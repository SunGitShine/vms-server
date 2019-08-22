package com.juma.vms.basic.domain;

import java.io.Serializable;

public class VmEvent implements Serializable {

    private static final long serialVersionUID = 965646829318478642L;
    private Integer vehicleId;
    private Integer tenantId;
    private String operateKey;

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getOperateKey() {
        return operateKey;
    }

    public void setOperateKey(String operateKey) {
        this.operateKey = operateKey;
    }

    // 电子围栏出发类型
    public enum OperateKey {
        ADD(1, "添加"), UPDATE(2, "更改"), DELETE(2, "删除");

        private int code;

        private String descr;

        private OperateKey(int code, String descr) {
            this.code = code;
            this.descr = descr;
        }

        public int getCode() {
            return code;
        }

        public String getDescr() {
            return descr;
        }
    }

}
