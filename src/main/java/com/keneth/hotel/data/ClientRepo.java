package com.keneth.hotel.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keneth.hotel.models.Client;
@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {
  //TODO client
}
