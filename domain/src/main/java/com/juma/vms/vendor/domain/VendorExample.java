package com.juma.vms.vendor.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VendorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int startOffSet = -1;

    protected int size = -1;

    public VendorExample() {
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

    public VendorExample orderBy(String ... orderByClauses) {
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

        public Criteria andJumaPinIsNull() {
            addCriterion("juma_pin is null");
            return (Criteria) this;
        }

        public Criteria andJumaPinIsNotNull() {
            addCriterion("juma_pin is not null");
            return (Criteria) this;
        }

        public Criteria andJumaPinEqualTo(String value) {
            addCriterion("juma_pin =", value, "jumaPin");
            return (Criteria) this;
        }

        public Criteria andJumaPinNotEqualTo(String value) {
            addCriterion("juma_pin <>", value, "jumaPin");
            return (Criteria) this;
        }

        public Criteria andJumaPinGreaterThan(String value) {
            addCriterion("juma_pin >", value, "jumaPin");
            return (Criteria) this;
        }

        public Criteria andJumaPinGreaterThanOrEqualTo(String value) {
            addCriterion("juma_pin >=", value, "jumaPin");
            return (Criteria) this;
        }

        public Criteria andJumaPinLessThan(String value) {
            addCriterion("juma_pin <", value, "jumaPin");
            return (Criteria) this;
        }

        public Criteria andJumaPinLessThanOrEqualTo(String value) {
            addCriterion("juma_pin <=", value, "jumaPin");
            return (Criteria) this;
        }

        public Criteria andJumaPinLike(String value) {
            addCriterion("juma_pin like", value, "jumaPin");
            return (Criteria) this;
        }

        public Criteria andJumaPinNotLike(String value) {
            addCriterion("juma_pin not like", value, "jumaPin");
            return (Criteria) this;
        }

        public Criteria andJumaPinLikeList(List<String> values) {
            addCriterion("juma_pin like", values, "jumaPin");
            return (Criteria) this;
        }

        public Criteria andJumaPinIn(List<String> values) {
            addCriterion("juma_pin in", values, "jumaPin");
            return (Criteria) this;
        }

        public Criteria andJumaPinNotIn(List<String> values) {
            addCriterion("juma_pin not in", values, "jumaPin");
            return (Criteria) this;
        }

        public Criteria andJumaPinBetween(String value1, String value2) {
            addCriterion("juma_pin between", value1, value2, "jumaPin");
            return (Criteria) this;
        }

        public Criteria andJumaPinNotBetween(String value1, String value2) {
            addCriterion("juma_pin not between", value1, value2, "jumaPin");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andVendorNameIsNull() {
            addCriterion("vendor_name is null");
            return (Criteria) this;
        }

        public Criteria andVendorNameIsNotNull() {
            addCriterion("vendor_name is not null");
            return (Criteria) this;
        }

        public Criteria andVendorNameEqualTo(String value) {
            addCriterion("vendor_name =", value, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorNameNotEqualTo(String value) {
            addCriterion("vendor_name <>", value, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorNameGreaterThan(String value) {
            addCriterion("vendor_name >", value, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorNameGreaterThanOrEqualTo(String value) {
            addCriterion("vendor_name >=", value, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorNameLessThan(String value) {
            addCriterion("vendor_name <", value, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorNameLessThanOrEqualTo(String value) {
            addCriterion("vendor_name <=", value, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorNameLike(String value) {
            addCriterion("vendor_name like", value, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorNameNotLike(String value) {
            addCriterion("vendor_name not like", value, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorNameLikeList(List<String> values) {
            addCriterion("vendor_name like", values, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorNameIn(List<String> values) {
            addCriterion("vendor_name in", values, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorNameNotIn(List<String> values) {
            addCriterion("vendor_name not in", values, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorNameBetween(String value1, String value2) {
            addCriterion("vendor_name between", value1, value2, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorNameNotBetween(String value1, String value2) {
            addCriterion("vendor_name not between", value1, value2, "vendorName");
            return (Criteria) this;
        }

        public Criteria andSerialNoIsNull() {
            addCriterion("serial_no is null");
            return (Criteria) this;
        }

        public Criteria andSerialNoIsNotNull() {
            addCriterion("serial_no is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNoEqualTo(String value) {
            addCriterion("serial_no =", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotEqualTo(String value) {
            addCriterion("serial_no <>", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoGreaterThan(String value) {
            addCriterion("serial_no >", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoGreaterThanOrEqualTo(String value) {
            addCriterion("serial_no >=", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoLessThan(String value) {
            addCriterion("serial_no <", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoLessThanOrEqualTo(String value) {
            addCriterion("serial_no <=", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoLike(String value) {
            addCriterion("serial_no like", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotLike(String value) {
            addCriterion("serial_no not like", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoLikeList(List<String> values) {
            addCriterion("serial_no like", values, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoIn(List<String> values) {
            addCriterion("serial_no in", values, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotIn(List<String> values) {
            addCriterion("serial_no not in", values, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoBetween(String value1, String value2) {
            addCriterion("serial_no between", value1, value2, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotBetween(String value1, String value2) {
            addCriterion("serial_no not between", value1, value2, "serialNo");
            return (Criteria) this;
        }

        public Criteria andContactUserNameIsNull() {
            addCriterion("contact_user_name is null");
            return (Criteria) this;
        }

        public Criteria andContactUserNameIsNotNull() {
            addCriterion("contact_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andContactUserNameEqualTo(String value) {
            addCriterion("contact_user_name =", value, "contactUserName");
            return (Criteria) this;
        }

        public Criteria andContactUserNameNotEqualTo(String value) {
            addCriterion("contact_user_name <>", value, "contactUserName");
            return (Criteria) this;
        }

        public Criteria andContactUserNameGreaterThan(String value) {
            addCriterion("contact_user_name >", value, "contactUserName");
            return (Criteria) this;
        }

        public Criteria andContactUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("contact_user_name >=", value, "contactUserName");
            return (Criteria) this;
        }

        public Criteria andContactUserNameLessThan(String value) {
            addCriterion("contact_user_name <", value, "contactUserName");
            return (Criteria) this;
        }

        public Criteria andContactUserNameLessThanOrEqualTo(String value) {
            addCriterion("contact_user_name <=", value, "contactUserName");
            return (Criteria) this;
        }

        public Criteria andContactUserNameLike(String value) {
            addCriterion("contact_user_name like", value, "contactUserName");
            return (Criteria) this;
        }

        public Criteria andContactUserNameNotLike(String value) {
            addCriterion("contact_user_name not like", value, "contactUserName");
            return (Criteria) this;
        }

        public Criteria andContactUserNameLikeList(List<String> values) {
            addCriterion("contact_user_name like", values, "contactUserName");
            return (Criteria) this;
        }

        public Criteria andContactUserNameIn(List<String> values) {
            addCriterion("contact_user_name in", values, "contactUserName");
            return (Criteria) this;
        }

        public Criteria andContactUserNameNotIn(List<String> values) {
            addCriterion("contact_user_name not in", values, "contactUserName");
            return (Criteria) this;
        }

        public Criteria andContactUserNameBetween(String value1, String value2) {
            addCriterion("contact_user_name between", value1, value2, "contactUserName");
            return (Criteria) this;
        }

        public Criteria andContactUserNameNotBetween(String value1, String value2) {
            addCriterion("contact_user_name not between", value1, value2, "contactUserName");
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

        public Criteria andEmergencyContactPhoneIsNull() {
            addCriterion("emergency_contact_phone is null");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactPhoneIsNotNull() {
            addCriterion("emergency_contact_phone is not null");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactPhoneEqualTo(String value) {
            addCriterion("emergency_contact_phone =", value, "emergencyContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactPhoneNotEqualTo(String value) {
            addCriterion("emergency_contact_phone <>", value, "emergencyContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactPhoneGreaterThan(String value) {
            addCriterion("emergency_contact_phone >", value, "emergencyContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("emergency_contact_phone >=", value, "emergencyContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactPhoneLessThan(String value) {
            addCriterion("emergency_contact_phone <", value, "emergencyContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("emergency_contact_phone <=", value, "emergencyContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactPhoneLike(String value) {
            addCriterion("emergency_contact_phone like", value, "emergencyContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactPhoneNotLike(String value) {
            addCriterion("emergency_contact_phone not like", value, "emergencyContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactPhoneLikeList(List<String> values) {
            addCriterion("emergency_contact_phone like", values, "emergencyContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactPhoneIn(List<String> values) {
            addCriterion("emergency_contact_phone in", values, "emergencyContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactPhoneNotIn(List<String> values) {
            addCriterion("emergency_contact_phone not in", values, "emergencyContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactPhoneBetween(String value1, String value2) {
            addCriterion("emergency_contact_phone between", value1, value2, "emergencyContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactPhoneNotBetween(String value1, String value2) {
            addCriterion("emergency_contact_phone not between", value1, value2, "emergencyContactPhone");
            return (Criteria) this;
        }

        public Criteria andIdCardNoIsNull() {
            addCriterion("id_card_no is null");
            return (Criteria) this;
        }

        public Criteria andIdCardNoIsNotNull() {
            addCriterion("id_card_no is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardNoEqualTo(String value) {
            addCriterion("id_card_no =", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotEqualTo(String value) {
            addCriterion("id_card_no <>", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoGreaterThan(String value) {
            addCriterion("id_card_no >", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_no >=", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoLessThan(String value) {
            addCriterion("id_card_no <", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoLessThanOrEqualTo(String value) {
            addCriterion("id_card_no <=", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoLike(String value) {
            addCriterion("id_card_no like", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotLike(String value) {
            addCriterion("id_card_no not like", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoLikeList(List<String> values) {
            addCriterion("id_card_no like", values, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoIn(List<String> values) {
            addCriterion("id_card_no in", values, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotIn(List<String> values) {
            addCriterion("id_card_no not in", values, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoBetween(String value1, String value2) {
            addCriterion("id_card_no between", value1, value2, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotBetween(String value1, String value2) {
            addCriterion("id_card_no not between", value1, value2, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoExpireTimeIsNull() {
            addCriterion("id_card_no_expire_time is null");
            return (Criteria) this;
        }

        public Criteria andIdCardNoExpireTimeIsNotNull() {
            addCriterion("id_card_no_expire_time is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardNoExpireTimeEqualTo(Date value) {
            addCriterion("id_card_no_expire_time =", value, "idCardNoExpireTime");
            return (Criteria) this;
        }

        public Criteria andIdCardNoExpireTimeNotEqualTo(Date value) {
            addCriterion("id_card_no_expire_time <>", value, "idCardNoExpireTime");
            return (Criteria) this;
        }

        public Criteria andIdCardNoExpireTimeGreaterThan(Date value) {
            addCriterion("id_card_no_expire_time >", value, "idCardNoExpireTime");
            return (Criteria) this;
        }

        public Criteria andIdCardNoExpireTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("id_card_no_expire_time >=", value, "idCardNoExpireTime");
            return (Criteria) this;
        }

        public Criteria andIdCardNoExpireTimeLessThan(Date value) {
            addCriterion("id_card_no_expire_time <", value, "idCardNoExpireTime");
            return (Criteria) this;
        }

        public Criteria andIdCardNoExpireTimeLessThanOrEqualTo(Date value) {
            addCriterion("id_card_no_expire_time <=", value, "idCardNoExpireTime");
            return (Criteria) this;
        }

        public Criteria andIdCardNoExpireTimeIn(List<Date> values) {
            addCriterion("id_card_no_expire_time in", values, "idCardNoExpireTime");
            return (Criteria) this;
        }

        public Criteria andIdCardNoExpireTimeNotIn(List<Date> values) {
            addCriterion("id_card_no_expire_time not in", values, "idCardNoExpireTime");
            return (Criteria) this;
        }

        public Criteria andIdCardNoExpireTimeBetween(Date value1, Date value2) {
            addCriterion("id_card_no_expire_time between", value1, value2, "idCardNoExpireTime");
            return (Criteria) this;
        }

        public Criteria andIdCardNoExpireTimeNotBetween(Date value1, Date value2) {
            addCriterion("id_card_no_expire_time not between", value1, value2, "idCardNoExpireTime");
            return (Criteria) this;
        }

        public Criteria andTaxNoIsNull() {
            addCriterion("tax_no is null");
            return (Criteria) this;
        }

        public Criteria andTaxNoIsNotNull() {
            addCriterion("tax_no is not null");
            return (Criteria) this;
        }

        public Criteria andTaxNoEqualTo(String value) {
            addCriterion("tax_no =", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoNotEqualTo(String value) {
            addCriterion("tax_no <>", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoGreaterThan(String value) {
            addCriterion("tax_no >", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoGreaterThanOrEqualTo(String value) {
            addCriterion("tax_no >=", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoLessThan(String value) {
            addCriterion("tax_no <", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoLessThanOrEqualTo(String value) {
            addCriterion("tax_no <=", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoLike(String value) {
            addCriterion("tax_no like", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoNotLike(String value) {
            addCriterion("tax_no not like", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoLikeList(List<String> values) {
            addCriterion("tax_no like", values, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoIn(List<String> values) {
            addCriterion("tax_no in", values, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoNotIn(List<String> values) {
            addCriterion("tax_no not in", values, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoBetween(String value1, String value2) {
            addCriterion("tax_no between", value1, value2, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoNotBetween(String value1, String value2) {
            addCriterion("tax_no not between", value1, value2, "taxNo");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(Byte value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(Byte value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(Byte value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(Byte value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(Byte value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(Byte value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<Byte> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<Byte> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(Byte value1, Byte value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(Byte value1, Byte value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andVendorSourceIsNull() {
            addCriterion("vendor_source is null");
            return (Criteria) this;
        }

        public Criteria andVendorSourceIsNotNull() {
            addCriterion("vendor_source is not null");
            return (Criteria) this;
        }

        public Criteria andVendorSourceEqualTo(Byte value) {
            addCriterion("vendor_source =", value, "vendorSource");
            return (Criteria) this;
        }

        public Criteria andVendorSourceNotEqualTo(Byte value) {
            addCriterion("vendor_source <>", value, "vendorSource");
            return (Criteria) this;
        }

        public Criteria andVendorSourceGreaterThan(Byte value) {
            addCriterion("vendor_source >", value, "vendorSource");
            return (Criteria) this;
        }

        public Criteria andVendorSourceGreaterThanOrEqualTo(Byte value) {
            addCriterion("vendor_source >=", value, "vendorSource");
            return (Criteria) this;
        }

        public Criteria andVendorSourceLessThan(Byte value) {
            addCriterion("vendor_source <", value, "vendorSource");
            return (Criteria) this;
        }

        public Criteria andVendorSourceLessThanOrEqualTo(Byte value) {
            addCriterion("vendor_source <=", value, "vendorSource");
            return (Criteria) this;
        }

        public Criteria andVendorSourceIn(List<Byte> values) {
            addCriterion("vendor_source in", values, "vendorSource");
            return (Criteria) this;
        }

        public Criteria andVendorSourceNotIn(List<Byte> values) {
            addCriterion("vendor_source not in", values, "vendorSource");
            return (Criteria) this;
        }

        public Criteria andVendorSourceBetween(Byte value1, Byte value2) {
            addCriterion("vendor_source between", value1, value2, "vendorSource");
            return (Criteria) this;
        }

        public Criteria andVendorSourceNotBetween(Byte value1, Byte value2) {
            addCriterion("vendor_source not between", value1, value2, "vendorSource");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositIsNull() {
            addCriterion("bank_of_deposit is null");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositIsNotNull() {
            addCriterion("bank_of_deposit is not null");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositEqualTo(String value) {
            addCriterion("bank_of_deposit =", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositNotEqualTo(String value) {
            addCriterion("bank_of_deposit <>", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositGreaterThan(String value) {
            addCriterion("bank_of_deposit >", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositGreaterThanOrEqualTo(String value) {
            addCriterion("bank_of_deposit >=", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositLessThan(String value) {
            addCriterion("bank_of_deposit <", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositLessThanOrEqualTo(String value) {
            addCriterion("bank_of_deposit <=", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositLike(String value) {
            addCriterion("bank_of_deposit like", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositNotLike(String value) {
            addCriterion("bank_of_deposit not like", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositLikeList(List<String> values) {
            addCriterion("bank_of_deposit like", values, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositIn(List<String> values) {
            addCriterion("bank_of_deposit in", values, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositNotIn(List<String> values) {
            addCriterion("bank_of_deposit not in", values, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositBetween(String value1, String value2) {
            addCriterion("bank_of_deposit between", value1, value2, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositNotBetween(String value1, String value2) {
            addCriterion("bank_of_deposit not between", value1, value2, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNull() {
            addCriterion("bank_account is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNotNull() {
            addCriterion("bank_account is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountEqualTo(String value) {
            addCriterion("bank_account =", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotEqualTo(String value) {
            addCriterion("bank_account <>", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThan(String value) {
            addCriterion("bank_account >", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account >=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThan(String value) {
            addCriterion("bank_account <", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThanOrEqualTo(String value) {
            addCriterion("bank_account <=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLike(String value) {
            addCriterion("bank_account like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotLike(String value) {
            addCriterion("bank_account not like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLikeList(List<String> values) {
            addCriterion("bank_account like", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountIn(List<String> values) {
            addCriterion("bank_account in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotIn(List<String> values) {
            addCriterion("bank_account not in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountBetween(String value1, String value2) {
            addCriterion("bank_account between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotBetween(String value1, String value2) {
            addCriterion("bank_account not between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeIsNull() {
            addCriterion("enterprise_code is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeIsNotNull() {
            addCriterion("enterprise_code is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeEqualTo(String value) {
            addCriterion("enterprise_code =", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeNotEqualTo(String value) {
            addCriterion("enterprise_code <>", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeGreaterThan(String value) {
            addCriterion("enterprise_code >", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_code >=", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeLessThan(String value) {
            addCriterion("enterprise_code <", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeLessThanOrEqualTo(String value) {
            addCriterion("enterprise_code <=", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeLike(String value) {
            addCriterion("enterprise_code like", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeNotLike(String value) {
            addCriterion("enterprise_code not like", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeLikeList(List<String> values) {
            addCriterion("enterprise_code like", values, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeIn(List<String> values) {
            addCriterion("enterprise_code in", values, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeNotIn(List<String> values) {
            addCriterion("enterprise_code not in", values, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeBetween(String value1, String value2) {
            addCriterion("enterprise_code between", value1, value2, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeNotBetween(String value1, String value2) {
            addCriterion("enterprise_code not between", value1, value2, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andSkillLicenseExpireTimeIsNull() {
            addCriterion("skill_license_expire_time is null");
            return (Criteria) this;
        }

        public Criteria andSkillLicenseExpireTimeIsNotNull() {
            addCriterion("skill_license_expire_time is not null");
            return (Criteria) this;
        }

        public Criteria andSkillLicenseExpireTimeEqualTo(Date value) {
            addCriterion("skill_license_expire_time =", value, "skillLicenseExpireTime");
            return (Criteria) this;
        }

        public Criteria andSkillLicenseExpireTimeNotEqualTo(Date value) {
            addCriterion("skill_license_expire_time <>", value, "skillLicenseExpireTime");
            return (Criteria) this;
        }

        public Criteria andSkillLicenseExpireTimeGreaterThan(Date value) {
            addCriterion("skill_license_expire_time >", value, "skillLicenseExpireTime");
            return (Criteria) this;
        }

        public Criteria andSkillLicenseExpireTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("skill_license_expire_time >=", value, "skillLicenseExpireTime");
            return (Criteria) this;
        }

        public Criteria andSkillLicenseExpireTimeLessThan(Date value) {
            addCriterion("skill_license_expire_time <", value, "skillLicenseExpireTime");
            return (Criteria) this;
        }

        public Criteria andSkillLicenseExpireTimeLessThanOrEqualTo(Date value) {
            addCriterion("skill_license_expire_time <=", value, "skillLicenseExpireTime");
            return (Criteria) this;
        }

        public Criteria andSkillLicenseExpireTimeIn(List<Date> values) {
            addCriterion("skill_license_expire_time in", values, "skillLicenseExpireTime");
            return (Criteria) this;
        }

        public Criteria andSkillLicenseExpireTimeNotIn(List<Date> values) {
            addCriterion("skill_license_expire_time not in", values, "skillLicenseExpireTime");
            return (Criteria) this;
        }

        public Criteria andSkillLicenseExpireTimeBetween(Date value1, Date value2) {
            addCriterion("skill_license_expire_time between", value1, value2, "skillLicenseExpireTime");
            return (Criteria) this;
        }

        public Criteria andSkillLicenseExpireTimeNotBetween(Date value1, Date value2) {
            addCriterion("skill_license_expire_time not between", value1, value2, "skillLicenseExpireTime");
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

        public Criteria andIdCardImg1IsNull() {
            addCriterion("id_card_img_1 is null");
            return (Criteria) this;
        }

        public Criteria andIdCardImg1IsNotNull() {
            addCriterion("id_card_img_1 is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardImg1EqualTo(String value) {
            addCriterion("id_card_img_1 =", value, "idCardImg1");
            return (Criteria) this;
        }

        public Criteria andIdCardImg1NotEqualTo(String value) {
            addCriterion("id_card_img_1 <>", value, "idCardImg1");
            return (Criteria) this;
        }

        public Criteria andIdCardImg1GreaterThan(String value) {
            addCriterion("id_card_img_1 >", value, "idCardImg1");
            return (Criteria) this;
        }

        public Criteria andIdCardImg1GreaterThanOrEqualTo(String value) {
            addCriterion("id_card_img_1 >=", value, "idCardImg1");
            return (Criteria) this;
        }

        public Criteria andIdCardImg1LessThan(String value) {
            addCriterion("id_card_img_1 <", value, "idCardImg1");
            return (Criteria) this;
        }

        public Criteria andIdCardImg1LessThanOrEqualTo(String value) {
            addCriterion("id_card_img_1 <=", value, "idCardImg1");
            return (Criteria) this;
        }

        public Criteria andIdCardImg1Like(String value) {
            addCriterion("id_card_img_1 like", value, "idCardImg1");
            return (Criteria) this;
        }

        public Criteria andIdCardImg1NotLike(String value) {
            addCriterion("id_card_img_1 not like", value, "idCardImg1");
            return (Criteria) this;
        }

        public Criteria andIdCardImg1LikeList(List<String> values) {
            addCriterion("id_card_img_1 like", values, "idCardImg1");
            return (Criteria) this;
        }

        public Criteria andIdCardImg1In(List<String> values) {
            addCriterion("id_card_img_1 in", values, "idCardImg1");
            return (Criteria) this;
        }

        public Criteria andIdCardImg1NotIn(List<String> values) {
            addCriterion("id_card_img_1 not in", values, "idCardImg1");
            return (Criteria) this;
        }

        public Criteria andIdCardImg1Between(String value1, String value2) {
            addCriterion("id_card_img_1 between", value1, value2, "idCardImg1");
            return (Criteria) this;
        }

        public Criteria andIdCardImg1NotBetween(String value1, String value2) {
            addCriterion("id_card_img_1 not between", value1, value2, "idCardImg1");
            return (Criteria) this;
        }

        public Criteria andIdCardImg2IsNull() {
            addCriterion("id_card_img_2 is null");
            return (Criteria) this;
        }

        public Criteria andIdCardImg2IsNotNull() {
            addCriterion("id_card_img_2 is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardImg2EqualTo(String value) {
            addCriterion("id_card_img_2 =", value, "idCardImg2");
            return (Criteria) this;
        }

        public Criteria andIdCardImg2NotEqualTo(String value) {
            addCriterion("id_card_img_2 <>", value, "idCardImg2");
            return (Criteria) this;
        }

        public Criteria andIdCardImg2GreaterThan(String value) {
            addCriterion("id_card_img_2 >", value, "idCardImg2");
            return (Criteria) this;
        }

        public Criteria andIdCardImg2GreaterThanOrEqualTo(String value) {
            addCriterion("id_card_img_2 >=", value, "idCardImg2");
            return (Criteria) this;
        }

        public Criteria andIdCardImg2LessThan(String value) {
            addCriterion("id_card_img_2 <", value, "idCardImg2");
            return (Criteria) this;
        }

        public Criteria andIdCardImg2LessThanOrEqualTo(String value) {
            addCriterion("id_card_img_2 <=", value, "idCardImg2");
            return (Criteria) this;
        }

        public Criteria andIdCardImg2Like(String value) {
            addCriterion("id_card_img_2 like", value, "idCardImg2");
            return (Criteria) this;
        }

        public Criteria andIdCardImg2NotLike(String value) {
            addCriterion("id_card_img_2 not like", value, "idCardImg2");
            return (Criteria) this;
        }

        public Criteria andIdCardImg2LikeList(List<String> values) {
            addCriterion("id_card_img_2 like", values, "idCardImg2");
            return (Criteria) this;
        }

        public Criteria andIdCardImg2In(List<String> values) {
            addCriterion("id_card_img_2 in", values, "idCardImg2");
            return (Criteria) this;
        }

        public Criteria andIdCardImg2NotIn(List<String> values) {
            addCriterion("id_card_img_2 not in", values, "idCardImg2");
            return (Criteria) this;
        }

        public Criteria andIdCardImg2Between(String value1, String value2) {
            addCriterion("id_card_img_2 between", value1, value2, "idCardImg2");
            return (Criteria) this;
        }

        public Criteria andIdCardImg2NotBetween(String value1, String value2) {
            addCriterion("id_card_img_2 not between", value1, value2, "idCardImg2");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg1IsNull() {
            addCriterion("quality_cert_img_1 is null");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg1IsNotNull() {
            addCriterion("quality_cert_img_1 is not null");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg1EqualTo(String value) {
            addCriterion("quality_cert_img_1 =", value, "qualityCertImg1");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg1NotEqualTo(String value) {
            addCriterion("quality_cert_img_1 <>", value, "qualityCertImg1");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg1GreaterThan(String value) {
            addCriterion("quality_cert_img_1 >", value, "qualityCertImg1");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg1GreaterThanOrEqualTo(String value) {
            addCriterion("quality_cert_img_1 >=", value, "qualityCertImg1");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg1LessThan(String value) {
            addCriterion("quality_cert_img_1 <", value, "qualityCertImg1");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg1LessThanOrEqualTo(String value) {
            addCriterion("quality_cert_img_1 <=", value, "qualityCertImg1");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg1Like(String value) {
            addCriterion("quality_cert_img_1 like", value, "qualityCertImg1");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg1NotLike(String value) {
            addCriterion("quality_cert_img_1 not like", value, "qualityCertImg1");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg1LikeList(List<String> values) {
            addCriterion("quality_cert_img_1 like", values, "qualityCertImg1");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg1In(List<String> values) {
            addCriterion("quality_cert_img_1 in", values, "qualityCertImg1");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg1NotIn(List<String> values) {
            addCriterion("quality_cert_img_1 not in", values, "qualityCertImg1");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg1Between(String value1, String value2) {
            addCriterion("quality_cert_img_1 between", value1, value2, "qualityCertImg1");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg1NotBetween(String value1, String value2) {
            addCriterion("quality_cert_img_1 not between", value1, value2, "qualityCertImg1");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg2IsNull() {
            addCriterion("quality_cert_img_2 is null");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg2IsNotNull() {
            addCriterion("quality_cert_img_2 is not null");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg2EqualTo(String value) {
            addCriterion("quality_cert_img_2 =", value, "qualityCertImg2");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg2NotEqualTo(String value) {
            addCriterion("quality_cert_img_2 <>", value, "qualityCertImg2");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg2GreaterThan(String value) {
            addCriterion("quality_cert_img_2 >", value, "qualityCertImg2");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg2GreaterThanOrEqualTo(String value) {
            addCriterion("quality_cert_img_2 >=", value, "qualityCertImg2");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg2LessThan(String value) {
            addCriterion("quality_cert_img_2 <", value, "qualityCertImg2");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg2LessThanOrEqualTo(String value) {
            addCriterion("quality_cert_img_2 <=", value, "qualityCertImg2");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg2Like(String value) {
            addCriterion("quality_cert_img_2 like", value, "qualityCertImg2");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg2NotLike(String value) {
            addCriterion("quality_cert_img_2 not like", value, "qualityCertImg2");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg2LikeList(List<String> values) {
            addCriterion("quality_cert_img_2 like", values, "qualityCertImg2");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg2In(List<String> values) {
            addCriterion("quality_cert_img_2 in", values, "qualityCertImg2");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg2NotIn(List<String> values) {
            addCriterion("quality_cert_img_2 not in", values, "qualityCertImg2");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg2Between(String value1, String value2) {
            addCriterion("quality_cert_img_2 between", value1, value2, "qualityCertImg2");
            return (Criteria) this;
        }

        public Criteria andQualityCertImg2NotBetween(String value1, String value2) {
            addCriterion("quality_cert_img_2 not between", value1, value2, "qualityCertImg2");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg1IsNull() {
            addCriterion("road_trans_permit_img_1 is null");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg1IsNotNull() {
            addCriterion("road_trans_permit_img_1 is not null");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg1EqualTo(String value) {
            addCriterion("road_trans_permit_img_1 =", value, "roadTransPermitImg1");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg1NotEqualTo(String value) {
            addCriterion("road_trans_permit_img_1 <>", value, "roadTransPermitImg1");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg1GreaterThan(String value) {
            addCriterion("road_trans_permit_img_1 >", value, "roadTransPermitImg1");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg1GreaterThanOrEqualTo(String value) {
            addCriterion("road_trans_permit_img_1 >=", value, "roadTransPermitImg1");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg1LessThan(String value) {
            addCriterion("road_trans_permit_img_1 <", value, "roadTransPermitImg1");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg1LessThanOrEqualTo(String value) {
            addCriterion("road_trans_permit_img_1 <=", value, "roadTransPermitImg1");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg1Like(String value) {
            addCriterion("road_trans_permit_img_1 like", value, "roadTransPermitImg1");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg1NotLike(String value) {
            addCriterion("road_trans_permit_img_1 not like", value, "roadTransPermitImg1");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg1LikeList(List<String> values) {
            addCriterion("road_trans_permit_img_1 like", values, "roadTransPermitImg1");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg1In(List<String> values) {
            addCriterion("road_trans_permit_img_1 in", values, "roadTransPermitImg1");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg1NotIn(List<String> values) {
            addCriterion("road_trans_permit_img_1 not in", values, "roadTransPermitImg1");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg1Between(String value1, String value2) {
            addCriterion("road_trans_permit_img_1 between", value1, value2, "roadTransPermitImg1");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg1NotBetween(String value1, String value2) {
            addCriterion("road_trans_permit_img_1 not between", value1, value2, "roadTransPermitImg1");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg2IsNull() {
            addCriterion("road_trans_permit_img_2 is null");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg2IsNotNull() {
            addCriterion("road_trans_permit_img_2 is not null");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg2EqualTo(String value) {
            addCriterion("road_trans_permit_img_2 =", value, "roadTransPermitImg2");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg2NotEqualTo(String value) {
            addCriterion("road_trans_permit_img_2 <>", value, "roadTransPermitImg2");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg2GreaterThan(String value) {
            addCriterion("road_trans_permit_img_2 >", value, "roadTransPermitImg2");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg2GreaterThanOrEqualTo(String value) {
            addCriterion("road_trans_permit_img_2 >=", value, "roadTransPermitImg2");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg2LessThan(String value) {
            addCriterion("road_trans_permit_img_2 <", value, "roadTransPermitImg2");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg2LessThanOrEqualTo(String value) {
            addCriterion("road_trans_permit_img_2 <=", value, "roadTransPermitImg2");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg2Like(String value) {
            addCriterion("road_trans_permit_img_2 like", value, "roadTransPermitImg2");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg2NotLike(String value) {
            addCriterion("road_trans_permit_img_2 not like", value, "roadTransPermitImg2");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg2LikeList(List<String> values) {
            addCriterion("road_trans_permit_img_2 like", values, "roadTransPermitImg2");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg2In(List<String> values) {
            addCriterion("road_trans_permit_img_2 in", values, "roadTransPermitImg2");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg2NotIn(List<String> values) {
            addCriterion("road_trans_permit_img_2 not in", values, "roadTransPermitImg2");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg2Between(String value1, String value2) {
            addCriterion("road_trans_permit_img_2 between", value1, value2, "roadTransPermitImg2");
            return (Criteria) this;
        }

        public Criteria andRoadTransPermitImg2NotBetween(String value1, String value2) {
            addCriterion("road_trans_permit_img_2 not between", value1, value2, "roadTransPermitImg2");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg1IsNull() {
            addCriterion("business_license_img_1 is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg1IsNotNull() {
            addCriterion("business_license_img_1 is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg1EqualTo(String value) {
            addCriterion("business_license_img_1 =", value, "businessLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg1NotEqualTo(String value) {
            addCriterion("business_license_img_1 <>", value, "businessLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg1GreaterThan(String value) {
            addCriterion("business_license_img_1 >", value, "businessLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg1GreaterThanOrEqualTo(String value) {
            addCriterion("business_license_img_1 >=", value, "businessLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg1LessThan(String value) {
            addCriterion("business_license_img_1 <", value, "businessLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg1LessThanOrEqualTo(String value) {
            addCriterion("business_license_img_1 <=", value, "businessLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg1Like(String value) {
            addCriterion("business_license_img_1 like", value, "businessLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg1NotLike(String value) {
            addCriterion("business_license_img_1 not like", value, "businessLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg1LikeList(List<String> values) {
            addCriterion("business_license_img_1 like", values, "businessLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg1In(List<String> values) {
            addCriterion("business_license_img_1 in", values, "businessLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg1NotIn(List<String> values) {
            addCriterion("business_license_img_1 not in", values, "businessLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg1Between(String value1, String value2) {
            addCriterion("business_license_img_1 between", value1, value2, "businessLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg1NotBetween(String value1, String value2) {
            addCriterion("business_license_img_1 not between", value1, value2, "businessLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg2IsNull() {
            addCriterion("business_license_img_2 is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg2IsNotNull() {
            addCriterion("business_license_img_2 is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg2EqualTo(String value) {
            addCriterion("business_license_img_2 =", value, "businessLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg2NotEqualTo(String value) {
            addCriterion("business_license_img_2 <>", value, "businessLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg2GreaterThan(String value) {
            addCriterion("business_license_img_2 >", value, "businessLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg2GreaterThanOrEqualTo(String value) {
            addCriterion("business_license_img_2 >=", value, "businessLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg2LessThan(String value) {
            addCriterion("business_license_img_2 <", value, "businessLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg2LessThanOrEqualTo(String value) {
            addCriterion("business_license_img_2 <=", value, "businessLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg2Like(String value) {
            addCriterion("business_license_img_2 like", value, "businessLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg2NotLike(String value) {
            addCriterion("business_license_img_2 not like", value, "businessLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg2LikeList(List<String> values) {
            addCriterion("business_license_img_2 like", values, "businessLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg2In(List<String> values) {
            addCriterion("business_license_img_2 in", values, "businessLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg2NotIn(List<String> values) {
            addCriterion("business_license_img_2 not in", values, "businessLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg2Between(String value1, String value2) {
            addCriterion("business_license_img_2 between", value1, value2, "businessLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImg2NotBetween(String value1, String value2) {
            addCriterion("business_license_img_2 not between", value1, value2, "businessLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andVendorAddressIsNull() {
            addCriterion("vendor_address is null");
            return (Criteria) this;
        }

        public Criteria andVendorAddressIsNotNull() {
            addCriterion("vendor_address is not null");
            return (Criteria) this;
        }

        public Criteria andVendorAddressEqualTo(String value) {
            addCriterion("vendor_address =", value, "vendorAddress");
            return (Criteria) this;
        }

        public Criteria andVendorAddressNotEqualTo(String value) {
            addCriterion("vendor_address <>", value, "vendorAddress");
            return (Criteria) this;
        }

        public Criteria andVendorAddressGreaterThan(String value) {
            addCriterion("vendor_address >", value, "vendorAddress");
            return (Criteria) this;
        }

        public Criteria andVendorAddressGreaterThanOrEqualTo(String value) {
            addCriterion("vendor_address >=", value, "vendorAddress");
            return (Criteria) this;
        }

        public Criteria andVendorAddressLessThan(String value) {
            addCriterion("vendor_address <", value, "vendorAddress");
            return (Criteria) this;
        }

        public Criteria andVendorAddressLessThanOrEqualTo(String value) {
            addCriterion("vendor_address <=", value, "vendorAddress");
            return (Criteria) this;
        }

        public Criteria andVendorAddressLike(String value) {
            addCriterion("vendor_address like", value, "vendorAddress");
            return (Criteria) this;
        }

        public Criteria andVendorAddressNotLike(String value) {
            addCriterion("vendor_address not like", value, "vendorAddress");
            return (Criteria) this;
        }

        public Criteria andVendorAddressLikeList(List<String> values) {
            addCriterion("vendor_address like", values, "vendorAddress");
            return (Criteria) this;
        }

        public Criteria andVendorAddressIn(List<String> values) {
            addCriterion("vendor_address in", values, "vendorAddress");
            return (Criteria) this;
        }

        public Criteria andVendorAddressNotIn(List<String> values) {
            addCriterion("vendor_address not in", values, "vendorAddress");
            return (Criteria) this;
        }

        public Criteria andVendorAddressBetween(String value1, String value2) {
            addCriterion("vendor_address between", value1, value2, "vendorAddress");
            return (Criteria) this;
        }

        public Criteria andVendorAddressNotBetween(String value1, String value2) {
            addCriterion("vendor_address not between", value1, value2, "vendorAddress");
            return (Criteria) this;
        }

        public Criteria andIsShowYourPriceIsNull() {
            addCriterion("is_show_your_price is null");
            return (Criteria) this;
        }

        public Criteria andIsShowYourPriceIsNotNull() {
            addCriterion("is_show_your_price is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowYourPriceEqualTo(Byte value) {
            addCriterion("is_show_your_price =", value, "isShowYourPrice");
            return (Criteria) this;
        }

        public Criteria andIsShowYourPriceNotEqualTo(Byte value) {
            addCriterion("is_show_your_price <>", value, "isShowYourPrice");
            return (Criteria) this;
        }

        public Criteria andIsShowYourPriceGreaterThan(Byte value) {
            addCriterion("is_show_your_price >", value, "isShowYourPrice");
            return (Criteria) this;
        }

        public Criteria andIsShowYourPriceGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_show_your_price >=", value, "isShowYourPrice");
            return (Criteria) this;
        }

        public Criteria andIsShowYourPriceLessThan(Byte value) {
            addCriterion("is_show_your_price <", value, "isShowYourPrice");
            return (Criteria) this;
        }

        public Criteria andIsShowYourPriceLessThanOrEqualTo(Byte value) {
            addCriterion("is_show_your_price <=", value, "isShowYourPrice");
            return (Criteria) this;
        }

        public Criteria andIsShowYourPriceIn(List<Byte> values) {
            addCriterion("is_show_your_price in", values, "isShowYourPrice");
            return (Criteria) this;
        }

        public Criteria andIsShowYourPriceNotIn(List<Byte> values) {
            addCriterion("is_show_your_price not in", values, "isShowYourPrice");
            return (Criteria) this;
        }

        public Criteria andIsShowYourPriceBetween(Byte value1, Byte value2) {
            addCriterion("is_show_your_price between", value1, value2, "isShowYourPrice");
            return (Criteria) this;
        }

        public Criteria andIsShowYourPriceNotBetween(Byte value1, Byte value2) {
            addCriterion("is_show_your_price not between", value1, value2, "isShowYourPrice");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsVendorIsNull() {
            addCriterion("is_sync_as_vendor is null");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsVendorIsNotNull() {
            addCriterion("is_sync_as_vendor is not null");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsVendorEqualTo(Byte value) {
            addCriterion("is_sync_as_vendor =", value, "isSyncAsVendor");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsVendorNotEqualTo(Byte value) {
            addCriterion("is_sync_as_vendor <>", value, "isSyncAsVendor");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsVendorGreaterThan(Byte value) {
            addCriterion("is_sync_as_vendor >", value, "isSyncAsVendor");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsVendorGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_sync_as_vendor >=", value, "isSyncAsVendor");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsVendorLessThan(Byte value) {
            addCriterion("is_sync_as_vendor <", value, "isSyncAsVendor");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsVendorLessThanOrEqualTo(Byte value) {
            addCriterion("is_sync_as_vendor <=", value, "isSyncAsVendor");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsVendorIn(List<Byte> values) {
            addCriterion("is_sync_as_vendor in", values, "isSyncAsVendor");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsVendorNotIn(List<Byte> values) {
            addCriterion("is_sync_as_vendor not in", values, "isSyncAsVendor");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsVendorBetween(Byte value1, Byte value2) {
            addCriterion("is_sync_as_vendor between", value1, value2, "isSyncAsVendor");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsVendorNotBetween(Byte value1, Byte value2) {
            addCriterion("is_sync_as_vendor not between", value1, value2, "isSyncAsVendor");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsDriverIsNull() {
            addCriterion("is_sync_as_driver is null");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsDriverIsNotNull() {
            addCriterion("is_sync_as_driver is not null");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsDriverEqualTo(Byte value) {
            addCriterion("is_sync_as_driver =", value, "isSyncAsDriver");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsDriverNotEqualTo(Byte value) {
            addCriterion("is_sync_as_driver <>", value, "isSyncAsDriver");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsDriverGreaterThan(Byte value) {
            addCriterion("is_sync_as_driver >", value, "isSyncAsDriver");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsDriverGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_sync_as_driver >=", value, "isSyncAsDriver");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsDriverLessThan(Byte value) {
            addCriterion("is_sync_as_driver <", value, "isSyncAsDriver");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsDriverLessThanOrEqualTo(Byte value) {
            addCriterion("is_sync_as_driver <=", value, "isSyncAsDriver");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsDriverIn(List<Byte> values) {
            addCriterion("is_sync_as_driver in", values, "isSyncAsDriver");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsDriverNotIn(List<Byte> values) {
            addCriterion("is_sync_as_driver not in", values, "isSyncAsDriver");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsDriverBetween(Byte value1, Byte value2) {
            addCriterion("is_sync_as_driver between", value1, value2, "isSyncAsDriver");
            return (Criteria) this;
        }

        public Criteria andIsSyncAsDriverNotBetween(Byte value1, Byte value2) {
            addCriterion("is_sync_as_driver not between", value1, value2, "isSyncAsDriver");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Byte value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Byte value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Byte value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Byte value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Byte value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Byte> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Byte> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Byte value1, Byte value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Byte value1, Byte value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsOpenIsNull() {
            addCriterion("is_open is null");
            return (Criteria) this;
        }

        public Criteria andIsOpenIsNotNull() {
            addCriterion("is_open is not null");
            return (Criteria) this;
        }

        public Criteria andIsOpenEqualTo(Byte value) {
            addCriterion("is_open =", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotEqualTo(Byte value) {
            addCriterion("is_open <>", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenGreaterThan(Byte value) {
            addCriterion("is_open >", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_open >=", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenLessThan(Byte value) {
            addCriterion("is_open <", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenLessThanOrEqualTo(Byte value) {
            addCriterion("is_open <=", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenIn(List<Byte> values) {
            addCriterion("is_open in", values, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotIn(List<Byte> values) {
            addCriterion("is_open not in", values, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenBetween(Byte value1, Byte value2) {
            addCriterion("is_open between", value1, value2, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotBetween(Byte value1, Byte value2) {
            addCriterion("is_open not between", value1, value2, "isOpen");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeList(List<String> values) {
            addCriterion("remark like", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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
        private VendorExample example;

        protected Criteria(VendorExample example) {
            super();
            this.example = example;
        }

        public VendorExample example() {
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