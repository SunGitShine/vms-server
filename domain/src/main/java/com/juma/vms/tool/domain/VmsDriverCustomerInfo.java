package com.juma.vms.tool.domain;

import java.io.Serializable;

public class VmsDriverCustomerInfo implements Serializable {

    private Integer crmDriverCustomerId;
    private String crmDrivercustomerName;
    private String mobileNumber;

    public Integer getCrmDriverCustomerId() {
        return crmDriverCustomerId;
    }

    public void setCrmDriverCustomerId(Integer crmDriverCustomerId) {
        this.crmDriverCustomerId = crmDriverCustomerId;
    }

    public String getCrmDrivercustomerName() {
        return crmDrivercustomerName;
    }

    public void setCrmDrivercustomerName(String crmDrivercustomerName) {
        this.crmDrivercustomerName = crmDrivercustomerName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
