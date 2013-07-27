package soy.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.vo.BaseSourceVO;
import soy.util.ForwardUtil;
import soy.util.PaginatedList;
import soy.util.SystemUtil;
import soy.web.service.BaseSourceService;

public class BaseSourceAction extends BaseAction {
	private static final Logger log = LoggerFactory
			.getLogger(BaseSourceAction.class);

	private BaseSourceService baseSourceService;
	private BaseSourceVO baseSourceVO;
	private boolean edit = false;
	private Integer page;
	private Integer cbId[];
	private PaginatedList list;

	public String query() {
		log.debug("查询客户来源");
		PaginatedList list = getBaseSourceService().find(new PaginatedList(getPage()), getBaseSourceVO());
		setList(list);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String add() {
		log.debug("跳转到增加客户来源的主界面");
		setEdit(false);
		BaseSourceVO baseSourceVO = new BaseSourceVO();
		setBaseSourceVO(baseSourceVO);
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String save() {
		log.debug("增加客户来源");
		if (getBaseSourceVO() == null) {
			addActionError("增加客户来源失败!");
		} else {
			BaseSourceVO baseSourceVO = getBaseSourceService().save(
					getBaseSourceVO());
			if (baseSourceVO == null) {
				addActionError("增加客户来源失败!");
			} else {
				addActionMessage("成功增加客户来源!");
				setEdit(true);
				setBaseSourceVO(baseSourceVO);
			}
		}
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String edit() {
		log.debug("跳转到修改客户来源的主界面");
		setEdit(true);
		if (!SystemUtil.isNull(getCbId())) {
			BaseSourceVO baseSourceVO = getBaseSourceService().findById(getCbId()[0]);
			if (baseSourceVO == null) {
				addActionError("未能找到该客户来源!");
			} else {
				setBaseSourceVO(baseSourceVO);
			}
		} else {
			addActionError("请先选择客户来源记录!");
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String update() {
		log.debug("修改客户来源");
		setEdit(true);
		if (getBaseSourceVO() == null) {
			addActionError("修改客户来源失败!");
		} else {
			BaseSourceVO baseSourceVO = getBaseSourceService().update(getBaseSourceVO());
			if (baseSourceVO == null) {
				addActionError("修改客户来源失败!");
			} else {
				addActionMessage("成功修改客户来源!");
				setBaseSourceVO(baseSourceVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String delete() {
		log.debug("开始删除所选择的记录");
		int size = getBaseSourceService().delete(getCbId());
		addActionMessage("成功删除" + size + "个客户来源!");
		return query();
	}

	public String back() {
		log.debug("");
		setBaseSourceVO(null);
		return query();
	}

	public BaseSourceService getBaseSourceService() {
		return baseSourceService;
	}

	public void setBaseSourceService(BaseSourceService baseSourceService) {
		this.baseSourceService = baseSourceService;
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

	public BaseSourceVO getBaseSourceVO() {
		return baseSourceVO;
	}

	public void setBaseSourceVO(BaseSourceVO baseSourceVO) {
		this.baseSourceVO = baseSourceVO;
	}

	public Integer[] getCbId() {
		return cbId;
	}

	public void setCbId(Integer[] cbId) {
		this.cbId = cbId;
	}

	public PaginatedList getList() {
		return list;
	}

	public void setList(PaginatedList list) {
		this.list = list;
	}

}
