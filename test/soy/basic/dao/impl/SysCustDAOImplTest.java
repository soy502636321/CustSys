package soy.basic.dao.impl;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
		SysCustDAO sysCustDAO = (SysCustDAO) factory.getBean("sysCustDAO");
		while (true) {
			List list = sysCustDAO.testFind();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(dateFormat.format(new Date()) + " - " + list.size());
			try {
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
