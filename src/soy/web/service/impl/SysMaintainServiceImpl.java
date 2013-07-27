package soy.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.BaseMaintaintypeDAO;
import soy.basic.dao.SysCustDAO;
import soy.basic.dao.SysMaintainDAO;
import soy.basic.dao.SysUserDAO;
import soy.basic.database.entity.BaseMaintaintype;
import soy.basic.database.entity.SysCust;
import soy.basic.database.entity.SysMaintain;
import soy.basic.database.entity.SysUser;
import soy.basic.vo.SysCustVO;
import soy.basic.vo.SysMaintainVO;
import soy.util.PaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;
import soy.web.service.SysMaintainService;

public class SysMaintainServiceImpl implements SysMaintainService {
	private static final Logger log = LoggerFactory
			.getLogger(SysMaintainServiceImpl.class);

	private SysMaintainDAO sysMaintainDAO;
	private SysCustDAO sysCustDAO;
	private BaseMaintaintypeDAO baseMaintaintypeDAO;

	@Override
	public PaginatedList find(PaginatedList list, SysMaintainVO vo,
			SysCustVO vo2) {
		list = getSysMaintainDAO().find(list, vo, vo2);
		List<SysMaintain> sysMaintaines = list.getList();
		List<SysMaintainVO> sysMaintainVOs = new ArrayList<SysMaintainVO>();
		for (SysMaintain sysMaintain : sysMaintaines) {
			sysMaintainVOs.add(new SysMaintainVO(sysMaintain));
		}
		list.setList(sysMaintainVOs);
		sysMaintaines = null;
		return list;
	}

	@Override
	public SysMaintainVO save(SysMaintainVO sysMaintainVO) {
		SysMaintainVO vo = null;
		if (sysMaintainVO != null) {
			try {
				SysMaintain sysMaintain = new SysMaintain();
				SysCust sysCust = null;
				System.out.println(1);
				if (!StringUtil.isNull(sysMaintainVO.getSysCustId())
						&& StringUtil.isInteger(sysMaintainVO.getSysCustId())) {
					sysCust = (SysCust) getSysCustDAO().findById(
							Integer.valueOf(sysMaintainVO.getSysCustId()));
				}
				System.out.println(2);
				if (sysCust == null) {
					return null;
				}
				System.out.println(3);
				sysMaintain.setSysCust(sysCust); // 客户
				sysMaintain.setMaintainTime(sysMaintainVO.getMaintainTime()); // 维护时间
				sysMaintain.setName(sysMaintainVO.getName()); // 联系人名字
				BaseMaintaintype baseMaintaintype = null;
				System.out.println(4);
				if (StringUtil.isInteger(sysMaintainVO.getBaseMaintaintypeId())) {
					baseMaintaintype = (BaseMaintaintype) getBaseMaintaintypeDAO()
							.findById(
									Integer.valueOf(sysMaintainVO
											.getBaseMaintaintypeId()));
				}
				sysMaintain.setBaseMaintaintype(baseMaintaintype); // 维护类型
				sysMaintain.setActiveDesc(sysMaintainVO.getActiveDesc()); // 活动描述
				sysMaintain.setResult(sysMaintainVO.getResult()); // 维护结果
				sysMaintain.setRemark(sysMaintainVO.getRemark()); // 备注

				getSysMaintainDAO().save(sysMaintain);

				vo = new SysMaintainVO(sysMaintain);
			} catch (Exception e) {
				vo = null;
				e.printStackTrace();
			}
		}
		return vo;
	}

	@Override
	public SysMaintainVO findById(Integer id) {
		SysMaintainVO sysMaintainVO = null;
		if (id != null && id.intValue() > 0) {
			SysMaintain sysMaintain = (SysMaintain) getSysMaintainDAO()
					.findById(id);
			if (sysMaintain != null) {
				sysMaintainVO = new SysMaintainVO(sysMaintain);
			}
		}
		return sysMaintainVO;
	}

	@Override
	public SysMaintainVO update(SysMaintainVO sysMaintainVO) {
		SysMaintainVO vo = null;
		if (sysMaintainVO != null && !StringUtil.isNull(sysMaintainVO.getId())) {
			SysMaintain sysMaintain = (SysMaintain) getSysMaintainDAO()
					.findById(Integer.valueOf(sysMaintainVO.getId()));
			if (sysMaintain != null) {
				try {
					System.out.println("获得修改的维护时间:"
							+ sysMaintainVO.getMaintainTime());
					sysMaintain
							.setMaintainTime(sysMaintainVO.getMaintainTime()); // 维护时间
					sysMaintain.setName(sysMaintainVO.getName()); // 联系人名字
					BaseMaintaintype baseMaintaintype = (BaseMaintaintype) getBaseMaintaintypeDAO()
							.findById(
									Integer.valueOf(sysMaintainVO
											.getBaseMaintaintypeId()));
					sysMaintain.setBaseMaintaintype(baseMaintaintype); // 维护类型
					sysMaintain.setActiveDesc(sysMaintainVO.getActiveDesc()); // 活动描述
					sysMaintain.setResult(sysMaintainVO.getResult()); // 维护结果
					sysMaintain.setRemark(sysMaintainVO.getRemark()); // 备注

					getSysMaintainDAO().update(sysMaintain);
					vo = new SysMaintainVO(sysMaintain);
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
		int size = 0;
		if (!SystemUtil.isNull(ids)) {
			for (Integer id : ids) {
				SysMaintain sysMaintain = (SysMaintain) getSysMaintainDAO()
						.findById(id);
				if (sysMaintain != null) {
					try {
						getSysMaintainDAO().delete(sysMaintain);
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

	public SysMaintainDAO getSysMaintainDAO() {
		return sysMaintainDAO;
	}

	public void setSysMaintainDAO(SysMaintainDAO sysMaintainDAO) {
		this.sysMaintainDAO = sysMaintainDAO;
	}

	public SysCustDAO getSysCustDAO() {
		return sysCustDAO;
	}

	public void setSysCustDAO(SysCustDAO sysCustDAO) {
		this.sysCustDAO = sysCustDAO;
	}

	public BaseMaintaintypeDAO getBaseMaintaintypeDAO() {
		return baseMaintaintypeDAO;
	}

	public void setBaseMaintaintypeDAO(BaseMaintaintypeDAO baseMaintaintypeDAO) {
		this.baseMaintaintypeDAO = baseMaintaintypeDAO;
	}

}
