package soy.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.vo.BasePaymentVO;
import soy.util.ForwardUtil;
import soy.util.PaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;
import soy.web.service.BasePaymentService;

public class BasePaymentAction extends BaseAction {
	private static final Logger log = LoggerFactory
			.getLogger(BasePaymentAction.class);

	private BasePaymentService basePaymentService;
	private boolean edit;
	private Integer page;
	private BasePaymentVO basePaymentVO;
	private PaginatedList list;
	private Integer cbId[];
	
	public String query() {
		log.debug("查询支付方式");
		PaginatedList list = getBasePaymentService().find(new PaginatedList(getPage()), getBasePaymentVO());
		setList(list);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}
	
	public String add() {
		log.debug("跳转到增加支付方式的主界面");
		setEdit(false);
		BasePaymentVO basePaymentVO = new BasePaymentVO();
		setBasePaymentVO(basePaymentVO);
		return ForwardUtil.FORWARD_ADD_PAGE;
	}
	
	public String save() {
		log.debug("开始增加支付方式");
		if (getBasePaymentVO() == null) {
			addActionError("增加支付方式失败!");
		} else {
			BasePaymentVO basePaymentVO = getBasePaymentService().save(getBasePaymentVO());
			if (basePaymentVO == null) {
				addActionError("增加支付方式失败!");
			} else {
				addActionMessage("成功增加支付方式!");
				setEdit(true);
				setBasePaymentVO(basePaymentVO);
			}
		}
		return ForwardUtil.FORWARD_ADD_PAGE;
	}
	
	public String edit() {
		log.debug("跳转到修改支付方式的主界面");
		setEdit(true);
		if (!SystemUtil.isNull(getCbId())) {
			BasePaymentVO basePaymentVO = getBasePaymentService().findById(getCbId()[0]);
			if (basePaymentVO == null) {
				addActionError("未能找到该支付方式!");
			} else {
				setBasePaymentVO(basePaymentVO);
			}
		} else {
			addActionError("请先选择支付方式记录!");
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}
	
	public String update() {
		log.debug("开始修改支付方式");
		setEdit(true);
		if (getBasePaymentVO() == null) {
			addActionError("修改交付方式失败!");
		} else {
			BasePaymentVO basePaymentVO = getBasePaymentService().update(getBasePaymentVO());
			if (basePaymentVO == null) {
				addActionError("修改交付方式失败!");
			} else {
				addActionMessage("成功修改交付方式!");
				setBasePaymentVO(basePaymentVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}
	
	public String delete() {
		log.debug("删除支付方式");
		int size = getBasePaymentService().delete(getCbId());
		addActionMessage("成功删除" + size + "个支付方式!");
		setBasePaymentVO(null);
		return query();
	}
	
	public String back() {
		log.debug("返回支付方式主界面");
		setBasePaymentVO(null);
		return query();
	}

	public BasePaymentService getBasePaymentService() {
		return basePaymentService;
	}

	public void setBasePaymentService(BasePaymentService basePaymentService) {
		this.basePaymentService = basePaymentService;
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

	public BasePaymentVO getBasePaymentVO() {
		return basePaymentVO;
	}

	public void setBasePaymentVO(BasePaymentVO basePaymentVO) {
		this.basePaymentVO = basePaymentVO;
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
