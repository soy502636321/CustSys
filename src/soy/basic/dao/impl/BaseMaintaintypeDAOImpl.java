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

import soy.basic.dao.BaseMaintaintypeDAO;
import soy.basic.database.entity.BaseMaintaintype;
import soy.basic.vo.BaseMaintaintypeVO;
import soy.util.PaginatedList;
import soy.util.StringUtil;

/**
 * 
 * @author 小胡
 *
 */

public class BaseMaintaintypeDAOImpl extends HibernateDaoSupport implements BaseMaintaintypeDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BaseMaintaintypeDAOImpl.class);
	// property constants
	public static final String MAINTAINTYPE_NAME = "maintaintypeName";
	public static final String REMARK = "remark";

	public void save(Object transientInstance) {
		log.debug("saving BaseMaintaintype instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Object persistentInstance) {
		log.debug("deleting BaseMaintaintype instance");
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

	public BaseMaintaintype findById(Object id) {
		log.debug("getting BaseMaintaintype instance with id: " + id);
		try {
			BaseMaintaintype instance = (BaseMaintaintype) getHibernateTemplate().get(
					"soy.basic.database.entity.BaseMaintaintype", (Integer)id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Object instance) {
		log.debug("finding BaseMaintaintype instance by example");
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
		log.debug("finding BaseMaintaintype instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BaseMaintaintype as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMaintaintypeName(Object maintaintypeName) {
		return findByProperty(MAINTAINTYPE_NAME, maintaintypeName);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all BaseMaintaintype instances");
		try {
			String queryString = "from BaseMaintaintype";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public PaginatedList find(final PaginatedList list, final BaseMaintaintypeVO vo) {
		PaginatedList result = getHibernateTemplate().execute(new HibernateCallback<PaginatedList>() {

			@Override
			public PaginatedList doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from BaseMaintaintype t where t.id != -1";
				if (vo != null) {
					if (!StringUtil.isNull(vo.getId())) {
						if (StringUtil.isInteger(vo.getId())) {
							hql += " and t.id = " + vo.getId();
						} else {
							hql += " and t.id = 0";
						}
					}
					if (!StringUtil.isNull(vo.getMaintaintypeName())) {
						hql += " and t.maintaintypeName like '%" + vo.getMaintaintypeName() + "%'";
					}
					if (!StringUtil.isNull(vo.getRemark())) {
						hql += " and t.remark like '%" + vo.getRemark() + "%'";
					}
				}
				
				Query query = session.createQuery(hql);
				query.setFirstResult(list.getStartNumber()).setMaxResults(list.getObjectsPerPage());
				list.setList(query.list());
				
				query = session.createQuery("select count(*) " + hql);
				int count = ((Number) query.list().iterator().next()).intValue();
				list.setFullListSize(count);
				query = null;
				return list;
			}
		});
		return result;
	}
}