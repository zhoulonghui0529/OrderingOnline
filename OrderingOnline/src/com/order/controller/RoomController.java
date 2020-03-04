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
import com.order.po.Room;
import com.order.po.RoomCustomVo;
import com.order.service.RoomService;

import net.sf.json.JSONObject;

/**
 * 包间controller类
 * @author zlh
 *
 */
@Controller
@RequestMapping("/room")
public class RoomController {
	@Autowired
	private RoomService roomService;
	
	//添加包间
	@RequestMapping("/saveRoom")
	public void saveRoom(Room room,HttpServletResponse response,HttpSession session) throws Exception{
		if (room!=null&&session.getAttribute("systemId")!=null) {
			Integer systemId=Integer.parseInt(session.getAttribute("systemId").toString());
			room.setSystemId(systemId);
			boolean status=roomService.saveRoom(room);
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
	//查询包间
	@RequestMapping("/queryRoom")
	public void queryRoom(Integer page,Integer rows,HttpServletResponse response,HttpSession session) throws Exception{
		if (session.getAttribute("systemId")!=null) {
			//创建room综合查询对象
			RoomCustomVo roomCustomVo=new RoomCustomVo();
			Integer systemId=Integer.parseInt(session.getAttribute("systemId").toString());
			//将systemId放入roomCustomVo
			roomCustomVo.setSystemId(systemId);
			//如果page, rows不为空 将Pager(page, rows)放入roomCustomVo
			if (page!=null&&rows!=null) {
				Pager pager=new Pager(page, rows);
				roomCustomVo.setPager(pager);
			}
			//包间总数
			int total=roomService.findCount(systemId);
			//包间列表
			List<Room> rooms=roomService.queryRoom(roomCustomVo);
			//创建map 存放total room
			Map<String, Object> dataMap=new HashMap<String, Object>();
			dataMap.put("rows", rooms);
			dataMap.put("total", total);
			//响应
			response.setCharacterEncoding("utf-8");
			PrintWriter printWriter=response.getWriter();
			printWriter.write(JSONObject.fromObject(dataMap).toString());
		}else {
			throw new ProjectException("参数错误");
		}
	}
	//根据包间id删除包间
	@RequestMapping(value = "/deleteRoom")
	public void deleteRoom(Integer id,HttpServletResponse response) throws Exception{
		if (id!=null) {
			boolean status=roomService.deleteRoom(id);
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
	
	//根据包间id修改包间
	@RequestMapping(value = "/editRoom")
	public void editRoom(Integer id,Room room,HttpServletResponse response) throws Exception{
		if (id!=null&&room!=null) {
			boolean status=roomService.editRoom(id,room);
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
}
