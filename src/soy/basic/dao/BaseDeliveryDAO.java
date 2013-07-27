package soy.basic.dao;

import java.util.List;

import soy.basic.vo.BaseDeliveryVO;
import soy.util.PaginatedList;

/**
 * 
 * @author 小胡
 * 
 */
public interface BaseDeliveryDAO extends BaseDAO {
	// property constants
	public static final String DELIVERY_NAME = "deliveryName";
	public static final String REMARK = "remark";
	
	public PaginatedList find(PaginatedList list, BaseDeliveryVO vo);
	
	public List findByDeliveryName(Object deliveryName) ;

	public List findByRemark(Object remark) ;
}
