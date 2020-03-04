//trades.html 自定义js方法实现

//表格包间状态显示
function roomStateFormatter(value,row,index){
	if(value == 0){
		return '空闲';
	}else if(value == 1){
		return '繁忙';
	}
}
//表格房间类型显示
function roomTypeFormatter(value,row,index){
	if(value==1){
		return '小包';
	}else if(value==2){
		return '中包';
	}else if(value==3){
		return '大包';
	}
}

var url;
//打开添加包间窗口
function newRoomDlg(){
	$('#newDlg').dialog('open').dialog('setTitle','New Room');
	$('#savefm').form('clear');
	url= "../../room/saveRoom.action";
}
//打开编辑商品信息窗口
function editRoomDlg(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$('#editDlg').dialog('open').dialog('setTitle','Edit Room');
		$('#editfm').form('load',row);
		url="../../room/editRoom.action";
	}
}
//添加商品信息方法
function saveRoom(){
	$('#savefm').form('submit',{
			url: url,
			onSubmit: function(){
				return $(this).form('validate');
		},
		success: function(result){
			if (result=="success"){
				$('#newDlg').dialog('close');		// close the dialog
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
//修改商品信息方法
function editRoom(){
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
function removeRoom(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$.messager.confirm('Confirm','确定要删除这个商品吗?',function(r){
			if (r){
				$.post('../../room/deleteRoom.action',{id:row.id},function(result){
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
            return /^[0-9]\d*$/.test(value)
        },
        message: '只能输入整数！'
    }
});