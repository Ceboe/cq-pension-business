package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:Family构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="family")
public class Family implements Serializable{

	@Id
    @Column(name = "fm_id")
	private Integer fmId;//家属编号

    @Column(name = "op_id")
	private Integer opId;//老人编号

    @Column(name = "fm_name")
	private String fmName;//家属名字

    @Column(name = "fm_sex")
	private String fmSex;//性别

    @Column(name = "fm_phone")
	private Integer fmPhone;//联系电话

    @Column(name = "fm_address")
	private String fmAddress;//家庭地址

    @Column(name = "fm_office")
	private String fmOffice;//办公地址

    @Column(name = "fm_rel")
	private String fmRel;//亲属关系

    @Column(name = "fm_charge")
	private String fmCharge;//是否负责人

    @Column(name = "fm_record")
	private String fmRecord;//记录人



	//get方法
	public Integer getFmId() {
		return fmId;
	}

	//set方法
	public void setFmId(Integer fmId) {
		this.fmId = fmId;
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
	public String getFmName() {
		return fmName;
	}

	//set方法
	public void setFmName(String fmName) {
		this.fmName = fmName;
	}
	//get方法
	public String getFmSex() {
		return fmSex;
	}

	//set方法
	public void setFmSex(String fmSex) {
		this.fmSex = fmSex;
	}
	//get方法
	public Integer getFmPhone() {
		return fmPhone;
	}

	//set方法
	public void setFmPhone(Integer fmPhone) {
		this.fmPhone = fmPhone;
	}
	//get方法
	public String getFmAddress() {
		return fmAddress;
	}

	//set方法
	public void setFmAddress(String fmAddress) {
		this.fmAddress = fmAddress;
	}
	//get方法
	public String getFmOffice() {
		return fmOffice;
	}

	//set方法
	public void setFmOffice(String fmOffice) {
		this.fmOffice = fmOffice;
	}
	//get方法
	public String getFmRel() {
		return fmRel;
	}

	//set方法
	public void setFmRel(String fmRel) {
		this.fmRel = fmRel;
	}
	//get方法
	public String getFmCharge() {
		return fmCharge;
	}

	//set方法
	public void setFmCharge(String fmCharge) {
		this.fmCharge = fmCharge;
	}
	//get方法
	public String getFmRecord() {
		return fmRecord;
	}

	//set方法
	public void setFmRecord(String fmRecord) {
		this.fmRecord = fmRecord;
	}


}
