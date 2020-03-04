package com.order.mapper;

import java.util.List;

import com.order.po.Room;
import com.order.po.RoomCustomVo;

/**
 * 包间mapper接口
 * @author zlh
 *
 */
public interface RoomMapper {
	//添加包间
	int insertRoom(Room room) throws Exception;
	
	//查询包间
	List<Room> findRoom(RoomCustomVo roomCustomVo) throws Exception;
	
	//修改包间
	int updateRoom(Room room) throws Exception;
	
	//删除包间
	int deleteRoom(Integer id) throws Exception;
	
	//查询包间总数
	int findRoomCount(Integer systemId) throws Exception;
}
