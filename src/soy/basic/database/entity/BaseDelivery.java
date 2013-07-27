package soy.basic.database.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 交付方式
 * @author 小胡
 *
 */

public class BaseDelivery implements java.io.Serializable {

	// 属性

	private Integer id; //主键
	private String deliveryName; //交付方式名字
	private String remark; //备注

	// 构造方法

	/**
	 * 默认的构造方法
	 */
	public BaseDelivery() {
	}

	/**
	 * 全属性构造方法
	 * @param deliveryName
	 * @param remark
	 */
	public BaseDelivery(String deliveryName, String remark) {
		this.deliveryName = deliveryName;
		this.remark = remark;
	}

	// 属性访问

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeliveryName() {
		return this.deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}