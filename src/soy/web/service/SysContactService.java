package soy.web.service;

import soy.basic.vo.SysContactVO;
import soy.basic.vo.SysCustVO;
import soy.util.PaginatedList;

public interface SysContactService {
	public SysContactVO save(SysContactVO sysContactVO);
	public PaginatedList find(PaginatedList list, SysContactVO sysContactVO, SysCustVO sysCustVO);
	public SysContactVO findById(Integer id);
	public SysContactVO update(SysContactVO sysContactVO);
}
