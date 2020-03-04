package com.order.service;

import java.util.List;

import com.order.po.Room;
import com.order.po.RoomCustomVo;

/**
 * 包间业务service接口
 * @author zlh
 *
 */
public interface RoomService {
	//添加包间
	boolean saveRoom(Room room) throws Exception;
	
	//查询包间总数
	int findCount(Integer systemId) throws Exception;
	
	//查询包间
	List<Room> queryRoom(RoomCustomVo roomCustomVo) throws Exception;
	
	//根据包间id删除包间
	boolean deleteRoom(Integer id) throws Exception;
	
	//根据包间id修改包间
	boolean editRoom(Integer id, Room room) throws Exception;

}
