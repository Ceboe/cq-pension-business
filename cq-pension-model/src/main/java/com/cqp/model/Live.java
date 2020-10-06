package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:Live构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="live")
public class Live implements Serializable{

	@Id
    @Column(name = "live_id")
	private Integer liveId;//入住id

    @Column(name = "op_id")
	private Integer opId;//老人编号

    @Column(name = "live_time")
	private Date liveTime;//入住时间

    @Column(name = "bed_id")
	private Integer bedId;//入住的床位编号

    @Column(name = "live_pro")
	private String livePro;//入住协议地址

    @Column(name = "end_time")
	private Date endTime;//退住时间

    @Column(name = "end_pro")
	private String endPro;//退住协议

    @Column(name = "el_id")
	private Integer elId;//餐饮规格编号

    @Column(name = "np_id")
	private Integer npId;//基础护理项编号



	//get方法
	public Integer getLiveId() {
		return liveId;
	}

	//set方法
	public void setLiveId(Integer liveId) {
		this.liveId = liveId;
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
	public Date getLiveTime() {
		return liveTime;
	}

	//set方法
	public void setLiveTime(Date liveTime) {
		this.liveTime = liveTime;
	}
	//get方法
	public Integer getBedId() {
		return bedId;
	}

	//set方法
	public void setBedId(Integer bedId) {
		this.bedId = bedId;
	}
	//get方法
	public String getLivePro() {
		return livePro;
	}

	//set方法
	public void setLivePro(String livePro) {
		this.livePro = livePro;
	}
	//get方法
	public Date getEndTime() {
		return endTime;
	}

	//set方法
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	//get方法
	public String getEndPro() {
		return endPro;
	}

	//set方法
	public void setEndPro(String endPro) {
		this.endPro = endPro;
	}
	//get方法
	public Integer getElId() {
		return elId;
	}

	//set方法
	public void setElId(Integer elId) {
		this.elId = elId;
	}
	//get方法
	public Integer getNpId() {
		return npId;
	}

	//set方法
	public void setNpId(Integer npId) {
		this.npId = npId;
	}


}
