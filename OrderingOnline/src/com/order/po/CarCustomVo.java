package com.order.po;
/**
 * 购物车综合查询
 * @author zlh
 *
 */

import com.order.common.entity.Pager;

public class CarCustomVo {
	private Pager pager;
	private Car car;
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
}
