package com.demo.actionForm;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class DemoActionForm extends ActionForm{

	private String phonenum="";
	private String phoneCode="";
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getPhoneCode() {
		return phoneCode;
	}
	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}
	

}
