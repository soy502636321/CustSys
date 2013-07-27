package soy.basic.dao;

import java.util.List;

import soy.basic.database.entity.BaseType;
import soy.basic.vo.BaseTypeVO;
import soy.util.PaginatedList;

/**
 * 
 * @author 小胡
 * 
 */
public interface BaseTypeDAO extends BaseDAO {
	// property constants
	public static final String TYPE_NAME = "typeName";
	public static final String REMARK = "remark";
	
	public PaginatedList find(PaginatedList list, BaseTypeVO vo);

	public List findByTypeName(Object typeName);

	public List findByRemark(Object remark);
}
