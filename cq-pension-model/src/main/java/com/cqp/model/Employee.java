package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:Employee构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="employee")
public class Employee implements Serializable{

	@Id
    @Column(name = "emp_id")
	private Integer empId;//员工编号

    @Column(name = "emp_name")
	private String empName;//姓名

    @Column(name = "emp_sex")
	private String empSex;//性别

    @Column(name = "emp_birthday")
	private Integer empBirthday;//年龄

    @Column(name = "emp_phone")
	private Date empPhone;//电话

    @Column(name = "emp_email")
	private Integer empEmail;//电子邮件

    @Column(name = "emp_add")
	private String empAdd;//地址

    @Column(name = "emp_photo")
	private String empPhoto;//照片

    @Column(name = "emp_native")
	private String empNative;//籍贯

    @Column(name = "emp_marry")
	private String empMarry;//是否婚配

    @Column(name = "emp_major")
	private String empMajor;//专业

    @Column(name = "emp_card")
	private String empCard;//身份证号

    @Column(name = "emp_")
	private String emp;//



	//get方法
	public Integer getEmpId() {
		return empId;
	}

	//set方法
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	//get方法
	public String getEmpName() {
		return empName;
	}

	//set方法
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	//get方法
	public String getEmpSex() {
		return empSex;
	}

	//set方法
	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}
	//get方法
	public Integer getEmpBirthday() {
		return empBirthday;
	}

	//set方法
	public void setEmpBirthday(Integer empBirthday) {
		this.empBirthday = empBirthday;
	}
	//get方法
	public Date getEmpPhone() {
		return empPhone;
	}

	//set方法
	public void setEmpPhone(Date empPhone) {
		this.empPhone = empPhone;
	}
	//get方法
	public Integer getEmpEmail() {
		return empEmail;
	}

	//set方法
	public void setEmpEmail(Integer empEmail) {
		this.empEmail = empEmail;
	}
	//get方法
	public String getEmpAdd() {
		return empAdd;
	}

	//set方法
	public void setEmpAdd(String empAdd) {
		this.empAdd = empAdd;
	}
	//get方法
	public String getEmpPhoto() {
		return empPhoto;
	}

	//set方法
	public void setEmpPhoto(String empPhoto) {
		this.empPhoto = empPhoto;
	}
	//get方法
	public String getEmpNative() {
		return empNative;
	}

	//set方法
	public void setEmpNative(String empNative) {
		this.empNative = empNative;
	}
	//get方法
	public String getEmpMarry() {
		return empMarry;
	}

	//set方法
	public void setEmpMarry(String empMarry) {
		this.empMarry = empMarry;
	}
	//get方法
	public String getEmpMajor() {
		return empMajor;
	}

	//set方法
	public void setEmpMajor(String empMajor) {
		this.empMajor = empMajor;
	}
	//get方法
	public String getEmpCard() {
		return empCard;
	}

	//set方法
	public void setEmpCard(String empCard) {
		this.empCard = empCard;
	}
	//get方法
	public String getEmp() {
		return emp;
	}

	//set方法
	public void setEmp(String emp) {
		this.emp = emp;
	}


}
