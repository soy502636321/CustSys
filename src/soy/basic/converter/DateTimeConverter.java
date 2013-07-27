package soy.basic.converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import soy.util.DateUtil;
import soy.util.StringUtil;
import soy.util.SystemUtil;

public class DateTimeConverter extends StrutsTypeConverter {
	private static String DATE_TIME = "yyyy-MM-dd HH:mm";
	private static String DATE = "yyyy-MM-dd";

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		Date date = null;
		if (!SystemUtil.isNull(arg1)) {
			if (!StringUtil.isNull(arg1[0])) {
				SimpleDateFormat dateTime = new SimpleDateFormat(DATE_TIME);
				try {
					date = dateTime.parse(arg1[0]);
				} catch (Exception e) {
					date = null;
				}
				if (date == null) {
					SimpleDateFormat dateFormat = new SimpleDateFormat(DATE);
					try {
						date = dateFormat.parse(arg1[0]);
					} catch (Exception e) {
						date = null;
					}
				}
			}
		}
		return date;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		return DateUtil.getTime((Date)arg1);
	}
		
}
