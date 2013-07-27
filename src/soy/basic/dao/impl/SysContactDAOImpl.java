package soy.basic.dao.impl;

import java.sql.SQLException;
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

import soy.basic.dao.SysContactDAO;
import soy.basic.database.entity.SysContact;
import soy.basic.vo.SysContactVO;
import soy.basic.vo.SysCustVO;
import soy.util.PaginatedList;
import soy.util.StringUtil;

/**
 * 
 * @author 小胡
 *
 */

public class SysContactDAOImpl extends HibernateDaoSupport implements SysContactDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SysContactDAOImpl.class);


	public void save(Object transientInstance) {
		log.debug("saving SysContact instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Object persistentInstance) {
		log.debug("deleting SysContact instance");
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

	public SysContact findById(Object id) {
		log.debug("getting SysContact instance with id: " + id);
		try {
			SysContact instance = (SysContact) getHibernateTemplate().get(
					"soy.basic.database.entity.SysContact", (Integer)id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Object instance) {
		log.debug("finding SysContact instance by example");
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
		log.debug("finding SysContact instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SysContact as model where model."
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

	public List findByPosition(Object position) {
		return findByProperty(POSITION, position);
	}

	public List findByMobile(Object mobile) {
		return findByProperty(MOBILE, mobile);
	}

	public List findByOffice(Object office) {
		return findByProperty(OFFICE, office);
	}

	public List findByFamilty(Object familty) {
		return findByProperty(FAMILTY, familty);
	}

	public List findByQq(Object qq) {
		return findByProperty(QQ, qq);
	}

	public List findByMsn(Object msn) {
		return findByProperty(MSN, msn);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByFax(Object fax) {
		return findByProperty(FAX, fax);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByInterests(Object interests) {
		return findByProperty(INTERESTS, interests);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all SysContact instances");
		try {
			String queryString = "from SysContact";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public PaginatedList find(final PaginatedList list, final SysContactVO vo, final SysCustVO vo2) {
		PaginatedList result = getHibernateTemplate().execute(new HibernateCallback<PaginatedList>() {

			@Override
			public PaginatedList doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from SysContact t where";
				if (vo2 == null || StringUtil.isNull(vo2.getId()) || !StringUtil.isInteger(vo2.getId())) {
					hql += " t.id = -1";
				} else {
					hql += " t.sysCust.id = " + vo2.getId();
				}
				if (vo != null) {
					if (!StringUtil.isNull(vo.getId())) {
						if (StringUtil.isInteger(vo.getId())) {
							hql += " and t.id = " + vo.getId();
						} else {
							hql += " and t.id = -1";
						}
					}
					//联系人
					if (!StringUtil.isNull(vo.getName())) {
						hql += " and t.name like '%" + vo.getName() + "%'";
					}
					//性别
					if (!StringUtil.isNull(vo.getGenderId())) {
						hql += " and t.gender = '" + vo.getGenderId() + "'";
					}
					//手机号码
					if (!StringUtil.isNull(vo.getMobile())) {
						hql += " and t.mobile like '%" + vo.getMobile() + "%'";
					}
					//办公室号码
					if (!StringUtil.isNull(vo.getOffice())) {
						hql += " and t.office like '%" + vo.getOffice() + "%'";
					}
					//家庭号码
					if (!StringUtil.isNull(vo.getFamilty())) {
						hql += " and t.familty like '%" + vo.getFamilty() + "%'";
					}
					//QQ
					if (!StringUtil.isNull(vo.getQq())) {
						hql += " and t.qq like '%" + vo.getQq() + "%'";
					}
					//MSN
					if (!StringUtil.isNull(vo.getMsn())) {
						hql += " and t.msn like '%" + vo.getMsn() + "%'";
					}
					//传真
					if (!StringUtil.isNull(vo.getFax())) {
						hql += " and t.fax like '%" + vo.getFax() + "%'";
					}
					//电子邮箱
					if (!StringUtil.isNull(vo.getEmail())) {
						hql += " and t.email like '%" + vo.getEmail() + "%'";
					}
					//家庭地址
					if (!StringUtil.isNull(vo.getAddress())) {
						hql += " and t.address like '%" + vo.getAddress() + "%'";
					}
					//兴趣爱好
					if (!StringUtil.isNull(vo.getInterests())) {
						hql += " and t.interests like '%" + vo.getInterests() + "%'";
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
}