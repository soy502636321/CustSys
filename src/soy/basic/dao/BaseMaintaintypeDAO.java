package soy.basic.dao;

import java.util.List;

import soy.basic.vo.BaseMaintaintypeVO;
import soy.util.PaginatedList;

/**
 * 
 * @author 小胡
 * 
 */
public interface BaseMaintaintypeDAO extends BaseDAO {
	// property constants
	public static final String MAINTAINTYPE_NAME = "maintaintypeName";
	public static final String REMARK = "remark";
	
	public PaginatedList find(PaginatedList list, BaseMaintaintypeVO vo);

	public List findByMaintaintypeName(Object maintaintypeName);

	public List findByRemark(Object remark);
}
