package soy.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.BaseProductionDAO;
import soy.basic.database.entity.BaseClass;
import soy.basic.database.entity.BaseProduction;
import soy.basic.vo.BaseClassVO;
import soy.basic.vo.BaseProductionVO;
import soy.util.HibernateUtil;
import soy.util.PaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;
import soy.web.service.BaseProductionService;

/**
 * @author XiaoLiang·Hu
 * 
 */
public class BaseProductionServiceImpl implements BaseProductionService {
	private static final Logger log = LoggerFactory
			.getLogger(BaseProductionServiceImpl.class);

	private BaseProductionDAO baseProductionDAO;
	
	private static boolean change = false;
	
	@Override
	public PaginatedList find(PaginatedList list, BaseProductionVO vo) {
		list = getBaseProductionDAO().find(list, vo);
		List<BaseProduction> baseProductions = list.getList();
		System.out.println("获得集合：" + baseProductions);
		List<BaseProductionVO> baseProductionVOs = HibernateUtil.parseToVos(baseProductions, BaseProductionVO.class);
		list.setList(baseProductionVOs);
		baseProductions = null;
		return list;
	}

	@Override
	public BaseProductionVO save(BaseProductionVO productionVO) {
		setChange(true);
		BaseProductionVO vo = null;
		if (productionVO != null) {
			try {
				BaseProduction baseProduction = new BaseProduction();

				baseProduction.setName(productionVO.getName());
				baseProduction.setRemark(productionVO.getRemark());
				
				getBaseProductionDAO().save(baseProduction);

				vo = new BaseProductionVO(baseProduction);
				
			} catch (Exception e) {
				vo = null;
				e.printStackTrace();
			}
		}
		return vo;
	}

	@Override
	public BaseProductionVO findById(Integer id) {
		BaseProductionVO baseProductionVO = null;
		if (id != null && id.intValue() > 0) {
			BaseProduction baseProduction = (BaseProduction) getBaseProductionDAO().findById(id);
			if (baseProduction != null) {
				baseProductionVO = new BaseProductionVO(baseProduction);
			}
		}
		return baseProductionVO;
	}

	@Override
	public BaseProductionVO update(BaseProductionVO baseProductionVO) {
		setChange(true);
		BaseProductionVO vo = null;
		if (baseProductionVO != null && !StringUtil.isNull(baseProductionVO.getId())) {
			BaseProduction baseProduction = (BaseProduction) getBaseProductionDAO().findById(Integer.valueOf(baseProductionVO.getId()));
			if (baseProduction != null) {
				try {
					baseProduction.setName(baseProductionVO.getName());
					baseProduction.setRemark(baseProductionVO.getRemark());

					getBaseProductionDAO().update(baseProduction);
					vo = new BaseProductionVO(baseProduction);
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
				BaseProduction baseProduction = (BaseProduction) getBaseProductionDAO().findById(id);
				if (baseProduction != null) {
					try {
						getBaseProductionDAO().delete(baseProduction);
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

	public BaseProductionDAO getBaseProductionDAO() {
		return baseProductionDAO;
	}

	public void setBaseProductionDAO(BaseProductionDAO baseProductionDAO) {
		this.baseProductionDAO = baseProductionDAO;
	}

	public boolean isChange() {
		return change;
	}

	public void setChange(boolean change) {
		BaseProductionServiceImpl.change = change;
	}

	
}
