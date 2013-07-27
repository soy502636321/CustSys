package soy.basic.dao;

import java.util.List;

import soy.basic.vo.SysContactVO;
import soy.basic.vo.SysCustVO;
import soy.util.PaginatedList;

/**
 * 
 * @author 小胡
 * 
 */
public interface SysContactDAO extends BaseDAO {
	// property constants
	public static final String NAME = "name";
	public static final String POSITION = "position";
	public static final String MOBILE = "mobile";
	public static final String OFFICE = "office";
	public static final String FAMILTY = "familty";
	public static final String QQ = "qq";
	public static final String MSN = "msn";
	public static final String ADDRESS = "address";
	public static final String FAX = "fax";
	public static final String EMAIL = "email";
	public static final String INTERESTS = "interests";
	public static final String REMARK = "remark";
	
	public PaginatedList find(PaginatedList list, SysContactVO vo, SysCustVO vo2);

	public List findByName(Object name);

	public List findByPosition(Object position);

	public List findByMobile(Object mobile);

	public List findByOffice(Object office);

	public List findByFamilty(Object familty);

	public List findByQq(Object qq);

	public List findByMsn(Object msn);

	public List findByAddress(Object address);

	public List findByFax(Object fax);

	public List findByEmail(Object email);

	public List findByInterests(Object interests);

	public List findByRemark(Object remark);
}
