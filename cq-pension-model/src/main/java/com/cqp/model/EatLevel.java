package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:EatLevel构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="eat_level")
public class EatLevel implements Serializable{

	@Id
    @Column(name = "el_id")
	private Integer elId;//规格编号

    @Column(name = "el_des")
	private String elDes;//描述

    @Column(name = "el_price")
	private String elPrice;//价格

    @Column(name = "note_taker")
	private String noteTaker;//记录人



	//get方法
	public Integer getElId() {
		return elId;
	}

	//set方法
	public void setElId(Integer elId) {
		this.elId = elId;
	}
	//get方法
	public String getElDes() {
		return elDes;
	}

	//set方法
	public void setElDes(String elDes) {
		this.elDes = elDes;
	}
	//get方法
	public String getElPrice() {
		return elPrice;
	}

	//set方法
	public void setElPrice(String elPrice) {
		this.elPrice = elPrice;
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
