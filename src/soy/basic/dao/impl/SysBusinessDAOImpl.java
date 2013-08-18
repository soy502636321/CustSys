package soy.basic.dao.impl;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import soy.basic.dao.SysBusinessDAO;
import soy.basic.database.entity.SysBusiness;
import soy.basic.vo.SysBusinessVO;
import soy.basic.vo.SysCustVO;
import soy.util.DateUtil;
import soy.util.PaginatedList;
import soy.util.StringUtil;

/**
 * 
 * @author 小胡
 *
 */
public class SysBusinessDAOImpl extends HibernateDaoSupport implements SysBusinessDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SysBusinessDAOImpl.class);


	public void save(Object transientInstance) {
		log.debug("saving SysBusiness instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Object persistentInstance) {
		log.debug("deleting SysBusiness instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void update(Object object) {
		log.debug("");
		try {
			getHibernateTemplate().update(object);
		} catch(DataAccessException e) {
			log.error("", e);
			throw e;
		}
	}

	public SysBusiness findById(Object id) {
		log.debug("getting SysBusiness instance with id: " + id);
		try {
			SysBusiness instance = (SysBusiness) getHibernateTemplate().get(
					"soy.basic.database.entity.SysBusiness", (Integer)id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Object instance) {
		log.debug("finding SysBusiness instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding SysBusiness instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SysBusiness as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBusinessNo(Object businessNo) {
		return findByProperty(BUSINESS_NO, businessNo);
	}

	public List findByContractNo(Object contractNo) {
		return findByProperty(CONTRACT_NO, contractNo);
	}

	public List findByTheme(Object theme) {
		return findByProperty(THEME, theme);
	}

	public List findByQuantity(Object quantity) {
		return findByProperty(QUANTITY, quantity);
	}

	public List findByUnitprice(Object unitprice) {
		return findByProperty(UNITPRICE, unitprice);
	}

	public List findByEstimatedAmount(Object estimatedAmount) {
		return findByProperty(ESTIMATED_AMOUNT, estimatedAmount);
	}

	public List findByActualAmount(Object actualAmount) {
		return findByProperty(ACTUAL_AMOUNT, actualAmount);
	}

	public List findByInvoice(Object invoice) {
		return findByProperty(INVOICE, invoice);
	}

	public List findByComplaints(Object complaints) {
		return findByProperty(COMPLAINTS, complaints);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all SysBusiness instances");
		try {
			String queryString = "from SysBusiness";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public PaginatedList find(final PaginatedList list, final SysBusinessVO vo,
			final SysCustVO vo2) {
		PaginatedList result = getHibernateTemplate().execute(new HibernateCallback<PaginatedList>() {

			@Override
			public PaginatedList doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from SysBusiness t where";
				if (vo2 == null || StringUtil.isNull(vo2.getId()) || !StringUtil.isInteger(vo2.getId())) {
					hql += " t.id != -1";
				} else {
					hql += " t.sysCust.id = " + vo2.getId();
				}
				
				if (vo != null) {
					//客户编号
					if (vo2 == null && !StringUtil.isNull(vo.getSysCustId())) {
						if (StringUtil.isInteger(vo.getSysCustId())) {
							hql += " and t.sysCust.id = " + vo.getSysCustId();
						} else {
							hql += " and t.sysCust.id = -20";
						}
					}
					if (!StringUtil.isNull(vo.getPrivateUserUsername())) {
						hql += " and t.sysCust.privateUser.username like '%" + vo.getPrivateUserUsername() + "%'";
					}
					
					//订单编号
					if (!StringUtil.isNull(vo.getBusinessNo())) {
						hql += " and t.businessNo like '%" + vo.getBusinessNo() + "%'";
					}
					//合同编号
					if (!StringUtil.isNull(vo.getContractNo())) {
						hql += " and t.contractNo like '%" + vo.getContractNo() + "%'";
					}
					//订单主题
					if (!StringUtil.isNull(vo.getTheme())) {
						hql += " and t.theme like '%" + vo.getTheme() + "%'";
					}
					//开始订单时间
					if (vo.getBusinessTimeStart() != null) {
						hql += " and t.businessTime >= '" + DateUtil.getTime(vo.getBusinessTimeStart()) + "'"; 
					}
					//结束订单时间
					if (vo.getBusinessTimeEnd() != null) {
						hql += " and t.businessTime <= '" + DateUtil.getTime(vo.getBusinessTimeEnd()) + "'";
					}
					//开始交付时间
					if (vo.getDeliveryTimeStart() != null) {
						hql += " and t.deliveryTime >= '" + DateUtil.getTime(vo.getDeliveryTimeStart()) + "'";
					}
					//结束交付时间
					if (vo.getDeliveryTimeEnd() != null) {
						hql += " and t.deliveryTime <= '" + DateUtil.getTime(vo.getDeliveryTimeEnd()) + "'";
					}
					//数量
					if (!StringUtil.isNull(vo.getQuantityString())) {
						if (StringUtil.isDouble(vo.getQuantityString())) {
							hql += " and t.quantity = " + vo.getQuantityString();
						} else {
							hql += " and t.quantity = -52236";
						}
					}
					//单价
					if (!StringUtil.isNull(vo.getUnitpriceString())) {
						if (StringUtil.isDouble(vo.getUnitpriceString())) {
							hql += " and t.unitprice = " + vo.getUnitpriceString();
						} else {
							hql += " and t.unitprice = -856485";
						}
					}
					//客户投诉
					if (!StringUtil.isNull(vo.getComplaintsId())) {
						hql += " and t.complaints = '" + vo.getComplaintsId() + "'";
					}
					//预估金额
					if (!StringUtil.isNull(vo.getEstimatedAmountString())) {
						if (StringUtil.isDouble(vo.getEstimatedAmountString())) {
							hql += " and t.estimatedAmount = " + vo.getEstimatedAmountString();
						} else {
							hql += " and t.estimatedAmount = -9632584.1";
						}
					}
					
					//实际金额
					if (!StringUtil.isNull(vo.getActualAmountString())) {
						if (StringUtil.isDouble(vo.getActualAmountString())) {
							hql += " and t.actualAmount = " + vo.getActualAmountString();
						} else {
							hql += " and t.actualAmount = -9655120.1";
						}
					}
					//付款方式
					if (!StringUtil.isNull(vo.getBasePaymentId()) && StringUtil.isInteger(vo.getBasePaymentId())) {
						hql += " and t.basePayment.id = " + vo.getBasePaymentId();
					}
					//交付方式
					if (!StringUtil.isNull(vo.getBaseDeliveryId()) && StringUtil.isInteger(vo.getBaseDeliveryId())) {
						hql += " and t.baseDelivery.id = " + vo.getBaseDeliveryId();
					}
					//开票
					if (!StringUtil.isNull(vo.getInvoiceId())) {
						hql += " and t.invoice = " + vo.getInvoiceId();
					}
					//备注
					if (!StringUtil.isNull(vo.getRemark())) {
						hql += " and t.remark like '%" + vo.getRemark() + "%'";
					}
				}
				
				Query query = session.createQuery(hql);
				query.setFirstResult(list.getStartNumber()).setMaxResults(list.getObjectsPerPage());
				list.setList(query.list());
				
				query = session.createQuery("select count(*) " + hql);
				int count = ((Number)query.list().iterator().next()).intValue();
				list.setFullListSize(count);
				
				query = null;
				return list;
			}
			
		});
		return result;
	}

	@Override
	public String createBusinessNo() {
		String today = DateUtil.getDate(new Date());
		System.out.println(today);
		List list = getHibernateTemplate().find("select count(*) from SysBusiness t where t.operateTime = '" + today + "'");
		int count = ((Number)list.iterator().next()).intValue();
		System.out.println("记录总数:" + count);
		today = today.replaceAll("-", "");
		String no = today + (new DecimalFormat("0000").format(count + 1L)); 
		return no;
	}

}