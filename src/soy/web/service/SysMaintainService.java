package soy.web.service;

import soy.basic.vo.SysCustVO;
import soy.basic.vo.SysMaintainVO;
import soy.util.PaginatedList;

public interface SysMaintainService {
	public PaginatedList find(PaginatedList list, SysMaintainVO sysMaintainVO, SysCustVO sysCustVO);

	public SysMaintainVO save(SysMaintainVO sysMaintainVO);

	public SysMaintainVO findById(Integer id);

	public SysMaintainVO update(SysMaintainVO sysMaintainVO);
	
	public int delete(Integer[] ids);
}
