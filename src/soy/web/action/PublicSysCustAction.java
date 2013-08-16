package soy.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	public String toPrivate() {
		log.debug("");
		if (!SystemUtil.isNull(getCbId())) {
			getSysCustService().toPrivate(getCbId(), getSysCustVO());
		} else {
			addActionError("请先选择客户!");
		}
		return query();
	}
}


