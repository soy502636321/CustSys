package soy.basic.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.BaseState;

public class BaseStateVO {
	private static final Logger log = LoggerFactory
			.getLogger(BaseStateVO.class);

	private BaseState baseState;

	private String id; // 客户状态主键
	private String stateName; // 客户状态名字
	private String remark; // 备注

	public BaseStateVO() {
	}

	public BaseStateVO(BaseState baseState) {
		this.baseState = baseState;
	}

	public BaseState getBaseState() {
		return baseState;
	}

	public void setBaseState(BaseState baseState) {
		this.baseState = baseState;
	}

	public String getId() {
		if (getBaseState() != null && id == null) {
			id = String.valueOf(getBaseState().getId());
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStateName() {
		if (getBaseState() != null && stateName == null) {
			stateName = getBaseState().getStateName();
		}
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getRemark() {
		if (getBaseState() != null && remark == null) {
			remark = getBaseState().getRemark();
		}
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
