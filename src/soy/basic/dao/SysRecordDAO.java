package soy.basic.dao;

import soy.basic.database.entity.SysBusiness;
import soy.basic.vo.SysBusinessVO;
import soy.basic.vo.SysRecordVO;
import soy.util.PaginatedList;

/**
 * @author XiaoLiang·Hu
 *
 */
public interface SysRecordDAO extends BaseDAO {

	PaginatedList find(PaginatedList list, SysRecordVO vo, SysBusinessVO businessVO);

}
