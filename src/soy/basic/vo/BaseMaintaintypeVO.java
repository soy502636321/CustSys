package soy.basic.vo;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

import soy.basic.database.entity.BaseMaintaintype;

public class BaseMaintaintypeVO {
	private static final Logger log = LoggerFactory
			.getLogger(BaseMaintaintypeVO.class);

	private BaseMaintaintype baseMaintaintype;

	private String id; // 维护类型主键
	private String maintaintypeName; // 维护类型名字
	private String remark; // 备注

	public BaseMaintaintypeVO() {
	}

	public BaseMaintaintypeVO(BaseMaintaintype baseMaintaintype) {
		this.baseMaintaintype = baseMaintaintype;
	}

	public BaseMaintaintype getBaseMaintaintype() {
		return baseMaintaintype;
	}

	public void setBaseMaintaintype(BaseMaintaintype baseMaintaintype) {
		this.baseMaintaintype = baseMaintaintype;
	}

	public String getId() {
		if (getBaseMaintaintype() != null && id == null) {
			id = String.valueOf(getBaseMaintaintype().getId());
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMaintaintypeName() {
		if (getBaseMaintaintype() != null && maintaintypeName == null) {
			maintaintypeName = getBaseMaintaintype().getMaintaintypeName();
		}
		return maintaintypeName;
	}

	public void setMaintaintypeName(String maintaintypeName) {
		this.maintaintypeName = maintaintypeName;
	}

	public String getRemark() {
		if (getBaseMaintaintype() != null && remark == null) {
			remark = getBaseMaintaintype().getRemark();
		}
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
