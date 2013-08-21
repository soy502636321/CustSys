package soy.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.SysCust;
import soy.basic.vo.SysMaintainVO;
import soy.util.ForwardUtil;
import soy.util.PaginatedList;
import soy.util.SystemUtil;
import soy.web.service.SysMaintainService;

public class SysMaintainAction extends BaseAction {
	private static final Logger log = LoggerFactory
			.getLogger(SysMaintainAction.class);

	private SysMaintainService sysMaintainService;
	private SysMaintainVO sysMaintainVO;
	private boolean edit = false;
	private Integer page;
	private PaginatedList list;
	private Integer cbId[];

	public String query() {
		log.debug("跳转到维护管理的主界面");
		PaginatedList list = getSysMaintainService().find(
				new PaginatedList(getPage()), getSysMaintainVO(), null);
		setList(list);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}
	
	public String search() {
		log.debug("");
		return ForwardUtil.FORWARD_SEARCH_PAGE;
	}

	public String add() {
		log.debug("跳转到增加维护的主界面");
		setEdit(false);
		SysMaintainVO sysMaintainVO = new SysMaintainVO();
		setSysMaintainVO(sysMaintainVO);
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String save() {
		log.debug("ACTION:开始增加维护记录");
		if (getSysMaintainVO() == null) {
			addActionError("增加维护记录失败!");
		} else {
			SysMaintainVO sysMaintainVO = getSysMaintainService().save(getSysMaintainVO());
			if (sysMaintainVO == null) {
				addActionError("增加维护记录失败!");
			} else {
				addActionMessage("成功增加维护记录!");
				addActionMessage("维护记录编号:(" + sysMaintainVO.getId() + ")");
				setSysMaintainVO(sysMaintainVO);
				setEdit(true);
				log.debug("ACTION:成功增加维护记录，并跳转到修改该记录的修改界面");
			}
		}
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String edit() {
		log.debug("跳转到修改维护的主界面");
		setEdit(true);
		if (SystemUtil.isNull(getCbId())) {
			addActionError("请先选择维护记录!");
		} else {
			SysMaintainVO sysMaintainVO = getSysMaintainService().findById(getCbId()[0]);
			if (sysMaintainVO == null) {
				addActionError("不存在你所选择的维护记录!");
			} else {
				setSysMaintainVO(sysMaintainVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String update() {
		log.debug("ACTION:开始修改维护记录");
		setEdit(true);
		if (getSysMaintainVO() == null) {
			addActionError("修改维护记录失败!");
		} else {
			SysMaintainVO sysMaintainVO = getSysMaintainService().update(getSysMaintainVO());
			if (sysMaintainVO == null) {
				addActionError("修改维护记录失败!");
			} else {
				addActionMessage("成功修改维护记录!");
				setSysMaintainVO(sysMaintainVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String back() {
		log.debug("");
		setSysMaintainVO(null);
		return query();
	}

	public SysMaintainVO getSysMaintainVO() {
		return sysMaintainVO;
	}

	public void setSysMaintainVO(SysMaintainVO sysMaintainVO) {
		this.sysMaintainVO = sysMaintainVO;
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

	public SysMaintainService getSysMaintainService() {
		return sysMaintainService;
	}

	public void setSysMaintainService(SysMaintainService sysMaintainService) {
		this.sysMaintainService = sysMaintainService;
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
