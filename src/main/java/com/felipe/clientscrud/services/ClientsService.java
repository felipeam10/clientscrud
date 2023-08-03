package com.felipe.clientscrud.services;

import com.felipe.clientscrud.dto.ClientsDTO;
import com.felipe.clientscrud.entities.Clients;
import com.felipe.clientscrud.repository.ClientsRepository;
import com.felipe.clientscrud.services.exceptions.DataBaseException;
import com.felipe.clientscrud.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientsService {

    @Autowired
    private ClientsRepository repository;

    @Transactional(readOnly = true)
    public ClientsDTO findById(Long id) {
        Clients clients = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
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
        try {
            Clients entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ClientsDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        repository.deleteById(id);
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(ClientsDTO dto, Clients entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }
}
