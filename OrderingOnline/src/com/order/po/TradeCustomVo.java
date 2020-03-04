package com.order.po;
/**
 * 商品信息综合查询
 * @author zlh
 *
 */

import com.order.common.entity.Pager;

public class TradeCustomVo {
	//定义管理员po类扩展类属性
	private TradeCustom tradesCustom;
	
	//定义管理员po类属性
	private Trade trade;
	
	//分页参数类属性
	private Pager pager;
	
	//管理员id
	private Integer systemId;

	public TradeCustom getTradesCustom() {
		return tradesCustom;
	}

	public void setTradesCustom(TradeCustom tradesCustom) {
		this.tradesCustom = tradesCustom;
	}

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public Integer getSystemId() {
		return systemId;
	}

	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}
	
	//定义其他查询条件属性
	
}
