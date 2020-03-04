package com.order.service;

import java.util.List;

import com.order.po.System;
import com.order.po.SystemCustom;
import com.order.po.SystemCustomVo;
/**
 * 管理员业务接口类
 * @author zlh
 *
 */
public interface SystemService {
	//根据名称查询管理员 返回boolean
	public SystemCustom findSysByName(SystemCustomVo systemCustomVo) throws Exception;

	//查询账户信息
	public List<System> querySystem(Integer id) throws Exception;
	
	//修改账户信息
	public boolean editSystem(System system) throws Exception;
}
