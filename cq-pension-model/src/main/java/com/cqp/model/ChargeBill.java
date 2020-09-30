package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:ChargeBill构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="charge_bill")
public class ChargeBill implements Serializable{

	@Id
    @Column(name = "cb_id")
	private Integer cbId;//收费单号

    @Column(name = "op_id")
	private Integer opId;//老人编号

    @Column(name = "cb_time")
	private Date cbTime;//收费时间

    @Column(name = "charg_esti")
	private String chargEsti;//预计收费

    @Column(name = "charg_act")
	private String chargAct;//待付金额

    @Column(name = "pay_method")
	private String payMethod;//支付方式

    @Column(name = "note_taker")
	private String noteTaker;//记录员

    @Column(name = "cb_rem")
	private String cbRem;//备注



	//get方法
	public Integer getCbId() {
		return cbId;
	}

	//set方法
	public void setCbId(Integer cbId) {
		this.cbId = cbId;
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
	public Date getCbTime() {
		return cbTime;
	}

	//set方法
	public void setCbTime(Date cbTime) {
		this.cbTime = cbTime;
	}
	//get方法
	public String getChargEsti() {
		return chargEsti;
	}

	//set方法
	public void setChargEsti(String chargEsti) {
		this.chargEsti = chargEsti;
	}
	//get方法
	public String getChargAct() {
		return chargAct;
	}

	//set方法
	public void setChargAct(String chargAct) {
		this.chargAct = chargAct;
	}
	//get方法
	public String getPayMethod() {
		return payMethod;
	}

	//set方法
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
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
	public String getCbRem() {
		return cbRem;
	}

	//set方法
	public void setCbRem(String cbRem) {
		this.cbRem = cbRem;
	}


}
