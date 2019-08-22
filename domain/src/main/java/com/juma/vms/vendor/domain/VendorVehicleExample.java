package com.juma.vms.vendor.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VendorVehicleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int startOffSet = -1;

    protected int size = -1;

    public VendorVehicleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setStartOffSet(int startOffSet) {
        this.startOffSet=startOffSet;
    }

    public int getStartOffSet() {
        return startOffSet;
    }

    public void setSize(int size) {
        this.size=size;
    }

    public int getSize() {
        return size;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andVendorVehicleIdIsNull() {
            addCriterion("vendor_vehicle_id is null");
            return (Criteria) this;
        }

        public Criteria andVendorVehicleIdIsNotNull() {
            addCriterion("vendor_vehicle_id is not null");
            return (Criteria) this;
        }

        public Criteria andVendorVehicleIdEqualTo(Integer value) {
            addCriterion("vendor_vehicle_id =", value, "vendorVehicleId");
            return (Criteria) this;
        }

        public Criteria andVendorVehicleIdNotEqualTo(Integer value) {
            addCriterion("vendor_vehicle_id <>", value, "vendorVehicleId");
            return (Criteria) this;
        }

        public Criteria andVendorVehicleIdGreaterThan(Integer value) {
            addCriterion("vendor_vehicle_id >", value, "vendorVehicleId");
            return (Criteria) this;
        }

        public Criteria andVendorVehicleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("vendor_vehicle_id >=", value, "vendorVehicleId");
            return (Criteria) this;
        }

        public Criteria andVendorVehicleIdLessThan(Integer value) {
            addCriterion("vendor_vehicle_id <", value, "vendorVehicleId");
            return (Criteria) this;
        }

        public Criteria andVendorVehicleIdLessThanOrEqualTo(Integer value) {
            addCriterion("vendor_vehicle_id <=", value, "vendorVehicleId");
            return (Criteria) this;
        }

        public Criteria andVendorVehicleIdIn(List<Integer> values) {
            addCriterion("vendor_vehicle_id in", values, "vendorVehicleId");
            return (Criteria) this;
        }

        public Criteria andVendorVehicleIdNotIn(List<Integer> values) {
            addCriterion("vendor_vehicle_id not in", values, "vendorVehicleId");
            return (Criteria) this;
        }

        public Criteria andVendorVehicleIdBetween(Integer value1, Integer value2) {
            addCriterion("vendor_vehicle_id between", value1, value2, "vendorVehicleId");
            return (Criteria) this;
        }

        public Criteria andVendorVehicleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("vendor_vehicle_id not between", value1, value2, "vendorVehicleId");
            return (Criteria) this;
        }

        public Criteria andVendorIdIsNull() {
            addCriterion("vendor_id is null");
            return (Criteria) this;
        }

        public Criteria andVendorIdIsNotNull() {
            addCriterion("vendor_id is not null");
            return (Criteria) this;
        }

        public Criteria andVendorIdEqualTo(Integer value) {
            addCriterion("vendor_id =", value, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdNotEqualTo(Integer value) {
            addCriterion("vendor_id <>", value, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdGreaterThan(Integer value) {
            addCriterion("vendor_id >", value, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("vendor_id >=", value, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdLessThan(Integer value) {
            addCriterion("vendor_id <", value, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdLessThanOrEqualTo(Integer value) {
            addCriterion("vendor_id <=", value, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdIn(List<Integer> values) {
            addCriterion("vendor_id in", values, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdNotIn(List<Integer> values) {
            addCriterion("vendor_id not in", values, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdBetween(Integer value1, Integer value2) {
            addCriterion("vendor_id between", value1, value2, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("vendor_id not between", value1, value2, "vendorId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(Integer value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(Integer value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(Integer value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(Integer value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(Integer value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<Integer> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<Integer> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(Integer value1, Integer value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdIsNull() {
            addCriterion("vehicle_id is null");
            return (Criteria) this;
        }

        public Criteria andVehicleIdIsNotNull() {
            addCriterion("vehicle_id is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleIdEqualTo(Integer value) {
            addCriterion("vehicle_id =", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdNotEqualTo(Integer value) {
            addCriterion("vehicle_id <>", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdGreaterThan(Integer value) {
            addCriterion("vehicle_id >", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("vehicle_id >=", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdLessThan(Integer value) {
            addCriterion("vehicle_id <", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdLessThanOrEqualTo(Integer value) {
            addCriterion("vehicle_id <=", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdIn(List<Integer> values) {
            addCriterion("vehicle_id in", values, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdNotIn(List<Integer> values) {
            addCriterion("vehicle_id not in", values, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_id between", value1, value2, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_id not between", value1, value2, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(Integer value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Integer value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Integer value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Integer value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Integer> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Integer> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("last_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("last_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Date value) {
            addCriterion("last_update_time =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Date value) {
            addCriterion("last_update_time <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Date value) {
            addCriterion("last_update_time >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_time >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Date value) {
            addCriterion("last_update_time <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_update_time <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Date> values) {
            addCriterion("last_update_time in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Date> values) {
            addCriterion("last_update_time not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("last_update_time between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_update_time not between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdIsNull() {
            addCriterion("last_update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdIsNotNull() {
            addCriterion("last_update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdEqualTo(Integer value) {
            addCriterion("last_update_user_id =", value, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdNotEqualTo(Integer value) {
            addCriterion("last_update_user_id <>", value, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdGreaterThan(Integer value) {
            addCriterion("last_update_user_id >", value, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_update_user_id >=", value, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdLessThan(Integer value) {
            addCriterion("last_update_user_id <", value, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("last_update_user_id <=", value, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdIn(List<Integer> values) {
            addCriterion("last_update_user_id in", values, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdNotIn(List<Integer> values) {
            addCriterion("last_update_user_id not in", values, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("last_update_user_id between", value1, value2, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("last_update_user_id not between", value1, value2, "lastUpdateUserId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}