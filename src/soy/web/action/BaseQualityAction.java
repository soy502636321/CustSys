package soy.web.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.vo.BaseQualityVO;
import soy.util.ForwardUtil;
import soy.util.PaginatedList;
import soy.util.SystemUtil;
import soy.web.service.BaseQualityService;

public class BaseQualityAction extends BaseAction {
	private static final Logger log = LoggerFactory
			.getLogger(BaseQualityAction.class);
	private BaseQualityService baseQualityService;
	private boolean edit = false;
	private Integer page;
	private BaseQualityVO baseQualityVO;
	private PaginatedList list;
	private Integer cbId[];
	
	public String query() {
		log.debug("查询业务品质");
		PaginatedList list = getBaseQualityService().find(new PaginatedList(), getBaseQualityVO());
		setList(list);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}
	
	public String add() {
		log.debug("跳转到增加业务品质的主界面");
		setEdit(false);
		BaseQualityVO baseQualityVO = new BaseQualityVO();
		setBaseQualityVO(baseQualityVO);
		return ForwardUtil.FORWARD_ADD_PAGE;
	}
	
	public String save() {
		log.debug("增加业务品质");
		if (getBaseQualityVO() == null) {
			addActionError("增加业务品质失败!");
		} else {
			BaseQualityVO baseQualityVO = (BaseQualityVO) getBaseQualityService().save(getBaseQualityVO());
			if (baseQualityVO == null) {
				addActionError("增加业务品质失败!");
			} else {
				addActionMessage("成功增加业务品质!");
				setEdit(true);
				setBaseQualityVO(baseQualityVO);
			}
		}
		return ForwardUtil.FORWARD_ADD_PAGE;
	}
	
	public String edit() {
		log.debug("跳转到修改业务品质的主界面");
		setEdit(true);
		if (!SystemUtil.isNull(getCbId())) {
			BaseQualityVO baseQualityVO = getBaseQualityService().findById(getCbId()[0]);
			if (baseQualityVO == null) {
				addActionError("未能找到该业务品质!");
			} else {
				setBaseQualityVO(baseQualityVO);
			}
		} else {
			addActionError("请先选择业务品质记录!");
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}
	
	public String update() {
		log.debug("修改业务品质");
		setEdit(true);
		if (getBaseQualityVO() == null) {
			addActionError("修改业务品质失败!");
		} else {
			BaseQualityVO baseQualityVO = getBaseQualityService().update(getBaseQualityVO());
			if (baseQualityVO == null) {
				addActionError("修改业务品质失败!");
			} else {
				addActionMessage("成功修改业务品质!");
				setBaseQualityVO(baseQualityVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}
	
	public String delete() {
		log.debug("删除业务品质");
		int size = getBaseQualityService().delete(getCbId());
		addActionMessage("成功删除" + size + "个业务品质!");
		setBaseQualityVO(null);
		return query();
	}
	
	public String back() {
		log.debug("返回业务品质主界面");
		setBaseQualityVO(null);
		return query();
	}

	public BaseQualityService getBaseQualityService() {
		return baseQualityService;
	}

	public void setBaseQualityService(BaseQualityService baseQualityService) {
		this.baseQualityService = baseQualityService;
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

	public BaseQualityVO getBaseQualityVO() {
		return baseQualityVO;
	}

	public void setBaseQualityVO(BaseQualityVO baseQualityVO) {
		this.baseQualityVO = baseQualityVO;
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
