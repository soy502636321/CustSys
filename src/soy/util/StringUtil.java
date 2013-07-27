package soy.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

public class StringUtil {
	
	/**
	 * 判断字符串是否为空或者长度为0
	 * @param value
	 * @return
	 */
	public static boolean isNull(String value) {
		return (null == value || value.trim().length() == 0);
	}

	/**
	 * 判断字符串是否是一个整型数字的字符串
	 * @param value
	 * @return
	 */
	public static boolean isInteger(String value) {
		try {
			Integer.valueOf(value);
			return true;
		} catch (NumberFormatException e) {
		}
		return false;
	}

	public static boolean isDouble(String quantityString) {
		try {
			Double.valueOf(quantityString);
			return true;
		} catch (NumberFormatException e) {
		}
		return false;
	}

}
