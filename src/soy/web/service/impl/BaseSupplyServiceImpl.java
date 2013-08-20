package soy.web.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.BaseSupplyDAO;
import soy.basic.database.entity.BaseClass;
import soy.basic.database.entity.BaseSupply;
import soy.basic.vo.BaseClassVO;
import soy.basic.vo.BaseSupplyVO;
import soy.util.PaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;
import soy.web.service.BaseSupplyService;

public class BaseSupplyServiceImpl implements BaseSupplyService {
	// 日志
	private static final Logger log = LoggerFactory
			.getLogger(BaseSupplyServiceImpl.class);

	// DAO
	private BaseSupplyDAO baseSupplyDAO;

	// 属性
	private static boolean change = false;
	private static List<BaseSupplyVO> baseSupplyVOs;

	@Override
	public PaginatedList find(PaginatedList list, BaseSupplyVO baseSupplyVO) {
		return getBaseSupplyDAO().find(list, baseSupplyVO);
	}

	@Override
	public BaseSupplyVO save(BaseSupplyVO baseSupplyVO) {
		setChange(true);
//		BaseClassVO vo = null;
		BaseSupplyVO vo = null;
		if (baseSupplyVO != null) {
			try {
				BaseSupply baseSupply = new BaseSupply();
				
				baseSupply.setSupplyName(baseSupplyVO.getSupplyName());
				baseSupply.setRemark(baseSupplyVO.getRemark());
				
				getBaseSupplyDAO().save(baseSupply);

				vo = new BaseSupplyVO(baseSupply);
			} catch (Exception e) {
				vo = null;
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	@Override
	public BaseSupplyVO findById(Integer id) {
		BaseSupplyVO baseSupplyVO = null;
		if (id != null && id.intValue() > 0) {
			BaseSupply baseSupply = (BaseSupply) getBaseSupplyDAO().findById(id);
			if (baseSupply != null) {
				baseSupplyVO = new BaseSupplyVO(baseSupply);
			}
		}
		return baseSupplyVO;
	}
	
	@Override
	public BaseSupplyVO update(BaseSupplyVO baseSupplyVO) {
		setChange(true);
		BaseSupplyVO vo = null;
		if (baseSupplyVO != null && !StringUtil.isNull(baseSupplyVO.getId())) {
//			BaseClass baseClass = (BaseClass) getBaseClassDAO().findById(
//					Integer.valueOf(baseClassVO.getId()));
			Integer id = Integer.valueOf(baseSupplyVO.getId());
			BaseSupply baseSupply = (BaseSupply) getBaseSupplyDAO().findById(id);
			if (baseSupply != null) {
				try {
//					baseClass.setClassName(baseClassVO.getClassName());
//					baseClass.setRemark(baseClassVO.getRemark());
					baseSupply.setSupplyName(baseSupplyVO.getSupplyName());
					baseSupply.setRemark(baseSupplyVO.getRemark());

//					getBaseClassDAO().update(baseClass);
					getBaseSupplyDAO().update(baseSupply);
//					vo = new BaseClassVO(baseClass);
					vo = new BaseSupplyVO(baseSupply);
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
				BaseSupply baseSupply = (BaseSupply) getBaseSupplyDAO().findById(id);
				if (baseSupply != null) {
					try {
						getBaseSupplyDAO().delete(baseSupply);
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
	public List findAll() {
		if (isChange() || SystemUtil.isNull(getBaseSupplyVOs())) {
			List<BaseSupply> baseSupplies = getBaseSupplyDAO().findAll();
			baseSupplyVOs = new ArrayList<BaseSupplyVO>();
			for (BaseSupply baseSupply : baseSupplies) {
				baseSupplyVOs.add(new BaseSupplyVO(baseSupply));
			}
			baseSupplies = null;
		}
		return baseSupplyVOs;
	}

	public BaseSupplyDAO getBaseSupplyDAO() {
		return baseSupplyDAO;
	}

	public void setBaseSupplyDAO(BaseSupplyDAO baseSupplyDAO) {
		this.baseSupplyDAO = baseSupplyDAO;
	}

	public static boolean isChange() {
		return change;
	}

	public static void setChange(boolean change) {
		BaseSupplyServiceImpl.change = change;
	}

	public static List<BaseSupplyVO> getBaseSupplyVOs() {
		return baseSupplyVOs;
	}

	public static void setBaseSupplyVOs(List<BaseSupplyVO> baseSupplyVOs) {
		BaseSupplyServiceImpl.baseSupplyVOs = baseSupplyVOs;
	}

}
