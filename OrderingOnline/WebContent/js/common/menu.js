$(function(){
	$("a[title]").click(function(){
		var text = $(this).text();
		var href = $(this).attr("title");
		//判断当前右边是否已有相应的tab
		if($("#tt").tabs("exists", text)) {
			$("#tt").tabs("select", text);
		} else {
			//如果没有则创建一个新的tab，否则切换到当前tag
			$("#tt").tabs("add",{
				title:text,
				closable:true,
				content:'<iframe src='+href+' frameborder="0" width="100%" height="100%" />'
			});
		}
		
	});
});