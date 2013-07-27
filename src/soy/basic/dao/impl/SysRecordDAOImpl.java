package soy.basic.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import soy.basic.dao.SysRecordDAO;
import soy.basic.vo.SysBusinessVO;
import soy.basic.vo.SysRecordVO;
import soy.util.PaginatedList;
import soy.util.StringUtil;

/**
 * @author XiaoLiang·Hu
 *
 */
public class SysRecordDAOImpl extends HibernateDaoSupport implements SysRecordDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SysRecordDAOImpl.class);

	@Override
	public PaginatedList find(final PaginatedList list, final SysRecordVO vo, final SysBusinessVO businessVO) {
		PaginatedList result = getHibernateTemplate().execute(new HibernateCallback<PaginatedList>() {

			@Override
			public PaginatedList doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from SysRecord t where 1 = 1";
				if (businessVO != null && StringUtil.isInteger(businessVO.getId())) {
					hql += " and t.sysBusiness.id = " + businessVO.getId();
				} else {
					hql += " and t.sysBusiness.id = -1";
				}
				if (vo != null) {
					
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
	public void save(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object findById(Object id) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}
	
}
