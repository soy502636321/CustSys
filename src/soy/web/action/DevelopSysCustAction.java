package soy.web.action;

import soy.util.ForwardUtil;
import soy.util.PaginatedList;

public class DevelopSysCustAction extends PublicSysCustAction {
	@Override
	public String query() {
		PaginatedList list = new PaginatedList(getPage());
		list = getSysCustService().findDevelop(list, getSysCustVO());
		setList(list);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}
}
