package soy.basic.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import soy.basic.dao.BaseProductionDAO;
import soy.basic.database.entity.BaseClass;
import soy.basic.database.entity.BaseProduction;
import soy.basic.vo.BaseProductionVO;
import soy.util.PaginatedList;
import soy.util.StringUtil;

/**
 * @author XiaoLiang·Hu
 *
 */
public class BaseProductionDAOImpl extends HibernateDaoSupport implements BaseProductionDAO {
	private static final Logger log = LoggerFactory
	.getLogger(BaseClassDAOImpl.class);
	
	@Override
	public void save(Object object) {
		log.debug("saving BaseClass instance");
		try {
			getHibernateTemplate().save(object);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(Object object) {
		log.debug("deleting BaseClass instance");
		try {
			getHibernateTemplate().delete(object);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public void update(Object object) {
		log.debug("");
		try {
			getHibernateTemplate().update(object);
		} catch (DataAccessException e) {
			log.error("delete failed", e);
			throw e;
		}
	}

	@Override
	public Object findById(Object id) {
		log.debug("getting BaseClass instance with id: " + id);
		try {
			BaseProduction instance = (BaseProduction) getHibernateTemplate().get(
					"soy.basic.database.entity.BaseProduction", (Integer)id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List findByExample(Object instance) {
		log.debug("finding BaseClass instance by example");
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

	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding BaseClass instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from BaseProduction as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@Override
	public List findAll() {
		log.debug("finding all BaseClass instances");
		try {
			String queryString = "from BaseProduction";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public PaginatedList find(final PaginatedList list, final BaseProductionVO vo) {
		PaginatedList result = getHibernateTemplate().execute(new HibernateCallback<PaginatedList>() {

			@Override
			public PaginatedList doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from BaseProduction t where 1 = 1";
				if (vo != null) {
					if (!StringUtil.isNull(vo.getId())) {
						if (StringUtil.isInteger(vo.getId())) {
							hql += " and t.id = " + vo.getId();
						} else {
							hql += " and t.id = 0";
						}
					}
					if (!StringUtil.isNull(vo.getName())) {
						hql += " and t.name like '%" + vo.getName() + "%'";
					}
					if (!StringUtil.isNull(vo.getRemark())) {
						hql += " and t.remark like '%" + vo.getRemark() + "%'";
					}
				}
				//获得分页集合
				Query query = session.createQuery(hql);
				query.setFirstResult(list.getStartNumber()).setMaxResults(list.getObjectsPerPage());
				list.setList(query.list());
				//获得记录总数
				query = session.createQuery("select count(*) " + hql);
				int count = ((Number)query.list().iterator().next()).intValue();
				list.setFullListSize(count);
				query = null;
				return list;
			}
		});
		return result;
	}
}
