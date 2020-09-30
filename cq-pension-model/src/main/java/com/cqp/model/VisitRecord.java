package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:VisitRecord构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="visit_record")
public class VisitRecord implements Serializable{

	@Id
    @Column(name = "vr_id")
	private Integer vrId;//记录编号

    @Column(name = "vr_ttime")
	private Date vrTtime;//到访时间

    @Column(name = "vr_ltime")
	private Date vrLtime;//离开时间

    @Column(name = "vr_name")
	private String vrName;//姓名

    @Column(name = "vr_phone")
	private Integer vrPhone;//联系电话

    @Column(name = "vr_purpsoe")
	private String vrPurpsoe;//到访目的

    @Column(name = "vr_rem")
	private String vrRem;//备注

    @Column(name = "vr_dutyname")
	private Integer vrDutyname;//值班人员



	//get方法
	public Integer getVrId() {
		return vrId;
	}

	//set方法
	public void setVrId(Integer vrId) {
		this.vrId = vrId;
	}
	//get方法
	public Date getVrTtime() {
		return vrTtime;
	}

	//set方法
	public void setVrTtime(Date vrTtime) {
		this.vrTtime = vrTtime;
	}
	//get方法
	public Date getVrLtime() {
		return vrLtime;
	}

	//set方法
	public void setVrLtime(Date vrLtime) {
		this.vrLtime = vrLtime;
	}
	//get方法
	public String getVrName() {
		return vrName;
	}

	//set方法
	public void setVrName(String vrName) {
		this.vrName = vrName;
	}
	//get方法
	public Integer getVrPhone() {
		return vrPhone;
	}

	//set方法
	public void setVrPhone(Integer vrPhone) {
		this.vrPhone = vrPhone;
	}
	//get方法
	public String getVrPurpsoe() {
		return vrPurpsoe;
	}

	//set方法
	public void setVrPurpsoe(String vrPurpsoe) {
		this.vrPurpsoe = vrPurpsoe;
	}
	//get方法
	public String getVrRem() {
		return vrRem;
	}

	//set方法
	public void setVrRem(String vrRem) {
		this.vrRem = vrRem;
	}
	//get方法
	public Integer getVrDutyname() {
		return vrDutyname;
	}

	//set方法
	public void setVrDutyname(Integer vrDutyname) {
		this.vrDutyname = vrDutyname;
	}


}
