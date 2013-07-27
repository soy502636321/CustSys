package soy.basic.dao;

import java.util.List;

public interface BaseDAO {
	
	public void save(Object object);
	
	public void delete(Object object);
	
	public void update(Object object);
	
	public Object findById(Object id);
	
	public List findByExample(Object instance);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findAll();
}
