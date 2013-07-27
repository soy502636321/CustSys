package soy.basic.database.entity;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */

public class SysUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private SysRole sysRole;
	private String username;
	private String password;
	private String name;
	private String gender;
	private String phoneTh1;
	private String phoneTh2;
	private String emailTh1;
	private String emailTh2;
	private String userState;
	private String remark;

	// Constructors

	/** default constructor */
	public SysUser() {
	}

	/** full constructor */
	public SysUser(SysRole sysRole, String username, String password,
			String name, String gender, String phoneTh1, String phoneTh2,
			String emailTh1, String emailTh2, String userState, String remark) {
		this.sysRole = sysRole;
		this.username = username;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.phoneTh1 = phoneTh1;
		this.phoneTh2 = phoneTh2;
		this.emailTh1 = emailTh1;
		this.emailTh2 = emailTh2;
		this.userState = userState;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SysRole getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneTh1() {
		return this.phoneTh1;
	}

	public void setPhoneTh1(String phoneTh1) {
		this.phoneTh1 = phoneTh1;
	}

	public String getPhoneTh2() {
		return this.phoneTh2;
	}

	public void setPhoneTh2(String phoneTh2) {
		this.phoneTh2 = phoneTh2;
	}

	public String getEmailTh1() {
		return this.emailTh1;
	}

	public void setEmailTh1(String emailTh1) {
		this.emailTh1 = emailTh1;
	}

	public String getEmailTh2() {
		return this.emailTh2;
	}

	public void setEmailTh2(String emailTh2) {
		this.emailTh2 = emailTh2;
	}

	public String getUserState() {
		return this.userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}