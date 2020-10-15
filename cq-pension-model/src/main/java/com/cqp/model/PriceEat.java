package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:PriceEat构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="price_eat")
public class PriceEat implements Serializable{

	@Id
    @Column(name = "pe_id")
	private Integer peId;//套餐编号

    @Column(name = "mael")
	private String mael;//套餐名

    @Column(name = "feature")
	private String feature;//特点

    @Column(name = "pe_spec")
	private Integer peSpec;//规格编号

    @Column(name = "m_make")
	private String mmake;//套餐组成

    @Column(name = "m_person")
	private String mperson;//套餐配置人



	//get方法
	public Integer getPeId() {
		return peId;
	}

	//set方法
	public void setPeId(Integer peId) {
		this.peId = peId;
	}
	//get方法
	public String getMael() {
		return mael;
	}

	//set方法
	public void setMael(String mael) {
		this.mael = mael;
	}
	//get方法
	public String getFeature() {
		return feature;
	}

	//set方法
	public void setFeature(String feature) {
		this.feature = feature;
	}
	//get方法
	public Integer getPeSpec() {
		return peSpec;
	}

	//set方法
	public void setPeSpec(Integer peSpec) {
		this.peSpec = peSpec;
	}
	//get方法
	public String getMMake() {
		return mmake;
	}

	//set方法
	public void setMMake(String mmake) {
		this.mmake = mmake;
	}
	//get方法
	public String getMPerson() {
		return mperson;
	}

	//set方法
	public void setMPerson(String mPerson) {
		this.mperson = mPerson;
	}


}
