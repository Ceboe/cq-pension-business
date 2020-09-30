package com.cqp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:IllHistory构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="ill_history")
public class IllHistory implements Serializable{

	@Id
    @Column(name = "ih_id")
	private Integer ihId;//id

    @Column(name = "op_id")
	private Integer opId;//老人id

    @Column(name = "ih_dis")
	private String ihDis;//疾病

    @Column(name = "ih_cure")
	private String ihCure;//是否痊愈

    @Column(name = "recur_pos")
	private String recurPos;//复发可能

    @Column(name = "ih_attention")
	private String ihAttention;//注意事项

    @Column(name = "ih_rec")
	private String ihRec;//记录人



	//get方法
	public Integer getIhId() {
		return ihId;
	}

	//set方法
	public void setIhId(Integer ihId) {
		this.ihId = ihId;
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
	public String getIhDis() {
		return ihDis;
	}

	//set方法
	public void setIhDis(String ihDis) {
		this.ihDis = ihDis;
	}
	//get方法
	public String getIhCure() {
		return ihCure;
	}

	//set方法
	public void setIhCure(String ihCure) {
		this.ihCure = ihCure;
	}
	//get方法
	public String getRecurPos() {
		return recurPos;
	}

	//set方法
	public void setRecurPos(String recurPos) {
		this.recurPos = recurPos;
	}
	//get方法
	public String getIhAttention() {
		return ihAttention;
	}

	//set方法
	public void setIhAttention(String ihAttention) {
		this.ihAttention = ihAttention;
	}
	//get方法
	public String getIhRec() {
		return ihRec;
	}

	//set方法
	public void setIhRec(String ihRec) {
		this.ihRec = ihRec;
	}


}
