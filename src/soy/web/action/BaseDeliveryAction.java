package soy.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.BaseDelivery;
import soy.basic.vo.BaseDeliveryVO;
import soy.util.ForwardUtil;
import soy.util.PaginatedList;
import soy.util.SystemUtil;
import soy.web.service.BaseDeliveryService;

public class BaseDeliveryAction extends BaseAction {
	private static final Logger log = LoggerFactory
			.getLogger(BaseDeliveryAction.class);

	private BaseDeliveryService baseDeliveryService;
	private boolean edit = false;
	private BaseDeliveryVO baseDeliveryVO;
	private Integer page;
	private PaginatedList list;
	private Integer[] cbId;

	public String query() {
		log.debug("开始查询交付方式");
		PaginatedList list = getBaseDeliveryService().find(
				new PaginatedList(getPage()), getBaseDeliveryVO());
		setList(list);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String add() {
		log.debug("跳转到增加交付方式的界面");
		setEdit(false);
		BaseDeliveryVO baseDeliveryVO = new BaseDeliveryVO();
		setBaseDeliveryVO(baseDeliveryVO);
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String save() {
		log.debug("开始增加交付方式");
		if (getBaseDeliveryVO() == null) {
			addActionError("增加交付方式失败!");
		} else {
			BaseDeliveryVO baseDeliveryVO = getBaseDeliveryService().save(
					getBaseDeliveryVO());
			if (baseDeliveryVO == null) {
				addActionError("增加交付方式失败!");
			} else {
				addActionMessage("成功增加交付方式!");
				setEdit(true);
				setBaseDeliveryVO(baseDeliveryVO);
			}
		}
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String edit() {
		log.debug("跳转到修改交付方式的界面");
		setEdit(true);
		if (!SystemUtil.isNull(getCbId())) {
			BaseDeliveryVO baseDeliveryVO = getBaseDeliveryService().findById(getCbId()[0]);
			if (baseDeliveryVO == null) {
				addActionError("未能找到该交付方式!");
			} else {
				setBaseDeliveryVO(baseDeliveryVO);
			}
		} else {
			addActionError("请先选择交付方式!");
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String update() {
		log.debug("开始修改交付方式");
		setEdit(true);
		if (getBaseDeliveryVO() == null) {
			addActionError("修改交付方式失败!");
		} else {
			BaseDeliveryVO baseDeliveryVO = getBaseDeliveryService().update(getBaseDeliveryVO());
			if (baseDeliveryVO == null) {
				addActionError("修改交付方式失败!");
			} else {
				addActionMessage("修改交付方式成功!");
				setBaseDeliveryVO(baseDeliveryVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String delete() {
		log.debug("开始删除交付方式");
		int size = getBaseDeliveryService().delete(getCbId());
		addActionMessage("成功删除" + size + "个交付方式!");
		return query();
	}

	public String back() {
		log.debug("返回到交付方式主界面");
		setBaseDeliveryVO(null);
		return query();
	}

	public BaseDeliveryService getBaseDeliveryService() {
		return baseDeliveryService;
	}

	public void setBaseDeliveryService(BaseDeliveryService baseDeliveryService) {
		this.baseDeliveryService = baseDeliveryService;
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

	public BaseDeliveryVO getBaseDeliveryVO() {
		return baseDeliveryVO;
	}

	public void setBaseDeliveryVO(BaseDeliveryVO baseDeliveryVO) {
		this.baseDeliveryVO = baseDeliveryVO;
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
