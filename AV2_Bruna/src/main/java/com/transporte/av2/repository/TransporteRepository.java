package com.transporte.av2.repository;
import com.transporte.av2.models.Transporte;

import org.springframework.data.repository.CrudRepository;

public interface TransporteRepository extends CrudRepository<Transporte, String>{
    Transporte findById(long id);
}
