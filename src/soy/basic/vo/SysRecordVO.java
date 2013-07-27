package soy.basic.vo;

import soy.basic.database.entity.SysRecord;
import soy.basic.database.entity.SysUser;

/**
 * @author XiaoLiang·Hu
 * 
 */
public class SysRecordVO {
	private SysRecord sysRecord;

	private String id;
	private SysUser sysUser;
	private Double amount;
	private Double total;
	private Double debit;

	public SysRecordVO() {
	}

	public SysRecordVO(SysRecord sysRecord) {
		this.sysRecord = sysRecord;
	}

	public SysRecord getSysRecord() {
		return sysRecord;
	}

	public void setSysRecord(SysRecord sysRecord) {
		this.sysRecord = sysRecord;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
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
