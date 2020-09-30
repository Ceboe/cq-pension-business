package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:RepContent构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="rep_content")
public class RepContent implements Serializable{

	@Id
    @Column(name = "rc_id")
	private Integer rcId;//ID

    @Column(name = "rep_id")
	private Integer repId;//所属报表ID

    @Column(name = "rc_data")
	private String rcData;//数据表

    @Column(name = "rc_field")
	private String rcField;//字段

    @Column(name = "field_name")
	private String fieldName;//字段注释



	//get方法
	public Integer getRcId() {
		return rcId;
	}

	//set方法
	public void setRcId(Integer rcId) {
		this.rcId = rcId;
	}
	//get方法
	public Integer getRepId() {
		return repId;
	}

	//set方法
	public void setRepId(Integer repId) {
		this.repId = repId;
	}
	//get方法
	public String getRcData() {
		return rcData;
	}

	//set方法
	public void setRcData(String rcData) {
		this.rcData = rcData;
	}
	//get方法
	public String getRcField() {
		return rcField;
	}

	//set方法
	public void setRcField(String rcField) {
		this.rcField = rcField;
	}
	//get方法
	public String getFieldName() {
		return fieldName;
	}

	//set方法
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}


}
