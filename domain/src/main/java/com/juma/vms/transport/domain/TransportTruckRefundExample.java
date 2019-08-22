package com.juma.vms.transport.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransportTruckRefundExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int startOffSet = -1;

    protected int size = -1;

    public TransportTruckRefundExample() {
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
        Criteria criteria = new Criteria(this);
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

    public TransportTruckRefundExample orderBy(String ... orderByClauses) {
        StringBuilder buffer = new StringBuilder();
        if(orderByClauses == null) throw new RuntimeException("order by field cannot be null");
        for(String field : orderByClauses) {
            if(field == null || field.trim().length() == 0) throw new RuntimeException("order by field cannot be null");
            buffer.append(field);
            buffer.append(",");
        }
        if(buffer.length() == 0) return this;
        this.setOrderByClause(buffer.substring(0, buffer.length() - 1));
        return this;
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
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andRefundIdIsNull() {
            addCriterion("refund_id is null");
            return (Criteria) this;
        }

        public Criteria andRefundIdIsNotNull() {
            addCriterion("refund_id is not null");
            return (Criteria) this;
        }

        public Criteria andRefundIdEqualTo(Integer value) {
            addCriterion("refund_id =", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotEqualTo(Integer value) {
            addCriterion("refund_id <>", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdGreaterThan(Integer value) {
            addCriterion("refund_id >", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("refund_id >=", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdLessThan(Integer value) {
            addCriterion("refund_id <", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdLessThanOrEqualTo(Integer value) {
            addCriterion("refund_id <=", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdIn(List<Integer> values) {
            addCriterion("refund_id in", values, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotIn(List<Integer> values) {
            addCriterion("refund_id not in", values, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdBetween(Integer value1, Integer value2) {
            addCriterion("refund_id between", value1, value2, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotBetween(Integer value1, Integer value2) {
            addCriterion("refund_id not between", value1, value2, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundNoIsNull() {
            addCriterion("refund_no is null");
            return (Criteria) this;
        }

        public Criteria andRefundNoIsNotNull() {
            addCriterion("refund_no is not null");
            return (Criteria) this;
        }

        public Criteria andRefundNoEqualTo(String value) {
            addCriterion("refund_no =", value, "refundNo");
            return (Criteria) this;
        }

        public Criteria andRefundNoNotEqualTo(String value) {
            addCriterion("refund_no <>", value, "refundNo");
            return (Criteria) this;
        }

        public Criteria andRefundNoGreaterThan(String value) {
            addCriterion("refund_no >", value, "refundNo");
            return (Criteria) this;
        }

        public Criteria andRefundNoGreaterThanOrEqualTo(String value) {
            addCriterion("refund_no >=", value, "refundNo");
            return (Criteria) this;
        }

        public Criteria andRefundNoLessThan(String value) {
            addCriterion("refund_no <", value, "refundNo");
            return (Criteria) this;
        }

        public Criteria andRefundNoLessThanOrEqualTo(String value) {
            addCriterion("refund_no <=", value, "refundNo");
            return (Criteria) this;
        }

        public Criteria andRefundNoLike(String value) {
            addCriterion("refund_no like", value, "refundNo");
            return (Criteria) this;
        }

        public Criteria andRefundNoNotLike(String value) {
            addCriterion("refund_no not like", value, "refundNo");
            return (Criteria) this;
        }

        public Criteria andRefundNoLikeList(List<String> values) {
            addCriterion("refund_no like", values, "refundNo");
            return (Criteria) this;
        }

        public Criteria andRefundNoIn(List<String> values) {
            addCriterion("refund_no in", values, "refundNo");
            return (Criteria) this;
        }

        public Criteria andRefundNoNotIn(List<String> values) {
            addCriterion("refund_no not in", values, "refundNo");
            return (Criteria) this;
        }

        public Criteria andRefundNoBetween(String value1, String value2) {
            addCriterion("refund_no between", value1, value2, "refundNo");
            return (Criteria) this;
        }

        public Criteria andRefundNoNotBetween(String value1, String value2) {
            addCriterion("refund_no not between", value1, value2, "refundNo");
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

        public Criteria andPlateNumberIsNull() {
            addCriterion("plate_number is null");
            return (Criteria) this;
        }

        public Criteria andPlateNumberIsNotNull() {
            addCriterion("plate_number is not null");
            return (Criteria) this;
        }

        public Criteria andPlateNumberEqualTo(String value) {
            addCriterion("plate_number =", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberNotEqualTo(String value) {
            addCriterion("plate_number <>", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberGreaterThan(String value) {
            addCriterion("plate_number >", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberGreaterThanOrEqualTo(String value) {
            addCriterion("plate_number >=", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberLessThan(String value) {
            addCriterion("plate_number <", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberLessThanOrEqualTo(String value) {
            addCriterion("plate_number <=", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberLike(String value) {
            addCriterion("plate_number like", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberNotLike(String value) {
            addCriterion("plate_number not like", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberLikeList(List<String> values) {
            addCriterion("plate_number like", values, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberIn(List<String> values) {
            addCriterion("plate_number in", values, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberNotIn(List<String> values) {
            addCriterion("plate_number not in", values, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberBetween(String value1, String value2) {
            addCriterion("plate_number between", value1, value2, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberNotBetween(String value1, String value2) {
            addCriterion("plate_number not between", value1, value2, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andTruckIdentificationNoIsNull() {
            addCriterion("truck_identification_no is null");
            return (Criteria) this;
        }

        public Criteria andTruckIdentificationNoIsNotNull() {
            addCriterion("truck_identification_no is not null");
            return (Criteria) this;
        }

        public Criteria andTruckIdentificationNoEqualTo(String value) {
            addCriterion("truck_identification_no =", value, "truckIdentificationNo");
            return (Criteria) this;
        }

        public Criteria andTruckIdentificationNoNotEqualTo(String value) {
            addCriterion("truck_identification_no <>", value, "truckIdentificationNo");
            return (Criteria) this;
        }

        public Criteria andTruckIdentificationNoGreaterThan(String value) {
            addCriterion("truck_identification_no >", value, "truckIdentificationNo");
            return (Criteria) this;
        }

        public Criteria andTruckIdentificationNoGreaterThanOrEqualTo(String value) {
            addCriterion("truck_identification_no >=", value, "truckIdentificationNo");
            return (Criteria) this;
        }

        public Criteria andTruckIdentificationNoLessThan(String value) {
            addCriterion("truck_identification_no <", value, "truckIdentificationNo");
            return (Criteria) this;
        }

        public Criteria andTruckIdentificationNoLessThanOrEqualTo(String value) {
            addCriterion("truck_identification_no <=", value, "truckIdentificationNo");
            return (Criteria) this;
        }

        public Criteria andTruckIdentificationNoLike(String value) {
            addCriterion("truck_identification_no like", value, "truckIdentificationNo");
            return (Criteria) this;
        }

        public Criteria andTruckIdentificationNoNotLike(String value) {
            addCriterion("truck_identification_no not like", value, "truckIdentificationNo");
            return (Criteria) this;
        }

        public Criteria andTruckIdentificationNoLikeList(List<String> values) {
            addCriterion("truck_identification_no like", values, "truckIdentificationNo");
            return (Criteria) this;
        }

        public Criteria andTruckIdentificationNoIn(List<String> values) {
            addCriterion("truck_identification_no in", values, "truckIdentificationNo");
            return (Criteria) this;
        }

        public Criteria andTruckIdentificationNoNotIn(List<String> values) {
            addCriterion("truck_identification_no not in", values, "truckIdentificationNo");
            return (Criteria) this;
        }

        public Criteria andTruckIdentificationNoBetween(String value1, String value2) {
            addCriterion("truck_identification_no between", value1, value2, "truckIdentificationNo");
            return (Criteria) this;
        }

        public Criteria andTruckIdentificationNoNotBetween(String value1, String value2) {
            addCriterion("truck_identification_no not between", value1, value2, "truckIdentificationNo");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxTypeIsNull() {
            addCriterion("vehicle_box_type is null");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxTypeIsNotNull() {
            addCriterion("vehicle_box_type is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxTypeEqualTo(Integer value) {
            addCriterion("vehicle_box_type =", value, "vehicleBoxType");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxTypeNotEqualTo(Integer value) {
            addCriterion("vehicle_box_type <>", value, "vehicleBoxType");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxTypeGreaterThan(Integer value) {
            addCriterion("vehicle_box_type >", value, "vehicleBoxType");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("vehicle_box_type >=", value, "vehicleBoxType");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxTypeLessThan(Integer value) {
            addCriterion("vehicle_box_type <", value, "vehicleBoxType");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxTypeLessThanOrEqualTo(Integer value) {
            addCriterion("vehicle_box_type <=", value, "vehicleBoxType");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxTypeIn(List<Integer> values) {
            addCriterion("vehicle_box_type in", values, "vehicleBoxType");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxTypeNotIn(List<Integer> values) {
            addCriterion("vehicle_box_type not in", values, "vehicleBoxType");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxTypeBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_box_type between", value1, value2, "vehicleBoxType");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_box_type not between", value1, value2, "vehicleBoxType");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxLengthIsNull() {
            addCriterion("vehicle_box_length is null");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxLengthIsNotNull() {
            addCriterion("vehicle_box_length is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxLengthEqualTo(Integer value) {
            addCriterion("vehicle_box_length =", value, "vehicleBoxLength");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxLengthNotEqualTo(Integer value) {
            addCriterion("vehicle_box_length <>", value, "vehicleBoxLength");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxLengthGreaterThan(Integer value) {
            addCriterion("vehicle_box_length >", value, "vehicleBoxLength");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("vehicle_box_length >=", value, "vehicleBoxLength");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxLengthLessThan(Integer value) {
            addCriterion("vehicle_box_length <", value, "vehicleBoxLength");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxLengthLessThanOrEqualTo(Integer value) {
            addCriterion("vehicle_box_length <=", value, "vehicleBoxLength");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxLengthIn(List<Integer> values) {
            addCriterion("vehicle_box_length in", values, "vehicleBoxLength");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxLengthNotIn(List<Integer> values) {
            addCriterion("vehicle_box_length not in", values, "vehicleBoxLength");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxLengthBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_box_length between", value1, value2, "vehicleBoxLength");
            return (Criteria) this;
        }

        public Criteria andVehicleBoxLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_box_length not between", value1, value2, "vehicleBoxLength");
            return (Criteria) this;
        }

        public Criteria andTruckRunTypeIsNull() {
            addCriterion("truck_run_type is null");
            return (Criteria) this;
        }

        public Criteria andTruckRunTypeIsNotNull() {
            addCriterion("truck_run_type is not null");
            return (Criteria) this;
        }

        public Criteria andTruckRunTypeEqualTo(Integer value) {
            addCriterion("truck_run_type =", value, "truckRunType");
            return (Criteria) this;
        }

        public Criteria andTruckRunTypeNotEqualTo(Integer value) {
            addCriterion("truck_run_type <>", value, "truckRunType");
            return (Criteria) this;
        }

        public Criteria andTruckRunTypeGreaterThan(Integer value) {
            addCriterion("truck_run_type >", value, "truckRunType");
            return (Criteria) this;
        }

        public Criteria andTruckRunTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("truck_run_type >=", value, "truckRunType");
            return (Criteria) this;
        }

        public Criteria andTruckRunTypeLessThan(Integer value) {
            addCriterion("truck_run_type <", value, "truckRunType");
            return (Criteria) this;
        }

        public Criteria andTruckRunTypeLessThanOrEqualTo(Integer value) {
            addCriterion("truck_run_type <=", value, "truckRunType");
            return (Criteria) this;
        }

        public Criteria andTruckRunTypeIn(List<Integer> values) {
            addCriterion("truck_run_type in", values, "truckRunType");
            return (Criteria) this;
        }

        public Criteria andTruckRunTypeNotIn(List<Integer> values) {
            addCriterion("truck_run_type not in", values, "truckRunType");
            return (Criteria) this;
        }

        public Criteria andTruckRunTypeBetween(Integer value1, Integer value2) {
            addCriterion("truck_run_type between", value1, value2, "truckRunType");
            return (Criteria) this;
        }

        public Criteria andTruckRunTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("truck_run_type not between", value1, value2, "truckRunType");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNull() {
            addCriterion("area_code is null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNotNull() {
            addCriterion("area_code is not null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeEqualTo(String value) {
            addCriterion("area_code =", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotEqualTo(String value) {
            addCriterion("area_code <>", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThan(String value) {
            addCriterion("area_code >", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("area_code >=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThan(String value) {
            addCriterion("area_code <", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("area_code <=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLike(String value) {
            addCriterion("area_code like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotLike(String value) {
            addCriterion("area_code not like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLikeList(List<String> values) {
            addCriterion("area_code like", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIn(List<String> values) {
            addCriterion("area_code in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotIn(List<String> values) {
            addCriterion("area_code not in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeBetween(String value1, String value2) {
            addCriterion("area_code between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotBetween(String value1, String value2) {
            addCriterion("area_code not between", value1, value2, "areaCode");
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

        public Criteria andContactPhoneIsNull() {
            addCriterion("contact_phone is null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNotNull() {
            addCriterion("contact_phone is not null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneEqualTo(String value) {
            addCriterion("contact_phone =", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotEqualTo(String value) {
            addCriterion("contact_phone <>", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThan(String value) {
            addCriterion("contact_phone >", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("contact_phone >=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThan(String value) {
            addCriterion("contact_phone <", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("contact_phone <=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLike(String value) {
            addCriterion("contact_phone like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotLike(String value) {
            addCriterion("contact_phone not like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLikeList(List<String> values) {
            addCriterion("contact_phone like", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIn(List<String> values) {
            addCriterion("contact_phone in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotIn(List<String> values) {
            addCriterion("contact_phone not in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneBetween(String value1, String value2) {
            addCriterion("contact_phone between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotBetween(String value1, String value2) {
            addCriterion("contact_phone not between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andVendorTypeIsNull() {
            addCriterion("vendor_type is null");
            return (Criteria) this;
        }

        public Criteria andVendorTypeIsNotNull() {
            addCriterion("vendor_type is not null");
            return (Criteria) this;
        }

        public Criteria andVendorTypeEqualTo(Byte value) {
            addCriterion("vendor_type =", value, "vendorType");
            return (Criteria) this;
        }

        public Criteria andVendorTypeNotEqualTo(Byte value) {
            addCriterion("vendor_type <>", value, "vendorType");
            return (Criteria) this;
        }

        public Criteria andVendorTypeGreaterThan(Byte value) {
            addCriterion("vendor_type >", value, "vendorType");
            return (Criteria) this;
        }

        public Criteria andVendorTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("vendor_type >=", value, "vendorType");
            return (Criteria) this;
        }

        public Criteria andVendorTypeLessThan(Byte value) {
            addCriterion("vendor_type <", value, "vendorType");
            return (Criteria) this;
        }

        public Criteria andVendorTypeLessThanOrEqualTo(Byte value) {
            addCriterion("vendor_type <=", value, "vendorType");
            return (Criteria) this;
        }

        public Criteria andVendorTypeIn(List<Byte> values) {
            addCriterion("vendor_type in", values, "vendorType");
            return (Criteria) this;
        }

        public Criteria andVendorTypeNotIn(List<Byte> values) {
            addCriterion("vendor_type not in", values, "vendorType");
            return (Criteria) this;
        }

        public Criteria andVendorTypeBetween(Byte value1, Byte value2) {
            addCriterion("vendor_type between", value1, value2, "vendorType");
            return (Criteria) this;
        }

        public Criteria andVendorTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("vendor_type not between", value1, value2, "vendorType");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(Integer value) {
            addCriterion("department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(Integer value) {
            addCriterion("department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(Integer value) {
            addCriterion("department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(Integer value) {
            addCriterion("department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<Integer> values) {
            addCriterion("department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<Integer> values) {
            addCriterion("department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(Integer value1, Integer value2) {
            addCriterion("department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("department_id not between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeIsNull() {
            addCriterion("department_code is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeIsNotNull() {
            addCriterion("department_code is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeEqualTo(String value) {
            addCriterion("department_code =", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeNotEqualTo(String value) {
            addCriterion("department_code <>", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeGreaterThan(String value) {
            addCriterion("department_code >", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("department_code >=", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeLessThan(String value) {
            addCriterion("department_code <", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeLessThanOrEqualTo(String value) {
            addCriterion("department_code <=", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeLike(String value) {
            addCriterion("department_code like", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeNotLike(String value) {
            addCriterion("department_code not like", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeLikeList(List<String> values) {
            addCriterion("department_code like", values, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeIn(List<String> values) {
            addCriterion("department_code in", values, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeNotIn(List<String> values) {
            addCriterion("department_code not in", values, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeBetween(String value1, String value2) {
            addCriterion("department_code between", value1, value2, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeNotBetween(String value1, String value2) {
            addCriterion("department_code not between", value1, value2, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentIdIsNull() {
            addCriterion("to_department_id is null");
            return (Criteria) this;
        }

        public Criteria andToDepartmentIdIsNotNull() {
            addCriterion("to_department_id is not null");
            return (Criteria) this;
        }

        public Criteria andToDepartmentIdEqualTo(Integer value) {
            addCriterion("to_department_id =", value, "toDepartmentId");
            return (Criteria) this;
        }

        public Criteria andToDepartmentIdNotEqualTo(Integer value) {
            addCriterion("to_department_id <>", value, "toDepartmentId");
            return (Criteria) this;
        }

        public Criteria andToDepartmentIdGreaterThan(Integer value) {
            addCriterion("to_department_id >", value, "toDepartmentId");
            return (Criteria) this;
        }

        public Criteria andToDepartmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("to_department_id >=", value, "toDepartmentId");
            return (Criteria) this;
        }

        public Criteria andToDepartmentIdLessThan(Integer value) {
            addCriterion("to_department_id <", value, "toDepartmentId");
            return (Criteria) this;
        }

        public Criteria andToDepartmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("to_department_id <=", value, "toDepartmentId");
            return (Criteria) this;
        }

        public Criteria andToDepartmentIdIn(List<Integer> values) {
            addCriterion("to_department_id in", values, "toDepartmentId");
            return (Criteria) this;
        }

        public Criteria andToDepartmentIdNotIn(List<Integer> values) {
            addCriterion("to_department_id not in", values, "toDepartmentId");
            return (Criteria) this;
        }

        public Criteria andToDepartmentIdBetween(Integer value1, Integer value2) {
            addCriterion("to_department_id between", value1, value2, "toDepartmentId");
            return (Criteria) this;
        }

        public Criteria andToDepartmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("to_department_id not between", value1, value2, "toDepartmentId");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIsNull() {
            addCriterion("refund_status is null");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIsNotNull() {
            addCriterion("refund_status is not null");
            return (Criteria) this;
        }

        public Criteria andRefundStatusEqualTo(Integer value) {
            addCriterion("refund_status =", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotEqualTo(Integer value) {
            addCriterion("refund_status <>", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusGreaterThan(Integer value) {
            addCriterion("refund_status >", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("refund_status >=", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusLessThan(Integer value) {
            addCriterion("refund_status <", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusLessThanOrEqualTo(Integer value) {
            addCriterion("refund_status <=", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIn(List<Integer> values) {
            addCriterion("refund_status in", values, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotIn(List<Integer> values) {
            addCriterion("refund_status not in", values, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusBetween(Integer value1, Integer value2) {
            addCriterion("refund_status between", value1, value2, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("refund_status not between", value1, value2, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundReasonTypeIsNull() {
            addCriterion("refund_reason_type is null");
            return (Criteria) this;
        }

        public Criteria andRefundReasonTypeIsNotNull() {
            addCriterion("refund_reason_type is not null");
            return (Criteria) this;
        }

        public Criteria andRefundReasonTypeEqualTo(Byte value) {
            addCriterion("refund_reason_type =", value, "refundReasonType");
            return (Criteria) this;
        }

        public Criteria andRefundReasonTypeNotEqualTo(Byte value) {
            addCriterion("refund_reason_type <>", value, "refundReasonType");
            return (Criteria) this;
        }

        public Criteria andRefundReasonTypeGreaterThan(Byte value) {
            addCriterion("refund_reason_type >", value, "refundReasonType");
            return (Criteria) this;
        }

        public Criteria andRefundReasonTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("refund_reason_type >=", value, "refundReasonType");
            return (Criteria) this;
        }

        public Criteria andRefundReasonTypeLessThan(Byte value) {
            addCriterion("refund_reason_type <", value, "refundReasonType");
            return (Criteria) this;
        }

        public Criteria andRefundReasonTypeLessThanOrEqualTo(Byte value) {
            addCriterion("refund_reason_type <=", value, "refundReasonType");
            return (Criteria) this;
        }

        public Criteria andRefundReasonTypeIn(List<Byte> values) {
            addCriterion("refund_reason_type in", values, "refundReasonType");
            return (Criteria) this;
        }

        public Criteria andRefundReasonTypeNotIn(List<Byte> values) {
            addCriterion("refund_reason_type not in", values, "refundReasonType");
            return (Criteria) this;
        }

        public Criteria andRefundReasonTypeBetween(Byte value1, Byte value2) {
            addCriterion("refund_reason_type between", value1, value2, "refundReasonType");
            return (Criteria) this;
        }

        public Criteria andRefundReasonTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("refund_reason_type not between", value1, value2, "refundReasonType");
            return (Criteria) this;
        }

        public Criteria andRefundReasonIsNull() {
            addCriterion("refund_reason is null");
            return (Criteria) this;
        }

        public Criteria andRefundReasonIsNotNull() {
            addCriterion("refund_reason is not null");
            return (Criteria) this;
        }

        public Criteria andRefundReasonEqualTo(String value) {
            addCriterion("refund_reason =", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonNotEqualTo(String value) {
            addCriterion("refund_reason <>", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonGreaterThan(String value) {
            addCriterion("refund_reason >", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonGreaterThanOrEqualTo(String value) {
            addCriterion("refund_reason >=", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonLessThan(String value) {
            addCriterion("refund_reason <", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonLessThanOrEqualTo(String value) {
            addCriterion("refund_reason <=", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonLike(String value) {
            addCriterion("refund_reason like", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonNotLike(String value) {
            addCriterion("refund_reason not like", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonLikeList(List<String> values) {
            addCriterion("refund_reason like", values, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonIn(List<String> values) {
            addCriterion("refund_reason in", values, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonNotIn(List<String> values) {
            addCriterion("refund_reason not in", values, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonBetween(String value1, String value2) {
            addCriterion("refund_reason between", value1, value2, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonNotBetween(String value1, String value2) {
            addCriterion("refund_reason not between", value1, value2, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundAttachmentsIsNull() {
            addCriterion("refund_attachments is null");
            return (Criteria) this;
        }

        public Criteria andRefundAttachmentsIsNotNull() {
            addCriterion("refund_attachments is not null");
            return (Criteria) this;
        }

        public Criteria andRefundAttachmentsEqualTo(String value) {
            addCriterion("refund_attachments =", value, "refundAttachments");
            return (Criteria) this;
        }

        public Criteria andRefundAttachmentsNotEqualTo(String value) {
            addCriterion("refund_attachments <>", value, "refundAttachments");
            return (Criteria) this;
        }

        public Criteria andRefundAttachmentsGreaterThan(String value) {
            addCriterion("refund_attachments >", value, "refundAttachments");
            return (Criteria) this;
        }

        public Criteria andRefundAttachmentsGreaterThanOrEqualTo(String value) {
            addCriterion("refund_attachments >=", value, "refundAttachments");
            return (Criteria) this;
        }

        public Criteria andRefundAttachmentsLessThan(String value) {
            addCriterion("refund_attachments <", value, "refundAttachments");
            return (Criteria) this;
        }

        public Criteria andRefundAttachmentsLessThanOrEqualTo(String value) {
            addCriterion("refund_attachments <=", value, "refundAttachments");
            return (Criteria) this;
        }

        public Criteria andRefundAttachmentsLike(String value) {
            addCriterion("refund_attachments like", value, "refundAttachments");
            return (Criteria) this;
        }

        public Criteria andRefundAttachmentsNotLike(String value) {
            addCriterion("refund_attachments not like", value, "refundAttachments");
            return (Criteria) this;
        }

        public Criteria andRefundAttachmentsLikeList(List<String> values) {
            addCriterion("refund_attachments like", values, "refundAttachments");
            return (Criteria) this;
        }

        public Criteria andRefundAttachmentsIn(List<String> values) {
            addCriterion("refund_attachments in", values, "refundAttachments");
            return (Criteria) this;
        }

        public Criteria andRefundAttachmentsNotIn(List<String> values) {
            addCriterion("refund_attachments not in", values, "refundAttachments");
            return (Criteria) this;
        }

        public Criteria andRefundAttachmentsBetween(String value1, String value2) {
            addCriterion("refund_attachments between", value1, value2, "refundAttachments");
            return (Criteria) this;
        }

        public Criteria andRefundAttachmentsNotBetween(String value1, String value2) {
            addCriterion("refund_attachments not between", value1, value2, "refundAttachments");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIsNull() {
            addCriterion("approval_status is null");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIsNotNull() {
            addCriterion("approval_status is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusEqualTo(Integer value) {
            addCriterion("approval_status =", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotEqualTo(Integer value) {
            addCriterion("approval_status <>", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThan(Integer value) {
            addCriterion("approval_status >", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("approval_status >=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThan(Integer value) {
            addCriterion("approval_status <", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThanOrEqualTo(Integer value) {
            addCriterion("approval_status <=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIn(List<Integer> values) {
            addCriterion("approval_status in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotIn(List<Integer> values) {
            addCriterion("approval_status not in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusBetween(Integer value1, Integer value2) {
            addCriterion("approval_status between", value1, value2, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("approval_status not between", value1, value2, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionIsNull() {
            addCriterion("approval_opinion is null");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionIsNotNull() {
            addCriterion("approval_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionEqualTo(String value) {
            addCriterion("approval_opinion =", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionNotEqualTo(String value) {
            addCriterion("approval_opinion <>", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionGreaterThan(String value) {
            addCriterion("approval_opinion >", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("approval_opinion >=", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionLessThan(String value) {
            addCriterion("approval_opinion <", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionLessThanOrEqualTo(String value) {
            addCriterion("approval_opinion <=", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionLike(String value) {
            addCriterion("approval_opinion like", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionNotLike(String value) {
            addCriterion("approval_opinion not like", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionLikeList(List<String> values) {
            addCriterion("approval_opinion like", values, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionIn(List<String> values) {
            addCriterion("approval_opinion in", values, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionNotIn(List<String> values) {
            addCriterion("approval_opinion not in", values, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionBetween(String value1, String value2) {
            addCriterion("approval_opinion between", value1, value2, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionNotBetween(String value1, String value2) {
            addCriterion("approval_opinion not between", value1, value2, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andStorageNoIsNull() {
            addCriterion("storage_no is null");
            return (Criteria) this;
        }

        public Criteria andStorageNoIsNotNull() {
            addCriterion("storage_no is not null");
            return (Criteria) this;
        }

        public Criteria andStorageNoEqualTo(String value) {
            addCriterion("storage_no =", value, "storageNo");
            return (Criteria) this;
        }

        public Criteria andStorageNoNotEqualTo(String value) {
            addCriterion("storage_no <>", value, "storageNo");
            return (Criteria) this;
        }

        public Criteria andStorageNoGreaterThan(String value) {
            addCriterion("storage_no >", value, "storageNo");
            return (Criteria) this;
        }

        public Criteria andStorageNoGreaterThanOrEqualTo(String value) {
            addCriterion("storage_no >=", value, "storageNo");
            return (Criteria) this;
        }

        public Criteria andStorageNoLessThan(String value) {
            addCriterion("storage_no <", value, "storageNo");
            return (Criteria) this;
        }

        public Criteria andStorageNoLessThanOrEqualTo(String value) {
            addCriterion("storage_no <=", value, "storageNo");
            return (Criteria) this;
        }

        public Criteria andStorageNoLike(String value) {
            addCriterion("storage_no like", value, "storageNo");
            return (Criteria) this;
        }

        public Criteria andStorageNoNotLike(String value) {
            addCriterion("storage_no not like", value, "storageNo");
            return (Criteria) this;
        }

        public Criteria andStorageNoLikeList(List<String> values) {
            addCriterion("storage_no like", values, "storageNo");
            return (Criteria) this;
        }

        public Criteria andStorageNoIn(List<String> values) {
            addCriterion("storage_no in", values, "storageNo");
            return (Criteria) this;
        }

        public Criteria andStorageNoNotIn(List<String> values) {
            addCriterion("storage_no not in", values, "storageNo");
            return (Criteria) this;
        }

        public Criteria andStorageNoBetween(String value1, String value2) {
            addCriterion("storage_no between", value1, value2, "storageNo");
            return (Criteria) this;
        }

        public Criteria andStorageNoNotBetween(String value1, String value2) {
            addCriterion("storage_no not between", value1, value2, "storageNo");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdIsNull() {
            addCriterion("process_instance_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdIsNotNull() {
            addCriterion("process_instance_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdEqualTo(String value) {
            addCriterion("process_instance_id =", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotEqualTo(String value) {
            addCriterion("process_instance_id <>", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdGreaterThan(String value) {
            addCriterion("process_instance_id >", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdGreaterThanOrEqualTo(String value) {
            addCriterion("process_instance_id >=", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdLessThan(String value) {
            addCriterion("process_instance_id <", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdLessThanOrEqualTo(String value) {
            addCriterion("process_instance_id <=", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdLike(String value) {
            addCriterion("process_instance_id like", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotLike(String value) {
            addCriterion("process_instance_id not like", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdLikeList(List<String> values) {
            addCriterion("process_instance_id like", values, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdIn(List<String> values) {
            addCriterion("process_instance_id in", values, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotIn(List<String> values) {
            addCriterion("process_instance_id not in", values, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdBetween(String value1, String value2) {
            addCriterion("process_instance_id between", value1, value2, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotBetween(String value1, String value2) {
            addCriterion("process_instance_id not between", value1, value2, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNull() {
            addCriterion("submit_time is null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNotNull() {
            addCriterion("submit_time is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeEqualTo(Date value) {
            addCriterion("submit_time =", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotEqualTo(Date value) {
            addCriterion("submit_time <>", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThan(Date value) {
            addCriterion("submit_time >", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("submit_time >=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThan(Date value) {
            addCriterion("submit_time <", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThanOrEqualTo(Date value) {
            addCriterion("submit_time <=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIn(List<Date> values) {
            addCriterion("submit_time in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotIn(List<Date> values) {
            addCriterion("submit_time not in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeBetween(Date value1, Date value2) {
            addCriterion("submit_time between", value1, value2, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotBetween(Date value1, Date value2) {
            addCriterion("submit_time not between", value1, value2, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdIsNull() {
            addCriterion("submit_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdIsNotNull() {
            addCriterion("submit_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdEqualTo(Integer value) {
            addCriterion("submit_user_id =", value, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdNotEqualTo(Integer value) {
            addCriterion("submit_user_id <>", value, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdGreaterThan(Integer value) {
            addCriterion("submit_user_id >", value, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("submit_user_id >=", value, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdLessThan(Integer value) {
            addCriterion("submit_user_id <", value, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("submit_user_id <=", value, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdIn(List<Integer> values) {
            addCriterion("submit_user_id in", values, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdNotIn(List<Integer> values) {
            addCriterion("submit_user_id not in", values, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdBetween(Integer value1, Integer value2) {
            addCriterion("submit_user_id between", value1, value2, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("submit_user_id not between", value1, value2, "submitUserId");
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
        private TransportTruckRefundExample example;

        protected Criteria(TransportTruckRefundExample example) {
            super();
            this.example = example;
        }

        public TransportTruckRefundExample example() {
            return this.example;
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean likeListValue;

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

        public boolean isLikeListValue() {
            return likeListValue;
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
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                List<?> l = (List<?>)value;
                if(!l.isEmpty()) {
                    if(condition.contains("like")) {
                        this.likeListValue = true;
                    } else if(condition.contains("in")) {
                        this.listValue = true;
                    }
                }
            } else {
                this.singleValue = true;
                if(value == null || value.toString().trim().length() == 0) {
                    this.noValue = true;
                }
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