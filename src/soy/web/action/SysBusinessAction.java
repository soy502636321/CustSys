package soy.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.vo.SysBusinessVO;
import soy.basic.vo.SysCustVO;
import soy.util.ForwardUtil;
import soy.util.PaginatedList;
import soy.util.SystemUtil;
import soy.web.service.SysBusinessService;
import soy.web.service.SysRecordService;

public class SysBusinessAction extends BaseAction {
	private static final Logger log = LoggerFactory
			.getLogger(SysBusinessAction.class);

	// 服务
	private SysBusinessService sysBusinessService;
	private SysRecordService sysRecordService;

	// VO
	private SysBusinessVO sysBusinessVO;

	// 属性
	private boolean edit = false;
	private Integer page;
	private PaginatedList list;
	private Integer[] cbId;

	public String query() {
		log.debug("业务管理的主界面");
		PaginatedList list = getSysBusinessService().find(
				new PaginatedList(getPage()), getSysBusinessVO(), null);
		setList(list);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}
	
	public String search() {
		log.debug("");
		return ForwardUtil.FORWARD_SEARCH_PAGE;
	}

	public String add() {
		log.debug("跳转到增加业务的主界面");
		setEdit(false);
		SysBusinessVO sysBusinessVO = new SysBusinessVO();
		setSysBusinessVO(sysBusinessVO);
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String save() {
		log.debug("ACTION:开始进行增加业务的操作");
		if (getSysBusinessVO() == null) {
			addActionError("增加业务失败!");
		} else {
			SysBusinessVO sysBusinessVO = getSysBusinessService().save(
					getSysBusinessVO());
			if (sysBusinessVO == null) {
				addActionError("增加业务失败!");
			} else {
				addActionMessage("增加业务成功!");
				addActionMessage("新增业务编号(" + sysBusinessVO.getId() + ")");
				setEdit(true);
				setSysBusinessVO(sysBusinessVO);
				log.debug("ACTION:增加业务成功，跳转到修改业务的主界面");
			}
		}
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String edit() {
		log.debug("跳转到修改业务的主界面");
		setEdit(true);
		if (SystemUtil.isNull(getCbId())) {
			addActionError("请先选择业务记录!");
		} else {
			SysBusinessVO sysBusinessVO = getSysBusinessService().findById(getCbId()[0]);
			if (sysBusinessVO == null) {
				addActionError("未能找到你所选择的业务记录!");
			} else {
				setSysBusinessVO(sysBusinessVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String update() {
		log.debug("ACTION:开始进行修改业务记录的操作");
		setEdit(true);
		if (getSysBusinessVO() == null) {
			addActionError("修改业务记录失败!");
		} else {
			SysBusinessVO sysBusinessVO = getSysBusinessService().update(getSysBusinessVO());
			if (sysBusinessVO == null) {
				addActionError("修改业务记录失败!");
			} else {
				addActionMessage("成功修改业务记录!");
				setSysBusinessVO(sysBusinessVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}
	
	public String claim() {
		log.debug("");
		if (SystemUtil.isNull(getCbId())) {
			addActionError("请先选择订单记录!");
		} else {
//			SysCustVO sysCustVO = getSysCustService().findById(getCbId()[0]);
			SysBusinessVO sysBusinessVO = getSysBusinessService().findById(getCbId()[0]);
			if (sysBusinessVO == null) {
				addActionError("未能找到你所选择的订单记录!");
			} else {
				setSysBusinessVO(sysBusinessVO);
			}
		}
		return "claim";
	}
	
	public String updateClaim() {
		log.debug("");
		if (getSysBusinessVO() == null) {
			addActionError("修改订单要求失败!");
		} else {
//			SysCustVO sysCustVO = getSysCustService().updateFeature(getSysCustVO());
			SysBusinessVO sysBusinessVO = getSysBusinessService().updateClaim(getSysBusinessVO());
			if (sysBusinessVO == null) {
				addActionError("修改订单要求失败!");
			} else {
				addActionMessage("成功修改订单要求!");
				setSysBusinessVO(sysBusinessVO);
			}
		}
		return "claim";
	}
	
	public String feature() {
		log.debug("");
		setEdit(true);
		if (SystemUtil.isNull(getCbId())) {
			addActionError("请先选择业务记录!");
		} else {
			SysBusinessVO sysBusinessVO = getSysBusinessService().findById(getCbId()[0]);
			if (sysBusinessVO == null) {
				addActionError("未能找你所选择的业务记录!");
			} else {
				setSysBusinessVO(sysBusinessVO);
			}
		}
		return "feature";
	}
	
	public String record() {
		log.debug("生产记录");
		if (SystemUtil.isNull(getCbId())) {
			addActionError("请先选择订单记录!");
		} else {
			SysBusinessVO sysBusinessVO = getSysBusinessService().findById(getCbId()[0]);
			if (sysBusinessVO == null) {
				addActionError("未能找到你所选择的订单记录!");
			} else {
				setSysBusinessVO(sysBusinessVO);
				PaginatedList list = getSysRecordService().find(new PaginatedList(1), null, sysBusinessVO);
				setList(list);
			}
		}			
		return "records";
	}
	
	public String show() {
		log.debug("ACTION:显示订单记录");
		if (SystemUtil.isNull(getCbId())) {
			addActionError("请先选择业务记录!");
		} else {
			SysBusinessVO sysBusinessVO = getSysBusinessService().findById(getCbId()[0]);
			if (sysBusinessVO == null) {
				addActionError("未能找到你所选择的业务记录!");
			} else {
				setSysBusinessVO(sysBusinessVO);
			}
		}
		return ForwardUtil.FORWARD_SHOW_PAGE;	
	}

	public String back() {
		log.debug("");
		setSysBusinessVO(null);
		return query();
	}

	public SysBusinessService getSysBusinessService() {
		return sysBusinessService;
	}

	public void setSysBusinessService(SysBusinessService sysBusinessService) {
		this.sysBusinessService = sysBusinessService;
	}

	public SysBusinessVO getSysBusinessVO() {
		return sysBusinessVO;
	}

	public void setSysBusinessVO(SysBusinessVO sysBusinessVO) {
		this.sysBusinessVO = sysBusinessVO;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public PaginatedList getList() {
		return list;
	}

	public void setList(PaginatedList list) {
		this.list = list;
	}

	public Integer[] getCbId() {
		return cbId;
	}

	public void setCbId(Integer[] cbId) {
		this.cbId = cbId;
	}

	public SysRecordService getSysRecordService() {
		return sysRecordService;
	}

	public void setSysRecordService(SysRecordService sysRecordService) {
		this.sysRecordService = sysRecordService;
	}

	
}
