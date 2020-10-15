package com.cqp.model;



import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:BedRepl构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="bed_repl")
public class BedRepl implements Serializable{

	@Id
    @Column(name = "br_id")
	private Integer brId;//记录编号

    @Column(name = "op_id")
	private Integer opId;//老人编号

    @Column(name = "o_bed_id")
	private Integer obedId;//原床位编号

    @Column(name = "n_bed_id")
	private Integer nbedId;//新床位编号

    @Column(name = "charge")
	private String charge;//负责人

    @Column(name = "remark")
	private String remark;//备注



	//get方法
	public Integer getBrId() {
		return brId;
	}

	//set方法
	public void setBrId(Integer brId) {
		this.brId = brId;
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
	public Integer getOBedId() {
		return obedId;
	}

	//set方法
	public void setOBedId(Integer oBedId) {
		this.obedId = oBedId;
	}
	//get方法
	public Integer getNBedId() {
		return nbedId;
	}

	//set方法
	public void setNBedId(Integer nBedId) {
		this.nbedId = nBedId;
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
	public String getRemark() {
		return remark;
	}

	//set方法
	public void setRemark(String remark) {
		this.remark = remark;
	}


}
