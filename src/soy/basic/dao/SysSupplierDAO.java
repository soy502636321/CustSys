package soy.basic.dao;

import soy.basic.vo.SysSupplierVO;
import soy.util.PaginatedList;

/**
 * @author XiaoLiang·Hu
 *
 */
public interface SysSupplierDAO extends BaseDAO {

	PaginatedList find(PaginatedList list, SysSupplierVO sysSupplierVO);

}
