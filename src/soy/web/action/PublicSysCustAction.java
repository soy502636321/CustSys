package soy.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.vo.SysCustVO;
import soy.util.ForwardUtil;
import soy.util.PaginatedList;
import soy.util.SystemUtil;

public class PublicSysCustAction extends SysCustAction {
	private static final Logger log = LoggerFactory.getLogger(PublicSysCustAction.class);
	
	@Override
	public String query() {
		log.debug("");
		PaginatedList list = new PaginatedList(getPage());
		list = getSysCustService().findPublic(list, getSysCustVO());
		setList(list);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}
	
	@Override
	public String save() {
		log.debug("ACTION:开始增加客户");
		if (getSysCustVO() == null) {
			addActionError("增加客户失败!");
		} else {
			SysCustVO sysCustVO = getSysCustService().save(getSysCustVO(), null);
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
	
	public String toPrivate() {
		log.debug("开始将客户放入我的客户");
		if (!SystemUtil.isNull(getCbId())) {
			getSysCustService().toPrivate(getCbId(), getLoginSysUserVO());
			addActionMessage("成功将客户放入我的客户!");
		} else {
			addActionError("请先选择客户!");
		}
		return query();
	}
}


