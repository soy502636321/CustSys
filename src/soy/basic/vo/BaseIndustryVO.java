package soy.basic.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.BaseIndustry;

public class BaseIndustryVO {
	private static final Logger log = LoggerFactory
			.getLogger(BaseIndustryVO.class);

	private BaseIndustry baseIndustry;
	private String id; // 行业主键
	private String industryName; // 行业名字
	private String remark; // 备注
	
	public BaseIndustryVO() {}
	
	public BaseIndustryVO(String id, String industryName) {
		this.id = id;
		this.industryName = industryName;
	}
	
	public BaseIndustryVO(BaseIndustry baseIndustry) {
		this.baseIndustry = baseIndustry;
	}

	public BaseIndustry getBaseIndustry() {
		return baseIndustry;
	}

	public void setBaseIndustry(BaseIndustry baseIndustry) {
		this.baseIndustry = baseIndustry;
	}

	public String getId() {
		if (getBaseIndustry() != null && id == null) {
			id = String.valueOf(getBaseIndustry().getId());
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIndustryName() {
		if (getBaseIndustry() != null && industryName == null) {
			industryName = getBaseIndustry().getIndustryName();
		}
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getRemark() {
		if (getBaseIndustry() != null && remark == null) {
			remark = getBaseIndustry().getRemark();
		}
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
