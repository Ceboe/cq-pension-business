package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:Bed构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="bed")
public class Bed implements Serializable{

	@Id
    @Column(name = "bed_id")
	private Integer bedId;//床位编号

    @Column(name = "room_id")
	private Integer roomId;//房间编号

    @Column(name = "bed_price")
	private String bedPrice;//入住价格

    @Column(name = "bed_occupy")
	private String bedOccupy;//是否占用



	//get方法
	public Integer getBedId() {
		return bedId;
	}

	//set方法
	public void setBedId(Integer bedId) {
		this.bedId = bedId;
	}
	//get方法
	public Integer getRoomId() {
		return roomId;
	}

	//set方法
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	//get方法
	public String getBedPrice() {
		return bedPrice;
	}

	//set方法
	public void setBedPrice(String bedPrice) {
		this.bedPrice = bedPrice;
	}
	//get方法
	public String getBedOccupy() {
		return bedOccupy;
	}

	//set方法
	public void setBedOccupy(String bedOccupy) {
		this.bedOccupy = bedOccupy;
	}


}
