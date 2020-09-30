package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:PhyExam构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="phy_exam")
public class PhyExam implements Serializable{

	@Id
    @Column(name = "pe_id")
	private Integer peId;//记录编号

    @Column(name = "op_id")
	private Integer opId;//老人ID

    @Column(name = "pe_form")
	private String peForm;//体检单

    @Column(name = "pe_hos")
	private String peHos;//体检医院

    @Column(name = "pe_type")
	private String peType;//体检类型

    @Column(name = "pe_time")
	private Date peTime;//体检时间

    @Column(name = "pe_charge")
	private String peCharge;//体检负责人

    @Column(name = "pe_rec")
	private String peRec;//记录人

    @Column(name = "pe_rem")
	private String peRem;//备注



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
	public String getPeForm() {
		return peForm;
	}

	//set方法
	public void setPeForm(String peForm) {
		this.peForm = peForm;
	}
	//get方法
	public String getPeHos() {
		return peHos;
	}

	//set方法
	public void setPeHos(String peHos) {
		this.peHos = peHos;
	}
	//get方法
	public String getPeType() {
		return peType;
	}

	//set方法
	public void setPeType(String peType) {
		this.peType = peType;
	}
	//get方法
	public Date getPeTime() {
		return peTime;
	}

	//set方法
	public void setPeTime(Date peTime) {
		this.peTime = peTime;
	}
	//get方法
	public String getPeCharge() {
		return peCharge;
	}

	//set方法
	public void setPeCharge(String peCharge) {
		this.peCharge = peCharge;
	}
	//get方法
	public String getPeRec() {
		return peRec;
	}

	//set方法
	public void setPeRec(String peRec) {
		this.peRec = peRec;
	}
	//get方法
	public String getPeRem() {
		return peRem;
	}

	//set方法
	public void setPeRem(String peRem) {
		this.peRem = peRem;
	}


}
