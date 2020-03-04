package com.order.service;

import java.util.List;

import com.order.po.Car;
import com.order.po.CarCustomVo;

/**
 * 购物车业务接口
 * @author zlh
 *
 */
public interface CarService {
	//添加购物车
	public boolean saveCar(Integer tradeId,Car car) throws Exception;
	//查询登录用户购物车商品总数
	public int queryCarCount(Integer memberId) throws Exception;
	//综合查询登录用户购物车商品信息
	public List<Car> queryCar(CarCustomVo carCustomVo) throws Exception;
	//更新购物车商品数量
	public boolean updateCar(Integer tradeId, Car car) throws Exception;
	//删除购物车商品信息
	public boolean deleteCar(Integer id) throws Exception;
}
