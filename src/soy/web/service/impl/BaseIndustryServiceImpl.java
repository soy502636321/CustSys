package soy.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.BaseIndustryDAO;
import soy.basic.database.entity.BaseIndustry;
import soy.basic.vo.BaseIndustryVO;
import soy.util.PaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;
import soy.web.service.BaseIndustryService;

public class BaseIndustryServiceImpl implements BaseIndustryService {
	// 日志
	private static final Logger log = LoggerFactory
			.getLogger(BaseIndustryServiceImpl.class);

	// DAO
	private BaseIndustryDAO baseIndustryDAO;

	// 缓存集合
	private static ArrayList<BaseIndustryVO> baseIndustryVOs;

	// 属性
	private static boolean change = false;

	@Override
	public PaginatedList find(PaginatedList list, BaseIndustryVO baseIndustryVO) {
		list = getBaseIndustryDAO().find(list, baseIndustryVO);
		List<BaseIndustry> baseIndustries = list.getList();
		List<BaseIndustryVO> baseIndustryVOs = new ArrayList<BaseIndustryVO>();
		for (BaseIndustry baseIndustry : baseIndustries) {
			baseIndustryVOs.add(new BaseIndustryVO(baseIndustry));
		}
		list.setList(baseIndustryVOs);
		baseIndustries = null;
		return list;
	}

	@Override
	public BaseIndustryVO save(BaseIndustryVO baseIndustryVO) {
		setChange(true);
		BaseIndustryVO vo = null;
		if (baseIndustryVO != null) {
			try {
				BaseIndustry baseIndustry = new BaseIndustry();
				baseIndustry.setIndustryName(baseIndustryVO.getIndustryName());
				baseIndustry.setRemark(baseIndustryVO.getRemark());
				getBaseIndustryDAO().save(baseIndustry);

				vo = new BaseIndustryVO(baseIndustry);
			} catch (Exception e) {
				vo = null;
				e.printStackTrace();
			}
		}
		return vo;
	}

	@Override
	public BaseIndustryVO findById(Integer id) {
		BaseIndustryVO baseIndustryVO = null;
		if (id != null && id.intValue() > 0) {
			BaseIndustry baseIndustry = (BaseIndustry) getBaseIndustryDAO()
					.findById(id);
			if (baseIndustry != null) {
				baseIndustryVO = new BaseIndustryVO(baseIndustry);
			}
		}
		return baseIndustryVO;
	}

	@Override
	public BaseIndustryVO update(BaseIndustryVO baseIndustryVO) {
		setChange(true);
		BaseIndustryVO vo = null;
		if (baseIndustryVO != null
				&& !StringUtil.isNull(baseIndustryVO.getId())
				&& StringUtil.isInteger(baseIndustryVO.getId())) {
			BaseIndustry baseIndustry = (BaseIndustry) getBaseIndustryDAO()
					.findById(Integer.valueOf(baseIndustryVO.getId()));
			if (baseIndustry != null) {
				try {
					baseIndustry.setIndustryName(baseIndustryVO
							.getIndustryName());
					baseIndustry.setRemark(baseIndustryVO.getRemark());

					getBaseIndustryDAO().update(baseIndustry);
					vo = new BaseIndustryVO(baseIndustry);
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
				BaseIndustry baseIndustry = (BaseIndustry) getBaseIndustryDAO()
						.findById(id);
				if (baseIndustry != null) {
					try {
						getBaseIndustryDAO().delete(baseIndustry);
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
	public List findAll() {
		if (isChange() || SystemUtil.isNull(getBaseIndustryVOs())) {
			List<BaseIndustry> baseIndustries = getBaseIndustryDAO().findAll();
			baseIndustryVOs = new ArrayList<BaseIndustryVO>();
			for (BaseIndustry baseIndustry : baseIndustries) {
				baseIndustryVOs.add(new BaseIndustryVO(baseIndustry));
			}
			baseIndustries = null;
		}
		return baseIndustryVOs;
	}

	public BaseIndustryDAO getBaseIndustryDAO() {
		return baseIndustryDAO;
	}

	public void setBaseIndustryDAO(BaseIndustryDAO baseIndustryDAO) {
		this.baseIndustryDAO = baseIndustryDAO;
	}

	public static boolean isChange() {
		return change;
	}

	public static void setChange(boolean change) {
		BaseIndustryServiceImpl.change = change;
	}

	public static ArrayList<BaseIndustryVO> getBaseIndustryVOs() {
		return baseIndustryVOs;
	}

	public static void setBaseIndustryVOs(
			ArrayList<BaseIndustryVO> baseIndustryVOs) {
		BaseIndustryServiceImpl.baseIndustryVOs = baseIndustryVOs;
	}

}
