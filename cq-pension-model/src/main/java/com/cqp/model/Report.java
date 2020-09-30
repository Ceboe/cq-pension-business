package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:Report构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="report")
public class Report implements Serializable{

	@Id
    @Column(name = "rep_id")
	private Integer repId;//报表ID

    @Column(name = "rep_name")
	private String repName;//报表名称

    @Column(name = "rep_des")
	private String repDes;//描述



	//get方法
	public Integer getRepId() {
		return repId;
	}

	//set方法
	public void setRepId(Integer repId) {
		this.repId = repId;
	}
	//get方法
	public String getRepName() {
		return repName;
	}

	//set方法
	public void setRepName(String repName) {
		this.repName = repName;
	}
	//get方法
	public String getRepDes() {
		return repDes;
	}

	//set方法
	public void setRepDes(String repDes) {
		this.repDes = repDes;
	}


}
