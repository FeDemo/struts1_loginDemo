package com.demo.utils;


/**
 * 
 * @author Fe
 * @version 1.0
 */
public class FeUtil {
	private FeUtil(){}
	
	/* 
	 * String start
	 */
	
	/**
	 * 根据指定正则,拆分此字符串
	 * 返回数组
	 * @param data 待拆分的字符串
	 * @param split 根据此正则拆分
	 * @return
	 */
	public static String[] strSplit(String data,String split){
		String[] dateArr=data.split(split);
		return dateArr;
	}
	
	/*
	 * Date start
	 */
	
	/**
	 * 获得当前String类型的时间戳
	 * @return
	 */
	public  static String DateTimeString(){
		String time=Long.toString(System.currentTimeMillis());
		return time;
	}
}
