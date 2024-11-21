package com.keneth.hotel.data;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keneth.hotel.models.Client;
@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {
  List<Client> findByFirstNameContaining(String firstName);
  Page<Client> findByFirstNameContaining(String firstName, Pageable pageable);
}
