package soy.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.SysContact;
import soy.basic.database.entity.SysCust;
import soy.basic.vo.SysContactVO;
import soy.basic.vo.SysCustVO;
import soy.basic.vo.SysMaintainVO;
import soy.util.ForwardUtil;
import soy.util.PaginatedList;
import soy.util.SystemUtil;
import soy.web.service.SysBusinessService;
import soy.web.service.SysContactService;
import soy.web.service.SysCustService;
import soy.web.service.SysMaintainService;

public class SysCustAction extends BaseAction {
	//日志
	private static final Logger log = LoggerFactory
			.getLogger(SysCustAction.class);

	//服务
	private SysCustService sysCustService;
	private SysContactService sysContactService;
	private SysMaintainService sysMaintainService;
	private SysBusinessService sysBusinessService;

	//VO
	private SysCustVO sysCustVO;
	
	//属性
	private boolean edit = false;
	private Integer page;
	private PaginatedList list;
	private Integer cbId[];

	//功能方法
	
	/**
	 * 查询
	 * @return
	 */
	public String query() {
		log.debug("跳转到客户管理的主界面");
		PaginatedList list = getSysCustService().find(
				new PaginatedList(getPage()), getSysCustVO());
		setList(list);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}
	
	public String search() {
		log.debug("跳转到搜索界面");
		return ForwardUtil.FORWARD_SEARCH_PAGE;
	}
	
	
	/**
	 * 添加客户
	 * @return
	 */
	public String add() {
		log.debug("跳转到增加客户的主界面");
		setEdit(false);
		SysCustVO sysCustVO = new SysCustVO();
		setSysCustVO(sysCustVO);
		return ForwardUtil.FORWARD_ADD_PAGE;
	}
	
	/**
	 * 添加客户》增加
	 * @return
	 */
	public String save() {
		log.debug("ACTION:开始增加客户");
		if (getSysCustVO() == null) {
			addActionError("增加客户失败!");
		} else {
			SysCustVO sysCustVO = getSysCustService().save(getSysCustVO());
			if (sysCustVO == null) {
				addActionError("增加客户失败!");
			} else {
				addActionMessage("增加客户成功!");
				addActionMessage("新增客户编号(" + sysCustVO.getId() + ")");
				setEdit(true);
				setSysCustVO(sysCustVO);
				log.debug("ACTION:增加客户成功，跳转到修改客户的主界面");
			}
		}
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	/**
	 * 修改客户
	 * @return
	 */
	public String edit() {
		log.debug("跳转到修改客户的主界面");
		setEdit(true);
		if (SystemUtil.isNull(getCbId())) {
			addActionError("请先选择客户记录!");
		} else {
			SysCustVO sysCustVO = getSysCustService().findById(getCbId()[0]);
			if (sysCustVO == null) {
				addActionError("未能找到你所选择的客户记录!");
			} else {
				setSysCustVO(sysCustVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	/**
	 * 修改客户》修改
	 * @return
	 */
	public String update() {
		log.debug("ACTION:开始修改客户记录");
		setEdit(true);
		if (getSysCustVO() == null) {
			addActionError("修改客户记录失败!");
		} else {
			SysCustVO sysCustVO = getSysCustService().update(getSysCustVO());
			if (sysCustVO == null) {
				addActionError("修改客户记录失败!");
			} else {
				addActionMessage("成功修改客户记录!");
				setSysCustVO(sysCustVO);
			}
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}

	/**
	 * 联系方式
	 * @return
	 */
	public String contactQuery() {
		log.debug("跳转到指定客户的联系方式主界面");
		if (SystemUtil.isNull(getCbId())) {
			addActionError("请先选择指定的客户记录!");
		} else {
			SysCustVO sysCustVO = getSysCustService().findById(getCbId()[0]);
			if (sysCustVO == null) {
				addActionError("未能找到你所选择的客户记录!");
			} else {
				list = getSysContactService().find(new PaginatedList(), null,
						sysCustVO);
				setSysCustVO(sysCustVO);
				setList(list);
			}
		}
		return "contactQuery";
	}

	/**
	 * 维护记录
	 * @return
	 */
	public String maintainQuery() {
		log.debug("跳转到指定客户的维护记录主界面");
		if (SystemUtil.isNull(getCbId())) {
			addActionError("请先选择指定的客户记录!");
		} else {
			SysCustVO sysCustVO = getSysCustService().findById(getCbId()[0]);
			if (sysCustVO == null) {
				addActionError("未能找到你所选择的客户记录!");
			} else {
				list = getSysMaintainService().find(new PaginatedList(), null,
						sysCustVO);
				setSysCustVO(sysCustVO);
				setList(list);
			}
		}
		return "maintainQuery";
	}

	public String businessQuery() {
		log.debug("跳转到指定客户的业务记录主界面");
		if (SystemUtil.isNull(getCbId())) {
			addActionError("请先选择指定的客户记录!");
		} else {
			SysCustVO sysCustVO = getSysCustService().findById(getCbId()[0]);
			if (sysCustVO == null) {
				
			} else {
				list = getSysBusinessService().find(new PaginatedList(), null, sysCustVO);
				setSysCustVO(sysCustVO);
				setList(list);
			}
		}
		return "businessQuery";
	}
	
	public String feature() {
		log.debug("跳转到修改或者增加客户性格的界面");
		if (SystemUtil.isNull(getCbId())) {
			addActionError("请先选择客户记录!");
		} else {
			SysCustVO sysCustVO = getSysCustService().findById(getCbId()[0]);
			if (sysCustVO == null) {
				addActionError("未能找到你所选择的客户记录!");
			} else {
				setSysCustVO(sysCustVO);
			}
		}
		return "feature";
	}
	
	public String updateFeature() {
		log.debug("ACTION:开始修改客户的特点");
		if (getSysCustVO() == null) {
			addActionError("修改客户特点失败!");
		} else {
			SysCustVO sysCustVO = getSysCustService().updateFeature(getSysCustVO());
			if (sysCustVO == null) {
				addActionError("修改客户特点失败!");
			} else {
				addActionMessage("成功修改客户特点!");
				setSysCustVO(sysCustVO);
			}
		}
		return "feature";
	}

	public String back() {
		log.debug("返回客户管理的主界面");
		setSysCustVO(null);
		return query();
	}
	
	public void searchJSON() {
		log.debug("");
		try {
//			String  i = ]}";
			StringBuffer buffer = new StringBuffer("{\"geonames\":[");
			PrintWriter writer = getResponse().getWriter();
			List<SysCustVO> sysCustVOs = getSysCustService().findAll();
			for (int i = 0; i < sysCustVOs.size(); i++) {
				SysCustVO sysCustVO = sysCustVOs.get(i);
				buffer.append("{\"custId\":\"").append(sysCustVO.getId()).append("\"}");
				if (i != (sysCustVOs.size() - 1)) {
					buffer.append(",");
				}
			}
			buffer.append("]}");
			writer.write(buffer.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//访问、设置属性
	
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

	public SysContactService getSysContactService() {
		return sysContactService;
	}

	public void setSysContactService(SysContactService sysContactService) {
		this.sysContactService = sysContactService;
	}

	public SysMaintainService getSysMaintainService() {
		return sysMaintainService;
	}

	public void setSysMaintainService(SysMaintainService sysMaintainService) {
		this.sysMaintainService = sysMaintainService;
	}

	public SysBusinessService getSysBusinessService() {
		return sysBusinessService;
	}

	public void setSysBusinessService(SysBusinessService sysBusinessService) {
		this.sysBusinessService = sysBusinessService;
	}

}
