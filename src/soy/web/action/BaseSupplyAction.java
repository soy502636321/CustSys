package soy.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.BaseSupply;
import soy.basic.vo.BaseClassVO;
import soy.basic.vo.BaseSupplyVO;
import soy.util.ForwardUtil;
import soy.util.PaginatedList;
import soy.util.SystemUtil;
import soy.web.service.BaseClassService;
import soy.web.service.BaseSupplyService;

public class BaseSupplyAction extends BaseAction {
	// 日志
	private static final Logger log = LoggerFactory
			.getLogger(BaseSupplyAction.class);

	// 服务
	private BaseSupplyService baseSupplyService;

	// VO
	private BaseSupplyVO baseSupplyVO;

	// 属性
	private boolean edit = false;
	private Integer page;
	private Integer cbId[];

	// 分页器
	private PaginatedList list;

	/**
	 * 分页查询供应质量，只要用于显示列表或者查询
	 * 
	 * @return
	 */
	public String query() {
		log.debug("ACTION:开始分页查询供应质量");
		PaginatedList list = new PaginatedList(getPage());
		list = getBaseSupplyService().find(list, getBaseSupplyVO());
		setList(list);
		log.debug("ACTION:分页查询供应质量成功");
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	/**
	 * 跳转到增加供应质量的主界面
	 * 
	 * @return
	 */
	public String add() {
		log.debug("ACTION:开始跳转到增加供应质量的主界面");
		setEdit(false);
		log.debug("ACTION:成功跳转到增加供应质量的主界面");
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String save() {
		log.debug("ACTION:开始增加供应质量");
		if (getBaseSupplyVO() == null) {
			addActionError("增加供应质量失败!");
			log.error("ACTION:增加供应质量失败，前台未传值");
		} else {
//			BaseClassVO baseClassVO = getBaseClassService().save(
//					getBaseClassVO());
			BaseSupplyVO baseSupplyVO = getBaseSupplyService().save(getBaseSupplyVO());
			if (baseSupplyVO == null) {
				addActionError("增加供应质量失败!");
				log.error("ACTION:增加供应质量失败，服务层返回空对象");
			} else {
				addActionMessage("成功增加供应质量!");
				setEdit(true);
				setBaseSupplyVO(baseSupplyVO);
				log.debug("ACTION:成功增加质量供应");
			}
		}
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String edit() {
		log.debug("ACTION:跳转到修改供应质量的主界面");
		setEdit(true);
		if (!SystemUtil.isNull(getCbId())) {
			BaseSupplyVO baseSupplyVO = (BaseSupplyVO) getBaseSupplyService().findById(getCbId()[0]);
			if (baseSupplyVO == null) {
				addActionError("未能找到该供应质量记录!");
			} else {
				setBaseSupplyVO(baseSupplyVO);
			}
		} else {
			addActionError("请先选择一个供应质量记录!");
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String update() {
		log.debug("ACTION:开始修改供应质量记录");
		setEdit(true);
		if (getBaseSupplyVO() == null) {
			addActionError("修改供应质量记录失败!");
		} else {
			BaseSupplyVO baseSupplyVO = getBaseSupplyService().update(getBaseSupplyVO());
			if (baseSupplyVO == null) {
				addActionError("修改供应质量记录失败!");
			} else {
				addActionMessage("修改供应质量记录成功!");
				setBaseSupplyVO(baseSupplyVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}
	
	public String show() {
		log.debug("ACTION:显示供应质量记录!");
		if (!SystemUtil.isNull(getCbId())) {
			BaseSupplyVO baseSupplyVO = (BaseSupplyVO) getBaseSupplyService().findById(getCbId()[0]);
			if (baseSupplyVO == null) {
				addActionError("未能找到该供应质量记录!");
			} else {
				setBaseSupplyVO(baseSupplyVO);
			}
		} else {
			addActionError("请先选择一个供应质量记录!");
		}
		return ForwardUtil.FORWARD_SHOW_PAGE;
	}

	public String delete() {
		log.debug("ACTION:删除所选择的供应质量记录!");
		int size = getBaseSupplyService().delete(getCbId());
		addActionMessage("成功删除" + size + "条供应质量记录!");
		return query();
	}

	public String back() {
		log.debug("ACTION:返回供应质量主界面");
		setBaseSupplyVO(null);
		return query();
	}

	public BaseSupplyService getBaseSupplyService() {
		return baseSupplyService;
	}

	public void setBaseSupplyService(BaseSupplyService baseSupplyService) {
		this.baseSupplyService = baseSupplyService;
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

	public BaseSupplyVO getBaseSupplyVO() {
		return baseSupplyVO;
	}

	public void setBaseSupplyVO(BaseSupplyVO baseSupplyVO) {
		this.baseSupplyVO = baseSupplyVO;
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
