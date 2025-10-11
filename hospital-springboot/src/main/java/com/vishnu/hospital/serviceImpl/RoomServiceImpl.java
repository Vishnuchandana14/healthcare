package com.vishnu.hospital.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.vishnu.hospital.dto.RoomDto;
import com.vishnu.hospital.entity.Room;
import com.vishnu.hospital.exceptions.DuplicateResourceException;
import com.vishnu.hospital.exceptions.RoomNotAvailableException;
import com.vishnu.hospital.repository.RoomRepository;
import com.vishnu.hospital.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	public RoomRepository roomRepository;
	
	@Autowired
	public ModelMapper modelMapper;

	@Override
	public RoomDto createRoom(RoomDto dto) {
		Room room = modelMapper.map(dto, Room.class);
		
		if(room.getStatus() == null) {
			room.setStatus("Available");
		}
		try {
		    return modelMapper.map(roomRepository.save(room), RoomDto.class);
		} catch(DataIntegrityViolationException e) {
			throw new DuplicateResourceException("Room with number already exists!");
		}
	}

	@Override
	public RoomDto getRoomById(int id) {
		Room room = roomRepository.findById(id)
				                  .orElseThrow(()-> new RoomNotAvailableException("Room not found with id" + id));
		return modelMapper.map(room, RoomDto.class);
	}

	@Override
	public List<RoomDto> getAllRooms() {
		return roomRepository.findAll().stream()
		                        .map(p-> modelMapper.map(p, RoomDto.class))
		                        .collect(Collectors.toList());
	}

	@Override
	public RoomDto updateRoom(int id, RoomDto dto) {
		Room room = roomRepository.findById(id)
                .orElseThrow(()-> new RoomNotAvailableException("Room not found with id" + id));
		
		room.setRoomNo(dto.getRoomNo());
        room.setType(dto.getType());
        
        if(dto.getStatus() != null) {
        	room.setStatus(dto.getStatus());
        }
		return modelMapper.map(roomRepository.save(room), RoomDto.class);
	}

	@Override
	public String deleteRoom(int id) {
		  if (roomRepository.existsById(id)) {
	            roomRepository.deleteById(id);
	            return "Room has been deleted from the record";
	       } else {
	            return "Room with ID " + id + " does not exist";
	       }
	}

}
