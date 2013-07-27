package soy.web.service;

import java.util.List;

import soy.basic.vo.BaseDeliveryVO;
import soy.util.PaginatedList;

/**
 * 交付方式服务
 * 
 * @author 小胡
 * 
 */
public interface BaseDeliveryService {
	/**
	 * 分页查询交付方式
	 * @param list
	 * @param baseDeliveryVO
	 * @return
	 */
	public PaginatedList find(PaginatedList list, BaseDeliveryVO baseDeliveryVO);
	
	public BaseDeliveryVO save(BaseDeliveryVO baseDeliveryVO);
	
	public BaseDeliveryVO findById(Integer id);
	
	public BaseDeliveryVO update(BaseDeliveryVO baseDeliveryVO);
	
	public int delete(Integer[] ids);
	
	public List findAll();
}
