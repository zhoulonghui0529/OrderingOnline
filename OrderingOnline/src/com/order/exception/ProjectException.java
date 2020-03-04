package com.order.exception;
/**
 * 系统异常
 * @author zlh
 *
 */
public class ProjectException extends Exception{
	private static final long serialVersionUID = 1L;
	private String message;
	public ProjectException() {
		// TODO Auto-generated constructor stub
	}
	public ProjectException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
