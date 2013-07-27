package soy.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.BaseClassDAO;
import soy.basic.database.entity.BaseClass;
import soy.basic.vo.BaseClassVO;
import soy.util.PaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;
import soy.web.service.BaseClassService;

/**
 * 
 * @author 小胡
 * 
 */
public class BaseClassServiceImpl implements BaseClassService {
	// 日志
	private final Logger log = LoggerFactory
			.getLogger(BaseClassServiceImpl.class);

	// DAO
	private BaseClassDAO baseClassDAO;

	// 缓存集合
	private static ArrayList<BaseClassVO> baseClassVOs;

	// 属性
	private static boolean change = false;

	@Override
	public PaginatedList find(PaginatedList list, BaseClassVO vo) {
		list = getBaseClassDAO().find(list, vo);
		List<BaseClass> baseClasses = list.getList();
		List<BaseClassVO> baseClassVOs = new ArrayList<BaseClassVO>();
		for (BaseClass baseClass : baseClasses) {
			baseClassVOs.add(new BaseClassVO(baseClass));
		}
		list.setList(baseClassVOs);
		baseClasses = null;
		return list;
	}

	@Override
	public BaseClassVO save(BaseClassVO baseClassVO) {
		setChange(true);
		BaseClassVO vo = null;
		if (baseClassVO != null) {
			try {
				BaseClass baseClass = new BaseClass();

				baseClass.setClassName(baseClassVO.getClassName());
				baseClass.setRemark(baseClassVO.getRemark());
				getBaseClassDAO().save(baseClass);

				vo = new BaseClassVO(baseClass);
			} catch (Exception e) {
				vo = null;
				e.printStackTrace();
			}
		}
		return vo;
	}

	@Override
	public BaseClassVO findById(Integer id) {
		BaseClassVO baseClassVO = null;
		if (id != null && id.intValue() > 0) {
			BaseClass baseClass = (BaseClass) getBaseClassDAO().findById(id);
			if (baseClass != null) {
				baseClassVO = new BaseClassVO(baseClass);
			}
		}
		return baseClassVO;
	}

	@Override
	public BaseClassVO update(BaseClassVO baseClassVO) {
		setChange(true);
		BaseClassVO vo = null;
		if (baseClassVO != null && !StringUtil.isNull(baseClassVO.getId())) {
			BaseClass baseClass = (BaseClass) getBaseClassDAO().findById(
					Integer.valueOf(baseClassVO.getId()));
			if (baseClass != null) {
				try {
					baseClass.setClassName(baseClassVO.getClassName());
					baseClass.setRemark(baseClassVO.getRemark());

					getBaseClassDAO().update(baseClass);
					vo = new BaseClassVO(baseClass);
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
				BaseClass baseClass = (BaseClass) getBaseClassDAO()
						.findById(id);
				if (baseClass != null) {
					try {
						getBaseClassDAO().delete(baseClass);
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
		if (isChange() || SystemUtil.isNull(getBaseClassVOs())) {
			List<BaseClass> baseClasses = getBaseClassDAO().findAll();
			baseClassVOs = new ArrayList<BaseClassVO>();
			for (BaseClass baseClass : baseClasses) {
				baseClassVOs.add(new BaseClassVO(baseClass));
			}
			baseClasses = null;
		}
		return baseClassVOs;
	}

	public BaseClassDAO getBaseClassDAO() {
		return baseClassDAO;
	}

	public void setBaseClassDAO(BaseClassDAO baseClassDAO) {
		this.baseClassDAO = baseClassDAO;
	}

	public static ArrayList<BaseClassVO> getBaseClassVOs() {
		return baseClassVOs;
	}

	public static void setBaseClassVOs(ArrayList<BaseClassVO> baseClassVOs) {
		BaseClassServiceImpl.baseClassVOs = baseClassVOs;
	}

	public static boolean isChange() {
		return change;
	}

	public static void setChange(boolean change) {
		BaseClassServiceImpl.change = change;
	}

}
