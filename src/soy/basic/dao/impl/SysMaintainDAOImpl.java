package soy.basic.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

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

import soy.basic.dao.SysMaintainDAO;
import soy.basic.database.entity.SysMaintain;
import soy.basic.vo.SysCustVO;
import soy.basic.vo.SysMaintainVO;
import soy.util.DateUtil;
import soy.util.PaginatedList;
import soy.util.StringUtil;

/**
 * 
 * @author 小胡
 *
 */

public class SysMaintainDAOImpl extends HibernateDaoSupport implements SysMaintainDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SysMaintainDAOImpl.class);


	public void save(Object transientInstance) {
		log.debug("saving SysMaintain instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Object persistentInstance) {
		log.debug("deleting SysMaintain instance");
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

	public SysMaintain findById(Object id) {
		log.debug("getting SysMaintain instance with id: " + id);
		try {
			SysMaintain instance = (SysMaintain) getHibernateTemplate().get(
					"soy.basic.database.entity.SysMaintain", (Integer)id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Object instance) {
		log.debug("finding SysMaintain instance by example");
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
		log.debug("finding SysMaintain instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SysMaintain as model where model."
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

	public List findByActiveDesc(Object activeDesc) {
		return findByProperty(ACTIVE_DESC, activeDesc);
	}

	public List findByResult(Object result) {
		return findByProperty(RESULT, result);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all SysMaintain instances");
		try {
			String queryString = "from SysMaintain";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public PaginatedList find(final PaginatedList list, final SysMaintainVO vo, final SysCustVO vo2) {
		PaginatedList result = getHibernateTemplate().execute(new HibernateCallback<PaginatedList>() {

			@Override
			public PaginatedList doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from SysMaintain t where";
				if (vo2 == null || StringUtil.isNull(vo2.getId()) || !StringUtil.isInteger(vo2.getId())) {
					hql += " t.id != -1";
				} else {
					hql += " t.sysCust.id = " + vo2.getId();
				}
				if (vo != null) {
					//维护编号
					if (!StringUtil.isNull(vo.getId())) {
						if (StringUtil.isInteger(vo.getId())) {
							hql += " and t.id = " + vo.getId();
						} else {
							hql += " and t.id = 0";
						}
					}
					//客户ID
					if (!StringUtil.isNull(vo.getSysCustId())) {
						if (StringUtil.isInteger(vo.getSysCustId())) {
							hql += " and t.sysCust.id = " + vo.getSysCustId();
						} else {
							hql += " and t.sysCust.id = 0";
						}
					}
					//开始维护时间
					if (vo.getMaintainTimeStart() != null) {
						hql += " and t.maintainTime >= '" + DateUtil.getTime(vo.getMaintainTimeStart()) + "'";
					}
					//结束维护时间
					if (vo.getMaintainTimeEnd() != null) {
						hql += " and t.maintainTime <= '" + DateUtil.getTime(vo.getMaintainTimeEnd()) + "'";
					}
					if (!StringUtil.isNull(vo.getName())) {
						hql += " and t.name like '%" + vo.getName() + "%'";
					}
					if (!StringUtil.isNull(vo.getBaseMaintaintypeId()) && StringUtil.isInteger(vo.getBaseMaintaintypeId()) && !"0".equals(vo.getBaseMaintaintypeId())) {
						hql += " and t.baseMaintaintype.id = " + vo.getBaseMaintaintypeId();
					}
					if (!StringUtil.isNull(vo.getActiveDesc())) {
						hql += " and t.activeDesc like '%" + vo.getActiveDesc() + "%'";
					}
					if (!StringUtil.isNull(vo.getResult())) {
						hql += " and t.result like '%" + vo.getResult() + "%'";
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
}