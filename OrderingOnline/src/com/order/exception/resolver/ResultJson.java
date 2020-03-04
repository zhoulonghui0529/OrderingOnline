package com.order.exception.resolver;
/**
 * 定义异常信息json类
 * @author zlh
 *
 */
public class ResultJson {
	public String message;
	public Object data;
	public ResultJson(String message) {
		super();
		this.message = message;
	}
	public ResultJson() {
		// TODO Auto-generated constructor stub
		this.message="success";
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public ResultJson setData(Object data) {
		this.data = data;
		return this;
	}
	
}
