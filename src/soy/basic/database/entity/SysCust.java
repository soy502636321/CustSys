package soy.basic.database.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 客户
 * 
 * @author 小胡
 * 
 */

public class SysCust implements java.io.Serializable {

	// 属性

	private Integer id; // 客户主键
	private BaseIndustry baseIndustry; // 行业
	private BaseType baseType; // 客户类型
	private BaseState baseState; // 客户状态
	private BaseSource baseSource; // 客户来源
	private String name; // 姓名
	private String address; // 地址
	private String postalCode; // 邮政编码
	private String website; // 网址
	private String remark; // 备注
	private String feature;// 特点
	private String custType; // 客户类型 /开发/正常
	private SysUser privateUser; // 开发人
	private Set sysMaintains = new HashSet(0);
	private Set sysBusinesses = new HashSet(0);
	private Set sysContacts = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysCust() {
	}

	/** minimal constructor */
	public SysCust(String name) {
		this.name = name;
	}

	/** full constructor */
	public SysCust(BaseIndustry baseIndustry, BaseType baseType,
			BaseState baseState, BaseSource baseSource, String name,
			String address, String postalCode, String website, String remark,
			Set sysMaintains, Set sysBusinesses, Set sysContacts) {
		this.baseIndustry = baseIndustry;
		this.baseType = baseType;
		this.baseState = baseState;
		this.baseSource = baseSource;
		this.name = name;
		this.address = address;
		this.postalCode = postalCode;
		this.website = website;
		this.remark = remark;
		this.sysMaintains = sysMaintains;
		this.sysBusinesses = sysBusinesses;
		this.sysContacts = sysContacts;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BaseIndustry getBaseIndustry() {
		return this.baseIndustry;
	}

	public void setBaseIndustry(BaseIndustry baseIndustry) {
		this.baseIndustry = baseIndustry;
	}

	public BaseType getBaseType() {
		return this.baseType;
	}

	public void setBaseType(BaseType baseType) {
		this.baseType = baseType;
	}

	public BaseState getBaseState() {
		return this.baseState;
	}

	public void setBaseState(BaseState baseState) {
		this.baseState = baseState;
	}

	public BaseSource getBaseSource() {
		return this.baseSource;
	}

	public void setBaseSource(BaseSource baseSource) {
		this.baseSource = baseSource;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getSysMaintains() {
		return this.sysMaintains;
	}

	public void setSysMaintains(Set sysMaintains) {
		this.sysMaintains = sysMaintains;
	}

	public Set getSysBusinesses() {
		return this.sysBusinesses;
	}

	public void setSysBusinesses(Set sysBusinesses) {
		this.sysBusinesses = sysBusinesses;
	}

	public Set getSysContacts() {
		return this.sysContacts;
	}

	public void setSysContacts(Set sysContacts) {
		this.sysContacts = sysContacts;
	}

	public String getFeature() {
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
		return privateUser;
	}

	public void setPrivateUser(SysUser privateUser) {
		this.privateUser = privateUser;
	}

}