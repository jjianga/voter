package org.jjianga.voter.entity;

import java.util.ArrayList;
import java.util.List;

public class DeviceInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
	* 
	* @return null
	*/
    public DeviceInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
	* 
	* @param orderByClause
	* @return null
	*/
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
	* 
	* @return java.lang.String
	*/
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
	* 
	* @param distinct
	* @return null
	*/
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
	* 
	* @return boolean
	*/
    public boolean isDistinct() {
        return distinct;
    }

    /**
	* 
	* @return java.util.List<Criteria>
	*/
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
	* 
	* @param criteria
	* @return null
	*/
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
	* 
	* @return Criteria
	*/
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
	* 
	* @return Criteria
	*/
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
	* 
	* @return Criteria
	*/
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
	* 
	* @return null
	*/
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRondaIsNull() {
            addCriterion("ronda is null");
            return (Criteria) this;
        }

        public Criteria andRondaIsNotNull() {
            addCriterion("ronda is not null");
            return (Criteria) this;
        }

        public Criteria andRondaEqualTo(String value) {
            addCriterion("ronda =", value, "ronda");
            return (Criteria) this;
        }

        public Criteria andRondaNotEqualTo(String value) {
            addCriterion("ronda <>", value, "ronda");
            return (Criteria) this;
        }

        public Criteria andRondaGreaterThan(String value) {
            addCriterion("ronda >", value, "ronda");
            return (Criteria) this;
        }

        public Criteria andRondaGreaterThanOrEqualTo(String value) {
            addCriterion("ronda >=", value, "ronda");
            return (Criteria) this;
        }

        public Criteria andRondaLessThan(String value) {
            addCriterion("ronda <", value, "ronda");
            return (Criteria) this;
        }

        public Criteria andRondaLessThanOrEqualTo(String value) {
            addCriterion("ronda <=", value, "ronda");
            return (Criteria) this;
        }

        public Criteria andRondaLike(String value) {
            addCriterion("ronda like", value, "ronda");
            return (Criteria) this;
        }

        public Criteria andRondaNotLike(String value) {
            addCriterion("ronda not like", value, "ronda");
            return (Criteria) this;
        }

        public Criteria andRondaIn(List<String> values) {
            addCriterion("ronda in", values, "ronda");
            return (Criteria) this;
        }

        public Criteria andRondaNotIn(List<String> values) {
            addCriterion("ronda not in", values, "ronda");
            return (Criteria) this;
        }

        public Criteria andRondaBetween(String value1, String value2) {
            addCriterion("ronda between", value1, value2, "ronda");
            return (Criteria) this;
        }

        public Criteria andRondaNotBetween(String value1, String value2) {
            addCriterion("ronda not between", value1, value2, "ronda");
            return (Criteria) this;
        }

        public Criteria andGroupDeviceIsNull() {
            addCriterion("group_device is null");
            return (Criteria) this;
        }

        public Criteria andGroupDeviceIsNotNull() {
            addCriterion("group_device is not null");
            return (Criteria) this;
        }

        public Criteria andGroupDeviceEqualTo(String value) {
            addCriterion("group_device =", value, "groupDevice");
            return (Criteria) this;
        }

        public Criteria andGroupDeviceNotEqualTo(String value) {
            addCriterion("group_device <>", value, "groupDevice");
            return (Criteria) this;
        }

        public Criteria andGroupDeviceGreaterThan(String value) {
            addCriterion("group_device >", value, "groupDevice");
            return (Criteria) this;
        }

        public Criteria andGroupDeviceGreaterThanOrEqualTo(String value) {
            addCriterion("group_device >=", value, "groupDevice");
            return (Criteria) this;
        }

        public Criteria andGroupDeviceLessThan(String value) {
            addCriterion("group_device <", value, "groupDevice");
            return (Criteria) this;
        }

        public Criteria andGroupDeviceLessThanOrEqualTo(String value) {
            addCriterion("group_device <=", value, "groupDevice");
            return (Criteria) this;
        }

        public Criteria andGroupDeviceLike(String value) {
            addCriterion("group_device like", value, "groupDevice");
            return (Criteria) this;
        }

        public Criteria andGroupDeviceNotLike(String value) {
            addCriterion("group_device not like", value, "groupDevice");
            return (Criteria) this;
        }

        public Criteria andGroupDeviceIn(List<String> values) {
            addCriterion("group_device in", values, "groupDevice");
            return (Criteria) this;
        }

        public Criteria andGroupDeviceNotIn(List<String> values) {
            addCriterion("group_device not in", values, "groupDevice");
            return (Criteria) this;
        }

        public Criteria andGroupDeviceBetween(String value1, String value2) {
            addCriterion("group_device between", value1, value2, "groupDevice");
            return (Criteria) this;
        }

        public Criteria andGroupDeviceNotBetween(String value1, String value2) {
            addCriterion("group_device not between", value1, value2, "groupDevice");
            return (Criteria) this;
        }

        public Criteria andSumIsNull() {
            addCriterion("sum is null");
            return (Criteria) this;
        }

        public Criteria andSumIsNotNull() {
            addCriterion("sum is not null");
            return (Criteria) this;
        }

        public Criteria andSumEqualTo(Integer value) {
            addCriterion("sum =", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotEqualTo(Integer value) {
            addCriterion("sum <>", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumGreaterThan(Integer value) {
            addCriterion("sum >", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("sum >=", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumLessThan(Integer value) {
            addCriterion("sum <", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumLessThanOrEqualTo(Integer value) {
            addCriterion("sum <=", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumIn(List<Integer> values) {
            addCriterion("sum in", values, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotIn(List<Integer> values) {
            addCriterion("sum not in", values, "sum");
            return (Criteria) this;
        }

        public Criteria andSumBetween(Integer value1, Integer value2) {
            addCriterion("sum between", value1, value2, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotBetween(Integer value1, Integer value2) {
            addCriterion("sum not between", value1, value2, "sum");
            return (Criteria) this;
        }

        public Criteria andOfferIsNull() {
            addCriterion("offer is null");
            return (Criteria) this;
        }

        public Criteria andOfferIsNotNull() {
            addCriterion("offer is not null");
            return (Criteria) this;
        }

        public Criteria andOfferEqualTo(Integer value) {
            addCriterion("offer =", value, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferNotEqualTo(Integer value) {
            addCriterion("offer <>", value, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferGreaterThan(Integer value) {
            addCriterion("offer >", value, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferGreaterThanOrEqualTo(Integer value) {
            addCriterion("offer >=", value, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferLessThan(Integer value) {
            addCriterion("offer <", value, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferLessThanOrEqualTo(Integer value) {
            addCriterion("offer <=", value, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferIn(List<Integer> values) {
            addCriterion("offer in", values, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferNotIn(List<Integer> values) {
            addCriterion("offer not in", values, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferBetween(Integer value1, Integer value2) {
            addCriterion("offer between", value1, value2, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferNotBetween(Integer value1, Integer value2) {
            addCriterion("offer not between", value1, value2, "offer");
            return (Criteria) this;
        }

        public Criteria andBeginNoIsNull() {
            addCriterion("begin_no is null");
            return (Criteria) this;
        }

        public Criteria andBeginNoIsNotNull() {
            addCriterion("begin_no is not null");
            return (Criteria) this;
        }

        public Criteria andBeginNoEqualTo(String value) {
            addCriterion("begin_no =", value, "beginNo");
            return (Criteria) this;
        }

        public Criteria andBeginNoNotEqualTo(String value) {
            addCriterion("begin_no <>", value, "beginNo");
            return (Criteria) this;
        }

        public Criteria andBeginNoGreaterThan(String value) {
            addCriterion("begin_no >", value, "beginNo");
            return (Criteria) this;
        }

        public Criteria andBeginNoGreaterThanOrEqualTo(String value) {
            addCriterion("begin_no >=", value, "beginNo");
            return (Criteria) this;
        }

        public Criteria andBeginNoLessThan(String value) {
            addCriterion("begin_no <", value, "beginNo");
            return (Criteria) this;
        }

        public Criteria andBeginNoLessThanOrEqualTo(String value) {
            addCriterion("begin_no <=", value, "beginNo");
            return (Criteria) this;
        }

        public Criteria andBeginNoLike(String value) {
            addCriterion("begin_no like", value, "beginNo");
            return (Criteria) this;
        }

        public Criteria andBeginNoNotLike(String value) {
            addCriterion("begin_no not like", value, "beginNo");
            return (Criteria) this;
        }

        public Criteria andBeginNoIn(List<String> values) {
            addCriterion("begin_no in", values, "beginNo");
            return (Criteria) this;
        }

        public Criteria andBeginNoNotIn(List<String> values) {
            addCriterion("begin_no not in", values, "beginNo");
            return (Criteria) this;
        }

        public Criteria andBeginNoBetween(String value1, String value2) {
            addCriterion("begin_no between", value1, value2, "beginNo");
            return (Criteria) this;
        }

        public Criteria andBeginNoNotBetween(String value1, String value2) {
            addCriterion("begin_no not between", value1, value2, "beginNo");
            return (Criteria) this;
        }

        public Criteria andEndNoIsNull() {
            addCriterion("end_no is null");
            return (Criteria) this;
        }

        public Criteria andEndNoIsNotNull() {
            addCriterion("end_no is not null");
            return (Criteria) this;
        }

        public Criteria andEndNoEqualTo(String value) {
            addCriterion("end_no =", value, "endNo");
            return (Criteria) this;
        }

        public Criteria andEndNoNotEqualTo(String value) {
            addCriterion("end_no <>", value, "endNo");
            return (Criteria) this;
        }

        public Criteria andEndNoGreaterThan(String value) {
            addCriterion("end_no >", value, "endNo");
            return (Criteria) this;
        }

        public Criteria andEndNoGreaterThanOrEqualTo(String value) {
            addCriterion("end_no >=", value, "endNo");
            return (Criteria) this;
        }

        public Criteria andEndNoLessThan(String value) {
            addCriterion("end_no <", value, "endNo");
            return (Criteria) this;
        }

        public Criteria andEndNoLessThanOrEqualTo(String value) {
            addCriterion("end_no <=", value, "endNo");
            return (Criteria) this;
        }

        public Criteria andEndNoLike(String value) {
            addCriterion("end_no like", value, "endNo");
            return (Criteria) this;
        }

        public Criteria andEndNoNotLike(String value) {
            addCriterion("end_no not like", value, "endNo");
            return (Criteria) this;
        }

        public Criteria andEndNoIn(List<String> values) {
            addCriterion("end_no in", values, "endNo");
            return (Criteria) this;
        }

        public Criteria andEndNoNotIn(List<String> values) {
            addCriterion("end_no not in", values, "endNo");
            return (Criteria) this;
        }

        public Criteria andEndNoBetween(String value1, String value2) {
            addCriterion("end_no between", value1, value2, "endNo");
            return (Criteria) this;
        }

        public Criteria andEndNoNotBetween(String value1, String value2) {
            addCriterion("end_no not between", value1, value2, "endNo");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table device_info
     *
     * @mbg.generated do_not_delete_during_merge Thu Oct 08 21:24:29 CST 2020
     */
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