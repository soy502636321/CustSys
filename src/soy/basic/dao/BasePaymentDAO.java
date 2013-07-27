package soy.basic.dao;

import java.util.List;

import soy.basic.vo.BasePaymentVO;
import soy.util.PaginatedList;

/**
 * 
 * @author 小胡
 * 
 */
public interface BasePaymentDAO extends BaseDAO {
	// property constants
	public static final String PAYMENT_NAME = "paymentName";
	public static final String REMARK = "remark";

	public PaginatedList find(PaginatedList list, BasePaymentVO vo);
	
	public List findByPaymentName(Object paymentName);

	public List findByRemark(Object remark);
}
