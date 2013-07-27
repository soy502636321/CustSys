package soy.basic.dao;

import java.util.List;

/**
 * 
 * @author 小胡
 * 
 */
public interface SysFunctionDAO extends BaseDAO {
	// property constants
	public static final String FUNCTION_NAME = "functionName";
	public static final String FUNCTION_URL = "functionUrl";
	public static final String FUNCTION_TYPE = "functionType";
	public static final String REMARK = "remark";

	public List findByFunctionName(Object functionName);

	public List findByFunctionUrl(Object functionUrl);

	public List findByFunctionType(Object functionType);

	public List findByRemark(Object remark);

}
