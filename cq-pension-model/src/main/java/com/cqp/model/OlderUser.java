package com.cqp.model;

import javax.persistence.*;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:OlderUser构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="older_user")
public class OlderUser implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//编号

    @Column(name = "op_id")
	private Integer opId;//登录账号（老人编号）

    @Column(name = "op_password")
	private String opPassword;//登录密码

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
	public Integer getOpId() {
		return opId;
	}

	//set方法
	public void setOpId(Integer opId) {
		this.opId = opId;
	}
	//get方法
	public String getOpPassword() {
		return opPassword;
	}

	//set方法
	public void setOpPassword(String opPassword) {
		this.opPassword = opPassword;
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
