package soy.basic.database.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author XiaoLiang·Hu
 * 
 */
public class SysSupplier implements Serializable {
	private Integer id;
	private String name;
	private String gender;
	private String phoneTh1;
	private String phoneTh2;
	private String qq;
	private String email;
	private BaseMain mainTh1;
	private BaseMain mainTh2;
	private BaseMain mainTh3;
	private BaseMain mainTh4;
	private String other;
	private Double price;
	private String remark;

	// private BaseClass baseClass;
	// private BaseQuality baseQuality;
	private Set supplierClasses = new HashSet(0);
	private Set supplierQualities = new HashSet(0);

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneTh1() {
		return phoneTh1;
	}

	public void setPhoneTh1(String phoneTh1) {
		this.phoneTh1 = phoneTh1;
	}

	public String getPhoneTh2() {
		return phoneTh2;
	}

	public void setPhoneTh2(String phoneTh2) {
		this.phoneTh2 = phoneTh2;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getSupplierClasses() {
		return supplierClasses;
	}

	public void setSupplierClasses(Set supplierClasses) {
		this.supplierClasses = supplierClasses;
	}

	public Set getSupplierQualities() {
		return supplierQualities;
	}

	public void setSupplierQualities(Set supplierQualities) {
		this.supplierQualities = supplierQualities;
	}

	public BaseMain getMainTh1() {
		return mainTh1;
	}

	public void setMainTh1(BaseMain mainTh1) {
		this.mainTh1 = mainTh1;
	}

	public BaseMain getMainTh2() {
		return mainTh2;
	}

	public void setMainTh2(BaseMain mainTh2) {
		this.mainTh2 = mainTh2;
	}

	public BaseMain getMainTh3() {
		return mainTh3;
	}

	public void setMainTh3(BaseMain mainTh3) {
		this.mainTh3 = mainTh3;
	}

	public BaseMain getMainTh4() {
		return mainTh4;
	}

	public void setMainTh4(BaseMain mainTh4) {
		this.mainTh4 = mainTh4;
	}

	
}
