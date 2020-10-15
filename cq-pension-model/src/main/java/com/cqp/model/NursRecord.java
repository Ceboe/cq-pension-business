package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:NursRecord构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="nurs_record")
public class NursRecord implements Serializable{

	@Id
    @Column(name = "n_id")
	private Integer nid;//记录编号

    @Column(name = "op_id")
	private Integer opId;//老人编号

    @Column(name = "start_time")
	private Date startTime;//开始时间

    @Column(name = "end_time")
	private Date endTime;//结束时间

    @Column(name = "np_id")
	private Integer npId;//护理项编号

    @Column(name = "nn_des")
	private String nnDes;//详细描述

    @Column(name = "result")
	private String result;//护理结果

    @Column(name = "nurse")
	private String nurse;//执行护工

    @Column(name = "note_taker")
	private String noteTaker;//记录人

    @Column(name = "remark")
	private String remark;//备注



	//get方法
	public Integer getNId() {
		return nid;
	}

	//set方法
	public void setNId(Integer nId) {
		this.nid = nId;
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
	public Date getStartTime() {
		return startTime;
	}

	//set方法
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	//get方法
	public Date getEndTime() {
		return endTime;
	}

	//set方法
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	//get方法
	public Integer getNpId() {
		return npId;
	}

	//set方法
	public void setNpId(Integer npId) {
		this.npId = npId;
	}
	//get方法
	public String getNnDes() {
		return nnDes;
	}

	//set方法
	public void setNnDes(String nnDes) {
		this.nnDes = nnDes;
	}
	//get方法
	public String getResult() {
		return result;
	}

	//set方法
	public void setResult(String result) {
		this.result = result;
	}
	//get方法
	public String getNurse() {
		return nurse;
	}

	//set方法
	public void setNurse(String nurse) {
		this.nurse = nurse;
	}
	//get方法
	public String getNoteTaker() {
		return noteTaker;
	}

	//set方法
	public void setNoteTaker(String noteTaker) {
		this.noteTaker = noteTaker;
	}
	//get方法
	public String getRemark() {
		return remark;
	}

	//set方法
	public void setRemark(String remark) {
		this.remark = remark;
	}


}
