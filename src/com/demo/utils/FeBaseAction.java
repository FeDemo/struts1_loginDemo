package com.demo.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.actions.DispatchAction;




public class FeBaseAction extends DispatchAction{
	
	/**
	 * 输出String
	 * @param str
	 * @param response
	 */
	public void outXmlString(String str, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		outString(str, response);
	}
	
	/**
	 * 根据Cookie的名称获得Cookie的值
	 * @param CookieName
	 * @param request
	 * @return
	 */
	public String getCookie(String CookieName,HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		 String city = "";
	    //如果浏览器中存在Cookie
	    if (cookies != null && cookies.length > 0) {
	        //遍历所有Cookie
	        for(Cookie cookie: cookies) {
	            //找到name为city的Cookie
	            if (cookie.getName().equals(CookieName)) {
	                //使用URLDecode.decode()解码,防止中文乱码
	                try {
						city = URLDecoder.decode(cookie.getValue(), "utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
	            }
	        }
	    }
		return city;
	}
	
	
	
	
	
	
	
	
	private void outString(String str, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			out.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}




