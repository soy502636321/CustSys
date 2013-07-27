package soy.basic.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.BasePayment;

public class BasePaymentVO {
	private static final Logger log = LoggerFactory.getLogger(BasePaymentVO.class);
	
	private BasePayment basePayment;
	
	private String id; //支付方式主键
	private String paymentName; //支付方式名字
	private String remark; //备注
	
	public BasePaymentVO() {}
	
	public BasePaymentVO(BasePayment basePayment) {
		this.basePayment = basePayment;
	}

	public BasePayment getBasePayment() {
		return basePayment;
	}

	public void setBasePayment(BasePayment basePayment) {
		this.basePayment = basePayment;
	}

	public String getId() {
		if (getBasePayment() != null && id == null) {
			id = String.valueOf(getBasePayment().getId());
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPaymentName() {
		if (getBasePayment() != null && paymentName == null) {
			paymentName = getBasePayment().getPaymentName();
		}
		return paymentName;
	}

	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}

	public String getRemark() {
		if (getBasePayment() != null && remark == null) {
			remark = getBasePayment().getRemark();
		}
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public static Logger getLog() {
		return log;
	}
	
	
	
	
}
