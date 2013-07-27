package soy.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 *  date util
 *  autor:rogr
 */
public class DateUtil{

	//default date format
	private final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

	//default time format
	private final static String DEFAULT_TIME_FORMAT = DEFAULT_DATE_FORMAT + " HH:mm";

	//default date format
	private final static String DEFAULT_DATEANDWEEK_FORMAT = "yyyy-MM-dd EEEE";
	
	//default output format: yyyy-MM-dd
	private final static DateFormat dfDate = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
	
	
	//default output format: yyyy-MM-dd HH:mm:ss
	private final static DateFormat dfDateTime = new SimpleDateFormat(DEFAULT_TIME_FORMAT);
	
	//default output format: yyyy-MM-dd 星期一
	private final static DateFormat dfDateAndWeek = 
			new SimpleDateFormat(DEFAULT_DATEANDWEEK_FORMAT,Locale.CHINA);

	/**
	 * @return get now time format: yyyy-MM-dd
	 */
	public static String getDate(){
		return dfDate.format(new Date());
	}
	
	/**
	 * @return format: yyyy-MM-dd
	 */
	public static String getDate(Date date){
		return dfDate.format(date);
	}
	
	/**
	 * @return get now time format: yyyy-MM-dd HH:mm:ss
	 */
	public static String getTime(){
		return dfDateTime.format(new Date());
	}
	
	/**
	 * @return format: yyyy-MM-dd HH:mm
	 */
	public static String getTime(Date date){
		return dfDateTime.format(date);
	}
	
	/**
	 * @return get now time format: yyyy-MM-dd 星期一
	 */
	public static String getDateAndWeek(){
		Date date = new Date();
		return dfDateAndWeek.format(date);
	}

	
	public static void main(String[] args) {
		System.out.println("getDate():"+getDateAndWeek());
	}
}
