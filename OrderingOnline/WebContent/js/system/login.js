function Systemlogin(){
	var sysname=$("input[name='sysname']").val();
	var syspwd=$("input[name='syspwd']").val();
	var loginData={'systemCustom':{'systemName':sysname,'systemPwd':syspwd}};
	$.ajax({
		type:"post",
		url:"../../systemLogin.action",
		data:JSON.stringify(loginData),
		contentType: "application/json;charset=UTF-8",
		success:function(msg){
			if(msg=="success"){
				alert("登录成功，确定将跳转到主页面。");
				location.href="index.html";
			}
			if(msg=="error")
				alert("账号或密码错误，请重新登入！");
		}
	});
}