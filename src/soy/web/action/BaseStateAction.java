package soy.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.vo.BaseStateVO;
import soy.util.ForwardUtil;
import soy.util.PaginatedList;
import soy.util.SystemUtil;
import soy.web.service.BaseStateService;

public class BaseStateAction extends BaseAction {
	private static final Logger log = LoggerFactory.getLogger(BaseStateAction.class);
	private BaseStateService baseStateService;
	private boolean edit = false;
	private Integer page;
	private BaseStateVO baseStateVO;
	private PaginatedList list;
	private Integer cbId[];

	public String query() {
		log.debug("开始查询客户状态");
		PaginatedList list = getBaseStateService().find(
				new PaginatedList(getPage()), getBaseStateVO());
		setList(list);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String add() {
		log.debug("开始跳转到增加客户状态的界面");
		setEdit(false);
		BaseStateVO baseStateVO = new BaseStateVO();
		setBaseStateVO(baseStateVO);
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String save() {
		log.debug("开始增加一个客户状态");
		if (getBaseStateVO() == null) {
			addActionError("增加客户状态失败!");
		} else {
			BaseStateVO baseStateVO = getBaseStateService().save(
					getBaseStateVO());
			if (baseStateVO == null) {
				addActionError("增加客户状态失败!");
			} else {
				addActionMessage("成功增加客户状态!");
				setEdit(true);
				setBaseStateVO(baseStateVO);
			}
		}
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String edit() {
		log.debug("开始跳转到修改客户状态的界面");
		setEdit(true);
		if (!SystemUtil.isNull(getCbId())) {
			BaseStateVO baseStateVO = getBaseStateService().findById(getCbId()[0]);
			if (baseStateVO == null) {
				addActionError("未能找到该客户状态!");
			} else {
				setBaseStateVO(baseStateVO);
			}
		} else {
			addActionError("请先选择一个客户状态!");
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String update() {
		log.debug("开始修改一个客户状态");
		setEdit(true);
		if (getBaseStateVO() == null) {
			addActionError("修改客户状态失败!");
		} else {
			BaseStateVO baseStateVO = getBaseStateService().update(getBaseStateVO());
			if (baseStateVO == null) {
				addActionError("修改客户状态失败!");
			} else {
				addActionMessage("成功修改客户状态!");
				setBaseStateVO(baseStateVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}
	
	public String delete() {
		log.debug("开始删除所选择的记录");
		int size = getBaseStateService().delete(getCbId());
		addActionMessage("成功删除" + size + "个客户状态!");
		return query();
	}

	public String back() {
		log.debug("返回客户状态主界面");
		setBaseStateVO(null);
		return query();
	}

	public BaseStateService getBaseStateService() {
		return baseStateService;
	}

	public void setBaseStateService(BaseStateService baseStateService) {
		this.baseStateService = baseStateService;
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

	public BaseStateVO getBaseStateVO() {
		return baseStateVO;
	}

	public void setBaseStateVO(BaseStateVO baseStateVO) {
		this.baseStateVO = baseStateVO;
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
}
