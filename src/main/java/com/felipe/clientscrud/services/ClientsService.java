package com.felipe.clientscrud.services;

import com.felipe.clientscrud.dto.ClientsDTO;
import com.felipe.clientscrud.entities.Clients;
import com.felipe.clientscrud.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Transactional(readOnly = true)
    public Page<ClientsDTO> findAll(Pageable pageable) {
        Page<Clients> result = repository.findAll(pageable);
        return result.map(x -> new ClientsDTO(x));
    }

    @Transactional
    public ClientsDTO insert(ClientsDTO dto) {
        Clients entity = new Clients();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ClientsDTO(entity);
    }

    @Transactional
    public ClientsDTO update(Long id, ClientsDTO dto) {
        Clients entity = repository.getReferenceById(id);
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ClientsDTO(entity);
    }

    private void copyDtoToEntity(ClientsDTO dto, Clients entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }
}
