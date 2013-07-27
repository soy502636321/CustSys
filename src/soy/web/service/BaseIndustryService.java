package soy.web.service;

import java.util.List;

import soy.basic.vo.BaseIndustryVO;
import soy.util.PaginatedList;

public interface BaseIndustryService {
	public PaginatedList find(PaginatedList list, BaseIndustryVO baseIndustryVO);
	
	public BaseIndustryVO save(BaseIndustryVO baseIndustryVO);
	
	public BaseIndustryVO findById(Integer id);
	
	public BaseIndustryVO update(BaseIndustryVO baseIndustryVO);
	
	public int delete(Integer[] ids);
	
	public List findAll();
}
