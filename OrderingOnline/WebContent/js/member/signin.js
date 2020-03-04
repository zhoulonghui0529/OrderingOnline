//会员登录
function memberSignin(){
	$('#signinfm').form('submit',{
			url: "../../memberSignin.action",
			onSubmit: function(){
				return $(this).form('validate');
		},
		success: function(result){
			if (result=="success"){
				alert("注册成功，确定将跳转到登录页面。");
				location.href="login.html";
			}else {
				alert("注册失败！");
			}
		}
	});
}
$.extend($.fn.validatebox.defaults.rules, {
    equals: {
		validator: function(value,param){
			return value == $(param[0]).val();//验证两个输入框密码是否相同
		},
		message: '两次输入的密码不相同.'
    }
});