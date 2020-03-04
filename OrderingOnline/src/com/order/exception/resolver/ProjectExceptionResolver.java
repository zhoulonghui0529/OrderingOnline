package com.order.exception.resolver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.order.exception.ProjectException;
/**
 * 系统全局异常处理器
 * @author zlh
 *
 */
public class ProjectExceptionResolver implements HandlerExceptionResolver {
	// slf4j日志记录器
	private static final  Logger logger=LoggerFactory.getLogger(ProjectExceptionResolver.class);
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// TODO Auto-generated method stub
		try {
			//创建响应流
			PrintWriter printWriter=response.getWriter();
			
			ResultJson resultJson=new ResultJson();
			//错误类型 是否为程序员处理的异常
			ProjectException projectException=null;
			
			if (ex instanceof ProjectException) {
				//自定义处理异常
				projectException=(ProjectException) ex;
				
			}else {
				//运行时异常
				projectException=new ProjectException("未知错误");
				
			}
			
			//错误信息
			String message=projectException.getMessage();
			
			resultJson.setMessage(message);
			//json转换器
			Gson gson=new Gson();
			//将对象转为json串
			String json=gson.toJson(resultJson);
			//打印异常
			logger.error("全局处理异常{}",json,ex);
			//设置响应json串头信息
			response.setContentType("application/json;charset=UTF-8");
			//将json写入到response响应
			printWriter.println(json);
			//关闭流资源
			printWriter.close();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			logger.error(e1.getMessage(),e1);
			
		}
		
		return null;
	}

}
