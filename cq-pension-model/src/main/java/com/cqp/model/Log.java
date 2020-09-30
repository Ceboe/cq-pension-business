package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:Log构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="log")
public class Log implements Serializable{

	@Id
    @Column(name = "log_id")
	private Integer logId;//ID

    @Column(name = "log_type")
	private String logType;//操作类型

    @Column(name = "log_con")
	private String logCon;//具体操作

    @Column(name = "log_name")
	private String logName;//操作人

    @Column(name = "log_date")
	private Date logDate;//日期

    @Column(name = "log_time")
	private Date logTime;//时间



	//get方法
	public Integer getLogId() {
		return logId;
	}

	//set方法
	public void setLogId(Integer logId) {
		this.logId = logId;
	}
	//get方法
	public String getLogType() {
		return logType;
	}

	//set方法
	public void setLogType(String logType) {
		this.logType = logType;
	}
	//get方法
	public String getLogCon() {
		return logCon;
	}

	//set方法
	public void setLogCon(String logCon) {
		this.logCon = logCon;
	}
	//get方法
	public String getLogName() {
		return logName;
	}

	//set方法
	public void setLogName(String logName) {
		this.logName = logName;
	}
	//get方法
	public Date getLogDate() {
		return logDate;
	}

	//set方法
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
	//get方法
	public Date getLogTime() {
		return logTime;
	}

	//set方法
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}


}
