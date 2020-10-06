package com.cqp.model;

import javax.persistence.*;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:EmmUser构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="emm_user")
public class EmmUser implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//编号

    @Column(name = "emp_id")
	private Integer empId;//员工编号

    @Column(name = "emp_name")
	private String empName;//姓名

    @Column(name = "emp_password")
	private String empPassword;//密码

    @Column(name = "role_id")
	private Integer roleId;//角色

    @Column(name = "can_use")
	private String canUse;//是否可用



	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
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
	public String getEmpName() {
		return empName;
	}

	//set方法
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	//get方法
	public String getEmpPassword() {
		return empPassword;
	}

	//set方法
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	//get方法
	public Integer getRoleId() {
		return roleId;
	}

	//set方法
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	//get方法
	public String getCanUse() {
		return canUse;
	}

	//set方法
	public void setCanUse(String canUse) {
		this.canUse = canUse;
	}


}
