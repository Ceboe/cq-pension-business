package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:UseRecord构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="use_record")
public class UseRecord implements Serializable{

	@Id
    @Column(name = "ur_id")
	private Integer urId;//记录编号

    @Column(name = "m_id")
	private Integer mid;//物资编号

    @Column(name = "applicant")
	private String applicant;//申请人

    @Column(name = "use_time")
	private Date useTime;//领用时间

    @Column(name = "use_num")
	private Integer useNum;//领用数量

    @Column(name = "re_time")
	private Date reTime;//归还时间

    @Column(name = "is_dem")
	private String isDem;//是否损坏

    @Column(name = "use_des")
	private String useDes;//使用详情

    @Column(name = "note_taker")
	private String noteTaker;//记录员



	//get方法
	public Integer getUrId() {
		return urId;
	}

	//set方法
	public void setUrId(Integer urId) {
		this.urId = urId;
	}
	//get方法
	public Integer getMId() {
		return mid;
	}

	//set方法
	public void setMId(Integer mId) {
		this.mid = mId;
	}
	//get方法
	public String getApplicant() {
		return applicant;
	}

	//set方法
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	//get方法
	public Date getUseTime() {
		return useTime;
	}

	//set方法
	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}
	//get方法
	public Integer getUseNum() {
		return useNum;
	}

	//set方法
	public void setUseNum(Integer useNum) {
		this.useNum = useNum;
	}
	//get方法
	public Date getReTime() {
		return reTime;
	}

	//set方法
	public void setReTime(Date reTime) {
		this.reTime = reTime;
	}
	//get方法
	public String getIsDem() {
		return isDem;
	}

	//set方法
	public void setIsDem(String isDem) {
		this.isDem = isDem;
	}
	//get方法
	public String getUseDes() {
		return useDes;
	}

	//set方法
	public void setUseDes(String useDes) {
		this.useDes = useDes;
	}
	//get方法
	public String getNoteTaker() {
		return noteTaker;
	}

	//set方法
	public void setNoteTaker(String noteTaker) {
		this.noteTaker = noteTaker;
	}


}
