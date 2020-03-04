package com.order.po;
/**
 * 商品信息表po类扩展类
 * @author zlh
 *
 */
public class TradeCustom extends Trade{
	//添加了大格式数据 text
	private String tradePic;//商品图片 存储图片地址
	private String tradeDesc;//商品描述信息
	public String getTradePic() {
		return tradePic;
	}
	public void setTradePic(String tradePic) {
		this.tradePic = tradePic;
	}
	public String getTradeDesc() {
		return tradeDesc;
	}
	public void setTradeDesc(String tradeDesc) {
		this.tradeDesc = tradeDesc;
	}
	@Override
	public String toString() {
		return "TradeCustom [tradePic=" + tradePic + ", tradeDesc=" + tradeDesc + "]";
	}
	
	
}
