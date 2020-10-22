package org.jjianga.voter.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.jjianga.voter.entity.AthleteInfo;
import org.jjianga.voter.entity.AthleteInfoExample.Criteria;
import org.jjianga.voter.entity.AthleteInfoExample.Criterion;
import org.jjianga.voter.entity.AthleteInfoExample;

public class AthleteInfoSqlProvider {

    /**
	* 
	* @param example
	* @return java.lang.String
	*/
    public String countByExample(AthleteInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("athlete_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
	* 
	* @param example
	* @return java.lang.String
	*/
    public String deleteByExample(AthleteInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("athlete_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
	* 
	* @param record
	* @return java.lang.String
	*/
    public String insertSelective(AthleteInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("athlete_info");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTeam() != null) {
            sql.VALUES("team", "#{team,jdbcType=VARCHAR}");
        }
        
        if (record.getRonda() != null) {
            sql.VALUES("ronda", "#{ronda,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getAthleteBeginTime() != null) {
            sql.VALUES("athlete_begin_time", "#{athleteBeginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAthleteEndTime() != null) {
            sql.VALUES("athlete_end_time", "#{athleteEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAthleteValue() != null) {
            sql.VALUES("athlete_value", "#{athleteValue,jdbcType=INTEGER}");
        }
        
        if (record.getAudienceBeginTime() != null) {
            sql.VALUES("audience_begin_time", "#{audienceBeginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAudienceEndTime() != null) {
            sql.VALUES("audience_end_time", "#{audienceEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAudienceValue() != null) {
            sql.VALUES("audience_value", "#{audienceValue,jdbcType=INTEGER}");
        }
        
        if (record.getScore() != null) {
            sql.VALUES("score", "#{score,jdbcType=INTEGER}");
        }
        
        if (record.getAthleteStatus() != null) {
            sql.VALUES("athlete_status", "#{athleteStatus,jdbcType=INTEGER}");
        }
        
        if (record.getClearingTime() != null) {
            sql.VALUES("clearing_time", "#{clearingTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
	* 
	* @param example
	* @return java.lang.String
	*/
    public String selectByExample(AthleteInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("team");
        sql.SELECT("ronda");
        sql.SELECT("name");
        sql.SELECT("athlete_begin_time");
        sql.SELECT("athlete_end_time");
        sql.SELECT("athlete_value");
        sql.SELECT("audience_begin_time");
        sql.SELECT("audience_end_time");
        sql.SELECT("audience_value");
        sql.SELECT("score");
        sql.SELECT("athlete_status");
        sql.SELECT("clearing_time");
        sql.FROM("athlete_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
	* 
	* @param parameter
	* @return java.lang.String
	*/
    public String updateByExampleSelective(Map<String, Object> parameter) {
        AthleteInfo record = (AthleteInfo) parameter.get("record");
        AthleteInfoExample example = (AthleteInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("athlete_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getTeam() != null) {
            sql.SET("team = #{record.team,jdbcType=VARCHAR}");
        }
        
        if (record.getRonda() != null) {
            sql.SET("ronda = #{record.ronda,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getAthleteBeginTime() != null) {
            sql.SET("athlete_begin_time = #{record.athleteBeginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAthleteEndTime() != null) {
            sql.SET("athlete_end_time = #{record.athleteEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAthleteValue() != null) {
            sql.SET("athlete_value = #{record.athleteValue,jdbcType=INTEGER}");
        }
        
        if (record.getAudienceBeginTime() != null) {
            sql.SET("audience_begin_time = #{record.audienceBeginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAudienceEndTime() != null) {
            sql.SET("audience_end_time = #{record.audienceEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAudienceValue() != null) {
            sql.SET("audience_value = #{record.audienceValue,jdbcType=INTEGER}");
        }
        
        if (record.getScore() != null) {
            sql.SET("score = #{record.score,jdbcType=INTEGER}");
        }
        
        if (record.getAthleteStatus() != null) {
            sql.SET("athlete_status = #{record.athleteStatus,jdbcType=INTEGER}");
        }
        
        if (record.getClearingTime() != null) {
            sql.SET("clearing_time = #{record.clearingTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
	* 
	* @param parameter
	* @return java.lang.String
	*/
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("athlete_info");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("team = #{record.team,jdbcType=VARCHAR}");
        sql.SET("ronda = #{record.ronda,jdbcType=VARCHAR}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("athlete_begin_time = #{record.athleteBeginTime,jdbcType=TIMESTAMP}");
        sql.SET("athlete_end_time = #{record.athleteEndTime,jdbcType=TIMESTAMP}");
        sql.SET("athlete_value = #{record.athleteValue,jdbcType=INTEGER}");
        sql.SET("audience_begin_time = #{record.audienceBeginTime,jdbcType=TIMESTAMP}");
        sql.SET("audience_end_time = #{record.audienceEndTime,jdbcType=TIMESTAMP}");
        sql.SET("audience_value = #{record.audienceValue,jdbcType=INTEGER}");
        sql.SET("score = #{record.score,jdbcType=INTEGER}");
        sql.SET("athlete_status = #{record.athleteStatus,jdbcType=INTEGER}");
        sql.SET("clearing_time = #{record.clearingTime,jdbcType=TIMESTAMP}");
        
        AthleteInfoExample example = (AthleteInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
	* 
	* @param record
	* @return java.lang.String
	*/
    public String updateByPrimaryKeySelective(AthleteInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("athlete_info");
        
        if (record.getTeam() != null) {
            sql.SET("team = #{team,jdbcType=VARCHAR}");
        }
        
        if (record.getRonda() != null) {
            sql.SET("ronda = #{ronda,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getAthleteBeginTime() != null) {
            sql.SET("athlete_begin_time = #{athleteBeginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAthleteEndTime() != null) {
            sql.SET("athlete_end_time = #{athleteEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAthleteValue() != null) {
            sql.SET("athlete_value = #{athleteValue,jdbcType=INTEGER}");
        }
        
        if (record.getAudienceBeginTime() != null) {
            sql.SET("audience_begin_time = #{audienceBeginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAudienceEndTime() != null) {
            sql.SET("audience_end_time = #{audienceEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAudienceValue() != null) {
            sql.SET("audience_value = #{audienceValue,jdbcType=INTEGER}");
        }
        
        if (record.getScore() != null) {
            sql.SET("score = #{score,jdbcType=INTEGER}");
        }
        
        if (record.getAthleteStatus() != null) {
            sql.SET("athlete_status = #{athleteStatus,jdbcType=INTEGER}");
        }
        
        if (record.getClearingTime() != null) {
            sql.SET("clearing_time = #{clearingTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    /**
	* 
	* @param sql
	* @param example
	* @param includeExamplePhrase
	* @return null
	*/
    protected void applyWhere(SQL sql, AthleteInfoExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}