package com.keneth.hotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.keneth.hotel.data.RoomRepo;
import com.keneth.hotel.models.Room;

@Service
public class RoomService {
  private RoomRepo roomRepo;
  public RoomService(RoomRepo roomRepo) {
    this.roomRepo=roomRepo;
  }

  public List<Room> findAll(){
    return roomRepo.findAll();
  }

  public Room save(Room room){
    return roomRepo.save(room);
  }

  public Optional<Room> findById(Long id){
    return roomRepo.findById(id);
  }

  public void delete(Long id){
    roomRepo.deleteById(id);
  }
}
