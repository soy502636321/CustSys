package soy.basic.database.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 业务品质
 * @author 小胡
 *
 */

public class BaseQuality implements java.io.Serializable {

	// 属性

	private Integer id; //业务品质主键
	private String qualityName; //业务品质名字
	private String remark; //备注

	// 构造方法

	/** 
	 * 默认的构造方法
	 */
	public BaseQuality() {
	}

	/**
	 * 全属性的构造方法
	 * @param qualityName
	 * @param remark
	 */
	public BaseQuality(String qualityName, String remark) {
		this.qualityName = qualityName;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQualityName() {
		return this.qualityName;
	}

	public void setQualityName(String qualityName) {
		this.qualityName = qualityName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}