package com.keneth.hotel.data;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.keneth.hotel.models.Room;
import com.keneth.hotel.models.Room.RoomStatus;
@Repository
public interface RoomRepo extends JpaRepository<Room,Long> {
   List<Room> findByStatus(RoomStatus status);
   @Query("SELECT r FROM Room r WHERE r.status = :status AND NOT EXISTS (SELECT 1 FROM Reservation b WHERE b.room = r AND (b.startDate < :endDate AND b.endDate > :startDate))")
    List<Room> findAvailableRoomsInPeriod(@Param("status") RoomStatus status, 
                                          @Param("startDate") LocalDate startDate, 
                                          @Param("endDate") LocalDate endDate);
}
