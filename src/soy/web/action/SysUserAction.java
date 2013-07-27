package soy.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.SysCust;
import soy.basic.database.entity.SysUser;
import soy.basic.vo.SysCustVO;
import soy.basic.vo.SysUserVO;
import soy.util.ForwardUtil;
import soy.util.PaginatedList;
import soy.util.SystemUtil;
import soy.web.service.SysUserService;

public class SysUserAction extends BaseAction {
	private static final Logger log = LoggerFactory.getLogger(SysUserAction.class);
	
	private SysUserService sysUserService;
	private boolean edit = false;
	private Integer page;
	private SysUserVO sysUserVO;
	private PaginatedList list;
	private Integer cbId[];

	public String query() {
		log.debug("开始查询用户管理");
		PaginatedList list = getSysUserService().find(
				new PaginatedList(getPage()), getSysUserVO());
		setList(list);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String add() {
		log.debug("开始跳转到增加用户管理的界面");
		setEdit(false);
		SysUserVO sysUserVO = new SysUserVO();
		setSysUserVO(sysUserVO);
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String save() {
		log.debug("开始增加一个用户管理");
		if (getSysUserVO() == null) {
			addActionError("增加用户失败!");
		} else {
			SysUserVO sysUserVO = getSysUserService().save(
					getSysUserVO());
			if (sysUserVO == null) {
				addActionError("增加用户失败!");
			} else {
				addActionMessage("成功增加用户!");
				setEdit(true);
				setSysUserVO(sysUserVO);
			}
		}
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String edit() {
		log.debug("开始跳转到修改用户管理的界面");
		setEdit(true);
		if (!SystemUtil.isNull(getCbId())) {
			SysUserVO sysUserVO = getSysUserService().findById(getCbId()[0]);
			if (sysUserVO == null) {
				addActionError("未能找到该用户!");
			} else {
				setSysUserVO(sysUserVO);
			}
		} else {
			addActionError("请先选择一个用户!");
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String update() {
		log.debug("开始修改一个用户管理");
		setEdit(true);
		if (getSysUserVO() == null) {
			addActionError("修改用户失败!");
		} else {
			SysUserVO sysUserVO = getSysUserService().update(getSysUserVO());
			if (sysUserVO == null) {
				addActionError("修改用户失败!");
			} else {
				addActionMessage("成功修改用户!");
				setSysUserVO(sysUserVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}
	
	public String delete() {
		log.debug("开始删除所选择的记录");
		int size = getSysUserService().delete(getCbId());
		addActionMessage("成功删除" + size + "个用户!");
		return query();
	}

	public String back() {
		log.debug("返回用户管理主界面");
		setSysUserVO(null);
		return query();
	}

	public SysUserService getSysUserService() {
		return sysUserService;
	}

	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
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

	public SysUserVO getSysUserVO() {
		return sysUserVO;
	}

	public void setSysUserVO(SysUserVO sysUserVO) {
		this.sysUserVO = sysUserVO;
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
