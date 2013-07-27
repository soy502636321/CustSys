package soy.web.action;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.SysRecord;
import soy.basic.vo.SysBusinessVO;
import soy.basic.vo.SysRecordVO;
import soy.util.ForwardUtil;
import soy.util.PaginatedList;
import soy.util.SystemUtil;
import soy.web.service.SysRecordService;

/**
 * @author XiaoLiang·Hu
 * 
 */
public class SysRecordAction extends BaseAction {
	// 日志
	private static final Logger log = LoggerFactory
			.getLogger(SysRecordAction.class);

	// 服务
	private SysRecordService sysRecordService;

	// 属性
	private PaginatedList list;
	private Integer page;
	private boolean edit = false;
	private SysRecordVO sysRecordVO;
	private SysBusinessVO sysBusinessVO;
	private Integer cbId[];

	// 功能方法

	public String query() {
		log.debug("");
		PaginatedList list = getSysRecordService().find(
				new PaginatedList(getPage()), getSysRecordVO(), getSysBusinessVO());
		setList(list);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String add() {
		log.debug("");
		setEdit(false);
		SysRecordVO sysRecordVO = new SysRecordVO();
		setSysRecordVO(sysRecordVO);
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String save() {
		log.debug("");
		if (getSysRecordVO() == null) {
			addActionError("增加生产记录失败!");
		} else {
			SysRecordVO sysRecordVO = getSysRecordService().save(
					getSysRecordVO());
			if (sysRecordVO == null) {
				addActionError("增加生产记录失败!");
			} else {
				addActionMessage("成功增加生产记录!");
				setEdit(true);
				setSysRecordVO(sysRecordVO);
			}
		}
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String edit() {
		log.debug("");
		setEdit(true);
		if (!SystemUtil.isNull(getCbId())) {
			// SysUserVO sysUserVO = getSysUserService().findById(getCbId()[0]);
			SysRecordVO sysRecordVO = getSysRecordService().findById(
					getCbId()[0]);
			if (sysRecordVO == null) {
				addActionError("未能找到该生产记录!");
			} else {
				// setSysUserVO(sysUserVO);
				setSysRecordVO(sysRecordVO);
			}
		} else {
			addActionError("请先选择一条生产记录!");
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String update() {
		log.debug("");
		setEdit(true);
		if (getSysRecordVO() == null) {
			addActionError("修改生产记录失败!");
		} else {
			// SysUserVO sysUserVO = getSysUserService().update(getSysUserVO());
			SysRecordVO sysRecordVO = getSysRecordService().update(
					getSysRecordVO());
			if (sysRecordVO == null) {
				addActionError("修改生产记录失败!");
			} else {
				addActionMessage("成功修改生产记录!");
				// setSysUserVO(sysUserVO);
				setSysRecordVO(sysRecordVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String delete() {
		log.debug("");
		int size = getSysRecordService().delete(getCbId());
		addActionMessage("成功删除" + size + "条生产记录!");
		return query();
	}

	public PaginatedList getList() {
		return list;
	}

	public void setList(PaginatedList list) {
		this.list = list;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public SysRecordService getSysRecordService() {
		return sysRecordService;
	}

	public void setSysRecordService(SysRecordService sysRecordService) {
		this.sysRecordService = sysRecordService;
	}

	public SysRecordVO getSysRecordVO() {
		return sysRecordVO;
	}

	public void setSysRecordVO(SysRecordVO sysRecordVO) {
		this.sysRecordVO = sysRecordVO;
	}

	public Integer[] getCbId() {
		return cbId;
	}

	public void setCbId(Integer[] cbId) {
		this.cbId = cbId;
	}

	public SysBusinessVO getSysBusinessVO() {
		return sysBusinessVO;
	}

	public void setSysBusinessVO(SysBusinessVO sysBusinessVO) {
		this.sysBusinessVO = sysBusinessVO;
	}

}
