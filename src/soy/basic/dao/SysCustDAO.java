package soy.basic.dao;

import java.util.List;

import soy.basic.vo.SysCustVO;
import soy.util.PaginatedList;

/**
 * 
 * @author 小胡
 * 
 */
public interface SysCustDAO extends BaseDAO {
	// property constants
	public static final String NAME = "name";
	public static final String ADDRESS = "address";
	public static final String POSTAL_CODE = "postalCode";
	public static final String WEBSITE = "website";
	public static final String REMARK = "remark";
	
	public PaginatedList find(PaginatedList list, SysCustVO vo);

	public List findByName(Object name);

	public List findByAddress(Object address);

	public List findByPostalCode(Object postalCode);

	public List findByWebsite(Object website);

	public List findByRemark(Object remark);
}
