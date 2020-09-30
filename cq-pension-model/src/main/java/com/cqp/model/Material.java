package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:Material构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="material")
public class Material implements Serializable{

	@Id
    @Column(name = "m_id")
	private Integer mId;//物资编号

    @Column(name = "m_name")
	private String mName;//物资号

    @Column(name = "m_descrip")
	private String mDescrip;//说明

    @Column(name = "m_price")
	private String mPrice;//价格

    @Column(name = "depr_rate")
	private String deprRate;//折旧率

    @Column(name = "item_type")
	private String itemType;//物品类型

    @Column(name = "stock_num")
	private Integer stockNum;//现存数量

    @Column(name = "charge")
	private String charge;//负责人

    @Column(name = "note_taker")
	private String noteTaker;//记录人

    @Column(name = "remark")
	private String remark;//备注



	//get方法
	public Integer getMId() {
		return mId;
	}

	//set方法
	public void setMId(Integer mId) {
		this.mId = mId;
	}
	//get方法
	public String getMName() {
		return mName;
	}

	//set方法
	public void setMName(String mName) {
		this.mName = mName;
	}
	//get方法
	public String getMDescrip() {
		return mDescrip;
	}

	//set方法
	public void setMDescrip(String mDescrip) {
		this.mDescrip = mDescrip;
	}
	//get方法
	public String getMPrice() {
		return mPrice;
	}

	//set方法
	public void setMPrice(String mPrice) {
		this.mPrice = mPrice;
	}
	//get方法
	public String getDeprRate() {
		return deprRate;
	}

	//set方法
	public void setDeprRate(String deprRate) {
		this.deprRate = deprRate;
	}
	//get方法
	public String getItemType() {
		return itemType;
	}

	//set方法
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	//get方法
	public Integer getStockNum() {
		return stockNum;
	}

	//set方法
	public void setStockNum(Integer stockNum) {
		this.stockNum = stockNum;
	}
	//get方法
	public String getCharge() {
		return charge;
	}

	//set方法
	public void setCharge(String charge) {
		this.charge = charge;
	}
	//get方法
	public String getNoteTaker() {
		return noteTaker;
	}

	//set方法
	public void setNoteTaker(String noteTaker) {
		this.noteTaker = noteTaker;
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
