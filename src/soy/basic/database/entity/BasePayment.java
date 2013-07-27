package soy.basic.database.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 支付方式
 * @author 小胡
 *
 */

public class BasePayment implements java.io.Serializable {

	// 属性

	private Integer id; //支付方式主键
	private String paymentName; //支付方式名字
	private String remark; //备注

	// 构造方法

	/**
	 * 默认的构造方法
	 */
	public BasePayment() {
	}

	/**
	 * 全属性构造方法
	 * @param paymentName
	 * @param remark
	 */
	public BasePayment(String paymentName, String remark) {
		this.paymentName = paymentName;
		this.remark = remark;
	}

	// 属性访问

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPaymentName() {
		return this.paymentName;
	}

	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}