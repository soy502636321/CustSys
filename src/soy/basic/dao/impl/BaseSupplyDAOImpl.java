package soy.basic.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import soy.basic.dao.BaseSupplyDAO;
import soy.basic.database.entity.BaseClass;
import soy.basic.database.entity.BaseQuality;
import soy.basic.database.entity.BaseSupply;
import soy.basic.vo.BaseSupplyVO;
import soy.util.HibernateUtil;
import soy.util.PaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;

public class BaseSupplyDAOImpl extends HibernateDaoSupport implements BaseSupplyDAO {
	private static final Logger log = LoggerFactory.getLogger(BaseSupplyDAOImpl.class);

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
			BaseSupply instance = (BaseSupply) getHibernateTemplate().get(
					"soy.basic.database.entity.BaseSupply", (Integer)id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List findByExample(Object instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findAll() {
		log.debug("finding all BaseClass instances");
		try {
			String queryString = "from BaseSupply";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	@Override
	public PaginatedList find(final PaginatedList list, final BaseSupplyVO vo) {
		try {
			PaginatedList result = getHibernateTemplate().execute(new HibernateCallback<PaginatedList>() {

				@Override
				public PaginatedList doInHibernate(Session session) {
					StringBuffer hql = new StringBuffer("from BaseSupply as model where 1 = 1");
					
					if (vo != null) {
						if (!StringUtil.isNull(vo.getId())) {
							if (StringUtil.isInteger(vo.getId())) {
								hql.append(" and model.id = ").append(vo.getId());
							} else {
								hql.append(" and 1 = 2");
							}
						}
						if (!StringUtil.isNull(vo.getSupplyName())) {
							hql.append(" and model.supplyName like '%").append(vo.getSupplyName()).append("%'");
						}
						if (!StringUtil.isNull(vo.getRemark())) {
							hql.append(" and model.remark like '%").append(vo.getRemark()).append("%'");
						}
					}
					
					//查询供应质量记录集合
					Query query = session.createQuery("select model " + hql.toString());
					query.setFirstResult(list.getStartNumber()).
						setMaxResults(list.getObjectsPerPage());
					list.setList(HibernateUtil.parseToVos(query.list(), BaseSupplyVO.class));
					
					//统计供应质量
					query = session.createQuery("select count(*) " + hql.toString());
					int count = ((Number) query.list().iterator().next()).intValue();
					list.setFullListSize(count);
					
					query = null;
					hql = null;
					
					return list;
				}
			});
			return result;
		} catch (DataAccessException e) {
			log.error("分页查询供应质量记录失败", e);
			throw e;
		} finally {
			
		}
	}
	
	@Override
	public List<BaseSupply> findByIds(Integer[] ids) {
		List list = new ArrayList();
		if (!SystemUtil.isNull(ids)) {
			DetachedCriteria criteria = DetachedCriteria
					.forClass(BaseSupply.class);
			criteria.add(Restrictions.in("id", ids));
			list = getHibernateTemplate().findByCriteria(criteria);
		}
		return list;
	}
}
