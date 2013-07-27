package soy.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.BaseMain;
import soy.basic.vo.BaseMainVO;
import soy.util.ForwardUtil;
import soy.util.PaginatedList;
import soy.util.SystemUtil;
import soy.web.service.BaseMainService;

/**
 * @author XiaoLiang·Hu
 * 
 */
public class BaseMainAction extends BaseAction {
	private static final Logger log = LoggerFactory
			.getLogger(BaseMainAction.class);

	// 服务
	private BaseMainService baseMainService;

	// 属性
	private PaginatedList list;
	private boolean edit = false;
	private Integer cbId[];
	private Integer page;
	private BaseMainVO baseMainVO;

	// 功能方法

	public String query() {
		log.debug("");
		PaginatedList list = getBaseMainService().find(
				new PaginatedList(getPage()), getBaseMainVO());
		setList(list);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String add() {
		log.debug("");
		setEdit(false);
		BaseMainVO baseMainVO = new BaseMainVO();
		setBaseMainVO(baseMainVO);
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String save() {
		log.debug("");
		if (getBaseMainVO() == null) {
			addActionError("增加供应商主营失败!");
		} else {
			BaseMainVO baseMainVO = getBaseMainService().save(getBaseMainVO());
			if (baseMainVO == null) {
				addActionError("增加供应商主营失败!");
			} else {
				addActionMessage("成功供应商主营种类!");
				setEdit(true);
				setBaseMainVO(baseMainVO);
			}
		}
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String edit() {
		log.debug("");
		setEdit(true);
		if (!SystemUtil.isNull(getCbId())) {
			BaseMainVO baseMainVO = getBaseMainService().findById(getCbId()[0]);
			if (baseMainVO == null) {
				addActionError("未能找到该供应商主营!");
			} else {
				setBaseMainVO(baseMainVO);
			}
		} else {
			addActionError("请先选择一个供应商主营!");
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String update() {
		log.debug("");
		setEdit(true);
		if (getBaseMainVO() == null) {
			addActionError("修改供应商主营失败!");
		} else {
//			BaseClassVO baseClassVO = getBaseClassService().update(getBaseClassVO());
			BaseMainVO baseMainVO = getBaseMainService().update(getBaseMainVO());
			if (baseMainVO == null) {
				addActionError("修改供应商主营失败!");
			} else {
				addActionMessage("成功修改供应商主营!");
				setBaseMainVO(baseMainVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}
	
	public String delete() {
		log.debug("");
		int size = getBaseMainService().delete(getCbId());
		addActionMessage("成功删除" + size + "个供应商主营!");
		return query();
	}

	public String back() {
		log.debug("");
		setBaseMainVO(null);
		return query();
	}

	public BaseMainService getBaseMainService() {
		return baseMainService;
	}

	public void setBaseMainService(BaseMainService baseMainService) {
		this.baseMainService = baseMainService;
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

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public BaseMainVO getBaseMainVO() {
		return baseMainVO;
	}

	public void setBaseMainVO(BaseMainVO baseMainVO) {
		this.baseMainVO = baseMainVO;
	}

}
