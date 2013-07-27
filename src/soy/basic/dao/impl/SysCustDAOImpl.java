package soy.basic.dao.impl;

import java.sql.SQLException;
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

import soy.basic.dao.SysCustDAO;
import soy.basic.database.entity.SysCust;
import soy.basic.vo.SysCustVO;
import soy.util.PaginatedList;
import soy.util.StringUtil;

/**
 * 
 * @author 小胡
 *
 */

public class SysCustDAOImpl extends HibernateDaoSupport implements SysCustDAO {
	private static final Logger log = LoggerFactory.getLogger(SysCustDAOImpl.class);


	public void save(Object transientInstance) {
		log.debug("saving SysCust instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Object persistentInstance) {
		log.debug("deleting SysCust instance");
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

	public SysCust findById(Object id) {
		log.debug("getting SysCust instance with id: " + id);
		try {
			SysCust instance = (SysCust) getHibernateTemplate().get(
					"soy.basic.database.entity.SysCust", (Integer)id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Object instance) {
		log.debug("finding SysCust instance by example");
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
		log.debug("finding SysCust instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SysCust as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByPostalCode(Object postalCode) {
		return findByProperty(POSTAL_CODE, postalCode);
	}

	public List findByWebsite(Object website) {
		return findByProperty(WEBSITE, website);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all SysCust instances");
		try {
			String queryString = "from SysCust";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public PaginatedList find(final PaginatedList list, final SysCustVO vo) {
		PaginatedList resullt = getHibernateTemplate().execute(new HibernateCallback<PaginatedList>() {

			@Override
			public PaginatedList doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from SysCust t where t.id != -1";
				
				if (vo != null) {
					//客户编号
					if (!StringUtil.isNull(vo.getId())) {
						if (StringUtil.isInteger(vo.getId())) {
							hql += " and t.id = " + vo.getId();
						} else {
							hql += " and t.id = 0";
						}
					}
					//客户名称 
					if (!StringUtil.isNull(vo.getName())) {
						hql += " and t.name like '%" + vo.getName() + "%'";
					}
					//邮编
					if (!StringUtil.isNull(vo.getPostalCode())) {
						hql += " and t.postalCode like '%" + vo.getPostalCode() + "%'";
					}
					//所属行业
					if (!StringUtil.isNull(vo.getBaseIndustryId()) && StringUtil.isInteger(vo.getBaseIndustryId())) {
						hql += " and t.baseIndustry.id = " + vo.getBaseIndustryId();
					}
					//客户类型
					if (!StringUtil.isNull(vo.getBaseTypeId()) && StringUtil.isInteger(vo.getBaseTypeId())) {
						hql += " and t.baseType.id = " + vo.getBaseTypeId();
					}
					//客户来源
					if (!StringUtil.isNull(vo.getBaseSourceId()) && StringUtil.isInteger(vo.getBaseSourceId())) {
						hql += " and t.baseSource.id = " + vo.getBaseSourceId();
					}
					//客户状态
					if (!StringUtil.isNull(vo.getBaseStateId()) && StringUtil.isInteger(vo.getBaseStateId())) {
						hql += " and t.baseState.id = " + vo.getBaseStateId();
					}
					//公司主页
					if (!StringUtil.isNull(vo.getWebsite())) {
						hql += " and t.website like '%" + vo.getWebsite() + "%'";
					}
					//详细地址
					if (!StringUtil.isNull(vo.getAddress())) {
						hql += " and t.address like '%" + vo.getAddress() + "%'";
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
		return resullt; 
	}
}