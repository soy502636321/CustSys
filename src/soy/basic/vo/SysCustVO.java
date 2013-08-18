package soy.basic.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.BaseIndustry;
import soy.basic.database.entity.BaseSource;
import soy.basic.database.entity.BaseState;
import soy.basic.database.entity.BaseType;
import soy.basic.database.entity.SysCust;
import soy.basic.database.entity.SysUser;

public class SysCustVO {
	private static final Logger log = LoggerFactory.getLogger(SysCustVO.class);

	private SysCust sysCust;

	private String id; // 客户主键
	private BaseIndustry baseIndustry; // 行业
	private String baseIndustryName; // 行业名字
	private String baseIndustryId; // 行业主键

	private BaseType baseType; // 客户类型
	private String baseTypeName;
	private String baseTypeId;

	private BaseState baseState; // 客户状态
	private String baseStateName;
	private String baseStateId;

	private BaseSource baseSource; // 客户来源
	private String baseSourceName;
	private String baseSourceId;

	private String name; // 姓名
	private String address; // 地址
	private String postalCode; // 邮政编码
	private String website; // 网址
	private String remark; // 备注
	private String feature;// 特点

	private String custType; // 客户类型 /开发/正常
	private SysUser privateUser; // 开发人
	private String privateUserUsername;

	public SysCustVO() {
	}

	public SysCustVO(SysCust sysCust) {
		this.sysCust = sysCust;
	}

	public SysCust getSysCust() {
		return sysCust;
	}

	public void setSysCust(SysCust sysCust) {
		this.sysCust = sysCust;
	}

	public String getId() {
		if (getSysCust() != null && id == null) {
			id = String.valueOf(getSysCust().getId());
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BaseIndustry getBaseIndustry() {
		if (getSysCust() != null && baseIndustry == null) {
			baseIndustry = getSysCust().getBaseIndustry();
		}
		return baseIndustry;
	}

	public void setBaseIndustry(BaseIndustry baseIndustry) {
		this.baseIndustry = baseIndustry;
	}

	public BaseType getBaseType() {
		if (getSysCust() != null && baseType == null) {
			baseType = getSysCust().getBaseType();
		}
		return baseType;
	}

	public void setBaseType(BaseType baseType) {
		this.baseType = baseType;
	}

	public BaseState getBaseState() {
		if (getSysCust() != null && baseState == null) {
			baseState = getSysCust().getBaseState();
		}
		return baseState;
	}

	public void setBaseState(BaseState baseState) {
		this.baseState = baseState;
	}

	public BaseSource getBaseSource() {
		if (getSysCust() != null && baseSource == null) {
			baseSource = getSysCust().getBaseSource();
		}
		return baseSource;
	}

	public void setBaseSource(BaseSource baseSource) {
		this.baseSource = baseSource;
	}

	public String getName() {
		if (getSysCust() != null && name == null) {
			name = getSysCust().getName();
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		if (getSysCust() != null && address == null) {
			address = getSysCust().getAddress();
		}
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		if (getSysCust() != null && postalCode == null) {
			postalCode = getSysCust().getPostalCode();
		}
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getWebsite() {
		if (getSysCust() != null && website == null) {
			website = getSysCust().getWebsite();
		}
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getRemark() {
		if (getSysCust() != null && remark == null) {
			remark = getSysCust().getRemark();
		}
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBaseIndustryName() {
		if (getBaseIndustry() != null && baseIndustryName == null) {
			baseIndustryName = getBaseIndustry().getIndustryName();
		}
		return baseIndustryName;
	}

	public void setBaseIndustryName(String baseIndustryName) {
		this.baseIndustryName = baseIndustryName;
	}

	public String getBaseIndustryId() {
		if (getBaseIndustry() != null && baseIndustryId == null) {
			baseIndustryId = String.valueOf(getBaseIndustry().getId());
		}
		return baseIndustryId;
	}

	public void setBaseIndustryId(String baseIndustryId) {
		this.baseIndustryId = baseIndustryId;
	}

	public String getBaseTypeName() {
		if (getBaseType() != null && baseTypeName == null) {
			baseTypeName = getBaseType().getTypeName();
		}
		return baseTypeName;
	}

	public void setBaseTypeName(String baseTypeName) {
		this.baseTypeName = baseTypeName;
	}

	public String getBaseTypeId() {
		if (getBaseType() != null && baseTypeId == null) {
			baseTypeId = String.valueOf(getBaseType().getId());
		}
		return baseTypeId;
	}

	public void setBaseTypeId(String baseTypeId) {
		this.baseTypeId = baseTypeId;
	}

	public String getBaseStateName() {
		if (getBaseState() != null && baseStateName == null) {
			baseStateName = getBaseState().getStateName();
		}
		return baseStateName;
	}

	public void setBaseStateName(String baseStateName) {
		this.baseStateName = baseStateName;
	}

	public String getBaseStateId() {
		if (getBaseState() != null && baseStateId == null) {
			baseStateId = String.valueOf(getBaseState().getId());
		}
		return baseStateId;
	}

	public void setBaseStateId(String baseStateId) {
		this.baseStateId = baseStateId;
	}

	public String getBaseSourceName() {
		if (getBaseSource() != null && baseSourceName == null) {
			baseSourceName = getBaseSource().getSourceName();
		}
		return baseSourceName;
	}

	public void setBaseSourceName(String baseSourceName) {
		this.baseSourceName = baseSourceName;
	}

	public String getBaseSourceId() {
		if (getBaseSource() != null && baseSourceId == null) {
			baseSourceId = String.valueOf(getBaseSource().getId());
		}
		return baseSourceId;
	}

	public void setBaseSourceId(String baseSourceId) {
		this.baseSourceId = baseSourceId;
	}

	public String getFeature() {
		if (getSysCust() != null && feature == null) {
			feature = getSysCust().getFeature();
		}
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public SysUser getPrivateUser() {
		if (getSysCust() != null && privateUser == null) {
			privateUser = getSysCust().getPrivateUser();
		}
		return privateUser;
	}

	public void setPrivateUser(SysUser privateUser) {
		this.privateUser = privateUser;
	}

	public String getPrivateUserUsername() {
		if (getPrivateUser() != null && privateUserUsername == null) {
			privateUserUsername = getPrivateUser().getUsername();
		}
		return privateUserUsername;
	}

	public void setPrivateUserUsername(String privateUserUsername) {
		this.privateUserUsername = privateUserUsername;
	}

}
