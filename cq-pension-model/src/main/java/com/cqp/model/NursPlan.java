package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:NursPlan构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="nurs_plan")
public class NursPlan implements Serializable{

	@Id
    @Column(name = "n_id")
	private Integer nId;//计划编号

    @Column(name = "op_id")
	private Integer opId;//老人编号

    @Column(name = "np_level")
	private Integer npLevel;//护理等级

    @Column(name = "description")
	private String description;//描述

    @Column(name = "adda_addr")
	private String addaAddr;//附件地址

    @Column(name = "note_taker")
	private String noteTaker;//记录人

    @Column(name = "remark")
	private String remark;//备注



	//get方法
	public Integer getNId() {
		return nId;
	}

	//set方法
	public void setNId(Integer nId) {
		this.nId = nId;
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
	public Integer getNpLevel() {
		return npLevel;
	}

	//set方法
	public void setNpLevel(Integer npLevel) {
		this.npLevel = npLevel;
	}
	//get方法
	public String getDescription() {
		return description;
	}

	//set方法
	public void setDescription(String description) {
		this.description = description;
	}
	//get方法
	public String getAddaAddr() {
		return addaAddr;
	}

	//set方法
	public void setAddaAddr(String addaAddr) {
		this.addaAddr = addaAddr;
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
