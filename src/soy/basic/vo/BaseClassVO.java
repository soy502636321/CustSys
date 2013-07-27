package soy.basic.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.BaseClass;

public class BaseClassVO {
	private static final Logger log = LoggerFactory
			.getLogger(BaseClassVO.class);

	// 属性
	private BaseClass baseClass;
	private String id; // 主键
	private String className; // 种类名字
	private String remark; // 备注

	// 构造方法
	/**
	 * 默认的构造方法
	 * 
	 * @return
	 */
	public BaseClassVO() {

	}
	
	public BaseClassVO(BaseClass baseClass) {
		this.baseClass = baseClass;
	}

	/**
	 * 全属性构造方法
	 * 
	 * @return
	 */

	public BaseClassVO(String className, String remark) {
		this.className = className;
		this.remark = remark;
	}

	public String getId() {
		if (getBaseClass() != null && id  == null) {
			id = String.valueOf(getBaseClass().getId());
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassName() {
		if (getBaseClass() != null && className == null) {
			className = getBaseClass().getClassName();
		}
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getRemark() {
		if (getBaseClass() != null && remark == null) {
			remark = getBaseClass().getRemark();
		}
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BaseClass getBaseClass() {
		return baseClass;
	}

	public void setBaseClass(BaseClass baseClass) {
		this.baseClass = baseClass;
	}

}
