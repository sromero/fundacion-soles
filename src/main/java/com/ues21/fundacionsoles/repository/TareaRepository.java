package com.ues21.fundacionsoles.repository;

import com.ues21.fundacionsoles.model.Tarea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends CrudRepository<Tarea, Long> {
}
