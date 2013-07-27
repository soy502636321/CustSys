package soy.common.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import soy.util.StringUtil;
import com.opensymphony.xwork2.util.ValueStack;

public class ButtonTag extends ComponentTagSupport {
	private String name;
	private String js;
	private String url;
	private String id;
	private String mode;
	private String location;
	private String type;

	@Override
	public Component getBean(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		return new ButtonService(stack, request, response);
	}

	@Override
	protected void populateParams() {
		ButtonService buttonService = (ButtonService) getComponent();
		ButtonsTag buttonsTag = (ButtonsTag) getParent();
		buttonService.setParentId(buttonsTag.getFunction());
		buttonService.setId(getId());
		buttonService.setName(getName());
		buttonService.setJs(getJs());
		buttonService.setUrl(getUrl());
		buttonService.setMode(getMode());
		buttonService.setLocation(getLocation());
		buttonService.setType(getType());
	}
	
	@Override
	public int doEndTag() throws JspException {
		ButtonService buttonService = (ButtonService) getComponent();
		ButtonsTag buttonsTag = (ButtonsTag) getParent();
		if (!StringUtil.isNull(buttonService.getResult())) {
			buttonsTag.getButtons().add(buttonService);
		}
		return super.doEndTag();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJs() {
		return js;
	}

	public void setJs(String js) {
		this.js = js;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
