package soy.web.service;

import soy.basic.vo.SysBusinessVO;
import soy.basic.vo.SysCustVO;
import soy.util.PaginatedList;

public interface SysBusinessService {
	public PaginatedList find(PaginatedList list, SysBusinessVO businessVO, SysCustVO sysCustVO);
	
	public SysBusinessVO save(SysBusinessVO sysBusinessVO);
	
	public SysBusinessVO update(SysBusinessVO sysBusinessVO);
	
	public SysBusinessVO findById(Integer id);
	
	public SysBusinessVO updateClaim(SysBusinessVO sysBusinessVO);
}
