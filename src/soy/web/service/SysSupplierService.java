package soy.web.service;

import soy.basic.vo.SysSupplierVO;
import soy.util.PaginatedList;

/**
 * @author XiaoLiang·Hu
 *
 */
public interface SysSupplierService {

	PaginatedList find(PaginatedList paginatedList, SysSupplierVO sysSupplierVO);

	SysSupplierVO save(SysSupplierVO sysSupplierVO);

	int delete(Integer[] cbId);

	SysSupplierVO findById(Integer integer);

	SysSupplierVO update(SysSupplierVO sysSupplierVO);
	
}
