package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:Activity构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="activity")
public class Activity implements Serializable{

	@Id
    @Column(name = "act_id")
	private Integer actId;//活动id

    @Column(name = "act_name")
	private String actName;//活动名称

    @Column(name = "act_type")
	private String actType;//活动内容

    @Column(name = "act_content")
	private String actContent;//活动内容

    @Column(name = "act_place")
	private String actPlace;//活动地点

    @Column(name = "act_charge")
	private String actCharge;//负责人

    @Column(name = "act_btime")
	private Date actBtime;//开始时间

    @Column(name = "act_etime")
	private Date actEtime;//结束时间

    @Column(name = "act_rem")
	private String actRem;//备注



	//get方法
	public Integer getActId() {
		return actId;
	}

	//set方法
	public void setActId(Integer actId) {
		this.actId = actId;
	}
	//get方法
	public String getActName() {
		return actName;
	}

	//set方法
	public void setActName(String actName) {
		this.actName = actName;
	}
	//get方法
	public String getActType() {
		return actType;
	}

	//set方法
	public void setActType(String actType) {
		this.actType = actType;
	}
	//get方法
	public String getActContent() {
		return actContent;
	}

	//set方法
	public void setActContent(String actContent) {
		this.actContent = actContent;
	}
	//get方法
	public String getActPlace() {
		return actPlace;
	}

	//set方法
	public void setActPlace(String actPlace) {
		this.actPlace = actPlace;
	}
	//get方法
	public String getActCharge() {
		return actCharge;
	}

	//set方法
	public void setActCharge(String actCharge) {
		this.actCharge = actCharge;
	}
	//get方法
	public Date getActBtime() {
		return actBtime;
	}

	//set方法
	public void setActBtime(Date actBtime) {
		this.actBtime = actBtime;
	}
	//get方法
	public Date getActEtime() {
		return actEtime;
	}

	//set方法
	public void setActEtime(Date actEtime) {
		this.actEtime = actEtime;
	}
	//get方法
	public String getActRem() {
		return actRem;
	}

	//set方法
	public void setActRem(String actRem) {
		this.actRem = actRem;
	}


}
