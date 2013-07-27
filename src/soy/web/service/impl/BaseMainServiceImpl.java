package soy.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.BaseMainDAO;
import soy.basic.database.entity.BaseMain;
import soy.basic.vo.BaseClassVO;
import soy.basic.vo.BaseMainVO;
import soy.util.PaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;
import soy.web.service.BaseMainService;

/**
 * @author XiaoLiang·Hu
 * 
 */
public class BaseMainServiceImpl implements BaseMainService {
	private static final Logger log = LoggerFactory
			.getLogger(BaseMainServiceImpl.class);

	private BaseMainDAO baseMainDAO;
	// 属性
	private static boolean change = false;
	private static List<BaseMain> selectList;

	@Override
	public PaginatedList find(PaginatedList list, BaseMainVO baseMainVO) {
		list = getBaseMainDAO().find(list, baseMainVO);
		List<BaseMain> baseMains = list.getList();
		List<BaseMainVO> baseMainVOs = new ArrayList<BaseMainVO>();
		for (BaseMain baseMain : baseMains) {
			baseMainVOs.add(new BaseMainVO(baseMain));
		}
		list.setList(baseMainVOs);
		baseMains = null;
		return list;
	}

	@Override
	public BaseMainVO save(BaseMainVO baseMainVO) {
		setChange(true);
		BaseMainVO vo = null;
		try {
			if (baseMainVO != null) {
				try {
					BaseMain baseMain = new BaseMain();
					baseMain.setMainName(baseMainVO.getMainName());
					baseMain.setRemark(baseMainVO.getRemark());

					getBaseMainDAO().save(baseMain);

					vo = new BaseMainVO(baseMain);
				} catch (Exception e) {
					vo = null;
					e.printStackTrace();
				}
			}
			return vo;
		} catch (RuntimeException re) {
			log.error("", re);
			throw re;
		}
	}

	@Override
	public BaseMainVO findById(Integer id) {
		BaseMainVO vo = null;
		if (id != null && id.intValue() > 0) {
			BaseMain baseMain = (BaseMain) getBaseMainDAO().findById(id);
			if (baseMain != null) {
				vo = new BaseMainVO(baseMain);
			}
		}
		return vo;
	}

	@Override
	public BaseMainVO update(BaseMainVO baseMainVO) {
		setChange(true);
//		BaseClassVO vo = null;
		BaseMainVO vo = null;
		if (baseMainVO != null && !StringUtil.isNull(baseMainVO.getId())) {
			BaseMain baseMain = (BaseMain) getBaseMainDAO().findById(
					Integer.valueOf(baseMainVO.getId()));
			if (baseMain != null) {
				try {
					baseMain.setMainName(baseMainVO.getMainName());
					baseMain.setRemark(baseMainVO.getRemark());
					
					getBaseMainDAO().update(baseMain);
					vo = new BaseMainVO(baseMain);
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
//				BaseClass baseClass = (BaseClass) getBaseClassDAO()
//						.findById(id);
				BaseMain baseMain = (BaseMain)getBaseMainDAO().findById(id);
				if (baseMain != null) {
					try {
						getBaseMainDAO().delete(baseMain);
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
	public List<BaseMain> getBaseMainSelect() {
		if (isChange() || SystemUtil.isNull(selectList)) {
			selectList = new ArrayList<BaseMain>();
			BaseMain baseMain = new BaseMain();
			baseMain.setId(null);
			baseMain.setMainName("——请选择——");
			selectList.add(baseMain);
			selectList.addAll(getBaseMainDAO().findAll());
		}
		return selectList;
	}
	
	public BaseMainDAO getBaseMainDAO() {
		return baseMainDAO;
	}

	public void setBaseMainDAO(BaseMainDAO baseMainDAO) {
		this.baseMainDAO = baseMainDAO;
	}

	public static boolean isChange() {
		return change;
	}

	public static void setChange(boolean change) {
		BaseMainServiceImpl.change = change;
	}
	
}
