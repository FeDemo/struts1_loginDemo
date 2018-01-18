package com.demo.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.actionForm.DemoActionForm;

public interface DemoService {
	
	/**
	 * 登录校验
	 * @param from
	 * @param session
	 * @return
	 */
	boolean formLogin(DemoActionForm form,HttpServletRequest request,HttpServletResponse response);
}
