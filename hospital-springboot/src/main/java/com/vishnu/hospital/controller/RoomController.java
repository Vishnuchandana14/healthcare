package com.vishnu.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vishnu.hospital.dto.RoomDto;
import com.vishnu.hospital.service.RoomService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "3. Rooms")
@RestController
@RequestMapping("/api/rooms")
public class RoomController {
	
	@Autowired
	public RoomService roomService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping()
	public ResponseEntity<RoomDto> createRoom(@Valid @RequestBody RoomDto dto){
		RoomDto room = roomService.createRoom(dto);
		return new ResponseEntity<>(room, HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN','NURSE','RECEPTIONIST')")
	@GetMapping("/{id}")
	public ResponseEntity<RoomDto> getRoomById(@PathVariable int id){
		RoomDto room = roomService.getRoomById(id);
		return new ResponseEntity<>(room, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN','RECEPTIONIST')")
	@GetMapping()
	public ResponseEntity<List<RoomDto>> getAllRooms(){
		List<RoomDto> rooms = roomService.getAllRooms();
		return new ResponseEntity<>(rooms, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN','NURSE','RECEPTIONIST')")
	@PutMapping("/{id}")
	public ResponseEntity<RoomDto> updateRoom(@PathVariable int id,@Valid @RequestBody RoomDto dto){
        RoomDto room = roomService.updateRoom(id, dto);
        return new ResponseEntity<>(room, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMapping(@PathVariable int id){
		String response = roomService.deleteRoom(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
