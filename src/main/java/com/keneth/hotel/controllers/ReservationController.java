package com.keneth.hotel.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keneth.hotel.models.ReservationDTO;
import com.keneth.hotel.services.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
  private ReservationService reservationService;

  public ReservationController(ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  @GetMapping
  public String findAll(Model model) {
    model.addAttribute("reservations", reservationService.findAll());
    model.addAttribute("reservation", new ReservationDTO());// TODO DTO
    return "reservations/index";
  }

  @GetMapping("/add")
  public String create(Model model) {
    model.addAttribute("reservation", new ReservationDTO());// TODO DTO
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
    model.addAttribute("reservations", reservationService.findAll());
    // Optional<ReservationDTO> reservation = reservationService.findById(id);
    // if (reservation.isPresent()) {
    // model.addAttribute("reservation", reservation.get());
    // }
    return "reservations/form";
  }
}
