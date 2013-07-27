package soy.basic.dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import soy.basic.dao.SysFunctionDAO;
import soy.basic.database.entity.SysFunction;

/**
 * 
 * @author 小胡
 *
 */

public class SysFunctionDAOImpl extends HibernateDaoSupport implements SysFunctionDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SysFunctionDAOImpl.class);

	public void save(Object transientInstance) {
		log.debug("saving SysFunction instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Object persistentInstance) {
		log.debug("deleting SysFunction instance");
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

	public SysFunction findById(Object id) {
		log.debug("getting SysFunction instance with id: " + id);
		try {
			SysFunction instance = (SysFunction) getHibernateTemplate().get(
					"soy.basic.database.entity.SysFunction", (Integer)id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Object instance) {
		log.debug("finding SysFunction instance by example");
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
		log.debug("finding SysFunction instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SysFunction as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFunctionName(Object functionName) {
		return findByProperty(FUNCTION_NAME, functionName);
	}

	public List findByFunctionUrl(Object functionUrl) {
		return findByProperty(FUNCTION_URL, functionUrl);
	}

	public List findByFunctionType(Object functionType) {
		return findByProperty(FUNCTION_TYPE, functionType);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all SysFunction instances");
		try {
			String queryString = "from SysFunction";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}