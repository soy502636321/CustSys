package soy.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.BaseMaintaintypeDAO;
import soy.basic.database.entity.BaseMaintaintype;
import soy.basic.vo.BaseMaintaintypeVO;
import soy.util.PaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;
import soy.web.service.BaseMaintaintypeService;

public class BaseMaintaintypeServiceImpl implements BaseMaintaintypeService {
	// 日志
	private static final Logger log = LoggerFactory
			.getLogger(BaseMaintaintypeServiceImpl.class);

	// DAO
	private BaseMaintaintypeDAO baseMaintaintypeDAO;

	private static ArrayList<BaseMaintaintypeVO> baseMaintaintypeVOs;

	// 缓存集合

	// 属性
	private static boolean change = false;

	@Override
	public PaginatedList find(PaginatedList list,
			BaseMaintaintypeVO baseMaintaintypeVO) {
		list = getBaseMaintaintypeDAO().find(list, baseMaintaintypeVO);
		List<BaseMaintaintype> baseMaintaintypes = list.getList();
		List<BaseMaintaintypeVO> baseMaintaintypeVOs = new ArrayList<BaseMaintaintypeVO>();
		for (BaseMaintaintype baseMaintaintype : baseMaintaintypes) {
			baseMaintaintypeVOs.add(new BaseMaintaintypeVO(baseMaintaintype));
		}
		list.setList(baseMaintaintypeVOs);
		baseMaintaintypes = null;
		return list;
	}

	@Override
	public BaseMaintaintypeVO save(BaseMaintaintypeVO baseMaintaintypeVO) {
		setChange(true);
		BaseMaintaintypeVO vo = null;
		if (baseMaintaintypeVO != null) {
			try {
				BaseMaintaintype baseMaintaintype = new BaseMaintaintype();
				baseMaintaintype.setMaintaintypeName(baseMaintaintypeVO
						.getMaintaintypeName());
				baseMaintaintype.setRemark(baseMaintaintypeVO.getRemark());
				getBaseMaintaintypeDAO().save(baseMaintaintype);

				vo = new BaseMaintaintypeVO(baseMaintaintype);
			} catch (Exception e) {
				vo = null;
				e.printStackTrace();
			}
		}
		return vo;
	}

	@Override
	public BaseMaintaintypeVO findById(Integer id) {
		BaseMaintaintypeVO vo = null;
		if (id != null && id.intValue() > 0) {
			BaseMaintaintype baseMaintaintype = (BaseMaintaintype) getBaseMaintaintypeDAO()
					.findById(id);
			if (baseMaintaintype != null) {
				vo = new BaseMaintaintypeVO(baseMaintaintype);
			}
		}
		return vo;
	}

	@Override
	public BaseMaintaintypeVO update(BaseMaintaintypeVO baseMaintaintypeVO) {
		setChange(true);
		BaseMaintaintypeVO vo = null;
		if (baseMaintaintypeVO != null
				&& !StringUtil.isNull(baseMaintaintypeVO.getId())
				&& StringUtil.isInteger(baseMaintaintypeVO.getId())) {
			BaseMaintaintype baseMaintaintype = (BaseMaintaintype) getBaseMaintaintypeDAO()
					.findById(Integer.valueOf(baseMaintaintypeVO.getId()));
			if (baseMaintaintype != null) {
				try {
					baseMaintaintype.setMaintaintypeName(baseMaintaintypeVO
							.getMaintaintypeName());
					baseMaintaintype.setRemark(baseMaintaintypeVO.getRemark());

					getBaseMaintaintypeDAO().update(baseMaintaintype);
					vo = new BaseMaintaintypeVO(baseMaintaintype);
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
				BaseMaintaintype baseMaintaintype = (BaseMaintaintype) getBaseMaintaintypeDAO()
						.findById(id);
				if (baseMaintaintype != null) {
					try {
						getBaseMaintaintypeDAO().delete(baseMaintaintype);
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
		if (isChange() || SystemUtil.isNull(getBaseMaintaintypeVOs())) {
			List<BaseMaintaintype> baseMaintaintypes = getBaseMaintaintypeDAO().findAll();
			baseMaintaintypeVOs = new ArrayList<BaseMaintaintypeVO>();
			for (BaseMaintaintype baseMaintaintype : baseMaintaintypes) {
				baseMaintaintypeVOs
						.add(new BaseMaintaintypeVO(baseMaintaintype));
			}
			baseMaintaintypes = null;
		}
		return baseMaintaintypeVOs;
	}

	public BaseMaintaintypeDAO getBaseMaintaintypeDAO() {
		return baseMaintaintypeDAO;
	}

	public void setBaseMaintaintypeDAO(BaseMaintaintypeDAO baseMaintaintypeDAO) {
		this.baseMaintaintypeDAO = baseMaintaintypeDAO;
	}

	public static boolean isChange() {
		return change;
	}

	public static void setChange(boolean change) {
		BaseMaintaintypeServiceImpl.change = change;
	}

	public static ArrayList<BaseMaintaintypeVO> getBaseMaintaintypeVOs() {
		return baseMaintaintypeVOs;
	}

	public static void setBaseMaintaintypeVOs(
			ArrayList<BaseMaintaintypeVO> baseMaintaintypeVOs) {
		BaseMaintaintypeServiceImpl.baseMaintaintypeVOs = baseMaintaintypeVOs;
	}

}
