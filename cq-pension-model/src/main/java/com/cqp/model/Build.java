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
	private Integer bId;//楼房编号

    @Column(name = "b_name")
	private String bName;//名称

    @Column(name = "fl_num")
	private Integer flNum;//层数

    @Column(name = "b_time")
	private Date bTime;//建成时间

    @Column(name = "b_per")
	private String bPer;//用途

    @Column(name = "dev_charge")
	private String devCharge;//建设负责人

    @Column(name = "b_charge")
	private String bCharge;//楼房负责人



	//get方法
	public Integer getBId() {
		return bId;
	}

	//set方法
	public void setBId(Integer bId) {
		this.bId = bId;
	}
	//get方法
	public String getBName() {
		return bName;
	}

	//set方法
	public void setBName(String bName) {
		this.bName = bName;
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
		return bTime;
	}

	//set方法
	public void setBTime(Date bTime) {
		this.bTime = bTime;
	}
	//get方法
	public String getBPer() {
		return bPer;
	}

	//set方法
	public void setBPer(String bPer) {
		this.bPer = bPer;
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
		return bCharge;
	}

	//set方法
	public void setBCharge(String bCharge) {
		this.bCharge = bCharge;
	}


}
