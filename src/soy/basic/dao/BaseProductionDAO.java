package soy.basic.dao;

import soy.basic.vo.BaseProductionVO;
import soy.util.PaginatedList;

/**
 * @author XiaoLiang·Hu
 *
 */
public interface BaseProductionDAO extends BaseDAO {

	PaginatedList find(PaginatedList list, BaseProductionVO vo);
	
}
