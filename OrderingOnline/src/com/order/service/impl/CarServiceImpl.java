package com.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.order.mapper.CarMapper;
import com.order.po.Car;
import com.order.po.CarCustomVo;
import com.order.service.CarService;
/**
 * 购物车接口实现
 * @author zlh
 *
 */
public class CarServiceImpl implements CarService {
	@Autowired 
	private CarMapper carMapper;
	//添加购物车
	@Override
	public boolean saveCar(Integer tradeId, Car car) throws Exception {
		// TODO Auto-generated method stub
		car.setTradeId(tradeId);
		CarCustomVo carCustomVo=new CarCustomVo();
		carCustomVo.setCar(car);
		//判断购物车中是否有该商品 有则直接将商品数量加1
		List<Car> cars=carMapper.findCar(carCustomVo);
		if (cars.size()>0) {
			Car carIs=cars.get(0);
			car.setTradeNum(carIs.getTradeNum()+1);
			if (carMapper.updateCar(car)>0) {
				return true;
			}
		}else {
			car.setTradeNum(1);
		}
		if (carMapper.insertCar(car)>0) {
			return true;
		}
		return false;
	}
	//查询登录用户购物车商品总数
	@Override
	public int queryCarCount(Integer memberId) throws Exception {
		// TODO Auto-generated method stub
		return carMapper.findCarCount(memberId);
	}
	//查询登录用户购物车商品信息
	@Override
	public List<Car> queryCar(CarCustomVo carCustomVo) throws Exception {
		// TODO Auto-generated method stub
		return carMapper.findCar(carCustomVo);
	}
	//更新登录用户购物车商品数量
	@Override
	public boolean updateCar(Integer tradeId, Car car) throws Exception {
		// TODO Auto-generated method stub
		car.setTradeId(tradeId);
		if (carMapper.updateCar(car)>0) {
			return true;
		}
		return false;
	}
	//删除登录用户购物车商品信息
	@Override
	public boolean deleteCar(Integer id) throws Exception {
		// TODO Auto-generated method stub
		if (carMapper.deleteCar(id)>0) {
			return true;
		}
		return false;
	}
	
}
