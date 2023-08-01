package com.felipe.clientscrud.controllers;

import com.felipe.clientscrud.dto.ClientsDTO;
import com.felipe.clientscrud.services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientsService service;
    @GetMapping(value = "/{id}")
    public ClientsDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
