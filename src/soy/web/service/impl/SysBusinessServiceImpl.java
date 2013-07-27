package soy.web.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.BaseClassDAO;
import soy.basic.dao.BaseDeliveryDAO;
import soy.basic.dao.BasePaymentDAO;
import soy.basic.dao.BaseQualityDAO;
import soy.basic.dao.SysBusinessDAO;
import soy.basic.dao.SysCustDAO;
import soy.basic.database.entity.BaseClass;
import soy.basic.database.entity.BaseDelivery;
import soy.basic.database.entity.BasePayment;
import soy.basic.database.entity.BaseQuality;
import soy.basic.database.entity.SysBusiness;
import soy.basic.database.entity.SysCust;
import soy.basic.vo.SysBusinessVO;
import soy.basic.vo.SysCustVO;
import soy.util.PaginatedList;
import soy.util.StringUtil;
import soy.web.service.SysBusinessService;

public class SysBusinessServiceImpl implements SysBusinessService {
	private static final Logger log = LoggerFactory
			.getLogger(SysBusinessServiceImpl.class);

	private SysBusinessDAO sysBusinessDAO;
	private SysCustDAO sysCustDAO;
	private BaseDeliveryDAO baseDeliveryDAO;
	private BasePaymentDAO basePaymentDAO;
	private BaseQualityDAO baseQualityDAO;
	private BaseClassDAO baseClassDAO;

	@Override
	public PaginatedList find(PaginatedList list, SysBusinessVO businessVO,
			SysCustVO sysCustVO) {
		list = getSysBusinessDAO().find(list, businessVO, sysCustVO);
		List<SysBusiness> sysBusinesses = list.getList();
		List<SysBusinessVO> sysBusinessVOs = new ArrayList<SysBusinessVO>();
		for (SysBusiness sysBusiness : sysBusinesses) {
			sysBusinessVOs.add(new SysBusinessVO(sysBusiness));
		}
		list.setList(sysBusinessVOs);
		sysBusinesses = null;
		return list;
	}

	@Override
	public SysBusinessVO save(SysBusinessVO sysBusinessVO) {
		SysBusinessVO vo = null;
		if (sysBusinessVO != null) {
			try {
				SysBusiness sysBusiness = new SysBusiness();

				SysCust sysCust = null;
				if (StringUtil.isInteger(sysBusinessVO.getSysCustId())) {
					sysCust = (SysCust) getSysCustDAO().findById(
							Integer.valueOf(sysBusinessVO.getSysCustId()));
				}
				if (sysCust == null) {
					return null;
				}
				// 客户编号
				sysBusiness.setSysCust(sysCust);
				// 合同编号
				sysBusiness.setContractNo(sysBusinessVO.getContractNo());
				// 订单编号(系统生成);
				sysBusiness.setBusinessNo(sysBusinessDAO.createBusinessNo());

				// 订单主题
				sysBusiness.setTheme(sysBusinessVO.getTheme());
				// 订单时间
				sysBusiness.setBusinessTime(sysBusinessVO.getBusinessTime());
				System.out.println("订单时间:" + sysBusinessVO.getBusinessTime());
				// 交付时间
				sysBusiness.setDeliveryTime(sysBusinessVO.getDeliveryTime());
				System.out.println("交付时间:" + sysBusinessVO.getDeliveryTime());

				// 订单品质
				System.out.println(sysBusinessVO.getBusinessQualityId());
				List<BaseQuality> baseQualities = getBaseQualityDAO()
						.findByIds(sysBusinessVO.getBusinessQualityId());
				Set<BaseQuality> businessQualities = new HashSet<BaseQuality>();
				businessQualities.addAll(baseQualities);
				System.out.println("订单品质:" + businessQualities.size());

				sysBusiness.setBusinessQualities(businessQualities);

				// 订单种类
				List<BaseClass> baseClasses = getBaseClassDAO().findByIds(
						sysBusinessVO.getBusinessClassId());
				Set<BaseClass> businessClasses = new HashSet<BaseClass>();
				businessClasses.addAll(baseClasses);
				System.out.println("订单种类:" + businessClasses.size());

				sysBusiness.setBusinessClasses(businessClasses);

				// 数量
				sysBusiness.setQuantity(sysBusinessVO.getQuantity());

				// 单价
				sysBusiness.setUnitprice(sysBusinessVO.getUnitprice());
				
				//对应单价
				sysBusiness.setCorrespondsPrice(sysBusinessVO.getCorrespondsPrice());
				
				//页码
				sysBusiness.setPageNumber(sysBusinessVO.getPageNumber());
				
				//税
				sysBusiness.setDuty(sysBusinessVO.getDuty());
				
				//返现
				sysBusiness.setCashBack(sysBusinessVO.getCashBack());
				
				//原材料
				sysBusiness.setRawMaterials(sysBusinessVO.getRawMaterials());
				
				//产品类型
				sysBusiness.setProductType(sysBusinessVO.getProductType());
				
				// 预估金额
				sysBusiness.setEstimatedAmount(sysBusinessVO
						.getEstimatedAmount());
				// 实际金额
				sysBusiness.setActualAmount(sysBusinessVO.getActualAmount());
				// 交付方式
				BaseDelivery baseDelivery = null;
				if (sysBusinessVO.getBaseDelivery() != null
						&& sysBusinessVO.getBaseDelivery().getId() != null) {
					baseDelivery = (BaseDelivery) getBaseDeliveryDAO()
							.findById(sysBusinessVO.getBaseDelivery().getId());
				}
				sysBusiness.setBaseDelivery(baseDelivery);
				// 付款方式
				BasePayment basePayment = null;
				if (sysBusinessVO.getBasePayment() != null
						&& sysBusinessVO.getBasePayment().getId() != null) {
					basePayment = (BasePayment) getBasePaymentDAO().findById(
							sysBusinessVO.getBasePayment().getId());
				}
				sysBusiness.setBasePayment(basePayment);

				sysBusiness.setInvoice(sysBusinessVO.getInvoiceId());
				sysBusiness.setComplaints(sysBusinessVO.getComplaintsId());
				sysBusiness.setRemark(sysBusinessVO.getRemark());

				getSysBusinessDAO().save(sysBusiness);

				vo = new SysBusinessVO(sysBusiness);
			} catch (Exception e) {
				vo = null;
				e.printStackTrace();
			}
		}
		return vo;
	}

	@Override
	public SysBusinessVO update(SysBusinessVO sysBusinessVO) {
		// SysContactVO vo = null;
		SysBusinessVO vo = null;
		if (sysBusinessVO != null && !StringUtil.isNull(sysBusinessVO.getId())
				&& StringUtil.isInteger(sysBusinessVO.getId())) {
			SysBusiness sysBusiness = (SysBusiness) getSysBusinessDAO()
					.findById(Integer.valueOf(sysBusinessVO.getId()));
			if (sysBusiness != null) {
				try {
					// 合同编号
					sysBusiness.setContractNo(sysBusinessVO.getContractNo());
					// 订单编号(系统生成);
					sysBusiness
							.setBusinessNo(sysBusinessDAO.createBusinessNo());

					// 订单主题
					sysBusiness.setTheme(sysBusinessVO.getTheme());
					// 订单时间
					sysBusiness
							.setBusinessTime(sysBusinessVO.getBusinessTime());
					// 交付时间
					sysBusiness
							.setDeliveryTime(sysBusinessVO.getDeliveryTime());

					// 订单品质
					System.out.println(sysBusinessVO.getBusinessQualityId());
					List<BaseQuality> baseQualities = getBaseQualityDAO()
							.findByIds(sysBusinessVO.getBusinessQualityId());
					Set<BaseQuality> businessQualities = new HashSet<BaseQuality>();
					businessQualities.addAll(baseQualities);
					System.out.println("订单品质:" + businessQualities.size());

					sysBusiness.setBusinessQualities(businessQualities);

					// 订单种类
					List<BaseClass> baseClasses = getBaseClassDAO().findByIds(
							sysBusinessVO.getBusinessClassId());
					Set<BaseClass> businessClasses = new HashSet<BaseClass>();
					businessClasses.addAll(baseClasses);
					System.out.println("订单种类:" + businessClasses.size());

					sysBusiness.setBusinessClasses(businessClasses);

					// 数量
					sysBusiness.setQuantity(sysBusinessVO.getQuantity());

					// 单价
					sysBusiness.setUnitprice(sysBusinessVO.getUnitprice());

					//对应单价
					sysBusiness.setCorrespondsPrice(sysBusinessVO.getCorrespondsPrice());
					
					//页码
					sysBusiness.setPageNumber(sysBusinessVO.getPageNumber());
					
					//税
					sysBusiness.setDuty(sysBusinessVO.getDuty());
					
					//返现
					sysBusiness.setCashBack(sysBusinessVO.getCashBack());
					
					//原材料
					sysBusiness.setRawMaterials(sysBusinessVO.getRawMaterials());
					
					//产品类型
					sysBusiness.setProductType(sysBusinessVO.getProductType());
					
					// 预估金额
					sysBusiness.setEstimatedAmount(sysBusinessVO
							.getEstimatedAmount());
					// 实际金额
					sysBusiness
							.setActualAmount(sysBusinessVO.getActualAmount());
					// 交付方式
					BaseDelivery baseDelivery = null;
					if (sysBusinessVO.getBaseDelivery() != null
							&& sysBusinessVO.getBaseDelivery().getId() != null) {
						baseDelivery = (BaseDelivery) getBaseDeliveryDAO()
								.findById(
										sysBusinessVO.getBaseDelivery().getId());
					}
					sysBusiness.setBaseDelivery(baseDelivery);
					// 付款方式
					BasePayment basePayment = null;
					if (sysBusinessVO.getBasePayment() != null
							&& sysBusinessVO.getBasePayment().getId() != null) {
						basePayment = (BasePayment) getBasePaymentDAO()
								.findById(
										sysBusinessVO.getBasePayment().getId());
					}
					sysBusiness.setBasePayment(basePayment);

					sysBusiness.setInvoice(sysBusinessVO.getInvoiceId());
					sysBusiness.setComplaints(sysBusinessVO.getComplaintsId());
					sysBusiness.setRemark(sysBusinessVO.getRemark());

					getSysBusinessDAO().update(sysBusiness);

					vo = new SysBusinessVO(sysBusiness);
				} catch (Exception e) {
					vo = null;
					e.printStackTrace();
				}
			}
		}
		return vo;
	}

	@Override
	public SysBusinessVO findById(Integer id) {
		SysBusinessVO sysBusinessVO = null;
		if (id != null && id.intValue() > 0) {
			SysBusiness sysBusiness = (SysBusiness) getSysBusinessDAO()
					.findById(id);
			if (sysBusiness != null) {
				sysBusinessVO = new SysBusinessVO(sysBusiness);
			}
		}
		return sysBusinessVO;
	}

	@Override
	public SysBusinessVO updateClaim(SysBusinessVO sysBusinessVO) {
		SysBusinessVO vo = null;
		if (sysBusinessVO != null && !StringUtil.isNull(sysBusinessVO.getId())
				&& StringUtil.isInteger(sysBusinessVO.getId())) {
			// SysCust sysCust = (SysCust) getSysCustDAO().findById(
			// Integer.valueOf(sysCustVO.getId()));
			SysBusiness sysBusiness = (SysBusiness) getSysBusinessDAO()
					.findById(Integer.valueOf(sysBusinessVO.getId()));
			if (sysBusiness != null) {
				try {
					sysBusiness.setClaim(sysBusinessVO.getClaim());
					getSysBusinessDAO().update(sysBusiness);

					vo = new SysBusinessVO(sysBusiness);
				} catch (Exception e) {
					vo = null;
					e.printStackTrace();
				}
			}
		}
		return vo;
	}

	public SysBusinessDAO getSysBusinessDAO() {
		return sysBusinessDAO;
	}

	public void setSysBusinessDAO(SysBusinessDAO sysBusinessDAO) {
		this.sysBusinessDAO = sysBusinessDAO;
	}

	public SysCustDAO getSysCustDAO() {
		return sysCustDAO;
	}

	public void setSysCustDAO(SysCustDAO sysCustDAO) {
		this.sysCustDAO = sysCustDAO;
	}

	public BaseDeliveryDAO getBaseDeliveryDAO() {
		return baseDeliveryDAO;
	}

	public void setBaseDeliveryDAO(BaseDeliveryDAO baseDeliveryDAO) {
		this.baseDeliveryDAO = baseDeliveryDAO;
	}

	public BasePaymentDAO getBasePaymentDAO() {
		return basePaymentDAO;
	}

	public void setBasePaymentDAO(BasePaymentDAO basePaymentDAO) {
		this.basePaymentDAO = basePaymentDAO;
	}

	public BaseQualityDAO getBaseQualityDAO() {
		return baseQualityDAO;
	}

	public void setBaseQualityDAO(BaseQualityDAO baseQualityDAO) {
		this.baseQualityDAO = baseQualityDAO;
	}

	public BaseClassDAO getBaseClassDAO() {
		return baseClassDAO;
	}

	public void setBaseClassDAO(BaseClassDAO baseClassDAO) {
		this.baseClassDAO = baseClassDAO;
	}

}
