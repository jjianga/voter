package org.jjianga.voter.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
* 
* @author jjianga
* @date 2020-10-08
* 数据表device_info映射bean，由Mybaits自动生成工具生成
*/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeviceInfo extends BestObject {
    /**
     * 主键
	* 列名:id 类型:INTEGER(10) 允许空:false 缺省值:null
     */
    private Integer id;

    /**
     * 场次
	* 列名:ronda 类型:VARCHAR(4) 允许空:true 缺省值:null
     */
    private String ronda;

    /**
     * 设备分类
	* 列名:group_device 类型:VARCHAR(20) 允许空:true 缺省值:null
     */
    private String groupDevice;

    /**
     * 设备总数
	* 列名:sum 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer sum;

    /**
     * 发送数量
	* 列名:offer 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer offer;

    /**
     * 设备开始编号
	* 列名:begin_no 类型:VARCHAR(4) 允许空:true 缺省值:null
     */
    private String beginNo;

    /**
     * 设备结束编号
	* 列名:end_no 类型:VARCHAR(4) 允许空:true 缺省值:null
     */
    private String endNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRonda() {
        return ronda;
    }

    public void setRonda(String ronda) {
        this.ronda = ronda == null ? null : ronda.trim();
    }

    public String getGroupDevice() {
        return groupDevice;
    }

    public void setGroupDevice(String groupDevice) {
        this.groupDevice = groupDevice == null ? null : groupDevice.trim();
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getOffer() {
        return offer;
    }

    public void setOffer(Integer offer) {
        this.offer = offer;
    }

    public String getBeginNo() {
        return beginNo;
    }

    public void setBeginNo(String beginNo) {
        this.beginNo = beginNo == null ? null : beginNo.trim();
    }

    public String getEndNo() {
        return endNo;
    }

    public void setEndNo(String endNo) {
        this.endNo = endNo == null ? null : endNo.trim();
    }
}