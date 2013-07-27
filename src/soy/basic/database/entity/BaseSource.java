package soy.basic.database.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 客户来源
 * @author 小胡
 *
 */

public class BaseSource implements java.io.Serializable {

	// 属性

	private Integer id; //客户来源主键
	private String sourceName; //客户来源名字
	private String remark; //备注

	// 构造方法

	/**
	 * 默认的构造方法
	 */
	public BaseSource() {
	}

	/**
	 * 全属性构造方法
	 * @param sourceName
	 * @param remark
	 */
	public BaseSource(String sourceName, String remark) {
		this.sourceName = sourceName;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSourceName() {
		return this.sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}