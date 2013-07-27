package soy.basic.database.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 客户行业
 * @author 小胡
 *
 */

public class BaseIndustry implements java.io.Serializable {

	// 属性

	private Integer id; //行业主键
	private String industryName; //行业名字
	private String remark; //备注

	// 构造方法

	/**
	 * 默认的构造方法
	 */
	public BaseIndustry() {
	}

	/**
	 * 全属性构造方法
	 * @param industryName
	 * @param remark
	 */
	public BaseIndustry(String industryName, String remark) {
		this.industryName = industryName;
		this.remark = remark;
	}

	// 属性方法

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIndustryName() {
		return this.industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}