package soy.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.vo.BaseIndustryVO;
import soy.util.ForwardUtil;
import soy.util.PaginatedList;
import soy.util.SystemUtil;
import soy.web.service.BaseIndustryService;

public class BaseIndustryAction extends BaseAction {
	private static final Logger log = LoggerFactory
			.getLogger(BaseIndustryAction.class);

	private BaseIndustryService baseIndustryService;
	private boolean edit = false;
	private Integer page;
	private BaseIndustryVO baseIndustryVO;
	private PaginatedList list;
	private Integer cbId[];

	public String query() {
		log.debug("开始查询客户行业");
		PaginatedList list = getBaseIndustryService().find(new PaginatedList(getPage()),
				getBaseIndustryVO());
		setList(list);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String add() {
		log.debug("开始跳转到增加客户行业的界面");
		setEdit(false);
		BaseIndustryVO baseIndustryVO = new BaseIndustryVO();
		setBaseIndustryVO(baseIndustryVO);
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String save() {
		log.debug("开始增加客户行业");
		if (getBaseIndustryVO() == null) {
			addActionError("增加客户行业失败!");
		} else {
			BaseIndustryVO baseIndustryVO = getBaseIndustryService().save(
					getBaseIndustryVO());
			if (baseIndustryVO == null) {
				addActionError("增加客户行业失败!");
			} else {
				addActionMessage("成功增加客户行业!");
				setEdit(true);
				setBaseIndustryVO(baseIndustryVO);
			}
		}
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String edit() {
		log.debug("跳转到修改客户行业的主界面");
		setEdit(true);
		if (!SystemUtil.isNull(getCbId())) {
			BaseIndustryVO baseIndustryVO = getBaseIndustryService().findById(getCbId()[0]);
			if (baseIndustryVO == null) {
				addActionError("未能找到该客户行业!");
			} else {
				setBaseIndustryVO(baseIndustryVO);
			}
		} else {
			addActionError("请先选择一个客户行业记录!");
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String update() {
		log.debug("修改客户行业");
		setEdit(true);
		if (getBaseIndustryVO() == null) {
			addActionError("修改客户行业失败!");
		} else {
			BaseIndustryVO baseIndustryVO = getBaseIndustryService().update(getBaseIndustryVO());
			if (baseIndustryVO == null) {
				addActionError("修改客户行业失败!");
			} else {
				addActionMessage("成功修改客户行业!");
				setBaseIndustryVO(baseIndustryVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String delete() {
		log.debug("进行删除客户行业的操作");
		int size = getBaseIndustryService().delete(getCbId());
		addActionMessage("成功删除" + size + "个客户行业!");
		return query();
	}

	public String back() {
		log.debug("返回客户行业主界面");
		setBaseIndustryVO(null);
		return query();
	}

	public BaseIndustryService getBaseIndustryService() {
		return baseIndustryService;
	}

	public void setBaseIndustryService(BaseIndustryService baseIndustryService) {
		this.baseIndustryService = baseIndustryService;
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

	public BaseIndustryVO getBaseIndustryVO() {
		return baseIndustryVO;
	}

	public void setBaseIndustryVO(BaseIndustryVO baseIndustryVO) {
		this.baseIndustryVO = baseIndustryVO;
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
