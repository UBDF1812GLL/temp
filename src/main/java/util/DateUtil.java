package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 用某种时间方法，格式化字符串
	 * @param date
	 * @param formatStr
	 * @return
	 */
	
	public static String formatDate(Date date,String formatStr) {
		
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		String result = sdf.format(date);
		return result;
	}
	
	/**
	 * 按给定格式把指定的字符串转换成时间
	 * @param formatStr
	 * @param value
	 * @return
	 */
	
	public static Date parseDate(String formatStr,String value) {
		
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		Date date = null;
		
		try {
			return sdf.parse(value);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static void main(String[] args) {
		System.out.println(formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
		System.out.println(parseDate("yyyy-MM-dd HH:mm:ss","2019-09-18 04:38:23"));
	}

}
