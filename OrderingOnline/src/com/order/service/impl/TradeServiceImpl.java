package com.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.order.exception.ProjectException;
import com.order.mapper.TradeMapper;
import com.order.po.Trade;
import com.order.po.TradeCustom;
import com.order.po.TradeCustomVo;
import com.order.service.TradeService;
/**
 * 商品业务接口实现类
 * @author zlh
 *
 */
public class TradeServiceImpl implements TradeService {
	//自动加载tradeMapperbean属性
	@Autowired
	private TradeMapper tradeMapper;
	//添加商品信息
	@Override
	public boolean saveTrade(Trade trade) throws Exception {
		// TODO Auto-generated method stub
		if (trade!=null) {
			//三个必须传递的参数
			if (trade.getTradeName()!=null&&trade.getTradePrice()!=null&&trade.getTradeStock()!=null&&trade.getSystemId()!=null) {
				//插入成功返回插入商品 id
				if (tradeMapper.insertTrade(trade)>0) {
					return true;
				}
			}else {
				throw new ProjectException("没有传入必要的参数");
			}
		}
		return false;
	}
	
	//查询商品list
	@Override
	public List<TradeCustom> queryTrades(TradeCustomVo tradeCustomVo) throws Exception{
		// TODO Auto-generated method stub
		return tradeMapper.findTrades(tradeCustomVo);
	}
	
	//查询管理员商品总数
	@Override
	public int queryTradesCount(Integer systemId) throws Exception{
		// TODO Auto-generated method stub
		return tradeMapper.findTradesCount(systemId);
	}
	
	//根据商品id删除商品信息
	@Override
	public boolean deleteTrade(Integer id) throws Exception{
		// TODO Auto-generated method stub
		if (tradeMapper.deleteTrade(id)>0) {
			return true;
		}
		return false;
	}

	//根据商品id修改商品信息
	@Override
	public boolean updateTrade(Integer id, TradeCustom tradeCustom) throws Exception{
		// TODO Auto-generated method stub
		tradeCustom.setId(id);
		if (tradeMapper.updateTrade(tradeCustom)>0) {
			return true;
		}
		return false;
	}

}
