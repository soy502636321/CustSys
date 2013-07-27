package soy.basic.database.entity;

/**
 * RoleFunctionId entity. @author MyEclipse Persistence Tools
 */

public class RoleFunctionId implements java.io.Serializable {

	// Fields

	private SysRole sysRole;
	private SysFunction sysFunction;

	// Constructors

	/** default constructor */
	public RoleFunctionId() {
	}

	/** full constructor */
	public RoleFunctionId(SysRole sysRole, SysFunction sysFunction) {
		this.sysRole = sysRole;
		this.sysFunction = sysFunction;
	}

	// Property accessors

	public SysRole getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public SysFunction getSysFunction() {
		return this.sysFunction;
	}

	public void setSysFunction(SysFunction sysFunction) {
		this.sysFunction = sysFunction;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RoleFunctionId))
			return false;
		RoleFunctionId castOther = (RoleFunctionId) other;

		return ((this.getSysRole() == castOther.getSysRole()) || (this
				.getSysRole() != null && castOther.getSysRole() != null && this
				.getSysRole().equals(castOther.getSysRole())))
				&& ((this.getSysFunction() == castOther.getSysFunction()) || (this
						.getSysFunction() != null
						&& castOther.getSysFunction() != null && this
						.getSysFunction().equals(castOther.getSysFunction())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSysRole() == null ? 0 : this.getSysRole().hashCode());
		result = 37
				* result
				+ (getSysFunction() == null ? 0 : this.getSysFunction()
						.hashCode());
		return result;
	}

}