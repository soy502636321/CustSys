package soy.basic.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.BaseClass;
import soy.basic.database.entity.BaseDelivery;
import soy.basic.database.entity.BasePayment;
import soy.basic.database.entity.BaseQuality;
import soy.basic.database.entity.SysBusiness;
import soy.basic.database.entity.SysCust;
import soy.util.ConfigUtil;
import soy.util.StringUtil;
import soy.util.SystemUtil;

public class SysBusinessVO {
	private static final Logger log = LoggerFactory
			.getLogger(SysBusinessVO.class);

	private SysBusiness sysBusiness;

	private String id; // 业务主键
	private BasePayment basePayment; // 付款方式
	private String basePaymentId;

	private SysCust sysCust; // 客户外键
	private String sysCustId; // 客户编号

	private BaseDelivery baseDelivery; // 交付方式
	private String baseDeliveryId;

	private String businessNo; // 业务编号
	private String contractNo; // 合同编号
	private String theme; // 主题

	private Date businessTime; // 订单时间
	private Date businessTimeStart; // 开始订单时间(查询)
	private Date businessTimeEnd; // 结束订单时间(查询)

	private Date deliveryTime; // 交付时间
	private Date deliveryTimeStart;// 开始交付时间(查询)
	private Date deliveryTimeEnd;// 结束交付时间(查询)

	private Double quantity; // 数量
	private String quantityString;

	private Double unitprice; // 单价
	private String unitpriceString;

	private Double estimatedAmount; // 预估金额
	private String estimatedAmountString;

	private Double actualAmount; // 实际金额
	private String actualAmountString;

	private String invoice; // 开票
	private String invoiceId;

	private String complaints; // 客户投诉
	private String complaintsId;
	private String remark; // 备注
	private String claim; // 要求
	
	private Double correspondsPrice; // 对应单价
	private Double pageNumber; // 页码
	private Double duty; // 税
	private Double cashBack; // 返现
	private String rawMaterials; // 原材料
	private String productType;// 产品类型

	private Integer[] businessClassId;
	private Set<BaseClassVO> baseClassVOs;

	private Integer[] businessQualityId;
	private Set<BaseQualityVO> baseQualityVOs;

	public SysBusinessVO() {
	}

	public SysBusinessVO(SysBusiness sysBusiness) {
		this.sysBusiness = sysBusiness;
	}

	public SysBusiness getSysBusiness() {
		return sysBusiness;
	}

	public void setSysBusiness(SysBusiness sysBusiness) {
		this.sysBusiness = sysBusiness;
	}

	public String getId() {
		if (getSysBusiness() != null && id == null) {
			id = String.valueOf(getSysBusiness().getId());
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BasePayment getBasePayment() {
		if (getSysBusiness() != null && basePayment == null) {
			basePayment = getSysBusiness().getBasePayment();
		}
		return basePayment;
	}

	public void setBasePayment(BasePayment basePayment) {
		this.basePayment = basePayment;
	}

	public SysCust getSysCust() {
		if (getSysBusiness() != null && sysCust == null) {
			sysCust = getSysBusiness().getSysCust();
		}
		return sysCust;
	}

	public void setSysCust(SysCust sysCust) {
		this.sysCust = sysCust;
	}

	public BaseDelivery getBaseDelivery() {
		if (getSysBusiness() != null && baseDelivery == null) {
			baseDelivery = getSysBusiness().getBaseDelivery();
		}
		return baseDelivery;
	}

	public void setBaseDelivery(BaseDelivery baseDelivery) {
		this.baseDelivery = baseDelivery;
	}

	public String getBusinessNo() {
		if (getSysBusiness() != null && businessNo == null) {
			businessNo = getSysBusiness().getBusinessNo();
		}
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getContractNo() {
		if (getSysBusiness() != null && contractNo == null) {
			contractNo = getSysBusiness().getContractNo();
		}
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getTheme() {
		if (getSysBusiness() != null && theme == null) {
			theme = getSysBusiness().getTheme();
		}
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Date getBusinessTime() {
		if (getSysBusiness() != null && businessTime == null) {
			businessTime = getSysBusiness().getBusinessTime();
		}
		return businessTime;
	}

	public void setBusinessTime(Date businessTime) {
		this.businessTime = businessTime;
	}

	public Date getDeliveryTime() {
		if (getSysBusiness() != null && deliveryTime == null) {
			deliveryTime = getSysBusiness().getDeliveryTime();
		}
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Double getQuantity() {
		if (getSysBusiness() != null && quantity == null) {
			quantity = getSysBusiness().getQuantity();
		}
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getUnitprice() {
		if (getSysBusiness() != null && unitprice == null) {
			unitprice = getSysBusiness().getUnitprice();
		}
		return unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	public Double getEstimatedAmount() {
		if (getSysBusiness() != null && estimatedAmount == null) {
			estimatedAmount = getSysBusiness().getEstimatedAmount();
		}
		return estimatedAmount;
	}

	public void setEstimatedAmount(Double estimatedAmount) {
		this.estimatedAmount = estimatedAmount;
	}

	public Double getActualAmount() {
		if (getSysBusiness() != null && actualAmount == null) {
			actualAmount = getSysBusiness().getActualAmount();
		}
		return actualAmount;
	}

	public void setActualAmount(Double actualAmount) {
		this.actualAmount = actualAmount;
	}

	public String getInvoice() {
		if (getSysBusiness() != null && invoice == null) {
			invoice = ConfigUtil.getConfigUtil().findValue(
					ConfigUtil.KEY_YESORNO, getSysBusiness().getInvoice());
		}
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getComplaints() {
		if (getSysBusiness() != null && complaints == null) {
			complaints = ConfigUtil.getConfigUtil().findValue(
					ConfigUtil.KEY_YESORNO, getSysBusiness().getComplaints());
		}
		return complaints;
	}

	public void setComplaints(String complaints) {
		this.complaints = complaints;
	}

	public String getRemark() {
		if (getSysBusiness() != null && remark == null) {
			remark = getSysBusiness().getRemark();
		}
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSysCustId() {
		if (getSysCust() != null && sysCustId == null) {
			sysCustId = String.valueOf(getSysCust().getId());
		}
		return sysCustId;
	}

	public void setSysCustId(String sysCustId) {
		this.sysCustId = sysCustId;
	}

	public String getClaim() {
		if (getSysBusiness() != null && claim == null) {
			claim = getSysBusiness().getClaim();
		}
		return claim;
	}

	public void setClaim(String claim) {
		this.claim = claim;
	}

	public String getBaseDeliveryId() {
		return baseDeliveryId;
	}

	public void setBaseDeliveryId(String baseDeliveryId) {
		this.baseDeliveryId = baseDeliveryId;
	}

	public Integer[] getBusinessClassId() {
		businessClassId = new Integer[] { 1 };
		return businessClassId;
	}

	public void setBusinessClassId(Integer[] businessClassId) {
		this.businessClassId = businessClassId;
	}

	public Integer[] getBusinessQualityId() {
		return businessQualityId;
	}

	public void setBusinessQualityId(Integer[] businessQualityId) {
		this.businessQualityId = businessQualityId;
	}

	public String getInvoiceId() {
		if (getSysBusiness() != null && invoiceId == null) {
			invoiceId = getSysBusiness().getInvoice();
		}
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getComplaintsId() {
		if (getSysBusiness() != null && complaintsId == null) {
			complaintsId = getSysBusiness().getComplaints();
		}
		return complaintsId;
	}

	public void setComplaintsId(String complaintsId) {
		this.complaintsId = complaintsId;
	}

	public Date getBusinessTimeStart() {
		return businessTimeStart;
	}

	public void setBusinessTimeStart(Date businessTimeStart) {
		this.businessTimeStart = businessTimeStart;
	}

	public Date getBusinessTimeEnd() {
		return businessTimeEnd;
	}

	public void setBusinessTimeEnd(Date businessTimeEnd) {
		this.businessTimeEnd = businessTimeEnd;
	}

	public Date getDeliveryTimeStart() {
		return deliveryTimeStart;
	}

	public void setDeliveryTimeStart(Date deliveryTimeStart) {
		this.deliveryTimeStart = deliveryTimeStart;
	}

	public Date getDeliveryTimeEnd() {
		return deliveryTimeEnd;
	}

	public void setDeliveryTimeEnd(Date deliveryTimeEnd) {
		this.deliveryTimeEnd = deliveryTimeEnd;
	}

	public String getQuantityString() {
		return quantityString;
	}

	public void setQuantityString(String quantityString) {
		this.quantityString = quantityString;
	}

	public String getUnitpriceString() {
		return unitpriceString;
	}

	public void setUnitpriceString(String unitpriceString) {
		this.unitpriceString = unitpriceString;
	}

	public String getEstimatedAmountString() {
		return estimatedAmountString;
	}

	public void setEstimatedAmountString(String estimatedAmountString) {
		this.estimatedAmountString = estimatedAmountString;
	}

	public String getActualAmountString() {
		return actualAmountString;
	}

	public void setActualAmountString(String actualAmountString) {
		this.actualAmountString = actualAmountString;
	}

	public String getBasePaymentId() {
		return basePaymentId;
	}

	public void setBasePaymentId(String basePaymentId) {
		this.basePaymentId = basePaymentId;
	}

	public Set<BaseClassVO> getBaseClassVOs() {
		if (getSysBusiness() != null && baseClassVOs == null
				&& !SystemUtil.isNull(getSysBusiness().getBusinessClasses())) {
			baseClassVOs = new HashSet<BaseClassVO>();
			for (Object object : getSysBusiness().getBusinessClasses()
					.toArray()) {
				baseClassVOs.add(new BaseClassVO((BaseClass) object));
			}
		}
		return baseClassVOs;
	}

	public void setBaseClassVOs(Set<BaseClassVO> baseClassVOs) {
		this.baseClassVOs = baseClassVOs;
	}

	public Set<BaseQualityVO> getBaseQualityVOs() {
		if (getSysBusiness() != null && baseQualityVOs == null
				&& !SystemUtil.isNull(getSysBusiness().getBusinessQualities())) {
			baseQualityVOs = new HashSet<BaseQualityVO>();
			for (Object object : getSysBusiness().getBusinessQualities()) {
				baseQualityVOs.add(new BaseQualityVO((BaseQuality) object));
			}
		} else {
			System.out.println("--------------1");
			if (!SystemUtil.isNull(getBusinessQualityId())) {
				System.out.println("-------------2");
				baseQualityVOs = new HashSet<BaseQualityVO>();
				for (Integer integer : getBusinessQualityId()) {
					System.out.println("----3");
					BaseQualityVO baseQualityVO = new BaseQualityVO();
					baseQualityVO.setId(integer.toString());
					baseQualityVOs.add(baseQualityVO);
				}
			}
		}
		return baseQualityVOs;
	}

	public void setBaseQualityVOs(Set<BaseQualityVO> baseQualityVOs) {
		this.baseQualityVOs = baseQualityVOs;
	}

	public Double getCorrespondsPrice() {
		if (getSysBusiness() != null && correspondsPrice == null) {
			correspondsPrice = getSysBusiness().getCorrespondsPrice();
		}
		return correspondsPrice;
	}

	public void setCorrespondsPrice(Double correspondsPrice) {
		this.correspondsPrice = correspondsPrice;
	}

	public Double getPageNumber() {
		if (getSysBusiness() != null && pageNumber == null) {
			pageNumber = getSysBusiness().getPageNumber();
		}
		return pageNumber;
	}

	public void setPageNumber(Double pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Double getDuty() {
		if (getSysBusiness() != null && duty == null) {
			duty = getSysBusiness().getDuty();
		}
		return duty;
	}

	public void setDuty(Double duty) {
		this.duty = duty;
	}

	public Double getCashBack() {
		if (getSysBusiness() != null && cashBack == null) {
			cashBack = getSysBusiness().getCashBack();
		}
		return cashBack;
	}

	public void setCashBack(Double cashBack) {
		this.cashBack = cashBack;
	}

	public String getRawMaterials() {
		if (getSysBusiness() != null && rawMaterials == null) {
			rawMaterials = getSysBusiness().getRawMaterials();
		}
		return rawMaterials;
	}

	public void setRawMaterials(String rawMaterials) {
		this.rawMaterials = rawMaterials;
	}

	public String getProductType() {
		if (getSysBusiness() != null && productType == null) {
			productType = getSysBusiness().getProductType();
		}
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	
}
