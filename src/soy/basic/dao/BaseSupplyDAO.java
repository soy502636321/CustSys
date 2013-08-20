package soy.basic.dao;

import java.util.List;

import soy.basic.database.entity.BaseSupply;
import soy.basic.vo.BaseSupplyVO;
import soy.util.PaginatedList;

public interface BaseSupplyDAO extends BaseDAO {

	public PaginatedList find(PaginatedList list, BaseSupplyVO baseSupplyVO);

	public List<BaseSupply> findByIds(Integer[] supplierQualityId);
	
}
