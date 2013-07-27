package soy.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.BaseTypeDAO;
import soy.basic.database.entity.BaseType;
import soy.basic.vo.BaseTypeVO;
import soy.util.PaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;
import soy.web.service.BaseTypeService;

public class BaseTypeServiceImpl implements BaseTypeService {
	// 日志
	private static final Logger log = LoggerFactory
			.getLogger(BaseTypeServiceImpl.class);

	// DAO
	private BaseTypeDAO baseTypeDAO;



	// 缓存集合
	private static ArrayList<BaseTypeVO> baseTypeVOs;
	// 属性
	private static boolean change = false; // 标记是否改变

	@Override
	public BaseTypeVO save(BaseTypeVO baseTypeVO) {
		setChange(true);
		BaseTypeVO vo = null;
		if (baseTypeVO != null) {
			try {
				BaseType BaseType = new BaseType();
				BaseType.setTypeName(baseTypeVO.getTypeName());
				BaseType.setRemark(baseTypeVO.getRemark());
				getBaseTypeDAO().save(BaseType);

				vo = new BaseTypeVO(BaseType);
			} catch (Exception e) {
				vo = null;
				e.printStackTrace();
			}
		}
		return vo;
	}

	@Override
	public BaseTypeVO findById(Integer id) {
		BaseTypeVO BaseTypeVO = null;
		if (id != null && id.intValue() > 0) {
			BaseType BaseType = (BaseType) getBaseTypeDAO().findById(id);
			if (BaseType != null) {
				BaseTypeVO = new BaseTypeVO(BaseType);
			}
		}
		return BaseTypeVO;
	}

	@Override
	public PaginatedList find(PaginatedList list, BaseTypeVO BaseTypeVO) {
		list = getBaseTypeDAO().find(list, BaseTypeVO);
		List<BaseType> baseTypes = list.getList();
		List<BaseTypeVO> baseTypeVOs = new ArrayList<BaseTypeVO>();
		for (BaseType baseType : baseTypes) {
			baseTypeVOs.add(new BaseTypeVO(baseType));
		}
		list.setList(baseTypeVOs);
		return list;
	}

	@Override
	public BaseTypeVO update(BaseTypeVO baseTypeVO) {
		setChange(true);
		BaseTypeVO vo = null;
		if (baseTypeVO != null && !StringUtil.isNull(baseTypeVO.getId())
				&& StringUtil.isInteger(baseTypeVO.getId())) {
			BaseType baseType = (BaseType) getBaseTypeDAO().findById(
					Integer.valueOf(baseTypeVO.getId()));
			if (baseType != null) {
				try {
					baseType.setTypeName(baseTypeVO.getTypeName());
					baseType.setRemark(baseTypeVO.getRemark());

					getBaseTypeDAO().update(baseType);
					vo = new BaseTypeVO(baseType);
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
			BaseType BaseType = (BaseType) getBaseTypeDAO().findById(id);
			if (BaseType != null) {
				try {
					getBaseTypeDAO().delete(BaseType);
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
		if (isChange() || SystemUtil.isNull(getBaseTypeVOs())) {
			List<BaseType> baseTypes = getBaseTypeDAO().findAll();
			baseTypeVOs = new ArrayList<BaseTypeVO>();
			for (BaseType baseType : baseTypes) {
				baseTypeVOs.add(new BaseTypeVO(baseType));
			}
			baseTypes = null;
		}
		return baseTypeVOs;
	}

	public BaseTypeDAO getBaseTypeDAO() {
		return baseTypeDAO;
	}

	public void setBaseTypeDAO(BaseTypeDAO baseTypeDAO) {
		this.baseTypeDAO = baseTypeDAO;
	}

	public static boolean isChange() {
		return change;
	}

	public static void setChange(boolean change) {
		BaseTypeServiceImpl.change = change;
	}

	public ArrayList<BaseTypeVO> getBaseTypeVOs() {
		return baseTypeVOs;
	}

	public void setBaseTypeVOs(ArrayList<BaseTypeVO> baseTypeVOs) {
		this.baseTypeVOs = baseTypeVOs;
	}

}
