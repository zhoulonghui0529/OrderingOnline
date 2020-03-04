package com.order.po;
/**
 * 包间po类
 * @author zlh
 *
 */
public class Room {
	private Integer id;
	private Integer systemId;
	private Integer roomCode;//包间号码
	private Integer roomType;//包间类型
	private Integer roomState;//包间状态
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(Integer roomCode) {
		this.roomCode = roomCode;
	}
	public Integer getRoomType() {
		return roomType;
	}
	public void setRoomType(Integer roomType) {
		this.roomType = roomType;
	}
	public Integer getRoomState() {
		return roomState;
	}
	public void setRoomState(Integer roomState) {
		this.roomState = roomState;
	}
	public Integer getSystemId() {
		return systemId;
	}
	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", systemId=" + systemId + ", roomCode=" + roomCode + ", roomType=" + roomType
				+ ", roomState=" + roomState + "]";
	}
	
	
}
