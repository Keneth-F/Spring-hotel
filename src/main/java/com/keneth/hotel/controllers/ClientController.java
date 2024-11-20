package com.keneth.hotel.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keneth.hotel.models.Client;
import com.keneth.hotel.services.ClientService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/client")
public class ClientController {
  private ClientService clientService;

  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @GetMapping
  public String findAll(Model model) {
    model.addAttribute("clients", clientService.findAll());
    model.addAttribute("client", new Client());// TODO DTO
    return "clients/index";
  }

  @GetMapping("/add")
  public String create(Model model) {
    model.addAttribute("client", new Client());// TODO DTO
    return "clients/form";
  }

  @PostMapping("/add")
  public String create(@Valid @ModelAttribute Client client, BindingResult result, Model model) {
    if (result.hasErrors() || true) {
      ObjectError error = new ObjectError("globalError", "error");
        result.addError(error);
			return "clients/form";
		}
    clientService.save(client);
    return "redirect:/client";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    clientService.delete(id);
    return "redirect:/clients";
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable Long id, Model model) {
    model.addAttribute("clients", clientService.findAll());
    Optional<Client> client = clientService.findById(id);
    if (client.isPresent()) {
      model.addAttribute("client", client.get());
    }
    return "clients/form";
  }
}
