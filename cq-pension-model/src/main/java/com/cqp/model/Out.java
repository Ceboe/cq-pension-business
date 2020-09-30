package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:Out构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="out")
public class Out implements Serializable{

	@Id
    @Column(name = "out_id")
	private Integer outId;//编号

    @Column(name = "op_id")
	private Integer opId;//老人编号

    @Column(name = "out_time")
	private Date outTime;//外出时间

    @Column(name = "predict_time")
	private Date predictTime;//预计回来时间

    @Column(name = "real_time")
	private Date realTime;//实际回来时间

    @Column(name = "out_reason")
	private String outReason;//外出原因

    @Column(name = "outfm_name")
	private String outfmName;//同意家属名

    @Column(name = "out_record")
	private String outRecord;//记录人

    @Column(name = "out_eaa")
	private String outEaa;//审批人



	//get方法
	public Integer getOutId() {
		return outId;
	}

	//set方法
	public void setOutId(Integer outId) {
		this.outId = outId;
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
	public Date getOutTime() {
		return outTime;
	}

	//set方法
	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}
	//get方法
	public Date getPredictTime() {
		return predictTime;
	}

	//set方法
	public void setPredictTime(Date predictTime) {
		this.predictTime = predictTime;
	}
	//get方法
	public Date getRealTime() {
		return realTime;
	}

	//set方法
	public void setRealTime(Date realTime) {
		this.realTime = realTime;
	}
	//get方法
	public String getOutReason() {
		return outReason;
	}

	//set方法
	public void setOutReason(String outReason) {
		this.outReason = outReason;
	}
	//get方法
	public String getOutfmName() {
		return outfmName;
	}

	//set方法
	public void setOutfmName(String outfmName) {
		this.outfmName = outfmName;
	}
	//get方法
	public String getOutRecord() {
		return outRecord;
	}

	//set方法
	public void setOutRecord(String outRecord) {
		this.outRecord = outRecord;
	}
	//get方法
	public String getOutEaa() {
		return outEaa;
	}

	//set方法
	public void setOutEaa(String outEaa) {
		this.outEaa = outEaa;
	}


}
