package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:SocialWorkerAct构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="social_worker_act")
public class SocialWorkerAct implements Serializable{

	@Id
    @Column(name = "swa_id")
	private Integer swaId;//活动编号

    @Column(name = "swa_content")
	private String swaContent;//活动内容

    @Column(name = "swa_btime")
	private Date swaBtime;//开始时间

    @Column(name = "swa_etime")
	private Date swaEtime;//结束时间

    @Column(name = "org_name")
	private String orgName;//组织名称

    @Column(name = "org_pnum")
	private Integer orgPnum;//组织人数

    @Column(name = "org_charge")
	private String orgCharge;//组织负责人

    @Column(name = "swa_charge")
	private String swaCharge;//院方负责人

    @Column(name = "swa_rem")
	private String swaRem;//备注



	//get方法
	public Integer getSwaId() {
		return swaId;
	}

	//set方法
	public void setSwaId(Integer swaId) {
		this.swaId = swaId;
	}
	//get方法
	public String getSwaContent() {
		return swaContent;
	}

	//set方法
	public void setSwaContent(String swaContent) {
		this.swaContent = swaContent;
	}
	//get方法
	public Date getSwaBtime() {
		return swaBtime;
	}

	//set方法
	public void setSwaBtime(Date swaBtime) {
		this.swaBtime = swaBtime;
	}
	//get方法
	public Date getSwaEtime() {
		return swaEtime;
	}

	//set方法
	public void setSwaEtime(Date swaEtime) {
		this.swaEtime = swaEtime;
	}
	//get方法
	public String getOrgName() {
		return orgName;
	}

	//set方法
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	//get方法
	public Integer getOrgPnum() {
		return orgPnum;
	}

	//set方法
	public void setOrgPnum(Integer orgPnum) {
		this.orgPnum = orgPnum;
	}
	//get方法
	public String getOrgCharge() {
		return orgCharge;
	}

	//set方法
	public void setOrgCharge(String orgCharge) {
		this.orgCharge = orgCharge;
	}
	//get方法
	public String getSwaCharge() {
		return swaCharge;
	}

	//set方法
	public void setSwaCharge(String swaCharge) {
		this.swaCharge = swaCharge;
	}
	//get方法
	public String getSwaRem() {
		return swaRem;
	}

	//set方法
	public void setSwaRem(String swaRem) {
		this.swaRem = swaRem;
	}


}
