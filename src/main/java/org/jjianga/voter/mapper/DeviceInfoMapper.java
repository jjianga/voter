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
import org.jjianga.voter.entity.DeviceInfo;
import org.jjianga.voter.entity.DeviceInfoExample;

public interface DeviceInfoMapper {
    /**
	* 
	* @param example
	* @return long
	*/
    @SelectProvider(type=DeviceInfoSqlProvider.class, method="countByExample")
    long countByExample(DeviceInfoExample example);

    /**
	* 
	* @param example
	* @return int
	*/
    @DeleteProvider(type=DeviceInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(DeviceInfoExample example);

    /**
	* 
	* @param id
	* @return int
	*/
    @Delete({
        "delete from device_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
	* 
	* @param record
	* @return int
	*/
    @Insert({
        "insert into device_info (id, ronda, ",
        "group_device, sum, ",
        "offer, begin_no, ",
        "end_no)",
        "values (#{id,jdbcType=INTEGER}, #{ronda,jdbcType=VARCHAR}, ",
        "#{groupDevice,jdbcType=VARCHAR}, #{sum,jdbcType=INTEGER}, ",
        "#{offer,jdbcType=INTEGER}, #{beginNo,jdbcType=VARCHAR}, ",
        "#{endNo,jdbcType=VARCHAR})"
    })
    int insert(DeviceInfo record);

    /**
	* 
	* @param record
	* @return int
	*/
    @InsertProvider(type=DeviceInfoSqlProvider.class, method="insertSelective")
    int insertSelective(DeviceInfo record);

    /**
	* 
	* @param example
	* @return java.util.List<org.jjianga.voter.entity.DeviceInfo>
	*/
    @SelectProvider(type=DeviceInfoSqlProvider.class, method="selectByExample")
    @Results(value={
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ronda", property="ronda", jdbcType=JdbcType.VARCHAR),
        @Result(column="group_device", property="groupDevice", jdbcType=JdbcType.VARCHAR),
        @Result(column="sum", property="sum", jdbcType=JdbcType.INTEGER),
        @Result(column="offer", property="offer", jdbcType=JdbcType.INTEGER),
        @Result(column="begin_no", property="beginNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="end_no", property="endNo", jdbcType=JdbcType.VARCHAR)
    },id="deviceInfo")
    List<DeviceInfo> selectByExample(DeviceInfoExample example);

    /**
	* 
	* @param id
	* @return org.jjianga.voter.entity.DeviceInfo
	*/
    @Select({
        "select",
        "id, ronda, group_device, sum, offer, begin_no, end_no",
        "from device_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ronda", property="ronda", jdbcType=JdbcType.VARCHAR),
        @Result(column="group_device", property="groupDevice", jdbcType=JdbcType.VARCHAR),
        @Result(column="sum", property="sum", jdbcType=JdbcType.INTEGER),
        @Result(column="offer", property="offer", jdbcType=JdbcType.INTEGER),
        @Result(column="begin_no", property="beginNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="end_no", property="endNo", jdbcType=JdbcType.VARCHAR)
    })
    DeviceInfo selectByPrimaryKey(Integer id);

    /**
	* 
	* @param record
	* @param example
	* @return int
	*/
    @UpdateProvider(type=DeviceInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") DeviceInfo record, @Param("example") DeviceInfoExample example);

    /**
	* 
	* @param record
	* @param example
	* @return int
	*/
    @UpdateProvider(type=DeviceInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") DeviceInfo record, @Param("example") DeviceInfoExample example);

    /**
	* 
	* @param record
	* @return int
	*/
    @UpdateProvider(type=DeviceInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(DeviceInfo record);

    /**
	* 
	* @param record
	* @return int
	*/
    @Update({
        "update device_info",
        "set ronda = #{ronda,jdbcType=VARCHAR},",
          "group_device = #{groupDevice,jdbcType=VARCHAR},",
          "sum = #{sum,jdbcType=INTEGER},",
          "offer = #{offer,jdbcType=INTEGER},",
          "begin_no = #{beginNo,jdbcType=VARCHAR},",
          "end_no = #{endNo,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DeviceInfo record);
}