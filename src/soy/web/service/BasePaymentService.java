package soy.web.service;

import java.util.List;

import soy.basic.vo.BasePaymentVO;
import soy.util.PaginatedList;

public interface BasePaymentService {
	public PaginatedList find(PaginatedList list, BasePaymentVO basePaymentVO);
	
	public BasePaymentVO save(BasePaymentVO basePaymentVO);
	
	public BasePaymentVO findById(Integer id);
	
	public BasePaymentVO update(BasePaymentVO basePaymentVO);
	
	public int delete(Integer[] ids);
	
	public  List findAll();
}
