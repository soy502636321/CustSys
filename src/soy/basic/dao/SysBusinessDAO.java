package soy.basic.dao;

import java.util.List;

import soy.basic.vo.SysBusinessVO;
import soy.basic.vo.SysCustVO;
import soy.util.PaginatedList;

/**
 * 
 * @author 小胡
 * 
 */
public interface SysBusinessDAO extends BaseDAO {
	// property constants
	public static final String BUSINESS_NO = "businessNo";
	public static final String CONTRACT_NO = "contractNo";
	public static final String THEME = "theme";
	public static final String QUANTITY = "quantity";
	public static final String UNITPRICE = "unitprice";
	public static final String ESTIMATED_AMOUNT = "estimatedAmount";
	public static final String ACTUAL_AMOUNT = "actualAmount";
	public static final String INVOICE = "invoice";
	public static final String COMPLAINTS = "complaints";
	public static final String REMARK = "remark";
	
	public PaginatedList find(PaginatedList list, SysBusinessVO vo, SysCustVO vo2);

	public List findByBusinessNo(Object businessNo);

	public List findByContractNo(Object contractNo);

	public List findByTheme(Object theme);

	public List findByQuantity(Object quantity);

	public List findByUnitprice(Object unitprice);

	public List findByEstimatedAmount(Object estimatedAmount);

	public List findByActualAmount(Object actualAmount);

	public List findByInvoice(Object invoice);

	public List findByComplaints(Object complaints);

	public List findByRemark(Object remark);
	
	public String createBusinessNo();
}
