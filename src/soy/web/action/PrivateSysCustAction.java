package soy.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.util.ForwardUtil;
import soy.util.PaginatedList;

public class PrivateSysCustAction extends SysCustAction {
	private static final Logger log = LoggerFactory.getLogger(PrivateSysCustAction.class);
	
	public String query() {
		log.debug("");
		PaginatedList list = new PaginatedList(getPage());
		list = getSysCustService().findPrivate(list, getSysCustVO(), getLoginSysUserVO());
		setList(list);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}
	
	public String toPublic() {
		log.debug("");
		return query();
	}
}
