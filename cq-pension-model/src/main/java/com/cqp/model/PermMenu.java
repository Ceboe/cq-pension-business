package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:PermMenu构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="perm_menu")
public class PermMenu implements Serializable{

	@Id
    @Column(name = "per_id")
	private Integer perId;//权限编号

    @Column(name = "menu_id")
	private Integer menuId;//菜单编号



	//get方法
	public Integer getPerId() {
		return perId;
	}

	//set方法
	public void setPerId(Integer perId) {
		this.perId = perId;
	}
	//get方法
	public Integer getMenuId() {
		return menuId;
	}

	//set方法
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}


}
