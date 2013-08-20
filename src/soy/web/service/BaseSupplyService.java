package soy.web.service;

import java.util.Collection;
import java.util.List;

import soy.basic.vo.BaseSupplyVO;
import soy.util.PaginatedList;

public interface BaseSupplyService {

	public PaginatedList find(PaginatedList list, BaseSupplyVO baseSupplyVO);

	public BaseSupplyVO save(BaseSupplyVO baseSupplyVO);

	public BaseSupplyVO findById(Integer integer);

	public BaseSupplyVO update(BaseSupplyVO baseSupplyVO);

	public int delete(Integer[] cbId);

	public List findAll();

}
