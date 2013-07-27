package soy.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.BasePaymentDAO;
import soy.basic.database.entity.BasePayment;
import soy.basic.vo.BasePaymentVO;
import soy.util.PaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;
import soy.web.service.BasePaymentService;

public class BasePaymentServiceImpl implements BasePaymentService {
	// 日志
	private static final Logger log = LoggerFactory
			.getLogger(BasePaymentServiceImpl.class);

	// DAO
	private BasePaymentDAO basePaymentDAO;

	// 缓存集合
	private static ArrayList<BasePaymentVO> basePaymentVOs;

	// 属性
	private static boolean change = false;

	@Override
	public PaginatedList find(PaginatedList list, BasePaymentVO basePaymentVO) {
		list = getBasePaymentDAO().find(list, basePaymentVO);
		List<BasePayment> basePayments = list.getList();
		List<BasePaymentVO> basePaymentVOs = new ArrayList<BasePaymentVO>();
		for (BasePayment basePayment : basePayments) {
			basePaymentVOs.add(new BasePaymentVO(basePayment));
		}
		list.setList(basePaymentVOs);
		basePayments = null;
		return list;
	}

	@Override
	public BasePaymentVO save(BasePaymentVO basePaymentVO) {
		setChange(true);
		BasePaymentVO vo = null;
		if (basePaymentVO != null) {
			try {
				BasePayment basePayment = new BasePayment();
				basePayment.setPaymentName(basePaymentVO.getPaymentName());
				basePayment.setRemark(basePaymentVO.getRemark());
				getBasePaymentDAO().save(basePayment);

				vo = new BasePaymentVO(basePayment);
			} catch (Exception e) {
				vo = null;
				e.printStackTrace();
			}
		}
		return vo;
	}

	@Override
	public BasePaymentVO findById(Integer id) {
		BasePaymentVO basePaymentVO = null;
		if (id != null && id.intValue() > 0) {
			BasePayment basePayment = (BasePayment) getBasePaymentDAO()
					.findById(id);
			if (basePayment != null) {
				basePaymentVO = new BasePaymentVO(basePayment);
			}
		}
		return basePaymentVO;
	}

	@Override
	public BasePaymentVO update(BasePaymentVO basePaymentVO) {
		setChange(true);
		BasePaymentVO vo = null;
		if (basePaymentVO != null && !StringUtil.isNull(basePaymentVO.getId())
				&& StringUtil.isInteger(basePaymentVO.getId())) {
			BasePayment basePayment = (BasePayment) getBasePaymentDAO()
					.findById(Integer.valueOf(basePaymentVO.getId()));
			if (basePayment != null) {
				try {
					basePayment.setPaymentName(basePaymentVO.getPaymentName());
					basePayment.setRemark(basePaymentVO.getRemark());

					getBasePaymentDAO().update(basePayment);
					vo = new BasePaymentVO(basePayment);
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
				BasePayment basePayment = (BasePayment) getBasePaymentDAO()
						.findById(id);
				if (basePayment != null) {
					try {
						getBasePaymentDAO().delete(basePayment);
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
		if (isChange() || SystemUtil.isNull(getBasePaymentVOs())) {
			List<BasePayment> basePayments = getBasePaymentDAO().findAll();
			basePaymentVOs = new ArrayList<BasePaymentVO>();
			for (BasePayment basePayment : basePayments) {
				basePaymentVOs.add(new BasePaymentVO(basePayment));
			}
			basePayments = null;
		}
		return basePaymentVOs;
	}

	public BasePaymentDAO getBasePaymentDAO() {
		return basePaymentDAO;
	}

	public void setBasePaymentDAO(BasePaymentDAO basePaymentDAO) {
		this.basePaymentDAO = basePaymentDAO;
	}

	public static ArrayList<BasePaymentVO> getBasePaymentVOs() {
		return basePaymentVOs;
	}

	public static void setBasePaymentVOs(ArrayList<BasePaymentVO> basePaymentVOs) {
		BasePaymentServiceImpl.basePaymentVOs = basePaymentVOs;
	}

	public static boolean isChange() {
		return change;
	}

	public static void setChange(boolean change) {
		BasePaymentServiceImpl.change = change;
	}

}
