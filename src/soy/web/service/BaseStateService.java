package soy.web.service;

import java.util.List;

import soy.basic.vo.BaseStateVO;
import soy.util.PaginatedList;

public interface BaseStateService {
	public PaginatedList find(PaginatedList list, BaseStateVO baseStateVO);
	
	public BaseStateVO findById(Integer id);
	
	public BaseStateVO save(BaseStateVO baseStateVO);
	
	public BaseStateVO update(BaseStateVO baseStateVO);
	
	public int delete(Integer[] ids);
	
	public List findAll();
}
