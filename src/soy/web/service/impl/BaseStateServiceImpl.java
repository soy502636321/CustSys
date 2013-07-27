package soy.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.BaseStateDAO;
import soy.basic.database.entity.BaseState;
import soy.basic.vo.BaseStateVO;
import soy.util.PaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;
import soy.web.service.BaseStateService;

public class BaseStateServiceImpl implements BaseStateService {
	// 日志
	private static final Logger log = LoggerFactory
			.getLogger(BaseStateServiceImpl.class);

	// DAO
	private BaseStateDAO baseStateDAO;

	// 缓存集合
	private static ArrayList<BaseStateVO> baseStateVOs;

	private static boolean change = false;

	@Override
	public PaginatedList find(PaginatedList list, BaseStateVO baseStateVO) {
		list = getBaseStateDAO().find(list, baseStateVO);
		List<BaseState> baseStates = list.getList();
		List<BaseStateVO> baseStateVOs = new ArrayList<BaseStateVO>();
		for (BaseState baseState : baseStates) {
			baseStateVOs.add(new BaseStateVO(baseState));
		}
		list.setList(baseStateVOs);
		baseStates = null;
		return list;
	}

	@Override
	public BaseStateVO findById(Integer id) {
		BaseStateVO baseStateVO = null;
		if (id != null && id.intValue() > 0) {
			BaseState baseState = (BaseState) getBaseStateDAO().findById(id);
			if (baseState != null) {
				baseStateVO = new BaseStateVO(baseState);
			}
		}
		return baseStateVO;
	}

	@Override
	public BaseStateVO save(BaseStateVO baseStateVO) {
		setChange(true);
		BaseStateVO vo = null;
		if (baseStateVO != null) {
			try {
				BaseState baseState = new BaseState();
				baseState.setStateName(baseStateVO.getStateName());
				baseState.setRemark(baseStateVO.getRemark());

				getBaseStateDAO().save(baseState);
				vo = new BaseStateVO(baseState);
			} catch (Exception e) {
				vo = null;
				e.printStackTrace();
			}
		}
		return vo;
	}

	@Override
	public BaseStateVO update(BaseStateVO baseStateVO) {
		setChange(true);
		BaseStateVO vo = null;
		if (baseStateVO != null && !StringUtil.isNull(baseStateVO.getId())
				&& StringUtil.isInteger(baseStateVO.getId())) {
			BaseState baseState = (BaseState) getBaseStateDAO().findById(
					Integer.valueOf(baseStateVO.getId()));
			if (baseState != null) {
				try {
					baseState.setStateName(baseStateVO.getStateName());
					baseState.setRemark(baseStateVO.getRemark());
					getBaseStateDAO().update(baseState);

					vo = new BaseStateVO(baseState);
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
			BaseState baseState = (BaseState) getBaseStateDAO().findById(id);
			if (baseState != null) {
				try {
					getBaseStateDAO().delete(baseState);
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
		if (isChange() || SystemUtil.isNull(getBaseStateVOs())) {
			List<BaseState> baseStates = getBaseStateDAO().findAll();
			baseStateVOs = new ArrayList<BaseStateVO>();
			for (BaseState baseState : baseStates) {
				baseStateVOs.add(new BaseStateVO(baseState));
			}
			baseStates = null;
		}
		return baseStateVOs;
	}

	public BaseStateDAO getBaseStateDAO() {
		return baseStateDAO;
	}

	public void setBaseStateDAO(BaseStateDAO baseStateDAO) {
		this.baseStateDAO = baseStateDAO;
	}

	public static ArrayList<BaseStateVO> getBaseStateVOs() {
		return baseStateVOs;
	}

	public static void setBaseStateVOs(ArrayList<BaseStateVO> baseStateVOs) {
		BaseStateServiceImpl.baseStateVOs = baseStateVOs;
	}

	public static boolean isChange() {
		return change;
	}

	public static void setChange(boolean change) {
		BaseStateServiceImpl.change = change;
	}

}
