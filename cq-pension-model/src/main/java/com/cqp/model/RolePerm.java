package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:RolePerm构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="role_perm")
public class RolePerm implements Serializable{

	@Id
    @Column(name = "rp_id")
	private Integer rpId;//角色权限ID

    @Column(name = "role_id")
	private Integer roleId;//角色ID

    @Column(name = "per_id")
	private Integer perId;//权限ID

    @Column(name = "rp_rem")
	private String rpRem;//描述



	//get方法
	public Integer getRpId() {
		return rpId;
	}

	//set方法
	public void setRpId(Integer rpId) {
		this.rpId = rpId;
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
	public Integer getPerId() {
		return perId;
	}

	//set方法
	public void setPerId(Integer perId) {
		this.perId = perId;
	}
	//get方法
	public String getRpRem() {
		return rpRem;
	}

	//set方法
	public void setRpRem(String rpRem) {
		this.rpRem = rpRem;
	}


}
