package soy.basic.dao;

import java.util.List;

import soy.basic.vo.BaseIndustryVO;
import soy.util.PaginatedList;

/**
 * 
 * @author 小胡
 * 
 */
public interface BaseIndustryDAO extends BaseDAO {
	// property constants
	public static final String INDUSTRY_NAME = "industryName";
	public static final String REMARK = "remark";
	
	public PaginatedList find(PaginatedList list, BaseIndustryVO vo);

	public List findByIndustryName(Object industryName);

	public List findByRemark(Object remark);
}
