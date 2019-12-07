package com.neo.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonFunctions {
	/**
	 * 验证为传入参数为空的公用方法
	 * 
	 * @param str
	 * @return
	 */
	public static boolean checkNull(String str) {
		if ("".equals(str) || null == str) {
			return false;
		}
		str = removeSpaces(str);
		if ("".equals(str)) {
			return false;
		}
		return true;
	}

	/**
	 * 去掉输入字符串两边的全角和半角空格
	 * 
	 * @param str
	 * @return
	 */
	public static String removeSpaces(String str) {
		if (str != null) {
			str = str.replaceAll("[ |　]", " ").trim();
		}
		return str;
	}

	/**
	 * encode json 公用方法
	 * 
	 * @param json
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String setJson(String json) throws UnsupportedEncodingException {
		return json = URLEncoder.encode(json, "UTF-8");
	}

	/**
	 * 序列化对象方法
	 * 
	 * @param mapper
	 * @param collectionClass
	 * @param elementClasses
	 * @return
	 */
	public static JavaType getCollectionType(ObjectMapper mapper, Class<?> collectionClass,
			Class<?>... elementClasses) {
		return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}

	/**
	 * 给定开始和结束时间，计算总天数
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws ParseException
	 */
	public static int caculateTotalTime(String startTime, String endTime) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		Date date = formatter.parse(startTime);
		long ts = date.getTime();
		date1 = formatter.parse(endTime);
		long ts1 = date1.getTime();
		long ts2 = ts1 - ts;
		int totalTime = 0;
		totalTime = (int) (ts2 / (24 * 3600 * 1000) + 1);
		return totalTime;
	}

	/**
	 * 给一个开始的日期得到加一天后的字符串
	 * 
	 * @param startDate
	 * @return
	 * @throws ParseException
	 */
	public static String addDate(String startDate) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(simpleDateFormat.parse(startDate));
		calendar.add(Calendar.DATE, 1); // 把日期往后增加一天,整数 往后推,负数往前移动
		String end_date = simpleDateFormat.format(calendar.getTime()); // 这个时间就是日期往后推一天的结果
		return end_date;
	}

	/**
	 * 给一个开始的日期和天数得到对应相加后日期字符串
	 * 
	 * @param startDate
	 * @return
	 * @throws ParseException
	 */
	public static String addDayTodate(String startDate, int day) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(simpleDateFormat.parse(startDate));
		calendar.add(Calendar.DATE, day); // 把日期往后增加天数,整数 往后推,负数往前移动
		String end_date = simpleDateFormat.format(calendar.getTime()); // 这个时间就是日期往后推天的结果
		return end_date;
	}

	

	// 将字符串按逗号切割成带单引号的数组字符串
	public static String strConverterStr(String str) {
		// 返回的新字符串
		String new_str = "";
		String[] new_string;
		new_string = str.split(","); // 分割字符串
		// 普通 for 循环
		for (int i = 0; i < new_string.length; i++) {
			if (i == new_string.length - 1) {
				new_str += "'" + new_string[i] + "'";
			} else {
				new_str += "'" + new_string[i] + "'" + ",";
			}
		}
		return new_str;
	}

	// 将集合拼成逗号分隔的字符串
	public static String listConverterStr(List<String> str) {
		// 返回的新字符串
		String new_str = "";
		// 普通 for 循环
		for (int i = 0; i < str.size(); i++) {
			if (i == str.size() - 1) {
				new_str += "'" + str.get(i) + "'";
			} else {
				new_str += "'" + str.get(i) + "'" + ",";
			}
		}
		return new_str;
	}

}
