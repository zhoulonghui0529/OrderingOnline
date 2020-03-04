package com.order.po;
/**
 * 商品信息表po类
 * @author zlh
 *
 */
public class Trade {
	//基本数据类型
	private Integer id;
	private Integer systemId;
	private String tradeName;
	private Integer tradePrice;
	private Integer tradeStock;
	private Integer tradeIsSale;//上架：1 下架：0
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getSystemId() {
		return systemId;
	}
	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}
	public String getTradeName() {
		return tradeName;
	}
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	public Integer getTradePrice() {
		return tradePrice;
	}
	public void setTradePrice(Integer tradePrice) {
		this.tradePrice = tradePrice;
	}
	public Integer getTradeStock() {
		return tradeStock;
	}
	public void setTradeStock(Integer tradeStock) {
		this.tradeStock = tradeStock;
	}
	public Integer getTradeIsSale() {
		return tradeIsSale;
	}
	public void setTradeIsSale(Integer tradeIsSale) {
		this.tradeIsSale = tradeIsSale;
	}
	@Override
	public String toString() {
		return "Trade [id=" + id + ", systemId=" + systemId + ", tradeName=" + tradeName + ", tradePrice=" + tradePrice
				+ ", tradeStock=" + tradeStock + ", tradeIsSale=" + tradeIsSale + "]";
	}
}
