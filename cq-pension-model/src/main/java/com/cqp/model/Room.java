package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:Room构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="room")
public class Room implements Serializable{

	@Id
    @Column(name = "room_id")
	private Integer roomId;//id

    @Column(name = "flo_id")
	private Integer floId;//对应楼层id

    @Column(name = "room_num")
	private Integer roomNum;//房号

    @Column(name = "bed_num")
	private int bedNum;//房间数

    @Column(name = "room_sun")
	private String roomSun;//是否向阳

    @Column(name = "room_spe")
	private String roomSpe;//是否特护



	//get方法
	public Integer getRoomId() {
		return roomId;
	}

	//set方法
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	//get方法
	public Integer getFloId() {
		return floId;
	}

	//set方法
	public void setFloId(Integer floId) {
		this.floId = floId;
	}
	//get方法
	public Integer getRoomNum() {
		return roomNum;
	}

	//set方法
	public void setRoomNum(Integer roomNum) {
		this.roomNum = roomNum;
	}
	//get方法
	public int getRoomType() {
		return bedNum;
	}

	//set方法
	public void setRoomType(int bedNum) {
		this.bedNum = bedNum;
	}
	//get方法
	public String getRoomSun() {
		return roomSun;
	}

	//set方法
	public void setRoomSun(String roomSun) {
		this.roomSun = roomSun;
	}
	//get方法
	public String getRoomSpe() {
		return roomSpe;
	}

	//set方法
	public void setRoomSpe(String roomSpe) {
		this.roomSpe = roomSpe;
	}


}
