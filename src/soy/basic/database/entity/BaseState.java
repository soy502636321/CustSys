package soy.basic.database.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 客户状态
 * @author 小胡
 *
 */
public class BaseState implements java.io.Serializable {

	// 属性

	private Integer id; //客户状态主键
	private String stateName; //客户状态名字
	private String remark; //备注

	// 构造方法

	/**
	 * 默认的构造方法
	 */
	public BaseState() {
	}

	/**
	 * 全属性构造方法
	 */
	public BaseState(String stateName, String remark) {
		this.stateName = stateName;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}