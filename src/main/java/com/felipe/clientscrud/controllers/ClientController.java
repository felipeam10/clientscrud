package com.felipe.clientscrud.controllers;

import com.felipe.clientscrud.dto.ClientsDTO;
import com.felipe.clientscrud.services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientsService service;
    @GetMapping(value = "/{id}")
    public ClientsDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public Page<ClientsDTO> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public ClientsDTO insert(@RequestBody ClientsDTO dto) {
        return service.insert(dto);
    }
}
