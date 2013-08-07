package soy.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.BaseProduction;
import soy.basic.vo.BaseClassVO;
import soy.basic.vo.BaseProductionVO;
import soy.util.ForwardUtil;
import soy.util.PaginatedList;
import soy.util.SystemUtil;
import soy.web.service.BaseProductionService;

/**
 * @author XiaoLiang·Hu
 * 
 */
public class BaseProductionAction extends BaseAction {
	private static final Logger log = LoggerFactory
			.getLogger(BaseClassAction.class);

	private BaseProductionService baseProductionService;

	private BaseProductionVO baseProductionVO;

	private PaginatedList list;
	private Integer cbId[];
	private boolean edit = false;
	private Integer page;

	public String query() {
		log.debug("开始查询生产类型");
		PaginatedList list = getBaseProductionService().find(
				new PaginatedList(getPage()), getBaseProductionVO());
		setList(list);
		System.out.println("kdfjkdjfd");;
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String add() {
		log.debug("开始跳转到增加生产类型的界面");
		setEdit(false);
//		BaseClassVO baseClassVO = new BaseClassVO();
		BaseProductionVO baseProductionVO = new BaseProductionVO();
//		setBaseClassVO(baseClassVO);
		setBaseProductionVO(baseProductionVO);
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String save() {
		log.debug("开始增加一个生产类型");
		if (getBaseProductionVO() == null) {
			addActionError("增加生产类型失败!");
		} else {
//			BaseClassVO baseClassVO = getBaseClassService().save(
//					getBaseClassVO());
			BaseProductionVO baseProductionVO = getBaseProductionService().save(getBaseProductionVO());
			if (baseProductionVO == null) {
				addActionError("增加生产类型失败!");
			} else {
				addActionMessage("成功增加生产类型!");
				setEdit(true);
//				setBaseClassVO(baseClassVO);
				setBaseProductionVO(baseProductionVO);
			}
		}
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String edit() {
		log.debug("开始跳转到修改生产类型的界面");
		setEdit(true);
		if (!SystemUtil.isNull(getCbId())) {
//			BaseClassVO baseClassVO = getBaseClassService().findById(
//					getCbId()[0]);
			BaseProductionVO baseProductionVO = getBaseProductionService().findById(getCbId()[0]);
			if (baseProductionVO == null) {
				addActionError("未能找到该生产类型!");
			} else {
//				setBaseClassVO(baseClassVO);
				setBaseProductionVO(baseProductionVO);
			}
		} else {
			addActionError("请先选择一个生产类型!");
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String update() {
		log.debug("开始修改一个生产类型");
		setEdit(true);
		if (getBaseProductionVO() == null) {
			addActionError("修改生产类型失败!");
		} else {
//			BaseClassVO baseClassVO = getBaseClassService().update(
//					getBaseClassVO());
			BaseProductionVO baseProductionVO = getBaseProductionService().update(getBaseProductionVO());
			if (baseProductionVO == null) {
				addActionError("修改生产类型失败!");
			} else {
				addActionMessage("成功修改生产类型!");
//				setBaseClassVO(baseClassVO);
				setBaseProductionVO(baseProductionVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String delete() {
		log.debug("开始删除所选择的记录");
//		int size = getBaseClassService().delete(getCbId());
		int size = getBaseProductionService().delete(getCbId());
		addActionMessage("成功删除" + size + "个生产类型!");
		return query();
	}

	public String back() {
		log.debug("返回生产类型主界面");
//		setBaseClassVO(null);
		setBaseProductionVO(null);
		return query();
	}

	public BaseProductionService getBaseProductionService() {
		return baseProductionService;
	}

	public void setBaseProductionService(BaseProductionService baseProductionService) {
		this.baseProductionService = baseProductionService;
	}

	public BaseProductionVO getBaseProductionVO() {
		return baseProductionVO;
	}

	public void setBaseProductionVO(BaseProductionVO baseProductionVO) {
		this.baseProductionVO = baseProductionVO;
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

}
