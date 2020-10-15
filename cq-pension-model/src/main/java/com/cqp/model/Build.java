package com.cqp.model;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:Build构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="build")
public class Build implements Serializable{

	@Id
    @Column(name = "b_id")
	private Integer bid;//楼房编号

    @Column(name = "b_name")
	private String bname;//名称

    @Column(name = "fl_num")
	private Integer flNum;//层数

    @Column(name = "b_time")
	private Date btime;//建成时间

    @Column(name = "b_per")
	private String bper;//用途

    @Column(name = "dev_charge")
	private String devCharge;//建设负责人

    @Column(name = "b_charge")
	private String bcharge;//楼房负责人



	//get方法
	public Integer getBId() {
		return bid;
	}

	//set方法
	public void setBId(Integer bId) {
		this.bid = bId;
	}
	//get方法
	public String getBName() {
		return bname;
	}

	//set方法
	public void setBName(String bName) {
		this.bname = bName;
	}
	//get方法
	public Integer getFlNum() {
		return flNum;
	}

	//set方法
	public void setFlNum(Integer flNum) {
		this.flNum = flNum;
	}
	//get方法
	public Date getBTime() {
		return btime;
	}

	//set方法
	public void setBTime(Date bTime) {
		this.btime = bTime;
	}
	//get方法
	public String getBPer() {
		return bper;
	}

	//set方法
	public void setBPer(String bPer) {
		this.bper = bPer;
	}
	//get方法
	public String getDevCharge() {
		return devCharge;
	}

	//set方法
	public void setDevCharge(String devCharge) {
		this.devCharge = devCharge;
	}
	//get方法
	public String getBCharge() {
		return bcharge;
	}

	//set方法
	public void setBCharge(String bCharge) {
		this.bcharge = bCharge;
	}


}
