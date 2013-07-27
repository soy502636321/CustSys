package soy.basic.database.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 业务种类：基本表
 * 
 * @author 小胡
 * 
 */

public class BaseClass implements java.io.Serializable {

	// 属性

	private Integer id; // 主键
	private String className; // 种类名字
	private String remark; // 备注

	// 构造方法

	/**
	 * 默认的构造方法
	 */
	public BaseClass() {
	}

	/**
	 * 全属性构造方法
	 * 
	 * @param className
	 * @param remark
	 */
	public BaseClass(String className, String remark) {
		this.className = className;
		this.remark = remark;
	}

	// 属性访问

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}