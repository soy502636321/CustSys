package soy.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.vo.BaseTypeVO;
import soy.util.ForwardUtil;
import soy.util.PaginatedList;
import soy.util.SystemUtil;
import soy.web.service.BaseTypeService;

public class BaseTypeAction extends BaseAction {
	private static final Logger log = LoggerFactory.getLogger(BaseTypeAction.class);
	private BaseTypeService baseTypeService;
	private boolean edit = false;
	private Integer page;
	private BaseTypeVO baseTypeVO;
	private PaginatedList list;
	private Integer cbId[];

	public String query() {
		log.debug("开始查询客户类型");
		PaginatedList list = getBaseTypeService().find(
				new PaginatedList(getPage()), getBaseTypeVO());
		setList(list);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String add() {
		log.debug("开始跳转到增加客户类型的界面");
		setEdit(false);
		BaseTypeVO baseTypeVO = new BaseTypeVO();
		setBaseTypeVO(baseTypeVO);
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String save() {
		log.debug("开始增加一个客户类型");
		if (getBaseTypeVO() == null) {
			addActionError("增加客户类型失败!");
		} else {
			BaseTypeVO baseTypeVO = getBaseTypeService().save(
					getBaseTypeVO());
			if (baseTypeVO == null) {
				addActionError("增加客户类型失败!");
			} else {
				addActionMessage("成功增加客户类型!");
				setEdit(true);
				setBaseTypeVO(baseTypeVO);
			}
		}
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String edit() {
		log.debug("开始跳转到修改客户类型的界面");
		setEdit(true);
		if (!SystemUtil.isNull(getCbId())) {
			BaseTypeVO baseTypeVO = getBaseTypeService().findById(getCbId()[0]);
			if (baseTypeVO == null) {
				addActionError("未能找到该客户类型!");
			} else {
				setBaseTypeVO(baseTypeVO);
			}
		} else {
			addActionError("请先选择一个客户类型!");
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String update() {
		log.debug("开始修改一个客户类型");
		setEdit(true);
		if (getBaseTypeVO() == null) {
			addActionError("修改客户类型失败!");
		} else {
			BaseTypeVO baseTypeVO = getBaseTypeService().update(getBaseTypeVO());
			if (baseTypeVO == null) {
				addActionError("修改客户类型失败!");
			} else {
				addActionMessage("成功修改客户类型!");
				setBaseTypeVO(baseTypeVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}
	
	public String delete() {
		log.debug("开始删除所选择的记录");
		int size = getBaseTypeService().delete(getCbId());
		addActionMessage("成功删除" + size + "个客户类型!");
		return query();
	}

	public String back() {
		log.debug("返回客户类型主界面");
		setBaseTypeVO(null);
		return query();
	}

	public BaseTypeService getBaseTypeService() {
		return baseTypeService;
	}

	public void setBaseTypeService(BaseTypeService baseTypeService) {
		this.baseTypeService = baseTypeService;
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

	public BaseTypeVO getBaseTypeVO() {
		return baseTypeVO;
	}

	public void setBaseTypeVO(BaseTypeVO baseTypeVO) {
		this.baseTypeVO = baseTypeVO;
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
