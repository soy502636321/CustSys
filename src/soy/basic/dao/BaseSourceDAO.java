package soy.basic.dao;

import java.util.List;

import soy.basic.vo.BaseSourceVO;
import soy.util.PaginatedList;

public interface BaseSourceDAO extends BaseDAO {
	// property constants
	public static final String SOURCE_NAME = "sourceName";
	public static final String REMARK = "remark";
	
	public PaginatedList find(PaginatedList list, BaseSourceVO vo);

	public List findBySourceName(Object sourceName);

	public List findByRemark(Object remark);
}
