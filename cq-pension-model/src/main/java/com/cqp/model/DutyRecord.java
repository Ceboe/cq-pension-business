package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:DutyRecord构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="duty_record")
public class DutyRecord implements Serializable{

	@Id
    @Column(name = "dr_id")
	private Integer drId;//id

    @Column(name = "emp_id")
	private Integer empId;//值班员工编号

    @Column(name = "dr_time")
	private Date drTime;//值班时间

    @Column(name = "dr_ctime")
	private Date drCtime;//换班时间

    @Column(name = "dr_arrange")
	private String drArrange;//值班安排

    @Column(name = "dr_rem")
	private String drRem;//备注



	//get方法
	public Integer getDrId() {
		return drId;
	}

	//set方法
	public void setDrId(Integer drId) {
		this.drId = drId;
	}
	//get方法
	public Integer getEmpId() {
		return empId;
	}

	//set方法
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	//get方法
	public Date getDrTime() {
		return drTime;
	}

	//set方法
	public void setDrTime(Date drTime) {
		this.drTime = drTime;
	}
	//get方法
	public Date getDrCtime() {
		return drCtime;
	}

	//set方法
	public void setDrCtime(Date drCtime) {
		this.drCtime = drCtime;
	}
	//get方法
	public String getDrArrange() {
		return drArrange;
	}

	//set方法
	public void setDrArrange(String drArrange) {
		this.drArrange = drArrange;
	}
	//get方法
	public String getDrRem() {
		return drRem;
	}

	//set方法
	public void setDrRem(String drRem) {
		this.drRem = drRem;
	}


}
