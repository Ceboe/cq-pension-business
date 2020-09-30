package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:Role构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="role")
public class Role implements Serializable{

	@Id
    @Column(name = "role_id")
	private Integer roleId;//角色表ID

    @Column(name = "role_name")
	private String roleName;//名称

    @Column(name = "role_des")
	private String roleDes;//描述

    @Column(name = "role_rec")
	private String roleRec;//记录状态

    @Column(name = "role_rem")
	private String roleRem;//备注



	//get方法
	public Integer getRoleId() {
		return roleId;
	}

	//set方法
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	//get方法
	public String getRoleName() {
		return roleName;
	}

	//set方法
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	//get方法
	public String getRoleDes() {
		return roleDes;
	}

	//set方法
	public void setRoleDes(String roleDes) {
		this.roleDes = roleDes;
	}
	//get方法
	public String getRoleRec() {
		return roleRec;
	}

	//set方法
	public void setRoleRec(String roleRec) {
		this.roleRec = roleRec;
	}
	//get方法
	public String getRoleRem() {
		return roleRem;
	}

	//set方法
	public void setRoleRem(String roleRem) {
		this.roleRem = roleRem;
	}


}
