package soy.basic.vo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.BaseMaintaintype;
import soy.basic.database.entity.SysCust;
import soy.basic.database.entity.SysMaintain;

public class SysMaintainVO {
	private static final Logger log = LoggerFactory
			.getLogger(SysMaintainVO.class);

	private SysMaintain sysMaintain;

	private String id; // 维护主键
	private BaseMaintaintype baseMaintaintype; // 维护类型
	private String baseMaintaintypeId;

	private SysCust sysCust;// 客户外键
	private String sysCustId;

	private Date maintainTime; // 维护时间
	private Date maintainTimeStart;
	private Date maintainTimeEnd;

	private String name; // 联系人名称
	private String activeDesc; // 活动描述
	private String result; // 维护结果
	private String remark; // 备注

	public SysMaintainVO() {
	}

	public SysMaintainVO(SysMaintain sysMaintain) {
		this.sysMaintain = sysMaintain;
	}

	public SysMaintain getSysMaintain() {
		return sysMaintain;
	}

	public void setSysMaintain(SysMaintain sysMaintain) {
		this.sysMaintain = sysMaintain;
	}

	public String getId() {
		if (getSysMaintain() != null && id == null) {
			id = String.valueOf(getSysMaintain().getId());
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BaseMaintaintype getBaseMaintaintype() {
		if (getSysMaintain() != null && baseMaintaintype == null) {
			baseMaintaintype = getSysMaintain().getBaseMaintaintype();
		}
		return baseMaintaintype;
	}

	public void setBaseMaintaintype(BaseMaintaintype baseMaintaintype) {
		this.baseMaintaintype = baseMaintaintype;
	}

	public String getBaseMaintaintypeId() {
		if (getBaseMaintaintype() != null && baseMaintaintypeId == null) {
			baseMaintaintypeId = String.valueOf(getBaseMaintaintype().getId());
		}
		return baseMaintaintypeId;
	}

	public void setBaseMaintaintypeId(String baseMaintaintypeId) {
		this.baseMaintaintypeId = baseMaintaintypeId;
	}

	public SysCust getSysCust() {
		if (getSysMaintain() != null && sysCust == null) {
			sysCust = getSysMaintain().getSysCust();
		}
		return sysCust;
	}

	public void setSysCust(SysCust sysCust) {
		this.sysCust = sysCust;
	}

	public String getSysCustId() {
		if (getSysCust() != null && sysCustId == null) {
			sysCustId = String.valueOf(getSysCust().getId());
		}
		return sysCustId;
	}

	public void setSysCustId(String sysCustId) {
		this.sysCustId = sysCustId;
	}

	public Date getMaintainTime() {
		if (getSysMaintain() != null && maintainTime == null) {
			maintainTime = getSysMaintain().getMaintainTime();
		}
		return maintainTime;
	}

	public void setMaintainTime(Date maintainTime) {
		this.maintainTime = maintainTime;
	}

	public String getName() {
		if (getSysMaintain() != null && name == null) {
			name = getSysMaintain().getName();
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActiveDesc() {
		if (getSysMaintain() != null && activeDesc == null) {
			activeDesc = getSysMaintain().getActiveDesc();
		}
		return activeDesc;
	}

	public void setActiveDesc(String activeDesc) {
		this.activeDesc = activeDesc;
	}

	public String getResult() {
		if (getSysMaintain() != null && result == null) {
			result = getSysMaintain().getResult();
		}
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRemark() {
		if (getSysMaintain() != null && remark == null) {
			remark = getSysMaintain().getRemark();
		}
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getMaintainTimeStart() {
		return maintainTimeStart;
	}

	public void setMaintainTimeStart(Date maintainTimeStart) {
		this.maintainTimeStart = maintainTimeStart;
	}

	public Date getMaintainTimeEnd() {
		return maintainTimeEnd;
	}

	public void setMaintainTimeEnd(Date maintainTimeEnd) {
		this.maintainTimeEnd = maintainTimeEnd;
	}

}
