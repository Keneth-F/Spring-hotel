package com.keneth.hotel.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  private String roomNumber;

  @Enumerated(EnumType.STRING)
  private RoomType type;

  private Double price;

  @Enumerated(EnumType.STRING)
  private RoomStatus status = RoomStatus.AVAILABLE;

  public Room() {
  }

  public Room(Long id, String roomNumber, RoomType type, Double price, RoomStatus status) {
    this.id = id;
    this.roomNumber = roomNumber;
    this.type = type;
    this.price = price;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
  }

  public RoomType getType() {
    return type;
  }

  public void setType(RoomType type) {
    this.type = type;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public RoomStatus getStatus() {
    return status;
  }

  public void setStatus(RoomStatus status) {
    this.status = status;
  }

  public enum RoomType {
    SINGLE,
    DOUBLE,
    SUITE
  }

  public enum RoomStatus {
    AVAILABLE,
    BOOKED,
    MAINTENANCE
  }

}
