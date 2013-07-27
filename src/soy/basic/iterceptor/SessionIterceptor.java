package soy.basic.iterceptor;

import java.util.Map;

import soy.util.GlobalUtil;
import soy.web.action.LoginAction;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


public class SessionIterceptor extends AbstractInterceptor {
	
	public static final String LOGIN_PAGE="loginPage";
	
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {

//		System.out.println("begin check login interceptor!");
		Object action = actionInvocation.getAction();
		if(action instanceof LoginAction){
//			System.out.println("exit check login, because this is login action.");
			return actionInvocation.invoke();
		}
		Map session=actionInvocation.getInvocationContext().getSession();
//		Map kjj= ActionContext.getContext().getSession();
		Object login = session.get(GlobalUtil.LOGINUSER);
		if(login !=null){
//			System.out.println("already login!");
			return actionInvocation.invoke();
		}else{
//			System.out.println("no login,forward login page!");
			return LOGIN_PAGE;
		}
		
	}

}
