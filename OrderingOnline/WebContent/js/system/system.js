//页面加载
$(function(){
	querySystem();
});
function querySystem(){
	$.ajax({
		url:"../../querySystem.action",
		data:{},
		dataType:"json",
		type:"post",
		success:function(result){
			for(var i=0;i<result.length;i++){
				$("#systemName").val(result[i].systemName);
				$("#systemPwd").val(result[i].systemPwd);
			}
			
		}
	});
}

var url;
//打开修改账户名窗口
function openNameDlg(){
	$('#nameDlg').dialog('open').dialog('setTitle','New Name');
	$('#namefm').form('clear');
	url= "../../editSystem.action";
}
//打开修改密码窗口
function openPwdDlg(){
	$('#pwdDlg').dialog('open').dialog('setTitle','Edit Password');
	$('#pwdfm').form('clear');
	url= "../../editSystem.action";
}
//修改账户名
function saveName(){
	$('#namefm').form('submit',{
			url: url,
			onSubmit: function(){
				return $(this).form('validate');
		},
		success: function(result){
			if (result=="success"){
				$('#nameDlg').dialog('close');		// close the dialog
				querySystem();
			}else {
				//右下角弹出插入错误信息窗口
				$.messager.show({
					title: 'Error',
					msg: result
				});
			}
		}
	});
}
//修改商品信息方法
function savePwd(){
	$('#pwdfm').form('submit',{
			url:url,
			onSubmit: function(){
				return $(this).form('validate');
		},
		success: function(result){
			if (result=="success"){
				$('#pwdDlg').dialog('close');		// close the dialog
				querySystem();
			}else {
				//右下角弹出插入错误信息窗口
				$.messager.show({
					title: 'Error',
					msg: result
				});
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