package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:IllRecord构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="ill_record")
public class IllRecord implements Serializable{

	@Id
    @Column(name = "ill_id")
	private Integer illId;//id

    @Column(name = "op_id")
	private Integer opId;//老人id

    @Column(name = "ill_dis")
	private String illDis;//疾病

    @Column(name = "ill_time")
	private Date illTime;//生病时间

    @Column(name = "med_mech")
	private String medMech;//就诊机构

    @Column(name = "reco_time")
	private Date recoTime;//痊愈时间

    @Column(name = "ill_attention")
	private String illAttention;//注意事项

    @Column(name = "ill_rec")
	private String illRec;//记录人



	//get方法
	public Integer getIllId() {
		return illId;
	}

	//set方法
	public void setIllId(Integer illId) {
		this.illId = illId;
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
	public String getIllDis() {
		return illDis;
	}

	//set方法
	public void setIllDis(String illDis) {
		this.illDis = illDis;
	}
	//get方法
	public Date getIllTime() {
		return illTime;
	}

	//set方法
	public void setIllTime(Date illTime) {
		this.illTime = illTime;
	}
	//get方法
	public String getMedMech() {
		return medMech;
	}

	//set方法
	public void setMedMech(String medMech) {
		this.medMech = medMech;
	}
	//get方法
	public Date getRecoTime() {
		return recoTime;
	}

	//set方法
	public void setRecoTime(Date recoTime) {
		this.recoTime = recoTime;
	}
	//get方法
	public String getIllAttention() {
		return illAttention;
	}

	//set方法
	public void setIllAttention(String illAttention) {
		this.illAttention = illAttention;
	}
	//get方法
	public String getIllRec() {
		return illRec;
	}

	//set方法
	public void setIllRec(String illRec) {
		this.illRec = illRec;
	}


}
