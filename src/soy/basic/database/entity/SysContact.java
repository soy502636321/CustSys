package soy.basic.database.entity;

/**
 * 联系方式
 * 
 * @author 小胡
 * 
 */
public class SysContact implements java.io.Serializable {

	// 属性

	private Integer id; // 联系方式主键
	private SysCust sysCust; // 客户外键
	private String name; // 姓名
	private String position; // 职务
	private String mobile; // 手机号码
	private String office; // 办公室号码
	private String familty; // 家庭号码
	private String qq; // QQ
	private String msn; // MSN
	private String address; // 家庭地址
	private String fax; // 传真
	private String email; // 邮件
	private String interests; // 兴趣爱好
	private String remark; // 备注
	private String gender; // 性别
	private String weibo; // 微博

	// 构造方法

	/**
	 * 默认的构造方法
	 */
	public SysContact() {
	}

	/**
	 * 全属性构造方法
	 * 
	 * @param sysCust
	 * @param name
	 * @param position
	 * @param mobile
	 * @param office
	 * @param familty
	 * @param qq
	 * @param msn
	 * @param address
	 * @param fax
	 * @param email
	 * @param interests
	 * @param remark
	 */
	public SysContact(SysCust sysCust, String name, String position,
			String mobile, String office, String familty, String qq,
			String msn, String address, String fax, String email,
			String interests, String remark) {
		this.sysCust = sysCust;
		this.name = name;
		this.position = position;
		this.mobile = mobile;
		this.office = office;
		this.familty = familty;
		this.qq = qq;
		this.msn = msn;
		this.address = address;
		this.fax = fax;
		this.email = email;
		this.interests = interests;
		this.remark = remark;
	}

	// 属性访问

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SysCust getSysCust() {
		return this.sysCust;
	}

	public void setSysCust(SysCust sysCust) {
		this.sysCust = sysCust;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOffice() {
		return this.office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getFamilty() {
		return this.familty;
	}

	public void setFamilty(String familty) {
		this.familty = familty;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMsn() {
		return this.msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInterests() {
		return this.interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

}