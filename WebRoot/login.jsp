<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>demo</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/style.css">

	<link rel="stylesheet" href="css/iconfont.css">
	<script type="text/javascript" src="js/jquery.js"></script>

  </head>
  
  <body>
    <div class="login-nav fix">

		<ul class="f-r">

			<li><a href="#">首页</a></li>

			<li><a href="#">协同</a></li>

			<li><a href="#">应用</a></li>

			<li><a href="#">案例</a></li>

			<li><a href="#">开发者</a></li>

			<li><a href="#">企业版</a></li>

		</ul>

	</div>

	<div class="login-banner"></div>


	<div class="login-box d1" >

		<div class="box-con d1" >

			<!-- 登录 start-->
			<form action="demoAction.do?method=login" method="post">
			<div class="login-con f-l d1" >

				<div class="form-group">
					<p> 手机号码:</p>
					<input type="text" placeholder="手机号码" id="phonenum" name="phonenum" onblur="verify.verifyPhonenum(this)">
					<span class="error-notic" id="numErr">手机号码格式不正确</span>
				</div>
				<div class="form-group">
					<p> 短信验证码:</p>
						<input type="text" placeholder="短信验证码" id="phoneCode" name="phoneCode"> <!--  onblur="verify.VerifyCode(this)"end-->
						<span class="error-notic" id="codeErr">验证码错误</span>
				</div>
				<div class="form-group">
					<button type="button" id="smsCodeBtn" class="ideal-file-upload" autocomplete="off" onclick="getSmsCode(this)" tag="60">获取验证码</button>
				</div>
				<div class="form-group">

					<button type="button" class="tran pr" onclick="fromSubmit()">
						<a class="tran">登录</a>

						<img class="loading" src="images/loading.gif" style="display:none" id="subImg">

					</button>

				</div>

			</div>

		 </form>
			<!-- 登录 end-->

		</div>

	</div>




<script>

var flag_code=false;
//验证
var verify={
		verifyPhonenum:function(_this){//验证手机号
			 $("#subImg").hide();
				var validateReg = /^1(3|4|5|7|8)\d{9}$/;
				var _value=$(_this).val();
				if(!validateReg.test(_value)){
					$("#numErr").show();
					return false;
				}else{
					$("#numErr").hide();
					return true;
				}
		},
		VerifyCode:function(_this){//验证验证码
				var _count="123456";
				var _value=$(_this).val();
				if(_value!=_count){
					$("#codeErr").show();
				}else{
					$("#codeErr").hide();
				}
		}
}

function getSmsCode(obj){//获得验证码
		var flag=verify.verifyPhonenum("#phonenum");
		if (flag) {
				
				$.ajax({
					type : "POST",
					url : "demoAction.do",
					data : "method=sendCode&phonenum="+$('#phonenum').val(),
					async : true,
					success : function(result) {
						if(result=="200"){
							setTimeout("btn()","1000");
							$("#smsCodeBtn").attr("disabled","disabled");
						}else{
							//TODO
						}
					}
				});
		}
}

function btn(){
	var btn = $("#smsCodeBtn");
	btn.attr("tag", btn.attr("tag")-1);
	btn.text("重新获取验证码("+btn.attr("tag")+")");
	if(btn.attr("tag")>0){
		setTimeout("btn()","1000");
		flag_code=true;
	}else{
		flag_code=false;
		$("#smsCodeBtn").text("重新获取验证码");
		$("#smsCodeBtn").attr("tag","60");
		$("#smsCodeBtn").removeAttr("disabled");
	}
}

function fromSubmit(){
	var flag1=verify.verifyPhonenum("#phonenum");
	$("#subImg").show();
	if (flag1&flag_code) {
		$("form:first").submit();
	}
}
</script>

  </body>
</html>
