package com.keneth.hotel.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keneth.hotel.models.Room;
@Repository
public interface RoomRepo extends JpaRepository<Room,Long> {
  
}
