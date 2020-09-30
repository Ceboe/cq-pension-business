package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:PersonEat构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="person_eat")
public class PersonEat implements Serializable{

	@Id
    @Column(name = "pe_id")
	private Integer peId;//需求编号

    @Column(name = "op_id")
	private Integer opId;//老人编号

    @Column(name = "dishlike")
	private String dishlike;//忌口

    @Column(name = "habbit")
	private String habbit;//饮食编号

    @Column(name = "pe_rec")
	private String peRec;//记录人



	//get方法
	public Integer getPeId() {
		return peId;
	}

	//set方法
	public void setPeId(Integer peId) {
		this.peId = peId;
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
	public String getDishlike() {
		return dishlike;
	}

	//set方法
	public void setDishlike(String dishlike) {
		this.dishlike = dishlike;
	}
	//get方法
	public String getHabbit() {
		return habbit;
	}

	//set方法
	public void setHabbit(String habbit) {
		this.habbit = habbit;
	}
	//get方法
	public String getPeRec() {
		return peRec;
	}

	//set方法
	public void setPeRec(String peRec) {
		this.peRec = peRec;
	}


}
