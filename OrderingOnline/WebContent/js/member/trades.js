$(function(){
	queryTrade();
});
function queryTrade(){
	$.ajax({
		url:"../../trades/queryTrades.action",
		type:"POST",
		dataType:"JSON",
		data:{},
		success:function(data){
			var trades=data["rows"];
			for(var trade in trades){
				$("#content").prepend("<div id='trade"+trades[trade].id+"' class='trade'>" 
						//图片展示div
						+"<div class='tradepic'>"
							+"<img src='"+trades[trade].tradePic+"'/>"
						+"</div>"
						//基本信息div
						+"<div class='tradetext'>"
							+"<p>"+trades[trade].tradeName+"</p><br/>"
							+"<p style='font-size:12px'>￥："+trades[trade].tradePrice+"元</p><br/>"
						+"</div>"
						+"<div class='tradeop'>"
							+"<input type='button' value='加入购物车' href='#' onclick='addTradeCar("+trades[trade].id+",\""+trades[trade].tradeName+"\","+trades[trade].tradePrice+")'>"
						+"</div>"
				+"</div>");
			}
		}
	});
}
//添加购物车
function addTradeCar(tradeId,tradeName,tradePrice){
	$.ajax({
		url:"../../car/saveCar.action",
		type:"post",
		data:{tradeId:tradeId,tradeName:tradeName,tradePrice:tradePrice},
		success:function(result){
			if(result=="success"){
				alert("添加成功");
			}else{
				alert("添加失败");
			}
		}
	});
}