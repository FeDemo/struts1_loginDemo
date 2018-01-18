package com.demo.service.impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.demo.actionForm.DemoActionForm;
import com.demo.service.DemoService;
import com.demo.utils.FeUtil;

public class DemoServiceImpl implements DemoService{

	@Override
	public boolean formLogin(DemoActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		boolean flag=(form.getPhonenum().equals(session.getAttribute("pnonenum")))&&
				(form.getPhoneCode().equals(session.getAttribute("code")));
		session.setAttribute("pnonenum", FeUtil.DateTimeString());
		session.setAttribute("code", FeUtil.DateTimeString());
		if (flag) {
			Cookie cookie = new Cookie("login", "1");
			response.addCookie(cookie);
		}else{
			Cookie cookie = new Cookie("login", "0");
			response.addCookie(cookie);
		}
		return flag;
	}

}
