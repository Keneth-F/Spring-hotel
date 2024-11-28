package com.keneth.hotel.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.keneth.hotel.models.Reservation;
import com.keneth.hotel.models.ReservationDTO;
import com.keneth.hotel.models.Room;
import com.keneth.hotel.models.Room.RoomStatus;
import com.keneth.hotel.services.ClientService;
import com.keneth.hotel.services.ReservationService;
import com.keneth.hotel.services.RoomService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
  private ReservationService reservationService;
  private RoomService roomService;
  private ClientService clientService;

  public ReservationController(ReservationService reservationService, RoomService roomService,
      ClientService clientService) {
    this.reservationService = reservationService;
    this.roomService = roomService;
    this.clientService = clientService;
  }

  @GetMapping
  public String findAll(Model model) {
    model.addAttribute("reservations", reservationService.findAll());
    model.addAttribute("reservation", new ReservationDTO());
    return "reservations/index";
  }

  @GetMapping("/add")
  public String create(Model model) {
    model.addAttribute("rooms", roomService.findByStatus(RoomStatus.AVAILABLE));
    model.addAttribute("clients", clientService.findAll());
    model.addAttribute("reservation", new ReservationDTO());
    return "reservations/form";
  }

  @PostMapping("/add")
  public String create(@Valid @ModelAttribute ReservationDTO reservation, BindingResult result, Model model) {
    // if (reservation.getId()==null) {
    // if
    // (roomService.findAvailableRoomsInPeriod(reservation.getStartDate(),reservation.getEndDate()).size()<1)
    // {
    // result.rejectValue("startDate", "500", "Ya ha sido reservada en este
    // periodo");
    // model.addAttribute("reservation", reservation);
    // return "reservation/form";
    // }
    // }
    reservationService.save(reservation);
    return "redirect:/reservation";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    reservationService.delete(id);
    return "redirect:/reservation";
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable Long id, Model model) {
    model.addAttribute("rooms", roomService.findAll());
    model.addAttribute("clients", clientService.findAll());
    model.addAttribute("reservations", reservationService.findAll());
    Optional<Reservation> reservation = reservationService.findById(id);
    if (reservation.isPresent()) {
      model.addAttribute("reservation", reservation.get().toDTO());
    }
    return "reservations/form";
  }

  @PostMapping("/check")
  @ResponseBody
  public List<Room> availables(
    @RequestParam("startDate") String startDate,
    @RequestParam("endDate") String endDate

  ) {
    var c = roomService.findAvailableRoomsInPeriod(LocalDateTime.parse(startDate) , LocalDateTime.parse(endDate));
    System.out.println(c.size());
    return c;

  }
}
