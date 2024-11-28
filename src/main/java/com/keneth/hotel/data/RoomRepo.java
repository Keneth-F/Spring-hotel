package com.keneth.hotel.data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.keneth.hotel.models.Room;
import com.keneth.hotel.models.Room.RoomStatus;
@Repository
public interface RoomRepo extends JpaRepository<Room,Long> {
   List<Room> findByStatus(RoomStatus status);
   Optional<Room> findByRoomNumber(String roomNumber);
   @Query("SELECT r FROM Room r WHERE  NOT EXISTS (SELECT 1 FROM Reservation b WHERE b.room = r AND (b.startDate < :endDate AND b.endDate > :startDate))")
    List<Room> findAvailableRoomsInPeriod(
                                          LocalDateTime startDate, 
                                          LocalDateTime endDate);
}
