package com.juma.vms.driver.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DriverExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int startOffSet = -1;

    protected int size = -1;

    public DriverExample() {
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

    public DriverExample orderBy(String ... orderByClauses) {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andDriverIdIsNull() {
            addCriterion("driver_id is null");
            return (Criteria) this;
        }

        public Criteria andDriverIdIsNotNull() {
            addCriterion("driver_id is not null");
            return (Criteria) this;
        }

        public Criteria andDriverIdEqualTo(Integer value) {
            addCriterion("driver_id =", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdNotEqualTo(Integer value) {
            addCriterion("driver_id <>", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdGreaterThan(Integer value) {
            addCriterion("driver_id >", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("driver_id >=", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdLessThan(Integer value) {
            addCriterion("driver_id <", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdLessThanOrEqualTo(Integer value) {
            addCriterion("driver_id <=", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdIn(List<Integer> values) {
            addCriterion("driver_id in", values, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdNotIn(List<Integer> values) {
            addCriterion("driver_id not in", values, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdBetween(Integer value1, Integer value2) {
            addCriterion("driver_id between", value1, value2, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdNotBetween(Integer value1, Integer value2) {
            addCriterion("driver_id not between", value1, value2, "driverId");
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

        public Criteria andAmsDriverIdIsNull() {
            addCriterion("ams_driver_id is null");
            return (Criteria) this;
        }

        public Criteria andAmsDriverIdIsNotNull() {
            addCriterion("ams_driver_id is not null");
            return (Criteria) this;
        }

        public Criteria andAmsDriverIdEqualTo(Integer value) {
            addCriterion("ams_driver_id =", value, "amsDriverId");
            return (Criteria) this;
        }

        public Criteria andAmsDriverIdNotEqualTo(Integer value) {
            addCriterion("ams_driver_id <>", value, "amsDriverId");
            return (Criteria) this;
        }

        public Criteria andAmsDriverIdGreaterThan(Integer value) {
            addCriterion("ams_driver_id >", value, "amsDriverId");
            return (Criteria) this;
        }

        public Criteria andAmsDriverIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ams_driver_id >=", value, "amsDriverId");
            return (Criteria) this;
        }

        public Criteria andAmsDriverIdLessThan(Integer value) {
            addCriterion("ams_driver_id <", value, "amsDriverId");
            return (Criteria) this;
        }

        public Criteria andAmsDriverIdLessThanOrEqualTo(Integer value) {
            addCriterion("ams_driver_id <=", value, "amsDriverId");
            return (Criteria) this;
        }

        public Criteria andAmsDriverIdIn(List<Integer> values) {
            addCriterion("ams_driver_id in", values, "amsDriverId");
            return (Criteria) this;
        }

        public Criteria andAmsDriverIdNotIn(List<Integer> values) {
            addCriterion("ams_driver_id not in", values, "amsDriverId");
            return (Criteria) this;
        }

        public Criteria andAmsDriverIdBetween(Integer value1, Integer value2) {
            addCriterion("ams_driver_id between", value1, value2, "amsDriverId");
            return (Criteria) this;
        }

        public Criteria andAmsDriverIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ams_driver_id not between", value1, value2, "amsDriverId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLikeList(List<String> values) {
            addCriterion("name like", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLikeList(List<String> values) {
            addCriterion("sex like", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andIconIsNull() {
            addCriterion("icon is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("icon is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("icon =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("icon <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("icon >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("icon >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("icon <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("icon <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLike(String value) {
            addCriterion("icon like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("icon not like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLikeList(List<String> values) {
            addCriterion("icon like", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(List<String> values) {
            addCriterion("icon in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<String> values) {
            addCriterion("icon not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("icon between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("icon not between", value1, value2, "icon");
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

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLikeList(List<String> values) {
            addCriterion("phone like", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
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

        public Criteria andCanDriveTypeIsNull() {
            addCriterion("can_drive_type is null");
            return (Criteria) this;
        }

        public Criteria andCanDriveTypeIsNotNull() {
            addCriterion("can_drive_type is not null");
            return (Criteria) this;
        }

        public Criteria andCanDriveTypeEqualTo(Byte value) {
            addCriterion("can_drive_type =", value, "canDriveType");
            return (Criteria) this;
        }

        public Criteria andCanDriveTypeNotEqualTo(Byte value) {
            addCriterion("can_drive_type <>", value, "canDriveType");
            return (Criteria) this;
        }

        public Criteria andCanDriveTypeGreaterThan(Byte value) {
            addCriterion("can_drive_type >", value, "canDriveType");
            return (Criteria) this;
        }

        public Criteria andCanDriveTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("can_drive_type >=", value, "canDriveType");
            return (Criteria) this;
        }

        public Criteria andCanDriveTypeLessThan(Byte value) {
            addCriterion("can_drive_type <", value, "canDriveType");
            return (Criteria) this;
        }

        public Criteria andCanDriveTypeLessThanOrEqualTo(Byte value) {
            addCriterion("can_drive_type <=", value, "canDriveType");
            return (Criteria) this;
        }

        public Criteria andCanDriveTypeIn(List<Byte> values) {
            addCriterion("can_drive_type in", values, "canDriveType");
            return (Criteria) this;
        }

        public Criteria andCanDriveTypeNotIn(List<Byte> values) {
            addCriterion("can_drive_type not in", values, "canDriveType");
            return (Criteria) this;
        }

        public Criteria andCanDriveTypeBetween(Byte value1, Byte value2) {
            addCriterion("can_drive_type between", value1, value2, "canDriveType");
            return (Criteria) this;
        }

        public Criteria andCanDriveTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("can_drive_type not between", value1, value2, "canDriveType");
            return (Criteria) this;
        }

        public Criteria andDriverRunTypeIsNull() {
            addCriterion("driver_run_type is null");
            return (Criteria) this;
        }

        public Criteria andDriverRunTypeIsNotNull() {
            addCriterion("driver_run_type is not null");
            return (Criteria) this;
        }

        public Criteria andDriverRunTypeEqualTo(Integer value) {
            addCriterion("driver_run_type =", value, "driverRunType");
            return (Criteria) this;
        }

        public Criteria andDriverRunTypeNotEqualTo(Integer value) {
            addCriterion("driver_run_type <>", value, "driverRunType");
            return (Criteria) this;
        }

        public Criteria andDriverRunTypeGreaterThan(Integer value) {
            addCriterion("driver_run_type >", value, "driverRunType");
            return (Criteria) this;
        }

        public Criteria andDriverRunTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("driver_run_type >=", value, "driverRunType");
            return (Criteria) this;
        }

        public Criteria andDriverRunTypeLessThan(Integer value) {
            addCriterion("driver_run_type <", value, "driverRunType");
            return (Criteria) this;
        }

        public Criteria andDriverRunTypeLessThanOrEqualTo(Integer value) {
            addCriterion("driver_run_type <=", value, "driverRunType");
            return (Criteria) this;
        }

        public Criteria andDriverRunTypeIn(List<Integer> values) {
            addCriterion("driver_run_type in", values, "driverRunType");
            return (Criteria) this;
        }

        public Criteria andDriverRunTypeNotIn(List<Integer> values) {
            addCriterion("driver_run_type not in", values, "driverRunType");
            return (Criteria) this;
        }

        public Criteria andDriverRunTypeBetween(Integer value1, Integer value2) {
            addCriterion("driver_run_type between", value1, value2, "driverRunType");
            return (Criteria) this;
        }

        public Criteria andDriverRunTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("driver_run_type not between", value1, value2, "driverRunType");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg1IsNull() {
            addCriterion("drive_license_img_1 is null");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg1IsNotNull() {
            addCriterion("drive_license_img_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg1EqualTo(String value) {
            addCriterion("drive_license_img_1 =", value, "driveLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg1NotEqualTo(String value) {
            addCriterion("drive_license_img_1 <>", value, "driveLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg1GreaterThan(String value) {
            addCriterion("drive_license_img_1 >", value, "driveLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg1GreaterThanOrEqualTo(String value) {
            addCriterion("drive_license_img_1 >=", value, "driveLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg1LessThan(String value) {
            addCriterion("drive_license_img_1 <", value, "driveLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg1LessThanOrEqualTo(String value) {
            addCriterion("drive_license_img_1 <=", value, "driveLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg1Like(String value) {
            addCriterion("drive_license_img_1 like", value, "driveLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg1NotLike(String value) {
            addCriterion("drive_license_img_1 not like", value, "driveLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg1LikeList(List<String> values) {
            addCriterion("drive_license_img_1 like", values, "driveLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg1In(List<String> values) {
            addCriterion("drive_license_img_1 in", values, "driveLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg1NotIn(List<String> values) {
            addCriterion("drive_license_img_1 not in", values, "driveLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg1Between(String value1, String value2) {
            addCriterion("drive_license_img_1 between", value1, value2, "driveLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg1NotBetween(String value1, String value2) {
            addCriterion("drive_license_img_1 not between", value1, value2, "driveLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg2IsNull() {
            addCriterion("drive_license_img_2 is null");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg2IsNotNull() {
            addCriterion("drive_license_img_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg2EqualTo(String value) {
            addCriterion("drive_license_img_2 =", value, "driveLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg2NotEqualTo(String value) {
            addCriterion("drive_license_img_2 <>", value, "driveLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg2GreaterThan(String value) {
            addCriterion("drive_license_img_2 >", value, "driveLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg2GreaterThanOrEqualTo(String value) {
            addCriterion("drive_license_img_2 >=", value, "driveLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg2LessThan(String value) {
            addCriterion("drive_license_img_2 <", value, "driveLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg2LessThanOrEqualTo(String value) {
            addCriterion("drive_license_img_2 <=", value, "driveLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg2Like(String value) {
            addCriterion("drive_license_img_2 like", value, "driveLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg2NotLike(String value) {
            addCriterion("drive_license_img_2 not like", value, "driveLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg2LikeList(List<String> values) {
            addCriterion("drive_license_img_2 like", values, "driveLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg2In(List<String> values) {
            addCriterion("drive_license_img_2 in", values, "driveLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg2NotIn(List<String> values) {
            addCriterion("drive_license_img_2 not in", values, "driveLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg2Between(String value1, String value2) {
            addCriterion("drive_license_img_2 between", value1, value2, "driveLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseImg2NotBetween(String value1, String value2) {
            addCriterion("drive_license_img_2 not between", value1, value2, "driveLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseFirstTakeTimeIsNull() {
            addCriterion("drive_license_first_take_time is null");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseFirstTakeTimeIsNotNull() {
            addCriterion("drive_license_first_take_time is not null");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseFirstTakeTimeEqualTo(Date value) {
            addCriterionForJDBCDate("drive_license_first_take_time =", value, "driveLicenseFirstTakeTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseFirstTakeTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("drive_license_first_take_time <>", value, "driveLicenseFirstTakeTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseFirstTakeTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("drive_license_first_take_time >", value, "driveLicenseFirstTakeTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseFirstTakeTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("drive_license_first_take_time >=", value, "driveLicenseFirstTakeTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseFirstTakeTimeLessThan(Date value) {
            addCriterionForJDBCDate("drive_license_first_take_time <", value, "driveLicenseFirstTakeTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseFirstTakeTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("drive_license_first_take_time <=", value, "driveLicenseFirstTakeTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseFirstTakeTimeIn(List<Date> values) {
            addCriterionForJDBCDate("drive_license_first_take_time in", values, "driveLicenseFirstTakeTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseFirstTakeTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("drive_license_first_take_time not in", values, "driveLicenseFirstTakeTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseFirstTakeTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("drive_license_first_take_time between", value1, value2, "driveLicenseFirstTakeTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseFirstTakeTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("drive_license_first_take_time not between", value1, value2, "driveLicenseFirstTakeTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseStartTimeIsNull() {
            addCriterion("drive_license_start_time is null");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseStartTimeIsNotNull() {
            addCriterion("drive_license_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseStartTimeEqualTo(Date value) {
            addCriterion("drive_license_start_time =", value, "driveLicenseStartTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseStartTimeNotEqualTo(Date value) {
            addCriterion("drive_license_start_time <>", value, "driveLicenseStartTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseStartTimeGreaterThan(Date value) {
            addCriterion("drive_license_start_time >", value, "driveLicenseStartTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("drive_license_start_time >=", value, "driveLicenseStartTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseStartTimeLessThan(Date value) {
            addCriterion("drive_license_start_time <", value, "driveLicenseStartTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("drive_license_start_time <=", value, "driveLicenseStartTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseStartTimeIn(List<Date> values) {
            addCriterion("drive_license_start_time in", values, "driveLicenseStartTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseStartTimeNotIn(List<Date> values) {
            addCriterion("drive_license_start_time not in", values, "driveLicenseStartTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseStartTimeBetween(Date value1, Date value2) {
            addCriterion("drive_license_start_time between", value1, value2, "driveLicenseStartTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("drive_license_start_time not between", value1, value2, "driveLicenseStartTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseEndTimeIsNull() {
            addCriterion("drive_license_end_time is null");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseEndTimeIsNotNull() {
            addCriterion("drive_license_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseEndTimeEqualTo(Date value) {
            addCriterion("drive_license_end_time =", value, "driveLicenseEndTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseEndTimeNotEqualTo(Date value) {
            addCriterion("drive_license_end_time <>", value, "driveLicenseEndTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseEndTimeGreaterThan(Date value) {
            addCriterion("drive_license_end_time >", value, "driveLicenseEndTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("drive_license_end_time >=", value, "driveLicenseEndTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseEndTimeLessThan(Date value) {
            addCriterion("drive_license_end_time <", value, "driveLicenseEndTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("drive_license_end_time <=", value, "driveLicenseEndTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseEndTimeIn(List<Date> values) {
            addCriterion("drive_license_end_time in", values, "driveLicenseEndTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseEndTimeNotIn(List<Date> values) {
            addCriterion("drive_license_end_time not in", values, "driveLicenseEndTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseEndTimeBetween(Date value1, Date value2) {
            addCriterion("drive_license_end_time between", value1, value2, "driveLicenseEndTime");
            return (Criteria) this;
        }

        public Criteria andDriveLicenseEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("drive_license_end_time not between", value1, value2, "driveLicenseEndTime");
            return (Criteria) this;
        }

        public Criteria andTelRemindSwitchIsNull() {
            addCriterion("tel_remind_switch is null");
            return (Criteria) this;
        }

        public Criteria andTelRemindSwitchIsNotNull() {
            addCriterion("tel_remind_switch is not null");
            return (Criteria) this;
        }

        public Criteria andTelRemindSwitchEqualTo(Boolean value) {
            addCriterion("tel_remind_switch =", value, "telRemindSwitch");
            return (Criteria) this;
        }

        public Criteria andTelRemindSwitchNotEqualTo(Boolean value) {
            addCriterion("tel_remind_switch <>", value, "telRemindSwitch");
            return (Criteria) this;
        }

        public Criteria andTelRemindSwitchGreaterThan(Boolean value) {
            addCriterion("tel_remind_switch >", value, "telRemindSwitch");
            return (Criteria) this;
        }

        public Criteria andTelRemindSwitchGreaterThanOrEqualTo(Boolean value) {
            addCriterion("tel_remind_switch >=", value, "telRemindSwitch");
            return (Criteria) this;
        }

        public Criteria andTelRemindSwitchLessThan(Boolean value) {
            addCriterion("tel_remind_switch <", value, "telRemindSwitch");
            return (Criteria) this;
        }

        public Criteria andTelRemindSwitchLessThanOrEqualTo(Boolean value) {
            addCriterion("tel_remind_switch <=", value, "telRemindSwitch");
            return (Criteria) this;
        }

        public Criteria andTelRemindSwitchIn(List<Boolean> values) {
            addCriterion("tel_remind_switch in", values, "telRemindSwitch");
            return (Criteria) this;
        }

        public Criteria andTelRemindSwitchNotIn(List<Boolean> values) {
            addCriterion("tel_remind_switch not in", values, "telRemindSwitch");
            return (Criteria) this;
        }

        public Criteria andTelRemindSwitchBetween(Boolean value1, Boolean value2) {
            addCriterion("tel_remind_switch between", value1, value2, "telRemindSwitch");
            return (Criteria) this;
        }

        public Criteria andTelRemindSwitchNotBetween(Boolean value1, Boolean value2) {
            addCriterion("tel_remind_switch not between", value1, value2, "telRemindSwitch");
            return (Criteria) this;
        }

        public Criteria andSmsRemindSwitchIsNull() {
            addCriterion("sms_remind_switch is null");
            return (Criteria) this;
        }

        public Criteria andSmsRemindSwitchIsNotNull() {
            addCriterion("sms_remind_switch is not null");
            return (Criteria) this;
        }

        public Criteria andSmsRemindSwitchEqualTo(Boolean value) {
            addCriterion("sms_remind_switch =", value, "smsRemindSwitch");
            return (Criteria) this;
        }

        public Criteria andSmsRemindSwitchNotEqualTo(Boolean value) {
            addCriterion("sms_remind_switch <>", value, "smsRemindSwitch");
            return (Criteria) this;
        }

        public Criteria andSmsRemindSwitchGreaterThan(Boolean value) {
            addCriterion("sms_remind_switch >", value, "smsRemindSwitch");
            return (Criteria) this;
        }

        public Criteria andSmsRemindSwitchGreaterThanOrEqualTo(Boolean value) {
            addCriterion("sms_remind_switch >=", value, "smsRemindSwitch");
            return (Criteria) this;
        }

        public Criteria andSmsRemindSwitchLessThan(Boolean value) {
            addCriterion("sms_remind_switch <", value, "smsRemindSwitch");
            return (Criteria) this;
        }

        public Criteria andSmsRemindSwitchLessThanOrEqualTo(Boolean value) {
            addCriterion("sms_remind_switch <=", value, "smsRemindSwitch");
            return (Criteria) this;
        }

        public Criteria andSmsRemindSwitchIn(List<Boolean> values) {
            addCriterion("sms_remind_switch in", values, "smsRemindSwitch");
            return (Criteria) this;
        }

        public Criteria andSmsRemindSwitchNotIn(List<Boolean> values) {
            addCriterion("sms_remind_switch not in", values, "smsRemindSwitch");
            return (Criteria) this;
        }

        public Criteria andSmsRemindSwitchBetween(Boolean value1, Boolean value2) {
            addCriterion("sms_remind_switch between", value1, value2, "smsRemindSwitch");
            return (Criteria) this;
        }

        public Criteria andSmsRemindSwitchNotBetween(Boolean value1, Boolean value2) {
            addCriterion("sms_remind_switch not between", value1, value2, "smsRemindSwitch");
            return (Criteria) this;
        }

        public Criteria andIsReceiveWaybillIsNull() {
            addCriterion("is_receive_waybill is null");
            return (Criteria) this;
        }

        public Criteria andIsReceiveWaybillIsNotNull() {
            addCriterion("is_receive_waybill is not null");
            return (Criteria) this;
        }

        public Criteria andIsReceiveWaybillEqualTo(Boolean value) {
            addCriterion("is_receive_waybill =", value, "isReceiveWaybill");
            return (Criteria) this;
        }

        public Criteria andIsReceiveWaybillNotEqualTo(Boolean value) {
            addCriterion("is_receive_waybill <>", value, "isReceiveWaybill");
            return (Criteria) this;
        }

        public Criteria andIsReceiveWaybillGreaterThan(Boolean value) {
            addCriterion("is_receive_waybill >", value, "isReceiveWaybill");
            return (Criteria) this;
        }

        public Criteria andIsReceiveWaybillGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_receive_waybill >=", value, "isReceiveWaybill");
            return (Criteria) this;
        }

        public Criteria andIsReceiveWaybillLessThan(Boolean value) {
            addCriterion("is_receive_waybill <", value, "isReceiveWaybill");
            return (Criteria) this;
        }

        public Criteria andIsReceiveWaybillLessThanOrEqualTo(Boolean value) {
            addCriterion("is_receive_waybill <=", value, "isReceiveWaybill");
            return (Criteria) this;
        }

        public Criteria andIsReceiveWaybillIn(List<Boolean> values) {
            addCriterion("is_receive_waybill in", values, "isReceiveWaybill");
            return (Criteria) this;
        }

        public Criteria andIsReceiveWaybillNotIn(List<Boolean> values) {
            addCriterion("is_receive_waybill not in", values, "isReceiveWaybill");
            return (Criteria) this;
        }

        public Criteria andIsReceiveWaybillBetween(Boolean value1, Boolean value2) {
            addCriterion("is_receive_waybill between", value1, value2, "isReceiveWaybill");
            return (Criteria) this;
        }

        public Criteria andIsReceiveWaybillNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_receive_waybill not between", value1, value2, "isReceiveWaybill");
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
        private DriverExample example;

        protected Criteria(DriverExample example) {
            super();
            this.example = example;
        }

        public DriverExample example() {
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