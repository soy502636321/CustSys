package soy.basic.database.entity;

import java.io.Serializable;

/**
 * @author XiaoLiang·Hu
 * 
 */
public class SysRecord implements Serializable {
	private Integer id;
	private SysBusiness sysBusiness;
	private SysUser sysUser;
	private BaseProduction baseProduction;
	private Double amount;
	private Double total;
	private Double debit;

	// 构造方法
	/**
	 * 默认的构造方法
	 */

	public SysRecord() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SysBusiness getSysBusiness() {
		return sysBusiness;
	}

	public void setSysBusiness(SysBusiness sysBusiness) {
		this.sysBusiness = sysBusiness;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public BaseProduction getBaseProduction() {
		return baseProduction;
	}

	public void setBaseProduction(BaseProduction baseProduction) {
		this.baseProduction = baseProduction;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getDebit() {
		return debit;
	}

	public void setDebit(Double debit) {
		this.debit = debit;
	}

}
