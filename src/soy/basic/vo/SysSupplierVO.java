package soy.basic.vo;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.BaseClass;
import soy.basic.database.entity.BaseMain;
import soy.basic.database.entity.BaseQuality;
import soy.basic.database.entity.BaseSupply;
import soy.basic.database.entity.SysSupplier;
import soy.util.ConfigUtil;
import soy.util.SystemUtil;

/**
 * @author XiaoLiang·Hu
 * 
 */
public class SysSupplierVO {
	private static final Logger log = LoggerFactory
			.getLogger(SysSupplierVO.class);

	private SysSupplier sysSupplier;

	private String id; // 编号
	private String name; // 姓名
	private String gender; // 性别
	private String genderId;
	private String phoneTh1;
	private String phoneTh2;
	private String qq;
	private String email;
	private BaseMain mainTh1;
	private String mainTh1Id;

	private BaseMain mainTh2;
	private String mainTh2Id;

	private BaseMain mainTh3;
	private String mainTh3Id;

	private BaseMain mainTh4;
	private String mainTh4Id;

	private String other;
	private Double price;
	private String priceString;
	private String remark;

	private Set supplierClasses = null;
	private Integer[] supplierClassId;

	private Set supplierQualities = null;
	private Integer[] supplierQualityId;

	public SysSupplierVO() {
	}

	public SysSupplierVO(SysSupplier sysSupplier) {
		this.sysSupplier = sysSupplier;
	}

	public SysSupplier getSysSupplier() {
		return sysSupplier;
	}

	public void setSysSupplier(SysSupplier sysSupplier) {
		this.sysSupplier = sysSupplier;
	}

	public String getId() {
		if (getSysSupplier() != null && id == null) {
			id = String.valueOf(getSysSupplier().getId());
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		if (getSysSupplier() != null && name == null) {
			name = getSysSupplier().getName();
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		if (getGenderId() != null && gender == null) {
			gender = ConfigUtil.getConfigUtil()
					.findValue("0001", getGenderId());
		}
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneTh1() {
		if (getSysSupplier() != null && phoneTh1 == null) {
			phoneTh1 = getSysSupplier().getPhoneTh1();
		}
		return phoneTh1;
	}

	public void setPhoneTh1(String phoneTh1) {
		this.phoneTh1 = phoneTh1;
	}

	public String getPhoneTh2() {
		if (getSysSupplier() != null && phoneTh1 == null) {
			phoneTh2 = getSysSupplier().getPhoneTh2();
		}
		return phoneTh2;
	}

	public void setPhoneTh2(String phoneTh2) {
		this.phoneTh2 = phoneTh2;
	}

	public String getQq() {
		if (getSysSupplier() != null && qq == null) {
			qq = getSysSupplier().getQq();
		}
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		if (getSysSupplier() != null && email == null) {
			email = getSysSupplier().getEmail();
		}
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BaseMain getMainTh1() {
		if (getSysSupplier() != null && mainTh1 == null) {
			mainTh1 = getSysSupplier().getMainTh1();
		}
		return mainTh1;
	}

	public void setMainTh1(BaseMain mainTh1) {
		this.mainTh1 = mainTh1;
	}

	public BaseMain getMainTh2() {
		if (getSysSupplier() != null && mainTh2 == null) {
			mainTh2 = getSysSupplier().getMainTh2();
		}
		return mainTh2;
	}

	public void setMainTh2(BaseMain mainTh2) {
		this.mainTh2 = mainTh2;
	}

	public BaseMain getMainTh3() {
		if (getSysSupplier() != null && mainTh3 == null) {
			mainTh3 = getSysSupplier().getMainTh3();
		}
		return mainTh3;
	}

	public void setMainTh3(BaseMain mainTh3) {
		this.mainTh3 = mainTh3;
	}

	public BaseMain getMainTh4() {
		if (getSysSupplier() != null && mainTh4 == null) {
			mainTh4 = getSysSupplier().getMainTh4();
		}
		return mainTh4;
	}

	public void setMainTh4(BaseMain mainTh4) {
		this.mainTh4 = mainTh4;
	}

	public String getOther() {
		if (getSysSupplier() != null && other == null) {
			other = getSysSupplier().getOther();
		}
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public Double getPrice() {
		if (getSysSupplier() != null && price == null) {
			price = getSysSupplier().getPrice();
		}
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getRemark() {
		if (getSysSupplier() != null && remark == null) {
			remark = getSysSupplier().getRemark();
		}
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getGenderId() {
		if (getSysSupplier() != null && genderId == null) {
			genderId = getSysSupplier().getGender();
		}
		return genderId;
	}

	public void setGenderId(String genderId) {
		this.genderId = genderId;
	}

	public Set getSupplierClasses() {
		if (getSysSupplier() != null && supplierClasses == null
				&& !SystemUtil.isNull(getSysSupplier().getSupplierClasses())) {
			supplierClasses = new HashSet<BaseClassVO>();
			for (Object object : getSysSupplier().getSupplierClasses()
					.toArray()) {
				supplierClasses.add(new BaseClassVO((BaseClass) object));
			}
		}
		return supplierClasses;
	}

	public void setSupplierClasses(Set supplierClasses) {
		this.supplierClasses = supplierClasses;
	}

	public Set getSupplierQualities() {
		if (getSysSupplier() != null && supplierQualities == null
				&& !SystemUtil.isNull(getSysSupplier().getSupplierQualities())) {
			supplierQualities = new HashSet<BaseQualityVO>();
			for (Object object : getSysSupplier().getSupplierQualities()) {
				supplierQualities.add(new BaseSupplyVO((BaseSupply) object));
			}
		} 
		return supplierQualities;
	}

	public void setSupplierQualities(Set supplierQualities) {
		this.supplierQualities = supplierQualities;
	}

	public String getMainTh1Id() {
		if (getMainTh1() != null && mainTh1Id == null) {
			mainTh1Id = String.valueOf(getMainTh1().getId());
		}
		return mainTh1Id;
	}

	public void setMainTh1Id(String mainTh1Id) {
		this.mainTh1Id = mainTh1Id;
	}

	public String getMainTh2Id() {
		if (getMainTh2() != null && mainTh2Id == null) {
			mainTh2Id = String.valueOf(getMainTh2().getId());
		}
		return mainTh2Id;
	}

	public void setMainTh2Id(String mainTh2Id) {
		this.mainTh2Id = mainTh2Id;
	}

	public String getMainTh3Id() {
		if (getMainTh3() != null && mainTh3Id == null) {
			mainTh3Id = String.valueOf(getMainTh3().getId());
		}
		return mainTh3Id;
	}

	public void setMainTh3Id(String mainTh3Id) {
		this.mainTh3Id = mainTh3Id;
	}

	public Integer[] getSupplierClassId() {
		return supplierClassId;
	}

	public void setSupplierClassId(Integer[] supplierClassId) {
		this.supplierClassId = supplierClassId;
	}

	public Integer[] getSupplierQualityId() {
		return supplierQualityId;
	}

	public void setSupplierQualityId(Integer[] supplierQualityId) {
		this.supplierQualityId = supplierQualityId;
	}

	public String getMainTh4Id() {
		if (getMainTh4() != null && mainTh4Id == null) {
			mainTh4Id = String.valueOf(getMainTh4().getId());
		}
		return mainTh4Id;
	}

	public void setMainTh4Id(String mainTh4Id) {
		this.mainTh4Id = mainTh4Id;
	}

	public String getPriceString() {
		return priceString;
	}

	public void setPriceString(String priceString) {
		this.priceString = priceString;
	}

	
}
