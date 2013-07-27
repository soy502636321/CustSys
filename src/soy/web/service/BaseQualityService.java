package soy.web.service;

import java.util.List;

import soy.basic.vo.BaseQualityVO;
import soy.util.PaginatedList;

public interface BaseQualityService {
	public PaginatedList find(PaginatedList list, BaseQualityVO baseQualityVO);
	
	public BaseQualityVO findById(Integer id);
	
	public BaseQualityVO save(BaseQualityVO baseQualityVO);
	
	public BaseQualityVO update(BaseQualityVO baseQualityVO);
	
	public int delete(Integer[] ids);
	
	public List findAll();
}
