package soy.basic.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import soy.basic.database.entity.SysFunction;
import soy.basic.database.entity.SysUser;
import soy.util.GlobalUtil;
import soy.util.PropsParser;




public class LoginUserVO{
	
	// admin
	public static final String SYSTEMADMIN = "SYSTEM_ADMIN";
	
	// 用户信息
	private SysUser user;
	
	// Function
	private List<SysFunction> functionList;
	
	// menu Function List
	private List<SysFunction> menuFunctionList;
	
	// not menu Function List
	private List<SysFunction> otherFunctionList;
	
	
	/**
	 * check is admin
	 */
	public boolean isAdmin(){
		try {
			Properties props = PropsParser.getProperties();
			if(getUser().getUsername().equals(props.getProperty(SYSTEMADMIN))){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public void setFunctionList(List<SysFunction> functionList) {
		this.functionList = functionList;
		
		// init menuFunctionList
		menuFunctionList = new ArrayList<SysFunction>();
		otherFunctionList = new ArrayList<SysFunction>();
		for (SysFunction function : functionList) {
			if(GlobalUtil.isMenu.equals(function.getFunctionType())){
				menuFunctionList.add(function);
			}else{
				otherFunctionList.add(function);
			}
			
		}
	}
	

	public SysUser getUser() {
		return user;
	}
	public List<SysFunction> getFunctionList() {
		return functionList;
	}
	public List<SysFunction> getMenuFunctionList() {
		return menuFunctionList;
	}
	public List<SysFunction> getOtherFunctionList() {
		return otherFunctionList;
	}
	public void setUser(SysUser user) {
		this.user = user;
	}
	public void setMenuFunctionList(List<SysFunction> menuFunctionList) {
		this.menuFunctionList = menuFunctionList;
	}
	public void setOtherFunctionList(List<SysFunction> otherFunctionList) {
		this.otherFunctionList = otherFunctionList;
	}

}
