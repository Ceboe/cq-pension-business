package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:Kitchen构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="kitchen")
public class Kitchen implements Serializable{

	@Id
    @Column(name = "k_id")
	private Integer kId;//菜品编号

    @Column(name = "time")
	private Date time;//时间

    @Column(name = "dish_name")
	private String dishName;//菜品名

    @Column(name = "dish_make")
	private String dishMake;//菜品组成

    @Column(name = "dish_mix")
	private String dishMix;//菜品配料

    @Column(name = "cooker")
	private String cooker;//厨师

    @Column(name = "charge")
	private String charge;//厨房负责人

    @Column(name = "recorder")
	private String recorder;//记录人



	//get方法
	public Integer getKId() {
		return kId;
	}

	//set方法
	public void setKId(Integer kId) {
		this.kId = kId;
	}
	//get方法
	public Date getTime() {
		return time;
	}

	//set方法
	public void setTime(Date time) {
		this.time = time;
	}
	//get方法
	public String getDishName() {
		return dishName;
	}

	//set方法
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	//get方法
	public String getDishMake() {
		return dishMake;
	}

	//set方法
	public void setDishMake(String dishMake) {
		this.dishMake = dishMake;
	}
	//get方法
	public String getDishMix() {
		return dishMix;
	}

	//set方法
	public void setDishMix(String dishMix) {
		this.dishMix = dishMix;
	}
	//get方法
	public String getCooker() {
		return cooker;
	}

	//set方法
	public void setCooker(String cooker) {
		this.cooker = cooker;
	}
	//get方法
	public String getCharge() {
		return charge;
	}

	//set方法
	public void setCharge(String charge) {
		this.charge = charge;
	}
	//get方法
	public String getRecorder() {
		return recorder;
	}

	//set方法
	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}


}
