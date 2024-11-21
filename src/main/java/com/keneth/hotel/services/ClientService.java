package com.keneth.hotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.keneth.hotel.data.ClientRepo;
import com.keneth.hotel.models.Client;

@Service
public class ClientService {
  private ClientRepo clientRepo;
  public ClientService(ClientRepo clientRepo) {
    this.clientRepo=clientRepo;
  }

  public Page<Client> findAll(Pageable pageable){
    return clientRepo.findAll(pageable);
  }
  public List<Client> findAll(){
    return clientRepo.findAll();
  }

  public Client save(Client phone){
    return clientRepo.save(phone);
  }

  public Optional<Client> findById(Long id){
    return clientRepo.findById(id);
  }
  public Page<Client> findByFirstName(String nombre, Pageable pageable) {
    return clientRepo.findByFirstNameContaining(nombre, pageable);
}
  public void delete(Long id){
    clientRepo.deleteById(id);
  }
}
