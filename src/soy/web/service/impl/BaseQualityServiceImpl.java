package soy.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.BaseQualityDAO;
import soy.basic.database.entity.BaseQuality;
import soy.basic.vo.BaseQualityVO;
import soy.util.PaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;
import soy.web.service.BaseQualityService;

public class BaseQualityServiceImpl implements BaseQualityService {
	// 日志
	private static final Logger log = LoggerFactory
			.getLogger(BaseQualityServiceImpl.class);

	// DAO
	private BaseQualityDAO baseQualityDAO;

	// 缓存集合
	private static ArrayList<BaseQualityVO> baseQualityVOs;

	// 属性
	private static boolean change = false;

	@Override
	public PaginatedList find(PaginatedList list, BaseQualityVO baseQualityVO) {
		list = getBaseQualityDAO().find(list, baseQualityVO);
		List<BaseQuality> baseQualities = list.getList();
		List<BaseQualityVO> baseQualityVOs = new ArrayList<BaseQualityVO>();
		for (BaseQuality baseQuality : baseQualities) {
			baseQualityVOs.add(new BaseQualityVO(baseQuality));
		}
		list.setList(baseQualityVOs);
		baseQualities = null;
		return list;
	}

	@Override
	public BaseQualityVO findById(Integer id) {
		BaseQualityVO baseQualityVO = null;
		if (id != null && id.intValue() > 0) {
			BaseQuality baseQuality = (BaseQuality) getBaseQualityDAO()
					.findById(id);
			if (baseQuality != null) {
				baseQualityVO = new BaseQualityVO(baseQuality);
			}
		}
		return baseQualityVO;
	}

	@Override
	public BaseQualityVO save(BaseQualityVO baseQualityVO) {
		setChange(true);
		BaseQualityVO vo = null;
		if (baseQualityVO != null) {
			try {
				BaseQuality baseQuality = new BaseQuality();
				baseQuality.setQualityName(baseQualityVO.getQualityName()); // 订单
																			// 品质名称
				baseQuality.setRemark(baseQualityVO.getRemark()); // 订单品质备注

				getBaseQualityDAO().save(baseQuality);
				vo = new BaseQualityVO(baseQuality);
			} catch (Exception e) {
				vo = null;
				e.printStackTrace();
			}
		}
		return vo;
	}

	@Override
	public BaseQualityVO update(BaseQualityVO baseQualityVO) {
		setChange(true);
		BaseQualityVO vo = null;
		if (baseQualityVO != null && !StringUtil.isNull(baseQualityVO.getId())
				&& StringUtil.isInteger(baseQualityVO.getId())) {
			BaseQuality baseQuality = (BaseQuality) getBaseQualityDAO()
					.findById(Integer.valueOf(baseQualityVO.getId()));
			if (baseQuality != null) {
				try {
					baseQuality.setQualityName(baseQualityVO.getQualityName());
					baseQuality.setRemark(baseQualityVO.getRemark());
					getBaseQualityDAO().update(baseQuality);

					vo = new BaseQualityVO(baseQuality);
				} catch (Exception e) {
					// TODO Auto-generated catch block
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
		for (Integer id : ids) {
			BaseQuality baseQuality = (BaseQuality) getBaseQualityDAO()
					.findById(id);
			if (baseQuality != null) {
				try {
					getBaseQualityDAO().delete(baseQuality);
					size++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return size;
	}

	@Override
	public List findAll() {
		if (isChange() || SystemUtil.isNull(getBaseQualityVOs())) {
			List<BaseQuality> baseQualities = getBaseQualityDAO().findAll();
			baseQualityVOs = new ArrayList<BaseQualityVO>();
			for (BaseQuality baseQuality : baseQualities) {
				baseQualityVOs.add(new BaseQualityVO(baseQuality));
			}
			baseQualities = null;
		}
		return baseQualityVOs;
	}

	public BaseQualityDAO getBaseQualityDAO() {
		return baseQualityDAO;
	}

	public void setBaseQualityDAO(BaseQualityDAO baseQualityDAO) {
		this.baseQualityDAO = baseQualityDAO;
	}

	public static ArrayList<BaseQualityVO> getBaseQualityVOs() {
		return baseQualityVOs;
	}

	public static void setBaseQualityVOs(ArrayList<BaseQualityVO> baseQualityVOs) {
		BaseQualityServiceImpl.baseQualityVOs = baseQualityVOs;
	}

	public static boolean isChange() {
		return change;
	}

	public static void setChange(boolean change) {
		BaseQualityServiceImpl.change = change;
	}

}
