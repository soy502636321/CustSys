package soy.basic.database.entity;

import java.io.Serializable;

/**
 * 供应质量实体类
 * @author 小胡
 */
public class BaseSupply implements Serializable {
	
	private Integer id;
	private String supplyName;
	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSupplyName() {
		return supplyName;
	}

	public void setSupplyName(String supplyName) {
		this.supplyName = supplyName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
