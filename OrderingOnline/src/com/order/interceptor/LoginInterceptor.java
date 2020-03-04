package com.order.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;

/**
 * 登录认证拦截器
 * @author zlh
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
	
	//进入controller方法之前执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//获取请求地址
//		String url=request.getRequestURI();
		//判断是否为项目的公开地址 即不需要登录即能访问的地址 项目中一般将公开地址放入配置文件中
//		if (url.indexOf("systemLogin.action")>=0||url.indexOf("systemLogout.action")>=0) {
//			//放行
//			return true;
//		}
//		HttpSession session=request.getSession();
		//判断是否已经登录
//		if (session.getAttribute("systemName")!=null) {
//			//放行
//			return true;
//		}
//		Map<String ,Object> data=new HashMap<String,Object>();
//		
//		data.put("data", "nologin");
		//ajax默认不支持重定向 请求转发 它只是局部刷新 不加载新页面
//		response.getWriter().write(JSONObject.fromObject(data).toString());
		return true;
	}
	
	
	
	//进入controller方法之后  返回modelandview之前执行
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	}
	//执行完controller方法之后执行
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
	}
	
}
