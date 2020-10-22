package org.jjianga.voter.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.jjianga.voter.entity.VoteInfo;
import org.jjianga.voter.entity.VoteInfoExample.Criteria;
import org.jjianga.voter.entity.VoteInfoExample.Criterion;
import org.jjianga.voter.entity.VoteInfoExample;

public class VoteInfoSqlProvider {

    /**
	* 
	* @param example
	* @return java.lang.String
	*/
    public String countByExample(VoteInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("vote_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
	* 
	* @param example
	* @return java.lang.String
	*/
    public String deleteByExample(VoteInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("vote_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
	* 
	* @param record
	* @return java.lang.String
	*/
    public String insertSelective(VoteInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("vote_info");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getReportKey() != null) {
            sql.VALUES("report_key", "#{reportKey,jdbcType=VARCHAR}");
        }
        
        if (record.getDeviceNo() != null) {
            sql.VALUES("device_no", "#{deviceNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPlayerNo() != null) {
            sql.VALUES("player_no", "#{playerNo,jdbcType=INTEGER}");
        }
        
        if (record.getResult() != null) {
            sql.VALUES("result", "#{result,jdbcType=INTEGER}");
        }
        
        if (record.getVoteTime() != null) {
            sql.VALUES("vote_time", "#{voteTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDataStatus() != null) {
            sql.VALUES("data_status", "#{dataStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
	* 
	* @param example
	* @return java.lang.String
	*/
    public String selectByExample(VoteInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("report_key");
        sql.SELECT("device_no");
        sql.SELECT("player_no");
        sql.SELECT("result");
        sql.SELECT("vote_time");
        sql.SELECT("data_status");
        sql.SELECT("create_time");
        sql.FROM("vote_info");
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
        VoteInfo record = (VoteInfo) parameter.get("record");
        VoteInfoExample example = (VoteInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("vote_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getReportKey() != null) {
            sql.SET("report_key = #{record.reportKey,jdbcType=VARCHAR}");
        }
        
        if (record.getDeviceNo() != null) {
            sql.SET("device_no = #{record.deviceNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPlayerNo() != null) {
            sql.SET("player_no = #{record.playerNo,jdbcType=INTEGER}");
        }
        
        if (record.getResult() != null) {
            sql.SET("result = #{record.result,jdbcType=INTEGER}");
        }
        
        if (record.getVoteTime() != null) {
            sql.SET("vote_time = #{record.voteTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDataStatus() != null) {
            sql.SET("data_status = #{record.dataStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
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
        sql.UPDATE("vote_info");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("report_key = #{record.reportKey,jdbcType=VARCHAR}");
        sql.SET("device_no = #{record.deviceNo,jdbcType=VARCHAR}");
        sql.SET("player_no = #{record.playerNo,jdbcType=INTEGER}");
        sql.SET("result = #{record.result,jdbcType=INTEGER}");
        sql.SET("vote_time = #{record.voteTime,jdbcType=TIMESTAMP}");
        sql.SET("data_status = #{record.dataStatus,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        VoteInfoExample example = (VoteInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
	* 
	* @param record
	* @return java.lang.String
	*/
    public String updateByPrimaryKeySelective(VoteInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("vote_info");
        
        if (record.getReportKey() != null) {
            sql.SET("report_key = #{reportKey,jdbcType=VARCHAR}");
        }
        
        if (record.getDeviceNo() != null) {
            sql.SET("device_no = #{deviceNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPlayerNo() != null) {
            sql.SET("player_no = #{playerNo,jdbcType=INTEGER}");
        }
        
        if (record.getResult() != null) {
            sql.SET("result = #{result,jdbcType=INTEGER}");
        }
        
        if (record.getVoteTime() != null) {
            sql.SET("vote_time = #{voteTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDataStatus() != null) {
            sql.SET("data_status = #{dataStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
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
    protected void applyWhere(SQL sql, VoteInfoExample example, boolean includeExamplePhrase) {
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