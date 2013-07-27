package soy.basic.dao;

import java.util.List;

import soy.basic.vo.BaseClassVO;
import soy.util.PaginatedList;

/**
 * 
 * @author 小胡
 * 
 */
public interface BaseClassDAO extends BaseDAO {
	// property constants
	public static final String CLASS_NAME = "className";
	public static final String REMARK = "remark";
	
	/**
	 * 分页查询
	 * @param list
	 * @param vo
	 * @return
	 */
	public PaginatedList find(PaginatedList list, BaseClassVO vo);

	/**
	 * 根据业务种类名字查询
	 * @param className
	 * @return
	 */
	public List findByClassName(Object className);

	/**
	 * 根据业务种类备注查询
	 * @param remark
	 * @return
	 */
	public List findByRemark(Object remark);
	
	public List findByIds(Integer[] ids);
}
