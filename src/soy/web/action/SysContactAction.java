package soy.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.SysContact;
import soy.basic.vo.SysContactVO;
import soy.basic.vo.SysCustVO;
import soy.util.ForwardUtil;
import soy.util.PaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;
import soy.web.service.SysContactService;
import soy.web.service.SysCustService;

public class SysContactAction extends BaseAction {
	private static final Logger log = LoggerFactory
			.getLogger(SysContactAction.class);

	//服务
	private SysContactService sysContactService;
	private SysCustService sysCustService;
	
	//VO
	private SysContactVO sysContactVO;
	private SysCustVO sysCustVO;
	
	//属性
	private boolean edit = false;
	private PaginatedList list;
	private Integer page;
	private Integer[] cbId;

	public String query() {
		log.debug("客户联系方式的主界面");
		if (getSysCustVO() == null || StringUtil.isNull(getSysCustVO().getId())
				|| !StringUtil.isInteger(getSysCustVO().getId())) {
			addActionError("未指定客户记录!");
		} else {
			SysCustVO sysCustVO = getSysCustService().findById(
					Integer.valueOf(getSysCustVO().getId()));
			if (sysCustVO == null) {
				addActionError("为指定客户记录!");
			} else {
				PaginatedList list = getSysContactService().find(
						new PaginatedList(getPage()), getSysContactVO(),
						sysCustVO);
				System.out.println("集合数量：" + list.getList().size());
				setSysCustVO(sysCustVO);
				setList(list);
			}
		}
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String add() {
		log.debug("跳转到增加客户联系方式的主界面");
		setEdit(false);
		SysContactVO sysContactVO = new SysContactVO();
		setSysContactVO(sysContactVO);
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String save() {
		log.debug("ACTION：开始增加客户的联系方式");
		if (getSysCustVO() == null) {
			addActionError("增加联系方式失败!");
		} else {
			getSysContactVO().setSysCustId(getSysCustVO().getId()); //对应的客户ID
			SysContactVO sysContactVO = getSysContactService().save(getSysContactVO());
			if (sysContactVO == null) {
				addActionError("增加联系方式失败!");
			} else {
				addActionMessage("增加联系方式成功!");
				addActionMessage("新增联系方式编号(" + sysContactVO.getId() + ")");
				setEdit(true);
				setSysContactVO(sysContactVO);
				log.debug("ACTION:增加联系方式成功，跳转到修改联系方式的主界面");
			}
		}
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String edit() {
		log.debug("跳转到修改客户的联系方式");
		setEdit(true);
		if (SystemUtil.isNull(getCbId())) {
			addActionError("请先选择客户联系记录!");
		} else {
			SysContactVO sysContactVO = getSysContactService().findById(getCbId()[0]);
			if (sysContactVO == null) {
				addActionError("未能找到你所选择的客户联系记录!");
			} else {
				setSysContactVO(sysContactVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String update() {
		log.debug("ACTION:开始修改客户联系方式");
		setEdit(true);
		if (getSysContactVO() == null) {
			addActionError("修改联系方式记录失败!");
		} else {
			SysContactVO sysContactVO = getSysContactService().update(getSysContactVO());
			if (sysContactVO == null) {
				addActionError("修改联系方式记录失败!");
			} else {
				addActionMessage("成功修改联系方式记录!");
				setSysContactVO(sysContactVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	public String back() {
		log.debug("返回客户联系方式的主界面");
		SysContactVO sysContactVO = new SysContactVO();
		setSysContactVO(sysContactVO);
		return query();
	}

	public SysContactService getSysContactService() {
		return sysContactService;
	}

	public void setSysContactService(SysContactService sysContactService) {
		this.sysContactService = sysContactService;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public SysContactVO getSysContactVO() {
		return sysContactVO;
	}

	public void setSysContactVO(SysContactVO sysContactVO) {
		this.sysContactVO = sysContactVO;
	}

	public SysCustService getSysCustService() {
		return sysCustService;
	}

	public void setSysCustService(SysCustService sysCustService) {
		this.sysCustService = sysCustService;
	}

	public SysCustVO getSysCustVO() {
		return sysCustVO;
	}

	public void setSysCustVO(SysCustVO sysCustVO) {
		this.sysCustVO = sysCustVO;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
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
