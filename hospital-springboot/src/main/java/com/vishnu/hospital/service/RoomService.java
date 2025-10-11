package com.vishnu.hospital.service;

import java.util.List;

import com.vishnu.hospital.dto.RoomDto;

public interface RoomService {
	
	RoomDto createRoom(RoomDto dto);
	RoomDto getRoomById(int id);
	List<RoomDto> getAllRooms();
	RoomDto updateRoom(int id, RoomDto dto);
	String deleteRoom(int id);

}
