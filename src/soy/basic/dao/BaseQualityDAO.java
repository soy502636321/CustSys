package soy.basic.dao;

import java.util.List;

import soy.basic.vo.BaseQualityVO;
import soy.util.PaginatedList;

/**
 * 
 * @author 小胡
 *
 */
public interface BaseQualityDAO extends BaseDAO {
	// property constants
	public static final String QUALITY_NAME = "qualityName";
	public static final String REMARK = "remark";

	public PaginatedList find(PaginatedList list, BaseQualityVO vo);
	
	public List findByQualityName(Object qualityName) ;

	public List findByRemark(Object remark);
	
	public List findByIds(Integer[] ids);
}
