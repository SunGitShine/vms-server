package com.juma.vms.truck.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TruckExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int startOffSet = -1;

    protected int size = -1;

    public TruckExample() {
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

    public TruckExample orderBy(String ... orderByClauses) {
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

        public Criteria andLicenseTypeIsNull() {
            addCriterion("license_type is null");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeIsNotNull() {
            addCriterion("license_type is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeEqualTo(Integer value) {
            addCriterion("license_type =", value, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeNotEqualTo(Integer value) {
            addCriterion("license_type <>", value, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeGreaterThan(Integer value) {
            addCriterion("license_type >", value, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("license_type >=", value, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeLessThan(Integer value) {
            addCriterion("license_type <", value, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeLessThanOrEqualTo(Integer value) {
            addCriterion("license_type <=", value, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeIn(List<Integer> values) {
            addCriterion("license_type in", values, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeNotIn(List<Integer> values) {
            addCriterion("license_type not in", values, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeBetween(Integer value1, Integer value2) {
            addCriterion("license_type between", value1, value2, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("license_type not between", value1, value2, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg1IsNull() {
            addCriterion("license_certificate_img_1 is null");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg1IsNotNull() {
            addCriterion("license_certificate_img_1 is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg1EqualTo(String value) {
            addCriterion("license_certificate_img_1 =", value, "licenseCertificateImg1");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg1NotEqualTo(String value) {
            addCriterion("license_certificate_img_1 <>", value, "licenseCertificateImg1");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg1GreaterThan(String value) {
            addCriterion("license_certificate_img_1 >", value, "licenseCertificateImg1");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg1GreaterThanOrEqualTo(String value) {
            addCriterion("license_certificate_img_1 >=", value, "licenseCertificateImg1");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg1LessThan(String value) {
            addCriterion("license_certificate_img_1 <", value, "licenseCertificateImg1");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg1LessThanOrEqualTo(String value) {
            addCriterion("license_certificate_img_1 <=", value, "licenseCertificateImg1");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg1Like(String value) {
            addCriterion("license_certificate_img_1 like", value, "licenseCertificateImg1");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg1NotLike(String value) {
            addCriterion("license_certificate_img_1 not like", value, "licenseCertificateImg1");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg1LikeList(List<String> values) {
            addCriterion("license_certificate_img_1 like", values, "licenseCertificateImg1");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg1In(List<String> values) {
            addCriterion("license_certificate_img_1 in", values, "licenseCertificateImg1");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg1NotIn(List<String> values) {
            addCriterion("license_certificate_img_1 not in", values, "licenseCertificateImg1");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg1Between(String value1, String value2) {
            addCriterion("license_certificate_img_1 between", value1, value2, "licenseCertificateImg1");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg1NotBetween(String value1, String value2) {
            addCriterion("license_certificate_img_1 not between", value1, value2, "licenseCertificateImg1");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg2IsNull() {
            addCriterion("license_certificate_img_2 is null");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg2IsNotNull() {
            addCriterion("license_certificate_img_2 is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg2EqualTo(String value) {
            addCriterion("license_certificate_img_2 =", value, "licenseCertificateImg2");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg2NotEqualTo(String value) {
            addCriterion("license_certificate_img_2 <>", value, "licenseCertificateImg2");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg2GreaterThan(String value) {
            addCriterion("license_certificate_img_2 >", value, "licenseCertificateImg2");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg2GreaterThanOrEqualTo(String value) {
            addCriterion("license_certificate_img_2 >=", value, "licenseCertificateImg2");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg2LessThan(String value) {
            addCriterion("license_certificate_img_2 <", value, "licenseCertificateImg2");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg2LessThanOrEqualTo(String value) {
            addCriterion("license_certificate_img_2 <=", value, "licenseCertificateImg2");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg2Like(String value) {
            addCriterion("license_certificate_img_2 like", value, "licenseCertificateImg2");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg2NotLike(String value) {
            addCriterion("license_certificate_img_2 not like", value, "licenseCertificateImg2");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg2LikeList(List<String> values) {
            addCriterion("license_certificate_img_2 like", values, "licenseCertificateImg2");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg2In(List<String> values) {
            addCriterion("license_certificate_img_2 in", values, "licenseCertificateImg2");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg2NotIn(List<String> values) {
            addCriterion("license_certificate_img_2 not in", values, "licenseCertificateImg2");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg2Between(String value1, String value2) {
            addCriterion("license_certificate_img_2 between", value1, value2, "licenseCertificateImg2");
            return (Criteria) this;
        }

        public Criteria andLicenseCertificateImg2NotBetween(String value1, String value2) {
            addCriterion("license_certificate_img_2 not between", value1, value2, "licenseCertificateImg2");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg1IsNull() {
            addCriterion("permit_license_img_1 is null");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg1IsNotNull() {
            addCriterion("permit_license_img_1 is not null");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg1EqualTo(String value) {
            addCriterion("permit_license_img_1 =", value, "permitLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg1NotEqualTo(String value) {
            addCriterion("permit_license_img_1 <>", value, "permitLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg1GreaterThan(String value) {
            addCriterion("permit_license_img_1 >", value, "permitLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg1GreaterThanOrEqualTo(String value) {
            addCriterion("permit_license_img_1 >=", value, "permitLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg1LessThan(String value) {
            addCriterion("permit_license_img_1 <", value, "permitLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg1LessThanOrEqualTo(String value) {
            addCriterion("permit_license_img_1 <=", value, "permitLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg1Like(String value) {
            addCriterion("permit_license_img_1 like", value, "permitLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg1NotLike(String value) {
            addCriterion("permit_license_img_1 not like", value, "permitLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg1LikeList(List<String> values) {
            addCriterion("permit_license_img_1 like", values, "permitLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg1In(List<String> values) {
            addCriterion("permit_license_img_1 in", values, "permitLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg1NotIn(List<String> values) {
            addCriterion("permit_license_img_1 not in", values, "permitLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg1Between(String value1, String value2) {
            addCriterion("permit_license_img_1 between", value1, value2, "permitLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg1NotBetween(String value1, String value2) {
            addCriterion("permit_license_img_1 not between", value1, value2, "permitLicenseImg1");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg2IsNull() {
            addCriterion("permit_license_img_2 is null");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg2IsNotNull() {
            addCriterion("permit_license_img_2 is not null");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg2EqualTo(String value) {
            addCriterion("permit_license_img_2 =", value, "permitLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg2NotEqualTo(String value) {
            addCriterion("permit_license_img_2 <>", value, "permitLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg2GreaterThan(String value) {
            addCriterion("permit_license_img_2 >", value, "permitLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg2GreaterThanOrEqualTo(String value) {
            addCriterion("permit_license_img_2 >=", value, "permitLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg2LessThan(String value) {
            addCriterion("permit_license_img_2 <", value, "permitLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg2LessThanOrEqualTo(String value) {
            addCriterion("permit_license_img_2 <=", value, "permitLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg2Like(String value) {
            addCriterion("permit_license_img_2 like", value, "permitLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg2NotLike(String value) {
            addCriterion("permit_license_img_2 not like", value, "permitLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg2LikeList(List<String> values) {
            addCriterion("permit_license_img_2 like", values, "permitLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg2In(List<String> values) {
            addCriterion("permit_license_img_2 in", values, "permitLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg2NotIn(List<String> values) {
            addCriterion("permit_license_img_2 not in", values, "permitLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg2Between(String value1, String value2) {
            addCriterion("permit_license_img_2 between", value1, value2, "permitLicenseImg2");
            return (Criteria) this;
        }

        public Criteria andPermitLicenseImg2NotBetween(String value1, String value2) {
            addCriterion("permit_license_img_2 not between", value1, value2, "permitLicenseImg2");
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

        public Criteria andEnergyTypeIsNull() {
            addCriterion("energy_type is null");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeIsNotNull() {
            addCriterion("energy_type is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeEqualTo(Integer value) {
            addCriterion("energy_type =", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeNotEqualTo(Integer value) {
            addCriterion("energy_type <>", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeGreaterThan(Integer value) {
            addCriterion("energy_type >", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("energy_type >=", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeLessThan(Integer value) {
            addCriterion("energy_type <", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeLessThanOrEqualTo(Integer value) {
            addCriterion("energy_type <=", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeIn(List<Integer> values) {
            addCriterion("energy_type in", values, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeNotIn(List<Integer> values) {
            addCriterion("energy_type not in", values, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeBetween(Integer value1, Integer value2) {
            addCriterion("energy_type between", value1, value2, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("energy_type not between", value1, value2, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyOutTypeIsNull() {
            addCriterion("energy_out_type is null");
            return (Criteria) this;
        }

        public Criteria andEnergyOutTypeIsNotNull() {
            addCriterion("energy_out_type is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyOutTypeEqualTo(Integer value) {
            addCriterion("energy_out_type =", value, "energyOutType");
            return (Criteria) this;
        }

        public Criteria andEnergyOutTypeNotEqualTo(Integer value) {
            addCriterion("energy_out_type <>", value, "energyOutType");
            return (Criteria) this;
        }

        public Criteria andEnergyOutTypeGreaterThan(Integer value) {
            addCriterion("energy_out_type >", value, "energyOutType");
            return (Criteria) this;
        }

        public Criteria andEnergyOutTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("energy_out_type >=", value, "energyOutType");
            return (Criteria) this;
        }

        public Criteria andEnergyOutTypeLessThan(Integer value) {
            addCriterion("energy_out_type <", value, "energyOutType");
            return (Criteria) this;
        }

        public Criteria andEnergyOutTypeLessThanOrEqualTo(Integer value) {
            addCriterion("energy_out_type <=", value, "energyOutType");
            return (Criteria) this;
        }

        public Criteria andEnergyOutTypeIn(List<Integer> values) {
            addCriterion("energy_out_type in", values, "energyOutType");
            return (Criteria) this;
        }

        public Criteria andEnergyOutTypeNotIn(List<Integer> values) {
            addCriterion("energy_out_type not in", values, "energyOutType");
            return (Criteria) this;
        }

        public Criteria andEnergyOutTypeBetween(Integer value1, Integer value2) {
            addCriterion("energy_out_type between", value1, value2, "energyOutType");
            return (Criteria) this;
        }

        public Criteria andEnergyOutTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("energy_out_type not between", value1, value2, "energyOutType");
            return (Criteria) this;
        }

        public Criteria andGoCityLicenseTypeIsNull() {
            addCriterion("go_city_license_type is null");
            return (Criteria) this;
        }

        public Criteria andGoCityLicenseTypeIsNotNull() {
            addCriterion("go_city_license_type is not null");
            return (Criteria) this;
        }

        public Criteria andGoCityLicenseTypeEqualTo(Integer value) {
            addCriterion("go_city_license_type =", value, "goCityLicenseType");
            return (Criteria) this;
        }

        public Criteria andGoCityLicenseTypeNotEqualTo(Integer value) {
            addCriterion("go_city_license_type <>", value, "goCityLicenseType");
            return (Criteria) this;
        }

        public Criteria andGoCityLicenseTypeGreaterThan(Integer value) {
            addCriterion("go_city_license_type >", value, "goCityLicenseType");
            return (Criteria) this;
        }

        public Criteria andGoCityLicenseTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("go_city_license_type >=", value, "goCityLicenseType");
            return (Criteria) this;
        }

        public Criteria andGoCityLicenseTypeLessThan(Integer value) {
            addCriterion("go_city_license_type <", value, "goCityLicenseType");
            return (Criteria) this;
        }

        public Criteria andGoCityLicenseTypeLessThanOrEqualTo(Integer value) {
            addCriterion("go_city_license_type <=", value, "goCityLicenseType");
            return (Criteria) this;
        }

        public Criteria andGoCityLicenseTypeIn(List<Integer> values) {
            addCriterion("go_city_license_type in", values, "goCityLicenseType");
            return (Criteria) this;
        }

        public Criteria andGoCityLicenseTypeNotIn(List<Integer> values) {
            addCriterion("go_city_license_type not in", values, "goCityLicenseType");
            return (Criteria) this;
        }

        public Criteria andGoCityLicenseTypeBetween(Integer value1, Integer value2) {
            addCriterion("go_city_license_type between", value1, value2, "goCityLicenseType");
            return (Criteria) this;
        }

        public Criteria andGoCityLicenseTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("go_city_license_type not between", value1, value2, "goCityLicenseType");
            return (Criteria) this;
        }

        public Criteria andTruckBodyImgIsNull() {
            addCriterion("truck_body_img is null");
            return (Criteria) this;
        }

        public Criteria andTruckBodyImgIsNotNull() {
            addCriterion("truck_body_img is not null");
            return (Criteria) this;
        }

        public Criteria andTruckBodyImgEqualTo(String value) {
            addCriterion("truck_body_img =", value, "truckBodyImg");
            return (Criteria) this;
        }

        public Criteria andTruckBodyImgNotEqualTo(String value) {
            addCriterion("truck_body_img <>", value, "truckBodyImg");
            return (Criteria) this;
        }

        public Criteria andTruckBodyImgGreaterThan(String value) {
            addCriterion("truck_body_img >", value, "truckBodyImg");
            return (Criteria) this;
        }

        public Criteria andTruckBodyImgGreaterThanOrEqualTo(String value) {
            addCriterion("truck_body_img >=", value, "truckBodyImg");
            return (Criteria) this;
        }

        public Criteria andTruckBodyImgLessThan(String value) {
            addCriterion("truck_body_img <", value, "truckBodyImg");
            return (Criteria) this;
        }

        public Criteria andTruckBodyImgLessThanOrEqualTo(String value) {
            addCriterion("truck_body_img <=", value, "truckBodyImg");
            return (Criteria) this;
        }

        public Criteria andTruckBodyImgLike(String value) {
            addCriterion("truck_body_img like", value, "truckBodyImg");
            return (Criteria) this;
        }

        public Criteria andTruckBodyImgNotLike(String value) {
            addCriterion("truck_body_img not like", value, "truckBodyImg");
            return (Criteria) this;
        }

        public Criteria andTruckBodyImgLikeList(List<String> values) {
            addCriterion("truck_body_img like", values, "truckBodyImg");
            return (Criteria) this;
        }

        public Criteria andTruckBodyImgIn(List<String> values) {
            addCriterion("truck_body_img in", values, "truckBodyImg");
            return (Criteria) this;
        }

        public Criteria andTruckBodyImgNotIn(List<String> values) {
            addCriterion("truck_body_img not in", values, "truckBodyImg");
            return (Criteria) this;
        }

        public Criteria andTruckBodyImgBetween(String value1, String value2) {
            addCriterion("truck_body_img between", value1, value2, "truckBodyImg");
            return (Criteria) this;
        }

        public Criteria andTruckBodyImgNotBetween(String value1, String value2) {
            addCriterion("truck_body_img not between", value1, value2, "truckBodyImg");
            return (Criteria) this;
        }

        public Criteria andIsTailBoardIsNull() {
            addCriterion("is_tail_board is null");
            return (Criteria) this;
        }

        public Criteria andIsTailBoardIsNotNull() {
            addCriterion("is_tail_board is not null");
            return (Criteria) this;
        }

        public Criteria andIsTailBoardEqualTo(Boolean value) {
            addCriterion("is_tail_board =", value, "isTailBoard");
            return (Criteria) this;
        }

        public Criteria andIsTailBoardNotEqualTo(Boolean value) {
            addCriterion("is_tail_board <>", value, "isTailBoard");
            return (Criteria) this;
        }

        public Criteria andIsTailBoardGreaterThan(Boolean value) {
            addCriterion("is_tail_board >", value, "isTailBoard");
            return (Criteria) this;
        }

        public Criteria andIsTailBoardGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_tail_board >=", value, "isTailBoard");
            return (Criteria) this;
        }

        public Criteria andIsTailBoardLessThan(Boolean value) {
            addCriterion("is_tail_board <", value, "isTailBoard");
            return (Criteria) this;
        }

        public Criteria andIsTailBoardLessThanOrEqualTo(Boolean value) {
            addCriterion("is_tail_board <=", value, "isTailBoard");
            return (Criteria) this;
        }

        public Criteria andIsTailBoardIn(List<Boolean> values) {
            addCriterion("is_tail_board in", values, "isTailBoard");
            return (Criteria) this;
        }

        public Criteria andIsTailBoardNotIn(List<Boolean> values) {
            addCriterion("is_tail_board not in", values, "isTailBoard");
            return (Criteria) this;
        }

        public Criteria andIsTailBoardBetween(Boolean value1, Boolean value2) {
            addCriterion("is_tail_board between", value1, value2, "isTailBoard");
            return (Criteria) this;
        }

        public Criteria andIsTailBoardNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_tail_board not between", value1, value2, "isTailBoard");
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
        private TruckExample example;

        protected Criteria(TruckExample example) {
            super();
            this.example = example;
        }

        public TruckExample example() {
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