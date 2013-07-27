package soy.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.vo.BaseClassVO;
import soy.basic.vo.SysSupplierVO;
import soy.util.ForwardUtil;
import soy.util.PaginatedList;
import soy.util.SystemUtil;
import soy.web.service.SysSupplierService;

/**
 * @author XiaoLiang·Hu
 * 
 */
public class SysSupplierAction extends BaseAction {
	// 日志
	private static final Logger log = LoggerFactory
			.getLogger(SysSupplierAction.class);

	// 服务
	private SysSupplierService sysSupplierService;

	// 属性
	private PaginatedList list;
	private Integer page;
	private Integer[] cbId;
	private boolean edit = false;
	private SysSupplierVO sysSupplierVO;

	public String query() {
		log.debug("");
		PaginatedList list = getSysSupplierService().find(new PaginatedList(getPage()), getSysSupplierVO());
		setList(list);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String add() {
		log.debug("");
		setEdit(false);
		SysSupplierVO sysSupplierVO = new SysSupplierVO();
		setSysSupplierVO(sysSupplierVO);
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String save() {
		log.debug("");
		if (getSysSupplierVO() == null) {
			addActionError("增加供应商失败!");
		} else {
			SysSupplierVO sysSupplierVO = getSysSupplierService().save(getSysSupplierVO());
			if (sysSupplierVO == null) {
				addActionError("增加供应商失败!");
			} else {
				addActionMessage("增加供应商成功!");
				addActionMessage("新增供应商编号(" + sysSupplierVO.getId() + ")");
				setEdit(true);
				setSysSupplierVO(sysSupplierVO);
				log.debug("ACTION:增加供应商成功，跳转到修改供应商的主界面");
			}
		}
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String edit() {
		log.debug("");
		setEdit(true);
		if (!SystemUtil.isNull(getCbId())) {
//			BaseClassVO baseClassVO = getBaseClassService().findById(getCbId()[0]);
			SysSupplierVO sysSupplierVO = getSysSupplierService().findById(getCbId()[0]);
			if (sysSupplierVO == null) {
				addActionError("未能找到该供应商!");
			} else {
//				setBaseClassVO(baseClassVO);
				setSysSupplierVO(sysSupplierVO);
			}
		} else {
			addActionError("请先选择一个供应商!");
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String update() {
		log.debug("");
		setEdit(true);
		if (getSysSupplierVO() == null) {
			addActionError("修改供应商失败!");
		} else {
			SysSupplierVO sysSupplierVO = getSysSupplierService().update(getSysSupplierVO());
			if (sysSupplierVO == null) {
				addActionError("修改供应商失败!");
			} else {
				addActionMessage("成功修改供应商!");
				setSysSupplierVO(sysSupplierVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}
	
	public String delete() {
		log.debug("ACTION:开始删除供应商");
		int size = getSysSupplierService().delete(getCbId());
		addActionMessage("成功删除" + size + "个供应商!");
		return query();
	}

	public SysSupplierService getSysSupplierService() {
		return sysSupplierService;
	}

	public void setSysSupplierService(SysSupplierService sysSupplierService) {
		this.sysSupplierService = sysSupplierService;
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

	public SysSupplierVO getSysSupplierVO() {
		return sysSupplierVO;
	}

	public void setSysSupplierVO(SysSupplierVO sysSupplierVO) {
		this.sysSupplierVO = sysSupplierVO;
	}

	
}
