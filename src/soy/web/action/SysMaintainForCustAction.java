package soy.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.vo.SysCustVO;
import soy.basic.vo.SysMaintainVO;
import soy.util.ForwardUtil;
import soy.util.PaginatedList;
import soy.util.SystemUtil;
import soy.web.service.SysMaintainService;

public class SysMaintainForCustAction extends BaseAction {
	// 日志
	private static final Logger log = LoggerFactory
			.getLogger(SysMaintainForCustAction.class);

	// 服务
	private SysMaintainService sysMaintainService;

	// VO
	private SysMaintainVO sysMaintainVO;
	private SysCustVO sysCustVO;

	// 属性
	private boolean edit = false;
	private PaginatedList list;
	private Integer page;
	private Integer[] cbId;

	// 功能方法

	public String query() {
		log.debug("跳转到客户维护记录的主界面");
		PaginatedList list = getSysMaintainService().find(
				new PaginatedList(getPage()), getSysMaintainVO(), null);
		setList(list);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String add() {
		log.debug("跳转到客户增加维护的主界面");
		setEdit(false);
		SysMaintainVO sysMaintainVO = new SysMaintainVO();
		sysMaintainVO.setSysCustId(getSysCustVO().getId());
		setSysMaintainVO(sysMaintainVO);
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String save() {
		log.debug("ACTION:开始增加客户维护记录");
		if (getSysMaintainVO() == null) {
			addActionError("增加维护记录失败!");
		} else {
			SysMaintainVO sysMaintainVO = getSysMaintainService().save(
					getSysMaintainVO());
			if (sysMaintainVO == null) {
				addActionError("增加维护记录失败!");
			} else {
				addActionMessage("成功增加维护记录!");
				addActionMessage("维护记录编号:(" + sysMaintainVO.getId() + ")");
				setSysMaintainVO(sysMaintainVO);
				setEdit(true);
				log.debug("ACTION:成功增加维护记录，并跳转到修改该记录的修改界面");
			}
		}
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String edit() {
		log.debug("跳转到修改客户维护的主界面");
		setEdit(true);
		if (SystemUtil.isNull(getCbId())) {
			addActionError("请先选择客户维护记录!");
		} else {
			SysMaintainVO sysMaintainVO = getSysMaintainService().findById(
					getCbId()[0]);
			if (sysMaintainVO == null) {
				addActionError("不存在你所选择的客户维护记录!");
			} else {
				setSysMaintainVO(sysMaintainVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String update() {
		log.debug("ACTION:开始修改客户维护记录");
		setEdit(true);
		if (getSysMaintainVO() == null) {
			addActionError("修改客户维护记录失败!");
		} else {
			SysMaintainVO sysMaintainVO = getSysMaintainService().update(
					getSysMaintainVO());
			if (sysMaintainVO == null) {
				addActionError("修改客户维护记录失败!");
			} else {
				addActionMessage("成功修改客户维护记录!");
				setSysMaintainVO(sysMaintainVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String back() {
		log.debug("返回客户的维护记录主界面");
		SysMaintainVO sysMaintainVO = new SysMaintainVO();
		setSysMaintainVO(sysMaintainVO);
		return query();
	}

	// 访问、设置属性

	public SysMaintainService getSysMaintainService() {
		return sysMaintainService;
	}

	public void setSysMaintainService(SysMaintainService sysMaintainService) {
		this.sysMaintainService = sysMaintainService;
	}

	public SysMaintainVO getSysMaintainVO() {
		return sysMaintainVO;
	}

	public void setSysMaintainVO(SysMaintainVO sysMaintainVO) {
		this.sysMaintainVO = sysMaintainVO;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
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

	public SysCustVO getSysCustVO() {
		return sysCustVO;
	}

	public void setSysCustVO(SysCustVO sysCustVO) {
		this.sysCustVO = sysCustVO;
	}

	public Integer[] getCbId() {
		return cbId;
	}

	public void setCbId(Integer[] cbId) {
		this.cbId = cbId;
	}

}
