package soy.web.service;

import soy.basic.vo.BaseProductionVO;
import soy.util.PaginatedList;

/**
 * @author XiaoLiang·Hu
 *
 */
public interface BaseProductionService {



	BaseProductionVO save(BaseProductionVO productionVO);

	PaginatedList find(PaginatedList list, BaseProductionVO vo);

	BaseProductionVO findById(Integer id);

	BaseProductionVO update(BaseProductionVO baseProductionVO);

	int delete(Integer[] ids);

}
