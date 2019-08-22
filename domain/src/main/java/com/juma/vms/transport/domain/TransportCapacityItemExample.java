package com.juma.vms.transport.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransportCapacityItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int startOffSet = -1;

    protected int size = -1;

    public TransportCapacityItemExample() {
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

    public TransportCapacityItemExample orderBy(String ... orderByClauses) {
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

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Integer value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Integer value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Integer value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Integer value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Integer> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Integer> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Integer value1, Integer value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andTransportIdIsNull() {
            addCriterion("transport_id is null");
            return (Criteria) this;
        }

        public Criteria andTransportIdIsNotNull() {
            addCriterion("transport_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransportIdEqualTo(Integer value) {
            addCriterion("transport_id =", value, "transportId");
            return (Criteria) this;
        }

        public Criteria andTransportIdNotEqualTo(Integer value) {
            addCriterion("transport_id <>", value, "transportId");
            return (Criteria) this;
        }

        public Criteria andTransportIdGreaterThan(Integer value) {
            addCriterion("transport_id >", value, "transportId");
            return (Criteria) this;
        }

        public Criteria andTransportIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("transport_id >=", value, "transportId");
            return (Criteria) this;
        }

        public Criteria andTransportIdLessThan(Integer value) {
            addCriterion("transport_id <", value, "transportId");
            return (Criteria) this;
        }

        public Criteria andTransportIdLessThanOrEqualTo(Integer value) {
            addCriterion("transport_id <=", value, "transportId");
            return (Criteria) this;
        }

        public Criteria andTransportIdIn(List<Integer> values) {
            addCriterion("transport_id in", values, "transportId");
            return (Criteria) this;
        }

        public Criteria andTransportIdNotIn(List<Integer> values) {
            addCriterion("transport_id not in", values, "transportId");
            return (Criteria) this;
        }

        public Criteria andTransportIdBetween(Integer value1, Integer value2) {
            addCriterion("transport_id between", value1, value2, "transportId");
            return (Criteria) this;
        }

        public Criteria andTransportIdNotBetween(Integer value1, Integer value2) {
            addCriterion("transport_id not between", value1, value2, "transportId");
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

        public Criteria andTruckIdIsNull() {
            addCriterion("truck_id is null");
            return (Criteria) this;
        }

        public Criteria andTruckIdIsNotNull() {
            addCriterion("truck_id is not null");
            return (Criteria) this;
        }

        public Criteria andTruckIdEqualTo(Integer value) {
            addCriterion("truck_id =", value, "truckId");
            return (Criteria) this;
        }

        public Criteria andTruckIdNotEqualTo(Integer value) {
            addCriterion("truck_id <>", value, "truckId");
            return (Criteria) this;
        }

        public Criteria andTruckIdGreaterThan(Integer value) {
            addCriterion("truck_id >", value, "truckId");
            return (Criteria) this;
        }

        public Criteria andTruckIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("truck_id >=", value, "truckId");
            return (Criteria) this;
        }

        public Criteria andTruckIdLessThan(Integer value) {
            addCriterion("truck_id <", value, "truckId");
            return (Criteria) this;
        }

        public Criteria andTruckIdLessThanOrEqualTo(Integer value) {
            addCriterion("truck_id <=", value, "truckId");
            return (Criteria) this;
        }

        public Criteria andTruckIdIn(List<Integer> values) {
            addCriterion("truck_id in", values, "truckId");
            return (Criteria) this;
        }

        public Criteria andTruckIdNotIn(List<Integer> values) {
            addCriterion("truck_id not in", values, "truckId");
            return (Criteria) this;
        }

        public Criteria andTruckIdBetween(Integer value1, Integer value2) {
            addCriterion("truck_id between", value1, value2, "truckId");
            return (Criteria) this;
        }

        public Criteria andTruckIdNotBetween(Integer value1, Integer value2) {
            addCriterion("truck_id not between", value1, value2, "truckId");
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

        public Criteria andTslOrderNoIsNull() {
            addCriterion("tsl_order_no is null");
            return (Criteria) this;
        }

        public Criteria andTslOrderNoIsNotNull() {
            addCriterion("tsl_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andTslOrderNoEqualTo(String value) {
            addCriterion("tsl_order_no =", value, "tslOrderNo");
            return (Criteria) this;
        }

        public Criteria andTslOrderNoNotEqualTo(String value) {
            addCriterion("tsl_order_no <>", value, "tslOrderNo");
            return (Criteria) this;
        }

        public Criteria andTslOrderNoGreaterThan(String value) {
            addCriterion("tsl_order_no >", value, "tslOrderNo");
            return (Criteria) this;
        }

        public Criteria andTslOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("tsl_order_no >=", value, "tslOrderNo");
            return (Criteria) this;
        }

        public Criteria andTslOrderNoLessThan(String value) {
            addCriterion("tsl_order_no <", value, "tslOrderNo");
            return (Criteria) this;
        }

        public Criteria andTslOrderNoLessThanOrEqualTo(String value) {
            addCriterion("tsl_order_no <=", value, "tslOrderNo");
            return (Criteria) this;
        }

        public Criteria andTslOrderNoLike(String value) {
            addCriterion("tsl_order_no like", value, "tslOrderNo");
            return (Criteria) this;
        }

        public Criteria andTslOrderNoNotLike(String value) {
            addCriterion("tsl_order_no not like", value, "tslOrderNo");
            return (Criteria) this;
        }

        public Criteria andTslOrderNoLikeList(List<String> values) {
            addCriterion("tsl_order_no like", values, "tslOrderNo");
            return (Criteria) this;
        }

        public Criteria andTslOrderNoIn(List<String> values) {
            addCriterion("tsl_order_no in", values, "tslOrderNo");
            return (Criteria) this;
        }

        public Criteria andTslOrderNoNotIn(List<String> values) {
            addCriterion("tsl_order_no not in", values, "tslOrderNo");
            return (Criteria) this;
        }

        public Criteria andTslOrderNoBetween(String value1, String value2) {
            addCriterion("tsl_order_no between", value1, value2, "tslOrderNo");
            return (Criteria) this;
        }

        public Criteria andTslOrderNoNotBetween(String value1, String value2) {
            addCriterion("tsl_order_no not between", value1, value2, "tslOrderNo");
            return (Criteria) this;
        }

        public Criteria andCrmCustomerIdIsNull() {
            addCriterion("crm_customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCrmCustomerIdIsNotNull() {
            addCriterion("crm_customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCrmCustomerIdEqualTo(Integer value) {
            addCriterion("crm_customer_id =", value, "crmCustomerId");
            return (Criteria) this;
        }

        public Criteria andCrmCustomerIdNotEqualTo(Integer value) {
            addCriterion("crm_customer_id <>", value, "crmCustomerId");
            return (Criteria) this;
        }

        public Criteria andCrmCustomerIdGreaterThan(Integer value) {
            addCriterion("crm_customer_id >", value, "crmCustomerId");
            return (Criteria) this;
        }

        public Criteria andCrmCustomerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("crm_customer_id >=", value, "crmCustomerId");
            return (Criteria) this;
        }

        public Criteria andCrmCustomerIdLessThan(Integer value) {
            addCriterion("crm_customer_id <", value, "crmCustomerId");
            return (Criteria) this;
        }

        public Criteria andCrmCustomerIdLessThanOrEqualTo(Integer value) {
            addCriterion("crm_customer_id <=", value, "crmCustomerId");
            return (Criteria) this;
        }

        public Criteria andCrmCustomerIdIn(List<Integer> values) {
            addCriterion("crm_customer_id in", values, "crmCustomerId");
            return (Criteria) this;
        }

        public Criteria andCrmCustomerIdNotIn(List<Integer> values) {
            addCriterion("crm_customer_id not in", values, "crmCustomerId");
            return (Criteria) this;
        }

        public Criteria andCrmCustomerIdBetween(Integer value1, Integer value2) {
            addCriterion("crm_customer_id between", value1, value2, "crmCustomerId");
            return (Criteria) this;
        }

        public Criteria andCrmCustomerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("crm_customer_id not between", value1, value2, "crmCustomerId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
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
        private TransportCapacityItemExample example;

        protected Criteria(TransportCapacityItemExample example) {
            super();
            this.example = example;
        }

        public TransportCapacityItemExample example() {
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
                if(condition.contains("like")) {
                    this.likeListValue = true;
                } else if(condition.contains("in")) {
                    this.listValue = true;
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