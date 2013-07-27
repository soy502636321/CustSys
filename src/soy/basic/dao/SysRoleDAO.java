package soy.basic.dao;

import java.util.List;

/**
 * 
 * @author 小胡
 * 
 */
public interface SysRoleDAO extends BaseDAO {
	// property constants
	public static final String ROLE_NAME = "roleName";
	public static final String REMARK = "remark";

	public List findByRoleName(Object roleName);

	public List findByRemark(Object remark);
}
