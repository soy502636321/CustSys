package soy.web.service;

import java.util.List;

import soy.basic.vo.BaseClassVO;
import soy.util.PaginatedList;

/**
 * 业务种类服务
 * @author 小胡
 *
 */
public interface BaseClassService {
	/**
	 * 根据业务种类来分页查询业务种类
	 * @param list
	 * @param vo
	 * @return
	 */
	public PaginatedList find(PaginatedList list, BaseClassVO vo);
	
	/**
	 * 增加一个指定的业务种类
	 * @param baseClassVO
	 * @return
	 */
	public BaseClassVO save(BaseClassVO baseClassVO);
	
	/**
	 * 根据指定ID来查询业务种类
	 * @param id
	 * @return
	 */
	public BaseClassVO findById(Integer id);
	
	/**
	 * 修改指定的业务种类
	 * @param baseClassVO
	 * @return
	 */
	public BaseClassVO update(BaseClassVO baseClassVO);
	
	/**
	 * 删除指定的业务种类集合
	 * @param ids
	 * @return
	 */
	public int delete(Integer[] ids); 
	
	
	public List findAll();
}
