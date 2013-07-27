package soy.web.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.BaseClassDAO;
import soy.basic.dao.BaseMainDAO;
import soy.basic.dao.BaseQualityDAO;
import soy.basic.dao.SysSupplierDAO;
import soy.basic.database.entity.BaseClass;
import soy.basic.database.entity.BaseMain;
import soy.basic.database.entity.BaseQuality;
import soy.basic.database.entity.SysSupplier;
import soy.basic.vo.BaseClassVO;
import soy.basic.vo.SysSupplierVO;
import soy.util.PaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;
import soy.web.service.SysSupplierService;

/**
 * @author XiaoLiang·Hu
 * 
 */
public class SysSupplierServiceImpl implements SysSupplierService {
	private static final Logger log = LoggerFactory
			.getLogger(SysSupplierServiceImpl.class);

	private SysSupplierDAO sysSupplierDAO;
	private BaseMainDAO baseMainDAO;
	private BaseClassDAO baseClassDAO;
	private BaseQualityDAO baseQualityDAO;

	@Override
	public PaginatedList find(PaginatedList list, SysSupplierVO sysSupplierVO) {
		list = getSysSupplierDAO().find(list, sysSupplierVO);
		List<SysSupplier> sysSuppliers = list.getList();
		List<SysSupplierVO> sysSupplierVOs = new ArrayList<SysSupplierVO>();
		for (SysSupplier sysSupplier : sysSuppliers) {
			sysSupplierVOs.add(new SysSupplierVO(sysSupplier));
		}
		list.setList(sysSupplierVOs);
		sysSuppliers = null;
		return list;
	}

	@Override
	public SysSupplierVO save(SysSupplierVO sysSupplierVO) {
		SysSupplierVO vo = null;
		if (sysSupplierVO != null) {
			try {
				SysSupplier sysSupplier = new SysSupplier();

				sysSupplier.setName(sysSupplierVO.getName()); // 名字
				sysSupplier.setGender(sysSupplierVO.getGenderId()); // 性别
				sysSupplier.setPhoneTh1(sysSupplierVO.getPhoneTh1()); // 联系电话
				sysSupplier.setQq(sysSupplierVO.getQq()); // QQ
				sysSupplier.setEmail(sysSupplierVO.getEmail()); // 邮箱

				// 订单品质
				List<BaseQuality> baseQualities = getBaseQualityDAO()
						.findByIds(sysSupplierVO.getSupplierQualityId());
				System.out.println("B:" + baseQualities);
				Set<BaseQuality> supplierQualities = new HashSet<BaseQuality>();
				supplierQualities.addAll(baseQualities);
				System.out.println(Arrays.toString(sysSupplierVO.getSupplierQualityId()));
				System.out.println("品质集合:" + supplierQualities.size());
				sysSupplier.setSupplierQualities(supplierQualities);

				// 订单种类
				List<BaseClass> baseClasses = getBaseClassDAO().findByIds(
						sysSupplierVO.getSupplierClassId());
				System.out.println("T：" + baseClasses);
				Set<BaseClass> supplierClasses = new HashSet<BaseClass>();
				supplierClasses.addAll(baseClasses);
				System.out.println(Arrays.toString(sysSupplierVO.getSupplierClassId()));
				System.out.println("种类集合:" + supplierClasses.size());
				sysSupplier.setSupplierClasses(supplierClasses);

				// 主营一
				if (!StringUtil.isNull(sysSupplierVO.getMainTh1Id())
						&& StringUtil.isInteger(sysSupplierVO.getMainTh1Id())) {
					Integer mainTh1Id = Integer.valueOf(sysSupplierVO
							.getMainTh1Id());
					BaseMain baseMain = (BaseMain) getBaseMainDAO().findById(
							mainTh1Id);
					sysSupplier.setMainTh1(baseMain);
				}

				// 主营二
				if (!StringUtil.isNull(sysSupplierVO.getMainTh2Id())
						&& StringUtil.isInteger(sysSupplierVO.getMainTh2Id())) {
					Integer mainTh2Id = Integer.valueOf(sysSupplierVO
							.getMainTh2Id());
					BaseMain baseMain = (BaseMain) getBaseMainDAO().findById(
							mainTh2Id);
					sysSupplier.setMainTh2(baseMain);
				}

				// 主营三
				if (!StringUtil.isNull(sysSupplierVO.getMainTh3Id())
						&& StringUtil.isInteger(sysSupplierVO.getMainTh3Id())) {
					Integer mainTh3Id = Integer.valueOf(sysSupplierVO
							.getMainTh3Id());
					BaseMain baseMain = (BaseMain) getBaseMainDAO().findById(
							mainTh3Id);
					sysSupplier.setMainTh3(baseMain);
				}

				sysSupplier.setOther(sysSupplierVO.getOther()); // 其他
				sysSupplier.setPrice(sysSupplierVO.getPrice()); // 成交价格
				sysSupplier.setRemark(sysSupplierVO.getRemark()); // 备注

				getSysSupplierDAO().save(sysSupplier);

				vo = new SysSupplierVO(sysSupplier);
			} catch (RuntimeException re) {
				vo = null;
				log.error("", re);
				throw re;
			}
		}
		return vo;
	}

	@Override
	public int delete(Integer[] ids) {
		int size = 0;
		if (!SystemUtil.isNull(ids)) {
			for (Integer id : ids) {
				SysSupplier sysSupplier = (SysSupplier) getSysSupplierDAO()
						.findById(id);
				if (sysSupplier != null) {
					try {
						getSysSupplierDAO().delete(sysSupplier);
						size++;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return size;
	}

	@Override
	public SysSupplierVO findById(Integer id) {
		// BaseClassVO baseClassVO = null;
		SysSupplierVO sysSupplierVO = null;
		if (id != null && id.intValue() > 0) {
			// BaseClass baseClass = (BaseClass) getBaseClassDAO().findById(id);
			SysSupplier sysSupplier = (SysSupplier) getSysSupplierDAO()
					.findById(id);
			if (sysSupplier != null) {
				sysSupplierVO = new SysSupplierVO(sysSupplier);
			}
		}
		return sysSupplierVO;
	}

	@Override
	public SysSupplierVO update(SysSupplierVO sysSupplierVO) {
		// BaseClassVO vo = null;
		SysSupplierVO vo = null;
		if (sysSupplierVO != null && !StringUtil.isNull(sysSupplierVO.getId())) {
			SysSupplier sysSupplier = (SysSupplier) getSysSupplierDAO()
					.findById(Integer.valueOf(sysSupplierVO.getId()));
			if (sysSupplier != null) {
				try {
					sysSupplier.setName(sysSupplierVO.getName()); // 名字
					sysSupplier.setGender(sysSupplierVO.getGenderId()); // 性别
					sysSupplier.setPhoneTh1(sysSupplierVO.getPhoneTh1()); // 联系电话
					sysSupplier.setQq(sysSupplierVO.getQq()); // QQ
					sysSupplier.setEmail(sysSupplierVO.getEmail()); // 邮箱

					// 订单品质
					List<BaseQuality> baseQualities = getBaseQualityDAO()
							.findByIds(sysSupplierVO.getSupplierQualityId());
					Set<BaseQuality> supplierQualities = new HashSet<BaseQuality>();
					supplierQualities.addAll(baseQualities);
					sysSupplier.setSupplierQualities(supplierQualities);

					// 订单种类
					List<BaseClass> baseClasses = getBaseClassDAO().findByIds(
							sysSupplierVO.getSupplierClassId());
					Set<BaseClass> supplierClasses = new HashSet<BaseClass>();
					supplierClasses.addAll(baseClasses);
					sysSupplier.setSupplierClasses(supplierClasses);
					
					// 主营一
					if (!StringUtil.isNull(sysSupplierVO.getMainTh1Id())
							&& StringUtil.isInteger(sysSupplierVO
									.getMainTh1Id())) {
						Integer mainTh1Id = Integer.valueOf(sysSupplierVO
								.getMainTh1Id());
						BaseMain baseMain = (BaseMain) getBaseMainDAO()
								.findById(mainTh1Id);
						sysSupplier.setMainTh1(baseMain);
					}

					// 主营二
					if (!StringUtil.isNull(sysSupplierVO.getMainTh2Id())
							&& StringUtil.isInteger(sysSupplierVO
									.getMainTh2Id())) {
						Integer mainTh2Id = Integer.valueOf(sysSupplierVO
								.getMainTh2Id());
						BaseMain baseMain = (BaseMain) getBaseMainDAO()
								.findById(mainTh2Id);
						sysSupplier.setMainTh2(baseMain);
					}

					// 主营三
					if (!StringUtil.isNull(sysSupplierVO.getMainTh3Id())
							&& StringUtil.isInteger(sysSupplierVO
									.getMainTh3Id())) {
						Integer mainTh3Id = Integer.valueOf(sysSupplierVO
								.getMainTh3Id());
						BaseMain baseMain = (BaseMain) getBaseMainDAO()
								.findById(mainTh3Id);
						sysSupplier.setMainTh3(baseMain);
					}

					sysSupplier.setOther(sysSupplierVO.getOther()); // 其他
					sysSupplier.setPrice(sysSupplierVO.getPrice()); // 成交价格
					sysSupplier.setRemark(sysSupplierVO.getRemark()); // 备注

					getSysSupplierDAO().update(sysSupplier);
					vo = new SysSupplierVO(sysSupplier);
				} catch (Exception e) {
					vo = null;
					e.printStackTrace();
				}
			}
		}
		System.out.println("5");
		return vo;
	}

	public SysSupplierDAO getSysSupplierDAO() {
		return sysSupplierDAO;
	}

	public void setSysSupplierDAO(SysSupplierDAO sysSupplierDAO) {
		this.sysSupplierDAO = sysSupplierDAO;
	}

	public BaseMainDAO getBaseMainDAO() {
		return baseMainDAO;
	}

	public void setBaseMainDAO(BaseMainDAO baseMainDAO) {
		this.baseMainDAO = baseMainDAO;
	}

	public BaseClassDAO getBaseClassDAO() {
		return baseClassDAO;
	}

	public void setBaseClassDAO(BaseClassDAO baseClassDAO) {
		this.baseClassDAO = baseClassDAO;
	}

	public BaseQualityDAO getBaseQualityDAO() {
		return baseQualityDAO;
	}

	public void setBaseQualityDAO(BaseQualityDAO baseQualityDAO) {
		this.baseQualityDAO = baseQualityDAO;
	}

}
