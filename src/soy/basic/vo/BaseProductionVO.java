package soy.basic.vo;

import soy.basic.database.entity.BaseProduction;

public class BaseProductionVO {

	private BaseProduction baseProduction;

	private String id;
	private String name;
	private String remark;

	public BaseProductionVO() {
		// TODO Auto-generated constructor stub
	}

	public BaseProductionVO(BaseProduction baseProduction) {
		this.baseProduction = baseProduction;
	}

	public BaseProduction getBaseProduction() {
		return baseProduction;
	}

	public void setBaseProduction(BaseProduction baseProduction) {
		this.baseProduction = baseProduction;
	}

	public String getId() {
		if (getBaseProduction() != null && id == null) {
			id = String.valueOf(getBaseProduction().getId());
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		if (getBaseProduction() != null && name == null) {
			name = getBaseProduction().getName();
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		if (getBaseProduction() != null && remark == null) {
			remark = getBaseProduction().getRemark();
		}
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
