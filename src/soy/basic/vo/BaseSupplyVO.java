package soy.basic.vo;

import soy.basic.database.entity.BaseSupply;

public class BaseSupplyVO {
	// 对应实体类
	private BaseSupply baseSupply;

	private String id;
	private String supplyName;
	private String remark;
	
	public BaseSupplyVO() {
	}
	
	public BaseSupplyVO(BaseSupply baseSupply) {
		this.baseSupply = baseSupply;
	}

	public BaseSupply getBaseSupply() {
		return baseSupply;
	}

	public void setBaseSupply(BaseSupply baseSupply) {
		this.baseSupply = baseSupply;
	}

	public String getId() {
		if (getBaseSupply() != null && id == null) {
			id = String.valueOf(getBaseSupply().getId());
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSupplyName() {
		if (getBaseSupply() != null && supplyName == null) {
			supplyName = getBaseSupply().getSupplyName();
		}
		return supplyName;
	}

	public void setSupplyName(String supplyName) {
		this.supplyName = supplyName;
	}

	public String getRemark() {
		if (getBaseSupply() != null && remark == null) {
			remark = getBaseSupply().getRemark();
		}
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
