package com.order.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.order.common.entity.Pager;
import com.order.exception.ProjectException;
import com.order.po.Car;
import com.order.po.CarCustomVo;
import com.order.service.CarService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 购物车
 * @author zlh
 *
 */
@Controller
@RequestMapping(value = "/car")
public class CarController {
	@Autowired
	private CarService carService;
	//添加购物车
	@RequestMapping(value = "/saveCar")
	public void saveCar(Integer tradeId,Car car,HttpServletResponse response,HttpSession session) throws Exception{
		if (session.getAttribute("memberId")!=null&&tradeId!=null&&car!=null) {
			car.setMemeberId(Integer.parseInt(session.getAttribute("memberId").toString()));
			boolean status=carService.saveCar(tradeId,car);
			response.setCharacterEncoding("utf-8");
			PrintWriter printWriter=response.getWriter();
			if (status) {
				printWriter.write("success");
			}else {
				printWriter.write("添加失败");
			}
		}else {
			throw new ProjectException("参数错误");
		}
	}
	//查询购物车
	@RequestMapping(value = "/queryCar")
	public void queryCar(Integer page,Integer rows,Car car,HttpServletResponse response,HttpSession session) throws Exception{
		if (session.getAttribute("memberId")!=null) {
			Integer memberId=Integer.parseInt(session.getAttribute("memberId").toString());
			car.setMemeberId(memberId);
			Pager pager=null;
			if (page!=null&&rows!=null) {
				pager=new Pager(page, rows);
			}
			//创建综合查询对象 放入分页 购物车对象
			CarCustomVo carCustomVo=new CarCustomVo();
			carCustomVo.setCar(car);
			carCustomVo.setPager(pager);
			//
			//调用业务层查询购物车信息总数方法 查询登入用户购物车总数total
			int total=carService.queryCarCount(memberId);
			//调用业务层查询购物车信息方法
			List<Car> cars=carService.queryCar(carCustomVo);
			//创建map对象
			Map<String,Object> carsMap=new HashMap<String, Object>();
			carsMap.put("total", total);
			carsMap.put("rows", cars);
			response.setCharacterEncoding("utf-8");
			PrintWriter printWriter=response.getWriter();
			printWriter.write(JSONObject.fromObject(carsMap).toString());
		}else {
			throw new ProjectException("参数错误");
		}
	}
	//修改购物车商品数量
	@RequestMapping(value = "/updateCar")
	public void updateCar(Integer tradeId,Car car,HttpServletResponse response) throws Exception{
		if (tradeId!=null&&car!=null) {
			boolean status=carService.updateCar(tradeId,car);
			response.setCharacterEncoding("utf-8");
			PrintWriter printWriter=response.getWriter();
			if (status) {
				printWriter.write("success");
			}else {
				printWriter.write("修改失败");
			}
		}else {
			throw new ProjectException("参数错误");
		}
	}
	//删除购物车商品
	@RequestMapping(value = "/deleteCar")
	public void deleteCar(Integer id,HttpServletResponse response) throws Exception{
		if (id!=null) {
			boolean status=carService.deleteCar(id);
			response.setCharacterEncoding("utf-8");
			PrintWriter printWriter=response.getWriter();
			if (status) {
				printWriter.write("success");
			}else {
				printWriter.write("删除失败");
			}
		}else {
			throw new ProjectException("参数错误");
		}
	}
}
