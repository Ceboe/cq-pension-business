package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:Opeople构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="opeople")
public class Opeople implements Serializable{

	@Id
    @Column(name = "op_id")
	private Integer opId;//老人编号

    @Column(name = "op_name")
	private String opName;//老人姓名

    @Column(name = "op_age")
	private Integer opAge;//老人年龄

    @Column(name = "op_sex")
	private String opSex;//老人性别

    @Column(name = "op_native")
	private String opNative;//籍贯

    @Column(name = "op_address")
	private String opAddress;//住址

    @Column(name = "op_photo")
	private String opPhoto;//照片

    @Column(name = "op_card")
	private String opCard;//身份证

    @Column(name = "op_phone")
	private Long opPhone;//联系电话

    @Column(name = "op_birthday")
	private Date opBirthday;//出生日期



	//get方法
	public Integer getOpId() {
		return opId;
	}

	//set方法
	public void setOpId(Integer opId) {
		this.opId = opId;
	}
	//get方法
	public String getOpName() {
		return opName;
	}

	//set方法
	public void setOpName(String opName) {
		this.opName = opName;
	}
	//get方法
	public Integer getOpAge() {
		return opAge;
	}

	//set方法
	public void setOpAge(Integer opAge) {
		this.opAge = opAge;
	}
	//get方法
	public String getOpSex() {
		return opSex;
	}

	//set方法
	public void setOpSex(String opSex) {
		this.opSex = opSex;
	}
	//get方法
	public String getOpNative() {
		return opNative;
	}

	//set方法
	public void setOpNative(String opNative) {
		this.opNative = opNative;
	}
	//get方法
	public String getOpAddress() {
		return opAddress;
	}

	//set方法
	public void setOpAddress(String opAddress) {
		this.opAddress = opAddress;
	}
	//get方法
	public String getOpPhoto() {
		return opPhoto;
	}

	//set方法
	public void setOpPhoto(String opPhoto) {
		this.opPhoto = opPhoto;
	}
	//get方法
	public String getOpCard() {
		return opCard;
	}

	//set方法
	public void setOpCard(String opCard) {
		this.opCard = opCard;
	}
	//get方法
	public Long getOpPhone() {
		return opPhone;
	}

	//set方法
	public void setOpPhone(Long opPhone) {
		this.opPhone = opPhone;
	}
	//get方法
	public Date getOpBirthday() {
		return opBirthday;
	}

	//set方法
	public void setOpBirthday(Date opBirthday) {
		this.opBirthday = opBirthday;
	}


}
