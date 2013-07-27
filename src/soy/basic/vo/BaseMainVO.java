package soy.basic.vo;

import soy.basic.database.entity.BaseMain;

/**
 * @author XiaoLiang·Hu
 * 
 */
public class BaseMainVO {
	private BaseMain baseMain;
	
	private String id;
	private String mainName;
	private String remark;

	public BaseMainVO() {
	}

	public BaseMainVO(BaseMain baseMain) {
		this.baseMain = baseMain;
	}

	public BaseMain getBaseMain() {
		return baseMain;
	}

	public void setBaseMain(BaseMain baseMain) {
		this.baseMain = baseMain;
	}

	public String getId() {
		if (getBaseMain() != null && id == null) {
			id = String.valueOf(getBaseMain().getId());
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMainName() {
		if (getBaseMain() != null && mainName == null) {
			mainName = getBaseMain().getMainName();
		}
		return mainName;
	}

	public void setMainName(String mainName) {
		this.mainName = mainName;
	}

	public String getRemark() {
		if (getBaseMain() != null && remark == null) {
			remark = getBaseMain().getRemark();
		}
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
