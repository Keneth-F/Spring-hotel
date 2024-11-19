package com.keneth.hotel.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keneth.hotel.models.Reservation;
@Repository
public interface ReservationRepo extends JpaRepository<Reservation,Long>{
  //TODO status
}
