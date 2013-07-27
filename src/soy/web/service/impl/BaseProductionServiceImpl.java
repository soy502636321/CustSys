package soy.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.BaseProductionDAO;
import soy.web.service.BaseProductionService;

/**
 * @author XiaoLiang·Hu
 * 
 */
public class BaseProductionServiceImpl implements BaseProductionService {
	private static final Logger log = LoggerFactory
			.getLogger(BaseProductionServiceImpl.class);

	private BaseProductionDAO baseProductionDAO;

	public BaseProductionDAO getBaseProductionDAO() {
		return baseProductionDAO;
	}

	public void setBaseProductionDAO(BaseProductionDAO baseProductionDAO) {
		this.baseProductionDAO = baseProductionDAO;
	}

}
