package soy.basic.database.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 业务
 * 
 * @author 小胡
 * 
 */

public class SysBusiness implements java.io.Serializable {

	// 属性

	private Integer id; // 业务主键
	private BasePayment basePayment; // 付款方式
	private SysCust sysCust; // 客户外键
	private BaseDelivery baseDelivery; // 交付方式
	private String businessNo; // 业务编号
	private String contractNo; // 合同编号
	private String theme; // 主题
	private Date businessTime; // 订单时间
	private Date deliveryTime; // 交付时间
	private Double quantity; // 数量
	private Double unitprice; // 单价
	private Double estimatedAmount; // 预估金额
	private Double actualAmount; // 实际金额
	private String invoice; // 开票
	private String complaints; // 客户投诉
	private String remark; // 备注
	private String claim; // 要求

	private Double correspondsPrice; // 对应单价
	private Double pageNumber; // 页码
	private Double duty; // 税
	private Double cashBack; // 返现
	private String rawMaterials; // 原材料
	private String productType;// 产品类型

	private Date operateTime = new Date(); // 操作时间

	private Set businessClasses = new HashSet(0); // 订单种类
	private Set businessQualities = new HashSet(0); // 订单品质

	// 构造方法

	/**
	 * 默认的构造方法
	 */
	public SysBusiness() {
	}

	/**
	 * 
	 * @param businessNo
	 */
	public SysBusiness(String businessNo) {
		this.businessNo = businessNo;
	}

	/**
	 * 全属性构造方法
	 * 
	 * @param basePayment
	 * @param sysCust
	 * @param baseDelivery
	 * @param businessNo
	 * @param contractNo
	 * @param theme
	 * @param businessTime
	 * @param deliveryTime
	 * @param quantity
	 * @param unitprice
	 * @param estimatedAmount
	 * @param actualAmount
	 * @param invoice
	 * @param complaints
	 * @param remark
	 * @param businessClasses
	 * @param businessQualities
	 */
	public SysBusiness(BasePayment basePayment, SysCust sysCust,
			BaseDelivery baseDelivery, String businessNo, String contractNo,
			String theme, Date businessTime, Date deliveryTime,
			Double quantity, Double unitprice, Double estimatedAmount,
			Double actualAmount, String invoice, String complaints,
			String remark, Set businessClasses, Set businessQualities) {
		this.basePayment = basePayment;
		this.sysCust = sysCust;
		this.baseDelivery = baseDelivery;
		this.businessNo = businessNo;
		this.contractNo = contractNo;
		this.theme = theme;
		this.businessTime = businessTime;
		this.deliveryTime = deliveryTime;
		this.quantity = quantity;
		this.unitprice = unitprice;
		this.estimatedAmount = estimatedAmount;
		this.actualAmount = actualAmount;
		this.invoice = invoice;
		this.complaints = complaints;
		this.remark = remark;
		this.businessClasses = businessClasses;
		this.businessQualities = businessQualities;
	}

	// 属性访问

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BasePayment getBasePayment() {
		return this.basePayment;
	}

	public void setBasePayment(BasePayment basePayment) {
		this.basePayment = basePayment;
	}

	public SysCust getSysCust() {
		return this.sysCust;
	}

	public void setSysCust(SysCust sysCust) {
		this.sysCust = sysCust;
	}

	public BaseDelivery getBaseDelivery() {
		return this.baseDelivery;
	}

	public void setBaseDelivery(BaseDelivery baseDelivery) {
		this.baseDelivery = baseDelivery;
	}

	public String getBusinessNo() {
		return this.businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getContractNo() {
		return this.contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Date getBusinessTime() {
		return this.businessTime;
	}

	public void setBusinessTime(Date businessTime) {
		this.businessTime = businessTime;
	}

	public Date getDeliveryTime() {
		return this.deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	public Double getEstimatedAmount() {
		return this.estimatedAmount;
	}

	public void setEstimatedAmount(Double estimatedAmount) {
		this.estimatedAmount = estimatedAmount;
	}

	public Double getActualAmount() {
		return this.actualAmount;
	}

	public void setActualAmount(Double actualAmount) {
		this.actualAmount = actualAmount;
	}

	public String getInvoice() {
		return this.invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getComplaints() {
		return this.complaints;
	}

	public void setComplaints(String complaints) {
		this.complaints = complaints;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getBusinessClasses() {
		return this.businessClasses;
	}

	public void setBusinessClasses(Set businessClasses) {
		this.businessClasses = businessClasses;
	}

	public Set getBusinessQualities() {
		return this.businessQualities;
	}

	public void setBusinessQualities(Set businessQualities) {
		this.businessQualities = businessQualities;
	}

	public String getClaim() {
		return claim;
	}

	public void setClaim(String claim) {
		this.claim = claim;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public Double getCorrespondsPrice() {
		return correspondsPrice;
	}

	public void setCorrespondsPrice(Double correspondsPrice) {
		this.correspondsPrice = correspondsPrice;
	}

	public Double getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Double pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Double getDuty() {
		return duty;
	}

	public void setDuty(Double duty) {
		this.duty = duty;
	}

	public Double getCashBack() {
		return cashBack;
	}

	public void setCashBack(Double cashBack) {
		this.cashBack = cashBack;
	}

	public String getRawMaterials() {
		return rawMaterials;
	}

	public void setRawMaterials(String rawMaterials) {
		this.rawMaterials = rawMaterials;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

}