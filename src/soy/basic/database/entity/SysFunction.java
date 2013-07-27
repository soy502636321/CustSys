package soy.basic.database.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * SysFunction entity. @author MyEclipse Persistence Tools
 */

public class SysFunction implements java.io.Serializable {

	// Fields

	private Integer id;
	private SysFunction sysFunction;
	private String functionName;
	private String functionUrl;
	private String functionType;
	private String remark;
	private Set sysFunctions = new HashSet(0);
	private Set roleFunctions = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysFunction() {
	}

	/** full constructor */
	public SysFunction(SysFunction sysFunction, String functionName,
			String functionUrl, String functionType, String remark,
			Set sysFunctions, Set roleFunctions) {
		this.sysFunction = sysFunction;
		this.functionName = functionName;
		this.functionUrl = functionUrl;
		this.functionType = functionType;
		this.remark = remark;
		this.sysFunctions = sysFunctions;
		this.roleFunctions = roleFunctions;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SysFunction getSysFunction() {
		return this.sysFunction;
	}

	public void setSysFunction(SysFunction sysFunction) {
		this.sysFunction = sysFunction;
	}

	public String getFunctionName() {
		return this.functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getFunctionUrl() {
		return this.functionUrl;
	}

	public void setFunctionUrl(String functionUrl) {
		this.functionUrl = functionUrl;
	}

	public String getFunctionType() {
		return this.functionType;
	}

	public void setFunctionType(String functionType) {
		this.functionType = functionType;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getSysFunctions() {
		return this.sysFunctions;
	}

	public void setSysFunctions(Set sysFunctions) {
		this.sysFunctions = sysFunctions;
	}

	public Set getRoleFunctions() {
		return this.roleFunctions;
	}

	public void setRoleFunctions(Set roleFunctions) {
		this.roleFunctions = roleFunctions;
	}

}