package com.keneth.hotel.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keneth.hotel.models.Room;
import com.keneth.hotel.services.RoomService;

@Controller
@RequestMapping("/room")
public class RoomController {
  private RoomService roomService;

  public RoomController(RoomService roomService) {
    this.roomService = roomService;
  }

  @GetMapping
  public String findAll(Model model) {
    model.addAttribute("rooms", roomService.findAll());
    return "rooms/index";
  }

  @GetMapping("/add")
  public String create(Model model) {
    return "rooms/form";
  }

  @PostMapping("/add")
  public String create(@ModelAttribute Room room) {
    roomService.save(room);
    return "redirect:/room";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    roomService.delete(id);
    return "redirect:/rooms";
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable Long id, Model model) {
    model.addAttribute("rooms", roomService.findAll());
    Optional<Room> room = roomService.findById(id);
    if (room.isPresent()) {
      model.addAttribute("room", room.get());
    }
    return "rooms/form";
  }
}
