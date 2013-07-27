package soy.web.service;

import soy.basic.vo.SysBusinessVO;
import soy.basic.vo.SysRecordVO;
import soy.util.PaginatedList;

/**
 * @author XiaoLiang·Hu
 *
 */
public interface SysRecordService {

	PaginatedList find(PaginatedList paginatedList, SysRecordVO sysRecordVO, SysBusinessVO businessVO);

	SysRecordVO save(SysRecordVO sysRecordVO);

	SysRecordVO findById(Integer integer);

	SysRecordVO update(SysRecordVO sysRecordVO);

	int delete(Integer[] cbId);

}
