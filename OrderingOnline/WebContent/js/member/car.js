
var url;
//打开修改商品数量窗口
function editCarDlg(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$('#editDlg').dialog('open').dialog('setTitle','Edit TradeNum');
		$('#editfm').form('load',row);
		url="../../car/updateCar.action";
	}
}
//修改商品信息方法
function editCar(){
	$('#editfm').form('submit',{
			url:url,
			onSubmit: function(){
				return $(this).form('validate');
		},
		success: function(result){
			if (result=="success"){
				$('#editDlg').dialog('close');		// close the dialog
				$('#dg').datagrid('reload');	// reload the user data
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
//移除商品信息方法
function removeCar(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$.messager.confirm('Confirm','确定要删除这个商品吗?',function(r){
			if (r){
				$.post('../../car/deleteCar.action',{id:row.id},function(result){
					if (result=="success"){
						alert("删除成功");
						$('#dg').datagrid('reload');	// reload the user data
					} else {
						$.messager.show({	// show error message
							title: 'Error',
							msg: result
						});
					}
				});
			}
		});
	}
}
//自定义输入框验证
$.extend($.fn.validatebox.defaults.rules, {
	//0和正整数正则验证
    intvalid: {
        validator: function (value, param) {
            return /^[1-9]\d*$/.test(value)
        },
        message: '只能输入1-9整数！'
    }
});