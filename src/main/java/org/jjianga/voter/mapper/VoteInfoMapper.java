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
import org.jjianga.voter.entity.VoteInfo;
import org.jjianga.voter.entity.VoteInfoExample;
import org.jjianga.voter.mapper.custom.BestVoteInfoMapper;

public interface VoteInfoMapper extends BestVoteInfoMapper {
    /**
	* 
	* @param example
	* @return long
	*/
    @SelectProvider(type=VoteInfoSqlProvider.class, method="countByExample")
    long countByExample(VoteInfoExample example);

    /**
	* 
	* @param example
	* @return int
	*/
    @DeleteProvider(type=VoteInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(VoteInfoExample example);

    /**
	* 
	* @param id
	* @return int
	*/
    @Delete({
        "delete from vote_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
	* 
	* @param record
	* @return int
	*/
    @Insert({
        "insert into vote_info (id, report_key, ",
        "device_no, player_no, ",
        "result, vote_time, ",
        "data_status, create_time)",
        "values (#{id,jdbcType=INTEGER}, #{reportKey,jdbcType=VARCHAR}, ",
        "#{deviceNo,jdbcType=VARCHAR}, #{playerNo,jdbcType=INTEGER}, ",
        "#{result,jdbcType=INTEGER}, #{voteTime,jdbcType=TIMESTAMP}, ",
        "#{dataStatus,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(VoteInfo record);

    /**
	* 
	* @param record
	* @return int
	*/
    @InsertProvider(type=VoteInfoSqlProvider.class, method="insertSelective")
    int insertSelective(VoteInfo record);

    /**
	* 
	* @param example
	* @return java.util.List<org.jjianga.voter.entity.VoteInfo>
	*/
    @SelectProvider(type=VoteInfoSqlProvider.class, method="selectByExample")
    @Results(value={
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="report_key", property="reportKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="device_no", property="deviceNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="player_no", property="playerNo", jdbcType=JdbcType.INTEGER),
        @Result(column="result", property="result", jdbcType=JdbcType.INTEGER),
        @Result(column="vote_time", property="voteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    },id="voteInfo")
    List<VoteInfo> selectByExample(VoteInfoExample example);

    /**
	* 
	* @param id
	* @return org.jjianga.voter.entity.VoteInfo
	*/
    @Select({
        "select",
        "id, report_key, device_no, player_no, result, vote_time, data_status, create_time",
        "from vote_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="report_key", property="reportKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="device_no", property="deviceNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="player_no", property="playerNo", jdbcType=JdbcType.INTEGER),
        @Result(column="result", property="result", jdbcType=JdbcType.INTEGER),
        @Result(column="vote_time", property="voteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    VoteInfo selectByPrimaryKey(Integer id);

    /**
	* 
	* @param record
	* @param example
	* @return int
	*/
    @UpdateProvider(type=VoteInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VoteInfo record, @Param("example") VoteInfoExample example);

    /**
	* 
	* @param record
	* @param example
	* @return int
	*/
    @UpdateProvider(type=VoteInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VoteInfo record, @Param("example") VoteInfoExample example);

    /**
	* 
	* @param record
	* @return int
	*/
    @UpdateProvider(type=VoteInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VoteInfo record);

    /**
	* 
	* @param record
	* @return int
	*/
    @Update({
        "update vote_info",
        "set report_key = #{reportKey,jdbcType=VARCHAR},",
          "device_no = #{deviceNo,jdbcType=VARCHAR},",
          "player_no = #{playerNo,jdbcType=INTEGER},",
          "result = #{result,jdbcType=INTEGER},",
          "vote_time = #{voteTime,jdbcType=TIMESTAMP},",
          "data_status = #{dataStatus,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(VoteInfo record);
}