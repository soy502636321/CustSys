package soy.basic.dao;

import java.util.List;

import soy.basic.vo.BaseStateVO;
import soy.util.PaginatedList;

/**
 * 
 * @author 小胡
 * 
 */
public interface BaseStateDAO extends BaseDAO {
	// property constants
	public static final String STATE_NAME = "stateName";
	public static final String REMARK = "remark";
	
	public PaginatedList find(PaginatedList list, BaseStateVO vo);

	public List findByStateName(Object stateName);

	public List findByRemark(Object remark);

}
