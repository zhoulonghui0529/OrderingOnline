package com.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.order.mapper.SystemMapper;
import com.order.po.System;
import com.order.po.SystemCustom;
import com.order.po.SystemCustomVo;
import com.order.service.SystemService;
/**
 * 管理员业务接口类实现类
 * @author zlh
 *
 */
public class SystemServiceImpl implements SystemService {
	//注解 自动装配属性systemMapper
	@Autowired
	private SystemMapper systemMapper;
	//根据账户名称查询管理员信息
	@Override
	//name为必须传入的参数
	public SystemCustom findSysByName(SystemCustomVo systemCustomVo) throws Exception{
		// TODO Auto-generated method stub
		//调用mapper接口中对应方法h
		SystemCustom realSystemCustom=systemMapper.findSysByName(systemCustomVo);
		if (realSystemCustom!=null) {
			if (realSystemCustom.getSystemPwd().equals(systemCustomVo.getSystemCustom().getSystemPwd())) {
				return realSystemCustom;
			}
		}
		return null;
	}
	//查询账户信息
	@Override
	public List<System> querySystem(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
		return systemMapper.findSystem(id);
	}
	//修改账户信息
	@Override
	public boolean editSystem(System system) throws Exception {
		// TODO Auto-generated method stub
		if (systemMapper.updateSystem(system)>0) {
			return true;
		}
		return false;
	}

}
