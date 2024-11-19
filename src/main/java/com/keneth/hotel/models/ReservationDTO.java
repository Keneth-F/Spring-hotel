package com.keneth.hotel.models;

import java.time.LocalDateTime;

import com.keneth.hotel.models.Reservation.ReservationStatus;

public class ReservationDTO {
  public Long id;
  public Long clientId;
  public Long roomId;
  public LocalDateTime startDate;
  public LocalDateTime endDate;
  public ReservationStatus status;
}
