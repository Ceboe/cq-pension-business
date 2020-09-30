package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:Employeemanage构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="employeemanage")
public class Employeemanage implements Serializable{

	@Id
    @Column(name = "emm_id")
	private Integer emmId;//就职编号

    @Column(name = "emp_id")
	private Integer empId;//员工编号

    @Column(name = "emm_job")
	private String emmJob;//职位

    @Column(name = "emm_inc")
	private String emmInc;//是否在职

    @Column(name = "emm_salary")
	private Double emmSalary;//资薪

    @Column(name = "emm_etime")
	private Date emmEtime;//入职时间

    @Column(name = "emm_dtime")
	private Date emmDtime;//离职时间



	//get方法
	public Integer getEmmId() {
		return emmId;
	}

	//set方法
	public void setEmmId(Integer emmId) {
		this.emmId = emmId;
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
	public String getEmmJob() {
		return emmJob;
	}

	//set方法
	public void setEmmJob(String emmJob) {
		this.emmJob = emmJob;
	}
	//get方法
	public String getEmmInc() {
		return emmInc;
	}

	//set方法
	public void setEmmInc(String emmInc) {
		this.emmInc = emmInc;
	}
	//get方法
	public Double getEmmSalary() {
		return emmSalary;
	}

	//set方法
	public void setEmmSalary(Double emmSalary) {
		this.emmSalary = emmSalary;
	}
	//get方法
	public Date getEmmEtime() {
		return emmEtime;
	}

	//set方法
	public void setEmmEtime(Date emmEtime) {
		this.emmEtime = emmEtime;
	}
	//get方法
	public Date getEmmDtime() {
		return emmDtime;
	}

	//set方法
	public void setEmmDtime(Date emmDtime) {
		this.emmDtime = emmDtime;
	}


}
