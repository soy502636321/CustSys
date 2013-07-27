package soy.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.SysContactDAO;
import soy.basic.dao.SysCustDAO;
import soy.basic.database.entity.SysContact;
import soy.basic.database.entity.SysCust;
import soy.basic.vo.SysContactVO;
import soy.basic.vo.SysCustVO;
import soy.util.PaginatedList;
import soy.util.StringUtil;
import soy.web.service.SysContactService;

public class SysContactServiceImpl implements SysContactService {
	private static final Logger log = LoggerFactory
			.getLogger(SysContactServiceImpl.class);

	private SysContactDAO sysContactDAO;
	private SysCustDAO sysCustDAO;

	@Override
	public PaginatedList find(PaginatedList list, SysContactVO sysContactVO,
			SysCustVO sysCustVO) {
		list = getSysContactDAO().find(list, sysContactVO, sysCustVO);
		List<SysContact> sysContacts = list.getList();
		List<SysContactVO> sysContactVOs = new ArrayList<SysContactVO>();
		for (SysContact sysContact : sysContacts) {
			sysContactVOs.add(new SysContactVO(sysContact));
		}
		list.setList(sysContactVOs);
		sysContacts = null;
		return list;
	}

	@Override
	public SysContactVO findById(Integer id) {
		SysContactVO sysContactVO = null;
		if (id != null && id.intValue() > 0) {
			SysContact sysContact = (SysContact) getSysContactDAO()
					.findById(id);
			if (sysContact != null) {
				sysContactVO = new SysContactVO(sysContact);
			}
		}
		return sysContactVO;
	}

	@Override
	public SysContactVO save(SysContactVO sysContactVO) {
		SysContactVO vo = null;
		if (sysContactVO != null) {
			try {
				SysContact sysContact = new SysContact();
				sysContact.setName(sysContactVO.getName()); // 联系人
				sysContact.setPosition(sysContactVO.getPosition()); // 职务
				sysContact.setMobile(sysContactVO.getMobile()); // 手机号码
				sysContact.setOffice(sysContactVO.getOffice()); // 办公室号码
				sysContact.setFamilty(sysContactVO.getFamilty()); // 家庭号码
				sysContact.setFax(sysContactVO.getFax()); // 传真
				sysContact.setQq(sysContactVO.getQq()); // QQ
				sysContact.setMsn(sysContactVO.getMsn()); // MSN
				sysContact.setAddress(sysContactVO.getAddress()); // 家庭地址
				sysContact.setInterests(sysContactVO.getInterests()); // 兴趣爱好
				sysContact.setRemark(sysContactVO.getRemark()); // 备注

				SysCust sysCust = (SysCust) getSysCustDAO().findById(
						Integer.valueOf(sysContactVO.getSysCustId()));
				if (sysCust == null) {
					return vo;
				}
				sysContact.setSysCust(sysCust); // 联系方式所属客户

				getSysContactDAO().save(sysContact);

				vo = new SysContactVO(sysContact);
			} catch (Exception e) {
				vo = null;
				e.printStackTrace();
			}
		}
		return vo;
	}

	@Override
	public SysContactVO update(SysContactVO sysContactVO) {
		SysContactVO vo = null;
		if (sysContactVO != null && !StringUtil.isNull(sysContactVO.getId())
				&& StringUtil.isInteger(sysContactVO.getId())) {
			SysContact sysContact = (SysContact) getSysContactDAO().findById(
					Integer.valueOf(sysContactVO.getId()));
			if (sysContact != null) {
				try {
					sysContact.setName(sysContactVO.getName()); // 联系人
					sysContact.setPosition(sysContactVO.getPosition()); // 职务
					sysContact.setMobile(sysContactVO.getMobile()); // 手机号码
					sysContact.setOffice(sysContactVO.getOffice()); // 办公室号码
					sysContact.setFamilty(sysContactVO.getFamilty()); // 家庭号码
					sysContact.setFax(sysContactVO.getFax()); // 传真
					sysContact.setWeibo(sysContactVO.getWeibo()); //微薄
					sysContact.setQq(sysContactVO.getQq()); // QQ
					sysContact.setMsn(sysContactVO.getMsn()); // MSN
					sysContact.setAddress(sysContactVO.getAddress()); // 家庭地址
					sysContact.setInterests(sysContactVO.getInterests()); // 兴趣爱好
					sysContact.setRemark(sysContactVO.getRemark()); // 备注
					sysContact.setGender(sysContactVO.getGenderId()); //性别
					
					getSysContactDAO().update(sysContact);

					vo = new SysContactVO(sysContact);
				} catch (Exception e) {
					vo = null;
					e.printStackTrace();
				}
			}
		}
		return vo;
	}

	public SysContactDAO getSysContactDAO() {
		return sysContactDAO;
	}

	public void setSysContactDAO(SysContactDAO sysContactDAO) {
		this.sysContactDAO = sysContactDAO;
	}

	public SysCustDAO getSysCustDAO() {
		return sysCustDAO;
	}

	public void setSysCustDAO(SysCustDAO sysCustDAO) {
		this.sysCustDAO = sysCustDAO;
	}

}
