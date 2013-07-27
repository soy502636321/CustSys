package soy.basic.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.BaseQuality;

public class BaseQualityVO {
	private static final Logger log = LoggerFactory.getLogger(BaseQualityVO.class);
	
	private BaseQuality baseQuality;
	
	private String id; //业务品质主键
	private String qualityName; //业务品质名字
	private String remark; //备注
	
	public BaseQualityVO() {}
	
	public BaseQualityVO(BaseQuality baseQuality) {
		this.baseQuality = baseQuality;
	}

	public BaseQuality getBaseQuality() {
		return baseQuality;
	}

	public void setBaseQuality(BaseQuality baseQuality) {
		this.baseQuality = baseQuality;
	}

	public String getId() {
		if (getBaseQuality() != null && id == null) {
			id = String.valueOf(getBaseQuality().getId());
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQualityName() {
		if (getBaseQuality() != null && qualityName == null) {
			qualityName = getBaseQuality().getQualityName();
		}
		return qualityName;
	}

	public void setQualityName(String qualityName) {
		this.qualityName = qualityName;
	}

	public String getRemark() {
		if (getBaseQuality() != null && remark == null) {
			remark = getBaseQuality().getRemark();
		}
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
