package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:JoinAct构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="join_act")
public class JoinAct implements Serializable{

	@Id
    @Column(name = "ja_id")
	private Integer jaId;//id

    @Column(name = "act_id")
	private Integer actId;//活动id

    @Column(name = "act_name")
	private String actName;//活动名称

    @Column(name = "op_id")
	private Integer opId;//老人id



	//get方法
	public Integer getJaId() {
		return jaId;
	}

	//set方法
	public void setJaId(Integer jaId) {
		this.jaId = jaId;
	}
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
	public Integer getOpId() {
		return opId;
	}

	//set方法
	public void setOpId(Integer opId) {
		this.opId = opId;
	}


}
