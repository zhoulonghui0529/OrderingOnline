package com.order.mapper;

import java.util.List;

import com.order.po.System;
import com.order.po.SystemCustom;
import com.order.po.SystemCustomVo;
/**
 * 管理员mapper接口
 * @author zlh
 *
 */
public interface SystemMapper {
	//根据名称查询管理员信息 返回System扩展类SystemCustom
	public SystemCustom findSysByName(SystemCustomVo systemCustomVo) throws Exception;
	
	//查询账户信息
	public List<System> findSystem(Integer id) throws Exception;
	
	//更新账户信息
	public int updateSystem(System system) throws Exception;
}
