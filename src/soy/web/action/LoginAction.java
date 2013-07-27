package soy.web.action;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.SysFunction;
import soy.basic.database.entity.SysUser;
import soy.basic.vo.LoginUserVO;
import soy.util.ForwardUtil;
import soy.util.GlobalUtil;
import soy.util.PasswordControl;
import soy.web.service.SysUserService;

public class LoginAction extends BaseAction {

	private static final Logger log = LoggerFactory
			.getLogger(LoginAction.class);

	private SysUserService sysUserService;
	private String username;
	private String password;

	// 登录：检查用户名跟密码
	public String login() throws Exception {

		log.debug("登录的用户名:" + getUsername() + ",密码:" + getPassword());

		// 清除Session缓存
		this.getSession().remove(GlobalUtil.LOGINUSER);
		System.out.println("用户名:" + getUsername());
		System.out.println("密码:" + getPassword());

		// 获得登录用户
		SysUser user = sysUserService.login(getUsername());
		if (user == null) {
			addActionError("用户名不存在！");
			return ForwardUtil.FORWARD_FAIL;
		}
		if (!PasswordControl.EncryptePassword(getPassword()).equals(
				user.getPassword())) {
			addActionError("密码不准确！");
			return ForwardUtil.FORWARD_FAIL;
		}

		if (isNull(user.getUserState())
				|| !user.getUserState().equals(GlobalUtil.isNormal)) {
			addActionError("该用户状态被禁用或未启用！");
			return ForwardUtil.FORWARD_FAIL;
		}

		// 初始化用户
		LoginUserVO userVO = new LoginUserVO();
		userVO.setUser(user);

		// 获得用户的权限功能
		if (userVO.isAdmin()) {
			log.debug("登录的用户是管理员");
			userVO.setFunctionList(sysUserService.findAllSysFunction());
		} else {
			log.debug("登录的用户是普通用户");
			List list = new ArrayList();
			list.addAll(user.getSysRole().getRoleFunctions());
			userVO.setFunctionList(list);
		}

		// 获得功能列表
		this.getSession().put(GlobalUtil.MENUSTRING, getMenuStr(userVO));

		this.getSession().put(GlobalUtil.LOGINUSER, userVO);

		return ForwardUtil.FORWARD_SUCCESS;
	}

	// 退出系统
	public String loginOut() throws Exception {
		// 删除缓存
		this.getSession().remove(GlobalUtil.LOGINUSER);
		return ForwardUtil.FORWARD_LOGIN_PAGE;
	}

	// 获得功能列表字符串
	public String getMenuStr(LoginUserVO userVO) {
		String contextPath = this.getRequest().getContextPath();
		String nodes = "";
		for (SysFunction function : userVO.getMenuFunctionList()) {
			Integer functionID = function.getId();
			Integer parentID = new Integer(0);
			String functionName = function.getFunctionName();
			if (function.getSysFunction() != null) {
				parentID = function.getSysFunction().getId();
			}
			String url = function.getFunctionUrl();
			String nodeUrl = "";
			if (url != null && !url.equals("")) {
				nodeUrl = ",url:\"" + contextPath + url + "\", target:\"I1\"";
			}
			nodes += "{ id:" + Double.valueOf(functionID) + ", pId:"
					+ Double.valueOf(parentID) + ", name:\"" + functionName
					+ "\"" + nodeUrl + "},";
		}

		if (nodes.length() > 0)
			nodes = "[ " + nodes.substring(0, nodes.length() - 1) + " ]";

		return nodes;
	}

	public SysUserService getSysUserService() {
		return sysUserService;
	}

	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
