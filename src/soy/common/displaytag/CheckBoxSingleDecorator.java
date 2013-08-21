package soy.common.displaytag;

import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;

/**
 * 
 * @author XiaoLiang·Hu
 *
 */
public class CheckBoxSingleDecorator implements DisplaytagColumnDecorator {
	public Object decorate(Object columnValue, PageContext pageContext,
			MediaTypeEnum media) throws DecoratorException {
		if (columnValue == null) {
			return "";
		}
		String id = columnValue.toString();
		StringBuffer sb = new StringBuffer();
		sb.append("<input type=\"checkbox\" name=\"cbId2\" class=\"checkbox\" ");
		sb.append(" value=\"" + id
				+ "\" onClick=\"changeCheckBoxSingle(cbId2, this)\">");
		return sb.toString();
	}
}
