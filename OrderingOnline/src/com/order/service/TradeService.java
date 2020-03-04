package com.order.service;

import java.util.List;

import com.order.po.Trade;
import com.order.po.TradeCustom;
import com.order.po.TradeCustomVo;
/**
 * 商品业务接口类
 * @author zlh
 *
 */
public interface TradeService {
	//添加商品信息
	public boolean saveTrade(Trade trade) throws Exception;
	
	//综合查询（systemId pager分页）商品信息
	public List<TradeCustom> queryTrades(TradeCustomVo tradeCustomVo)throws Exception;
	
	//根据systemId查询管理员商品信息总数
	public int queryTradesCount(Integer systemId)throws Exception;
	
	//根据商品id删除商品信息
	public boolean deleteTrade(Integer id) throws Exception;
	
	//根据商品id修改商品信息
	public boolean updateTrade(Integer id,TradeCustom tradeCustom) throws Exception;
}
