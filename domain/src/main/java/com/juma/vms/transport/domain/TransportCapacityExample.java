package com.juma.vms.transport.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransportCapacityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int startOffSet = -1;

    protected int size = -1;

    public TransportCapacityExample() {
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

    public TransportCapacityExample orderBy(String ... orderByClauses) {
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

        public Criteria andTenantCodeIsNull() {
            addCriterion("tenant_code is null");
            return (Criteria) this;
        }

        public Criteria andTenantCodeIsNotNull() {
            addCriterion("tenant_code is not null");
            return (Criteria) this;
        }

        public Criteria andTenantCodeEqualTo(String value) {
            addCriterion("tenant_code =", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeNotEqualTo(String value) {
            addCriterion("tenant_code <>", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeGreaterThan(String value) {
            addCriterion("tenant_code >", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_code >=", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeLessThan(String value) {
            addCriterion("tenant_code <", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeLessThanOrEqualTo(String value) {
            addCriterion("tenant_code <=", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeLike(String value) {
            addCriterion("tenant_code like", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeNotLike(String value) {
            addCriterion("tenant_code not like", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeLikeList(List<String> values) {
            addCriterion("tenant_code like", values, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeIn(List<String> values) {
            addCriterion("tenant_code in", values, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeNotIn(List<String> values) {
            addCriterion("tenant_code not in", values, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeBetween(String value1, String value2) {
            addCriterion("tenant_code between", value1, value2, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeNotBetween(String value1, String value2) {
            addCriterion("tenant_code not between", value1, value2, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantIdIsNull() {
            addCriterion("receive_tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantIdIsNotNull() {
            addCriterion("receive_tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantIdEqualTo(Integer value) {
            addCriterion("receive_tenant_id =", value, "receiveTenantId");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantIdNotEqualTo(Integer value) {
            addCriterion("receive_tenant_id <>", value, "receiveTenantId");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantIdGreaterThan(Integer value) {
            addCriterion("receive_tenant_id >", value, "receiveTenantId");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("receive_tenant_id >=", value, "receiveTenantId");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantIdLessThan(Integer value) {
            addCriterion("receive_tenant_id <", value, "receiveTenantId");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantIdLessThanOrEqualTo(Integer value) {
            addCriterion("receive_tenant_id <=", value, "receiveTenantId");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantIdIn(List<Integer> values) {
            addCriterion("receive_tenant_id in", values, "receiveTenantId");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantIdNotIn(List<Integer> values) {
            addCriterion("receive_tenant_id not in", values, "receiveTenantId");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantIdBetween(Integer value1, Integer value2) {
            addCriterion("receive_tenant_id between", value1, value2, "receiveTenantId");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantIdNotBetween(Integer value1, Integer value2) {
            addCriterion("receive_tenant_id not between", value1, value2, "receiveTenantId");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantCodeIsNull() {
            addCriterion("receive_tenant_code is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantCodeIsNotNull() {
            addCriterion("receive_tenant_code is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantCodeEqualTo(String value) {
            addCriterion("receive_tenant_code =", value, "receiveTenantCode");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantCodeNotEqualTo(String value) {
            addCriterion("receive_tenant_code <>", value, "receiveTenantCode");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantCodeGreaterThan(String value) {
            addCriterion("receive_tenant_code >", value, "receiveTenantCode");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantCodeGreaterThanOrEqualTo(String value) {
            addCriterion("receive_tenant_code >=", value, "receiveTenantCode");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantCodeLessThan(String value) {
            addCriterion("receive_tenant_code <", value, "receiveTenantCode");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantCodeLessThanOrEqualTo(String value) {
            addCriterion("receive_tenant_code <=", value, "receiveTenantCode");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantCodeLike(String value) {
            addCriterion("receive_tenant_code like", value, "receiveTenantCode");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantCodeNotLike(String value) {
            addCriterion("receive_tenant_code not like", value, "receiveTenantCode");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantCodeLikeList(List<String> values) {
            addCriterion("receive_tenant_code like", values, "receiveTenantCode");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantCodeIn(List<String> values) {
            addCriterion("receive_tenant_code in", values, "receiveTenantCode");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantCodeNotIn(List<String> values) {
            addCriterion("receive_tenant_code not in", values, "receiveTenantCode");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantCodeBetween(String value1, String value2) {
            addCriterion("receive_tenant_code between", value1, value2, "receiveTenantCode");
            return (Criteria) this;
        }

        public Criteria andReceiveTenantCodeNotBetween(String value1, String value2) {
            addCriterion("receive_tenant_code not between", value1, value2, "receiveTenantCode");
            return (Criteria) this;
        }

        public Criteria andTransportNoIsNull() {
            addCriterion("transport_no is null");
            return (Criteria) this;
        }

        public Criteria andTransportNoIsNotNull() {
            addCriterion("transport_no is not null");
            return (Criteria) this;
        }

        public Criteria andTransportNoEqualTo(String value) {
            addCriterion("transport_no =", value, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportNoNotEqualTo(String value) {
            addCriterion("transport_no <>", value, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportNoGreaterThan(String value) {
            addCriterion("transport_no >", value, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportNoGreaterThanOrEqualTo(String value) {
            addCriterion("transport_no >=", value, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportNoLessThan(String value) {
            addCriterion("transport_no <", value, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportNoLessThanOrEqualTo(String value) {
            addCriterion("transport_no <=", value, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportNoLike(String value) {
            addCriterion("transport_no like", value, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportNoNotLike(String value) {
            addCriterion("transport_no not like", value, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportNoLikeList(List<String> values) {
            addCriterion("transport_no like", values, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportNoIn(List<String> values) {
            addCriterion("transport_no in", values, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportNoNotIn(List<String> values) {
            addCriterion("transport_no not in", values, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportNoBetween(String value1, String value2) {
            addCriterion("transport_no between", value1, value2, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportNoNotBetween(String value1, String value2) {
            addCriterion("transport_no not between", value1, value2, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportTypeIsNull() {
            addCriterion("transport_type is null");
            return (Criteria) this;
        }

        public Criteria andTransportTypeIsNotNull() {
            addCriterion("transport_type is not null");
            return (Criteria) this;
        }

        public Criteria andTransportTypeEqualTo(Integer value) {
            addCriterion("transport_type =", value, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeNotEqualTo(Integer value) {
            addCriterion("transport_type <>", value, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeGreaterThan(Integer value) {
            addCriterion("transport_type >", value, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("transport_type >=", value, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeLessThan(Integer value) {
            addCriterion("transport_type <", value, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeLessThanOrEqualTo(Integer value) {
            addCriterion("transport_type <=", value, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeIn(List<Integer> values) {
            addCriterion("transport_type in", values, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeNotIn(List<Integer> values) {
            addCriterion("transport_type not in", values, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeBetween(Integer value1, Integer value2) {
            addCriterion("transport_type between", value1, value2, "transportType");
            return (Criteria) this;
        }

        public Criteria andTransportTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("transport_type not between", value1, value2, "transportType");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentIdIsNull() {
            addCriterion("from_department_id is null");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentIdIsNotNull() {
            addCriterion("from_department_id is not null");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentIdEqualTo(Integer value) {
            addCriterion("from_department_id =", value, "fromDepartmentId");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentIdNotEqualTo(Integer value) {
            addCriterion("from_department_id <>", value, "fromDepartmentId");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentIdGreaterThan(Integer value) {
            addCriterion("from_department_id >", value, "fromDepartmentId");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("from_department_id >=", value, "fromDepartmentId");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentIdLessThan(Integer value) {
            addCriterion("from_department_id <", value, "fromDepartmentId");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("from_department_id <=", value, "fromDepartmentId");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentIdIn(List<Integer> values) {
            addCriterion("from_department_id in", values, "fromDepartmentId");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentIdNotIn(List<Integer> values) {
            addCriterion("from_department_id not in", values, "fromDepartmentId");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentIdBetween(Integer value1, Integer value2) {
            addCriterion("from_department_id between", value1, value2, "fromDepartmentId");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("from_department_id not between", value1, value2, "fromDepartmentId");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCodeIsNull() {
            addCriterion("from_department_code is null");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCodeIsNotNull() {
            addCriterion("from_department_code is not null");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCodeEqualTo(String value) {
            addCriterion("from_department_code =", value, "fromDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCodeNotEqualTo(String value) {
            addCriterion("from_department_code <>", value, "fromDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCodeGreaterThan(String value) {
            addCriterion("from_department_code >", value, "fromDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("from_department_code >=", value, "fromDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCodeLessThan(String value) {
            addCriterion("from_department_code <", value, "fromDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCodeLessThanOrEqualTo(String value) {
            addCriterion("from_department_code <=", value, "fromDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCodeLike(String value) {
            addCriterion("from_department_code like", value, "fromDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCodeNotLike(String value) {
            addCriterion("from_department_code not like", value, "fromDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCodeLikeList(List<String> values) {
            addCriterion("from_department_code like", values, "fromDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCodeIn(List<String> values) {
            addCriterion("from_department_code in", values, "fromDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCodeNotIn(List<String> values) {
            addCriterion("from_department_code not in", values, "fromDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCodeBetween(String value1, String value2) {
            addCriterion("from_department_code between", value1, value2, "fromDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCodeNotBetween(String value1, String value2) {
            addCriterion("from_department_code not between", value1, value2, "fromDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCreditcodeIsNull() {
            addCriterion("from_department_creditcode is null");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCreditcodeIsNotNull() {
            addCriterion("from_department_creditcode is not null");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCreditcodeEqualTo(String value) {
            addCriterion("from_department_creditcode =", value, "fromDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCreditcodeNotEqualTo(String value) {
            addCriterion("from_department_creditcode <>", value, "fromDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCreditcodeGreaterThan(String value) {
            addCriterion("from_department_creditcode >", value, "fromDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCreditcodeGreaterThanOrEqualTo(String value) {
            addCriterion("from_department_creditcode >=", value, "fromDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCreditcodeLessThan(String value) {
            addCriterion("from_department_creditcode <", value, "fromDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCreditcodeLessThanOrEqualTo(String value) {
            addCriterion("from_department_creditcode <=", value, "fromDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCreditcodeLike(String value) {
            addCriterion("from_department_creditcode like", value, "fromDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCreditcodeNotLike(String value) {
            addCriterion("from_department_creditcode not like", value, "fromDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCreditcodeLikeList(List<String> values) {
            addCriterion("from_department_creditcode like", values, "fromDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCreditcodeIn(List<String> values) {
            addCriterion("from_department_creditcode in", values, "fromDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCreditcodeNotIn(List<String> values) {
            addCriterion("from_department_creditcode not in", values, "fromDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCreditcodeBetween(String value1, String value2) {
            addCriterion("from_department_creditcode between", value1, value2, "fromDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andFromDepartmentCreditcodeNotBetween(String value1, String value2) {
            addCriterion("from_department_creditcode not between", value1, value2, "fromDepartmentCreditcode");
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

        public Criteria andToDepartmentCodeIsNull() {
            addCriterion("to_department_code is null");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCodeIsNotNull() {
            addCriterion("to_department_code is not null");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCodeEqualTo(String value) {
            addCriterion("to_department_code =", value, "toDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCodeNotEqualTo(String value) {
            addCriterion("to_department_code <>", value, "toDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCodeGreaterThan(String value) {
            addCriterion("to_department_code >", value, "toDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("to_department_code >=", value, "toDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCodeLessThan(String value) {
            addCriterion("to_department_code <", value, "toDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCodeLessThanOrEqualTo(String value) {
            addCriterion("to_department_code <=", value, "toDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCodeLike(String value) {
            addCriterion("to_department_code like", value, "toDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCodeNotLike(String value) {
            addCriterion("to_department_code not like", value, "toDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCodeLikeList(List<String> values) {
            addCriterion("to_department_code like", values, "toDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCodeIn(List<String> values) {
            addCriterion("to_department_code in", values, "toDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCodeNotIn(List<String> values) {
            addCriterion("to_department_code not in", values, "toDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCodeBetween(String value1, String value2) {
            addCriterion("to_department_code between", value1, value2, "toDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCodeNotBetween(String value1, String value2) {
            addCriterion("to_department_code not between", value1, value2, "toDepartmentCode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCreditcodeIsNull() {
            addCriterion("to_department_creditcode is null");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCreditcodeIsNotNull() {
            addCriterion("to_department_creditcode is not null");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCreditcodeEqualTo(String value) {
            addCriterion("to_department_creditcode =", value, "toDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCreditcodeNotEqualTo(String value) {
            addCriterion("to_department_creditcode <>", value, "toDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCreditcodeGreaterThan(String value) {
            addCriterion("to_department_creditcode >", value, "toDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCreditcodeGreaterThanOrEqualTo(String value) {
            addCriterion("to_department_creditcode >=", value, "toDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCreditcodeLessThan(String value) {
            addCriterion("to_department_creditcode <", value, "toDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCreditcodeLessThanOrEqualTo(String value) {
            addCriterion("to_department_creditcode <=", value, "toDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCreditcodeLike(String value) {
            addCriterion("to_department_creditcode like", value, "toDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCreditcodeNotLike(String value) {
            addCriterion("to_department_creditcode not like", value, "toDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCreditcodeLikeList(List<String> values) {
            addCriterion("to_department_creditcode like", values, "toDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCreditcodeIn(List<String> values) {
            addCriterion("to_department_creditcode in", values, "toDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCreditcodeNotIn(List<String> values) {
            addCriterion("to_department_creditcode not in", values, "toDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCreditcodeBetween(String value1, String value2) {
            addCriterion("to_department_creditcode between", value1, value2, "toDepartmentCreditcode");
            return (Criteria) this;
        }

        public Criteria andToDepartmentCreditcodeNotBetween(String value1, String value2) {
            addCriterion("to_department_creditcode not between", value1, value2, "toDepartmentCreditcode");
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

        public Criteria andAttachUrlIsNull() {
            addCriterion("attach_url is null");
            return (Criteria) this;
        }

        public Criteria andAttachUrlIsNotNull() {
            addCriterion("attach_url is not null");
            return (Criteria) this;
        }

        public Criteria andAttachUrlEqualTo(String value) {
            addCriterion("attach_url =", value, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlNotEqualTo(String value) {
            addCriterion("attach_url <>", value, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlGreaterThan(String value) {
            addCriterion("attach_url >", value, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlGreaterThanOrEqualTo(String value) {
            addCriterion("attach_url >=", value, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlLessThan(String value) {
            addCriterion("attach_url <", value, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlLessThanOrEqualTo(String value) {
            addCriterion("attach_url <=", value, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlLike(String value) {
            addCriterion("attach_url like", value, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlNotLike(String value) {
            addCriterion("attach_url not like", value, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlLikeList(List<String> values) {
            addCriterion("attach_url like", values, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlIn(List<String> values) {
            addCriterion("attach_url in", values, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlNotIn(List<String> values) {
            addCriterion("attach_url not in", values, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlBetween(String value1, String value2) {
            addCriterion("attach_url between", value1, value2, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlNotBetween(String value1, String value2) {
            addCriterion("attach_url not between", value1, value2, "attachUrl");
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
        private TransportCapacityExample example;

        protected Criteria(TransportCapacityExample example) {
            super();
            this.example = example;
        }

        public TransportCapacityExample example() {
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