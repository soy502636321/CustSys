package soy.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.vo.SysBusinessVO;
import soy.basic.vo.SysCustVO;
import soy.basic.vo.SysMaintainVO;
import soy.util.ForwardUtil;
import soy.util.PaginatedList;
import soy.util.SystemUtil;
import soy.web.service.SysBusinessService;

public class SysBusinessForCustAction extends BaseAction {
	// 日志
	private static final Logger log = LoggerFactory
			.getLogger(SysBusinessForCustAction.class);

	// 服务
	private SysBusinessService sysBusinessService;

	// VO
	private SysBusinessVO sysBusinessVO;
	private SysCustVO sysCustVO;

	// 属性
	private PaginatedList list;
	private Integer page;
	private boolean edit = false;
	private Integer[] cbId;

	// 功能方法
	
	public String query() {
		log.debug("跳转到客户业务记录的主界面");
		PaginatedList list = getSysBusinessService().find(
				new PaginatedList(getPage()), getSysBusinessVO(),
				getSysCustVO());
		setList(list);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}
	
	public String add() {
		log.debug("跳转到客户增加订单的主界面");
		setEdit(false);
		SysBusinessVO sysBusinessVO = new SysBusinessVO();
		sysBusinessVO.setSysCustId(getSysCustVO().getId());
		setSysBusinessVO(sysBusinessVO);
		return ForwardUtil.FORWARD_ADD_PAGE;
	}
	
	public String save() {
		log.debug("ACTION:开始增加客户订单记录");
		if (getSysBusinessVO() == null) {
			addActionError("增加客户订单失败!");
		} else {
			SysBusinessVO sysBusinessVO = getSysBusinessService().save(getSysBusinessVO());
			if (sysBusinessVO == null) {
				addActionError("增加客户订单失败!");
			} else {
				addActionMessage("成功客户订单!");
				addActionMessage("订单编号:(" + sysBusinessVO.getBusinessNo() + ")");
				setSysBusinessVO(sysBusinessVO);
				setEdit(true);
				log.debug("ACTION:成功增加客户订单，并跳转到修改该订单的修改界面");
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
	
	public String back() {
		log.debug("返回客户业务记录的主界面");
		SysBusinessVO sysBusinessVO = new SysBusinessVO();
		setSysBusinessVO(sysBusinessVO);
		return query();
	}

	// 访问、设置属性

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

	public SysCustVO getSysCustVO() {
		return sysCustVO;
	}

	public void setSysCustVO(SysCustVO sysCustVO) {
		this.sysCustVO = sysCustVO;
	}

	public PaginatedList getList() {
		return list;
	}

	public void setList(PaginatedList list) {
		this.list = list;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public Integer[] getCbId() {
		return cbId;
	}

	public void setCbId(Integer[] cbId) {
		this.cbId = cbId;
	}

	
}
