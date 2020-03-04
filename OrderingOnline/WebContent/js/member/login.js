//会员登录
function memberLogin(){
	$('#loginfm').form('submit',{
			url: "../../memberLogin.action",
			onSubmit: function(){
				return $(this).form('validate');
		},
		success: function(result){
			if (result=="success"){
				alert("登录成功，确定将跳转到主页面。");
				location.href="index.html";
			}else {
				alert("账号或密码错误，请重新登入！");
			}
		}
	});
}
$(function(){
	$("#systemList").combobox({
		width: "150",
		height: "25",
		valueField: "id",
		textField: "systemName",
		multiple: false, //可多选
		editable: false, //不可编辑
		method: "post",
		url:"../../querySystems.action"
		//在下拉框中的第一行加一个请选择行
		
	});
});