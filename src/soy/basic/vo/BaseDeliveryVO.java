package soy.basic.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.BaseDelivery;

public class BaseDeliveryVO {
	private static final Logger log = LoggerFactory
			.getLogger(BaseDeliveryVO.class);

	private BaseDelivery baseDelivery;
	
	//属性
	private String id; // 主键
	private String deliveryName; // 交付方式名字
	private String remark; // 备注
	
	//构造方法
	/**
	 * 默认的构造方法
	 * @return
	 */
	public BaseDeliveryVO() {
		
	}
	
	public BaseDeliveryVO(BaseDelivery baseDelivery) {
		this.baseDelivery = baseDelivery;
	}
	
	public BaseDelivery getBaseDelivery() {
		return baseDelivery;
	}

	public void setBaseDelivery(BaseDelivery baseDelivery) {
		this.baseDelivery = baseDelivery;
	}

	public String getId() {
		if (getBaseDelivery() != null && id == null) {
			id = String.valueOf(getBaseDelivery().getId());
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeliveryName() {
		if (getBaseDelivery() != null && deliveryName == null) {
			deliveryName = getBaseDelivery().getDeliveryName();
		}
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getRemark() {
		if (getBaseDelivery() != null && remark == null) {
			remark = getBaseDelivery().getRemark();
		}
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
