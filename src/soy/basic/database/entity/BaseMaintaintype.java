package soy.basic.database.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 维护类型
 * @author 小胡
 *
 */

public class BaseMaintaintype implements java.io.Serializable {

	// 属性

	private Integer id; //维护类型主键
	private String maintaintypeName; //维护类型名字
	private String remark; //备注

	// 构造方法

	/**
	 * 默认的构造方法
	 */
	public BaseMaintaintype() {
	}

	/** 
	 * 全属性构造方法
	 * @param maintaintypeName
	 * @param remark
	 */
	public BaseMaintaintype(String maintaintypeName, String remark) {
		this.maintaintypeName = maintaintypeName;
		this.remark = remark;
	}

	// 属性访问

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMaintaintypeName() {
		return this.maintaintypeName;
	}

	public void setMaintaintypeName(String maintaintypeName) {
		this.maintaintypeName = maintaintypeName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}