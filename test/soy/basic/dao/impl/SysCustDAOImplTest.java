package soy.basic.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import soy.basic.dao.SysCustDAO;
import soy.basic.dao.SysUserDAO;
import soy.basic.database.entity.SysCust;
import soy.basic.database.entity.SysUser;
import soy.basic.vo.SysUserVO;
import soy.util.PaginatedList;
import soy.web.service.SysUserService;

public class SysCustDAOImplTest {
	public BeanFactory factory = new ClassPathXmlApplicationContext(
	"applicationContext-*.xml");
	@Test
	public void testSave() {
		
	}

	@Test
	public void testDelete() {
		
	}

	@Test
	public void testUpdate() {
		
	}

	@Test
	public void testFindById() {
		
	}

	@Test
	public void testFindByExample() {
		
	}

	@Test
	public void testFindByProperty() {
		
	}

	@Test
	public void testFindByName() {
		
	}

	@Test
	public void testFindByAddress() {
		
	}

	@Test
	public void testFindByPostalCode() {
		
	}

	@Test
	public void testFindByWebsite() {
		
	}

	@Test
	public void testFindByRemark() {
		
	}

	@Test
	public void testFindAll() {
		
	}

	@Test
	public void testFind() {
		
	}

	@Test
	public void testFindPublic() {
		
	}

	@Test
	public void testFindPrivate() {
		
	}

	@Test
	public void testToPrivate() {
//		SysCustDAO sysCustDAO = (SysCustDAO) factory.getBean("sysCustDAO");
//		SysUserDAO sysUserDAO = (SysUserDAO) factory.getBean("sysUserDAO");
//		SysUser sysUser = (SysUser) sysUserDAO.findById(3);
//		sysUserDAO.delete(sysUser);
		SysUserService sysUserService = (SysUserService) factory.getBean("sysUserService");
		Integer[] ids = new Integer[] {3};
		sysUserService.delete(ids);
	}

}
