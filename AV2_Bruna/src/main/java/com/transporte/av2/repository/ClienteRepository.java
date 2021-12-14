package com.transporte.av2.repository;

import com.transporte.av2.models.Cliente;
import com.transporte.av2.models.Transporte;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, String>{
    Iterable<Cliente> findByTransporte(Transporte transporte);
    Cliente findByRg(String rg);
}
