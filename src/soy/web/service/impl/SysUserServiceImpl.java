package soy.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.SysFunctionDAO;
import soy.basic.dao.SysRoleDAO;
import soy.basic.dao.SysUserDAO;
import soy.basic.database.entity.SysFunction;
import soy.basic.database.entity.SysRole;
import soy.basic.database.entity.SysUser;
import soy.basic.vo.SysUserVO;
import soy.util.PaginatedList;
import soy.util.PasswordControl;
import soy.util.StringUtil;
import soy.util.SystemUtil;
import soy.web.service.SysUserService;

public class SysUserServiceImpl implements SysUserService {

	private static final Logger log = LoggerFactory
			.getLogger(SysUserServiceImpl.class);

	private SysUserDAO sysUserDAO;
	private SysRoleDAO sysRoleDAO;
	private SysFunctionDAO sysFunctionDAO;

	@Override
	public SysUser login(String username) {
		SysUser sysUser = null;
		if (!StringUtil.isNull(username)) {
			List list = getSysUserDAO().findByUsername(username);
			if (!SystemUtil.isNull(list)) {
				sysUser = (SysUser) list.get(0);
			}
		}
		return sysUser;
	}

	@Override
	public List<SysFunction> findAllSysFunction() {
		return getSysFunctionDAO().findAll();
	}

	@Override
	public PaginatedList find(PaginatedList list, SysUserVO vo) {
		list = getSysUserDAO().find(list, vo);
		List<SysUser> sysUsers = list.getList();
		List<SysUserVO> sysUserVOs = new ArrayList<SysUserVO>();
		for (SysUser sysUser : sysUsers) {
			sysUserVOs.add(new SysUserVO(sysUser));
		}
		list.setList(sysUserVOs);
		sysUsers = null;
		return list;
	}

	@Override
	public SysUserVO save(SysUserVO sysUserVO) {
		SysUserVO vo = null;
		if (sysUserVO != null) {
			try {
				SysUser sysUser = new SysUser();
				
				sysUser.setUsername(sysUserVO.getUsername());
				sysUser.setName(sysUserVO.getName());
				sysUser.setPassword(PasswordControl.EncryptePassword(sysUserVO.getPassword()));
				sysUser.setGender(sysUserVO.getGender());
				SysRole sysRole = (SysRole) getSysRoleDAO().findById(Integer.valueOf(sysUserVO.getSysRoleId()));
				sysUser.setSysRole(sysRole);
				sysUser.setPhoneTh1(sysUserVO.getPhoneTh1());
				sysUser.setEmailTh1(sysUserVO.getEmailTh1());
				sysUser.setRemark(sysUserVO.getRemark());
				getSysUserDAO().save(sysUser);

				vo = new SysUserVO(sysUser);
			} catch (Exception e) {
				vo = null;
				e.printStackTrace();
			}
		}
		return vo;
	}

	@Override
	public SysUserVO findById(Integer id) {
		SysUserVO sysUserVO = null;
		if (id != null && id.intValue() > 0) {
			SysUser sysUser = (SysUser) getSysUserDAO().findById(id);
			if (sysUser != null) {
				sysUserVO = new SysUserVO(sysUser);
			}
		}
		return sysUserVO;
	}

	@Override
	public SysUserVO update(SysUserVO sysUserVO) {
		SysUserVO vo = null;
		if (sysUserVO != null && !StringUtil.isNull(sysUserVO.getId())) {
			SysUser sysUser = (SysUser) getSysUserDAO().findById(
					Integer.valueOf(sysUserVO.getId()));
			if (sysUser != null) {
				try {
//					SysUser.setClassName(SysUserVO.getClassName());
//					SysUser.setRemark(SysUserVO.getRemark());

					getSysUserDAO().update(sysUser);
					vo = new SysUserVO(sysUser);
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
				SysUser SysUser = (SysUser) getSysUserDAO().findById(id);
				if (SysUser != null) {
					try {
						getSysUserDAO().delete(SysUser);
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

	public SysUserDAO getSysUserDAO() {
		return sysUserDAO;
	}

	public void setSysUserDAO(SysUserDAO sysUserDAO) {
		this.sysUserDAO = sysUserDAO;
	}

	public SysFunctionDAO getSysFunctionDAO() {
		return sysFunctionDAO;
	}

	public void setSysFunctionDAO(SysFunctionDAO sysFunctionDAO) {
		this.sysFunctionDAO = sysFunctionDAO;
	}

	public SysRoleDAO getSysRoleDAO() {
		return sysRoleDAO;
	}

	public void setSysRoleDAO(SysRoleDAO sysRoleDAO) {
		this.sysRoleDAO = sysRoleDAO;
	}

	
}
