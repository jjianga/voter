package org.jjianga.voter.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AthleteInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
	* 
	* @return null
	*/
    public AthleteInfoExample() {
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

        public Criteria andTeamIsNull() {
            addCriterion("team is null");
            return (Criteria) this;
        }

        public Criteria andTeamIsNotNull() {
            addCriterion("team is not null");
            return (Criteria) this;
        }

        public Criteria andTeamEqualTo(String value) {
            addCriterion("team =", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamNotEqualTo(String value) {
            addCriterion("team <>", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamGreaterThan(String value) {
            addCriterion("team >", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamGreaterThanOrEqualTo(String value) {
            addCriterion("team >=", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamLessThan(String value) {
            addCriterion("team <", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamLessThanOrEqualTo(String value) {
            addCriterion("team <=", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamLike(String value) {
            addCriterion("team like", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamNotLike(String value) {
            addCriterion("team not like", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamIn(List<String> values) {
            addCriterion("team in", values, "team");
            return (Criteria) this;
        }

        public Criteria andTeamNotIn(List<String> values) {
            addCriterion("team not in", values, "team");
            return (Criteria) this;
        }

        public Criteria andTeamBetween(String value1, String value2) {
            addCriterion("team between", value1, value2, "team");
            return (Criteria) this;
        }

        public Criteria andTeamNotBetween(String value1, String value2) {
            addCriterion("team not between", value1, value2, "team");
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

        public Criteria andAthleteBeginTimeIsNull() {
            addCriterion("athlete_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andAthleteBeginTimeIsNotNull() {
            addCriterion("athlete_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andAthleteBeginTimeEqualTo(Date value) {
            addCriterion("athlete_begin_time =", value, "athleteBeginTime");
            return (Criteria) this;
        }

        public Criteria andAthleteBeginTimeNotEqualTo(Date value) {
            addCriterion("athlete_begin_time <>", value, "athleteBeginTime");
            return (Criteria) this;
        }

        public Criteria andAthleteBeginTimeGreaterThan(Date value) {
            addCriterion("athlete_begin_time >", value, "athleteBeginTime");
            return (Criteria) this;
        }

        public Criteria andAthleteBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("athlete_begin_time >=", value, "athleteBeginTime");
            return (Criteria) this;
        }

        public Criteria andAthleteBeginTimeLessThan(Date value) {
            addCriterion("athlete_begin_time <", value, "athleteBeginTime");
            return (Criteria) this;
        }

        public Criteria andAthleteBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("athlete_begin_time <=", value, "athleteBeginTime");
            return (Criteria) this;
        }

        public Criteria andAthleteBeginTimeIn(List<Date> values) {
            addCriterion("athlete_begin_time in", values, "athleteBeginTime");
            return (Criteria) this;
        }

        public Criteria andAthleteBeginTimeNotIn(List<Date> values) {
            addCriterion("athlete_begin_time not in", values, "athleteBeginTime");
            return (Criteria) this;
        }

        public Criteria andAthleteBeginTimeBetween(Date value1, Date value2) {
            addCriterion("athlete_begin_time between", value1, value2, "athleteBeginTime");
            return (Criteria) this;
        }

        public Criteria andAthleteBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("athlete_begin_time not between", value1, value2, "athleteBeginTime");
            return (Criteria) this;
        }

        public Criteria andAthleteEndTimeIsNull() {
            addCriterion("athlete_end_time is null");
            return (Criteria) this;
        }

        public Criteria andAthleteEndTimeIsNotNull() {
            addCriterion("athlete_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andAthleteEndTimeEqualTo(Date value) {
            addCriterion("athlete_end_time =", value, "athleteEndTime");
            return (Criteria) this;
        }

        public Criteria andAthleteEndTimeNotEqualTo(Date value) {
            addCriterion("athlete_end_time <>", value, "athleteEndTime");
            return (Criteria) this;
        }

        public Criteria andAthleteEndTimeGreaterThan(Date value) {
            addCriterion("athlete_end_time >", value, "athleteEndTime");
            return (Criteria) this;
        }

        public Criteria andAthleteEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("athlete_end_time >=", value, "athleteEndTime");
            return (Criteria) this;
        }

        public Criteria andAthleteEndTimeLessThan(Date value) {
            addCriterion("athlete_end_time <", value, "athleteEndTime");
            return (Criteria) this;
        }

        public Criteria andAthleteEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("athlete_end_time <=", value, "athleteEndTime");
            return (Criteria) this;
        }

        public Criteria andAthleteEndTimeIn(List<Date> values) {
            addCriterion("athlete_end_time in", values, "athleteEndTime");
            return (Criteria) this;
        }

        public Criteria andAthleteEndTimeNotIn(List<Date> values) {
            addCriterion("athlete_end_time not in", values, "athleteEndTime");
            return (Criteria) this;
        }

        public Criteria andAthleteEndTimeBetween(Date value1, Date value2) {
            addCriterion("athlete_end_time between", value1, value2, "athleteEndTime");
            return (Criteria) this;
        }

        public Criteria andAthleteEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("athlete_end_time not between", value1, value2, "athleteEndTime");
            return (Criteria) this;
        }

        public Criteria andAthleteValueIsNull() {
            addCriterion("athlete_value is null");
            return (Criteria) this;
        }

        public Criteria andAthleteValueIsNotNull() {
            addCriterion("athlete_value is not null");
            return (Criteria) this;
        }

        public Criteria andAthleteValueEqualTo(Integer value) {
            addCriterion("athlete_value =", value, "athleteValue");
            return (Criteria) this;
        }

        public Criteria andAthleteValueNotEqualTo(Integer value) {
            addCriterion("athlete_value <>", value, "athleteValue");
            return (Criteria) this;
        }

        public Criteria andAthleteValueGreaterThan(Integer value) {
            addCriterion("athlete_value >", value, "athleteValue");
            return (Criteria) this;
        }

        public Criteria andAthleteValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("athlete_value >=", value, "athleteValue");
            return (Criteria) this;
        }

        public Criteria andAthleteValueLessThan(Integer value) {
            addCriterion("athlete_value <", value, "athleteValue");
            return (Criteria) this;
        }

        public Criteria andAthleteValueLessThanOrEqualTo(Integer value) {
            addCriterion("athlete_value <=", value, "athleteValue");
            return (Criteria) this;
        }

        public Criteria andAthleteValueIn(List<Integer> values) {
            addCriterion("athlete_value in", values, "athleteValue");
            return (Criteria) this;
        }

        public Criteria andAthleteValueNotIn(List<Integer> values) {
            addCriterion("athlete_value not in", values, "athleteValue");
            return (Criteria) this;
        }

        public Criteria andAthleteValueBetween(Integer value1, Integer value2) {
            addCriterion("athlete_value between", value1, value2, "athleteValue");
            return (Criteria) this;
        }

        public Criteria andAthleteValueNotBetween(Integer value1, Integer value2) {
            addCriterion("athlete_value not between", value1, value2, "athleteValue");
            return (Criteria) this;
        }

        public Criteria andAudienceBeginTimeIsNull() {
            addCriterion("audience_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andAudienceBeginTimeIsNotNull() {
            addCriterion("audience_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andAudienceBeginTimeEqualTo(Date value) {
            addCriterion("audience_begin_time =", value, "audienceBeginTime");
            return (Criteria) this;
        }

        public Criteria andAudienceBeginTimeNotEqualTo(Date value) {
            addCriterion("audience_begin_time <>", value, "audienceBeginTime");
            return (Criteria) this;
        }

        public Criteria andAudienceBeginTimeGreaterThan(Date value) {
            addCriterion("audience_begin_time >", value, "audienceBeginTime");
            return (Criteria) this;
        }

        public Criteria andAudienceBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("audience_begin_time >=", value, "audienceBeginTime");
            return (Criteria) this;
        }

        public Criteria andAudienceBeginTimeLessThan(Date value) {
            addCriterion("audience_begin_time <", value, "audienceBeginTime");
            return (Criteria) this;
        }

        public Criteria andAudienceBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("audience_begin_time <=", value, "audienceBeginTime");
            return (Criteria) this;
        }

        public Criteria andAudienceBeginTimeIn(List<Date> values) {
            addCriterion("audience_begin_time in", values, "audienceBeginTime");
            return (Criteria) this;
        }

        public Criteria andAudienceBeginTimeNotIn(List<Date> values) {
            addCriterion("audience_begin_time not in", values, "audienceBeginTime");
            return (Criteria) this;
        }

        public Criteria andAudienceBeginTimeBetween(Date value1, Date value2) {
            addCriterion("audience_begin_time between", value1, value2, "audienceBeginTime");
            return (Criteria) this;
        }

        public Criteria andAudienceBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("audience_begin_time not between", value1, value2, "audienceBeginTime");
            return (Criteria) this;
        }

        public Criteria andAudienceEndTimeIsNull() {
            addCriterion("audience_end_time is null");
            return (Criteria) this;
        }

        public Criteria andAudienceEndTimeIsNotNull() {
            addCriterion("audience_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andAudienceEndTimeEqualTo(Date value) {
            addCriterion("audience_end_time =", value, "audienceEndTime");
            return (Criteria) this;
        }

        public Criteria andAudienceEndTimeNotEqualTo(Date value) {
            addCriterion("audience_end_time <>", value, "audienceEndTime");
            return (Criteria) this;
        }

        public Criteria andAudienceEndTimeGreaterThan(Date value) {
            addCriterion("audience_end_time >", value, "audienceEndTime");
            return (Criteria) this;
        }

        public Criteria andAudienceEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("audience_end_time >=", value, "audienceEndTime");
            return (Criteria) this;
        }

        public Criteria andAudienceEndTimeLessThan(Date value) {
            addCriterion("audience_end_time <", value, "audienceEndTime");
            return (Criteria) this;
        }

        public Criteria andAudienceEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("audience_end_time <=", value, "audienceEndTime");
            return (Criteria) this;
        }

        public Criteria andAudienceEndTimeIn(List<Date> values) {
            addCriterion("audience_end_time in", values, "audienceEndTime");
            return (Criteria) this;
        }

        public Criteria andAudienceEndTimeNotIn(List<Date> values) {
            addCriterion("audience_end_time not in", values, "audienceEndTime");
            return (Criteria) this;
        }

        public Criteria andAudienceEndTimeBetween(Date value1, Date value2) {
            addCriterion("audience_end_time between", value1, value2, "audienceEndTime");
            return (Criteria) this;
        }

        public Criteria andAudienceEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("audience_end_time not between", value1, value2, "audienceEndTime");
            return (Criteria) this;
        }

        public Criteria andAudienceValueIsNull() {
            addCriterion("audience_value is null");
            return (Criteria) this;
        }

        public Criteria andAudienceValueIsNotNull() {
            addCriterion("audience_value is not null");
            return (Criteria) this;
        }

        public Criteria andAudienceValueEqualTo(Integer value) {
            addCriterion("audience_value =", value, "audienceValue");
            return (Criteria) this;
        }

        public Criteria andAudienceValueNotEqualTo(Integer value) {
            addCriterion("audience_value <>", value, "audienceValue");
            return (Criteria) this;
        }

        public Criteria andAudienceValueGreaterThan(Integer value) {
            addCriterion("audience_value >", value, "audienceValue");
            return (Criteria) this;
        }

        public Criteria andAudienceValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("audience_value >=", value, "audienceValue");
            return (Criteria) this;
        }

        public Criteria andAudienceValueLessThan(Integer value) {
            addCriterion("audience_value <", value, "audienceValue");
            return (Criteria) this;
        }

        public Criteria andAudienceValueLessThanOrEqualTo(Integer value) {
            addCriterion("audience_value <=", value, "audienceValue");
            return (Criteria) this;
        }

        public Criteria andAudienceValueIn(List<Integer> values) {
            addCriterion("audience_value in", values, "audienceValue");
            return (Criteria) this;
        }

        public Criteria andAudienceValueNotIn(List<Integer> values) {
            addCriterion("audience_value not in", values, "audienceValue");
            return (Criteria) this;
        }

        public Criteria andAudienceValueBetween(Integer value1, Integer value2) {
            addCriterion("audience_value between", value1, value2, "audienceValue");
            return (Criteria) this;
        }

        public Criteria andAudienceValueNotBetween(Integer value1, Integer value2) {
            addCriterion("audience_value not between", value1, value2, "audienceValue");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andAthleteStatusIsNull() {
            addCriterion("athlete_status is null");
            return (Criteria) this;
        }

        public Criteria andAthleteStatusIsNotNull() {
            addCriterion("athlete_status is not null");
            return (Criteria) this;
        }

        public Criteria andAthleteStatusEqualTo(Integer value) {
            addCriterion("athlete_status =", value, "athleteStatus");
            return (Criteria) this;
        }

        public Criteria andAthleteStatusNotEqualTo(Integer value) {
            addCriterion("athlete_status <>", value, "athleteStatus");
            return (Criteria) this;
        }

        public Criteria andAthleteStatusGreaterThan(Integer value) {
            addCriterion("athlete_status >", value, "athleteStatus");
            return (Criteria) this;
        }

        public Criteria andAthleteStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("athlete_status >=", value, "athleteStatus");
            return (Criteria) this;
        }

        public Criteria andAthleteStatusLessThan(Integer value) {
            addCriterion("athlete_status <", value, "athleteStatus");
            return (Criteria) this;
        }

        public Criteria andAthleteStatusLessThanOrEqualTo(Integer value) {
            addCriterion("athlete_status <=", value, "athleteStatus");
            return (Criteria) this;
        }

        public Criteria andAthleteStatusIn(List<Integer> values) {
            addCriterion("athlete_status in", values, "athleteStatus");
            return (Criteria) this;
        }

        public Criteria andAthleteStatusNotIn(List<Integer> values) {
            addCriterion("athlete_status not in", values, "athleteStatus");
            return (Criteria) this;
        }

        public Criteria andAthleteStatusBetween(Integer value1, Integer value2) {
            addCriterion("athlete_status between", value1, value2, "athleteStatus");
            return (Criteria) this;
        }

        public Criteria andAthleteStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("athlete_status not between", value1, value2, "athleteStatus");
            return (Criteria) this;
        }

        public Criteria andClearingTimeIsNull() {
            addCriterion("clearing_time is null");
            return (Criteria) this;
        }

        public Criteria andClearingTimeIsNotNull() {
            addCriterion("clearing_time is not null");
            return (Criteria) this;
        }

        public Criteria andClearingTimeEqualTo(Date value) {
            addCriterion("clearing_time =", value, "clearingTime");
            return (Criteria) this;
        }

        public Criteria andClearingTimeNotEqualTo(Date value) {
            addCriterion("clearing_time <>", value, "clearingTime");
            return (Criteria) this;
        }

        public Criteria andClearingTimeGreaterThan(Date value) {
            addCriterion("clearing_time >", value, "clearingTime");
            return (Criteria) this;
        }

        public Criteria andClearingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("clearing_time >=", value, "clearingTime");
            return (Criteria) this;
        }

        public Criteria andClearingTimeLessThan(Date value) {
            addCriterion("clearing_time <", value, "clearingTime");
            return (Criteria) this;
        }

        public Criteria andClearingTimeLessThanOrEqualTo(Date value) {
            addCriterion("clearing_time <=", value, "clearingTime");
            return (Criteria) this;
        }

        public Criteria andClearingTimeIn(List<Date> values) {
            addCriterion("clearing_time in", values, "clearingTime");
            return (Criteria) this;
        }

        public Criteria andClearingTimeNotIn(List<Date> values) {
            addCriterion("clearing_time not in", values, "clearingTime");
            return (Criteria) this;
        }

        public Criteria andClearingTimeBetween(Date value1, Date value2) {
            addCriterion("clearing_time between", value1, value2, "clearingTime");
            return (Criteria) this;
        }

        public Criteria andClearingTimeNotBetween(Date value1, Date value2) {
            addCriterion("clearing_time not between", value1, value2, "clearingTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table athlete_info
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