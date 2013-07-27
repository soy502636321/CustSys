package soy.basic.database.entity;

/**
 * RoleFunction entity. @author MyEclipse Persistence Tools
 */

public class RoleFunction implements java.io.Serializable {

	// Fields

	private RoleFunctionId id;
	private SysFunction sysFunction;
	private SysRole sysRole;

	// Constructors

	/** default constructor */
	public RoleFunction() {
	}

	/** minimal constructor */
	public RoleFunction(RoleFunctionId id) {
		this.id = id;
	}

	/** full constructor */
	public RoleFunction(RoleFunctionId id, SysFunction sysFunction,
			SysRole sysRole) {
		this.id = id;
		this.sysFunction = sysFunction;
		this.sysRole = sysRole;
	}

	// Property accessors

	public RoleFunctionId getId() {
		return this.id;
	}

	public void setId(RoleFunctionId id) {
		this.id = id;
	}

	public SysFunction getSysFunction() {
		return this.sysFunction;
	}

	public void setSysFunction(SysFunction sysFunction) {
		this.sysFunction = sysFunction;
	}

	public SysRole getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

}