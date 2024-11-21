package com.keneth.hotel.controllers;


import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keneth.hotel.models.Reservation;
import com.keneth.hotel.models.ReservationDTO;
import com.keneth.hotel.services.ClientService;
import com.keneth.hotel.services.ReservationService;
import com.keneth.hotel.services.RoomService;

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
    model.addAttribute("rooms", roomService.findAll());
    model.addAttribute("clients", clientService.findAll());
    model.addAttribute("reservation", new ReservationDTO());
    return "reservations/form";
  }

  @PostMapping("/add")
  public String create(@ModelAttribute ReservationDTO reservation) {
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
}
