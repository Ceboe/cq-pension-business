package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:NursProj构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="nurs_proj")
public class NursProj implements Serializable{

	@Id
    @Column(name = "np_id")
	private Integer npId;//护理项编号

    @Column(name = "na_name")
	private String naName;//护理项名称

    @Column(name = "np_des")
	private String npDes;//详情

    @Column(name = "np_price")
	private String npPrice;//价格

    @Column(name = "remark")
	private String remark;//备注



	//get方法
	public Integer getNpId() {
		return npId;
	}

	//set方法
	public void setNpId(Integer npId) {
		this.npId = npId;
	}
	//get方法
	public String getNaName() {
		return naName;
	}

	//set方法
	public void setNaName(String naName) {
		this.naName = naName;
	}
	//get方法
	public String getNpDes() {
		return npDes;
	}

	//set方法
	public void setNpDes(String npDes) {
		this.npDes = npDes;
	}
	//get方法
	public String getNpPrice() {
		return npPrice;
	}

	//set方法
	public void setNpPrice(String npPrice) {
		this.npPrice = npPrice;
	}
	//get方法
	public String getRemark() {
		return remark;
	}

	//set方法
	public void setRemark(String remark) {
		this.remark = remark;
	}


}
