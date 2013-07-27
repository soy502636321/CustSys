package soy.basic.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import soy.basic.dao.BaseQualityDAO;
import soy.basic.database.entity.BaseQuality;
import soy.basic.vo.BaseQualityVO;
import soy.util.PaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;

/**
 * 
 * @author 小胡
 *
 */

public class BaseQualityDAOImpl extends HibernateDaoSupport implements BaseQualityDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BaseQualityDAOImpl.class);


	public void save(Object transientInstance) {
		log.debug("saving BaseQuality instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Object persistentInstance) {
		log.debug("deleting BaseQuality instance");
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
		} catch (DataAccessException e) {
			log.error("", e);
			throw e;
		}
	}

	public BaseQuality findById(Object id) {
		log.debug("getting BaseQuality instance with id: " + id);
		try {
			BaseQuality instance = (BaseQuality) getHibernateTemplate().get(
					"soy.basic.database.entity.BaseQuality", (Integer)id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Object instance) {
		log.debug("finding BaseQuality instance by example");
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
		log.debug("finding BaseQuality instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from BaseQuality as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByQualityName(Object qualityName) {
		return findByProperty(QUALITY_NAME, qualityName);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all BaseQuality instances");
		try {
			String queryString = "from BaseQuality";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public PaginatedList find(final PaginatedList list, final BaseQualityVO vo) {
		PaginatedList result = getHibernateTemplate().execute(new HibernateCallback<PaginatedList>() {

			@Override
			public PaginatedList doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from BaseQuality t where t.id != -1";
				if (vo != null) {
					if (!StringUtil.isNull(vo.getId())) {
						if (StringUtil.isInteger(vo.getId())) {
							hql += " and t.id = " + vo.getId();
						} else {
							hql += " and t.id = 0";
						}
					}
					if (!StringUtil.isNull(vo.getQualityName())) {
						hql += " and t.qualityName like '%" + vo.getQualityName() + "%'";
					}
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
	public List findByIds(Integer[] ids) {
		List list = new ArrayList();
		if (!SystemUtil.isNull(ids)) {
			DetachedCriteria criteria = DetachedCriteria
					.forClass(BaseQuality.class);
			criteria.add(Restrictions.in("id", ids));
			list = getHibernateTemplate().findByCriteria(criteria);
		}
		return list;
	}

}