package soy.basic.dao;

import java.util.List;

import soy.basic.vo.SysCustVO;
import soy.basic.vo.SysMaintainVO;
import soy.util.PaginatedList;

/**
 * 
 * @author 小胡
 * 
 */
public interface SysMaintainDAO extends BaseDAO {
	// property constants
	public static final String NAME = "name";
	public static final String ACTIVE_DESC = "activeDesc";
	public static final String RESULT = "result";
	public static final String REMARK = "remark";
	
	public PaginatedList find(PaginatedList list, SysMaintainVO vo, SysCustVO vo2);

	public List findByName(Object name);

	public List findByActiveDesc(Object activeDesc);

	public List findByResult(Object result);

	public List findByRemark(Object remark);
}
