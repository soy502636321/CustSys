package soy.web.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.SysRoleDAO;
import soy.web.service.SysRoleService;

public class SysRoleServiceImpl implements SysRoleService {
	private static final Logger log = LoggerFactory
			.getLogger(SysRoleServiceImpl.class);
	private SysRoleDAO sysRoleDAO;

	@Override
	public List findAll() {
		return getSysRoleDAO().findAll();
	}

	public SysRoleDAO getSysRoleDAO() {
		return sysRoleDAO;
	}

	public void setSysRoleDAO(SysRoleDAO sysRoleDAO) {
		this.sysRoleDAO = sysRoleDAO;
	}

}
