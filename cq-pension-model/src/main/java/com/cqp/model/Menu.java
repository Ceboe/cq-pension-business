package com.cqp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Menu构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="menu")
public class Menu implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
	private Integer menuId;//菜单编号

    @Column(name = "level")
	private Integer level;//菜单级别

    @Column(name = "name")
	private String name;//菜单名称

    @Column(name = "icon")
	private String icon;//菜单图标

    @Column(name = "url")
	private String url;//菜单地址

    @Column(name = "parent")
	private Integer parent;//父菜单编号

	private List<Menu> children;//子菜单列表



	//get方法
	public Integer getMenuId() {
		return menuId;
	}

	//set方法
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	//get方法
	public Integer getLevel() {
		return level;
	}

	//set方法
	public void setLevel(Integer level) {
		this.level = level;
	}
	//get方法
	public String getName() {
		return name;
	}

	//set方法
	public void setName(String name) {
		this.name = name;
	}
	//get方法
	public String getIcon() {
		return icon;
	}

	//set方法
	public void setIcon(String icon) {
		this.icon = icon;
	}
	//get方法
	public String getUrl() {
		return url;
	}

	//set方法
	public void setUrl(String url) {
		this.url = url;
	}
	//get方法
	public Integer getParent() {
		return parent;
	}

	//set方法
	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}


}
