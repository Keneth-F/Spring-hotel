package com.keneth.hotel.models;

import java.time.LocalDateTime;

import com.keneth.hotel.models.Reservation.ReservationStatus;

public class ReservationDTO {
  private Long id;
  private Long clientId;
  private Long roomId;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private ReservationStatus status;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getClientId() {
    return clientId;
  }

  public void setClientId(Long clientId) {
    this.clientId = clientId;
  }

  public Long getRoomId() {
    return roomId;
  }

  public void setRoomId(Long roomId) {
    this.roomId = roomId;
  }

  public LocalDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }

  public LocalDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDateTime endDate) {
    this.endDate = endDate;
  }

  public ReservationStatus getStatus() {
    return status;
  }

  public void setStatus(ReservationStatus status) {
    this.status = status;
  }

  public ReservationDTO(Long id, Long clientId, Long roomId, LocalDateTime startDate, LocalDateTime endDate,
      ReservationStatus status) {
    this.id = id;
    this.clientId = clientId;
    this.roomId = roomId;
    this.startDate = startDate;
    this.endDate = endDate;
    this.status = status;
  }

  public ReservationDTO() {
  }
}
