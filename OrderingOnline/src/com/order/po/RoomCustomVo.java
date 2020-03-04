package com.order.po;
/**
 * 包间综合查询
 * @author zlh
 *
 */

import com.order.common.entity.Pager;

public class RoomCustomVo {
	private Integer systemId;//管理员账号id
	private Pager pager;//分页参数
	public Integer getSystemId() {
		return systemId;
	}
	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
}
