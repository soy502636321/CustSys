package soy.basic.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.BaseSource;

public class BaseSourceVO {
	private static final Logger log = LoggerFactory
			.getLogger(BaseSourceVO.class);

	private BaseSource baseSource;

	private String id; // 客户来源主键
	private String sourceName; // 客户来源名字
	private String remark; // 备注

	public BaseSourceVO() {
	}

	public BaseSourceVO(String id, String sourceName) {
		this.id = id;
		this.sourceName = sourceName;
	}
	
	public BaseSourceVO(BaseSource baseSource) {
		this.baseSource = baseSource;
	}

	public BaseSource getBaseSource() {
		return baseSource;
	}

	public void setBaseSource(BaseSource baseSource) {
		this.baseSource = baseSource;
	}

	public String getId() {
		if (getBaseSource() != null && id == null) {
			id = String.valueOf(getBaseSource().getId());
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSourceName() {
		if (getBaseSource() != null && sourceName == null) {
			sourceName = getBaseSource().getSourceName();
		}
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getRemark() {
		if (getBaseSource() != null && remark == null) {
			remark = getBaseSource().getRemark();
		}
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
