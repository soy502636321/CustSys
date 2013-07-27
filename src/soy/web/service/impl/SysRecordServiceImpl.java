package soy.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.SysRecordDAO;
import soy.basic.database.entity.SysRecord;
import soy.basic.vo.SysBusinessVO;
import soy.basic.vo.SysRecordVO;
import soy.util.PaginatedList;
import soy.web.service.SysRecordService;

/**
 * @author XiaoLiang·Hu
 *
 */
public class SysRecordServiceImpl implements SysRecordService {
	private static final Logger log = LoggerFactory
			.getLogger(SysRecordServiceImpl.class);
	
	//DAO
	private SysRecordDAO sysRecordDAO;
	
	private static boolean change = false;
	
	@Override
	public PaginatedList find(PaginatedList list,
			SysRecordVO vo, SysBusinessVO businessVO) {
		list = getSysRecordDAO().find(list, vo, businessVO);
		List<SysRecord> sysRecords = list.getList();
		List<SysRecordVO> sysRecordVOs = new ArrayList<SysRecordVO>();
		for (SysRecord sysRecord : sysRecords) {
			sysRecordVOs.add(new SysRecordVO(sysRecord));
		}
		list.setList(sysRecordVOs);
		sysRecords = null;
		return list;
	}
	
	@Override
	public SysRecordVO save(SysRecordVO sysRecordVO) {
		setChange(true);
//		SysCustVO vo = null;
		SysRecordVO vo = null;
		if (sysRecordVO != null) {
			try {
//				SysCust sysCust = new SysCust();
				SysRecord sysRecord = new SysRecord();
				
//				getSysCustDAO().save(sysCust);
				getSysRecordDAO().save(sysRecord);

//				vo = new SysCustVO(sysCust);
				vo = new SysRecordVO(sysRecord);
			} catch (Exception e) {
				vo = null;
				e.printStackTrace();
			}
		}
		return vo;
	}

	public SysRecordDAO getSysRecordDAO() {
		return sysRecordDAO;
	}

	public void setSysRecordDAO(SysRecordDAO sysRecordDAO) {
		this.sysRecordDAO = sysRecordDAO;
	}

	public static boolean isChange() {
		return change;
	}

	public static void setChange(boolean change) {
		SysRecordServiceImpl.change = change;
	}

	@Override
	public SysRecordVO findById(Integer integer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SysRecordVO update(SysRecordVO sysRecordVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Integer[] cbId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
