package soy.web.service;

import java.util.List;

import soy.basic.vo.BaseTypeVO;
import soy.util.PaginatedList;

public interface BaseTypeService {
	public PaginatedList find(PaginatedList list, BaseTypeVO baseTypeVO);
	
	public BaseTypeVO findById(Integer id);
	
	public BaseTypeVO save(BaseTypeVO baseTypeVO);
	
	public BaseTypeVO update(BaseTypeVO baseTypeVO);
	
	public int delete(Integer[] ids);
	
	public List findAll();
}
