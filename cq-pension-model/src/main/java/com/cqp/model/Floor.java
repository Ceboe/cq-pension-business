package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:Floor构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="floor")
public class Floor implements Serializable{

	@Id
    @Column(name = "fl_id")
	private Integer flId;//楼层编号

    @Column(name = "b_id")
	private Integer bid;//楼房编号

    @Column(name = "r_num")
	private Integer rnum;//房间数量

    @Column(name = "fl_name")
	private String flName;//楼层名称

    @Column(name = "fl_charge")
	private String flCharge;//楼层负责人



	//get方法
	public Integer getFlId() {
		return flId;
	}

	//set方法
	public void setFlId(Integer flId) {
		this.flId = flId;
	}
	//get方法
	public Integer getBId() {
		return bid;
	}

	//set方法
	public void setBId(Integer bId) {
		this.bid = bId;
	}
	//get方法
	public Integer getRNum() {
		return rnum;
	}

	//set方法
	public void setRNum(Integer rNum) {
		this.rnum = rNum;
	}
	//get方法
	public String getFlName() {
		return flName;
	}

	//set方法
	public void setFlName(String flName) {
		this.flName = flName;
	}
	//get方法
	public String getFlCharge() {
		return flCharge;
	}

	//set方法
	public void setFlCharge(String flCharge) {
		this.flCharge = flCharge;
	}


}
