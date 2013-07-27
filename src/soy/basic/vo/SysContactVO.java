package soy.basic.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.SysContact;
import soy.basic.database.entity.SysCust;
import soy.util.ConfigUtil;

public class SysContactVO {
	private static final Logger log = LoggerFactory
			.getLogger(SysContactVO.class);

	private SysContact sysContact;

	private String id; // 联系方式主键
	private SysCust sysCust; // 客户外键
	private String sysCustId;

	private String name; // 姓名
	private String gender; // 性别
	private String genderId; //

	private String position; // 职务
	private String mobile; // 手机号码
	private String office; // 办公室号码
	private String familty; // 家庭号码
	private String qq; // QQ
	private String msn; // MSN
	private String weibo; // 微博
	private String address; // 家庭地址
	private String fax; // 传真
	private String email; // 邮件
	private String interests; // 兴趣爱好
	private String remark; // 备注

	public SysContactVO() {
	}

	public SysContactVO(SysContact sysContact) {
		this.sysContact = sysContact;
	}

	public String getId() {
		if (getSysContact() != null && id == null) {
			id = String.valueOf(getSysContact().getId());
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SysCust getSysCust() {
		if (getSysContact() != null && sysCust == null) {
			sysCust = getSysContact().getSysCust();
		}
		return sysCust;
	}

	public void setSysCust(SysCust sysCust) {
		this.sysCust = sysCust;
	}

	public String getName() {
		if (getSysContact() != null && name == null) {
			name = getSysContact().getName();
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		if (getSysContact() != null && position == null) {
			this.position = getSysContact().getPosition();
		}
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getMobile() {
		if (getSysContact() != null && mobile == null) {
			mobile = getSysContact().getMobile();
		}
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOffice() {
		if (getSysContact() != null && office == null) {
			office = getSysContact().getOffice();
		}
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getFamilty() {
		if (getSysContact() != null && familty == null) {
			familty = getSysContact().getFamilty();
		}
		return familty;
	}

	public void setFamilty(String familty) {
		this.familty = familty;
	}

	public String getQq() {
		if (getSysContact() != null && qq == null) {
			qq = getSysContact().getQq();
		}
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMsn() {
		if (getSysContact() != null && msn == null) {
			msn = getSysContact().getMsn();
		}
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getAddress() {
		if (getSysContact() != null && address == null) {
			address = getSysContact().getAddress();
		}
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFax() {
		if (getSysContact() != null && fax == null) {
			fax = getSysContact().getFax();
		}
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		if (getSysContact() != null && email == null) {
			email = getSysContact().getEmail();
		}
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInterests() {
		if (getSysContact() != null && interests == null) {
			interests = getSysContact().getInterests();
		}
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getRemark() {
		if (getSysContact() != null && remark == null) {
			remark = getSysContact().getRemark();
		}
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public SysContact getSysContact() {
		return sysContact;
	}

	public void setSysContact(SysContact sysContact) {
		this.sysContact = sysContact;
	}

	public String getSysCustId() {
		return sysCustId;
	}

	public void setSysCustId(String sysCustId) {
		this.sysCustId = sysCustId;
	}

	public String getGender() {
		if (getSysContact() != null && gender == null) {
			gender = ConfigUtil.getConfigUtil().findValue(
					ConfigUtil.KEY_GENDERS, getSysContact().getGender());
		}
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getWeibo() {
		if (getSysContact() != null && weibo == null) {
			weibo = getSysContact().getWeibo();
		}
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getGenderId() {
		if (getSysContact() != null && genderId == null) {
			genderId = getSysContact().getGender();
		}
		return genderId;
	}

	public void setGenderId(String genderId) {
		this.genderId = genderId;
	}

}
