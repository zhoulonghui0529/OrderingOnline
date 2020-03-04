package com.order.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.order.exception.ProjectException;
import com.order.po.System;
import com.order.po.SystemCustom;
import com.order.po.SystemCustomVo;
import com.order.service.SystemService;

import net.sf.json.JSONArray;


/**  
 *  管理员控制器
 * @author zlh
 *
 */
//注解 自动配置bean
@Controller
public class SystemController {
	//注解 自动注入属性systemService
	@Autowired
	private SystemService systemService;
	//管理员登录 只允许响应POST请求
	@RequestMapping(value = "/systemLogin",method = RequestMethod.POST)
	//@RequestBody接收前台传入json格式数据  @ResponseBody响应json数据给前台页面
	@ResponseBody
	public void systemLogin(@RequestBody SystemCustomVo systemCustomVo,HttpServletResponse response,HttpSession session) throws Exception{
		
		SystemCustom systemCustom = systemService.findSysByName(systemCustomVo);
		//设置响应编码
		response.setCharacterEncoding("utf-8");
		if (systemCustom!=null) {
			//将登录信息放入session域中
			String systemName=systemCustom.getSystemName();
			Integer systemId=systemCustom.getId();
			session.setAttribute("systemName", systemName);
			session.setAttribute("systemId", systemId);
			response.getWriter().write("success");
		}
		else {
			response.getWriter().write("error");
		}
	}
	//管理员退出
	@RequestMapping(value = "/systemLogout")
	public void systemLogout(HttpServletResponse response,HttpSession session) throws Exception{
		//将session中的信息失效
		session.invalidate();
		//重定向到管理员登录界面
		response.sendRedirect("views/system/login.html");
	}
	//查询管理员信息
	@RequestMapping(value = "/querySystem")
	public void querySystem(HttpServletResponse response,HttpSession session) throws Exception{
		if (session.getAttribute("systemId")!=null) {
			Integer id=Integer.parseInt(session.getAttribute("systemId").toString());
			List<System> systems=systemService.querySystem(id);
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(JSONArray.fromObject(systems).toString());
		}else {
			throw new ProjectException("参数错误");
		}
	}
	//
	@RequestMapping(value = "/querySystems")
	public void querySystems(HttpServletResponse response,HttpSession session) throws Exception{
		List<System> systems=systemService.querySystem(null);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(JSONArray.fromObject(systems).toString());
	}
	
	
	//修改管理员信息
	@RequestMapping(value = "/editSystem")
	public void editSystem(System system,HttpServletResponse response,HttpSession session) throws Exception{
		if (session.getAttribute("systemId")!=null&&system!=null) {
			Integer id=Integer.parseInt(session.getAttribute("systemId").toString());
			system.setId(id);
			boolean status=systemService.editSystem(system);
			response.setCharacterEncoding("utf-8");
			PrintWriter printWriter=response.getWriter();
			if (status) {
				if (system.getSystemName()!=null) {
					session.setAttribute("systemName", system.getSystemName());
				}if (system.getSystemPwd()!=null) {
					session.setAttribute("systemPwd", system.getSystemPwd());
				}
				printWriter.write("success");
			}else {
				printWriter.write("修改信息失败");
			}
		}else {
			throw new ProjectException("参数错误");
		}
	}
}
