package soy.web.service;

import java.util.List;

import soy.basic.vo.BaseSourceVO;
import soy.util.PaginatedList;

public interface BaseSourceService {
	public PaginatedList find(PaginatedList list, BaseSourceVO baseSourceVO);
	
	public BaseSourceVO save(BaseSourceVO baseSourceVO);
	
	public BaseSourceVO findById(Integer id);
	
	public BaseSourceVO update(BaseSourceVO baseSourceVO);
	
	public int delete(Integer[] ids);
	
	public List findAll();
}
