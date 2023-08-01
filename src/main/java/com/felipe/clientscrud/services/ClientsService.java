package com.felipe.clientscrud.services;

import com.felipe.clientscrud.dto.ClientsDTO;
import com.felipe.clientscrud.entities.Clients;
import com.felipe.clientscrud.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientsService {

    @Autowired
    private ClientsRepository repository;

    @Transactional(readOnly = true)
    public ClientsDTO findById(Long id) {
        Clients clients = repository.findById(id).get();
        return new ClientsDTO(clients);
    }
}
