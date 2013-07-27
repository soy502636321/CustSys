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

import soy.basic.dao.SysSupplierDAO;
import soy.basic.database.entity.BaseClass;
import soy.basic.database.entity.SysSupplier;
import soy.basic.vo.SysSupplierVO;
import soy.util.PaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;

/**
 * @author XiaoLiang·Hu
 * 
 */
public class SysSupplierDAOImpl extends HibernateDaoSupport implements
		SysSupplierDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SysSupplierDAOImpl.class);

	@Override
	public void save(Object object) {
		try {
			getHibernateTemplate().save(object);
		} catch (DataAccessException e) {
			log.error("", e);
			throw e;
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
			SysSupplier instance = (SysSupplier) getHibernateTemplate().get(
					"soy.basic.database.entity.SysSupplier", (Integer)id);
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
			String queryString = "from SysSupplier as model where model."
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
			String queryString = "from SysSupplier";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public PaginatedList find(final PaginatedList list, final SysSupplierVO vo) {
		try {
			PaginatedList result = getHibernateTemplate().execute(new HibernateCallback<PaginatedList>() {

				@Override
				public PaginatedList doInHibernate(Session session)
						throws HibernateException, SQLException {
					StringBuffer hql = new StringBuffer("from SysSupplier as model left join fetch model.supplierClasses as cl left join fetch model.supplierQualities as qu where 1 = 1");
					if (vo != null) {
						//
						if (!StringUtil.isNull(vo.getId())) {
							if (StringUtil.isInteger(vo.getId())) {
								hql.append(" and model.id = ").append(vo.getId());
							} else {
								hql.append(" and model.id = 0");
							}
						}
						if (!StringUtil.isNull(vo.getName())) {
							hql.append(" and model.name like '%").append(vo.getName()).append("%'");
						}
						if (!StringUtil.isNull(vo.getGenderId())) {
							hql.append(" and model.gender = '").append(vo.getGenderId()).append("'");
						}
						if (!StringUtil.isNull(vo.getPhoneTh1())) {
							hql.append(" and model.phoneTh1 like '%").append(vo.getPhoneTh1()).append("%'");
						}
						if (!StringUtil.isNull(vo.getQq())) {
							hql.append(" and model.qq like '%").append(vo.getQq()).append("%'");
						}
						if (!StringUtil.isNull(vo.getEmail())) {
							hql.append(" and model.email like '%").append(vo.getEmail()).append("%'");
						}
						if (!StringUtil.isNull(vo.getMainTh1Id())) {
							if (StringUtil.isInteger(vo.getMainTh1Id())) {
								hql.append(" and model.mainTh1.id = ").append(vo.getMainTh1Id());
							} else {
								hql.append(" and model.mainTh1.id = 0");
							}
						}
						if (!StringUtil.isNull(vo.getMainTh2Id())) {
							if (StringUtil.isInteger(vo.getMainTh2Id())) {
								hql.append(" and model.mainTh2.id = ").append(vo.getMainTh2Id());
							} else {
								hql.append(" and model.mainTh2.id = 0");
							}
						}
						if (!StringUtil.isNull(vo.getMainTh3Id())) {
							if (StringUtil.isInteger(vo.getMainTh3Id())) {
								hql.append(" and model.mainTh3.id = ").append(vo.getMainTh3Id());
							} else {
								hql.append(" and model.mainTh3.id = 0");
							}
						}
						if (!StringUtil.isNull(vo.getPriceString())) {
							if (StringUtil.isDouble(vo.getPriceString())) {
								hql.append(" and model.price = ").append(vo.getPriceString());
							} else {
								hql.append(" and model.price = -20");
							}
						}
						if (!StringUtil.isNull(vo.getOther())) {
							hql.append(" and model.other like '%").append(vo.getOther()).append("%'");
						}
						if (!StringUtil.isNull(vo.getRemark())) {
							hql.append(" and model.remark like '%").append(vo.getRemark()).append("%'");
						}
						if (!SystemUtil.isNull(vo.getSupplierClassId())) {
							hql.append(" and (");
							for (int i = 0; i < vo.getSupplierClassId().length; i++) {
								Integer id = vo.getSupplierClassId()[i];
								hql.append("cl.id = ").append(id.intValue());
								if ((i + 1) != vo.getSupplierClassId().length) {
									hql.append(" or ");
								}
							}
							hql.append(")");
						}
						if (!SystemUtil.isNull(vo.getSupplierQualityId())) {
							hql.append(" and (");
							for (int i = 0; i < vo.getSupplierQualityId().length; i++) {
								Integer id = vo.getSupplierQualityId()[i];
								hql.append("qu.id = ").append(id.intValue());
								if ((i + 1) != vo.getSupplierQualityId().length) {
									hql.append(" or ");
								}
							}
							hql.append(")");
						}
					}
					
					System.out.println(hql.toString());
					
					Query query = session.createQuery(hql.toString());
					query.setFirstResult(list.getStartNumber());
					query.setMaxResults(list.getObjectsPerPage());
					list.setList(query.list());
					
					query = session.createQuery("select count(*) " + hql.toString().replaceAll(" fetch", ""));
					int count = ((Number)query.list().iterator().next()).intValue();
					list.setFullListSize(count);
					query = null;
					hql = null;
					return list;
				}
			});
			return result;
		} catch (DataAccessException e) {
			log.error("", e);
			throw e;
		}
	}
}
