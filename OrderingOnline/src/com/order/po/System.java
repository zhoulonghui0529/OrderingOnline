package com.order.po;
/**
 * 管理员po类
 * @author zlh
 *
 */
public class System {
	private Integer id;
	private String systemName;
	private String systemPwd;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getSystemPwd() {
		return systemPwd;
	}
	public void setSystemPwd(String systemPwd) {
		this.systemPwd = systemPwd;
	}
	@Override
	public String toString() {
		return "System [id=" + id + ", systemName=" + systemName + ", systemPwd=" + systemPwd + "]";
	}
	
}
