package com.ues21.fundacionsoles.repository;

import com.ues21.fundacionsoles.model.Estado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Long> {
}
