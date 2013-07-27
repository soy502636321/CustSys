package soy.basic.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.BaseType;

public class BaseTypeVO {
	private static final Logger log = LoggerFactory.getLogger(BaseTypeVO.class);

	private BaseType baseType;

	private String id; // 客户类型主键
	private String typeName; // 客户类型名字
	private String remark; // 备注

	public BaseTypeVO() {
	}
	
	public BaseTypeVO(String id, String typeName) {
		this.id = id;
		this.typeName = typeName;
	}

	public BaseTypeVO(BaseType baseType) {
		this.baseType = baseType;
	}

	public BaseType getBaseType() {
		return baseType;
	}

	public void setBaseType(BaseType baseType) {
		this.baseType = baseType;
	}

	public String getId() {
		if (getBaseType() != null && id == null) {
			id = String.valueOf(getBaseType().getId());
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTypeName() {
		if (getBaseType() != null && typeName == null) {
			typeName = getBaseType().getTypeName();
		}
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getRemark() {
		if (getBaseType() != null && remark == null) {
			remark = getBaseType().getRemark();
		}
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
