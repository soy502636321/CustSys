package soy.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.vo.BaseMaintaintypeVO;
import soy.util.ForwardUtil;
import soy.util.PaginatedList;
import soy.util.SystemUtil;
import soy.web.service.BaseMaintaintypeService;

public class BaseMaintaintypeAction extends BaseAction {
	private static final Logger log = LoggerFactory
			.getLogger(BaseMaintaintypeAction.class);

	private BaseMaintaintypeService baseMaintaintypeService;
	private BaseMaintaintypeVO baseMaintaintypeVO;
	private Integer page;
	private PaginatedList list;
	private boolean edit = false;
	private Integer cbId[];

	public String query() {
		log.debug("查询维护类型");
		PaginatedList list = getBaseMaintaintypeService().find(
				new PaginatedList(getPage()), getBaseMaintaintypeVO());
		setList(list);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String add() {
		log.debug("跳转到增加维护类型的界面");
		setEdit(false);
		BaseMaintaintypeVO baseMaintaintypeVO = new BaseMaintaintypeVO();
		setBaseMaintaintypeVO(baseMaintaintypeVO);
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String save() {
		log.debug("开始增加维护类型");
		if (getBaseMaintaintypeVO() == null) {
			addActionError("增加维护类型失败!");
		} else {
			BaseMaintaintypeVO baseMaintaintypeVO = getBaseMaintaintypeService()
					.save(getBaseMaintaintypeVO());
			if (baseMaintaintypeVO == null) {
				addActionError("增加维护类型失败!");
			} else {
				addActionMessage("成功增加维护类型!");
				setEdit(true);
				setBaseMaintaintypeVO(baseMaintaintypeVO);
			}
		}
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String edit() {
		log.debug("跳转到修改维护类型的界面");
		setEdit(true);
		if (!SystemUtil.isNull(getCbId())) {
			BaseMaintaintypeVO baseMaintaintypeVO = getBaseMaintaintypeService().findById(getCbId()[0]);
			if (baseMaintaintypeVO == null) {
				addActionError("未能找到该维护类型!");
			} else {
				setBaseMaintaintypeVO(baseMaintaintypeVO);
			}
		} else {
			addActionError("请先选择维护类型记录!");
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String update() {
		log.debug("开始修改维护类型");
		setEdit(true);
		if (getBaseMaintaintypeVO() == null) {
			addActionError("修改维护类型失败!");
		} else {
			BaseMaintaintypeVO baseMaintaintypeVO = getBaseMaintaintypeService().update(getBaseMaintaintypeVO());
			if (baseMaintaintypeVO == null) {
				addActionError("修改维护类型失败!");
			} else {
				addActionMessage("成功修改维护类型!");
				setBaseMaintaintypeVO(baseMaintaintypeVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}
	
	public String delete() {
		log.debug("删除维护类型");
		int size = getBaseMaintaintypeService().delete(getCbId());
		addActionMessage("成功删除" + size + "个维护类型!");
		return query();
	}

	public String back() {
		log.debug("返回维护类型主界面");
		setBaseMaintaintypeVO(null);
		return query();
	}

	public BaseMaintaintypeService getBaseMaintaintypeService() {
		return baseMaintaintypeService;
	}

	public void setBaseMaintaintypeService(
			BaseMaintaintypeService baseMaintaintypeService) {
		this.baseMaintaintypeService = baseMaintaintypeService;
	}

	public BaseMaintaintypeVO getBaseMaintaintypeVO() {
		return baseMaintaintypeVO;
	}

	public void setBaseMaintaintypeVO(BaseMaintaintypeVO baseMaintaintypeVO) {
		this.baseMaintaintypeVO = baseMaintaintypeVO;
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
