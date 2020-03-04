package com.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.order.mapper.RoomMapper;
import com.order.po.Room;
import com.order.po.RoomCustomVo;
import com.order.service.RoomService;
/**
 * 包间业务service接口实现类
 * @author zlh
 *
 */
public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomMapper roomMapper;
	//添加包间
	@Override
	public boolean saveRoom(Room room) throws Exception {
		// TODO Auto-generated method stub
		if (roomMapper.insertRoom(room)>0) {
			return true;
		}
		return false;
	}
	//查询包间总数
	@Override
	public int findCount(Integer systemId) throws Exception{
		// TODO Auto-generated method stub
		return roomMapper.findRoomCount(systemId);
	}
	//查询包间
	@Override
	public List<Room> queryRoom(RoomCustomVo roomCustomVo) throws Exception{
		// TODO Auto-generated method stub
		return roomMapper.findRoom(roomCustomVo);
	}
	//根据包间id删除包间
	@Override
	public boolean deleteRoom(Integer id) throws Exception {
		// TODO Auto-generated method stub
		if (roomMapper.deleteRoom(id)>0) {
			return true;
		}
		return false;
	}
	//根据包间id修改包间
	@Override
	public boolean editRoom(Integer id, Room room) throws Exception {
		// TODO Auto-generated method stub
		room.setId(id);
		if (roomMapper.updateRoom(room)>0) {
			return true;
		}
		return false;
	}

}
