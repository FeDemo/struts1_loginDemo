package com.demo.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.demo.actionForm.DemoActionForm;
import com.demo.service.DemoService;
import com.demo.service.impl.DemoServiceImpl;
import com.demo.utils.FeBaseAction;
import com.demo.utils.NoteI;
import com.demo.utils.NoteImpl;


public class DemoAction extends FeBaseAction{
	DemoService service=new DemoServiceImpl();
	NoteI note=new NoteImpl();
	
	/**
	 * 登录校验与跳转
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward login(final ActionMapping mapping,
			final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		if(getCookie("login",request).equals("1")){
			//return mapping.findForward("ok");
			outXmlString("ok", response);
			return null;
		}
		//校验验证码
		if (service.formLogin((DemoActionForm)form,request,response)) {
			//return mapping.findForward("ok");
			outXmlString("ok", response);
			return null;
		}else{
			return mapping.findForward("login");
		}
		
	}
	
	
	/**
	 * 根据手机号发送验证码
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public void sendCode(final ActionMapping mapping,
			final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		DemoActionForm from=(DemoActionForm)form;
		String phonenum=from.getPhonenum();
		request.getSession().setAttribute("pnonenum", phonenum);
		try {
			String code=note.getCode(phonenum);
			request.getSession().setAttribute("code", code);
			outXmlString("200", response);
		} catch (Exception e) {
			request.getSession().setAttribute("code", "");
			e.printStackTrace();
			outXmlString("500", response);
		}
		
	}
	
	
	/****************************************************************************************************************************************************/
}
