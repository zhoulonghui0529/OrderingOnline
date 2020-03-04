//trades.html 自定义js方法实现

//表格图片显示
function picFormatter(value,row,index){
	if(value){
	    return '<img src='+value+' height=50>';
	} else {
	    return '';
	}
}
//表格商品状态显示
function isSaleFormatter(value,row,index){
	if(value==0){
		return '下架';
	} else if(value==1){
		return '上架';
	}
}

var url;
//打开添加商品窗口
function newTradeDlg(){
	$('#newDlg').dialog('open').dialog('setTitle','New Trade');
	$('#savefm').form('clear');
	url= "../../trades/saveTrade.action";
}
//打开编辑商品信息窗口
function editTradeDlg(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$('#editDlg').dialog('open').dialog('setTitle','Edit Trade');
		$('#edit_tradePicSource').filebox({
	        accept:'image/*',
	        buttonText:'浏览...',
	        prompt:'请选择图片文件...'
	    });
		$.ajax({
			url:"../../trades/queryTrades.action",
			type:"post",
			dataType:"json",
			data:{id:row.id},
			success:function(data){
				for(var i=0;i<data.rows.length;i++){
					$("#edit_id").val(data.rows[i].id);
					$("#edit_tradeName").val(data.rows[i].tradeName);
					$("#edit_tradePrice").val(data.rows[i].tradePrice);
					$("#edit_tradeStock").val(data.rows[i].tradeStock);
					if (data.rows[i].tradeIsSale == 0) {
					    $("input[name='tradeIsSale'][value='0']").attr("checked",true); 
				    }else if(data.rows[i].tradeIsSale == 1){
				        $("input[name='tradeIsSale'][value='1']").attr("checked",true); 
				    }   
					$("#edit_tradePic").attr("src", data.rows[i].tradePic);
					$("#edit_tradeDesc").val(data.rows[i].tradeDesc);
				}
				
			}
		});
		url="../../trades/updateTrade.action";
	}
}
//添加商品信息方法
function saveTrade(){
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
function editTrade(){
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
function removeTrade(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$.messager.confirm('Confirm','确定要删除这个商品吗?',function(r){
			if (r){
				$.post('../../trades/deleteTrade.action',{id:row.id},function(result){
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
//搜索
function doSearch(){
    $('#dg').datagrid('load',{
    	tradeName: $('#tradeName').val()
    });
}
//自定义输入框验证
$.extend($.fn.validatebox.defaults.rules, {
	//0和正整数正则验证
    intvalid: {
        validator: function (value, param) {
            return /^[0-9]\d*$/.test(value)
        },
        message: '只能输入0-9整数！'
    }
});
/* $.extend($.fn.validatebox.defaults.rules, {
    equals: {
		validator: function(value,param){
			return value == $(param[0]).val();验证两个输入框密码是否相同
		},
		message: 'Field do not match.'
    }
}); */