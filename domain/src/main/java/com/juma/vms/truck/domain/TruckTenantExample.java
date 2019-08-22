package com.juma.vms.truck.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TruckTenantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int startOffSet = -1;

    protected int size = -1;

    public TruckTenantExample() {
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

    public TruckTenantExample orderBy(String ... orderByClauses) {
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

        public Criteria andTruckTenantIdIsNull() {
            addCriterion("truck_tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTruckTenantIdIsNotNull() {
            addCriterion("truck_tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTruckTenantIdEqualTo(Integer value) {
            addCriterion("truck_tenant_id =", value, "truckTenantId");
            return (Criteria) this;
        }

        public Criteria andTruckTenantIdNotEqualTo(Integer value) {
            addCriterion("truck_tenant_id <>", value, "truckTenantId");
            return (Criteria) this;
        }

        public Criteria andTruckTenantIdGreaterThan(Integer value) {
            addCriterion("truck_tenant_id >", value, "truckTenantId");
            return (Criteria) this;
        }

        public Criteria andTruckTenantIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("truck_tenant_id >=", value, "truckTenantId");
            return (Criteria) this;
        }

        public Criteria andTruckTenantIdLessThan(Integer value) {
            addCriterion("truck_tenant_id <", value, "truckTenantId");
            return (Criteria) this;
        }

        public Criteria andTruckTenantIdLessThanOrEqualTo(Integer value) {
            addCriterion("truck_tenant_id <=", value, "truckTenantId");
            return (Criteria) this;
        }

        public Criteria andTruckTenantIdIn(List<Integer> values) {
            addCriterion("truck_tenant_id in", values, "truckTenantId");
            return (Criteria) this;
        }

        public Criteria andTruckTenantIdNotIn(List<Integer> values) {
            addCriterion("truck_tenant_id not in", values, "truckTenantId");
            return (Criteria) this;
        }

        public Criteria andTruckTenantIdBetween(Integer value1, Integer value2) {
            addCriterion("truck_tenant_id between", value1, value2, "truckTenantId");
            return (Criteria) this;
        }

        public Criteria andTruckTenantIdNotBetween(Integer value1, Integer value2) {
            addCriterion("truck_tenant_id not between", value1, value2, "truckTenantId");
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

        public Criteria andIsOwnerIsNull() {
            addCriterion("is_owner is null");
            return (Criteria) this;
        }

        public Criteria andIsOwnerIsNotNull() {
            addCriterion("is_owner is not null");
            return (Criteria) this;
        }

        public Criteria andIsOwnerEqualTo(Boolean value) {
            addCriterion("is_owner =", value, "isOwner");
            return (Criteria) this;
        }

        public Criteria andIsOwnerNotEqualTo(Boolean value) {
            addCriterion("is_owner <>", value, "isOwner");
            return (Criteria) this;
        }

        public Criteria andIsOwnerGreaterThan(Boolean value) {
            addCriterion("is_owner >", value, "isOwner");
            return (Criteria) this;
        }

        public Criteria andIsOwnerGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_owner >=", value, "isOwner");
            return (Criteria) this;
        }

        public Criteria andIsOwnerLessThan(Boolean value) {
            addCriterion("is_owner <", value, "isOwner");
            return (Criteria) this;
        }

        public Criteria andIsOwnerLessThanOrEqualTo(Boolean value) {
            addCriterion("is_owner <=", value, "isOwner");
            return (Criteria) this;
        }

        public Criteria andIsOwnerIn(List<Boolean> values) {
            addCriterion("is_owner in", values, "isOwner");
            return (Criteria) this;
        }

        public Criteria andIsOwnerNotIn(List<Boolean> values) {
            addCriterion("is_owner not in", values, "isOwner");
            return (Criteria) this;
        }

        public Criteria andIsOwnerBetween(Boolean value1, Boolean value2) {
            addCriterion("is_owner between", value1, value2, "isOwner");
            return (Criteria) this;
        }

        public Criteria andIsOwnerNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_owner not between", value1, value2, "isOwner");
            return (Criteria) this;
        }

        public Criteria andIsReceivableIsNull() {
            addCriterion("is_receivable is null");
            return (Criteria) this;
        }

        public Criteria andIsReceivableIsNotNull() {
            addCriterion("is_receivable is not null");
            return (Criteria) this;
        }

        public Criteria andIsReceivableEqualTo(Boolean value) {
            addCriterion("is_receivable =", value, "isReceivable");
            return (Criteria) this;
        }

        public Criteria andIsReceivableNotEqualTo(Boolean value) {
            addCriterion("is_receivable <>", value, "isReceivable");
            return (Criteria) this;
        }

        public Criteria andIsReceivableGreaterThan(Boolean value) {
            addCriterion("is_receivable >", value, "isReceivable");
            return (Criteria) this;
        }

        public Criteria andIsReceivableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_receivable >=", value, "isReceivable");
            return (Criteria) this;
        }

        public Criteria andIsReceivableLessThan(Boolean value) {
            addCriterion("is_receivable <", value, "isReceivable");
            return (Criteria) this;
        }

        public Criteria andIsReceivableLessThanOrEqualTo(Boolean value) {
            addCriterion("is_receivable <=", value, "isReceivable");
            return (Criteria) this;
        }

        public Criteria andIsReceivableIn(List<Boolean> values) {
            addCriterion("is_receivable in", values, "isReceivable");
            return (Criteria) this;
        }

        public Criteria andIsReceivableNotIn(List<Boolean> values) {
            addCriterion("is_receivable not in", values, "isReceivable");
            return (Criteria) this;
        }

        public Criteria andIsReceivableBetween(Boolean value1, Boolean value2) {
            addCriterion("is_receivable between", value1, value2, "isReceivable");
            return (Criteria) this;
        }

        public Criteria andIsReceivableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_receivable not between", value1, value2, "isReceivable");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyIsNull() {
            addCriterion("truck_belong_to_company is null");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyIsNotNull() {
            addCriterion("truck_belong_to_company is not null");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyEqualTo(Integer value) {
            addCriterion("truck_belong_to_company =", value, "truckBelongToCompany");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyNotEqualTo(Integer value) {
            addCriterion("truck_belong_to_company <>", value, "truckBelongToCompany");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyGreaterThan(Integer value) {
            addCriterion("truck_belong_to_company >", value, "truckBelongToCompany");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyGreaterThanOrEqualTo(Integer value) {
            addCriterion("truck_belong_to_company >=", value, "truckBelongToCompany");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyLessThan(Integer value) {
            addCriterion("truck_belong_to_company <", value, "truckBelongToCompany");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyLessThanOrEqualTo(Integer value) {
            addCriterion("truck_belong_to_company <=", value, "truckBelongToCompany");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyIn(List<Integer> values) {
            addCriterion("truck_belong_to_company in", values, "truckBelongToCompany");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyNotIn(List<Integer> values) {
            addCriterion("truck_belong_to_company not in", values, "truckBelongToCompany");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyBetween(Integer value1, Integer value2) {
            addCriterion("truck_belong_to_company between", value1, value2, "truckBelongToCompany");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyNotBetween(Integer value1, Integer value2) {
            addCriterion("truck_belong_to_company not between", value1, value2, "truckBelongToCompany");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyCodeIsNull() {
            addCriterion("truck_belong_to_company_code is null");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyCodeIsNotNull() {
            addCriterion("truck_belong_to_company_code is not null");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyCodeEqualTo(String value) {
            addCriterion("truck_belong_to_company_code =", value, "truckBelongToCompanyCode");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyCodeNotEqualTo(String value) {
            addCriterion("truck_belong_to_company_code <>", value, "truckBelongToCompanyCode");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyCodeGreaterThan(String value) {
            addCriterion("truck_belong_to_company_code >", value, "truckBelongToCompanyCode");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("truck_belong_to_company_code >=", value, "truckBelongToCompanyCode");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyCodeLessThan(String value) {
            addCriterion("truck_belong_to_company_code <", value, "truckBelongToCompanyCode");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyCodeLessThanOrEqualTo(String value) {
            addCriterion("truck_belong_to_company_code <=", value, "truckBelongToCompanyCode");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyCodeLike(String value) {
            addCriterion("truck_belong_to_company_code like", value, "truckBelongToCompanyCode");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyCodeNotLike(String value) {
            addCriterion("truck_belong_to_company_code not like", value, "truckBelongToCompanyCode");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyCodeLikeList(List<String> values) {
            addCriterion("truck_belong_to_company_code like", values, "truckBelongToCompanyCode");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyCodeIn(List<String> values) {
            addCriterion("truck_belong_to_company_code in", values, "truckBelongToCompanyCode");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyCodeNotIn(List<String> values) {
            addCriterion("truck_belong_to_company_code not in", values, "truckBelongToCompanyCode");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyCodeBetween(String value1, String value2) {
            addCriterion("truck_belong_to_company_code between", value1, value2, "truckBelongToCompanyCode");
            return (Criteria) this;
        }

        public Criteria andTruckBelongToCompanyCodeNotBetween(String value1, String value2) {
            addCriterion("truck_belong_to_company_code not between", value1, value2, "truckBelongToCompanyCode");
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
    }

    public static class Criteria extends GeneratedCriteria {
        private TruckTenantExample example;

        protected Criteria(TruckTenantExample example) {
            super();
            this.example = example;
        }

        public TruckTenantExample example() {
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