package soy.basic.dao;

import java.util.List;

import soy.basic.vo.SysUserVO;
import soy.util.PaginatedList;

/**
 * 
 * @author 小胡
 * 
 */
public interface SysUserDAO extends BaseDAO {
	// property constants
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String NAME = "name";
	public static final String GENDER = "gender";
	public static final String PHONE_TH1 = "phoneTh1";
	public static final String PHONE_TH2 = "phoneTh2";
	public static final String EMAIL_TH1 = "emailTh1";
	public static final String EMAIL_TH2 = "emailTh2";
	public static final String USER_STATE = "userState";
	public static final String REMARK = "remark";
	
	public PaginatedList find(PaginatedList list, SysUserVO vo);

	public List findByUsername(Object username);

	public List findByPassword(Object password);

	public List findByName(Object name);

	public List findByGender(Object gender);

	public List findByPhoneTh1(Object phoneTh1);

	public List findByPhoneTh2(Object phoneTh2);

	public List findByEmailTh1(Object emailTh1);

	public List findByEmailTh2(Object emailTh2);

	public List findByUserState(Object userState);

	public List findByRemark(Object remark);

}
