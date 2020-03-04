package com.order.po;
/**
 * 购物车
 * @author zlh
 *
 */
public class Car {
	private Integer id;
	private Integer memberId;
	private Integer tradeId;
	private String tradeName;
	private Integer tradePrice;
	private Integer tradeNum;//商品数量
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemeberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getTradeId() {
		return tradeId;
	}
	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
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
	public Integer getTradeNum() {
		return tradeNum;
	}
	public void setTradeNum(Integer tradeNum) {
		this.tradeNum = tradeNum;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", memeberId=" + memberId + ", tradeId=" + tradeId + ", tradeName=" + tradeName
				+ ", tradePrice=" + tradePrice + ", tradeNum=" + tradeNum + "]";
	}
	
}
