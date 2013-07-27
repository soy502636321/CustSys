package soy.basic.database.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * SysRole entity. @author MyEclipse Persistence Tools
 */

public class SysRole implements java.io.Serializable {

	// Fields

	private Integer id;
	private String roleName;
	private String remark;
	private Set sysUsers = new HashSet(0);
	private Set roleFunctions = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysRole() {
	}

	/** full constructor */
	public SysRole(String roleName, String remark, Set sysUsers,
			Set roleFunctions) {
		this.roleName = roleName;
		this.remark = remark;
		this.sysUsers = sysUsers;
		this.roleFunctions = roleFunctions;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getSysUsers() {
		return this.sysUsers;
	}

	public void setSysUsers(Set sysUsers) {
		this.sysUsers = sysUsers;
	}

	public Set getRoleFunctions() {
		return this.roleFunctions;
	}

	public void setRoleFunctions(Set roleFunctions) {
		this.roleFunctions = roleFunctions;
	}

}