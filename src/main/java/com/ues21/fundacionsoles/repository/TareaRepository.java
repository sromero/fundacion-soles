package com.ues21.fundacionsoles.repository;

import com.ues21.fundacionsoles.model.Tarea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends CrudRepository<Tarea, Long> {
    List<Tarea> findAllByVoluntarioId(Long userId);
}
