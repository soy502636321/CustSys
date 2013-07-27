package soy.basic.database.entity;

import java.util.Date;

/**
 * 维护记录
 * @author 小胡
 *
 */

public class SysMaintain implements java.io.Serializable {

	// 属性

	private Integer id; //维护主键
	private BaseMaintaintype baseMaintaintype; //维护类型
	private SysCust sysCust;// 客户外键
	private Date maintainTime; //维护时间
	private String name; //联系人名称
	private String activeDesc; //活动描述
	private String result; //维护结果
	private String remark; //备注

	// 构造方法

	/**
	 * 默认的构造方法
	 */
	public SysMaintain() {
	}

	/**
	 * 全属性构造方法
	 * @param baseMaintaintype
	 * @param sysCust
	 * @param maintainTime
	 * @param name
	 * @param activeDesc
	 * @param result
	 * @param remark
	 */
	public SysMaintain(BaseMaintaintype baseMaintaintype, SysCust sysCust,
			Date maintainTime, String name, String activeDesc, String result,
			String remark) {
		this.baseMaintaintype = baseMaintaintype;
		this.sysCust = sysCust;
		this.maintainTime = maintainTime;
		this.name = name;
		this.activeDesc = activeDesc;
		this.result = result;
		this.remark = remark;
	}

	// 属性访问

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BaseMaintaintype getBaseMaintaintype() {
		return this.baseMaintaintype;
	}

	public void setBaseMaintaintype(BaseMaintaintype baseMaintaintype) {
		this.baseMaintaintype = baseMaintaintype;
	}

	public SysCust getSysCust() {
		return this.sysCust;
	}

	public void setSysCust(SysCust sysCust) {
		this.sysCust = sysCust;
	}

	public Date getMaintainTime() {
		return this.maintainTime;
	}

	public void setMaintainTime(Date maintainTime) {
		this.maintainTime = maintainTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActiveDesc() {
		return this.activeDesc;
	}

	public void setActiveDesc(String activeDesc) {
		this.activeDesc = activeDesc;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}