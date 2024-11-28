package com.keneth.hotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.keneth.hotel.data.ReservationRepo;
import com.keneth.hotel.models.Reservation;
import com.keneth.hotel.models.ReservationDTO;
import com.keneth.hotel.models.Room;
import com.keneth.hotel.models.Reservation.ReservationStatus;
import com.keneth.hotel.models.Room.RoomStatus;

import jakarta.transaction.Transactional;

@Service
public class ReservationService {
  private ReservationRepo reservationRepo;
  private RoomService roomService;//Not DTO
  public ReservationService(ReservationRepo reservationRepo,RoomService roomService) {
    this.reservationRepo=reservationRepo;
    this.roomService=roomService;
  }

  public List<Reservation> findAll(){
    return reservationRepo.findAll();
  }

  @Transactional
  public Reservation save(ReservationDTO reservation){
    Room room = roomService.findById(reservation.getRoomId()).get();
    if (reservation.getId() ==null || reservation.getStatus()==ReservationStatus.ACTIVE) {
      room.setStatus(RoomStatus.BOOKED);
    }else{
      room.setStatus(RoomStatus.AVAILABLE);
    }
    roomService.save(room);
    return reservationRepo.save(reservation.toModel());
  }

  public Optional<Reservation> findById(Long id){
    return reservationRepo.findById(id);
  }
  @Transactional
  public void delete(Long id){
    var r =reservationRepo.findById(id).get().getRoom();
    r.setStatus(RoomStatus.AVAILABLE);
    System.out.println("\n\nroom::"+r.getStatus());
    roomService.save(r);
    reservationRepo.deleteById(id);
  }
}
