package com.keneth.hotel.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.keneth.hotel.data.RoomRepo;
import com.keneth.hotel.models.Room;
import com.keneth.hotel.models.Room.RoomStatus;

@Service
public class RoomService {
  private RoomRepo roomRepo;
  public RoomService(RoomRepo roomRepo) {
    this.roomRepo=roomRepo;
  }

  public List<Room> findAll(){
    return roomRepo.findAll();
  }
  public List<Room> findAvailableRoomsInPeriod(LocalDateTime startDate, LocalDateTime endDate){
    return roomRepo.findAvailableRoomsInPeriod(startDate,endDate);
  }

  public Room save(Room room){
    return roomRepo.save(room);
  }

  public Optional<Room> findById(Long id){
    return roomRepo.findById(id);
  }
  public Optional<Room> findByRoomNumber(String roomNumber){
    return roomRepo.findByRoomNumber(roomNumber);
  }
  public List<Room> findByStatus(RoomStatus status){
    return roomRepo.findByStatus(status);
  }

  public void delete(Long id){
    roomRepo.deleteById(id);
  }
}
