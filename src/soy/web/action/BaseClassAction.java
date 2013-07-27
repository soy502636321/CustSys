package soy.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.vo.BaseClassVO;
import soy.util.ForwardUtil;
import soy.util.PaginatedList;
import soy.util.SystemUtil;
import soy.web.service.BaseClassService;

/**
 * 
 * @author 小胡
 * 
 */
public class BaseClassAction extends BaseAction {
	private static final Logger log = LoggerFactory
			.getLogger(BaseClassAction.class);
	private BaseClassService baseClassService;
	private boolean edit = false;
	private Integer page;
	private BaseClassVO baseClassVO;
	private PaginatedList list;
	private Integer cbId[];

	public String query() {
		log.debug("开始查询订单种类");
		PaginatedList list = getBaseClassService().find(
				new PaginatedList(getPage()), getBaseClassVO());
		setList(list);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String add() {
		log.debug("开始跳转到增加订单种类的界面");
		setEdit(false);
		BaseClassVO baseClassVO = new BaseClassVO();
		setBaseClassVO(baseClassVO);
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String save() {
		log.debug("开始增加一个订单种类");
		if (getBaseClassVO() == null) {
			addActionError("增加订单种类失败!");
		} else {
			BaseClassVO baseClassVO = getBaseClassService().save(
					getBaseClassVO());
			if (baseClassVO == null) {
				addActionError("增加订单种类失败!");
			} else {
				addActionMessage("成功增加订单种类!");
				setEdit(true);
				setBaseClassVO(baseClassVO);
			}
		}
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String edit() {
		log.debug("开始跳转到修改订单种类的界面");
		setEdit(true);
		if (!SystemUtil.isNull(getCbId())) {
			BaseClassVO baseClassVO = getBaseClassService().findById(getCbId()[0]);
			if (baseClassVO == null) {
				addActionError("未能找到该订单种类!");
			} else {
				setBaseClassVO(baseClassVO);
			}
		} else {
			addActionError("请先选择一个订单种类!");
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String update() {
		log.debug("开始修改一个订单种类");
		setEdit(true);
		if (getBaseClassVO() == null) {
			addActionError("修改订单种类失败!");
		} else {
			BaseClassVO baseClassVO = getBaseClassService().update(getBaseClassVO());
			if (baseClassVO == null) {
				addActionError("修改订单种类失败!");
			} else {
				addActionMessage("成功修改订单种类!");
				setBaseClassVO(baseClassVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}
	
	public String delete() {
		log.debug("开始删除所选择的记录");
		int size = getBaseClassService().delete(getCbId());
		addActionMessage("成功删除" + size + "个订单种类!");
		return query();
	}

	public String back() {
		log.debug("返回订单种类主界面");
		setBaseClassVO(null);
		return query();
	}

	public BaseClassService getBaseClassService() {
		return baseClassService;
	}

	public void setBaseClassService(BaseClassService baseClassService) {
		this.baseClassService = baseClassService;
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

	public BaseClassVO getBaseClassVO() {
		return baseClassVO;
	}

	public void setBaseClassVO(BaseClassVO baseClassVO) {
		this.baseClassVO = baseClassVO;
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
