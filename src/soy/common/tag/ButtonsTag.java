package soy.common.tag;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import soy.util.StringUtil;
import com.opensymphony.xwork2.util.ValueStack;

public class ButtonsTag extends ComponentTagSupport {
	private String function;
	private String id;
	private List buttons;

	@Override
	public int doStartTag() throws JspException {
		setButtons(new ArrayList());
		return super.doStartTag();
	}

	@Override
	public int doEndTag() throws JspException {
		ButtonsService buttonsService = (ButtonsService) getComponent();
		buttonsService.setButtons(getButtons());
		return super.doEndTag();
	}

	@Override
	public Component getBean(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		return new ButtonsService(stack, request, response);
	}

	@Override
	protected void populateParams() {
		ButtonsService buttonsService = (ButtonsService) getComponent();
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List getButtons() {
		return buttons;
	}

	public void setButtons(List buttons) {
		this.buttons = buttons;
	}

}
