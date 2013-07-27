package soy.web.service;

import java.util.List;

import soy.basic.database.entity.SysFunction;
import soy.basic.database.entity.SysUser;
import soy.basic.vo.SysUserVO;
import soy.util.PaginatedList;

public interface SysUserService {

	public SysUser login(String username);

	public List<SysFunction> findAllSysFunction();

	public PaginatedList find(PaginatedList list,
			SysUserVO sysUserVO);

	public SysUserVO save(SysUserVO sysUserVO);

	public SysUserVO findById(Integer id);

	public SysUserVO update(SysUserVO sysUserVO);

	public int delete(Integer[] ids);
}
