package org.jjianga.voter.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.jjianga.voter.entity.AthleteInfo;
import org.jjianga.voter.entity.AthleteInfoExample;
import org.jjianga.voter.mapper.custom.BestAthleteInfoMapper;

public interface AthleteInfoMapper extends BestAthleteInfoMapper {
    /**
	* 
	* @param example
	* @return long
	*/
    @SelectProvider(type=AthleteInfoSqlProvider.class, method="countByExample")
    long countByExample(AthleteInfoExample example);

    /**
	* 
	* @param example
	* @return int
	*/
    @DeleteProvider(type=AthleteInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(AthleteInfoExample example);

    /**
	* 
	* @param id
	* @return int
	*/
    @Delete({
        "delete from athlete_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
	* 
	* @param record
	* @return int
	*/
    @Insert({
        "insert into athlete_info (id, team, ",
        "ronda, name, athlete_begin_time, ",
        "athlete_end_time, athlete_value, ",
        "audience_begin_time, audience_end_time, ",
        "audience_value, score, ",
        "athlete_status, clearing_time)",
        "values (#{id,jdbcType=INTEGER}, #{team,jdbcType=VARCHAR}, ",
        "#{ronda,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, #{athleteBeginTime,jdbcType=TIMESTAMP}, ",
        "#{athleteEndTime,jdbcType=TIMESTAMP}, #{athleteValue,jdbcType=INTEGER}, ",
        "#{audienceBeginTime,jdbcType=TIMESTAMP}, #{audienceEndTime,jdbcType=TIMESTAMP}, ",
        "#{audienceValue,jdbcType=INTEGER}, #{score,jdbcType=INTEGER}, ",
        "#{athleteStatus,jdbcType=INTEGER}, #{clearingTime,jdbcType=TIMESTAMP})"
    })
    int insert(AthleteInfo record);

    /**
	* 
	* @param record
	* @return int
	*/
    @InsertProvider(type=AthleteInfoSqlProvider.class, method="insertSelective")
    int insertSelective(AthleteInfo record);

    /**
	* 
	* @param example
	* @return java.util.List<org.jjianga.voter.entity.AthleteInfo>
	*/
    @SelectProvider(type=AthleteInfoSqlProvider.class, method="selectByExample")
    @Results(value={
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="team", property="team", jdbcType=JdbcType.VARCHAR),
        @Result(column="ronda", property="ronda", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="athlete_begin_time", property="athleteBeginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="athlete_end_time", property="athleteEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="athlete_value", property="athleteValue", jdbcType=JdbcType.INTEGER),
        @Result(column="audience_begin_time", property="audienceBeginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audience_end_time", property="audienceEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audience_value", property="audienceValue", jdbcType=JdbcType.INTEGER),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="athlete_status", property="athleteStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="clearing_time", property="clearingTime", jdbcType=JdbcType.TIMESTAMP)
    },id="athleteInfo")
    List<AthleteInfo> selectByExample(AthleteInfoExample example);

    /**
	* 
	* @param id
	* @return org.jjianga.voter.entity.AthleteInfo
	*/
    @Select({
        "select",
        "id, team, ronda, name, athlete_begin_time, athlete_end_time, athlete_value, ",
        "audience_begin_time, audience_end_time, audience_value, score, athlete_status, ",
        "clearing_time",
        "from athlete_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="team", property="team", jdbcType=JdbcType.VARCHAR),
        @Result(column="ronda", property="ronda", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="athlete_begin_time", property="athleteBeginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="athlete_end_time", property="athleteEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="athlete_value", property="athleteValue", jdbcType=JdbcType.INTEGER),
        @Result(column="audience_begin_time", property="audienceBeginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audience_end_time", property="audienceEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audience_value", property="audienceValue", jdbcType=JdbcType.INTEGER),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="athlete_status", property="athleteStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="clearing_time", property="clearingTime", jdbcType=JdbcType.TIMESTAMP)
    })
    AthleteInfo selectByPrimaryKey(Integer id);

    /**
	* 
	* @param record
	* @param example
	* @return int
	*/
    @UpdateProvider(type=AthleteInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AthleteInfo record, @Param("example") AthleteInfoExample example);

    /**
	* 
	* @param record
	* @param example
	* @return int
	*/
    @UpdateProvider(type=AthleteInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AthleteInfo record, @Param("example") AthleteInfoExample example);

    /**
	* 
	* @param record
	* @return int
	*/
    @UpdateProvider(type=AthleteInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AthleteInfo record);

    /**
	* 
	* @param record
	* @return int
	*/
    @Update({
        "update athlete_info",
        "set team = #{team,jdbcType=VARCHAR},",
          "ronda = #{ronda,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "athlete_begin_time = #{athleteBeginTime,jdbcType=TIMESTAMP},",
          "athlete_end_time = #{athleteEndTime,jdbcType=TIMESTAMP},",
          "athlete_value = #{athleteValue,jdbcType=INTEGER},",
          "audience_begin_time = #{audienceBeginTime,jdbcType=TIMESTAMP},",
          "audience_end_time = #{audienceEndTime,jdbcType=TIMESTAMP},",
          "audience_value = #{audienceValue,jdbcType=INTEGER},",
          "score = #{score,jdbcType=INTEGER},",
          "athlete_status = #{athleteStatus,jdbcType=INTEGER},",
          "clearing_time = #{clearingTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AthleteInfo record);
}