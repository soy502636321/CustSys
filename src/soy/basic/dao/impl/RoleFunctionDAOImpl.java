package soy.basic.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import soy.basic.database.entity.RoleFunction;
import soy.basic.database.entity.RoleFunctionId;

/**
 * 
 * @author 小胡
 *
 */

public class RoleFunctionDAOImpl extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(RoleFunctionDAOImpl.class);

	// property constants

	public void save(RoleFunction transientInstance) {
		log.debug("saving RoleFunction instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RoleFunction persistentInstance) {
		log.debug("deleting RoleFunction instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RoleFunction findById(soy.basic.database.entity.RoleFunctionId id) {
		log.debug("getting RoleFunction instance with id: " + id);
		try {
			RoleFunction instance = (RoleFunction) getHibernateTemplate().get(
					"soy.basic.database.entity.RoleFunction", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(RoleFunction instance) {
		log.debug("finding RoleFunction instance by example");
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
		log.debug("finding RoleFunction instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from RoleFunction as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all RoleFunction instances");
		try {
			String queryString = "from RoleFunction";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

}