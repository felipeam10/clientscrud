package com.felipe.clientscrud.dto;

import com.felipe.clientscrud.entities.Clients;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class ClientsDTO {

    private Long id;
    @Size(min = 3, max = 80, message = "Nome precisa ter de 03 a 80 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;
    @NotBlank(message = "Campo requerido")
    private String cpf;
    @Positive(message = "Renda deve ser positiva")
    private Double income;
    private LocalDate birthDate;
    @PositiveOrZero(message = "Quantidade de filhos zero ou mais")
    private Integer children;

    public ClientsDTO(){}

    public ClientsDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }
    public ClientsDTO(Clients entity) {
        id = entity.getId();
        name = entity.getName();
        cpf = entity.getCpf();
        income = entity.getIncome();
        birthDate = entity.getBirthDate();
        children = entity.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
