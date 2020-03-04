package com.order.mapper;

import java.util.List;

import com.order.po.Trade;
import com.order.po.TradeCustom;
import com.order.po.TradeCustomVo;
/**
 * 商品mapper接口
 * @author zlh
 *
 */
public interface TradeMapper {
	//插入商品信息
	public int insertTrade(Trade trade) throws Exception;
	
	//查询商品信息
	public List<TradeCustom> findTrades(TradeCustomVo tradeCustomVo) throws Exception;
	
	//查询管理员商品总数
	public int findTradesCount(Integer systemId) throws Exception;
	
	//删除商品信息
	public int deleteTrade(Integer id) throws Exception;
	
	//修改商品信息
	public int updateTrade(TradeCustom tradeCustom) throws Exception;
}
