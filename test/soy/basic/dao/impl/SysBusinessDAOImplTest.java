package soy.basic.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import soy.basic.dao.SysBusinessDAO;
import soy.util.DateUtil;

public class SysBusinessDAOImplTest {
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
	public void testFindByBusinessNo() {
		
	}

	@Test
	public void testFindByContractNo() {
		
	}

	@Test
	public void testFindByTheme() {
		
	}

	@Test
	public void testFindByQuantity() {
		
	}

	@Test
	public void testFindByUnitprice() {
		
	}

	@Test
	public void testFindByEstimatedAmount() {
		
	}

	@Test
	public void testFindByActualAmount() {
		
	}

	@Test
	public void testFindByInvoice() {
		
	}

	@Test
	public void testFindByComplaints() {
		
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
	public void testCreateBusinessNo() {
		SysBusinessDAO sysBusinessDAO = (SysBusinessDAO) factory.getBean("sysBusinessDAO");
		System.out.println(sysBusinessDAO.createBusinessNo());
	}

}
