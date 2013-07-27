package soy.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.BaseDeliveryDAO;
import soy.basic.database.entity.BaseDelivery;
import soy.basic.vo.BaseDeliveryVO;
import soy.util.PaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;
import soy.web.service.BaseDeliveryService;

/**
 * 
 * @author 小胡
 * 
 */
public class BaseDeliveryServiceImpl implements BaseDeliveryService {
	// 日志
	private static final Logger log = LoggerFactory
			.getLogger(BaseDeliveryServiceImpl.class);

	// DAO
	private BaseDeliveryDAO baseDeliveryDAO;

	// 缓存集合
	private static ArrayList<BaseDeliveryVO> baseDeliveryVOs;

	// 属性
	private static boolean change = false;

	@Override
	public PaginatedList find(PaginatedList list, BaseDeliveryVO baseDeliveryVO) {
		list = getBaseDeliveryDAO().find(list, baseDeliveryVO);
		List<BaseDelivery> baseDeliveries = list.getList();
		List<BaseDeliveryVO> baseDeliveryVOs = new ArrayList<BaseDeliveryVO>();
		for (BaseDelivery baseDelivery : baseDeliveries) {
			baseDeliveryVOs.add(new BaseDeliveryVO(baseDelivery));
		}
		list.setList(baseDeliveryVOs);
		baseDeliveries = null;
		return list;
	}

	@Override
	public BaseDeliveryVO save(BaseDeliveryVO baseDeliveryVO) {
		setChange(true);
		BaseDeliveryVO vo = null;
		if (baseDeliveryVO != null) {
			try {
				BaseDelivery baseDelivery = new BaseDelivery();

				baseDelivery.setDeliveryName(baseDeliveryVO.getDeliveryName());
				baseDelivery.setRemark(baseDeliveryVO.getRemark());
				getBaseDeliveryDAO().save(baseDelivery);

				vo = new BaseDeliveryVO(baseDelivery);
			} catch (Exception e) {
				vo = null;
				e.printStackTrace();
			}
		}
		return vo;
	}

	@Override
	public BaseDeliveryVO update(BaseDeliveryVO baseDeliveryVO) {
		setChange(true);
		BaseDeliveryVO vo = null;
		if (baseDeliveryVO != null
				&& !StringUtil.isNull(baseDeliveryVO.getId())
				&& StringUtil.isInteger(baseDeliveryVO.getId())) {
			BaseDelivery baseDelivery = (BaseDelivery) getBaseDeliveryDAO()
					.findById(Integer.valueOf(baseDeliveryVO.getId()));
			if (baseDelivery != null) {
				try {
					baseDelivery.setDeliveryName(baseDeliveryVO
							.getDeliveryName());
					baseDelivery.setRemark(baseDeliveryVO.getRemark());

					getBaseDeliveryDAO().update(baseDelivery);
					vo = new BaseDeliveryVO(baseDelivery);
				} catch (Exception e) {
					vo = null;
					e.printStackTrace();
				}
			}
		}
		return vo;
	}

	@Override
	public BaseDeliveryVO findById(Integer id) {
		BaseDeliveryVO baseDeliveryVO = null;
		if (id != null && id.intValue() > 0) {
			BaseDelivery baseDelivery = (BaseDelivery) getBaseDeliveryDAO()
					.findById(id);
			if (baseDelivery != null) {
				baseDeliveryVO = new BaseDeliveryVO(baseDelivery);
			}
		}
		return baseDeliveryVO;
	}

	@Override
	public int delete(Integer[] ids) {
		setChange(true);
		int size = 0;
		if (!SystemUtil.isNull(ids)) {
			for (Integer id : ids) {
				BaseDelivery baseDelivery = (BaseDelivery) getBaseDeliveryDAO()
						.findById(id);
				if (baseDelivery != null) {
					try {
						getBaseDeliveryDAO().delete(baseDelivery);
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
		if (isChange() || SystemUtil.isNull(getBaseDeliveryVOs())) {
			List<BaseDelivery> baseDeliveries = getBaseDeliveryDAO().findAll();
			baseDeliveryVOs = new ArrayList<BaseDeliveryVO>();
			for (BaseDelivery baseDelivery : baseDeliveries) {
				baseDeliveryVOs.add(new BaseDeliveryVO(baseDelivery));
			}
			baseDeliveries = null;
		}
		return baseDeliveryVOs;
	}

	public BaseDeliveryDAO getBaseDeliveryDAO() {
		return baseDeliveryDAO;
	}

	public void setBaseDeliveryDAO(BaseDeliveryDAO baseDeliveryDAO) {
		this.baseDeliveryDAO = baseDeliveryDAO;
	}

	public static ArrayList<BaseDeliveryVO> getBaseDeliveryVOs() {
		return baseDeliveryVOs;
	}

	public static void setBaseDeliveryVOs(
			ArrayList<BaseDeliveryVO> baseDeliveryVOs) {
		BaseDeliveryServiceImpl.baseDeliveryVOs = baseDeliveryVOs;
	}

	public static boolean isChange() {
		return change;
	}

	public static void setChange(boolean change) {
		BaseDeliveryServiceImpl.change = change;
	}

}
