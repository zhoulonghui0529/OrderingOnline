package com.order.mapper;

import java.util.List;

import com.order.po.Car;
import com.order.po.CarCustomVo;

/**
 * 购物街mapper接口
 * @author zlh
 *
 */
public interface CarMapper {
	//查询购物车
	List<Car> findCar(CarCustomVo carCustomVo) throws Exception;
	//插入购物车
	int insertCar(Car car) throws Exception;
	//更新购物车
	int updateCar(Car car) throws Exception;
	//删除购物车
	int deleteCar(Integer id) throws Exception;
	//查询购物车总数
	int findCarCount(Integer memberId) throws Exception;
}
