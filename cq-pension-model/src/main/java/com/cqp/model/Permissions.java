package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:Permissions构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="permissions")
public class Permissions implements Serializable{

	@Id
    @Column(name = "per_id")
	private Integer perId;//权限表ID

    @Column(name = "rp_id")
	private Integer rpId;//记录编号

    @Column(name = "per_name")
	private String perName;//名称

    @Column(name = "per_des")
	private String perDes;//描述

    @Column(name = "per_menu")
	private String perMenu;//子菜单

    @Column(name = "per_rem")
	private String perRem;//备注



	//get方法
	public Integer getPerId() {
		return perId;
	}

	//set方法
	public void setPerId(Integer perId) {
		this.perId = perId;
	}
	//get方法
	public Integer getRpId() {
		return rpId;
	}

	//set方法
	public void setRpId(Integer rpId) {
		this.rpId = rpId;
	}
	//get方法
	public String getPerName() {
		return perName;
	}

	//set方法
	public void setPerName(String perName) {
		this.perName = perName;
	}
	//get方法
	public String getPerDes() {
		return perDes;
	}

	//set方法
	public void setPerDes(String perDes) {
		this.perDes = perDes;
	}
	//get方法
	public String getPerMenu() {
		return perMenu;
	}

	//set方法
	public void setPerMenu(String perMenu) {
		this.perMenu = perMenu;
	}
	//get方法
	public String getPerRem() {
		return perRem;
	}

	//set方法
	public void setPerRem(String perRem) {
		this.perRem = perRem;
	}


}
