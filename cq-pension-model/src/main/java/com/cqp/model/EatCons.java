package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:EatCons构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="eat_cons")
public class EatCons implements Serializable{

	@Id
    @Column(name = "ec_id")
	private Integer ecId;//消费记录编号

    @Column(name = "op_id")
	private Integer opId;//老人编号

    @Column(name = "cb_id")
	private Integer cbId;//收费单号

    @Column(name = "cons_time")
	private Date consTime;//消费时间

    @Column(name = "pe_id")
	private Integer peId;//套餐编号

    @Column(name = "pe_price")
	private String pePrice;//消费金额

    @Column(name = "ec_status")
	private String ecStatus;//支付状态



	//get方法
	public Integer getEcId() {
		return ecId;
	}

	//set方法
	public void setEcId(Integer ecId) {
		this.ecId = ecId;
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
	public Integer getCbId() {
		return cbId;
	}

	//set方法
	public void setCbId(Integer cbId) {
		this.cbId = cbId;
	}
	//get方法
	public Date getConsTime() {
		return consTime;
	}

	//set方法
	public void setConsTime(Date consTime) {
		this.consTime = consTime;
	}
	//get方法
	public Integer getPeId() {
		return peId;
	}

	//set方法
	public void setPeId(Integer peId) {
		this.peId = peId;
	}
	//get方法
	public String getPePrice() {
		return pePrice;
	}

	//set方法
	public void setPePrice(String pePrice) {
		this.pePrice = pePrice;
	}
	//get方法
	public String getEcStatus() {
		return ecStatus;
	}

	//set方法
	public void setEcStatus(String ecStatus) {
		this.ecStatus = ecStatus;
	}


}
