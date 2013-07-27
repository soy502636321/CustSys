package soy.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.BaseSourceDAO;
import soy.basic.database.entity.BaseSource;
import soy.basic.vo.BaseSourceVO;
import soy.util.PaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;
import soy.web.service.BaseSourceService;

public class BaseSourceServiceImpl implements BaseSourceService {
	// 日志
	private static final Logger log = LoggerFactory
			.getLogger(BaseSourceServiceImpl.class);

	// DAO
	private BaseSourceDAO baseSourceDAO;

	// 缓存集合
	private static ArrayList<BaseSourceVO> baseSourceVOs;

	// 属性
	private static boolean change = false;

	@Override
	public BaseSourceVO save(BaseSourceVO baseSourceVO) {
		setChange(true);
		BaseSourceVO vo = null;
		if (baseSourceVO != null) {
			try {
				BaseSource baseSource = new BaseSource();
				baseSource.setSourceName(baseSourceVO.getSourceName());
				baseSource.setRemark(baseSourceVO.getRemark());
				getBaseSourceDAO().save(baseSource);

				vo = new BaseSourceVO(baseSource);
			} catch (Exception e) {
				vo = null;
				e.printStackTrace();
			}
		}
		return vo;
	}

	@Override
	public BaseSourceVO findById(Integer id) {
		BaseSourceVO baseSourceVO = null;
		if (id != null && id.intValue() > 0) {
			BaseSource baseSource = (BaseSource) getBaseSourceDAO()
					.findById(id);
			if (baseSource != null) {
				baseSourceVO = new BaseSourceVO(baseSource);
			}
		}
		return baseSourceVO;
	}

	@Override
	public PaginatedList find(PaginatedList list, BaseSourceVO baseSourceVO) {
		list = getBaseSourceDAO().find(list, baseSourceVO);
		List<BaseSource> baseSources = list.getList();
		List<BaseSourceVO> baseSourceVOs = new ArrayList<BaseSourceVO>();
		for (BaseSource baseSource : baseSources) {
			baseSourceVOs.add(new BaseSourceVO(baseSource));
		}
		list.setList(baseSourceVOs);
		return list;
	}

	@Override
	public BaseSourceVO update(BaseSourceVO baseSourceVO) {
		setChange(true);
		BaseSourceVO vo = null;
		if (baseSourceVO != null && !StringUtil.isNull(baseSourceVO.getId())
				&& StringUtil.isInteger(baseSourceVO.getId())) {
			BaseSource baseSource = (BaseSource) getBaseSourceDAO().findById(
					Integer.valueOf(baseSourceVO.getId()));
			if (baseSource != null) {
				try {
					baseSource.setSourceName(baseSourceVO.getSourceName());
					baseSource.setRemark(baseSourceVO.getRemark());

					getBaseSourceDAO().update(baseSource);
					vo = new BaseSourceVO(baseSource);
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
		for (Integer id : ids) {
			BaseSource baseSource = (BaseSource) getBaseSourceDAO()
					.findById(id);
			if (baseSource != null) {
				try {
					getBaseSourceDAO().delete(baseSource);
					size++;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return size;
	}

	@Override
	public List findAll() {
		if (isChange() || SystemUtil.isNull(getBaseSourceVOs())) {
			List<BaseSource> baseSources = getBaseSourceDAO().findAll();
			baseSourceVOs = new ArrayList<BaseSourceVO>();
			for (BaseSource baseSource : baseSources) {
				baseSourceVOs.add(new BaseSourceVO(baseSource));
			}
			baseSources = null;
		}
		return baseSourceVOs;
	}

	public BaseSourceDAO getBaseSourceDAO() {
		return baseSourceDAO;
	}

	public void setBaseSourceDAO(BaseSourceDAO baseSourceDAO) {
		this.baseSourceDAO = baseSourceDAO;
	}

	public static boolean isChange() {
		return change;
	}

	public static void setChange(boolean change) {
		BaseSourceServiceImpl.change = change;
	}

	public ArrayList<BaseSourceVO> getBaseSourceVOs() {
		return baseSourceVOs;
	}

	public void setBaseSourceVOs(ArrayList<BaseSourceVO> baseSourceVOs) {
		this.baseSourceVOs = baseSourceVOs;
	}

}
