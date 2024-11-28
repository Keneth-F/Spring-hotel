package com.keneth.hotel.models;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.keneth.hotel.models.Reservation.ReservationStatus;

import jakarta.validation.constraints.NotNull;

public class ReservationDTO {
  private Long id;
  @NotNull
  private Long clientId;
  @NotNull
  private Long roomId;
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime startDate;
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime endDate;
  @NotNull
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

  public final Reservation toModel() {
    return new Reservation(this.id,
        new Client(this.clientId, null, null, null, null),
        new Room(this.roomId, null, null, null, null),
        startDate,
        endDate,
        status);
  }
}
