package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:HealAss构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="heal_ass")
public class HealAss implements Serializable{

	@Id
    @Column(name = "ha_id")
	private Integer haId;//id

    @Column(name = "op_id")
	private Integer opId;//老人id

    @Column(name = "ha_num")
	private Integer haNum;//评估单号

    @Column(name = "ha_type")
	private String haType;//评估类型

    @Column(name = "ha_time")
	private Date haTime;//评估时间

    @Column(name = "ha_level")
	private String haLevel;//建议护理级别

    @Column(name = "live_ass")
	private String liveAss;//入住评估

    @Column(name = "ha_person")
	private String haPerson;//评估人

    @Column(name = "ha_eye")
	private String haEye;//视力障碍

    @Column(name = "ha_ear")
	private String haEar;//听力障碍

    @Column(name = "ha_mood")
	private String haMood;//精神状态

    @Column(name = "ha_move")
	private String haMove;//行动能力

    @Column(name = "ha_talk")
	private String haTalk;//交流能力

    @Column(name = "ha_limbs")
	private String haLimbs;//肢体能力

    @Column(name = "ha_daily")
	private String haDaily;//日常生活能力

    @Column(name = "ha_eat")
	private String haEat;//饮食障碍

    @Column(name = "ha_med")
	private String haMed;//药物过敏

    @Column(name = "ha_rec")
	private String haRec;//记录人



	//get方法
	public Integer getHaId() {
		return haId;
	}

	//set方法
	public void setHaId(Integer haId) {
		this.haId = haId;
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
	public Integer getHaNum() {
		return haNum;
	}

	//set方法
	public void setHaNum(Integer haNum) {
		this.haNum = haNum;
	}
	//get方法
	public String getHaType() {
		return haType;
	}

	//set方法
	public void setHaType(String haType) {
		this.haType = haType;
	}
	//get方法
	public Date getHaTime() {
		return haTime;
	}

	//set方法
	public void setHaTime(Date haTime) {
		this.haTime = haTime;
	}
	//get方法
	public String getHaLevel() {
		return haLevel;
	}

	//set方法
	public void setHaLevel(String haLevel) {
		this.haLevel = haLevel;
	}
	//get方法
	public String getLiveAss() {
		return liveAss;
	}

	//set方法
	public void setLiveAss(String liveAss) {
		this.liveAss = liveAss;
	}
	//get方法
	public String getHaPerson() {
		return haPerson;
	}

	//set方法
	public void setHaPerson(String haPerson) {
		this.haPerson = haPerson;
	}
	//get方法
	public String getHaEye() {
		return haEye;
	}

	//set方法
	public void setHaEye(String haEye) {
		this.haEye = haEye;
	}
	//get方法
	public String getHaEar() {
		return haEar;
	}

	//set方法
	public void setHaEar(String haEar) {
		this.haEar = haEar;
	}
	//get方法
	public String getHaMood() {
		return haMood;
	}

	//set方法
	public void setHaMood(String haMood) {
		this.haMood = haMood;
	}
	//get方法
	public String getHaMove() {
		return haMove;
	}

	//set方法
	public void setHaMove(String haMove) {
		this.haMove = haMove;
	}
	//get方法
	public String getHaTalk() {
		return haTalk;
	}

	//set方法
	public void setHaTalk(String haTalk) {
		this.haTalk = haTalk;
	}
	//get方法
	public String getHaLimbs() {
		return haLimbs;
	}

	//set方法
	public void setHaLimbs(String haLimbs) {
		this.haLimbs = haLimbs;
	}
	//get方法
	public String getHaDaily() {
		return haDaily;
	}

	//set方法
	public void setHaDaily(String haDaily) {
		this.haDaily = haDaily;
	}
	//get方法
	public String getHaEat() {
		return haEat;
	}

	//set方法
	public void setHaEat(String haEat) {
		this.haEat = haEat;
	}
	//get方法
	public String getHaMed() {
		return haMed;
	}

	//set方法
	public void setHaMed(String haMed) {
		this.haMed = haMed;
	}
	//get方法
	public String getHaRec() {
		return haRec;
	}

	//set方法
	public void setHaRec(String haRec) {
		this.haRec = haRec;
	}


}
