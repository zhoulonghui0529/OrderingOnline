package com.order.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.order.common.entity.Pager;
import com.order.exception.ProjectException;
import com.order.po.Trade;
import com.order.po.TradeCustom;
import com.order.po.TradeCustomVo;
import com.order.service.TradeService;

import net.sf.json.JSONObject;

/**  
 *  商品控制器
 * @author zlh
 *
 */
//注解 自动配置bean
@Controller
//模块化
@RequestMapping(value = "/trades")
public class TradeController {
	//注入属性tradeService bean
	@Autowired
	private TradeService tradeService;
	//添加商品
	@RequestMapping(value = "/saveTrade")
	public void saveTrade(Trade trade,HttpServletResponse response,HttpSession session) throws Exception{
		Integer systemId=null;
		if (session.getAttribute("systemId")!=null) {
			systemId=Integer.parseInt(session.getAttribute("systemId").toString());
			trade.setSystemId(systemId);
			boolean status=tradeService.saveTrade(trade);
			if (status) {
				response.getWriter().write("success");
			}
			else {
				response.getWriter().write("保存失败");
			}
		}else {
			throw new ProjectException("管理员身份过期，请重新登录");
		}
	}
	//根据管理员id查询对应管理员所有的商品信息
	@RequestMapping(value = "/queryTrades")
	public void queryTrades(Integer id,String tradeName,HttpSession session,Integer page,Integer rows,HttpServletResponse response) throws Exception{
		if (session.getAttribute("systemId")!=null) {
			//获取session中的管理员登录id
			Integer systemId=Integer.parseInt(session.getAttribute("systemId").toString());
			
			//将page rows封装到pager中
			Pager pager=null;
			if (page!=null&&rows!=null) {
				pager=new Pager(page,rows);
			}
			
			//将pager对象和systemId都封装到TradeCustomVo对象中
			TradeCustomVo tradeCustomVo=new TradeCustomVo();
			tradeCustomVo.setPager(pager);
			tradeCustomVo.setSystemId(systemId);
			Trade trade=null;
			if (tradeName!=null&&tradeName!="") {
				trade=new Trade();
				trade.setTradeName(tradeName);
				tradeCustomVo.setTrade(trade);
			}
			if (id!=null) {
				trade=new Trade();
				trade.setId(id);
				tradeCustomVo.setTrade(trade);
			}
			
			//查询管理员商品信息总数
			int total=tradeService.queryTradesCount(systemId);
			
			//查询管理员商品信息列表
			List<TradeCustom> tradeCustomList=tradeService.queryTrades(tradeCustomVo);
			
			Map<String ,Object> dataMap=new HashMap<String,Object>();
			//前端识别rows为datagird的数据名称
			dataMap.put("rows", tradeCustomList);
			//total为数据总数
			dataMap.put("total", total);
			//设置响应编码
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(JSONObject.fromObject(dataMap).toString());
		}else {
			throw new ProjectException("后台参数出错");
		}
	}
	//根据商品id删除商品
	@RequestMapping(value = "/deleteTrade")
	public void deleteTrade(Integer id,HttpServletResponse response) throws Exception{
		if (id!=null) {
			boolean status=tradeService.deleteTrade(id);
			response.setCharacterEncoding("utf-8");
			if (status) {
				response.getWriter().write("success");
			}else {
				response.getWriter().write("删除失败！");
			}
		}else {
			throw new ProjectException("后台参数错误");
		}
	}
	//根据商品id修改商品
	@RequestMapping(value = "/updateTrade")
	public void updateTrade(Integer id,TradeCustom tradeCustom,MultipartFile tradePicSource,HttpServletResponse response) throws Exception{
		if (tradeCustom!=null&&id!=null) {
			if (tradePicSource!=null&&tradePicSource.getSize()!=0) {
				//图片存储磁盘路径
				String realPath="F:\\Java\\orderfile\\";
				//图片原始名称
				String originalName=tradePicSource.getOriginalFilename();
				//新的图片名称
				String newName=UUID.randomUUID()+originalName.substring(originalName.lastIndexOf("."));
				//新的图片文件
				File newFile=new File(realPath+newName);
				//将内存中的图片文件写入磁盘中
				tradePicSource.transferTo(newFile);
				//将图片虚拟路径写入tradeCustom对象中 存入数据库中
				tradeCustom.setTradePic("/files/"+newName);
			}
			boolean status=tradeService.updateTrade(id,tradeCustom);
			response.setCharacterEncoding("utf-8");
			PrintWriter printWriter=response.getWriter();
			if (status) {
				printWriter.write("success");
			}else {
				printWriter.write("修改失败！");
			}
		}else {
			throw new ProjectException("参数异常");
		}
	}
}
