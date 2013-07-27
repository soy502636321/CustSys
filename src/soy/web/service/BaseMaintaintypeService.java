package soy.web.service;

import java.util.Collection;
import java.util.List;

import soy.basic.vo.BaseMaintaintypeVO;
import soy.util.PaginatedList;

public interface BaseMaintaintypeService {
	public PaginatedList find(PaginatedList list, BaseMaintaintypeVO baseMaintaintypeVO);
	
	public BaseMaintaintypeVO save(BaseMaintaintypeVO baseMaintaintypeVO);
	
	public BaseMaintaintypeVO findById(Integer id);
	
	public BaseMaintaintypeVO update(BaseMaintaintypeVO baseMaintaintypeVO);
	
	public int delete(Integer[] ids);

	public List findAll();
}
