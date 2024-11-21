package com.keneth.hotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.keneth.hotel.data.ReservationRepo;
import com.keneth.hotel.models.Reservation;
import com.keneth.hotel.models.ReservationDTO;

@Service
public class ReservationService {
  private ReservationRepo reservationRepo;
  public ReservationService(ReservationRepo reservationRepo) {
    this.reservationRepo=reservationRepo;
  }

  public List<Reservation> findAll(){
    return reservationRepo.findAll();
  }

  public Reservation save(ReservationDTO reservation){
    return reservationRepo.save(reservation.toModel());
  }

  public Optional<Reservation> findById(Long id){
    return reservationRepo.findById(id);
  }

  public void delete(Long id){
    reservationRepo.deleteById(id);
  }
}
