package com.felipe.clientscrud.repository;

import com.felipe.clientscrud.entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients, Long> {
}
