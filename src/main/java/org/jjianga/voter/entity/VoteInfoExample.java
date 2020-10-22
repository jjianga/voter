package org.jjianga.voter.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VoteInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
	* 
	* @return null
	*/
    public VoteInfoExample() {
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

        public Criteria andReportKeyIsNull() {
            addCriterion("report_key is null");
            return (Criteria) this;
        }

        public Criteria andReportKeyIsNotNull() {
            addCriterion("report_key is not null");
            return (Criteria) this;
        }

        public Criteria andReportKeyEqualTo(String value) {
            addCriterion("report_key =", value, "reportKey");
            return (Criteria) this;
        }

        public Criteria andReportKeyNotEqualTo(String value) {
            addCriterion("report_key <>", value, "reportKey");
            return (Criteria) this;
        }

        public Criteria andReportKeyGreaterThan(String value) {
            addCriterion("report_key >", value, "reportKey");
            return (Criteria) this;
        }

        public Criteria andReportKeyGreaterThanOrEqualTo(String value) {
            addCriterion("report_key >=", value, "reportKey");
            return (Criteria) this;
        }

        public Criteria andReportKeyLessThan(String value) {
            addCriterion("report_key <", value, "reportKey");
            return (Criteria) this;
        }

        public Criteria andReportKeyLessThanOrEqualTo(String value) {
            addCriterion("report_key <=", value, "reportKey");
            return (Criteria) this;
        }

        public Criteria andReportKeyLike(String value) {
            addCriterion("report_key like", value, "reportKey");
            return (Criteria) this;
        }

        public Criteria andReportKeyNotLike(String value) {
            addCriterion("report_key not like", value, "reportKey");
            return (Criteria) this;
        }

        public Criteria andReportKeyIn(List<String> values) {
            addCriterion("report_key in", values, "reportKey");
            return (Criteria) this;
        }

        public Criteria andReportKeyNotIn(List<String> values) {
            addCriterion("report_key not in", values, "reportKey");
            return (Criteria) this;
        }

        public Criteria andReportKeyBetween(String value1, String value2) {
            addCriterion("report_key between", value1, value2, "reportKey");
            return (Criteria) this;
        }

        public Criteria andReportKeyNotBetween(String value1, String value2) {
            addCriterion("report_key not between", value1, value2, "reportKey");
            return (Criteria) this;
        }

        public Criteria andDeviceNoIsNull() {
            addCriterion("device_no is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNoIsNotNull() {
            addCriterion("device_no is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNoEqualTo(String value) {
            addCriterion("device_no =", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotEqualTo(String value) {
            addCriterion("device_no <>", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoGreaterThan(String value) {
            addCriterion("device_no >", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoGreaterThanOrEqualTo(String value) {
            addCriterion("device_no >=", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLessThan(String value) {
            addCriterion("device_no <", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLessThanOrEqualTo(String value) {
            addCriterion("device_no <=", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLike(String value) {
            addCriterion("device_no like", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotLike(String value) {
            addCriterion("device_no not like", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoIn(List<String> values) {
            addCriterion("device_no in", values, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotIn(List<String> values) {
            addCriterion("device_no not in", values, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoBetween(String value1, String value2) {
            addCriterion("device_no between", value1, value2, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotBetween(String value1, String value2) {
            addCriterion("device_no not between", value1, value2, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andPlayerNoIsNull() {
            addCriterion("player_no is null");
            return (Criteria) this;
        }

        public Criteria andPlayerNoIsNotNull() {
            addCriterion("player_no is not null");
            return (Criteria) this;
        }

        public Criteria andPlayerNoEqualTo(Integer value) {
            addCriterion("player_no =", value, "playerNo");
            return (Criteria) this;
        }

        public Criteria andPlayerNoNotEqualTo(Integer value) {
            addCriterion("player_no <>", value, "playerNo");
            return (Criteria) this;
        }

        public Criteria andPlayerNoGreaterThan(Integer value) {
            addCriterion("player_no >", value, "playerNo");
            return (Criteria) this;
        }

        public Criteria andPlayerNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("player_no >=", value, "playerNo");
            return (Criteria) this;
        }

        public Criteria andPlayerNoLessThan(Integer value) {
            addCriterion("player_no <", value, "playerNo");
            return (Criteria) this;
        }

        public Criteria andPlayerNoLessThanOrEqualTo(Integer value) {
            addCriterion("player_no <=", value, "playerNo");
            return (Criteria) this;
        }

        public Criteria andPlayerNoIn(List<Integer> values) {
            addCriterion("player_no in", values, "playerNo");
            return (Criteria) this;
        }

        public Criteria andPlayerNoNotIn(List<Integer> values) {
            addCriterion("player_no not in", values, "playerNo");
            return (Criteria) this;
        }

        public Criteria andPlayerNoBetween(Integer value1, Integer value2) {
            addCriterion("player_no between", value1, value2, "playerNo");
            return (Criteria) this;
        }

        public Criteria andPlayerNoNotBetween(Integer value1, Integer value2) {
            addCriterion("player_no not between", value1, value2, "playerNo");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(Integer value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(Integer value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(Integer value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(Integer value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(Integer value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<Integer> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<Integer> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(Integer value1, Integer value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(Integer value1, Integer value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andVoteTimeIsNull() {
            addCriterion("vote_time is null");
            return (Criteria) this;
        }

        public Criteria andVoteTimeIsNotNull() {
            addCriterion("vote_time is not null");
            return (Criteria) this;
        }

        public Criteria andVoteTimeEqualTo(Date value) {
            addCriterion("vote_time =", value, "voteTime");
            return (Criteria) this;
        }

        public Criteria andVoteTimeNotEqualTo(Date value) {
            addCriterion("vote_time <>", value, "voteTime");
            return (Criteria) this;
        }

        public Criteria andVoteTimeGreaterThan(Date value) {
            addCriterion("vote_time >", value, "voteTime");
            return (Criteria) this;
        }

        public Criteria andVoteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("vote_time >=", value, "voteTime");
            return (Criteria) this;
        }

        public Criteria andVoteTimeLessThan(Date value) {
            addCriterion("vote_time <", value, "voteTime");
            return (Criteria) this;
        }

        public Criteria andVoteTimeLessThanOrEqualTo(Date value) {
            addCriterion("vote_time <=", value, "voteTime");
            return (Criteria) this;
        }

        public Criteria andVoteTimeIn(List<Date> values) {
            addCriterion("vote_time in", values, "voteTime");
            return (Criteria) this;
        }

        public Criteria andVoteTimeNotIn(List<Date> values) {
            addCriterion("vote_time not in", values, "voteTime");
            return (Criteria) this;
        }

        public Criteria andVoteTimeBetween(Date value1, Date value2) {
            addCriterion("vote_time between", value1, value2, "voteTime");
            return (Criteria) this;
        }

        public Criteria andVoteTimeNotBetween(Date value1, Date value2) {
            addCriterion("vote_time not between", value1, value2, "voteTime");
            return (Criteria) this;
        }

        public Criteria andDataStatusIsNull() {
            addCriterion("data_status is null");
            return (Criteria) this;
        }

        public Criteria andDataStatusIsNotNull() {
            addCriterion("data_status is not null");
            return (Criteria) this;
        }

        public Criteria andDataStatusEqualTo(Integer value) {
            addCriterion("data_status =", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotEqualTo(Integer value) {
            addCriterion("data_status <>", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusGreaterThan(Integer value) {
            addCriterion("data_status >", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_status >=", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusLessThan(Integer value) {
            addCriterion("data_status <", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusLessThanOrEqualTo(Integer value) {
            addCriterion("data_status <=", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusIn(List<Integer> values) {
            addCriterion("data_status in", values, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotIn(List<Integer> values) {
            addCriterion("data_status not in", values, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusBetween(Integer value1, Integer value2) {
            addCriterion("data_status between", value1, value2, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("data_status not between", value1, value2, "dataStatus");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table vote_info
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