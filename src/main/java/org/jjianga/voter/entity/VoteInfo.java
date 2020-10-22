package org.jjianga.voter.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
* 
* @author jjianga
* @date 2020-10-08
* 数据表vote_info映射bean，由Mybaits自动生成工具生成
*/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VoteInfo extends BestObject {
    /**
     * 主键
	* 列名:id 类型:INTEGER(10) 允许空:false 缺省值:null
     */
    private Integer id;

    /**
     * 报文主键
	* 列名:report_key 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String reportKey;

    /**
     * 设备编号
	* 列名:device_no 类型:VARCHAR(4) 允许空:true 缺省值:null
     */
    private String deviceNo;

    /**
     * 选手编号
	* 列名:player_no 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer playerNo;

    /**
     * 投票结果
	* 列名:result 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer result;

    /**
     * 投票时间
	* 列名:vote_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date voteTime;

    /**
     * 数据状态表
	* 列名:data_status 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer dataStatus;

    /**
     * 入库时间/创建时间
	* 列名:create_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportKey() {
        return reportKey;
    }

    public void setReportKey(String reportKey) {
        this.reportKey = reportKey == null ? null : reportKey.trim();
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo == null ? null : deviceNo.trim();
    }

    public Integer getPlayerNo() {
        return playerNo;
    }

    public void setPlayerNo(Integer playerNo) {
        this.playerNo = playerNo;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Date getVoteTime() {
        return voteTime;
    }

    public void setVoteTime(Date voteTime) {
        this.voteTime = voteTime;
    }

    public Integer getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}