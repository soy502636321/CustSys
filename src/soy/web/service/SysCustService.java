package soy.web.service;

import java.util.List;

import soy.basic.vo.SysCustVO;
import soy.basic.vo.SysUserVO;
import soy.util.PaginatedList;

public interface SysCustService {
	public PaginatedList find(PaginatedList list, SysCustVO sysCustVO);
	
	public SysCustVO save(SysCustVO sysCustVO);
	
	public SysCustVO findById(Integer id);
	
	public SysCustVO update(SysCustVO sysCustVO);
	
	public int delete(Integer[] ids);
	
	public String findAllIdOfString();
	
	public SysCustVO updateFeature(SysCustVO sysCustVO);
	
	public List<SysCustVO> findAll();

	public PaginatedList findPublic(PaginatedList list, SysCustVO sysCustVO);

	public PaginatedList findPrivate(PaginatedList list, SysCustVO sysCustVO, SysUserVO sysUserVO);

	public void toPrivate(Integer[] cbId, SysCustVO sysCustVO);
}
