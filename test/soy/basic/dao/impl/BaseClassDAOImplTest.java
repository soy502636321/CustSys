package soy.basic.dao.impl;

import static org.junit.Assert.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import soy.basic.dao.BaseClassDAO;
import soy.basic.dao.BaseDAO;
import soy.util.PaginatedList;

public class BaseClassDAOImplTest {
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
	public void testFindByClassName() {
		
	}

	@Test
	public void testFindByRemark() {
		
	}

	@Test
	public void testFindAll() {
		
	}

	@Test
	public void testFind() {
//		BaseClassDAO baseClassDAO = (BaseClassDAO) factory.getBean("baseClassDAO");
//		PaginatedList list = baseClassDAO.find(new PaginatedList(), null);
//		System.out.println(list.getList().size());
	}
	
	@Test
	public void testFindByIds() {
		BaseClassDAO baseClassDAO = (BaseClassDAO) factory.getBean("baseClassDAO");
		Integer[] ids = new Integer[]{2, 3};
		List list = baseClassDAO.findByIds(ids);
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		System.out.println(new DecimalFormat("0000").format(34L));
	}
}
