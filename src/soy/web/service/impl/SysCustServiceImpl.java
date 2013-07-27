package soy.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.BaseIndustryDAO;
import soy.basic.dao.BaseSourceDAO;
import soy.basic.dao.BaseStateDAO;
import soy.basic.dao.BaseTypeDAO;
import soy.basic.dao.SysCustDAO;
import soy.basic.database.entity.BaseIndustry;
import soy.basic.database.entity.BaseSource;
import soy.basic.database.entity.BaseState;
import soy.basic.database.entity.BaseType;
import soy.basic.database.entity.SysCust;
import soy.basic.vo.SysCustVO;
import soy.util.PaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;
import soy.web.service.SysCustService;

public class SysCustServiceImpl implements SysCustService {
	//日志
	private static final Logger log = LoggerFactory
			.getLogger(SysCustServiceImpl.class);

	private SysCustDAO sysCustDAO;
	private BaseIndustryDAO baseIndustryDAO;
	private BaseTypeDAO baseTypeDAO;
	private BaseSourceDAO baseSourceDAO;
	private BaseStateDAO baseStateDAO;

	private static String buffer = null;
	private static List<SysCustVO> sysCustVOs = null;
	private static boolean change = false;

	@Override
	public PaginatedList find(PaginatedList list, SysCustVO vo) {
		list = getSysCustDAO().find(list, vo);
		List<SysCust> sysCustes = list.getList();
		List<SysCustVO> sysCustVOs = new ArrayList<SysCustVO>();
		for (SysCust sysCust : sysCustes) {
			sysCustVOs.add(new SysCustVO(sysCust));
		}
		list.setList(sysCustVOs);
		sysCustes = null;
		return list;
	}
	
	@Override
	public List<SysCustVO> findAll() {
		if (isChange() || SystemUtil.isNull(sysCustVOs)) {
			List<SysCust> sysCusts = getSysCustDAO().findAll();
			SysCustServiceImpl.sysCustVOs = new ArrayList<SysCustVO>();
			for (SysCust sysCust : sysCusts) {
				sysCustVOs.add(new SysCustVO(sysCust));
			}
		}
		return sysCustVOs;
	}

	@Override
	public SysCustVO save(SysCustVO sysCustVO) {
		setChange(true);
		SysCustVO vo = null;
		if (sysCustVO != null) {
			try {
				SysCust sysCust = new SysCust();
				sysCust.setName(sysCustVO.getName());// 客户名称
				sysCust.setPostalCode(sysCustVO.getPostalCode()); // 邮编
				BaseIndustry baseIndustry = null;// 客户行业

				if (StringUtil.isInteger(sysCustVO.getBaseIndustryId())) {
					baseIndustry = (BaseIndustry) getBaseIndustryDAO()
							.findById(
									Integer.valueOf(sysCustVO
											.getBaseIndustryId()));
				}
				sysCust.setBaseIndustry(baseIndustry);

				BaseType baseType = null; // 客户类型
				if (StringUtil.isInteger(sysCustVO.getBaseTypeId())) {
					baseType = (BaseType) getBaseTypeDAO().findById(
							Integer.valueOf(sysCustVO.getBaseTypeId()));
				}
				sysCust.setBaseType(baseType);

				BaseSource baseSource = null;
				if (StringUtil.isInteger(sysCustVO.getBaseSourceId())) {
					baseSource = (BaseSource) getBaseSourceDAO().findById(
							Integer.valueOf(sysCustVO.getBaseSourceId())); // 客户来源
				}
				sysCust.setBaseSource(baseSource);

				BaseState baseState = null;
				if (StringUtil.isInteger(sysCustVO.getBaseStateId())) {
					baseState = (BaseState) getBaseStateDAO().findById(
							Integer.valueOf(sysCustVO.getBaseStateId())); // 客户状态
				}
				sysCust.setBaseState(baseState);

				sysCust.setWebsite(sysCustVO.getWebsite()); // 公司主页
				sysCust.setAddress(sysCustVO.getAddress()); // 详细地址
				sysCust.setRemark(sysCustVO.getRemark()); // 备注

				getSysCustDAO().save(sysCust);

				vo = new SysCustVO(sysCust);
			} catch (Exception e) {
				vo = null;
				e.printStackTrace();
			}
		}
		return vo;
	}

	@Override
	public SysCustVO findById(Integer id) {
		SysCustVO sysCustVO = null;
		if (id != null && id.intValue() > 0) {
			SysCust sysCust = (SysCust) getSysCustDAO().findById(id);
			if (sysCust != null) {
				sysCustVO = new SysCustVO(sysCust);
			}
		}
		return sysCustVO;
	}

	@Override
	public SysCustVO update(SysCustVO sysCustVO) {
		setChange(true);
		SysCustVO vo = null;
		if (sysCustVO != null && !StringUtil.isNull(sysCustVO.getId())) {
			SysCust sysCust = (SysCust) getSysCustDAO().findById(
					Integer.valueOf(sysCustVO.getId()));
			if (sysCust != null) {
				try {
					sysCust.setName(sysCustVO.getName());// 客户名称
					sysCust.setPostalCode(sysCustVO.getPostalCode()); // 邮编

					BaseIndustry baseIndustry = null; // 客户行业
					if (StringUtil.isInteger(sysCustVO.getBaseIndustryId())) {
						baseIndustry = (BaseIndustry) getBaseIndustryDAO()
								.findById(
										Integer.valueOf(sysCustVO
												.getBaseIndustryId()));
					}
					System.out.println("客户行业" + baseIndustry);
					sysCust.setBaseIndustry(baseIndustry);

					BaseType baseType = null;// 客户类型
					if (StringUtil.isInteger(sysCustVO.getBaseTypeId())) {
						baseType = (BaseType) getBaseTypeDAO().findById(
								Integer.valueOf(sysCustVO.getBaseTypeId()));
					}
					sysCust.setBaseType(baseType);

					BaseSource baseSource = null;// 客户来源
					if (StringUtil.isInteger(sysCustVO.getBaseSourceId())) {
						baseSource = (BaseSource) getBaseSourceDAO().findById(
								Integer.valueOf(sysCustVO.getBaseSourceId()));
					}
					System.out.println(baseSource);
					sysCust.setBaseSource(baseSource);

					BaseState baseState = null; // 客户状态
					System.out.println(Integer.valueOf(sysCustVO
							.getBaseStateId()));
					if (StringUtil.isInteger(sysCustVO.getBaseStateId())) {
						baseState = (BaseState) getBaseStateDAO().findById(
								Integer.valueOf(sysCustVO.getBaseStateId()));
						System.out.println(baseState);
					}
					System.out.println("客户状态:" + baseState);
					sysCust.setBaseState(baseState);

					sysCust.setWebsite(sysCustVO.getWebsite()); // 公司主页
					sysCust.setAddress(sysCustVO.getAddress()); // 详细地址
					sysCust.setRemark(sysCustVO.getRemark()); // 备注

					getSysCustDAO().update(sysCust);
					vo = new SysCustVO(sysCust);
				} catch (Exception e) {
					vo = null;
					e.printStackTrace();
				}
			}
		}
		return vo;
	}

	@Override
	public int delete(Integer[] ids) {
		setChange(true);
		int size = 0;
		if (!SystemUtil.isNull(ids)) {
			for (Integer id : ids) {
				SysCust sysCust = (SysCust) getSysCustDAO().findById(id);
				if (sysCust != null) {
					try {
						getSysCustDAO().delete(sysCust);
						size++;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return size;
	}

	@Override
	public String findAllIdOfString() {
		if (isChange() || StringUtil.isNull(getBuffer())) {
			List<SysCust> sysCusts = getSysCustDAO().findAll();
			StringBuffer buffer = new StringBuffer("[");
			for (SysCust sysCust : sysCusts) {
				buffer.append("'").append(sysCust.getId()).append("'")
						.append(",");
			}
			buffer.append("''");
			buffer.append("]");
			setBuffer(buffer.toString());
		}
		return buffer;
	}

	@Override
	public SysCustVO updateFeature(SysCustVO sysCustVO) {
		SysCustVO vo = null;
		if (sysCustVO != null && !StringUtil.isNull(sysCustVO.getId())
				&& StringUtil.isInteger(sysCustVO.getId())) {
			SysCust sysCust = (SysCust) getSysCustDAO().findById(
					Integer.valueOf(sysCustVO.getId()));
			if (sysCust != null) {
				try {
					sysCust.setFeature(sysCustVO.getFeature());
					getSysCustDAO().update(sysCust);

					vo = new SysCustVO(sysCust);
				} catch (Exception e) {
					vo = null;
					e.printStackTrace();
				}
			}
		}
		return vo;
	}

	public SysCustDAO getSysCustDAO() {
		return sysCustDAO;
	}

	public void setSysCustDAO(SysCustDAO sysCustDAO) {
		this.sysCustDAO = sysCustDAO;
	}

	public BaseIndustryDAO getBaseIndustryDAO() {
		return baseIndustryDAO;
	}

	public void setBaseIndustryDAO(BaseIndustryDAO baseIndustryDAO) {
		this.baseIndustryDAO = baseIndustryDAO;
	}

	public BaseTypeDAO getBaseTypeDAO() {
		return baseTypeDAO;
	}

	public void setBaseTypeDAO(BaseTypeDAO baseTypeDAO) {
		this.baseTypeDAO = baseTypeDAO;
	}

	public BaseSourceDAO getBaseSourceDAO() {
		return baseSourceDAO;
	}

	public void setBaseSourceDAO(BaseSourceDAO baseSourceDAO) {
		this.baseSourceDAO = baseSourceDAO;
	}

	public BaseStateDAO getBaseStateDAO() {
		return baseStateDAO;
	}

	public void setBaseStateDAO(BaseStateDAO baseStateDAO) {
		this.baseStateDAO = baseStateDAO;
	}

	public static boolean isChange() {
		return change;
	}

	public static void setChange(boolean change) {
		SysCustServiceImpl.change = change;
	}

	public static String getBuffer() {
		return buffer;
	}

	public static void setBuffer(String buffer) {
		SysCustServiceImpl.buffer = buffer;
	}

}
