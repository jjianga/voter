package org.jjianga.voter.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
* 
* @author jjianga
* @date 2020-10-08
* 数据表athlete_info映射bean，由Mybaits自动生成工具生成
*/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AthleteInfo extends BestObject {
    /**
     * 主键
	* 列名:id 类型:INTEGER(10) 允许空:false 缺省值:null
     */
    private Integer id;

    /**
     * 队伍
	* 列名:team 类型:VARCHAR(20) 允许空:true 缺省值:null
     */
    private String team;

    /**
     * 场次
	* 列名:ronda 类型:VARCHAR(20) 允许空:true 缺省值:null
     */
    private String ronda;

    /**
     * 选手姓名
	* 列名:name 类型:VARCHAR(20) 允许空:true 缺省值:null
     */
    private String name;

    /**
     * 选手投票开始时间
	* 列名:athlete_begin_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date athleteBeginTime;

    /**
     * 选手投票结束时间
	* 列名:athlete_end_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date athleteEndTime;

    /**
     * 选手自评分数
	* 列名:athlete_value 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer athleteValue;

    /**
     * 观众投票开始时间
	* 列名:audience_begin_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date audienceBeginTime;

    /**
     * 观众投票结束时间
	* 列名:audience_end_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date audienceEndTime;

    /**
     * 观众评分数
	* 列名:audience_value 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer audienceValue;

    /**
     * 差异分
	* 列名:score 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer score;

    /**
     * 选手状态
	* 列名:athlete_status 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer athleteStatus;

    /**
     * 数据清算时间
	* 列名:clearing_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date clearingTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team == null ? null : team.trim();
    }

    public String getRonda() {
        return ronda;
    }

    public void setRonda(String ronda) {
        this.ronda = ronda == null ? null : ronda.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getAthleteBeginTime() {
        return athleteBeginTime;
    }

    public void setAthleteBeginTime(Date athleteBeginTime) {
        this.athleteBeginTime = athleteBeginTime;
    }

    public Date getAthleteEndTime() {
        return athleteEndTime;
    }

    public void setAthleteEndTime(Date athleteEndTime) {
        this.athleteEndTime = athleteEndTime;
    }

    public Integer getAthleteValue() {
        return athleteValue;
    }

    public void setAthleteValue(Integer athleteValue) {
        this.athleteValue = athleteValue;
    }

    public Date getAudienceBeginTime() {
        return audienceBeginTime;
    }

    public void setAudienceBeginTime(Date audienceBeginTime) {
        this.audienceBeginTime = audienceBeginTime;
    }

    public Date getAudienceEndTime() {
        return audienceEndTime;
    }

    public void setAudienceEndTime(Date audienceEndTime) {
        this.audienceEndTime = audienceEndTime;
    }

    public Integer getAudienceValue() {
        return audienceValue;
    }

    public void setAudienceValue(Integer audienceValue) {
        this.audienceValue = audienceValue;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getAthleteStatus() {
        return athleteStatus;
    }

    public void setAthleteStatus(Integer athleteStatus) {
        this.athleteStatus = athleteStatus;
    }

    public Date getClearingTime() {
        return clearingTime;
    }

    public void setClearingTime(Date clearingTime) {
        this.clearingTime = clearingTime;
    }
}