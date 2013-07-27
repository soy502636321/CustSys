package soy.basic.database.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 客户类型
 * @author 小胡
 *
 */

public class BaseType implements java.io.Serializable {

	// 属性

	private Integer id; //客户类型主键
	private String typeName; //客户类型名字
	private String remark; //备注

	// 构造方法

	/**
	 * 默认的构造方法
	 */
	public BaseType() {
	}

	/**
	 * 全属性构造方法
	 * @param typeName
	 * @param remark
	 * @param sysCusts
	 */
	public BaseType(String typeName, String remark) {
		this.typeName = typeName;
		this.remark = remark;
	}

	// 属性访问

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}