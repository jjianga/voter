package org.jjianga.voter.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.jjianga.voter.entity.DeviceInfo;
import org.jjianga.voter.entity.DeviceInfoExample.Criteria;
import org.jjianga.voter.entity.DeviceInfoExample.Criterion;
import org.jjianga.voter.entity.DeviceInfoExample;

public class DeviceInfoSqlProvider {

    /**
	* 
	* @param example
	* @return java.lang.String
	*/
    public String countByExample(DeviceInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("device_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
	* 
	* @param example
	* @return java.lang.String
	*/
    public String deleteByExample(DeviceInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("device_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
	* 
	* @param record
	* @return java.lang.String
	*/
    public String insertSelective(DeviceInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("device_info");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getRonda() != null) {
            sql.VALUES("ronda", "#{ronda,jdbcType=VARCHAR}");
        }
        
        if (record.getGroupDevice() != null) {
            sql.VALUES("group_device", "#{groupDevice,jdbcType=VARCHAR}");
        }
        
        if (record.getSum() != null) {
            sql.VALUES("sum", "#{sum,jdbcType=INTEGER}");
        }
        
        if (record.getOffer() != null) {
            sql.VALUES("offer", "#{offer,jdbcType=INTEGER}");
        }
        
        if (record.getBeginNo() != null) {
            sql.VALUES("begin_no", "#{beginNo,jdbcType=VARCHAR}");
        }
        
        if (record.getEndNo() != null) {
            sql.VALUES("end_no", "#{endNo,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
	* 
	* @param example
	* @return java.lang.String
	*/
    public String selectByExample(DeviceInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("ronda");
        sql.SELECT("group_device");
        sql.SELECT("sum");
        sql.SELECT("offer");
        sql.SELECT("begin_no");
        sql.SELECT("end_no");
        sql.FROM("device_info");
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
        DeviceInfo record = (DeviceInfo) parameter.get("record");
        DeviceInfoExample example = (DeviceInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("device_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getRonda() != null) {
            sql.SET("ronda = #{record.ronda,jdbcType=VARCHAR}");
        }
        
        if (record.getGroupDevice() != null) {
            sql.SET("group_device = #{record.groupDevice,jdbcType=VARCHAR}");
        }
        
        if (record.getSum() != null) {
            sql.SET("sum = #{record.sum,jdbcType=INTEGER}");
        }
        
        if (record.getOffer() != null) {
            sql.SET("offer = #{record.offer,jdbcType=INTEGER}");
        }
        
        if (record.getBeginNo() != null) {
            sql.SET("begin_no = #{record.beginNo,jdbcType=VARCHAR}");
        }
        
        if (record.getEndNo() != null) {
            sql.SET("end_no = #{record.endNo,jdbcType=VARCHAR}");
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
        sql.UPDATE("device_info");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("ronda = #{record.ronda,jdbcType=VARCHAR}");
        sql.SET("group_device = #{record.groupDevice,jdbcType=VARCHAR}");
        sql.SET("sum = #{record.sum,jdbcType=INTEGER}");
        sql.SET("offer = #{record.offer,jdbcType=INTEGER}");
        sql.SET("begin_no = #{record.beginNo,jdbcType=VARCHAR}");
        sql.SET("end_no = #{record.endNo,jdbcType=VARCHAR}");
        
        DeviceInfoExample example = (DeviceInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
	* 
	* @param record
	* @return java.lang.String
	*/
    public String updateByPrimaryKeySelective(DeviceInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("device_info");
        
        if (record.getRonda() != null) {
            sql.SET("ronda = #{ronda,jdbcType=VARCHAR}");
        }
        
        if (record.getGroupDevice() != null) {
            sql.SET("group_device = #{groupDevice,jdbcType=VARCHAR}");
        }
        
        if (record.getSum() != null) {
            sql.SET("sum = #{sum,jdbcType=INTEGER}");
        }
        
        if (record.getOffer() != null) {
            sql.SET("offer = #{offer,jdbcType=INTEGER}");
        }
        
        if (record.getBeginNo() != null) {
            sql.SET("begin_no = #{beginNo,jdbcType=VARCHAR}");
        }
        
        if (record.getEndNo() != null) {
            sql.SET("end_no = #{endNo,jdbcType=VARCHAR}");
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
    protected void applyWhere(SQL sql, DeviceInfoExample example, boolean includeExamplePhrase) {
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