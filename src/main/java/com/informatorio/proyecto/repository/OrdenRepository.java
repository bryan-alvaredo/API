package com.informatorio.proyecto.repository;

import com.informatorio.proyecto.entity.Orden;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends CrudRepository<Orden, Long> {

}
