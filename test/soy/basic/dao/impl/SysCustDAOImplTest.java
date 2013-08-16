package soy.basic.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import soy.basic.dao.SysCustDAO;
import soy.basic.vo.SysUserVO;
import soy.util.PaginatedList;

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
		SysCustDAO sysCustDAO = (SysCustDAO) factory.getBean("sysCustDAO");
		PaginatedList list = new PaginatedList(1);
		SysUserVO sysUserVO = new SysUserVO();
		sysUserVO.setId("1");
		list = sysCustDAO.findPublic(list, null);
		System.out.println("统计:" + list.getFullListSize());
		System.out.println("集合:" + list.getList());
	}

}
