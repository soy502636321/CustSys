package soy.basic.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.SysRole;
import soy.basic.database.entity.SysUser;
import soy.util.ConfigUtil;

public class SysUserVO {
	private static final Logger log = LoggerFactory.getLogger(SysUserVO.class);

	private SysUser sysUser;

	private String id;
	private SysRole sysRole;
	private String sysRoleName;
	private String sysRoleId;

	private String username;
	private String password;
	private String name;
	private String gender;
	private String genderNo;

	private String phoneTh1;
	private String phoneTh2;
	private String emailTh1;
	private String emailTh2;
	private String userState;
	private String userStateNo;

	private String remark;

	public SysUserVO() {
	}

	public SysUserVO(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public String getId() {
		if (getSysUser() != null && id == null) {
			id = String.valueOf(getSysUser().getId());
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SysRole getSysRole() {
		if (getSysUser() != null && sysRole == null) {
			sysRole = getSysUser().getSysRole();
		}
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public String getUsername() {
		if (getSysUser() != null && username == null) {
			username = getSysUser().getUsername();
		}
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
//		if (getSysUser() != null && password == null) {
//			password = getSysUser().getPassword();
//		}
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		if (getSysUser() != null && name == null) {
			name = getSysUser().getName();
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		if (getSysUser() != null && gender == null) {
			gender = getSysUser().getGender();
		}
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneTh1() {
		if (getSysUser() != null && phoneTh1 == null) {
			phoneTh1 = getSysUser().getPhoneTh1();
		}
		return phoneTh1;
	}

	public void setPhoneTh1(String phoneTh1) {
		this.phoneTh1 = phoneTh1;
	}

	public String getPhoneTh2() {
		if (getSysUser() != null && phoneTh2 == null) {
			phoneTh2 = getSysUser().getPhoneTh2();
		}
		return phoneTh2;
	}

	public void setPhoneTh2(String phoneTh2) {
		this.phoneTh2 = phoneTh2;
	}

	public String getEmailTh1() {
		if (getSysUser() != null && emailTh1 == null) {
			emailTh1 = getSysUser().getEmailTh1();
		}
		return emailTh1;
	}

	public void setEmailTh1(String emailTh1) {
		this.emailTh1 = emailTh1;
	}

	public String getEmailTh2() {
		if (getSysUser() != null && emailTh2 == null) {
			emailTh2 = getEmailTh2();
		}
		return emailTh2;
	}

	public void setEmailTh2(String emailTh2) {
		this.emailTh2 = emailTh2;
	}

	public String getUserState() {
		if (getSysUser() != null && userState == null) {
			userState = getSysUser().getUserState();
		}
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getRemark() {
		if (getSysUser() != null && remark == null) {
			remark = getSysUser().getRemark();
		}
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSysRoleName() {
		if (getSysRole() != null && sysRoleName == null) {
			sysRoleName = getSysRole().getRoleName();
		}
		return sysRoleName;
	}

	public void setSysRoleName(String sysRoleName) {

		this.sysRoleName = sysRoleName;
	}

	public String getGenderNo() {
		if (getGender() != null && genderNo == null) {
			genderNo = ConfigUtil.getConfigUtil().findValue("0001", getGender());
		}
		return genderNo;
	}

	public void setGenderNo(String genderNo) {
		this.genderNo = genderNo;
	}

	public String getUserStateNo() {
		if (getUserState() != null && userStateNo == null) {
			userStateNo = ConfigUtil.getConfigUtil().findValue("0003", getUserState());
		}
		return userStateNo;
	}

	public void setUserStateNo(String userStateNo) {
		this.userStateNo = userStateNo;
	}

	public String getSysRoleId() {
		if (getSysRole() != null && sysRoleId == null) {
			sysRoleId = String.valueOf(getSysRole().getId());
		}
		return sysRoleId;
	}

	public void setSysRoleId(String sysRoleId) {
		this.sysRoleId = sysRoleId;
	}

}
