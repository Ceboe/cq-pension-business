package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:Refund构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="refund")
public class Refund implements Serializable{

	@Id
    @Column(name = "re_id")
	private Integer reId;//退费编号

    @Column(name = "op_id")
	private Integer opId;//老人编号

    @Column(name = "re_status")
	private String reStatus;//退费状态

    @Column(name = "re_time")
	private Date reTime;//退费时间

    @Column(name = "re_money")
	private String reMoney;//退费金额

    @Column(name = "re_method")
	private String reMethod;//退费方式

    @Column(name = "note_taker")
	private String noteTaker;//记录员



	//get方法
	public Integer getReId() {
		return reId;
	}

	//set方法
	public void setReId(Integer reId) {
		this.reId = reId;
	}
	//get方法
	public Integer getOpId() {
		return opId;
	}

	//set方法
	public void setOpId(Integer opId) {
		this.opId = opId;
	}
	//get方法
	public String getReStatus() {
		return reStatus;
	}

	//set方法
	public void setReStatus(String reStatus) {
		this.reStatus = reStatus;
	}
	//get方法
	public Date getReTime() {
		return reTime;
	}

	//set方法
	public void setReTime(Date reTime) {
		this.reTime = reTime;
	}
	//get方法
	public String getReMoney() {
		return reMoney;
	}

	//set方法
	public void setReMoney(String reMoney) {
		this.reMoney = reMoney;
	}
	//get方法
	public String getReMethod() {
		return reMethod;
	}

	//set方法
	public void setReMethod(String reMethod) {
		this.reMethod = reMethod;
	}
	//get方法
	public String getNoteTaker() {
		return noteTaker;
	}

	//set方法
	public void setNoteTaker(String noteTaker) {
		this.noteTaker = noteTaker;
	}


}
