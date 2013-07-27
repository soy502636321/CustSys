package soy.basic.dao;

import soy.basic.vo.BaseMainVO;
import soy.util.PaginatedList;

/**
 * @author XiaoLiang·Hu
 *
 */
public interface BaseMainDAO extends BaseDAO {

	PaginatedList find(PaginatedList list, BaseMainVO baseMainVO);

}
