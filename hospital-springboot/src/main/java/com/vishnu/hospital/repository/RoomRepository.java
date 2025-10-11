package com.vishnu.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vishnu.hospital.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}
