package soy.web.service;

import java.util.List;

import soy.basic.database.entity.BaseMain;
import soy.basic.vo.BaseMainVO;
import soy.util.PaginatedList;

/**
 * @author XiaoLiang·Hu
 *
 */
public interface BaseMainService {

	PaginatedList find(PaginatedList paginatedList, BaseMainVO baseMainVO);

	BaseMainVO save(BaseMainVO baseMainVO);

	BaseMainVO findById(Integer integer);

	BaseMainVO update(BaseMainVO baseMainVO);

	int delete(Integer[] cbId);

	List<BaseMain> getBaseMainSelect();

}
